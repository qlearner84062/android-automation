
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import java.lang.Object


def static "custom.keywords.selectQuantity"(
    	int expectedQuantity	
     , 	TestObject selectedQuantity	) {
    (new custom.keywords()).selectQuantity(
        	expectedQuantity
         , 	selectedQuantity)
}

def static "custom.keywords.selectPaymentMethod"(
    	String expectedMethod	
     , 	TestObject selectedPaymentMethod	) {
    (new custom.keywords()).selectPaymentMethod(
        	expectedMethod
         , 	selectedPaymentMethod)
}

def static "custom.keywords.getElementByText"(
    	String text	) {
    (new custom.keywords()).getElementByText(
        	text)
}

def static "custom.keywords.getTextViewElementByText"(
    	String text	) {
    (new custom.keywords()).getTextViewElementByText(
        	text)
}

def static "custom.keywords.scrollToTextViewElement"(
    	String text	) {
    (new custom.keywords()).scrollToTextViewElement(
        	text)
}

def static "custom.keywords.swipeDown"(
    	int swipes	) {
    (new custom.keywords()).swipeDown(
        	swipes)
}

def static "custom.keywords.swipeUp"(
    	int swipes	) {
    (new custom.keywords()).swipeUp(
        	swipes)
}

def static "custom.keywords.scrollDown"() {
    (new custom.keywords()).scrollDown()
}

def static "custom.keywords.scrollUp"() {
    (new custom.keywords()).scrollUp()
}

def static "custom.keywords.multiScroll"(
    	int times	
     , 	double startY	
     , 	double endY	
     , 	int durationInSec	) {
    (new custom.keywords()).multiScroll(
        	times
         , 	startY
         , 	endY
         , 	durationInSec)
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

def static "custom.keywords.verifyElementDontExist"(
    	TestObject to	
     , 	int timeout	) {
    (new custom.keywords()).verifyElementDontExist(
        	to
         , 	timeout)
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

def static "custom.keywords.setEncryptedText"(
    	TestObject to	
     , 	String attributeName	
     , 	String attributeValue	
     , 	String text	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).setEncryptedText(
        	to
         , 	attributeName
         , 	attributeValue
         , 	text
         , 	timeout
         , 	delay)
}

def static "custom.keywords.getText"(
    	TestObject to	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).getText(
        	to
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

def static "custom.keywords.verifyMatch"(
    	String actualText	
     , 	String expectedText	) {
    (new custom.keywords()).verifyMatch(
        	actualText
         , 	expectedText)
}

def static "custom.keywords.verifyNumbersAreEqual"(
    	Object actualNumber	
     , 	Object expectedNumber	) {
    (new custom.keywords()).verifyNumbersAreEqual(
        	actualNumber
         , 	expectedNumber)
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

def static "custom.keywords.selectProcessingDate"(
    	int date	
     , 	int timeout	
     , 	int delay	) {
    (new custom.keywords()).selectProcessingDate(
        	date
         , 	timeout
         , 	delay)
}
