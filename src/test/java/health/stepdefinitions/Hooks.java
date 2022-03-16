package health.stepdefinitions;

import io.cucumber.java8.En;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks implements En {

    // TODO Keeping this static could cause memory issues when parallelizing tests.
    // Needs to be updated to pass into scenarios individually.
    public static WebDriver driver;

    public Hooks () {
        Before(() -> {
            String environment = System.getProperty("env", "local");

            WebDriverManager wdm = WebDriverManager.chromedriver();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--window-size=1440,900");

            if (environment.matches("ci|headless")) {
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
            }

            driver = wdm.capabilities(chromeOptions).create();
        });

        After(() -> {
            driver.quit();
        });
    }
}
