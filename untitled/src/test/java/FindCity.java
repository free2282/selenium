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
public class FindCity {
    private WebDriver driver;
    private final String cityName;
    private final boolean isVisible;

    public FindCity(String cityName, boolean isVisible) {
        this.cityName = cityName;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                { "Москва", true},
                { "Санкт-Петербург", true},
                {"Кейптаун", false}
        };
    }

    @Test
    public void citiesTest() {
        boolean actual = driver.findElements(By.xpath("//h2[text()='" + cityName + "']")).size() !=0;
        assertEquals(isVisible, actual);
    }
    @Before
    public void startUp()
    {
        String[] itemForLogIn = {"free2282@ya.ru", "Freein22820"};
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        driver.findElement(By.id("email")).sendKeys(itemForLogIn[0]);
        driver.findElement(By.id("password")).sendKeys(itemForLogIn[1]);
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
    }
    @After
    public void setDown()
    {
        driver.quit();
    }
}