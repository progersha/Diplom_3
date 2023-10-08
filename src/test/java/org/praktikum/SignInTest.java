package org.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.api.LoginUser;
import org.praktikum.api.RegisterUser;
import org.praktikum.api.User;
import org.praktikum.page_objects.pages.ConstructorPage;
import org.praktikum.page_objects.pages.SignInPage;

import static org.junit.Assert.assertEquals;

public class SignInTest extends BaseTest {

    User user = new User();

    @Before
    public void openSignInPage() {
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser();
        webdriver.get(url_sign_in);
    }

    @Test
    @DisplayName("Успешная авторизация")
    public void SignInSuccessfullyTest() {
        SignInPage signInPage = new SignInPage(webdriver);
        signInPage.fillSignInForm(email, password);
        signInPage.clickSignInButton();
        ConstructorPage constructorPage = new ConstructorPage(webdriver);

        assertEquals("Оформить заказ", constructorPage.getTextActionButton());
    }

    @After
    public void deleteUser() {
        new LoginUser(user).deleteUser();
    }
}
