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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

// Open browser
WebUI.openBrowser('https://rahulshettyacademy.com/seleniumPractise/#/');

// Maximize current window
WebUI.maximizeWindow()

// click
WebUI.click(findTestObject('Object Repository/Enter promo code/Page_GreenKart - veg and fruits kart/button_ADD TO CART'))

// drop down
TestObject dropdownValue = new TestObject('DropDownValue').addProperty('xpath', ConditionType.EQUALS, "//*[@id='root']/div/header/div/div[3]/a[4]/img")
WebUI.waitForElementVisible(dropdownValue, 30)
WebUI.click(dropdownValue)


// click checkout
WebUI.click(findTestObject('Object Repository/checkout/Page_GreenKart - veg and fruits kart/button_PROCEED TO CHECKOUT'))

// Switch  window
WebUI.switchToWindowUrl('https://rahulshettyacademy.com/seleniumPractise/#/cart')

// get tottal amount

text = WebUI.getText(findTestObject('Object Repository/Enter promo code/Page_GreenKart - veg and fruits kart/span_75'))

WebUI.setText(findTestObject('Object Repository/Enter promo code/Page_GreenKart - veg and fruits kart/input_Total_promoCode'), text)

// apply code
WebUI.click(findTestObject('Object Repository/Enter promo code/Page_GreenKart - veg and fruits kart/button_Apply'))

if ( WebUI.verifyElementPresent(findTestObject('Object Repository/invlid message/Page_GreenKart - veg and fruits kart/span_Invalid code'), 30)) {
	KeywordUtil.markPassed("Element is present")
} else {
	KeywordUtil.markFailed("Element is not present")
}

// Click on place order
WebUI.click(findTestObject('Object Repository/place order/Page_GreenKart - veg and fruits kart/button_Place Order'))




// close browser
WebUI.closeBrowser()