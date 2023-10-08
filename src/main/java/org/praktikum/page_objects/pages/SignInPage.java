package org.praktikum.page_objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    private final WebDriver webdriver;
    public SignInPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By header = By.xpath(".//h2");
    private final By emailInput = By.xpath(".//fieldset[1]//input");
    private final By passwordInput = By.name("Пароль");
    private final By signInButton = By.xpath(".//button[text()='Войти']");

    public void fillSignInForm(String email, String password) {
        webdriver.findElement(emailInput).sendKeys(email);
        webdriver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignInButton() {
        webdriver.findElement(signInButton).click();
        new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(signInButton));
    }

    public String getHeaderText() {
        new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("login"));
        return webdriver.findElement(header).getText();
    }
}
