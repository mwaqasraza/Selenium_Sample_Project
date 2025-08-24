package com.digital.ui.steps ;

import io.cucumber.testng.AbstractTestNGCucumberTests;
    import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/resources", // Path to your feature files
            glue = "com.nisum.stepdefinitions", // Package containing your step definitions
            plugin = {"pretty", "html:target/cucumber-report.html"}
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
    }