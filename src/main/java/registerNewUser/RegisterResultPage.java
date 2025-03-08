package registerNewUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterResultPage {
    private final WebDriver driver;

    @FindBy(className = "result")
    private WebElement resultMessage;

    @FindBy(className = "validation-summary-errors")
    private WebElement validationErrorMessage;

    public boolean registrationResult() {
        try {
            if (validationErrorMessage != null && validationErrorMessage.isDisplayed()) {
                return false; // Rejestracja nie powiodła się
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Jeśli element nie istnieje, zakłada się, że rejestracja jest sukcesem
        }

        // Sprawdzanie komunikatu o sukcesie rejestracji
        if (resultMessage != null && resultMessage.isDisplayed()) {
            return resultMessage.getText().contains("Your registration completed");
        }

        return false; // Jeśli nie znaleziono komunikatów
    }


    public RegisterResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
