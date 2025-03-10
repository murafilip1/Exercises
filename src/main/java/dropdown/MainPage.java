package dropdown;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    private final WebDriver driver;

    @FindBy(id = "dropdown")
    private WebElement dropDownMenu;

    public void isDropDownMenuDisplayed() {
        Assert.assertTrue("Dropdown menu is not visible", dropDownMenu.isDisplayed());
        System.out.println("Dropdown menu is visible");
    }

    public void chooseOptionOneFromDropDownMenu() {
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Option 1");
        Assert.assertEquals("Option 1", select.getFirstSelectedOption().getText());
    }

    public void chooseOptionTwoFromDropDownMenu() {
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Option 2");
        Assert.assertEquals("Option 2", select.getFirstSelectedOption().getText());
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
