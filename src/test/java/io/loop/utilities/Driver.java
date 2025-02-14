package io.loop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


     /*
    creating private constructor so this class object is not reachable from outside
     */

    private Driver() {
    }

    /*
    making driver instance private
    Static - run before everything elso use in static method
     */

    private static WebDriver driver;


    /*
    reusable method that will return same driver instance everytime when called
     */

    /**
     * singleton patter
     *
     * @return driver
     * @author Naima
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperties("browser");
            switch (browserType.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    /**
     * closing driver
     * @author Naima
     */

    public static void closeDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }


    }


}
