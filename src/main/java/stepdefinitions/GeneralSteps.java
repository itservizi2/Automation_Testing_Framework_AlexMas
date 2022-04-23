package stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.TestContext;

public class GeneralSteps {
    private TestContext context;

    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaUrl) throws Throwable {
        context.getWebDriverManager().getDriver4Web().get(adresaUrl);
    }
    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String keyWord) throws Throwable {
        boolean containsCorrectUrlEndpoint = context.getWebDriverManager().getDriver4Web().getCurrentUrl().contains(keyWord);
        Assertions.assertTrue(containsCorrectUrlEndpoint, "The actual URL does not contain the correct endpoint");
    }
}
