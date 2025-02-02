package loggingIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(className = "post-title")
    WebElement loggedInMessage;

    public boolean logInCheck() {
        wait.until(ExpectedConditions.visibilityOf(loggedInMessage));
        String message = loggedInMessage.getText();
        System.out.println("Logged in message: " + message);
        return loggedInMessage.getText().equalsIgnoreCase("Logged In Successfully");

    }

    public LoggedInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
