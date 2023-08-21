package com.deepskilling.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

public class HandlingIFrames {
	
WebDriver driver;
	
	@BeforeMethod
	public void init() {
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		//System.out.println(driver.getTitle());
//		driver.switchTo().frame(0);
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("value");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("after switching to parent");
		driver.switchTo().defaultContent();
		String textIs = driver.findElement(By.xpath("//label/span")).getText();
		System.out.println("Current frame is:"+textIs);
		driver.switchTo().frame("frame2");
		Select dropDownValue = new Select(driver.findElement(By.id("animals")));
		dropDownValue.selectByIndex(1);
}

}
