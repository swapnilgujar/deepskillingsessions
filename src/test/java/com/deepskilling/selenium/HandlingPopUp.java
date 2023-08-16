package com.deepskilling.selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingPopUp {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.stqatools.com/demo/Windows.php");
		System.out.println(driver.getTitle());
		String parentHandleName = driver.getWindowHandle();
		System.out.println("Parent window name is:"+parentHandleName);
		driver.findElement(By.xpath("//button[contains(text(),' Click to open new Tab ')]")).click();
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println("Total open windows are:"+childWindow.size());
//		for(int i=0;i<windowHandles.size();i++) {
//			System.out.println("Window name is:\n"+windowHandles);
//		}
		for(String handleName:childWindow) {
			System.out.println("Window name is:"+handleName);
			if(!handleName.equalsIgnoreCase(parentHandleName)) {
				driver.switchTo().window(handleName);
				driver.findElement(By.xpath("//span[contains(text(),'Java')]")).click();
				//System.out.println(driver.getTitle());
			}
			//driver.close();
		}
		driver.switchTo().window(parentHandleName);
		driver.findElement(By.xpath("//button[contains(text(),' Click to open new Window ')]")).click();
		System.out.println("CLICKED!!!!!!!!");
		//driver.quit();
	}

}
