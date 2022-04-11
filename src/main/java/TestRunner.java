import managers.WebDriverManager;

public class TestRunner {
    public static void main(String[] args) {

        WebDriverManager DriverManagerFirefox = new WebDriverManager("firefox");
        DriverManagerFirefox.getDriver4Web().get("https://www.mozilla.org/en-US/firefox/new/");
        DriverManagerFirefox.getDriver4Web().close();


        WebDriverManager webDriverManager = new WebDriverManager("Chrome");
        webDriverManager.getDriver4Web().get("https://www.google.com/chrome/");
        webDriverManager.getDriver4Web().close();

    }
}
