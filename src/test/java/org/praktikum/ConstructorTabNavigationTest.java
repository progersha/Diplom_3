package org.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_objects.pages.ConstructorPage;

public class ConstructorTabNavigationTest extends BaseTest {

    @Before
    public void openConstructorPage(){
        webdriver.get(url_main);
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void checkNavigationToBunsTest() {
        ConstructorPage constructorPage = new ConstructorPage(webdriver);
        constructorPage.clickBySousesTab();
        constructorPage.clickByBunsTab();
        Assert.assertTrue(constructorPage.bunsIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void checkNavigationToSaucesTest() {
        ConstructorPage constructorPage = new ConstructorPage(webdriver);
        constructorPage.clickBySousesTab();

        Assert.assertTrue(constructorPage.sousesIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void checkNavigationToFillingsTest() {
        ConstructorPage constructorPage = new ConstructorPage(webdriver);
        constructorPage.clickByFillingsTab();

        Assert.assertTrue(constructorPage.fillingsIsDisplayed());
    }
}
