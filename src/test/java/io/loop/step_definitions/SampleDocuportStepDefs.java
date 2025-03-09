package io.loop.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SampleDocuportStepDefs {

    LoginPage loginPage = new LoginPage();
    private static final Logger LOG = LogManager.getLogger();
    LeftNavigatePage leftNavigatePage = new LeftNavigatePage();
    ReceivedDocsPage receivedDocPage = new ReceivedDocsPage();

    @When("user inserts {string} to {string} field on {string} page")
    public void user_inserts_to_field_on_page(String input, String field, String page) {
        switch (page.toLowerCase().trim()){
            case "login":
                loginPage.insertField(field, input);
                LOG.info(input +"- was successfully send to - " + field);
                break;
                case "received docs":
                    receivedDocPage.insertField(field, input);
                    LOG.info(input +"- was successfully send to - " + field);
                    break;
                    default:

        }

    }

    @When("user clicks {string} button on {string} page")
    public void user_clicks_button_on_page(String button, String page) {
        switch (page.toLowerCase().trim()){
            case "login", "choose account":
                loginPage.clickButton(button);
                LOG.info(button + " - was successfully clicked");
                break;
            case "left navigate":
                leftNavigatePage.clickButton(button);
                LOG.info(button + " - was successfully clicked");
                break;
            case "received doc":
                receivedDocPage.clickButton(button);
                LOG.info(button + " - was successfully clicked");
                break;
            default: throw new IllegalArgumentException("not such a page: " + page);
        }
    }



}
