package com.petClinic.pages;

import com.petClinic.blocks.CommonStaticElements;
import com.petClinic.blocks.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPage extends BasePage {

    private Menu menu;

    private CommonStaticElements commonStaticElements;

    @FindBy(xpath = "//div[@class = 'container-fluid']//img")
    private WebElement petsImage;

    @FindBy(xpath = "//div[@class = 'container-fluid']//p")
    private WebElement errorMessage;

    public ErrorPage(WebDriver driver) {
        super(driver);
    }

    public Menu getMenu() {
        return menu;
    }

    public CommonStaticElements getCommonStaticElements() {
        return commonStaticElements;
    }

    public WebElement getPetsImage() {
        return petsImage;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
