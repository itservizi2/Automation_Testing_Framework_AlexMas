import managers.WebDriverManager;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestJunitRunner {
    WebDriverManager webDriverManager = new WebDriverManager("Chrome");

    @BeforeEach
    public void configureTestPreconditions() {
        webDriverManager.getDriver4Web().get("https://demo-opencart.com/");
    }
    @AfterEach
    public void tearDownActivities() {
        webDriverManager.getDriver4Web().close();
        webDriverManager.getDriver4Web().quit();
    }
    @Test
    @DisplayName("The registration page can be accessed from navigation bar")
    public void registerPageIsOpened() {

        HomePage homePage = new HomePage(webDriverManager.getDriver4Web());
        homePage.navigateToRegisterPageViaHeader();

        boolean containsCorrectUrlEndpoint = webDriverManager.getDriver4Web().getCurrentUrl().contains("index.php?route=account/register");
        Assertions.assertTrue(containsCorrectUrlEndpoint, "The actual URL does not contain the correct endpoint");
    }

    @Test
    @DisplayName("Correct error message is displayed when trying to create a user without checking the privacy policy")

    public void anErrorMessageIsDisplayedWhenCreatingAnAccountWithoutAcceptingThePrivacyPolicy() {

        HomePage homePage = new HomePage(webDriverManager.getDriver4Web());
        homePage.navigateToRegisterPageViaHeader();

        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver4Web());
        registerPage.populateRegisterFormWithData("John", "Smith", "Jsmith@gmail.com", "069512345", "Qwerty123", "Qwerty123");
        registerPage.clickContinueBtn();

        WebElement errorMessageForLackOfPrivacy = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
        String expectedErrorText = "Warning: You must agree to the Privacy Policy!";
        String actualErrorText = errorMessageForLackOfPrivacy.getText();

        Assertions.assertEquals(expectedErrorText, actualErrorText, "The error message is not correct, please check the actual result");
    }
}
