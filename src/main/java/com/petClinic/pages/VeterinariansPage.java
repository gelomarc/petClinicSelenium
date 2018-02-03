package com.petClinic.pages;

import com.petClinic.blocks.CommonStaticElements;
import com.petClinic.blocks.Menu;
import com.petClinic.listItems.VeterinarianListItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

public class VeterinariansPage {

    private Menu menu;

    private CommonStaticElements commonStaticElements;

    private List<VeterinarianListItem> veterinarianListItems;

    @FindBy(xpath = "//table[@class = 'table-buttons']//a[text() = 'View as XML']")
    private WebElement viewAsXMLButton;

    @FindBy(xpath = "//table[@class = 'table-buttons']//a[text() = 'View as JSON']")
    private WebElement viewAsJSONButton;

    public VeterinariansPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public Menu getMenu() {
        return menu;
    }

    public CommonStaticElements getCommonStaticElements() {
        return commonStaticElements;
    }

    public List<VeterinarianListItem> getVeterinarianListItems() {
        return veterinarianListItems;
    }

    public WebElement getViewAsXMLButton() {
        return viewAsXMLButton;
    }

    public WebElement getViewAsJSONButton() {
        return viewAsJSONButton;
    }
}
