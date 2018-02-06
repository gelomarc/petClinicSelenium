package com.petClinic.pages;

import com.petClinic.entities.Veterinary;
import com.petClinic.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import ru.yandex.qatools.htmlelements.matchers.decorators.TimeoutWaiter;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.exists;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class BasePage {

    private static final int DEFAULT_WAITING_TIMEOUT = 3;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    BasePage() {
    }

    WebDriver getDriver() {
        return driver;
    }

    public void getPage(String url) {
        driver.get(url);
    }

    public byte[] makeScreenshotAndAddFailingURLtoLogs() {
        System.out.println("Test failed on URL: " + driver.getCurrentUrl());
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void quit() {
        driver.quit();
    }

    public void shouldSee(WebElement element) {
        assertThat(element + " is not displayed", element, should(isDisplayed()).whileWaitingUntil(timeoutHasExpired(SECONDS.toMillis(DEFAULT_WAITING_TIMEOUT))));
    }

    public void click(WebElement element) {
        click(element, 3000);
    }

    public void click(WebElement element, int timeout) {
        shouldSee(element);
        waitForElementClickable(element, 30);
        int clickAttemptNr = 0;
        while (clickAttemptNr <= 20) {
            try {
                clickAttemptNr++;
                element.click();
                break;
            } catch (Exception e) {
                System.out.println("Tried to press clickable element: " + element + " but didn't work.");
            }
            sleep(timeout);
        }
    }

    void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void clickIfExists(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
        }
    }

    void elementExists(WebElement element) {
        assertThat(element + " is not displayed", element, should(exists()).whileWaitingUntil(TimeoutWaiter.timeoutHasExpired(SECONDS.toMillis(DEFAULT_WAITING_TIMEOUT))));
    }

    public void shouldBeSame(String text1, String text2) {
        assertEquals(text2, text1);
    }

    public void failTest(String message) {
        fail(message);
    }

    public void clearField(WebElement element) {
        click(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void shouldSeeText(WebElement element, String expectedText) {
        elementExists(element);
        assertThat("Element " + element + " has wrong text", getElementText(element), equalTo(expectedText));
    }

    public void waitForElementVisible(WebElement element, long timeoutInSeconds) {
        (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element, long timeoutInSeconds) {
        (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    String getElementText(WebElement element) {
        String text = element.getText();
        if (!"".equals(text)) {
            return Utils.clearString(text);
        } else {
            return Utils.clearString(element.getAttribute("innerHTML"));
        }
    }

    void enterText(WebElement element, String text) {
        shouldSee(element);
        element.clear();
        element.sendKeys(text);
    }

    public void shouldNotSee(WebElement element) {
        assertThat(element + " is displayed", element, should(not(isDisplayed())).whileWaitingUntil(TimeoutWaiter.timeoutHasExpired(10000)));
    }

    public void listShouldBeSize(List<?> list, int size) {
        assertThat("List is different size", list, hasSize(size));
    }

    String selectSimilarOption(WebElement element, String text) {
        element.click();
        try {
            element.findElement(By.xpath(".//*[contains(text(),'" + text + "')]")).click();
            return text;
        } catch (NoSuchElementException e) {
            fail(text + " not found");
            return text;
        }
    }

    public String mergeToOneStringMultipleString(List<String> list) {
        String mergedString = "";
        for (String singleString : list) {
            mergedString += singleString;
            if (!list.get(list.size() - 1).equals(singleString))
                mergedString += " ";
        }
        return mergedString;
    }

    public List<Veterinary> populateVeterinariansTable() {
        List<Veterinary> veterinaries = new ArrayList<>();

        Veterinary veterinary = new Veterinary("James Carter");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Helen Leary");
        veterinary.getSpecialities().add("radiology");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Linda Douglas");
        veterinary.getSpecialities().add("dentistry");
        veterinary.getSpecialities().add("surgery");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Rafael Ortega");
        veterinary.getSpecialities().add("surgery");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Henry Stevens");
        veterinary.getSpecialities().add("radiology");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Sharon Jenkins");
        veterinaries.add(veterinary);

        return veterinaries;
    }
}
