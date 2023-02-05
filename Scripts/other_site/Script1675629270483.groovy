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

WebUI.click(actionBtn)

// verify text actions
WebUI.verifyTextPresent("ACTIONS", true)

WebUI.navigateToUrl("http://www.webdriveruniversity.com/Actions/index.html")

WebUI.verifyElementPresent(findTestObject('Object Repository/Drag_and_Drop/Page_WebDriver  Actions/p_DRAG ME TO MY TARGET'), 10)
// Drag and drop “Drag me to my target” box inside the “Drop here” box
TestObject drag = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="draggable"]')

TestObject drop = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id='droppable']")

WebUI.dragAndDropToObject(drag, drop)


// Verify that “Link 1” is not visible until user hovers (Mouse Over) “Hover Over Me First” button
TestObject HoverOverLink = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="div-hover"]/div[1]') 
TestObject Link1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="div-hover"]/div[1]/div/a')
WebUI.verifyElementNotVisible(Link1)
// Mouse over on Link 1
WebUI.mouseOver(HoverOverLink)
WebUI.click(Link1)

// Click on “Link 1” and verify Alert message is displayed
// alert verify
WebUI.verifyAlertPresent(20)
// Getting the text from the alert and storing it in Variable'
String AlertText = driver.switchTo().alert().getText()
// 'Verifying the Actual and Expected text from Alert'
WebUI.verifyEqual(AlertText, 'Well done you clicked on the link!')
WebUI.dismissAlert()

// close browser
WebUI.closeBrowser()

// Open browser
WebUI.openBrowser('http://www.webdriveruniversity.com/Contact-Us/contactus.html');

// Maximize current window
WebUI.maximizeWindow()

// verify element
WebUI.verifyElementPresent(findTestObject('Object Repository/contact us/Page_WebDriver  Contact Us/h2_CONTACT US'), 10)

// In the Comment text box enter the Alert text 
TestObject CommentText = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="contact_form"]/textarea')

WebUI.setText(CommentText, AlertText)

// close browser
WebUI.closeBrowser()