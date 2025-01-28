package alerts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertsTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void checkJsAlert() {
        MainPage mainPage = new MainPage(driver);
        mainPage.verifyJsAlert();
    }

    @Test
    public void checkPromptAlert() {
        MainPage mainPage = new MainPage(driver);
        mainPage.verifyPromptAlert();
    }


    @After
    public void quit() {
        driver.quit();
    }

}
