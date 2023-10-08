package org.praktikum.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final WebDriver webdriver;
    public Header(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    private final By constructorLink = By.xpath(".//nav/ul/li[1]/a");
    private final By logoLink = By.xpath(".//nav/div/a");
    private final By profileLink = By.xpath(".//p[text() = 'Личный Кабинет']");

    public void clickProfileLink() {
        webdriver.findElement(profileLink).click();
    }

    public void clickConstructorLinkLink() {
        webdriver.findElement(constructorLink).click();
    }

    public void clickLogoLink() {
        webdriver.findElement(logoLink).click();
    }
}
