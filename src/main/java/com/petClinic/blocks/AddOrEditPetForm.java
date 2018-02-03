package com.petClinic.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[@class = 'container xd-container']")
public class AddOrEditPetForm extends HtmlElement {

    @FindBy(xpath = ".//label[text() = 'Owner']/following::div[1]/span")
    private WebElement ownerLabel;

    @FindBy(id = "name")
    private WebElement nameTextField;

    @FindBy(xpath = ".//input[@id = 'name']/following-sibling::span[2][@class = 'help-inline']")
    private WebElement nameValidationMessage;

    @FindBy(id = "birthDate")
    private WebElement birthDateTextField;

    @FindBy(xpath = ".//input[@id = 'birthDate']/following-sibling::span[2][@class = 'help-inline']")
    private WebElement birthDateValidationMessage;

    @FindBy(id = "type")
    private WebElement petTypeDropdown;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement addPetButton;

    public WebElement getOwnerLabel() {
        return ownerLabel;
    }

    public WebElement getNameTextField() {
        return nameTextField;
    }

    public WebElement getBirthDateTextField() {
        return birthDateTextField;
    }

    public WebElement getPetTypeDropdown() {
        return petTypeDropdown;
    }

    public WebElement getAddPetButton() {
        return addPetButton;
    }

    public WebElement getNameValidationMessage() {
        return nameValidationMessage;
    }

    public WebElement getBirthDateValidationMessage() {
        return birthDateValidationMessage;
    }
}
