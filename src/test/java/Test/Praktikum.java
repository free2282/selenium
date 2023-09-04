package Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class Praktikum
{
    private WebDriver driver;

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome


        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        // выполни авторизацию
        objLoginPage.login("free2282@ya.ru", "Freein22820");

        // создай объект класса главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);

        // дождись загрузки данных профиля на главной странице
        objHomePage.waitForLoadProfileData();

        // кликни на кнопку редактирования профиля
        objHomePage.clickProfileEdit();



        // создай объект класса для поп-апа редактирования профиля
        ProfilePageMesto objProfilePage = new ProfilePageMesto(driver);

        // это переменная со значением, которое надо ввести в поле «Занятие»
        String newActivity = "Тестировщик";
        // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение

        objProfilePage.setNewActivity(newActivity);
        // сохрани изменения в профиле
        objProfilePage.saveActivityChange();


        objHomePage.waitForChangedActivity(newActivity);


    }
    @Before
    public void tearUp()
    {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
