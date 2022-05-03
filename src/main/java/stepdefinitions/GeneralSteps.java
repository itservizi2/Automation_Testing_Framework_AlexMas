package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobjects.Page;
import utils.TestContext;

public class GeneralSteps {
    private TestContext context;

    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }

    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String keyWord) {
        boolean containsCorrectUrlEndpoint = context.getWebDriverManager().getDriver4Web().getCurrentUrl().contains(keyWord);

        Assertions.assertTrue(containsCorrectUrlEndpoint, "the keyword is not present in the url");
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String pageName) {
        Page.navigateToPage(pageName, context.getWebDriverManager().getDriver4Web());
    }

    @Then("^Correct \"([^\"]*)\" endpoint is displayed$")
    public void correctEndpointIsDisplayed(String pageName) {
        String expectedUrlEndpoint = Page.pageContainsCorrectEndpoint(pageName, context.getWebDriverManager().getDriver4Web());
        String valoareaActualaEndpoint = context.getWebDriverManager().getDriver4Web().getCurrentUrl();
        Assertions.assertTrue(valoareaActualaEndpoint.contains(expectedUrlEndpoint), " The ENDPOINT defined in the " +
                " pageObject of " + pageName + " page is not present in the current URL: " + valoareaActualaEndpoint);

    }
}
