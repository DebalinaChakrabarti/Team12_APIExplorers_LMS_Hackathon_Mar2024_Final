package com.lms.api.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				monochrome=true,
				features={"src\\test\\resources\\features\\001_UserLogin.feature",
						"src\\test\\resources\\features\\002PrgramModule.feature",
						"src\\test\\resources\\features\\004UserModule.feature",
				"src\\test\\resources\\features\\005UserRoleProgrmBatchMap.feature"
						},
				//dryRun=false,tags="@EndToEnd",
				glue= {"com.lms.api.StepDefinitions","com.lms.api.utilities.RestUtils"},
						plugin= {"pretty",
								"html:testngtarget/CucumberReports/CucumberReport.html",
								"json:testngtarget/CucumberReports/CucumberReport.json",
								"junit:testngtarget/CucumberReports/CucumberReport.xml",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
								
						}
		)


public class TestRunner extends AbstractTestNGCucumberTests{

}
