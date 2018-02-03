package com.petClinic.listItems;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = "//table[@id = 'vets']//tbody/tr")
public class VeterinarianListItem extends HtmlElement {

    @FindBy(xpath = "./td[1]")
    private WebElement nameLabel;

    @FindBy(xpath = "./td[2]/span")
    private List<WebElement> specialityLabels;

    public WebElement getNameLabel() {
        return nameLabel;
    }

    public List<WebElement> getSpecialityLabels() {
        return specialityLabels;
    }
}
