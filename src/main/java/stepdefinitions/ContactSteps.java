package stepdefinitions;

import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobjects.ContactPage;
import utils.TestContext;

public class ContactSteps {
    private TestContext context;
    private ContactPage contactPage;

    public ContactSteps(TestContext testContext) {
        context = testContext;
        contactPage = new ContactPage(context.getWebDriverManager().getDriver4Web());
    }

    @Then("^the most important contact details are displayed$")
    public void theMostImportantContactDetailsAreDisplayed() {
        boolean areDisplayed = contactPage.theMostImportantContactPageElementsAreDisplayed();
        Assertions.assertTrue(areDisplayed, "At least one of the most important details is not displayed");
    }

}
