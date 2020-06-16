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

////Launch application
Mobile.startApplication(GlobalVariable.G_AndroidApp, true)

////Close Already have an account dialog
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Already have an account - Dialog/btn_X'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/Already have an account - Dialog/btn_X'), GlobalVariable.G_Timeout_Long)
//
////Verify Shop page displaying
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/btn_Browse All Products'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/card_Single Oils'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Shop - Page/card_Blend Oils'), GlobalVariable.G_Timeout_Long)
//
////Click on Account icon in the bottom nav
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_ACCOUNT'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_ACCOUNT'), GlobalVariable.G_Timeout_Long)
//
////Click on I already have an account button
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Account - Page/lbl_I already have an account'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/Account - Page/lbl_I already have an account'), GlobalVariable.G_Timeout_Long)
//
////Validate that Log in button is disabled
//Mobile.verifyElementExist(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementAttributeValue(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), 'class', 'android.widget.Button', GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementAttributeValue(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), 'enabled', 'false', GlobalVariable.G_Timeout_Long)
//
////Enter ID
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your email or ID'), GlobalVariable.G_Timeout_Long)
//Mobile.setText(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your email or ID'), '8111537', GlobalVariable.G_Timeout_Long)
//
////Enter password
//String password = "VL+i8NsHPUhDiyVo8sB+5w=="
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your password'), GlobalVariable.G_Timeout_Long)
//Mobile.setEncryptedText(findTestObject('Object Repository/doTERRA-MobileApp/Log in - Page/txt_Enter your password'), password, GlobalVariable.G_Timeout_Long)
//
////Verify that Log in button become enabled after entering ID and password
//Mobile.verifyElementExist(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementAttributeValue(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), 'enabled', 'true', GlobalVariable.G_Timeout_Long)
//
////Click on Log in button
//Mobile.verifyElementExist(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('doTERRA-MobileApp/Log in - Page/btn_Log In'), GlobalVariable.G_Timeout_Long)
//
////Verify that User Account page is displaying
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_My Orders'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_Saved Products'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_My Details'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_US English Local'), GlobalVariable.G_Timeout_Long)
//Mobile.scrollToText('Privacy Policy')
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_Notifications'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_My Orders'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Log out'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Privacy Policy'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Terms  Conditions'), GlobalVariable.G_Timeout_Long)
//
////Navigate to My Details page
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/card_My Details'), GlobalVariable.G_Timeout_Long)
//
////Verify user full name
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/My Details - Page/lbl_Lucas Pinto'), GlobalVariable.G_Timeout_Long)
//String fullName = Mobile.getText(findTestObject('Object Repository/doTERRA-MobileApp/My Details - Page/lbl_Lucas Pinto'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyMatch(fullName, 'Lucas Pinto', false)
//
////Verify user doTERRA ID
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/My Details - Page/lbl_8111537'), GlobalVariable.G_Timeout_Long)
//String doTERRAID = Mobile.getText(findTestObject('Object Repository/doTERRA-MobileApp/My Details - Page/lbl_8111537'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyMatch(doTERRAID, '8111537', false)
//
////Click Back button in upper nav
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Upper Nav/btn_Back'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/Upper Nav/btn_Back'), GlobalVariable.G_Timeout_Long)
//
////Click on BAG icon in the bottom nav
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_BAG'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_BAG'), GlobalVariable.G_Timeout_Long)
//
////Verify that Bag is empty
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Bag - Page/lbl_Your bag is empty'), GlobalVariable.G_Timeout_Long)
//String emptyBag = Mobile.getText(findTestObject('Object Repository/doTERRA-MobileApp/Bag - Page/lbl_Your bag is empty'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyMatch(emptyBag, 'Your bag is empty', false)
//
////Click on Start Shopping button
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Bag - Page/btn_Start Shopping'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/Bag - Page/btn_Start Shopping'), GlobalVariable.G_Timeout_Long)
//
////Validate that user have 700.00 rewards points
//Mobile.verifyElementExist(findTestObject('doTERRA-MobileApp/Shop - Page/lbl_0.00'), GlobalVariable.G_Timeout_Long)
//String rewardPoints = Mobile.getText(findTestObject('doTERRA-MobileApp/Shop - Page/lbl_0.00'), GlobalVariable.G_Timeout_Long)
//Mobile.verifyMatch(rewardPoints, '700.00', false)
//
////Click on ACCOUNT icon in bottom nav
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_ACCOUNT'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/Bottom Nav/icn_ACCOUNT'), GlobalVariable.G_Timeout_Long)
//
////Log out user
//Mobile.scrollToText('Log out')
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Log out'), GlobalVariable.G_Timeout_Long)
//Mobile.tap(findTestObject('Object Repository/doTERRA-MobileApp/User Account - Page/lnk_Log out'), GlobalVariable.G_Timeout_Long)
//
////Verify that user has successfully logged out
//Mobile.verifyElementExist(findTestObject('Object Repository/doTERRA-MobileApp/Account - Page/lbl_I already have an account'), GlobalVariable.G_Timeout_Long)
//Mobile.closeApplication()
