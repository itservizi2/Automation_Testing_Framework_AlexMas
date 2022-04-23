package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.TestContext;

public class Hooks {
private TestContext testContext;
public Hooks(TestContext context){
    testContext = context;
}
@Before
    public void setUpBeforeEachTest(){
    testContext.getWebDriverManager().getDriver4Web();
}
@After
    public void tearDownActionsAfterEachTest(){
    testContext.getWebDriverManager().getDriver4Web().close();
    testContext.getWebDriverManager().getDriver4Web().quit();
}

}
