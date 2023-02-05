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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor



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

// Click on place order
WebUI.click(findTestObject('Object Repository/place order/Page_GreenKart - veg and fruits kart/button_Place Order'))

// Switch  window
WebUI.switchToWindowUrl('https://rahulshettyacademy.com/seleniumPractise/#/country')

// select
TestObject selectEl = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id='root']/div/div/div/div/div/select")

WebUI.click(selectEl)

// select country
WebUI.selectOptionByValue(selectEl, 'India', false)

// verify element is clickble (not disabled)
WebUI.verifyElementClickable(selectEl)

// random dopdown
TotalOptions = WebUI.getNumberOfTotalOption(selectEl)

Random rand = new Random()

def randomNumber = ThreadLocalRandom.current().nextInt(0, TotalOptions - 1)
WebUI.selectOptionByIndex(selectEl, randomNumber)

//  check box 
WebUI.check(findTestObject('Object Repository/checkbox/Page_GreenKart - veg and fruits kart/input_Choose Country_chkAgree'))

// verify check box is checked
WebUI.verifyElementChecked(findTestObject('Object Repository/checkbox/Page_GreenKart - veg and fruits kart/input_Choose Country_chkAgree'), 30)

// click on procced btn
WebUI.click(findTestObject('Object Repository/country/Page_GreenKart - veg and fruits kart/button_Proceed'))

// Verify message after procced btn
WebUI.verifyTextPresent("Thank you", true)

// new tab
WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')
int currentTab = WebUI.getWindowIndex()
WebUI.switchToWindowIndex(currentTab)

WebUI.navigateToUrl("http://www.webdriveruniversity.com/")

// Scroll down to Actions and take a screenshot
WebUI.scrollToElement(findTestObject('Object Repository/web/Page_WebDriverUniversity.com/h1_ACTIONS') , 3)

// click on actions
TestObject actionBtn = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id='actions']") 
WebUI.click(actionBtn)

// Go back to the second tab (webdriveruniversity Home page) and take a screenshot
// switch tab 
WebUI.switchToWindowIndex(0)
// take screenshot - 
WebUI.takeScreenshot()
WebUI.takeScreenshot('screenshot.png')

// close browser
WebUI.closeBrowser()