import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AuthTest {
    private WebDriver driver;
    private final String email;
    private final String password;
    private final boolean expected;

    public AuthTest(String email, String password, boolean expected)
    {
        this.email = email;
        this.password = password;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                { "free2282@ya.ru","Freein22820", true},
                { "Free2282@ya.ru", "Freein2282", false},
                {"Free228@ya.ru", "Freein22820", false},
        };
    }
    @Test
    public void citiesTest() {
        boolean actual;
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("auth-form__button")).click();
        if (expected)
        {
            new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
        }
        assertEquals(expected, driver.findElements(By.cssSelector(".profile__image")).size() != 0);
    }
    @Before
    public void startUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

}