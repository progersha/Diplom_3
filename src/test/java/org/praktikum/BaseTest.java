package org.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    WebDriver webdriver;

    protected final String url_main = "https://stellarburgers.nomoreparties.site";
    protected final String url_profile = "https://stellarburgers.nomoreparties.site/account";
    protected final String url_sign_up = "https://stellarburgers.nomoreparties.site/register";
    protected final String url_sign_in = "https://stellarburgers.nomoreparties.site/login";
    protected final String url_recovery_password = "https://stellarburgers.nomoreparties.site/forgot-password";


    protected final String name = "Name";
    protected final String email = "email1234567@mail.ru";
    protected final String password = "123456";

    public static WebDriver getWebDriver(String browser){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/org/praktikum/webdrivers/chromedriver");
                return new ChromeDriver(options);
            case "Yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/java/org/praktikum/webdriversyandexdriver");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Error: WebDriver not found");
        }
    }

    @Before
    public void startUp() {
        webdriver = getWebDriver("Chrome");
    }

    @After
    public void teardown() {
        webdriver.quit();
    }
}