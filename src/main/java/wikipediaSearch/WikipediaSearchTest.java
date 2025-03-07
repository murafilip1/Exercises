package wikipediaSearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WikipediaSearchTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");

    }

    @Test
    public void searchKeyword(){
        MainPage mainPage = new MainPage(driver);
        mainPage.searchForKeyword("Selenium");
    }

    @After
    public void quit() {
        driver.quit();
    }
}
