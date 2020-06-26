package custom
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


class keywords {

	
	@Keyword
	def numberPickerSelectQuantity(int expectedQuantity, TestObject selectedQuantity) {
		String getSelectedQuantity = this.getText(selectedQuantity, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
		int actualQuantity = Integer.parseInt(getSelectedQuantity)
		while(actualQuantity != expectedQuantity) {
			if(actualQuantity > expectedQuantity) {
				AppiumDriver<?> driver = MobileDriverFactory.getDriver()
				Dimension dimension = driver.manage().window().getSize()
				System.out.println("dimension: " + dimension)
				double centerX = dimension.getWidth() / 2
				int startX = centerX.intValue()
				System.out.println("startX: " + startX)
				double centerY = dimension.getHeight() / 2
				int startY = centerY.intValue()
				System.out.println("startY: " + startY)
				int endY = startY + 200
				TouchAction action = new TouchAction(driver)
				action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(startX, endY)).release().perform()
				getSelectedQuantity = this.getText(selectedQuantity, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
				actualQuantity = Integer.parseInt(getSelectedQuantity)
			} else if(actualQuantity < expectedQuantity) {
				AppiumDriver<?> driver = MobileDriverFactory.getDriver()
				Dimension dimension = driver.manage().window().getSize()
				System.out.println("dimension: " + dimension)
				double centerX = dimension.getWidth() / 2
				int startX = centerX.intValue()
				System.out.println("startX: " + startX)
				double centerY = dimension.getHeight() / 2
				int startY = centerY.intValue()
				System.out.println("startY: " + startY)
				int endY = startY - 200
				TouchAction action = new TouchAction(driver)
				action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(startX, endY)).release().perform()
				getSelectedQuantity = this.getText(selectedQuantity, GlobalVariable.G_Timeout_Long, GlobalVariable.G_Timeout_XShort)
				actualQuantity = Integer.parseInt(getSelectedQuantity)
			}
		}
	}

	@Keyword
	def MobileElement getElementByText(String text) {
		AppiumDriver<MobileElement> driver = (AppiumDriver<MobileElement>) MobileDriverFactory.getDriver()
		MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']"))
		return element
	}

	@Keyword
	def List<MobileElement> getTextViewElementByText(String text) {
		AppiumDriver<MobileElement> driver = (AppiumDriver<MobileElement>) MobileDriverFactory.getDriver()
		List<MobileElement> elements = driver.findElements(By.xpath("//android.widget.TextView[@text='"+text+"']"))
		return elements
	}

	@Keyword
	def void scrollToTextViewElement(String text) throws InterruptedException {
		while(this.getTextViewElementByText(text).size() == 0) {
			this.multiScroll(1, 0.5, 0.15, 3)
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
			int endY = device_Height * 0.68
			Mobile.swipe(startX, endY, endX, startY)
		}
	}

	@Keyword
	def swipeUp(int swipes) {
		for(int i = 0; i < swipes; i++) {
			int device_Height = Mobile.getDeviceHeight()
			int device_Width = Mobile.getDeviceWidth()
			int startX = device_Width / 2
			int endX = startX
			int startY = device_Height * 0.30
			int endY = device_Height * 0.68
			Mobile.swipe(startX, startY, endX, endY)
		}
	}

	@Keyword
	def scrollDown() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		Dimension dimension = driver.manage().window().getSize()
		double scrollHeightStart = dimension.getHeight() * 0.8
		int scrollStart = scrollHeightStart.intValue()
		double scrollHeightEnd = dimension.getHeight() * 0.2
		int scrollEnd = scrollHeightEnd.intValue()
		TouchAction action = new TouchAction(driver)
		action.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(0, scrollEnd)).release().perform()
	}

	@Keyword
	def scrollUp() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		Dimension dimension = driver.manage().window().getSize()
		double scrollHeightStart = dimension.getHeight() * 0.2
		int scrollStart = scrollHeightStart.intValue()
		double scrollHeightEnd = dimension.getHeight() * 0.5
		int scrollEnd = scrollHeightEnd.intValue()
		TouchAction action = new TouchAction(driver)
		action.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(0, scrollEnd)).release().perform()
	}

	@Keyword
	def multiScroll(int times, double startY, double endY, int durationInSec) {
		for(int i = 0; i < times; i++) {
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()
			Dimension dimension = driver.manage().window().getSize()
			double scrollHeightStart = dimension.getHeight() * startY
			int scrollStart = scrollHeightStart.intValue()
			double scrollHeightEnd = dimension.getHeight() * endY
			int scrollEnd = scrollHeightEnd.intValue()
			TouchAction action = new TouchAction(driver)
			action.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durationInSec))).moveTo(PointOption.point(0, scrollEnd)).release().perform()
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