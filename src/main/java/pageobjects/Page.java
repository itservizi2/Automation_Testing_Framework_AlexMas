package pageobjects;

import managers.PropertiesManager;
import managers.WebDriverWaiterManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Method;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/i")
    private WebElement myAccountIcon;

    @FindBy(xpath = " //*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"search\"]/input")
    private WebElement searchInputField;

    @FindBy(xpath = "//*[@id=\"search\"]/span/button ")
    private WebElement searchBtn;

    @FindBy(xpath = ".//a[text()='Contact Us']")
    private WebElement contactUsBtn;

    protected final String BASE_URL = PropertiesManager.getBaseUrl();

    public void navigateToRegisterPageViaHeader() {
        WebDriverWaiterManager.waitElementToBeVisible(myAccountIcon, driver);
        myAccountIcon.click();
        WebDriverWaiterManager.waitElementToBeVisible(registerBtn, driver);
        WebDriverWaiterManager.waitElementToBeClickable(registerBtn, driver);
        registerBtn.click();

    }

    public void performSearchFor(String valoareCautata) {
        searchInputField.sendKeys(valoareCautata);
        searchBtn.click();
    }

    public void clearSearchField() {
        searchInputField.clear();
    }

    public static void navigateToPage(String pageName, WebDriver webDriver) {
        Method defineMethod;
        try {
            defineMethod = Class.forName("pageobjects." + pageName).getMethod("goToPage");
            defineMethod.invoke(Class.forName("pageobjects." + pageName).getConstructor(WebDriver.class).newInstance(webDriver));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String pageContainsCorrectEndpoint(String pageName, WebDriver webDriver) {
        Method defineMethod;
        try {
            defineMethod = Class.forName("pageobjects." + pageName).getMethod("getENDPOINT");

            return (String) defineMethod.invoke(Class.forName("pageobjects." + pageName).getConstructor(WebDriver.class).newInstance(webDriver));

        } catch (Throwable e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Problems occurred during Endpoint extraction");
    }

    public void clickOnContactUsBtn() {
        WebDriverWaiterManager.waitElementToBeClickable(contactUsBtn, driver);
        contactUsBtn.click();
    }
}
