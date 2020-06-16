import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class BDDStepsDefinition {
	//******************************HYBRID APP******************************
	@Given("I am on Eroll screen and click on Enroll today button")
	def startAppValidateEnrollPage() {
		//Launch application
		Mobile.startApplication(GlobalVariable.G_AndroidApp, true)

		//Verify welcome message is displaying
		Mobile.verifyElementExist(findTestObject('doTERRA-HybridApp/Enroll - Page/lbl_Welcome to doTERRA'), GlobalVariable.G_Timeout_Long)
		String welcomeMessage = Mobile.getText(findTestObject('doTERRA-HybridApp/Enroll - Page/lbl_Welcome to doTERRA'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(welcomeMessage, 'Welcome to dōTERRA', false)

		//Verify Login button is displaying
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/btn_Login'), GlobalVariable.G_Timeout_Long)

		//Verify Enroll today button is displaying then click on it
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/btn_Enroll today'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/btn_Enroll today'), GlobalVariable.G_Timeout_Long)
	}

	@Given("I have selected my (.*) region")
	def selectRegion(String region) {
		//Verify Where will your product be shipped? text is displaying
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/lbl_Where will your products be shipped'), GlobalVariable.G_Timeout_Long)
		String regionText = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/lbl_Where will your products be shipped'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(regionText, 'Where will your products be shipped?', false)

		//Verify Region label is displaying
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/lbl_Region'), GlobalVariable.G_Timeout_Long)
		String regionLabel = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/lbl_Region'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(regionLabel, 'Region', false)

		//Verify Region dropdown is displaying and United States is selected option
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_United States'), GlobalVariable.G_Timeout_Long)
		String selectedRegion = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_United States'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(selectedRegion, 'United States', false)

		//Click on Region dropdown
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_United States'), GlobalVariable.G_Timeout_Long)

		//Verify scrolling is working, select Canada option and click on Done button
		Mobile.waitForElementPresent(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/Select Region - Dialog/lst_Region Picker'), GlobalVariable.G_Timeout_Long)
		Mobile.scrollToText(region)
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/Select Region - Dialog/btn_Done'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/Select Region - Dialog/btn_Done'), GlobalVariable.G_Timeout_Long)

		//Verify that Canada regions is now selected
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_Canada'), GlobalVariable.G_Timeout_Long)
		selectedRegion = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_Canada'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(selectedRegion, region, false)

		//Verify Language dropdown is displaying and English is selected option
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_English'), GlobalVariable.G_Timeout_Long)
		String selectedLanguage = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_English'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(selectedLanguage, 'English', false)

		//Verify Continue button is displaying then click on it
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/btn_Continue'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/btn_Continue'), GlobalVariable.G_Timeout_Long)
	}

	@When("I switch my warehouse and add individual product to my shopping bag")
	def switchWarehouseAddIndividualProduct() {
		//Verify Switch Warehouse button is displaying in upper nav
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Upper Nav/btn_Switch Warehouse'), GlobalVariable.G_Timeout_Long)

		//Click on Switch Warehouse button
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Upper Nav/btn_Switch Warehouse'), GlobalVariable.G_Timeout_Long)

		//Verify Switching Warehouse dialog is displaying then click on Continue button
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Switching Warehouse - Dialog/lbl_Switching Warehouse'), GlobalVariable.G_Timeout_Long)
		String lblSwitchingWarehouse = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Switching Warehouse - Dialog/lbl_Switching Warehouse'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(lblSwitchingWarehouse, 'Switching Warehouse', false)
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Switching Warehouse - Dialog/btn_Continue'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Switching Warehouse - Dialog/btn_Continue'), GlobalVariable.G_Timeout_Long)

		//Verify Bundle and Save label is displaying
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Bundle and Save - Page/lbl_Bundle and Save'), GlobalVariable.G_Timeout_Long)
		String lblBundleAndSave = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Bundle and Save - Page/lbl_Bundle and Save'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(lblBundleAndSave, 'Bundle and Save', false)

		//Click on Individual Products button
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Bundle and Save - Page/btn_Individual Products'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Bundle and Save - Page/btn_Individual Products'), GlobalVariable.G_Timeout_Long)

		//Verify Add Products label is displaying
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Add Products - Page/lbl_Add Products'), GlobalVariable.G_Timeout_Long)
		String lblAddProducts = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Add Products - Page/lbl_Add Products'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(lblAddProducts, 'Add Products', false)

		//Search and add Oregano essential oil
		Mobile.scrollToText('Single Oils')
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Add Products - Page/lnk_Single Oils'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Add Products - Page/lnk_Single Oils'), GlobalVariable.G_Timeout_Long)

		//Add Arborvitae oile and click Shopping Bag button
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Single Oils - Page/btn_Add Arborvitae'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Single Oils - Page/btn_Add Arborvitae'), GlobalVariable.G_Timeout_Long)
		Mobile.delay(GlobalVariable.G_Timeout_Short)
		Mobile.waitForElementPresent(findTestObject('Object Repository/doTERRA-HybridApp/Single Oils - Page/btn_Shopping Bag'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Single Oils - Page/btn_Shopping Bag'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Single Oils - Page/btn_Shopping Bag'), GlobalVariable.G_Timeout_Long)
	}

	@Then("I should see Shopping Bag screen with Product Guide and individual product")
	def validateShoppingBag() {
		//Verify that Shopping Bag label is displaying
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Shopping Bag'), GlobalVariable.G_Timeout_Long)
		String lblShoppingBag = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Shopping Bag'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(lblShoppingBag, 'Shopping Bag', false)

		//Verify Product Guide has been added
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Product Guide Enrollment feeSingle  Enrollment Fee'), GlobalVariable.G_Timeout_Long)
		String enrollmentGuide = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Product Guide Enrollment feeSingle  Enrollment Fee'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(enrollmentGuide, 'Product Guide Enrollment fee Single + Enrollment Fee', false)
		Mobile.scrollToText('Order Summary')

		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Arborvitae5 mL'), GlobalVariable.G_Timeout_Long)
		String individualProduct = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Arborvitae5 mL'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(individualProduct, 'Arborvitae 5 mL', false)
	}

	@When("I click on Proceed to Checkout button")
	def clickProceedToCheckoutButton() {
		//Click on Proceed to Checkout button
		Mobile.scrollToText('Proceed to Checkout')
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/btn_Proceed to Checkout'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/btn_Proceed to Checkout'), GlobalVariable.G_Timeout_Long)
	}

	@Then("I should see Account Setup screen")
	def verifyAccountSetupScreenDisplaying() {
		//Verify Account Setup label is displaying
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/lbl_Account Setup'), GlobalVariable.G_Timeout_Long)
		String lblAccountSetup = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/lbl_Account Setup'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(lblAccountSetup, 'Account Setup', false)
	}

	@Then("I should be able to enter my Personal Details")
	def enterPersonalDetails() {
		//Enter first name
		String firstName = CustomKeywords.'custom.keywords.getRandomString'(7)
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_First Name'), GlobalVariable.G_Timeout_Long)
		Mobile.setText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_First Name'), firstName, GlobalVariable.G_Timeout_Long)

		//Enter last name
		String lastName = CustomKeywords.'custom.keywords.getRandomString'(10)
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Last Name'), GlobalVariable.G_Timeout_Long)
		Mobile.setText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Last Name'), lastName, GlobalVariable.G_Timeout_Long)

		//Enter birthday
		String birthday = "12/01/1999"
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Birthday MMDDYYYY'), GlobalVariable.G_Timeout_Long)
		Mobile.setText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Birthday MMDDYYYY'), birthday, GlobalVariable.G_Timeout_Long)

		//Enter mobile phone
		Random random = new Random()
		int areaCode1 = random.nextInt(900) + 100
		int threeDigits1 = random.nextInt(900) + 100
		int fourDigits1 = random.nextInt(1000) + 1000
		String mobile = "(" + areaCode1 + ") " + threeDigits1 + "-" + fourDigits1
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Mobile Phone'), GlobalVariable.G_Timeout_Long)
		Mobile.setText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Mobile Phone'), mobile, GlobalVariable.G_Timeout_Long)

		//Enter home phone
		int areaCode2 = random.nextInt(900) + 100
		int threeDigits2 = random.nextInt(900) + 100
		int fourDigits2 = random.nextInt(1000) + 1000
		String home = "(" + areaCode2 + ") " + threeDigits2 + "-" + fourDigits2
		Mobile.scrollToText('Create Account')
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Home Phone'), GlobalVariable.G_Timeout_Long)
		Mobile.setText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Home Phone'), home, GlobalVariable.G_Timeout_Long)

		//Enter email
		String email = CustomKeywords.'custom.keywords.getRandomEmail'('auto', 'email.com')
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Email'), GlobalVariable.G_Timeout_Long)
		Mobile.setText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Email'), email, GlobalVariable.G_Timeout_Long)

		//Enter password
		String password = "Password123"
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Create a Password'), GlobalVariable.G_Timeout_Long)
		Mobile.setText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Create a Password'), password, GlobalVariable.G_Timeout_Long)

		//Click on Show link to reveal password
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/lnk_Show'), GlobalVariable.G_Timeout_Long)
		Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/lnk_Show'), GlobalVariable.G_Timeout_Long)

		//Verify password matching expected value
		Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Create a Password'), GlobalVariable.G_Timeout_Long)
		String actualPassword = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/txt_Create a Password'), GlobalVariable.G_Timeout_Long)
		Mobile.verifyMatch(actualPassword, password, false)
	}

	//******************************MOBILE APP******************************
	
	@Given("I successfully lanuched Mobile application")
	def launchMobileApp() {
		//Launch application
		CustomKeywords.'custom.keywords.startApplication'(GlobalVariable.G_AndroidApp, findTestObject('Object Repository/doTERRA-MobileApp/Already have an account - Dialog/btn_X'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort, true)
		
		//Close Already have an account dialog
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Already have an account - Dialog/btn_X'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Given("I am on the Shop page where I can browse all products")
	def validateShopPage() {
		//Verify Shop page displaying	
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/btn_Browse All Products'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/card_Single Oils'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/card_Blend Oils'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@When("I click on ACCOUNT icon and navigate to Login page")
	def clickAccountNavigateLoginPage() {
		//Click on Account icon in the bottom nav
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_ACCOUNT'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)

		//Click on I already have an account button
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Account - Page/lbl_I already have an account'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Then("I should see Login page with disabled Log in button")
	def validateLoginButtonDisabled() {
		//Validate that Log in button is disabled
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), 'class', 'android.widget.Button', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), 'enabled', 'false', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@When("I enter my user's (.*) and (.*)")
	def enterIDAndPassword(String id, String password) {
		//Enter ID		
		CustomKeywords.'custom.keywords.setText'(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your email or ID'), 'enabled', 'true', id, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)

		//Enter password		
		CustomKeywords.'custom.keywords.setText'(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your password'), 'enabled', 'true', password, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Then("I should see Log in button become enabled")
	def verifyLoginButtonEnabled() {
		//Verify that Log in button become enabled after entering ID and password		
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@When("I click on Log in button")
	def clickLoginButton() {
		//Click on Log in button		
		CustomKeywords.'custom.keywords.tap'(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Then("I should see User Account page")
	def validateUserAccountPage() {
		//Verify that User Account page is displaying
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_My Orders'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)	
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_Saved Products'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_My Details'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_US English Local'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_Notifications'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.scrollToText'('Privacy Policy', findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Privacy Policy'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Log out'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Privacy Policy'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Terms  Conditions'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@When("I click on My Details card")
	def clickMyDetailsCard() {
		//Click on My Details card
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_My Details'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Then("I should be able to validate authenticated user (.*) and (.*)")
	def validateAuthenticatedUserNameAndID(String fullName, String id) {
		//Verify user full name
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/My Details - Page/lbl_Lucas Pinto'), fullName, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)

		//Verify user doTERRA ID
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/My Details - Page/lbl_8111537'), id, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)

		//Click Back button in upper nav
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Upper Nav/btn_Back'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@When("I click on BAG icon")
	def clickBAGIcon() {
		//Click on BAG icon in the bottom nav
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_BAG'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Then("my shopping bag should be empty")
	def verifyShoppingBagEmpty() {
		//Verify that Bag is empty
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Bag - Page/lbl_Your bag is empty'), 'Your bag is empty', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@When("I click on Start Shopping button")
	def clickStartShoppingButton() {
		//Click on Start Shopping button
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Bag - Page/btn_Start Shopping'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Then("I should be able to see my user's (.*)")
	def validateUserRewardPoints(String rewardPoints) {
		//Validate that user have 700.00 rewards points
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_0.00'), rewardPoints, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@When("I navigate back to User Account page")
	def navigateToUserAccountPage() {
		//Click on ACCOUNT icon in bottom nav
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_ACCOUNT'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}

	@Then("I should be able to log out my user")
	def logOutUser() {
		//Log out user
		CustomKeywords.'custom.keywords.scrollToText'('Log out', findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Log out'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Log out'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)

		//Verify that user has successfully logged out
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Account - Page/lbl_I already have an account'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.closeApplication'()
	}
}