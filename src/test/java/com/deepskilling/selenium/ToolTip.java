package com.deepskilling.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTip {
	
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
		driver.manage().window().maximize();
		Actions mouseHover = new Actions(driver);
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement ageTextbox = driver.findElement(By.xpath("//input[@id='age']"));
		ageTextbox.sendKeys(Keys.PAGE_DOWN);
		mouseHover.moveToElement(ageTextbox).perform();
		String toolTipText = driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText();
		System.out.println(toolTipText);
		
	}

@AfterMethod
public void closeDriver() {
	driver.close();
}
}

