package LamdaDemo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class InputForm {
	RemoteWebDriver driver;
	@BeforeTest
	public void Setup() {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability("browserName", "Chrome");
	     capabilities.setCapability("browserVersion", "114.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "alwinantony1402");
		ltOptions.put("accessKey", "FGZ6Y6YDjM4EwPxHKEuw5LESK2bVVIV9Cz063TmctntTnkLRVM");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("project", "Untitled");
		ltOptions.put("name", "testcase3");
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
		driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.id("name")).sendKeys("abc");
		driver.findElement(By.id("inputEmail4")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("abcde");
        driver.findElement(By.id("company")).sendKeys("abcde");
		driver.findElement(By.id("websitename")).sendKeys("lamdatest");
		WebElement MultiDropDown = driver.findElement(By.name("country"));
		Select countries = new Select(MultiDropDown);
		countries.selectByIndex(3);
		driver.findElement(By.id("inputCity")).sendKeys("kolkata");
		driver.findElement(By.name("address_line1")).sendKeys("agcs house");
		driver.findElement(By.name("address_line2")).sendKeys("efgh house");
		driver.findElement(By.id("inputState")).sendKeys("mumbai");
		driver.findElement(By.id("inputZip")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[6]/button")).click();
        String text1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div/p")).getText();
		System.out.println(text1);



		}
	
	@Test
	public void MyTest1(){
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[6]/button")).click();
		String message = driver.findElement(By.id("name")).getAttribute("validationMessage");
		System.out.println(message);
	}
	
@AfterTest
	
	public void Dropdown() {
		driver.close();
	}


	

}
