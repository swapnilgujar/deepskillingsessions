package com.deepskilling.selenium;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadExternalFile {
	
	WebDriver driver;
	Properties properties;
	String getURL;
	String propertyPath;
	String testDataPath;
	String arrOfTestData[];
	CSVReader csvReader;
	ArrayList<Object> dataList;
	
	@BeforeMethod
	public void init() throws IOException {
		
		propertyPath = System.getProperty("user.dir")+ "//src//test//config//config.properties";
		FileInputStream fis =  new FileInputStream(propertyPath);
		
		properties = new Properties();
		properties.load(fis);
		String strBrowser = properties.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();	
		}
		getURL = properties.getProperty("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@DataProvider(name = "loginData")
	public Object[][] readData() throws CsvValidationException, IOException{
		
		testDataPath = System.getProperty("user.dir")+ "//src//test//testdata//logindata.csv";
		
		csvReader = new CSVReader(new FileReader(testDataPath));
		dataList = new ArrayList<Object>();
		while((arrOfTestData=csvReader.readNext()) !=null){
			Object [] testData = {arrOfTestData[0],arrOfTestData[1]};
			dataList.add(testData);
		}
		return dataList.toArray(new Object[dataList.size()][]);
	}
		
	@Test(dataProvider = "loginData", retryAnalyzer = RetryAnalyzer.class)
	public void readPropertyFile(String username, String password) {
		
		driver.get(getURL);
		System.out.println("Executing for......"+username);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='radius']")).click();
		//System.out.println(driver.getCurrentUrl());
		String welcomeMessage = driver.findElement(By.xpath("//h4")).getText();
		Assert.assertEquals(welcomeMessage, "Welcome to the Secure Area. When you are done click logout below.");
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}
