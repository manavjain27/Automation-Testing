package com.test;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Flipkart {
	public static WebDriver driver;

	@Test(priority = 1)
	public void browser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	public static void flipkartLogin() throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"))
				.sendKeys("7898921019");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"))
				.sendKeys("Anushree@21");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		
	
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void searchBox() throws FindFailed, InterruptedException {
		Screen screen = new Screen();
		Pattern searchBox = new Pattern("C:\\Users\\Waheguru\\Desktop\\img\\search.png");
		screen.type(searchBox, "Java");
		Thread.sleep(3000);
		 // Switching to Alert        
      Alert alert = driver.switchTo().alert();	
      alert.sendKeys("fjanfjnsj");
      		
      // Capturing alert message.    
      String alertMessage= driver.switchTo().alert().getText();		
      		
      // Displaying alert message		
   
      Thread.sleep(5000);
      		
      // Accepting alert		
      alert.accept();	
	}

	
	
	/*
	 * @Test public void sikuliMethod() throws FindFailed { Screen screen = new
	 * Screen(); Pattern cart = new
	 * Pattern("C:\\Users\\Waheguru\\Desktop\\img\\cartclick.png");
	 * screen.click(cart); }
	 */
	 

}
