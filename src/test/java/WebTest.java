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

    @Test
    public void addContent()
    {
        //String[]
        driver.findElement(By.className("profile__add-button")).click();
        String[] authData = {"Прага", "https://code.s3.yandex.net/qa-automation-engineer/java/files/new_photo_selenium.jpg"};
        driver.findElement(By.name("name")).sendKeys(authData[0]);
        driver.findElement(By.name("link")).sendKeys(authData[1]);
        driver.findElement(By.xpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")));
        driver.findElement(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();

    }
    @Test
    public void checkContent()
    {
        WebElement element = driver.findElement(By.cssSelector(".places__item"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }



    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        String[] authData = {"free2282@ya.ru", "Freein22820"};
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//input[@id='email']")).sendKeys(authData[0]);
        driver.findElement(By.xpath(".//input[@id='password']")).sendKeys(authData[1]);
        driver.findElement(By.xpath(".//button[@class='auth-form__button']")).click();
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}
