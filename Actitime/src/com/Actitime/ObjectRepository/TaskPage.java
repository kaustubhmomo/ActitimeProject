package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	//declaration
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addnewbutton;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcustm;
	
	@FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
	private WebElement customername;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement entercustmdescrip;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createcustm;
	
	@FindBy(xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement cancelbtn;
	
	//initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
//utilization
	public WebElement getAddnewbutton() {
		return addnewbutton;
	}

	public WebElement getNewcustm() {
		return newcustm;
	}

	public WebElement getCustomername() {
		return customername;
	}

	public WebElement getEntercustmdescrip() {
		return entercustmdescrip;
	}

	public WebElement getCreatecustm() {
		return createcustm;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

}
