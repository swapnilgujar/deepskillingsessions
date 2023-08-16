package com.deepskilling.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutor {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com");
		System.out.println(driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement searchBox = (WebElement) js.executeScript("return document.getElementsByName(\"search\")[0]");
		searchBox.sendKeys("Phone");
		//js.executeScript("history.go()");
		String pageTitle = (String) js.executeScript("return document.title");
		System.out.println("Page title is:"+pageTitle);
		//driver.findElement(By.cssSelector("#g2599-name")).sendKeys("css selector");
		//driver.quit();
	}

}
