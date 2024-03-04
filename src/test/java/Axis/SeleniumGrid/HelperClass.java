package Axis.SeleniumGrid;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
 
public class HelperClass {
 
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static String remote_url = "http://192.168.233.91:4444";
	public Capabilities capabilities;
 
	@Parameters({ "browser" })
	@BeforeMethod
	public void setDriver(String browser) throws MalformedURLException {
 
		System.out.println("Test is running on " + browser);
 
		if (browser.equals("chrome")) {
		capabilities = new ChromeOptions();
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\athar\\OneDrive\\Documents\\Manipal\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//			  WebDriver driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
//			System.setProperty("webdriver.edge.driver","C:\\Users\\athar\\OneDrive\\Documents\\Manipal\\edgedriver_win64\\msedgedriver.exe");
//			  WebDriver driver = new EdgeDriver();
		capabilities = new EdgeOptions();
		}else if (browser.equals("gecko")) {
			capabilities = new FirefoxOptions();
		}
 
		driver.set(new RemoteWebDriver(new URL(remote_url), capabilities));
		driver.get().get("https://opensource-demo.orangehrmlive.com/");
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
	}
 
	public WebDriver getDriver() {
		return driver.get();
	}
 
	@AfterMethod
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}
 
}