package com.petClinic.listItems;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = "//td[@valign = 'top']/parent::tr")
public class PetListItem extends HtmlElement {

    @FindBy(xpath = ".//dl[@class = 'dl-horizontal']/dd[1]")
    private WebElement nameLabel;

    @FindBy(xpath = ".//dl[@class = 'dl-horizontal']/dd[2]")
    private WebElement birthDateLabel;

    @FindBy(xpath = ".//dl[@class = 'dl-horizontal']/dd[3]")
    private WebElement typeLabel;

    @FindBy(xpath = ".//a[text() = 'Edit\n" +
            "                  Pet']")
    private WebElement editPetButton;

    @FindBy(xpath = ".//a[text() = 'Add\n" +
            "                  Visit']")
    private WebElement addVisitButton;

    private List<VisitOnOwnerInformationListItem> visitLineItem;

    public WebElement getNameLabel() {
        return nameLabel;
    }

    public WebElement getBirthDateLabel() {
        return birthDateLabel;
    }

    public WebElement getTypeLabel() {
        return typeLabel;
    }

    public WebElement getEditPetButton() {
        return editPetButton;
    }

    public WebElement getAddVisitButton() {
        return addVisitButton;
    }

    public List<VisitOnOwnerInformationListItem> getVisitLineItem() {
        return visitLineItem;
    }
}
