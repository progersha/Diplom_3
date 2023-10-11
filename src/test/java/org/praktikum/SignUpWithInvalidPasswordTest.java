package org.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_objects.pages.SignUpPage;

public class SignUpWithInvalidPasswordTest extends BaseTest {

    @Before
    public void openSignUpPage() {
        webdriver.get(url_sign_up);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    public void shouldSeeErrorForInvalidPasswordTest() {
        SignUpPage signUpPage = new SignUpPage(webdriver);
        String invalid_password = "12345";
        signUpPage.fillSignUpForm(name, email, invalid_password);
        signUpPage.clickSignUpButton();

        Assert.assertEquals("Некорректный пароль", signUpPage.getErrorText());
    }
}
