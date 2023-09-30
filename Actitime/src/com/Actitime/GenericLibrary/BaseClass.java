// Base class is super most class present in Automation projrct
// it is used to create per condition and post condition for project.
package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.ActitimeLoginPage;


public class BaseClass {
	FileLibraryClass f=new FileLibraryClass();
	public static WebDriver driver;
	@BeforeSuite
	public void DataBaseConnection()
	{
		Reporter.log("Data Base Connected",true);
	}
	@BeforeClass
	public void LaunchBrowser() throws IOException 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = f.readDatafromPropertyFile("url");
		driver.get(URL);
		Reporter.log("browser launch successfully");
	}
	@BeforeMethod
	public void LoginToActitime() throws IOException {
		ActitimeLoginPage l=new ActitimeLoginPage(driver);
		String username = f.readDatafromPropertyFile("username");
		l.getUntbx().sendKeys(username);
		String PWD = f.readDatafromPropertyFile("password");
		l.getPwtbx().sendKeys(PWD);
		l.getLgbtn().click();
		Reporter.log("logged in successfully");
	}
	@AfterMethod
	public void LogOutToActitime() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out successfully");
	}
	@AfterClass
	public void CloseBrowser() {
		driver.close();
		Reporter.log("Browser Close successfully");
	}
	@AfterSuite
	public void DataBaseDisconnected() {
		Reporter.log("Data Base disconnected");
	}
	
}
