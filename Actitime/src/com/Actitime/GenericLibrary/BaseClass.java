package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.checkerframework.checker.units.qual.h;
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

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	
	FileLibrary f = new FileLibrary();
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	@BeforeClass
	public void launchBrowser() throws IOException {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readDataPropertyFile("url");
		driver.get(url);
		Reporter.log("browser launched",true);
	}
	@BeforeMethod
	public void Login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String UN = f.readDataPropertyFile("username");
		String PW = f.readDataPropertyFile("password");
		lp.getUntbx().sendKeys(UN);;
		lp.getPwtbx().sendKeys(PW);
		lp.getLgbtn().click();
		
		//String un = f.readDataPropertyFile("username");
		//driver.findElement(By.id("username")).sendKeys(un);
		//String pw = f.readDataPropertyFile("password");
		//driver.findElement(By.name("pwd")).sendKeys(pw);
		//driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("logged in successfully",true);
	}
	@AfterMethod
	public void Logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutlink().click();
		//driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully",true);
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed",true);
	}
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected",true);
	}
}
