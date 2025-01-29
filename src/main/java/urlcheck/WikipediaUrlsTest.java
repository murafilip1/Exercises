package urlcheck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WikipediaUrlsTest {
    private static WebDriver driver;
    private static PrintWriter reportWriter;

    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");

        reportWriter = new PrintWriter(new FileWriter("test-report.txt", false));
        reportWriter.println("=== RAPORT TESTU LINKÓW ===");
        reportWriter.println("Strona testowana: https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        reportWriter.println();

    }

    @Test
    public void testAllLinks() {
        WikipediaMainPage wikipediaMainPage = new WikipediaMainPage(driver);
        List<WebElement> links = wikipediaMainPage.getAllLinks();
        System.out.println("Liczba znalezionych linków: " + links.size());
        reportWriter.println("Liczba znalezionych linków: " + links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url != null && !url.isEmpty()) {
                System.out.println("Sprawdzanie linku: " + url);
                reportWriter.println("Sprawdzanie linku: " + url);
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    System.out.println("Status HTTP: " + responseCode);
                    reportWriter.println("Status HTTP: " + responseCode);

                    if (responseCode >= 400) {
                        System.out.println("NIEPOPRAWNY LINK: " + url);
                        reportWriter.println("NIEPOPRAWNY LINK: " + url);
                    }
                } catch (IOException e) {
                    System.out.println("BŁĄD PODCZAS SPRAWDZANIA: " + url);
                    reportWriter.println("BŁĄD PODCZAS SPRAWDZANIA: " + url);
                }
                reportWriter.println();
            }
        }
    }

    @After
    public void quit() {
        driver.quit();
        reportWriter.close();
    }
}
