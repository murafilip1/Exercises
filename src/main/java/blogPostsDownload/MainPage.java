package blogPostsDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private final WebDriver driver;


    public List<WebElement> getAllPostTitles() {
        return driver.findElements(By.tagName("h2"));
    }


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
