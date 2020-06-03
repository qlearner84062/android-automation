import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Launch application
Mobile.startApplication(GlobalVariable.G_AndroidApp, true)

//******************Home Page Validations******************
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/logo_doTERRA'), GlobalVariable.G_Timeout_Long)

//Verify welcome message is displaying
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/lbl_Welcome to doTERRA'), GlobalVariable.G_Timeout_Long)
String welcomeMessage = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/lbl_Welcome to doTERRA'), GlobalVariable.G_Timeout_Long)
Mobile.verifyMatch(welcomeMessage, 'Welcome to dōTERRA', false)

//Verify Login button is displaying
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/btn_Login'), GlobalVariable.G_Timeout_Long)

//Verify Enroll today button is displaying then click on it
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/btn_Enroll today'), GlobalVariable.G_Timeout_Long)
Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Enroll - Page/btn_Enroll today'), GlobalVariable.G_Timeout_Long)

//******************Region and Language Page Validations******************

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
Mobile.scrollToText('Canada')
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/Select Region - Dialog/btn_Done'), GlobalVariable.G_Timeout_Long)
Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/Select Region - Dialog/btn_Done'), GlobalVariable.G_Timeout_Long)

//Verify that Canada regions is now selected
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_Canada'), GlobalVariable.G_Timeout_Long)
selectedRegion = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_Canada'), GlobalVariable.G_Timeout_Long)
Mobile.verifyMatch(selectedRegion, 'Canada', false)

//Verify Language dropdown is displaying and English is selected option
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_English'), GlobalVariable.G_Timeout_Long)
String selectedLanguage = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/opt_English'), GlobalVariable.G_Timeout_Long)
Mobile.verifyMatch(selectedLanguage, 'English', false)

//Verify Continue button is displaying then click on it
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/btn_Continue'), GlobalVariable.G_Timeout_Long)
Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Region Language - Page/btn_Continue'), GlobalVariable.G_Timeout_Long)

//******************Bundle and Save Page Validations******************

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

//******************Add Products Page Validations******************

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

//******************Shopping Bag Page Validations******************

//Verify that Shopping Bag label is displaying
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Shopping Bag'), GlobalVariable.G_Timeout_Long)
String lblShoppingBag = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/lbl_Shopping Bag'), GlobalVariable.G_Timeout_Long)
Mobile.verifyMatch(lblShoppingBag, 'Shopping Bag', false)

//Click on Proceed to Checkout button
Mobile.scrollToText('Proceed to Checkout')
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/btn_Proceed to Checkout'), GlobalVariable.G_Timeout_Long)
Mobile.tap(findTestObject('Object Repository/doTERRA-HybridApp/Shopping Bag - Page/btn_Proceed to Checkout'), GlobalVariable.G_Timeout_Long)

//******************Account Setup Page Validations******************

//Verify Account Setup label is displaying
Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/lbl_Account Setup'), GlobalVariable.G_Timeout_Long)
String lblAccountSetup = Mobile.getText(findTestObject('Object Repository/doTERRA-HybridApp/Account Setup - Page/lbl_Account Setup'), GlobalVariable.G_Timeout_Long)
Mobile.verifyMatch(lblAccountSetup, 'Account Setup', false)

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



