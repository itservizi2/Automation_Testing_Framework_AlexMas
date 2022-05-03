package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class WebDriverManager {
    public WebDriverManager(String browserType) {
        this.browserType = browserType;
    }

    private WebDriver driver4Web;
    private String browserType;

    private void initializeDriver() {
        if (browserType.toUpperCase(Locale.ROOT).equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe ");
            driver4Web = new ChromeDriver();
        } else if (browserType.toUpperCase(Locale.ROOT).equals("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe ");
            driver4Web = new FirefoxDriver();
        } else {
            System.out.println("Such a browser has not been implemented");
        }
        driver4Web.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver4Web.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public WebDriver getDriver4Web() {
        if (driver4Web == null) {
            System.out.println("The browser is being initialized");
            initializeDriver();
        }
        return this.driver4Web;
    }
}
