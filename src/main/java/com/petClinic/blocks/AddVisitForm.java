package com.petClinic.blocks;

import com.petClinic.listItems.VisitOnAddVisitFormListItem;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = "//div[@class = 'container xd-container']")
public class AddVisitForm extends HtmlElement {

    @FindBy(xpath = ".//table[@class = 'table table-striped'][1]//td[1]")
    private WebElement nameLabel;

    @FindBy(xpath = ".//table[@class = 'table table-striped'][1]//td[2]")
    private WebElement birthDateLabel;

    @FindBy(xpath = ".//table[@class = 'table table-striped'][1]//td[3]")
    private WebElement typeLabel;

    @FindBy(xpath = ".//table[@class = 'table table-striped'][1]//td[4]")
    private WebElement ownerLabel;

    @FindBy(id = "date")
    private WebElement visitDateTextField;

    @FindBy(id = "description")
    private WebElement descriptionTextField;

    @FindBy(xpath = ".//button[@class = 'submit']")
    private WebElement addVisitButton;

    private List<VisitOnAddVisitFormListItem> visitOnAddVisitFormListItems;

    public WebElement getNameLabel() {
        return nameLabel;
    }

    public WebElement getBirthDateLabel() {
        return birthDateLabel;
    }

    public WebElement getTypeLabel() {
        return typeLabel;
    }

    public WebElement getOwnerLabel() {
        return ownerLabel;
    }

    public WebElement getVisitDateTextField() {
        return visitDateTextField;
    }

    public WebElement getDescriptionTextField() {
        return descriptionTextField;
    }

    public WebElement getAddVisitButton() {
        return addVisitButton;
    }

    public List<VisitOnAddVisitFormListItem> getVisitOnAddVisitFormListItems() {
        return visitOnAddVisitFormListItems;
    }
}
