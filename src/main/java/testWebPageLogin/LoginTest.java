package testWebPageLogin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickSubmit();

        Assert.assertTrue("Nie udało się poprawnie zalogowac", loginPage.isLoginSuccessful());
        System.out.println("Udało się poprawnie zalogować");

    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}
