package com.petClinic.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//nav[@role = 'navigation']")
public class Menu extends HtmlElement {

    @FindBy(xpath = ".//button//span[@class = 'sr-only']")
    private WebElement toggleNavigationButton;

    @FindBy(xpath = ".//li/a[@title = 'home page']")
    private WebElement homeButton;

    @FindBy(xpath = ".//li/a[@title = 'find owners']")
    private WebElement findOwnersButton;

    @FindBy(xpath = ".//li/a[@title = 'veterinarians']")
    private WebElement veterinariansButton;

    @FindBy(xpath = ".//li/a[@title = 'trigger a RuntimeException to see how it is handled']")
    private WebElement errorButton;

    public WebElement getToggleNavigationButton() {
        return toggleNavigationButton;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getFindOwnersButton() {
        return findOwnersButton;
    }

    public WebElement getVeterinariansButton() {
        return veterinariansButton;
    }

    public WebElement getErrorButton() {
        return errorButton;
    }
}
