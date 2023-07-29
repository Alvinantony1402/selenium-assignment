package LamdaDemo;


	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.HashMap;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	public class slider {
		RemoteWebDriver driver;
		@BeforeTest
		public void Setup1() {
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
			ltOptions.put("name", "testcase2");
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
	public void MyTest1(){
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//*[@id=\"slider3\"]/h4"));
		WebElement Slider = driver.findElement(By.xpath("//*[@id=\"slider3\"]/div/input"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(Slider, 215, 0).perform();
		
		
	}
	@AfterTest
	
	public void Dropdown1() {
		driver.close();
	}
	
	}
