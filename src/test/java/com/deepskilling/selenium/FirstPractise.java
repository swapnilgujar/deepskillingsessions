package com.deepskilling.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstPractise {
	
	WebDriver driver = null;
	Properties properties;
	String getURL;
	String propertyPath;
	String uRL;
	String strUserName;
	String strPassword;
	
	
	
	@BeforeMethod
	public void init() throws IOException {
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		propertyPath = System.getProperty("user.dir")+ "//src//test//config//config.properties";
		FileInputStream fis =  new FileInputStream(propertyPath);
		
		properties = new Properties();
		properties.load(fis);
		uRL = properties.getProperty("newURL");
		strUserName = properties.getProperty("username");
		strPassword = properties.getProperty("password");
		
	}
	
	@Test
	public void createAccount(String uRL,String userName, String passWord) {
		
		driver.get(uRL);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		
		
	}
	

}
