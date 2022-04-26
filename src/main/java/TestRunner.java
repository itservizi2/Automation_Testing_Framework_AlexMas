import managers.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager webDriverManager = new WebDriverManager("Chrome");
        webDriverManager.getDriver4Web().get("https://demo-opencart.com/");

        HomePage homePage = new HomePage(webDriverManager.getDriver4Web());
        homePage.navigateToRegisterPageViaHeader();


        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver4Web());
        registerPage.populateRegisterFormWithData("Tom", "Sawyer", "tom.s@gmail.com", "067123652", "Mypass123", "Mypass123");
        registerPage.clickContinueBtn();


        registerPage.performSearchFor("Apple");
        registerPage.clearSearchField();
        registerPage.performSearchFor("Samsung");

        webDriverManager.getDriver4Web().close();
        webDriverManager.getDriver4Web().quit();

    }
}
