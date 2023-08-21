package com.deepskilling.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
@Test	
public  void firstTestCase() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://globalsqa.com/samplepagetest");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#g2599-name")).sendKeys("css selector");
		driver.quit();
	}

@AfterMethod
public void closeDriver() {
	driver.close();
}
}