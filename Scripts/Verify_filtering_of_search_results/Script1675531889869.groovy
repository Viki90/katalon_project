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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject


// Open browser
WebUI.openBrowser('https://rahulshettyacademy.com/seleniumPractise/#/');

// Maximize current window
WebUI.maximizeWindow()

// set text
//WebUI.setText(findTestObject('Object Repository/Test_2_OR/Page_GreenKart - veg and fruits kart/input_KART_search-keyword'), 'ca')

for (def i = 1; i <= 4; i++) {
	WebUI.click(findTestObject('Object Repository/Test_2_OR/Page_GreenKart - veg and fruits kart/button_ADD TO CART'))
}
	
	TestObject vegetable = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/div[1]/div/div[2]/div[3]/button')
	TestObject vegetable2 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/div[1]/div/div[5]/div[3]/button')
	TestObject vegetable3 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/div[1]/div/div[6]/div[3]/button')
	List<TestObject> randomObjects = new ArrayList<>();
	randomObjects.add(vegetable);
	randomObjects.add(vegetable2);
	randomObjects.add(vegetable3);
	Random rand = new Random()
	TestObject randomPath = randomObjects.get(rand.nextInt(randomObjects.size()))
	WebUI.click(randomPath)

	 
	
// verify element
//WebUI.verifyElementPresent(findTestObject('Object Repository/Test_2_OR/Page_GreenKart - veg and fruits kart/div_Carrot - 1 Kg56ADD TO CART'), 6)
WebUI.verifyElementPresent(vegetable, 20)

// drop down
TestObject dropdownValue = new TestObject('DropDownValue').addProperty('xpath', ConditionType.EQUALS, "//*[@id='root']/div/header/div/div[3]/a[4]/img")
WebUI.waitForElementVisible(dropdownValue, 30)
WebUI.click(dropdownValue)


// click checkout
WebUI.click(findTestObject('Object Repository/checkout/Page_GreenKart - veg and fruits kart/button_PROCEED TO CHECKOUT'))

// Switch  window
WebUI.switchToWindowUrl('https://rahulshettyacademy.com/seleniumPractise/#/cart')

CurrentUrL = WebUI.getUrl()

WebUI.verifyLinksAccessible([CurrentUrL, 'https://rahulshettyacademy.com/seleniumPractise/#/cart'])

// close browser
WebUI.closeBrowser()