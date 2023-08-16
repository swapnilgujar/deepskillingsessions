package com.deepskilling.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions mouseHover = new Actions(driver);
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement ageTextbox = driver.findElement(By.xpath("//input[@id='age']"));
		ageTextbox.sendKeys(Keys.PAGE_DOWN);
		mouseHover.moveToElement(ageTextbox).perform();
		String toolTipText = driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText();
		System.out.println(toolTipText);
		
	}
}
