package com.petClinic.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[@class = 'container xd-container']")
public class CommonStaticElements extends HtmlElement {

    @FindBy(xpath = "./h2")
    private WebElement tittleMessageLabel;

    @FindBy(xpath = ".//img[@alt = 'Sponsored by Pivotal']")
    private WebElement springImage;

    public WebElement getTittleMessageLabel() {
        return tittleMessageLabel;
    }

    public WebElement getSpringImage() {
        return springImage;
    }
}
