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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class FirstPractise {
	
	WebDriver driver = null;
	Properties properties;
	String getURL;
	String propertyPath;
	String uRL;
	String strUserName;
	String strPassword;
	String testDataPath;
	String arrOfTestData[];
	CSVReader csvReader;
	ArrayList<Object> dataList;
	
	
	@BeforeMethod
	public void init() throws IOException {
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		propertyPath = System.getProperty("user.dir")+ "//src//test//config//config.properties";
		FileInputStream fis =  new FileInputStream(propertyPath);
		
		properties = new Properties();
		properties.load(fis);
		
		uRL = properties.getProperty("newURL");
		strUserName = properties.getProperty("username");
		strPassword = properties.getProperty("password");
	}
	
	@DataProvider(name = "createaccount")
	public Object[][] readData() throws CsvValidationException, IOException{
		
		testDataPath = System.getProperty("user.dir")+ "//src//test//testdata//createaccount.csv";
		
		csvReader = new CSVReader(new FileReader(testDataPath));
		dataList = new ArrayList<Object>();
		while((arrOfTestData=csvReader.readNext()) !=null){
			Object [] testData = {arrOfTestData[0],arrOfTestData[1]};
			dataList.add(testData);
		}
		return dataList.toArray(new Object[dataList.size()][]);
	}
	
	
	@Test(dataProvider = "createaccount")
	public void createAccount(String username,String password) {
		
		driver.get(uRL);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(strUserName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		System.out.println("username-->"+username+"=======password-->"+password);
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(password);
		driver.findElement(By.xpath("//i[@class = 'save icon']")).click();
	}


	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

}
