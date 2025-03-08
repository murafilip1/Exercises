package registerNewUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(id = "gender-male")
    private WebElement genderMaleCheck;
    @FindBy(id = "gender-female")
    private WebElement genderFemaleCheck;
    @FindBy(id = "FirstName")
    private WebElement firstNameField;
    @FindBy(id = "LastName")
    private WebElement lastNameField;
    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;
    @FindBy(id = "register-button")
    private WebElement registerBtn;

    public void registerUser(String firstName, String lastName, String email, String password) {
        genderMaleCheck.click();
        firstNameField.click();
        firstNameField.sendKeys(firstName);
        lastNameField.click();
        lastNameField.sendKeys(lastName);
        emailField.click();
        emailField.sendKeys(email);
        passwordField.click();
        passwordField.sendKeys(password);
        confirmPasswordField.click();
        confirmPasswordField.sendKeys(password);
        registerBtn.click();
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
