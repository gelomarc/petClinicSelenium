package com.petClinic.pages;

import com.petClinic.blocks.*;
import com.petClinic.entities.Owner;
import com.petClinic.entities.Pet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.petClinic.utils.Utils.dateFormat;

public class FindOwnersPage extends BasePage {

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
        super(driver);
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

    public void fillInAddOwnerForm(Owner owner) {
        enterText(this.getAddOrEditOwnerForm().getFirstNameTextBox(), owner.getFirstName());
        enterText(this.getAddOrEditOwnerForm().getLastNameTextBox(), owner.getLastName());
        enterText(this.getAddOrEditOwnerForm().getAddressTextBox(), owner.getAddress());
        enterText(this.getAddOrEditOwnerForm().getCityTextBox(), owner.getCity());
        enterText(this.getAddOrEditOwnerForm().getTelephoneTextBox(), owner.getTelephone());
        click(this.getAddOrEditOwnerForm().getAddOrEditOwnerButton());
    }

    public void fillInAddPetForm(Pet pet) {
        enterText(this.getAddOrEditPetForm().getNameTextField(), pet.getName());
        enterText(this.getAddOrEditPetForm().getBirthDateTextField(), dateFormat(pet.getBirthDate()));
        selectSimilarOption(this.getAddOrEditPetForm().getPetTypeDropdown(), pet.getPetType().getPetType());
        click(this.getAddOrEditPetForm().getAddPetButton());
    }
}
