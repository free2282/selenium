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
public class ProfilePageMesto
{
    private WebDriver driver;
    // создай локатор для поля «Занятие» в профиле пользователя
    private By activity = By.id("owner-description");
    // создай локатор для кнопки «Сохранить» в профиле пользователя
    private By save = By.xpath(".//button[@type='submit']");

    public ProfilePageMesto (WebDriver driver){
        this.driver = driver;
    }

    // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра
    public void setNewActivity(String change)
    {
        Assert.assertTrue(driver.findElement(activity).isEnabled());
        driver.findElement(activity).clear();
        driver.findElement(activity).sendKeys(change);

    }

    // метод для нажатия на кнопку сохранения профиля
    public void saveActivityChange()
    {
        driver.findElement(save).click();
    }
}
