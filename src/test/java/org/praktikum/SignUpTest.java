package org.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.api.LoginUser;
import org.praktikum.api.User;
import org.praktikum.page_objects.pages.SignInPage;
import org.praktikum.page_objects.pages.SignUpPage;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest {

    User user = new User();

    @Before
    public void openSignUpPage() {
        webdriver.get(url_sign_up);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void SignUpSuccessfullyTest() {
        SignUpPage signUpPage = new SignUpPage(webdriver);
        signUpPage.fillSignUpForm(name, email, password);
        signUpPage.clickSignUpButton();
        SignInPage signInPage = new SignInPage(webdriver);

        assertEquals("Вход", signInPage.getHeaderText());
    }

    @After
    public void deleteUser() {
        new LoginUser(user).deleteUser();
    }
}
