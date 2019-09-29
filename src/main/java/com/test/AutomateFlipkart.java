package com.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomateFlipkart {

	public static String path=System.getProperty("user.dir");
	public static WebDriver driver;
	public static String driverPathChrome = "C:\\Users\\Waheguru\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing\\driver\\chromedriver.exe";
	public static String driverPathFirefox = "C:\\Users\\Waheguru\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing2\\driver\\geckodriver.exe";
	public static String sBookKey = "Java";
	private static final String sBookName = "(//a[contains(.,'" + sBookKey + "')])[last()]";

	@BeforeTest
	@Parameters("browser")
	public static void initWebDriver(String browser) throws InterruptedException, IOException {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPathChrome);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPathFirefox);
			driver = new FirefoxDriver();
		}
		driver.get(GetConfig.getData("Environment"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void searchBox() throws FindFailed {
		Screen screen = new Screen();
		Pattern searchBox = new Pattern("C:\\Users\\Waheguru\\Desktop\\img\\search.png");
		screen.type(searchBox, "Java");
	}
	
	
	@Test(priority=3)
	public void takeScreenShot() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path+"screenshot2.png"));
		System.out.println(path+"screenshot.png");
	}

	@AfterTest
	public static void process() throws InterruptedException {

		Actions action = new Actions(driver);

		WebElement elementClick = driver.findElement(By.xpath("//button[@class=\"vh79eN\"]"));

	
		
		Action build = action.click(elementClick).build();

		build.perform();
		
		

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sBookName))).click();

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(newTab.get(1));

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class=\"_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c\"]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"_2AkmmA _I6-pD _7UHT_c\"]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"_2AkmmA _2Q4i61 _7UHT_c\"]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[4]/div[2]/div/div/div"))).click();

	}
	
	@Test(priority = 1)
	public static void flipkartLogin() throws IOException, InterruptedException {

		// TBD: Fill your username/password of flipkart.
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"))
				.sendKeys(ReadExcelData.readCredentials_Second());
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"))
				.sendKeys(ReadExcelData.readCredentials_Second1());
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TBD: Auto-generated catch block.
			e.printStackTrace();
		}
	}

}
