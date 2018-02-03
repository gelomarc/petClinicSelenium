package com.petClinic.listItems;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = "//table[@id = 'vets']//tbody/tr")
public class OwnerListItem extends HtmlElement {

    @FindBy(xpath = "./td[1]")
    private WebElement nameLabel;

    @FindBy(xpath = "./td[2]")
    private WebElement addressLabel;

    @FindBy(xpath = "./td[3]")
    private WebElement cityLabel;

    @FindBy(xpath = "./td[4]")
    private WebElement telephoneLabel;

    @FindBy(xpath = "./td[5]/span")
    private List<WebElement> petLabels;

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

    public List<WebElement> getPetLabels() {
        return petLabels;
    }
}
