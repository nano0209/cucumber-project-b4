package io.loop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    //private static WebDriver driver;
    //implement threadLocal to achieve multi thread local
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


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
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperties("browser");
            switch (browserType.toLowerCase()) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                    case "headless":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        driverPool.set(new ChromeDriver(chromeOptions));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;

            }

        }
        return driverPool.get();
    }

    /**
     * closing driver
     * @author Naima
     */

    public static void closeDriver() {

        if (driverPool.get() != null) {
            driverPool.get().quit();
           // driver = null;
            driverPool.remove();
        }


    }


}
