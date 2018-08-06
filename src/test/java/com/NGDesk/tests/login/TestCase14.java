package com.NGDesk.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NGDesk.pages.LoginPage;
import com.NGDesk.pages.ViewTicketPage;
import com.NGDesk.tests.TestBase;
import com.NGDesk.utilities.BrowserUtils;
import com.NGDesk.utilities.ConfigurationReader;

public class TestCase14 extends TestBase{

	// SPA-626
	String userId = ConfigurationReader.getProperty("usernameBayram");
	String password = ConfigurationReader.getProperty("passwordBayram");
	String loginPageUrlBayram = ConfigurationReader.getProperty("loginPageUrlBayram");
	@Test
	public void testCase13() throws InterruptedException {
	//Open url  and login Step 1-2-3-4
	LoginPage loginPage=new LoginPage();
    
	driver.get(loginPageUrlBayram);
	loginPage.username.sendKeys(userId);
	loginPage.password.sendKeys(password);
	Thread.sleep(3000);
	loginPage.loginButton.click();
	
	ViewTicketPage viewTicketPage = new ViewTicketPage();
	BrowserUtils.hover(viewTicketPage.hoverTicketButton);
	viewTicketPage.viewTickets.click();
	Thread.sleep(3000);
	
	
	// Clicking on the first ticket
	viewTicketPage.firstTicket.click();
	Thread.sleep(3000);
	System.out.println("Control panel: "+viewTicketPage.controlPanel.getText());
	Assert.assertEquals(viewTicketPage.controlPanel.getText() , "Control Panel");
}
}
