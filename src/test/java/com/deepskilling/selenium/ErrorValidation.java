package com.deepskilling.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErrorValidation {

public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.lambdatest.com/register");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tomsmith@gmail.com");
		driver.findElement(By.id("userpassword")).sendKeys(" ");
		driver.findElement(By.xpath("//button[@data-amplitude='R_signup']")).click();
		String errorMessage=driver.findElement(By.xpath("//p[@data-testid='errors-password']")).getText();
		System.out.println("Error message is:"+errorMessage);
//		System.out.println(driver.getTitle());
//		driver.quit();
	}

}
