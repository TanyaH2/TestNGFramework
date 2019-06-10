package com.syntax.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass {

	@Test(enabled = false)
	public void loginToOrangeHRM() {

		LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();

		CommonMethods.sendText(login.username, "Admins");
		CommonMethods.sendText(login.password, "@81EpCSguV");
		CommonMethods.click(login.btnLogin);

	}

	@Test(enabled = false)
	public void doLogIn() {
		LoginPage login = new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);

		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();
		Assert.assertTrue(isDisplayed);

	}

	/*
	 * verify user is unable to logIn with wrong credentials
	 */

	@Test
	public void negativeLogin() {
		
		LoginPage login=new LoginPage();
		
		login.login("admins", "test");
		String errorText=login.message.getText();
		
		Assert.assertEquals(errorText, "Invalid Credentials");
	}

}
