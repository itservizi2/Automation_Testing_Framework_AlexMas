package stepdefinitions;

import cucumber.api.java.en.When;
import pageobjects.HomePage;
import utils.TestContext;

public class HomeSteps {
    private TestContext context;
    private HomePage homePage;

    public HomeSteps(TestContext testContext){
        context = testContext;
homePage = new HomePage(context.getWebDriverManager().getDriver4Web());
    }
    @When("^user clicks on registration button from navigation bar$")
    public void userClicksOnRegistrationButtonFromNavigationBar() {
      homePage.navigateToRegisterPageViaHeader();
    }

    @When("^Contact Us button from footer is clicked$")
    public void contactUsButtonFromFooterIsClicked() {
        homePage.clickOnContactUsBtn();
    }
}
