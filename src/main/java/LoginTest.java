import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @After
    public void quit(){
        driver.quit();
    }

    @Test
    public void testLoggingIn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue("Alert should be displayed", loginPage.isSuccessAlertDisplayed());
        Assert.assertTrue(loginPage.getSuccessAlertText().contains("You logged into a secure area!"));
    }

}
