package dropdown;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DropDownTest {

    private WebDriver driver;

    MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        mainPage = new MainPage(driver);

    }

    @Test
    public void dropDownMenuTest() {
        mainPage.isDropDownMenuDisplayed();
        mainPage.chooseOptionOneFromDropDownMenu();
        mainPage.chooseOptionTwoFromDropDownMenu();
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }


}
