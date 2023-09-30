package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//initialization
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath="//div[.='Reports']")
	private WebElement reportstab;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement usertab;
	
	@FindBy(id="logoutLink")
	private WebElement logoutlink;
	
	//declaration
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	//Utilization
	public WebElement getTasktab() {
		return tasktab;
	}

	public WebElement getReportstab() {
		return reportstab;
	}

	public WebElement getUsertab() {
		return usertab;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	
}
