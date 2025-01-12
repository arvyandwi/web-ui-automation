package com.indra;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.indra"},
        features = {"src/test/resources"},
        plugin = {"pretty","html:reports/test-report-cucumber.html","json:reports/test-report-cucumber.json"}
)
public class CucumberTest {}

