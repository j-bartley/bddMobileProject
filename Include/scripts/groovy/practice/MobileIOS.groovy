package practice
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as M

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then

class MobileIOS {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Open the mobile app")
	def Open_the_mobile_app() {
		M.startExistingApplication("com.apple.mobilecal")
	}

	@When("I wait")
	def I_wait() {
		M.delay(10)
	}

	@Then("I close the mobile app")
	def I_close_the__mobile_app(){
		M.closeApplication()
	}
}