
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import com.applitools.eyes.RectangleSize

import com.applitools.eyes.selenium.Eyes


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
}

def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}

def static "custom.keywords.startApplication"(
    	String appFile	
     , 	TestObject to	
     , 	int timeout	
     , 	int delay	
     , 	boolean uninstallAfterCloseApp	) {
    (new custom.keywords()).startApplication(
        	appFile
         , 	to
         , 	timeout
         , 	delay
         , 	uninstallAfterCloseApp)
}

def static "custom.keywords.tap"(
    	TestObject to	
     , 	String attributeName	
     , 	String attributeValue	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).tap(
        	to
         , 	attributeName
         , 	attributeValue
         , 	timeout
         , 	delay)
}

def static "custom.keywords.verifyElementExistsWithAttribute"(
    	TestObject to	
     , 	String attributeName	
     , 	String attributeValue	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).verifyElementExistsWithAttribute(
        	to
         , 	attributeName
         , 	attributeValue
         , 	timeout
         , 	delay)
}

def static "custom.keywords.setText"(
    	TestObject to	
     , 	String attributeName	
     , 	String attributeValue	
     , 	String text	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).setText(
        	to
         , 	attributeName
         , 	attributeValue
         , 	text
         , 	timeout
         , 	delay)
}

def static "custom.keywords.scrollToText"(
    	String text	
     , 	TestObject to	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).scrollToText(
        	text
         , 	to
         , 	timeout
         , 	delay)
}

def static "custom.keywords.getTextAndVerifyMatch"(
    	TestObject to	
     , 	String expectedText	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).getTextAndVerifyMatch(
        	to
         , 	expectedText
         , 	timeout
         , 	delay)
}

def static "custom.keywords.closeApplication"() {
    (new custom.keywords()).closeApplication()
}

def static "custom.keywords.getRandomEmail"(
    	String suffix	
     , 	String prefix	) {
    (new custom.keywords()).getRandomEmail(
        	suffix
         , 	prefix)
}

def static "custom.keywords.getRandomString"(
    	int length	) {
    (new custom.keywords()).getRandomString(
        	length)
}

def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
}

def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
}

def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}

def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline"(
    	String baselineName	
     , 	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpenWithBaseline(
        	baselineName
         , 	testName
         , 	viewportSize)
}
