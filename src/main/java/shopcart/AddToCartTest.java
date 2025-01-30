package shopcart;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void addItemsToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.logIn("standard_user", "secret_sauce");
        productsPage.addToCart();
        Assert.assertTrue("Produkt nie został dodany do koszyka", cartPage.isTheItemInCart());
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}
