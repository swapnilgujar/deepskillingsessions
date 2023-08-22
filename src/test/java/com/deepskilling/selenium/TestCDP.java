package com.deepskilling.selenium;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.emulation.Emulation;
import org.openqa.selenium.devtools.v115.network.Network;
import org.openqa.selenium.devtools.v115.network.model.Headers;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;




public class TestCDP {
	
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
  //@Test
  public void viewPortTest() {
	  Map deviceMetrics = new HashMap() {{
		  put("width",400);
		  put("height",800);
		  put("deviceScaleFactor",50);
		  put("mobile",true);
	  }};
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", 
			  deviceMetrics);
	  driver.get("https://www.selenium.dev");
  }
  
//@Test
 public void getNetworkTraffic() {
	
	devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
	devTools.addListener(Network.requestWillBeSent(),
			entry -> {
				System.out.println("Request URI" + entry.getRequest().getUrl()+ "\n"
						+ "with method:" + entry.getRequest().getMethod()+ "\n"
						+entry.getRequest().getMethod());
			});
	driver.get("https://www.google.com");
	devTools.send(Network.disable());
}

//@Test
public void setGeoLocation() {
	
	devTools.send(Emulation.setGeolocationOverride(
			Optional.of(27.664827),
			Optional.of(-81.515755),
			Optional.of(100))
			);
	driver.get("https://oldnavy.gap.com/stores");
}

@Test
public void basicAuth() {
	devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
	Map<String,Object> headers = new HashMap<>();
	String userName = "admin";
	String password = "admin";
	
	String basicAuth = "Basic" + new String(new Base64().encode(
			String.format("%s:%s", userName,password).getBytes()));
	System.out.println("Auth----->"+basicAuth);
	
	headers.put("Authorisation", basicAuth);
	devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
	
	driver.get("https://the-internet.herokuapp.com/basic_auth");
	String successMesg = driver.findElement(By.cssSelector("div.example p")).getText();
	Assert.assertEquals(successMesg, "Congratulations! You must have the proper credentials.");
}

/*
 * @AfterMethod public void closeDriver() { driver.close(); }
 */
}
