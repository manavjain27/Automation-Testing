package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class TestHeadless {

	WebDriver driver;
	
	
	@Test
	public void HeadlessBrowser_Test()
	{
		driver=new HtmlUnitDriver();
		driver.get("https://google.com");
		String title=driver.getTitle();
		System.out.println(title);
		
	}
}
