package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessChrome {

	WebDriver driver;
	
	@Test
	public void HeadlessChrome_Test_1()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");

		//driver = new ChromeDriver();
		
		ChromeOptions cOptions=new ChromeOptions();
		cOptions.setHeadless(true);
		driver=new ChromeDriver(cOptions);
		
		driver.get("https://google.com");
		String title=driver.getTitle();
		System.out.println(title);
	}
	
}
