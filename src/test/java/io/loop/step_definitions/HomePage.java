package io.loop.step_definitions;

import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(xpath = "//h2[contains(text(), 'Received docs')]")
        public WebElement receivedDocs;
    }
