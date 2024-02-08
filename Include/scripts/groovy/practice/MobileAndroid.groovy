package practice
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as M

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then

class MobileAndroid {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Open the mobile app android")
	def Open_the_mobile_app_android() {
		M.startExistingApplication("com.android.chrome")
	}

	@When("I wait android")
	def I_wait_android() {
		M.delay(10)
	}

	@Then("I close the mobile app android")
	def I_close_the__mobile_app_android(){
		M.closeApplication()
	}
}