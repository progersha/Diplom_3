package org.praktikum.page_objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver webdriver;
    public ProfilePage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By profileLink = By.xpath(".//a[text()='Профиль']");
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    private final By profileNotificationText = By.xpath(".//nav/p");


    public void profileLinkClick() {
        webdriver.findElement(profileLink).click();
    }

    public void exitButtonClick() {
        new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton)).click();
    }

    public String getProfileNotificationText() {
        return new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(profileNotificationText))
                .getText();
    }
}
