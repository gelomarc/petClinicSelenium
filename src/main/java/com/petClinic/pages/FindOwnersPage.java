package com.petClinic.pages;

import com.petClinic.blocks.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class FindOwnersPage {

    private Menu menu;

    private CommonStaticElements commonStaticElements;

    @FindBy(id = "lastName")
    private WebElement lastElementTextBox;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement findOwnerButton;

    @FindBy(xpath = "//a[text() = 'Add Owner']")
    private WebElement addOwnerButton;

    private AddOrEditOwnerForm addOrEditOwnerForm;

    private AddOrEditPetForm addOrEditPetForm;

    private OwnerInformation ownerInformation;

    public FindOwnersPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public Menu getMenu() {
        return menu;
    }

    public CommonStaticElements getCommonStaticElements() {
        return commonStaticElements;
    }

    public WebElement getLastElementTextBox() {
        return lastElementTextBox;
    }

    public WebElement getFindOwnerButton() {
        return findOwnerButton;
    }

    public WebElement getAddOwnerButton() {
        return addOwnerButton;
    }

    public AddOrEditOwnerForm getAddOrEditOwnerForm() {
        return addOrEditOwnerForm;
    }

    public AddOrEditPetForm getAddOrEditPetForm() {
        return addOrEditPetForm;
    }

    public OwnerInformation getOwnerInformation() {
        return ownerInformation;
    }
}
