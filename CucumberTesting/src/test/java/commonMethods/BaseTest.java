package commonMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	public static WebDriver driver=null;
	
	public static final String URL = "https://www.google.com/";
	
	  public void BrowserInitialization() {
	    	ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-download-notification");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.plugins", 1);
			prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
			prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver", System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe"));
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


	    }
	  
	  public void NavigateToURL(String URL) {
			driver.manage().window().maximize();
			driver.get(URL);
	  }
}
