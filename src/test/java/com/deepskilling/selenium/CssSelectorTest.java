package com.deepskilling.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorTest {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://globalsqa.com/samplepagetest");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#g2599-name")).sendKeys("css selector");
		driver.close();
	}

}
