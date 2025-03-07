package testWebPageLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "submit")
    private WebElement submitBtn;
    @FindBy(className = "post-title")
    private WebElement successMessage;


    public void enterUsername(String username) {
        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public boolean isLoginSuccessful() {
        return successMessage.getText().contains("Logged In Successfully");
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
