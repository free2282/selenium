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
public class HomePageMesto
{
    private WebDriver driver;

    private By profileTitle = By.className("profile__title");
    // создай локатор для кнопки редактирования профиля
    private By editProfileButton = By.className("profile__edit-button");

    // создай локатор для поля «Занятие» в профиле пользователя
    private By activity = By.className("profile__description");

    public HomePageMesto(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания прогрузки данных профиля
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(profileTitle).getText() != null && !driver.findElement(profileTitle).getText().isEmpty()));
    }
    // метод для нажатия на кнопку редактирования профиля

    public void clickProfileEdit()
    {
        driver.findElement(editProfileButton).click();
    }

    public void waitForChangedActivity(String changed)
    {

        new WebDriverWait(driver, 4).until(ExpectedConditions.textToBePresentInElementLocated(activity, changed));

    }
}
