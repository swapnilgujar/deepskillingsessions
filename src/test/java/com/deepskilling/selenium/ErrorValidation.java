package com.deepskilling.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ErrorValidation {
	
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

public static void firstTestCaseError() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.lambdatest.com/register");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tomsmith@gmail.com");
		driver.findElement(By.id("userpassword")).sendKeys(" ");
		driver.findElement(By.xpath("//button[@data-amplitude='R_signup']")).click();
		String errorMessage=driver.findElement(By.xpath("//p[@data-testid='errors-password']")).getText();
		System.out.println("Error message is:"+errorMessage);
//		System.out.println(driver.getTitle());
	}

@AfterMethod
public void closeDriver() {
	driver.close();
}

}

