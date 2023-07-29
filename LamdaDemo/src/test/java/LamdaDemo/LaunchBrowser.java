package LamdaDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LaunchBrowser{
	RemoteWebDriver driver;
	@BeforeTest
	public void Setup() {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability("browserName", "Chrome");
	     capabilities.setCapability("browserVersion", "114.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "LT_USERNAME");
		ltOptions.put("accessKey", "LT_ACCESS_KEY");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("project", "Untitled");
		ltOptions.put("name", "testcase1");
		ltOptions.put("console", "true");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		capabilities.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(driver);
	}
	@Test
	public void MyTest(){
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("user-message")).sendKeys("Welcome to LambdaTest");
		driver.findElement(By.id("showInput")).click();
		String text = driver.findElement(By.id("message")).getText();
		
		System.out.println(text);
	}
	@AfterTest
	
	public void Dropdown() {
		driver.close();
	}
	
}
