
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import com.applitools.eyes.selenium.Eyes

import com.applitools.eyes.RectangleSize


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

def static "custom.keywords.isElementPresent_Mobile"(
    	TestObject to	
     , 	int timeout	) {
    (new custom.keywords()).isElementPresent_Mobile(
        	to
         , 	timeout)
}

def static "custom.keywords.getCurrentSessionMobileDriver"() {
    (new custom.keywords()).getCurrentSessionMobileDriver()
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

def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
}

def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}

def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
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
