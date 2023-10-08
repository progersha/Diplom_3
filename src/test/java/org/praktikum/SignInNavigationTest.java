package org.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.praktikum.page_objects.Header;
import org.praktikum.page_objects.pages.ConstructorPage;
import org.praktikum.page_objects.pages.RecoveryPasswordPage;
import org.praktikum.page_objects.pages.SignUpPage;

public class SignInNavigationTest extends BaseTest {

    @Test
    @DisplayName("Переход на страницу авторизации через кнопку «Войти в аккаунт» на главной")
    public void checkNavigationToSignInPageOnMainPageTest() {
        webdriver.get(url_main);
        ConstructorPage constructorPage = new ConstructorPage(webdriver);
        constructorPage.clickEnterButton();

        Assert.assertEquals(webdriver.getCurrentUrl(), url_sign_in);
    }

    @Test
    @DisplayName("Переход на страницу авторизации через кнопку «Личный кабинет» в заголовке")
    public void checkNavigationToSignInPageOnHeaderTest() {
        webdriver.get(url_main);
        Header header = new Header(webdriver);
        header.clickProfileLink();

        Assert.assertEquals(webdriver.getCurrentUrl(), url_sign_in);
    }

    @Test
    @DisplayName("Переход на страницу авторизации через кнопку в форме регистрации")
    public void checkNavigationToSignInPageOnSignUpPageTest() {
        webdriver.get(url_sign_up);
        SignUpPage signUpPage = new SignUpPage(webdriver);
        signUpPage.clickSignInLink();

        Assert.assertEquals(webdriver.getCurrentUrl(), url_sign_in);
    }

    @Test
    @DisplayName("Переход на страницу авторизации через кнопку восстановления пароля")
    public void checkNavigationToSignInPageOnRecoveryPasswordLinkTest() {
        webdriver.get(url_recovery_password);
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(webdriver);
        recoveryPasswordPage.clickSignInLink();

        Assert.assertEquals(webdriver.getCurrentUrl(), url_sign_in);
    }
}
