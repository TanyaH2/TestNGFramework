package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//li[@class='page-title']")
	public WebElement dashboardText;

	@FindBy(xpath = "//span[text()='PIM']")
	public WebElement pim;
	
	@FindBy(xpath = "//span[text()='Add Employee']")
	public WebElement addEmployee;
    
	
	public HomePage() {

		PageFactory.initElements(driver, this);
	}
	
//	   public void addEmpl() {
//	    	
//	    	CommonMethods.click(pim);
//	    	CommonMethods.click(addEmployee);
//	    }

}
