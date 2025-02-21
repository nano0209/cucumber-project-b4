package io.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;


public class BrowserUtils {

    public static Scenario myScenario;

    /**
     * takes screenshot
     * @author nsh
     */
    public static void takeScreenshot(){
        try{
            myScenario.log("Current url is: " +Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException wbd) {
            wbd.getMessage();
        } catch (ClassCastException cce) {
            cce.getMessage();
        }

    }

    /**
     * validate if driver switched to expected url or title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Naima
     * implements assertion
     * note; usually we do not do validation in metjhod this is for practicing purposes
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

        //after stopping on expected url, validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));


    }

    /*

     */

    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
            }
            driver.switchTo().window(origin);
        }

        /**
         * click any link from loop practice
         * @param nameOfPage
         * @author naima
         */

        public static void LoopLinkClick(String nameOfPage){
            WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }

    /**
     * methodfor providing element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author Naima
     */

    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @author nsh
     */
    public static void waitForInvisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


/**
 * method for the providing element to be visible
 * @param element
 * @param timeToWaitSec
 * return
 * @author Naima
 */
public static WebElement waitForVisibility(WebElement element, int timeToWaitSec){
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitSec));
    return wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     * @author nsh
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    }
