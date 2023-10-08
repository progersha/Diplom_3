package org.praktikum.page_objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {

    private final WebDriver webdriver;
    public ConstructorPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By bunsTub = By.xpath(".//section[1]/div[1]/div[1]");
    private final By saucesTab = By.xpath(".//section[1]/div[1]/div[2]");
    private final By fillingsTab= By.xpath(".//section[1]/div[1]/div[3]");
    private final By buns = By.xpath(".//div[not(contains(class,'tab_tab_type_current'))]/span[contains(text(),'Булки')]");
    private final By sauces = By.xpath(".//div[not(contains(class,'tab_tab_type_current'))]/span[contains(text(),'Соусы')]");
    private final By filings = By.xpath("//div[not(contains(class,'tab_tab_type_current'))]/span[contains(text(),'Начинки')]");
    private final By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By actionButton = By.xpath(".//section[2]/div/button");

    public void clickByBunsTab() {
        webdriver.findElement(buns).click();
    }

    public void clickBySousesTab() {
        webdriver.findElement(sauces).click();
    }

    public void clickByFillingsTab() {
        webdriver.findElement(filings).click();
    }

    public void clickEnterButton() {
        webdriver.findElement(enterButton).click();
    }

    public String getTextActionButton() {
        return new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(actionButton))
                .getText();
    }

    public boolean bunsIsDisplayed() {
        return webdriver.findElement(bunsTub).getAttribute("class").contains("tab_tab_type_current");
    }

    public boolean sousesIsDisplayed() {
        return webdriver.findElement(saucesTab).getAttribute("class").contains("tab_tab_type_current");
    }

    public boolean fillingsIsDisplayed() {
        return webdriver.findElement(fillingsTab).getAttribute("class").contains("tab_tab_type_current");
    }
}
