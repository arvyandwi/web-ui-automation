package com.indra.stepdef;

import com.indra.BaseTest;
import com.indra.page.HomePage;
import io.cucumber.java.en.Then;

public class HomeStepdef extends BaseTest {

    HomePage homePage;

    @Then("user is in homepage")
    public void userIsInHomepage() {
        homePage = new HomePage(driver);
        homePage.validateInHomepage();
    }
}
