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
public class LoginPageMesto
{
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.className("auth-form__button");

    public LoginPageMesto(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    public void login(String username, String password){

        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }
}
