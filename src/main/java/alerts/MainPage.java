package alerts;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertButton;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement jsPromptButton;
    @FindBy(id = "result")
    WebElement resultField;


    public void verifyJsAlert() {
        try {
            jsAlertButton.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            String result = resultField.getText();
            Assert.assertTrue(result.contains("You successfully clicked an alert"));
        } catch (Exception e) {
            Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
        }
    }

    public void verifyPromptAlert() {
        jsPromptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.accept();
        Assert.assertTrue(resultField.getText().contains("Test"));
    }

}
