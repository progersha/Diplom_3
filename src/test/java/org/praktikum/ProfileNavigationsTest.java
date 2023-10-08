package org.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.praktikum.api.LoginUser;
import org.praktikum.api.RegisterUser;
import org.praktikum.api.User;
import org.praktikum.page_objects.Header;
import org.praktikum.page_objects.pages.ProfilePage;
import org.praktikum.page_objects.pages.ConstructorPage;
import org.praktikum.page_objects.pages.SignInPage;

import static org.junit.Assert.assertEquals;

public class ProfileNavigationsTest extends BaseTest {

    User user = new User();

    SignInPage signInPage;

    @Before
    public void getUser() {
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser();
        webdriver.get(url_sign_in);
        signInPage = new SignInPage(webdriver);
        signInPage.fillSignInForm(email, password);
        signInPage.clickSignInButton();
    }

    @Test
    @DisplayName("Переход в Личный кабинет")
    public void NavigationToProfilePageTest() {
        webdriver.get(url_main);
        Header header = new Header(webdriver);
        header.clickProfileLink();
        ProfilePage profilePage = new ProfilePage(webdriver);

        assertEquals("В этом разделе вы можете изменить свои персональные данные", profilePage.getProfileNotificationText());
    }

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор по кнопке")
    public void NavigationToConstructorPageByButtonTest() {
        webdriver.get(url_profile);
        Header header = new Header(webdriver);
        header.clickConstructorLinkLink();
        ConstructorPage constructorPage = new ConstructorPage(webdriver);

        assertEquals("Оформить заказ", constructorPage.getTextActionButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор по лого")
    public void NavigationToConstructorPageByLogoTest() {
        webdriver.get(url_profile);
        Header header = new Header(webdriver);
        header.clickLogoLink();
        ConstructorPage constructorPage = new ConstructorPage(webdriver);

        assertEquals("Оформить заказ", constructorPage.getTextActionButton());
    }

    @After
    public void deleteUser() {
        new LoginUser(user).deleteUser();
    }
}
