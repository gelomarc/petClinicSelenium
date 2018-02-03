package com.petClinic.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(id = "add-owner-form")
public class AddOrEditOwnerForm extends HtmlElement {

    @FindBy(id = "firstName")
    private WebElement firstNameTextBox;

    @FindBy(xpath = ".//input[@id = 'firstName']/following-sibling::span[2][@class = 'help-inline']")
    private WebElement firstNameValidationMessage;

    @FindBy(id = "lastName")
    private WebElement lastNameTextBox;

    @FindBy(xpath = ".//input[@id = 'lastName']/following-sibling::span[2][@class = 'help-inline']")
    private WebElement lastNameValidationMessage;

    @FindBy(id = "address")
    private WebElement addressTextBox;

    @FindBy(xpath = ".//input[@id = 'address']/following-sibling::span[2][@class = 'help-inline']")
    private WebElement addressValidationMessage;

    @FindBy(id = "city")
    private WebElement cityTextBox;

    @FindBy(xpath = ".//input[@id = 'city']/following-sibling::span[2][@class = 'help-inline']")
    private WebElement cityValidationMessage;

    @FindBy(id = "telephone")
    private WebElement telephoneTextBox;

    @FindBy(xpath = ".//input[@id = 'telephone']/following-sibling::span[2][@class = 'help-inline']")
    private WebElement telephoneValidationMessage;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement addOrEditOwnerButton;

    public WebElement getFirstNameTextBox() {
        return firstNameTextBox;
    }

    public WebElement getLastNameTextBox() {
        return lastNameTextBox;
    }

    public WebElement getAddressTextBox() {
        return addressTextBox;
    }

    public WebElement getCityTextBox() {
        return cityTextBox;
    }

    public WebElement getTelephoneTextBox() {
        return telephoneTextBox;
    }

    public WebElement getTelephoneValidationMessage() {
        return telephoneValidationMessage;
    }

    public WebElement getAddOrEditOwnerButton() {
        return addOrEditOwnerButton;
    }

    public WebElement getFirstNameValidationMessage() {
        return firstNameValidationMessage;
    }

    public WebElement getLastNameValidationMessage() {
        return lastNameValidationMessage;
    }

    public WebElement getAddressValidationMessage() {
        return addressValidationMessage;
    }

    public WebElement getCityValidationMessage() {
        return cityValidationMessage;
    }
}
