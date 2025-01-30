package shopcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private final WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    WebElement gotoTCart;
    @FindBy(className = "cart_item")
    WebElement cartItem;

    public boolean isTheItemInCart() {
        gotoTCart.click();
        try {
            return cartItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
