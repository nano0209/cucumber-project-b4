package io.loop.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.loop.utilities.Driver;

public class Hook {

    @Before
    public void setUp() {
        Driver.getDriver();

    }
    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
