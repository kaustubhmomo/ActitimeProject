package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;

public class Task extends BaseClass {
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getTasktab().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbutton().click();
		tp.getNewcustm().click();
		
		FileLibrary f = new FileLibrary();
		String createcustomer = f.readDataFromExcel("Sheet1", 1, 1);
		tp.getCustomername().sendKeys(createcustomer);
		String description = f.readDataFromExcel("Sheet1", 2, 2);
		tp.getEntercustmdescrip().sendKeys(description);
		tp.getCreatecustm().click();
		String expextedresult = createcustomer;
		 actualresult = driver.findElement(By.xpath("(//div[.=+createcustomer+]"));

		
		
		
	}
	

}
