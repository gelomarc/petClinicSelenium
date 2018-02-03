package com.petClinic.steps;

import com.petClinic.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.matchers.decorators.TimeoutWaiter;

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

public class WebDriverSteps {

    private static final int DEFAULT_WAITING_TIMEOUT = 3;

    private WebDriver driver;

    public WebDriverSteps(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverSteps() {
    }

    public WebDriver getDriver() {
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

    public void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickIfExists(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
        }
    }

    public void elementExists(WebElement element) {
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

    public String getElementText(WebElement element) {
        String text = element.getText();
        if (!"".equals(text)) {
            return Utils.clearString(text);
        } else {
            return Utils.clearString(element.getAttribute("innerHTML"));
        }
    }

    public void enterText(WebElement element, String text) {
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

    public String selectSimilarOption(WebElement element, String text) {
        element.click();
        try {
            element.findElement(By.xpath(".//*[contains(text(),'" + text + "')]")).click();
            return text;
        } catch (NoSuchElementException e) {
            fail(text + " not found");
            return text;
        }
    }
}
