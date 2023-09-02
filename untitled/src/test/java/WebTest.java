import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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

public class WebTest
{
    private WebDriver driver;




    @Test
    public void clickButtonEnter()
    {

        driver.findElement(By.xpath(".//button[@class='auth-form__button']")).click();
    }
    @Test
    public void searchElement()
    {
        driver.findElement(By.xpath(".//h3[@class='auth-form__title']"));
    }
    @Test
    public void logInCheckExit()
    {
        driver.findElement(By.xpath(".//button[@class='header__logout']"));
        String exit = driver.findElement(By.xpath(".//button[@class='header__logout']")).getText();
        System.out.println(exit);
    }
    @Test
    public void logInCheckFooter()
    {

        driver.findElement(By.className("footer__copyright"));
        WebElement element = driver.findElement(By.className("footer__copyright"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        String footer = driver.findElement(By.className("footer__copyright")).getText();
        System.out.println(footer);
    }
    @Test
    public void checkPhotoChange()
    {
        String url = "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png";
        driver.findElement(By.cssSelector(".profile__image")).click();
        driver.findElement(By.id("owner-avatar")).sendKeys(url);
        driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();

    }


    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        String mail = "free2282@ya.ru";
        String password = "Freein22820";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//input[@id='email']")).sendKeys(mail);
        driver.findElement(By.xpath(".//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath(".//button[@class='auth-form__button']")).click();
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}
