package loggingIn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
    }

    @Test
    public void logInTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedInPage loggedInPage = new LoggedInPage(driver, wait);
        loginPage.logIn("student", "Password123");
        Assert.assertTrue(loggedInPage.logInCheck());
    }

    @After
    public void quit() {
        driver.quit();
    }

}
