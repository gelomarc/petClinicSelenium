package com.petClinic.pages;

import com.petClinic.blocks.CommonStaticElements;
import com.petClinic.blocks.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class HomePage {

    private Menu menu;

    private CommonStaticElements commonStaticElements;

    @FindBy(xpath = "//div[@class = 'row']//img[@class = 'img-responsive']")
    private WebElement petsImage;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
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
