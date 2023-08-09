package com.deepskilling.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://globalsqa.com/samplepagetest");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
