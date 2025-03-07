package blogPostsDownload;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DownloadPostTitlesTest {

    private static WebDriver driver;
    private static PrintWriter reportWriter;
    private static ChromeOptions options;

    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        options = new ChromeOptions();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.zyte.com/blog/");

        reportWriter = new PrintWriter(new FileWriter("Post-title-download-test-report.txt", false));
        reportWriter.println("=== RAPORT TESTU POBIERANIA TYTUŁÓW POSTÓW ===");
        reportWriter.println("Strona testowana: https://www.zyte.com/blog/");
        reportWriter.println();

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("user-data-dir=C:\\Users\\m_fil\\AppData\\Local\\Google\\Chrome\\User Data"); // Używa zapisanych ustawień cookies

    }

    @Test
    public void downloadPostTitles(){
        MainPage mainPage = new MainPage(driver);
        List<WebElement> postTitles = mainPage.getAllPostTitles();
        for (int i = 0; i < postTitles.size(); i++) {
            String title = postTitles.get(i).getText();
            System.out.println((i + 1) + ". "+title);
            reportWriter.println((i + 1) + ". "+title);
        }

    }

    @After
    public void quit() {
        driver.quit();
        reportWriter.close();
    }


}
