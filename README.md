# bddMobileProject
A Katalon Studio project for BDD + Mobile testing

What is the purpose of the BDD Mobile Testing Project?

The BDD (Behavior-Driven-Development) Mobile Testing Project is designed to help troubleshoot and solve issues with Mobile devices and BDD projects in Katalon Studio 9.x. This project contains critical changes required for BDD projects that have been migrated from Katalon Studio 8.x to 9.x, as well as simple mobile tests to quickly ensure that mobile devices will work properly when used in Katalon Studio.

https://github.com/j-bartley/bddMobileProject 

BDD Implementation

The first problem-solving topic resolved by this project is for the BDD migration. This project contains two important Test Listeners that ensure default Cucumber packages, and custom packages, are included for use within the project. For example, in the sample code from the project below we can see that beforeTestCase2 contains a list of packages including one called “practice”. This package was added manually, and shows that if you have your own custom packages, they can be added here for usage:

import com.katalon.KatalonHelper
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.cucumber.keyword.internal.CucumberGlueGenerator
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

class TestListener {
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		KatalonHelper.updateInfo()
	}

	@BeforeTestCase
	def beforeTestCase(TestCaseContext context) {
		CucumberGlueGenerator.addDefaultPackages();
	}

	/**
	* Add the GLUE option for Cucumber to locate the step definition files.
	* @param testCaseContext related information of the executed test case.
	*/
	@BeforeTestCase
	def beforeTestCase2(TestCaseContext testCaseContext) {
		CucumberKW.GLUE = ['common', 'operations', 'practice']
	}
}

Mobile Implementation

In addition to the BDD migration code, the project also contains Mobile tests, both standard test cases and feature files to test integration between BDD and Mobile. This can also be utilized to see if iOS and Android set ups are working properly.

3.1. iOS Implementation

The iOS implementation launches the built-in Calendar application either on a simulator or a physical device, taps a single object, and closes the application. By running either of the following files with you desired device, you can quickly test to see if the iOS setup is working properly:

BDD

featureFileIOS.tc

MobileIOS.feature

Standard

mobileTestIOS.tc

3.2. Android Implementation

The Android implementation launches the built-in Google Chrome application either on a simulator or physical device, taps a single object, and closes the application. By running either of the following files with you desired device, you can quickly test to see if the iOS setup is working properly:

BDD

featureFileAndroid.tc

MobileAndroid.feature

Standard

mobildTestAndroid.tc