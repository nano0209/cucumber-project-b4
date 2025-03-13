package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.HomePage;
import io.loop.pages.LoginPage;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    private static final Logger LOG = LogManager.getLogger();



    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBeta"));
        LOG.info("user is on docuport login page");
        BrowserUtils.takeScreenshot();

    }
    @When("user enters username for client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        assertTrue("Page was not load", loginPage.loginButton.isDisplayed());
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);


    }
    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_All);

    }
    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();

    }
    @Then("user should be able to see the home page for client")
    public void user_should_be_able_to_see_the_home_page_for_client() {
        assertTrue(BrowserUtils.waitForVisibility(homePage.receivedDocs, 10).isDisplayed());
        LOG.info("Home page is successfully loaded");


    }


    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);

    }
    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_All);

    }
    @Then("user should be able to see the home page for employee")
    public void user_should_be_able_to_see_the_home_page_for_employee() {
        loginPage.homePage.isDisplayed();

    }


    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);


    }
    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_All);

    }
    @Then("user should be able to see the home page for advisor")
    public void user_should_be_able_to_see_the_home_page_for_advisor() {
        loginPage.homePage.isDisplayed();

    }


    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);

    }
    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_All);

    }
    @Then("user should be able to see the home page for supervisor")
    public void user_should_be_able_to_see_the_home_page_for_supervisor() {
        loginPage.homePage.isDisplayed();

    }

    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String > credentials) {
//        for (Map.Entry<String, String> entry : credentials.entrySet()) {
//            String key = entry.getKey();
//            System.out.println("key = " + key);
//
//            String value = entry.getValue();
//            System.out.println("value = " + value);
//
//            System.out.println("==========================");
//        }

        loginPage.login2(credentials.get("username"), credentials.get("password"));

    }


}
