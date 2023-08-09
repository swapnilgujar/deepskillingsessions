package com.deepskilling.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSelenium {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://globalsqa.com/samplepagetest");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("g2599-name")).sendKeys("Name");
		driver.findElement(By.id("g2599-email")).sendKeys("test123@test.com");
		driver.findElement(By.id("g2599-website")).sendKeys("https://www.test.com");
		System.out.println(driver.getTitle());
		
		Select dropDownValue = new Select(driver.findElement(By.id("g2599-experienceinyears")));
		dropDownValue.selectByIndex(1);
		
		driver.findElement((By.xpath("//input[@type='checkbox' and @value='Functional Testing']"))).click();
		driver.findElement((By.xpath("//input[@type='radio' and @value='Graduate']"))).click();
		driver.findElement((By.id("contact-form-comment-g2599-comment"))).sendKeys("test comments");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.close();
	}

}
