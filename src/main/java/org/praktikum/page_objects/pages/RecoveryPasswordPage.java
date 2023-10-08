package org.praktikum.page_objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {

    private final WebDriver webdriver;
    public RecoveryPasswordPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By signInLink = By.xpath(".//a[text()='Войти']");

    public void clickSignInLink() {webdriver.findElement(signInLink).click();}
}
