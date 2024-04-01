package com.lms.api.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				monochrome=true,
				features={"/Users/debalinachakrabarti/git/Team12_APIExplorers_LMS_Hackathon_Mar2024/Team12_APIExplorers_LMS_Hackathon_Mar2024/src/test/resources/features/001UserLogin.feature",
						"/Users/debalinachakrabarti/git/Team12_APIExplorers_LMS_Hackathon_Mar2024/Team12_APIExplorers_LMS_Hackathon_Mar2024/src/test/resources/features/005UserRoleProgrmBatchMap.feature"},
				glue= {"com.lms.api.StepDefinitions","com.lms.api.utilities.RestUtils"},
						plugin= {"pretty",
								"html:testngtarget/CucumberReports/CucumberReport.html",
								"json:testngtarget/CucumberReports/CucumberReport.json",
								"junit:testngtarget/CucumberReports/CucumberReport.xml",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
								
						}
		)


public class TestRunner  extends AbstractTestNGCucumberTests {
	
}