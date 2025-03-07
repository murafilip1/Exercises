package wikipediaSearch;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(id = "searchInput")
    private WebElement searchBar;
    @FindBy(className = "pure-button")
    private WebElement searchBtn;
    @FindBy(tagName = "h1")
    private WebElement mainHeader;

    public void searchForKeyword(String keyword) {
        searchBar.click();
        searchBar.sendKeys(keyword);
        searchBtn.click();
        Assert.assertTrue("Nagłówek nie zawiera słowa kluczowego", mainHeader.getText().contains(keyword));
        System.out.println("Test zaliczony");
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
