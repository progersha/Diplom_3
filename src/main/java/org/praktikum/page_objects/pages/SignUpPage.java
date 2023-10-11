package org.praktikum.page_objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    private final WebDriver webdriver;
    public SignUpPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By nameInput = By.xpath(".//fieldset[1]//input");
    private final By emailInput = By.xpath(".//fieldset[2]//input");
    private final By passwordInput = By.name("Пароль");
    private final By errorPassword = By.xpath(".//div[@id='root']//fieldset[3]/div/p");
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By signInLink = By.xpath(".//a[text()='Войти']");

    public void fillSignUpForm(String name, String email, String password) {
        webdriver.findElement(nameInput).sendKeys(name);
        webdriver.findElement(emailInput).sendKeys(email);
        webdriver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignUpButton() {
        webdriver.findElement(signUpButton).click();
    }

    public void clickSignInLink() {webdriver.findElement(signInLink).click();}

    public String getErrorText() {
        return new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorPassword))
                .getText();
    }
}
