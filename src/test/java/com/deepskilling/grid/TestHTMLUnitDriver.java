package com.deepskilling.grid;


import java.security.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHTMLUnitDriver {
	HtmlUnitDriver driver;
	WebElement srchBox;
	
  @Test
  public void testHTMLUnitDriver() {
	  
	  driver = new HtmlUnitDriver();
	  driver.get("https://www.google.com");
	  srchBox = driver.findElement(By.name("q"));
	  srchBox.sendKeys("cypress tutorial");
	  srchBox.submit();
	 // srchBox.sendKeys(Keys.ENTER);
	  System.out.println("Page title is----->"+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "cypress tutorial - Google Search");
  }
}
