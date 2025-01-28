package urlcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WikipediaMainPage {
    private final WebDriver driver;

    public WikipediaMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getAllLinks() {
        return driver.findElements(By.tagName("a"));
    }

}
