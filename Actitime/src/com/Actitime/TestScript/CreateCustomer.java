package com.Actitime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibraryClass;
import com.Actitime.GenericLibrary.ListnerImplimentation;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

@Listeners(ListnerImplimentation.class)

public class CreateCustomer extends BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	public void creatCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasktab().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewcust().click();
		tp.getNewcust().click();
		FileLibraryClass f=new FileLibraryClass();
		String name = f.readDatafromExcel("Sheet1", 5, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readDatafromExcel("Sheet1", 5, 2);
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatecust().click();
		
     	String expectedresult = name;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
		s.assertAll();
	}

}
