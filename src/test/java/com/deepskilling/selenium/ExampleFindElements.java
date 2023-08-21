package com.deepskilling.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ExampleFindElements {
	
WebDriver driver;
	
	@BeforeMethod
	public void init() {
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static void main(String [] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("APjFqb")).sendKeys("java tutorial");
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='G43f7e']//li"));
		System.out.println("number of elements are:"+elements.size());
		for(int i= 0;i<elements.size();i++) {
			System.out.println("List elements are:"+elements.get(i).getText());
			if(elements.get(i).getText().equalsIgnoreCase("java tutorial pdf")) {
				elements.get(i).click();
				System.out.println("page title is:"+driver.getTitle());
				break;
			}
		}
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}
