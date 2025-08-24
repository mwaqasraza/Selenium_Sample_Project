package com.digital.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/mawais/Documents/sample-project/Selenium_Sample_Project/src/test/resources/FeatureFiles", //Add your feature file path here
        glue = {"com/digital/ui/steps"}, //Add the step definition and runners package here
        plugin = {"pretty", "html:target/cucumber-html-report"},
        monochrome = true
)
public class TestRunner {
}