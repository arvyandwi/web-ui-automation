package com.indra.stepdef;

import com.indra.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseTest {

    @Before
    public void beforeTest() {
        getDriver();
    }

    @After
    public void afterTest() {
        driver.close();
    }
}
