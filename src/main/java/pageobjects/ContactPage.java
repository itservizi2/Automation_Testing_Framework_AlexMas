package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends Page {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private final String ENDPOINT = "/index.php?route=information/contact";

    @FindBy(xpath =".//strong[text()='Your Store']")
    private WebElement addressLabel;

    @FindBy(xpath =".//address")
    private WebElement addressValue;

    @FindBy(xpath =".//strong[text()='Telephone']")
    private WebElement phoneLabel;

    @FindBy(xpath ="//*[@id=\"content\"]/div/div/div/div[2]")
    private WebElement phoneValue;

    public ContactPage goToPage() {
        driver.get(BASE_URL + ENDPOINT);
        return this;
    }

    public String getENDPOINT() {
        return ENDPOINT;
    }
    public Boolean theMostImportantContactPageElementsAreDisplayed(){
        return addressLabel.isDisplayed() && addressValue.isDisplayed() && phoneLabel.isDisplayed() && phoneValue.isDisplayed();

    }
}
