package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInputField;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInputField;

    @FindBy(css = "#input-telephone")
    private WebElement phoneInputField;

    @FindBy(id = "input-password")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@id=\"input-confirm\"]")
    private WebElement confirmPasswordInputField;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    private WebElement privacyCheckBox;

    @FindBy(xpath = "//div[@class=\"text-danger\"]")
    private WebElement errorMessage;

    private final String ENDPOINT = "/index.php?route=account/register";

    public RegisterPage goToPage() {
        driver.get(BASE_URL + ENDPOINT);
        return this;
    }

    public void populateRegisterFormWithData(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        emailInputField.sendKeys(email);
        phoneInputField.sendKeys(phone);
        passwordInputField.sendKeys(password);
        confirmPasswordInputField.sendKeys(confirmPassword);
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void clickCheckBox() {
        privacyCheckBox.click();
    }

    public String getTheErrorMessageText() {
        return errorMessage.getText();
    }
    public String getENDPOINT(){
        return ENDPOINT;
    }
}
