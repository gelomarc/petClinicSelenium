package com.petClinic.listItems;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//table[@class = 'table-condensed']/tbody/tr")
public class VisitOnOwnerInformationListItem extends HtmlElement {

    @FindBy(xpath = "./td[1]")
    private WebElement visitDateLabel;

    @FindBy(xpath = "./td[2]")
    private WebElement descriptionLabel;

    public WebElement getVisitDateLabel() {
        return visitDateLabel;
    }

    public WebElement getDescriptionLabel() {
        return descriptionLabel;
    }
}
