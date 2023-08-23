package com.deepskilling.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGrid {
	
	WebDriver driver;
	WebElement srchBox;
  @Test
  public void remoteTest() throws MalformedURLException {
	  
	  ChromeOptions options = new ChromeOptions();
	  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	  options.setCapability(CapabilityType.BROWSER_VERSION, "116");
	  
	  String strhub = "";
	  driver = new RemoteWebDriver(new URL(strhub),options);
	  
	  driver.get("https://www.google.com");
	  srchBox = driver.findElement(By.name("q"));
	  srchBox.sendKeys("cypress tutorial");
	  srchBox.sendKeys(Keys.ENTER);
	  System.out.println("Page title is----->"+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "cypress tutorial - Google Search");
	  
	  
  }
}
