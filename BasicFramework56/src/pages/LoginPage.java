package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import data.DataFile;

public class LoginPage {
	
	WebDriver driver;
	
	public void openBrowesr() throws IOException 
	{
		
		//Homework
		//read this from properties file
		
		//DataFile df = new DataFile();
		
		FileInputStream f = new FileInputStream("C:\\testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		//System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		String browser = prop.getProperty("browser");//new FirefoxDriver();
		
		if(browser.equals("Firefox")) 
		{
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
		} 
		else if(browser.equals("Chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	}
	
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=7nyZjuYXRII&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiN255Wmp1WVhSSUkiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzMDI2OTUwNiwiaWF0IjoxNjMwMjY4MzA2LCJqdGkiOiJjMGJhMmZmYy0yYzM5LTRmMWItYmUyOC0yMDdmNzBmNzc1ZWMiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.MamyXPOjyR-QZ9lS5hIPWtFhJ1_CM7bBEH0GZfc5kHzfoe4qnag8UbtHSuqms9RFT03mYp3BZkl7yYaT1nHNkFb6eSyEJdfG6ibetam62hhcIZAVSQ5MZCEhRsanrvo7HCoMI5PSmCDE7szzZT2TFDU6TXIP0W6s3HcKLuSjvFxt2Ke6Eo692Rb8y79mdgOAn-cxl0g4gjsy1q-hAXfAcPfTg27yTpibzeDRVw3GPsLRKVJ13i4jGb8OuGIpjXgiWx-x3E2uhazUwiE8LntbuXOcAHX24ypGd8Yea9dVNTau_kiymyTJIhfB4dfJmvH8nQm80GsJ_wYTynivIe4r2g&preferred_environment=");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		driver.findElement(By.id("usernameInput-input")).sendKeys(a);
		driver.findElement(By.name("password")).sendKeys(b);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(2000);
	}
	
	public String readGlobalErr() {
		String actualErr = driver.findElement(By.id("globalError")).getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readLocalErr() {
		String actualErr = driver.findElement(By.className("Error__text")).getText();
		System.out.println(actualErr);
		return actualErr;
	}

}
