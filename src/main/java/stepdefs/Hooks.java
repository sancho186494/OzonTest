package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePage;


import static managers.InitManager.initFramework;

public class Hooks {
    @Before
    public void setUp() {
        initFramework();
    }

    @After
    public void tearDown() {
        BasePage.getCart().clear();
    }
}
