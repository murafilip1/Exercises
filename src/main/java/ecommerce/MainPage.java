package ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "field-keywords")
    WebElement searchField;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;
    @FindBy(xpath = "//h2[contains(@class, 'a-size-base-plus')]")
    List<WebElement> productTitles;

    public void searchItems() {
        searchField.click();
        searchField.clear();
        searchField.sendKeys("laptop");
        searchButton.click();

    }

    public boolean verifyProductsContainLaptop() {
        for (WebElement title : productTitles) {
            String text = title.getText().toLowerCase();
            if (text.contains("laptop")) {
                System.out.println("Znaleziono: " + text);
                return true;
            }
        }
        System.out.println("Żaden wynik nie zawiera słowa 'laptop'.");
        return false;

    }
}
