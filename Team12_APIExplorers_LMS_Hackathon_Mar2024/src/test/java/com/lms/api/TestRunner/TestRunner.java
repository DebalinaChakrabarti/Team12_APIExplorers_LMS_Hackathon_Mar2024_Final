package com.lms.api.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"pretty", "html:target/cucumber.html"},
				monochrome=true,
				features="src/test/resources/features/001UserLoginController.feature",
				glue= {"com.lms.api.StepDefinitions"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}

