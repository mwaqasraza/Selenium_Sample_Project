package com.digital.ui.steps ;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.safeway.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RunCucumberTest {
}