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
import org.junit.After
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.detroitlabs.katalonmobileutil.touch.Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import com.detroitlabs.katalonmobileutil.device.App
import com.detroitlabs.katalonmobileutil.device.Device
import com.detroitlabs.katalonmobileutil.testobject.Finder
import com.detroitlabs.katalonmobileutil.testobject.TestObjectType
import com.detroitlabs.katalonmobileutil.testobject.TestObjectConverter
import io.appium.java_client.android.AndroidElement
import com.detroitlabs.katalonmobileutil.touch.Scroll
import com.detroitlabs.katalonmobileutil.touch.Scroll.ScrollFactor

import java.net.MalformedURLException
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit
import org.openqa.selenium.Dimension
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.MobileDriver
import io.appium.java_client.remote.MobileCapabilityType
import java.lang.Object
import io.appium.java_client.touch.offset.PointOption
import io.appium.java_client.touch.WaitOptions
import groovy.time.TimeCategory



class BDDStepsDefinition {
	//******************************HYBRID APP******************************
	@Given("I am on Eroll screen and click on Enroll today button")
	def startAppValidateEnrollPage() {
		//Launch application
		CustomKeywords.'custom.keywords.startApplication'(GlobalVariable.G_AndroidApp, findTestObject('Object Repository/doTERRA-MobileApp/Already have an account - Dialog/btn_X'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort, true)

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
		
		//Get mobile operating system
		String getMobileOS = Device.getDeviceOS()
		System.out.println("getMobileOS: " + getMobileOS)
		
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
		CustomKeywords.'custom.keywords.scrollToText'('Privacy Policy', findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Privacy Policy'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_Notifications'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
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
	
	//******************************Process Now - Edit LRP******************************
	
	@Given("I have successfully authenticated my (.*) with (.*) and (.*)")
	def authenticateUser(String userName, String id, String password) {
		//Click on ACCOUNT icon
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_ACCOUNT'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Click on I already have an account button
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Account - Page/lbl_I already have an account'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Log in button is disabled
		this.validateLoginButtonDisabled()
		
		//Enter ID
		CustomKeywords.'custom.keywords.setText'(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your email or ID'), 'enabled', 'true', id, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Log in button is disabled
		this.validateLoginButtonDisabled()
		
		//Enter password
		CustomKeywords.'custom.keywords.setEncryptedText'(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your password'), 'enabled', 'true', password, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Log in button becomes enabled
		this.verifyLoginButtonEnabled()
		
		
		//Click on Log in button
		this.clickLoginButton()
		
		//Verify right user was authenticated
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lbl_Lucas'), userName, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@When("I click on SHOP icon")
	def clickShopScrollToOrder() {
		//Click on SHOP icon
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_SHOP'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Shop page is displaying
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_My Loyalty Rewards'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Your percentage back'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@When("I edit my Scheduled Loyalty Order and click on Save and Process Now button")
	def verifySheduledLoyaltyOrder() {
		//Scroll to Scheduled Loyalty Order then click on edit
		CustomKeywords.'custom.keywords.swipeDown'(1)
		
		//Get PV and Order Total values
		String pv = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_PV 45.0'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		pv = pv.minus(".0")
		def pvValue = pv.toInteger()
		
		String total = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Total 16700'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		total = total.minus("¥")
		total = total.minus(",")		
		def totalValue = total.toInteger()
		
		//Edit order and swipe down
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit Scheduled Loyalty Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.swipeDown'(4)
		
		//Get PV value and compare it to the value before edit
		String pv2 = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Order Summary PV Earned'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		pv2 = pv2.minus(".00")
		def pvValue2 = pv2.toInteger()
		CustomKeywords.'custom.keywords.verifyNumbersAreEqual'(pvValue2, pvValue)
		
		//Get Order Total value and compare it to the value before edit
		String total2 = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Order Summary Total'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		total2 = total2.minus("¥")
		total2 = total2.minus(",")
		def totalValue2 = total2.toInteger()
		CustomKeywords.'custom.keywords.verifyNumbersAreEqual'(totalValue2, totalValue)
		
		//Click on Save and Process Now button
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/btn_Save and Process Now'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should see Loyalty Order Confirmation screen")
	def verifyOrderConfirmationScreen() {
		//Verify Loyalty Order Confirmation screen is displaying
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Confirmation - Page/lbl_Your Loyalty Order is Now Setup'), 'Your Loyalty Order is Now Setup!', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.closeApplication'()
	}
	
	//******************************Process on a Later Date - Edit LRP******************************
	
	@When("I edit my Scheduled Loyalty Order and click on Save and Process on later date button")
	def verifySheduledLoyaltyOrderOnLaterDate() {
		//Scroll to Scheduled Loyalty Order then click on edit
		CustomKeywords.'custom.keywords.scrollToText'('Scheduled Loyalty Orders')
		
		//Get PV and Order Total values
		String pv = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_PV 45.0'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		pv = pv.minus(".0")
		def pvValue = pv.toInteger()
		
		String total = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Total 16700'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		total = total.minus("¥")
		total = total.minus(",")
		def totalValue = total.toInteger()
		
		//Edit order and swipe down
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit Scheduled Loyalty Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.swipeDown'(4)
		
		//Get PV value and compare it to the value before edit
		String pv2 = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Order Summary PV Earned'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		pv2 = pv2.minus(".00")
		def pvValue2 = pv2.toInteger()
		CustomKeywords.'custom.keywords.verifyNumbersAreEqual'(pvValue2, pvValue)
		
		//Get Order Total value and compare it to the value before edit
		String total2 = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Order Summary Total'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		total2 = total2.minus("¥")
		total2 = total2.minus(",")
		def totalValue2 = total2.toInteger()
		CustomKeywords.'custom.keywords.verifyNumbersAreEqual'(totalValue2, totalValue)
		
		//Click on Save and Process On button
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/btn_Save and Process on'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	//******************************Edit LRP - Add Remove Product - Process on a Later Date******************************
	
	@When("I edit my Scheduled Loyalty Order and add (.*) product")
	def verifySheduledLoyaltyOrdersAddProduct(String product) {
		//Scroll to Scheduled Loyalty Order then click on edit		
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.1, 3)
		
		//Edit order
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit Loyalty Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Tap search bar
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Name PV or Item number'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Search for a OnGuard product
		CustomKeywords.'custom.keywords.setText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/txt_Name or Item number'), 'enabled', 'true', product, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Get and verify product name
		String productName = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard  Softgels'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard  Softgels'), 'OnGuard + Softgels', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Get product price
		String productPrice = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard Price'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		System.out.println('productPrice: ' + productPrice)
		
		//Get product PV
		String productPV = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard PV'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		System.out.println('productPV: ' + productPV)
		
		//Tap to add product
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/icn_Add to Bag'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify that Edit Loyalty Order page is displaying
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Add Additional Products'), 'text', 'Add Additional Products', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	
		//Verify product name
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.15, 3)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_OnGuard Softgels'), 'text', 'OnGuard + Softgels', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify product price
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_OnGuard Price'), productPrice, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify product PV
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_OnGuard PV'), productPV, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)	
		
		//Verify product quantity
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Order3 Quantity'), '1', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@When("I click on Save and Process on button")
	def clickOnSaveAndProcessOnButton() {
		//Swipe down and click on Save and Process on button
		CustomKeywords.'custom.keywords.multiScroll'(3, 0.7, 0.1, 1)
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/btn_Save and Process on'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should see Order Confirmation screen")
	def verifyOrderConfirmationScreenWithoutClosingApp() {
		//Verify order confirmation screen
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Confirmation - Page/lbl_Your Loyalty Order is Now Setup'), 'Your Loyalty Order is Now Setup!', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@When("I click on Back to Home button")
	def clickBackToHomeButton() {
		//Click on Back to Home button
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Confirmation - Page/btn_Back to Home'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should see Scheduled Loyalty Order with added product")
	def verifyScheduledLoyaltyOrderHaveAddedProduct() {		
		//Verify PV point total with added product
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_PV Amount'), '73.0', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify order total with added product
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Total Amount'), '¥20,824', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify order date
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Scheduled Loyalty Order Date'), 'Aug 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@When("I edit my Scheduled Loyalty Order and and change added product quantity to zero")
	def eidtLoyaltyOrderAndChangeProductQuantityToZero() {
		//Edit Scheduled Loyalty Order
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit Scheduled Loyalty Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Your Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Scroll down to the OnGuard + Softgels item than click on quantity arrow button
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.15, 3)
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/img_OnGuard Softgels Arrow'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Tap on number picker object to get dialog in focus
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Select Quantity - Dialog/obj_NumberPicker'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)	
		
		//Change quantity to zero and click on Done button
		CustomKeywords.'custom.keywords.selectQuantity'(0, findTestObject('Object Repository/doTERRA-MobileApp/Select Quantity - Dialog/opt_Quantity Selected'))
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Select Quantity - Dialog/btn_Done'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Scroll down and click on Save and Process On button
		this.clickOnSaveAndProcessOnButton()
	}
	
	@Then("I should see added product being removed from Scheduled Loyalty Order")
	def verifyAddedProductHasBeenRemoved() {
		//Click on Back to Home button
		this.clickBackToHomeButton()
		
		//Verify PV point total without added product
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_PV Amount'), '45.0', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify order date
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Scheduled Loyalty Order Date'), 'Aug 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Edit Scheduled Loyalty Order
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit Scheduled Loyalty Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Your Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Scroll down and verify that added order no longer exist
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.15, 3)
		CustomKeywords.'custom.keywords.verifyElementDontExist'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_OnGuard Softgels'), GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.closeApplication'()
	}
	
	//******************************Create and Delete LRP******************************
	
	@When("I click on SHOP icon and scroll to LRP section")
	def clickShopIconEditLRP() {
		//Click on SHOP icon
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_SHOP'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Shop page is displaying
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_My Loyalty Rewards'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Your percentage back'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Scroll to Scheduled Loyalty Order then click on edit
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.1, 3)
	}
	
	@Then("I should be able to create new LRP and add (.*)")
	def createNewLRPAddProduct(String product) {
		//Click on Scheduled Loyalty Orders label
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_Scheduled Loyalty Orders'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Click on Name, PV or Item number text field
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Name PV or Item number'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Search for a OnGuard product
		CustomKeywords.'custom.keywords.setText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/txt_Name or Item number'), 'enabled', 'true', product, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Get and verify product name
		String productName = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard  Softgels'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard  Softgels'), product, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Get product price
		String productPrice = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard Price'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Get product PV
		String productPV = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/lbl_OnGuard PV'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Tap to add product
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Loyalty Order Search Product - Page/icn_Add to Bag'), 'clickable', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify product name
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Your Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.multiScroll'(1, 0.5, 0.2, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_OnGuard  Softgels'), productName, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify product price
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Product Price'), productPrice, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify product PV
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Product PV'), productPV, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should be able to select processing date and verify (.*), (.*), and delivery address")
	def selectProcessDate(String phone, String email) {
		//Scroll down and select Processing Date
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.18, 3)
		CustomKeywords.'custom.keywords.selectProcessingDate'(10, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Scroll down and verify phone number
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.15, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Phone Number'), 'Phone Number', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Phone Number'), phone, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify primary email
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Primary Email'), 'Primary Email', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Primary Email'), email, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify delivery address
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Delivery Address'), 'Delivery Address', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		String deliveryAddress = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Delivery Address'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		assert deliveryAddress.contains('Pinto, Lucas')
		assert deliveryAddress.contains('060-0001')
		assert deliveryAddress.contains('Hokkaido')
		assert deliveryAddress.contains('Sapporo Shi Chuo Ku')
		assert deliveryAddress.contains('Kita1-Jonishi')
		assert deliveryAddress.contains('House')
		assert deliveryAddress.contains('JPN')
	}
	
	@When("I select my payment method and verify my Order Summary")
	def selectPaymentMethod() {
		//Verify Payment Information label is displaying
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.18, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Payment Information'), 'Payment Information', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify selected payment method
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/opt_Selected Payment'), 'Visa – Ending in 1111', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Billing Address label is displaying
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Billing Address'), 'Billing Address', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Add New Payment Method link is displaying then click on it
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lnk_Add New Payment Method'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lst_Select Payment Method'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Select Cash on Delivery payment method
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Select Quantity - Dialog/obj_NumberPicker'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)	
		CustomKeywords.'custom.keywords.selectPaymentMethod'("Cash on Delivery", findTestObject('Object Repository/doTERRA-MobileApp/Select Payment - Dialog/opt_Selected Payment Method'))
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Select Payment - Dialog/btn_Done'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify that Cash on Delivery payment method got selected
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/opt_Selected Payment'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/opt_Selected Payment'), 'Cash on Delivery', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Order Summary label is displaying
		CustomKeywords.'custom.keywords.multiScroll'(1, 0.5, 0.2, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Order Summary'), 'Order Summary', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Items Total
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Items Total'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Items Total'), '¥3,800', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Subtotal
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Subtotal'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Subtotal'), '¥3,800', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Tax
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Tax'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Tax'), '¥0', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Shipping
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Shipping'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Shipping'), '¥600', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify PV Earned
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_PV Earned'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_PV Earned'), '28.00', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Total
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/lbl_Total'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/txt_Total'), '¥4,400', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@When("I click on Save and Process Now button")
	def clickSaveAndProcessNow() {
		//Click on Save and Process Now button
		CustomKeywords.'custom.keywords.multiScroll'(1, 0.5, 0.4, 1)
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Create New Loyalty Order - Page/btn_Save and Process Now'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should see added LRP order")
	def verifyAddedLRPOrder() {
		//Verify added order processing date
		CustomKeywords.'custom.keywords.multiScroll'(1, 0.5, 0.35, 3)
		Date today = new Date()
		String currentMonth = today.format('MMM')
		if(currentMonth == "Jan") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Feb 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Feb") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Mar 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Mar") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Apr 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Apr") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'May 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "May") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Jun 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Jun") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Jul 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Jul") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Aug 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Aug") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Sep 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Sep") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Oct 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Oct") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Nov 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Nov") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Dec 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Dec") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Processing Date Order 2'), 'Jan 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		}
		
		//Verify added order PV points
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_PV Order 2'), '28.0', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify added order total
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/txt_Total Order 2'), '¥4,724', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@When("I edit my added LRP order")
	def editSecondLRPOrder() {
		//Edit second LRP order
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit LRP 2'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify Edit Loyalty Order screen is displaying
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_Add Additional Products'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should be able to validate (.*), (.*), (.*), Processing Date, Delivery Address, (.*), and Order Summary")
	def validateLRPOrder(String product, String phone, String email, String paymentMethod) {
		//Verify OnGuard + Softgels product is displaying
		CustomKeywords.'custom.keywords.multiScroll'(1, 0.5, 0.35, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/lbl_OnGuard Softgels'), product, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify LRP order processing date
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.3, 3)
		Date today = new Date()
		String currentMonth = today.format('MMM')
		if(currentMonth == "Jan") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Feb 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Feb") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Mar 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Mar") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Apr 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Apr") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'May 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "May") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Jun 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Jun") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Jul 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Jul") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Aug 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Aug") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Sep 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Sep") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Oct 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Oct") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Nov 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Nov") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Dec 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		} else if(currentMonth == "Dec") {
			CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Processing Date'), 'Jan 10', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		}
		
		//Validate phone number
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.25, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Phone Number'), phone, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Validate primary email
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Primary Email'), email, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Validate delivery address
		String deliveryAddress = CustomKeywords.'custom.keywords.getText'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Delivery Address'), GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		assert deliveryAddress.contains('Pinto, Lucas')
		assert deliveryAddress.contains('060-0001')
		assert deliveryAddress.contains('Hokkaido')
		assert deliveryAddress.contains('Sapporo Shi Chuo Ku')
		assert deliveryAddress.contains('Kita1-Jonishi')
		assert deliveryAddress.contains('House')
		assert deliveryAddress.contains('JPN')
		
		//Validate selected payment method
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.3, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/opt_Selected Payment'), paymentMethod, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		

		//Validate order summary
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.3, 3)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Items Total'), '¥3,800', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Subtotal'), '¥3,800', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Shipping'), '¥600', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.getTextAndVerifyMatch'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/txt_Total'), '¥4,400', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should be able to delete added LRP order")
	def deleteLRPOrder() {
		//Delete LRP order
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/icn_...'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/btn_Delete Template'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Delete Template - Dialog/btn_Yes'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify LRP order has been deleted
		CustomKeywords.'custom.keywords.verifyElementExistsWithAttribute'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/lbl_My Loyalty Rewards'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.multiScroll'(2, 0.5, 0.2, 3)
		CustomKeywords.'custom.keywords.verifyElementDontExist'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit LRP 2'), GlobalVariable.G_Timeout_XShort)
	}
	
	@Then("I should not be able to delete last LRP order")
	def verifyLastLRPOrderCannotBeDeleted() {
		//Edit last LRP order
		CustomKeywords.'custom.keywords.tap'(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/icn_Edit Loyalty Order'), 'enabled', 'true', GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		
		//Verify ... icon is not displaying
		CustomKeywords.'custom.keywords.verifyElementDontExist'(findTestObject('Object Repository/doTERRA-MobileApp/Edit Loyalty Order - Page/icn_...'), GlobalVariable.G_Timeout_XShort)
		CustomKeywords.'custom.keywords.closeApplication'()
	}
}