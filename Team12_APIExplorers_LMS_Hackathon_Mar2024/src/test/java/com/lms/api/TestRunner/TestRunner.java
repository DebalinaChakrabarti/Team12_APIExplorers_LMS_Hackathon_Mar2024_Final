package com.lms.api.TestRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)


@CucumberOptions(features ={"./src/test/resources/features/"}, 
glue = {"api.StepDefinitions"}, 

monochrome = true, 
plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"html:target/Cucumber.html",
		"json:target/cucumber.json",
		"junit:target/JUNITReports/reports.xml"})

public class TestRunner {

}

