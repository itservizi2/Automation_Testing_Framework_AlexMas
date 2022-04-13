import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager webDriverManager = new WebDriverManager("Chrome");
        webDriverManager.getDriver4Web().get("https://demo.opencart.com/");

        WebElement myAccountIcon = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
        myAccountIcon.click();
        Thread.sleep(2000);
        WebElement registerBtn = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        registerBtn.click();
        Thread.sleep(2000);
        // actiuni asupra paginii registration
        WebElement firstNameInputField = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        WebElement lastNameInputField = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        WebElement emailInputField = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"input-email\"]"));
        WebElement phoneInputField = webDriverManager.getDriver4Web().findElement(By.cssSelector("#input-telephone"));
        WebElement passwordInputField = webDriverManager.getDriver4Web().findElement(By.id("input-password"));
        WebElement confirmPasswordInputField = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"input-confirm\"]"));
        WebElement continueBtn = webDriverManager.getDriver4Web().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        firstNameInputField.sendKeys("Tom");
        lastNameInputField.sendKeys("Sawyer");
        emailInputField.sendKeys("tom.s@gmail.com");
        phoneInputField.sendKeys("067123652");
        passwordInputField.sendKeys("Mypass123");
        confirmPasswordInputField.sendKeys("Mypass111");
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys("Mypass123");

        continueBtn.click();
        Thread.sleep(5000);


        webDriverManager.getDriver4Web().close();
        webDriverManager.getDriver4Web().quit();

    }
}
