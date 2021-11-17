package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import utilities.ExcelRead;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	
	
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	/*
	 * ExcelRead d = new ExcelRead("C:\\testing\\NikulTest.xlsx"); String wrongEmail
	 * = d.getCellData("Data1", "UserName", 3); String wrongPassword =
	 * d.getCellData("Data1", "Password", 2); String invalidEmail =
	 * d.getCellData("Data1", "UserName", 4); String globalErr =
	 * d.getCellData("Data1", "Global Error", 2);
	 * //"Please check your card number / username or password and try again.";
	 * String emptyEmailErr = d.getCellData("Data1", "Email Error", 4);
	 * //"Please enter your username or card number."; String emptyPasswordErr =
	 * d.getCellData("Data1", "Password Error", 3); //"Please enter your password.";
	 * String emailWithSpeCharErr = d.getCellData("Data1", "Email Error", 5);
	 * //"Please enter a username or card number without special characters.";
	 */
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
	  lp.openBrowesr();
	  lp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException 
  {
	  lp.closeBrowser();
  }
  
	@Test(priority = 1)
	public void loginWithWrongEmailPasswordTest() throws InterruptedException 
	{
		lp.login(df.wrongEmail,df.wrongPassword);
		Assert.assertEquals(lp.readGlobalErr(), df.globalErr);
	}

	@Test(priority = 2)
	public void loginWithEmptyEmailTest() throws InterruptedException 
	{
		lp.login("",df.wrongPassword);
		Assert.assertEquals(lp.readLocalErr(), df.emptyEmailErr);
	}

	@Test(priority = 3)
	public void loginWithEmptyPasswordTest() throws InterruptedException 
	{
		lp.login(df.wrongEmail,"");
		Assert.assertEquals(lp.readLocalErr(), df.emptyPasswordErr);
	}

	@Test(priority = 4)
	public void loginWithInvalidEmailTest() throws InterruptedException
	{
		lp.login(df.invalidEmail, df.wrongPassword);
		Assert.assertEquals(lp.readLocalErr(), df.emailWithSpeCharErr);
	}
}
