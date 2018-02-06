package com.petClinic.pages;

import com.petClinic.blocks.CommonStaticElements;
import com.petClinic.blocks.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private Menu menu;

    private CommonStaticElements commonStaticElements;

    @FindBy(xpath = "//div[@class = 'row']//img[@class = 'img-responsive']")
    private WebElement petsImage;

    public HomePage(WebDriver driver) {
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
}
