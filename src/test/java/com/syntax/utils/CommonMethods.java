package com.syntax.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass{
	// SELENIUM
	
	/**
	 * This method will Check if data is displayed in the table
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void dataCheck(List<WebElement> element, String text) {

		List<WebElement> cells = element;
		String expected = text;
		for (WebElement cell : cells) {
			String cellText = cell.getText();
			if (cellText.equalsIgnoreCase(expected)) {
				System.out.println("Your order for " + text + " is displayed ");
				break;
			} else {
				System.out.println(text + " - text is not present");
			}
		}
	}

	/**
	 * This method will Check if displayed data is as expected
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void orderDataCheck(WebElement element, String text) {

		WebElement dataCheck = element;
		if (dataCheck.isDisplayed()) {
			String present = dataCheck.getAttribute("value");
			if (present.equalsIgnoreCase(text)) {
				System.out.println(text + " - text is present");
			
			} else {
				System.out.println(text + " - text is not present");
			}
			
		}
	}

	/**
	 * This method will check if specified Radio Button is selected
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void radioButtonCheck(List<WebElement> element, String text) {

		List<WebElement> listOfElements = element;

		for (WebElement elementOption : listOfElements) {

			if (elementOption.isDisplayed()) {
				String value = elementOption.getText();
				if (value.equalsIgnoreCase(text)) {
					System.out.println("Option of " + text + " is selected");
				}
			} else {
				System.out.println("No such option of Radio Button is availible");

			}
		}
	}

	/**
	 * This method will select specified Radio Button
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void radioButton(List<WebElement> element, String text) {

		List<WebElement> listOfElements = element;

		for (WebElement elementOption : listOfElements) {

			if (elementOption.isEnabled() && elementOption.isDisplayed()) {
				String value = elementOption.getText();
//				System.out.println(value);
				if (value.equalsIgnoreCase(text)) {
					elementOption.click();
					System.out.println("Option of " + text + " is selected");
				}
			} else {
				System.out.println("No such option of Radio Button is availible");

			}
		}
	}

	/**
	 * This method will select specified Check Boxes
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text, String text2
	 * 
	 */

	public static void checkBox(List<WebElement> element, String text, String text2) {

		List<WebElement> hobbys = element;

		for (WebElement hobby : hobbys) {

			if (hobby.isEnabled() && hobby.isDisplayed()) {
				String value = hobby.getText();
				if (value.equalsIgnoreCase(text) || value.equalsIgnoreCase(text2)) {
					if (hobby.isSelected()) {
						hobby.click();
					}
					hobby.click();
				}
			} else {
				System.out.println("No such option of Check Box is availible");
			}

		}
	}

	/**
	 * This method will select specified Calendar cell date
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void calendarDateSelection(List<WebElement> element, String wantedDate) {
		List<WebElement> dateCells = element;
		for (WebElement dateOB : dateCells) {
			String dateText = dateOB.getText();

			if (dateText.equals(wantedDate)) {
				dateOB.click();
				System.out.println("Option with date " + wantedDate + " is selected");
				break;
			} else {
				System.out.println(wantedDate + " - date is not present");
			}

		}
	}

	/**
	 * This method will select a specified value from a drop down
	 * 
	 * @author Syntax
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text " + text + " is selected");
				isSelected = true;
				break;
			}
		}
		if (!isSelected) {
			System.out.println("Option with text +" + text + "is not available");
		}
	}

	/**
	 * This method will select a specified value from a drop down by its index
	 * 
	 * @author Syntax
	 * @param Select element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
			System.out.println("Option with text " + index + " is selected");
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	/**
	 * Method will send Text
	 * 
	 * @param WebElement element, String value
	 */
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Method will accept alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will dismiss alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will get text of an alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}

	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, By locator, int time
	 */
	public static void waitForElementBeVisible(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementBeVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementBeClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementBeClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Method that will take ScreenShot
	 * 
	 * @param String folderName, String fileName
	 */
	public static void takeScreenshot(String folderName, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scr, new File("screenshots/" + folderName + "/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screesnhot");
		}
	}

	/**
	 * Method that scrolls Down and Up
	 * 
	 * @param int pixels
	 */
	public static void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public static void scrollUp(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixels + ")");
	}

	/**
	 * Method that Clicks in JavaScript
	 * 
	 * @param WebElement element
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void click(WebElement element) {
		element.click();
	}

}
///**********************************************************
// * 
// * @param element
// * @param text
// * Below is for Sending Keys
// **********************************************************/
//    public static void sendText(WebElement element, String text) {
//        element.clear();
//        element.sendKeys(text);
//    }
//    
//    /**********************************************************
//     * 
//     * @param element
//     * @param broswer
//     * Below is for browserSetUp
//     **********************************************************/
//    
//    public static void browserSetUp(String broswer, String URL) {
//        if(broswer.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver", "/Users/Syntax/Selenium/chromedriver");
//            driver=new ChromeDriver();
//        }else if(broswer.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "/Users/Syntax/Selenium/geckodriver");
//            driver=new FirefoxDriver();
//        }
//        driver.get(URL);
//    }
//    
//    /**********************************************************
//     * 
//     * @param element
//     * @param broswer
//     * Below is for selectByValue
//     **********************************************************/
//    
//    public static void selectByValue(WebElement element,String value) {
//         name=new Select(element);
//        List<WebElement> list=name.getOptions();
//        for(WebElement ele:list) {
//            System.out.println(ele.getText());
//            if(value.equals(ele.getAttribute("value"))) {
//                 name.selectByValue(value);
//            }
//        }
//    }
//    
//    /**********************************************************
//     * 
//     * @param element
//     * @param broswer
//     * Below is for selectByIndex
//     **********************************************************/
//    
//    public static void selectByIndex(WebElement element, int index) {
//        name=new Select(element);
//        List<WebElement> ele=name.getOptions();
//        for(WebElement option:ele) {
//            System.out.println(option.getText());
//            if(ele.size()>index) {
//                name.selectByIndex(index);
//            }
//
//

//FROM AHMET 
//public static void findingElement(String locator, String path, String SendKeyValue) {
//if (locator.equalsIgnoreCase("cssSelector")) {
//	driver.findElement(By.cssSelector(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("xpath")) {
//	driver.findElement(By.xpath(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("id")) {
//	driver.findElement(By.id(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("className")) {
//	driver.findElement(By.className(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("name")) {
//	driver.findElement(By.name(path)).sendKeys(SendKeyValue);
//}
//}
