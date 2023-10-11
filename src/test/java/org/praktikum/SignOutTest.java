package org.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.api.LoginUser;
import org.praktikum.api.RegisterUser;
import org.praktikum.api.User;
import org.praktikum.page_objects.pages.ProfilePage;
import org.praktikum.page_objects.pages.SignInPage;

import static org.junit.Assert.assertEquals;

public class SignOutTest extends BaseTest {

    User user = new User();

    SignInPage signInPage;

    @Before
    public void openAccountProfilePage() {
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser();
        webdriver.get(url_sign_in);
        signInPage = new SignInPage(webdriver);
        signInPage.fillSignInForm(email, password);
        signInPage.clickSignInButton();
        webdriver.get(url_profile);
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void SignOutSuccessfullyTest() {
        ProfilePage profilePage = new ProfilePage(webdriver);
        profilePage.exitButtonClick();

        assertEquals("Вход", signInPage.getHeaderText());
    }

    @After
    public void deleteUser() {
        new LoginUser(user).deleteUser();
    }
}
