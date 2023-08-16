package com.deepskilling.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingPopUp {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.stqatools.com/demo/Windows.php");
		System.out.println(driver.getTitle());
		String windowHandleName = driver.getWindowHandle();
		System.out.println("Parent window name is:"+windowHandleName);
		driver.findElement(By.xpath("//button[contains(text(),' Click to open new Tab ')]")).click();
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println("Total open windows are:"+childWindow.size());
//		for(int i=0;i<windowHandles.size();i++) {
//			System.out.println("Window name is:\n"+windowHandles);
//		}
		for(String handleName:childWindow) {
			System.out.println("Window name is:"+handleName);
		}
		//driver.close();
	}

}
