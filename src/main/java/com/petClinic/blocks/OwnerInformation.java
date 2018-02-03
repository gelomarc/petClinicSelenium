package com.petClinic.blocks;

import com.petClinic.listItems.PetListItem;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = "//div[@class = 'container xd-container']")
public class OwnerInformation extends HtmlElement {

    @FindBy(xpath = ".//th[text() = 'Name']/following-sibling::td/b")
    private WebElement nameLabel;

    @FindBy(xpath = ".//th[text() = 'Address']/following-sibling::td")
    private WebElement addressLabel;

    @FindBy(xpath = ".//th[text() = 'City']/following-sibling::td")
    private WebElement cityLabel;

    @FindBy(xpath = ".//th[text() = 'Telephone']/following-sibling::td")
    private WebElement telephoneLabel;

    @FindBy(xpath = ".//a[1]")
    private WebElement editOwnerButton;

    @FindBy(xpath = ".//a[2]")
    private WebElement addNewPetButton;

    private List<PetListItem> petListItems;

    public WebElement getNameLabel() {
        return nameLabel;
    }

    public WebElement getAddressLabel() {
        return addressLabel;
    }

    public WebElement getCityLabel() {
        return cityLabel;
    }

    public WebElement getTelephoneLabel() {
        return telephoneLabel;
    }

    public WebElement getEditOwnerButton() {
        return editOwnerButton;
    }

    public WebElement getAddNewPetButton() {
        return addNewPetButton;
    }

    public List<PetListItem> getPetListItems() {
        return petListItems;
    }
}