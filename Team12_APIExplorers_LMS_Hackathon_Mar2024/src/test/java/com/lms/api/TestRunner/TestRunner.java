package com.lms.api.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"pretty", 
				"html:target/Cucumber.html",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			//	"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"json:target/cucumber.json",
				"junit:target/JUNITReports/reports.xml"},
				monochrome=true,
				dryRun=!true,
				features="src/test/resources/features",
				glue= {"com.lms.api.StepDefinitions"}
				//tags="@tag"
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}

