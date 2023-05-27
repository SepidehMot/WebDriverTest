package test;

import java.time.Duration;

//import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
public class DriverLifeCycleSetting {
	protected WebDriver driver;

	@BeforeAll
	public static void BeforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void BeforeEach() {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	@AfterEach
	public void AfterEach() {
		if (driver != null)
			driver.quit();
	}
}
