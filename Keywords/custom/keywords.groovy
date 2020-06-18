package custom
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidElement


class keywords {
	AppiumDriver driver

	def swiping() {
		this.driver = MobileDriverFactory.getDriver()
	}

	private scrollEntireList() {
		// very specific to android and the type of element that makes up your dropdowns
		ArrayList listElement = driver.findElementsByClassName("android.widget.CheckedTextView")
		TouchAction touchAction = new TouchAction(driver)
		def bottomElement = listElement[listElement.size() - 1]
		def topElement = listElement[0]
		// Press and scroll from the last element in the list all the way to the top
		touchAction.press(bottomElement).moveTo(topElement).release().perform();
	}

	@Keyword
	def boolean scrollListToElementWithText(String elementText) {
		boolean isElementFound = false;
		while (isElementFound == false) {
			// very specific to android and the type of element that makes up your dropdowns
			ArrayList listElement = driver.findElementsByClassName("android.widget.CheckedTextView")
			for (int i = 0; i<listElement.size(); i++) {
				String textItem = ((MobileElement)listElement[i]).getText()
				if (textItem == elementText) {
					isElementFound = true;
					return true;
				}
			}
			scrollEntireList()
		}
	}

	@Keyword
	def swipeDown(int swipes) {
		for(int i = 0; i < swipes; i++) {
			int device_Height = Mobile.getDeviceHeight()
			int device_Width = Mobile.getDeviceWidth()
			int startX = device_Width / 2
			int endX = startX
			int startY = device_Height * 0.30
			int endY = device_Height * 0.70
			Mobile.swipe(startX, endY, endX, startY)
		}
	}

	@Keyword
	def startApplication(String appFile, TestObject to, int timeout, int delay, boolean uninstallAfterCloseApp) {
		Mobile.startApplication(appFile, uninstallAfterCloseApp)
		Mobile.waitForElementPresent(to, timeout)
		try {
			for(int i = 0; i <= 5; i++) {
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					System.out.println("elementExist (startApplication): " + elementExist)
					KeywordUtil.markPassed("Mobile application " + appFile + " launched successfully!")
					break
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile application " + appFile + " failed to launch!")
		}
	}

	@Keyword
	def tap(TestObject to, String attributeName, String attributeValue, int timeout, int delay) {
		try {
			for(int i = 0; i <= 5; i++) {
				Mobile.waitForElementPresent(to, timeout)
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					System.out.println("elementExist (tap): " + elementExist)
					Mobile.waitForElementAttributeValue(to, attributeName, attributeValue, timeout)
					boolean elementHasAttribute = Mobile.verifyElementAttributeValue(to, attributeName, attributeValue, timeout)
					if(!elementHasAttribute) {
						Mobile.delay(delay)
						continue
					} else {
						System.out.println("elementHasAttribute (tap): " + elementHasAttribute)
						Mobile.tap(to, timeout)
						break
					}
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile element " + to + " is not found!")
		}
	}

	@Keyword
	def verifyElementExistsWithAttribute(TestObject to, String attributeName, String attributeValue, int timeout, int delay) {
		try {
			for(int i = 0; i <= 5; i++) {
				Mobile.waitForElementPresent(to, timeout)
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					System.out.println("elementExist (verifyElementExistsWithAttribute): " + elementExist)
					Mobile.waitForElementAttributeValue(to,  attributeName, attributeValue, timeout)
					boolean elementHasAttribute = Mobile.verifyElementAttributeValue(to, attributeName, attributeValue, timeout)
					if(!elementHasAttribute) {
						Mobile.delay(delay)
						continue
					} else {
						System.out.println("elementHasAttribute (verifyElementExistsWithAttribute): " + elementHasAttribute)
						KeywordUtil.markPassed("Found elemenet " + to + " with attribute " + attributeName + " and attribute value " + attributeValue)
						break
					}
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile element " + to + " is not found!")
		}
	}

	@Keyword
	def setText(TestObject to, String attributeName, String attributeValue, String text, int timeout, int delay) {
		try {
			for(int i = 0; i <= 5; i++) {
				Mobile.waitForElementPresent(to, timeout)
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					System.out.println("elementExist (setText): " + elementExist)
					Mobile.waitForElementAttributeValue(to, attributeName, attributeValue, timeout)
					boolean elementHasAttribute = Mobile.verifyElementAttributeValue(to, attributeName, attributeValue, timeout)
					if(!elementHasAttribute) {
						Mobile.delay(delay)
						continue
					} else {
						System.out.println("elementHasAttribute (setText): " + elementHasAttribute)
						KeywordUtil.markPassed("Found elemenet " + to + " with attribute " + attributeName + " and attribute value " + attributeValue)
						Mobile.setText(to, "", timeout)
						Mobile.setText(to, text, timeout)
						break
					}
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile element " + to + " is not found!")
		}
	}

	@Keyword
	def setEncryptedText(TestObject to, String attributeName, String attributeValue, String text, int timeout, int delay) {
		try {
			for(int i = 0; i <= 5; i++) {
				Mobile.waitForElementPresent(to, timeout)
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					System.out.println("elementExist (setText): " + elementExist)
					Mobile.waitForElementAttributeValue(to, attributeName, attributeValue, timeout)
					boolean elementHasAttribute = Mobile.verifyElementAttributeValue(to, attributeName, attributeValue, timeout)
					if(!elementHasAttribute) {
						Mobile.delay(delay)
						continue
					} else {
						System.out.println("elementHasAttribute (setText): " + elementHasAttribute)
						KeywordUtil.markPassed("Found elemenet " + to + " with attribute " + attributeName + " and attribute value " + attributeValue)
						Mobile.setText(to, "", timeout)
						Mobile.setEncryptedText(to, text, timeout)
						break
					}
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile element " + to + " is not found!")
		}
	}

	@Keyword
	def scrollToText(String text, TestObject to, int timeout, int delay) {
		Mobile.scrollToText(text)
		try {
			for(int i = 0; i <= 5; i++) {
				Mobile.waitForElementPresent(to, timeout)
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					KeywordUtil.markPassed("Successfully scrolled to " + text + " and found element " + to)
					break
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile element " + to + " is not found!")
		}
	}

	@Keyword
	def String getText(TestObject to, int timeout, int delay) {
		try {
			for(int i = 0; i <= 5; i++) {
				Mobile.waitForElementPresent(to, timeout)
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					String value = Mobile.getText(to, timeout)
					return value
					break
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile element " + to + " is not found!")
		}
	}

	@Keyword
	def getTextAndVerifyMatch(TestObject to, String expectedText, int timeout, int delay) {
		try {
			for(int i = 0; i <= 5; i++) {
				Mobile.waitForElementPresent(to, timeout)
				boolean elementExist = Mobile.verifyElementExist(to, timeout)
				if(!elementExist) {
					Mobile.delay(delay)
					continue
				} else {
					String actualText = Mobile.getText(to, timeout)
					boolean compare = Mobile.verifyMatch(actualText, expectedText, false)
					if(compare) {
						KeywordUtil.markPassed("Successfully verified actual text " + actualText + " and expected text " + expectedText)
						break
					} else {
						KeywordUtil.markFailed("Failed to verify match! Actual text" + actualText + " and expected text " + expectedText)
					}
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Mobile element " + to + " is not found!")
		}
	}

	@Keyword
	def boolean verifyMatch(String actualText, String expectedText) {
		boolean result = Mobile.verifyMatch(actualText, actualText, false)
		if(result) {
			KeywordUtil.markPassed("Successfully verified actual text " + actualText + " and expected text " + expectedText)
			return result
		} else {
			KeywordUtil.markFailed("Failed to verify match! Actual text " + actualText + " and expected text " + expectedText)
			return result
		}
	}

	@Keyword
	def boolean verifyNumbersAreEqual(Object actualNumber, Object expectedNumber) {
		boolean result = Mobile.verifyEqual(actualNumber, expectedNumber)
		if(result) {
			KeywordUtil.markPassed("Successfully verified numbers " + actualNumber + " and expected text " + expectedNumber)
			return result
		} else {
			KeywordUtil.markFailed("Failed to verify numbers! Actual number " + actualNumber + " and expected number " + expectedNumber)
			return result
		}
	}

	@Keyword
	def closeApplication() {
		Mobile.closeApplication()
	}

	@Keyword
	public String getRandomEmail(String suffix, String prefix) {
		int randomNo = (int)(Math.random() * 1000000000)
		return suffix + "_" + randomNo + "@" + prefix
	}

	@Keyword
	public String getRandomString(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789"
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return sb.toString();
	}
}