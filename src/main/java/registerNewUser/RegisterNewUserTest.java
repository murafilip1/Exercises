package registerNewUser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RegisterNewUserTest {
    private WebDriver driver;

    String email = "testuser" + UUID.randomUUID().toString() + "@mail.com";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://demowebshop.tricentis.com/register");
    }

    @Test
    public void registerUser() {
        MainPage mainPage = new MainPage(driver);
        RegisterResultPage registerResultPage = new RegisterResultPage(driver);
        mainPage.registerUser("Test", "User", email, "Test1234!");
        Assert.assertTrue("Rejestracja nie powiodła się", registerResultPage.registrationResult());
    }


    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }


}
