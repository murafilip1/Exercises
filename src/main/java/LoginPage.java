import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(className = "radius")
    WebElement loginButton;
    @FindBy(className = "success")
    WebElement successMsg;

    public void logIn(String username, String password){
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isSuccessAlertDisplayed(){
        return successMsg.isDisplayed();
    }

    public String getSuccessAlertText(){
        return successMsg.getText();
    }




}
