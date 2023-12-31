package keyWordDriverFramework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest extends Flib implements IautoConstant {
	static WebDriver driver;
	public void openBrowser() throws IOException {
		Flib flib= new Flib();
		 String browservalue = flib.readDataFromProperty(PROP_PATH,"Browser");
		 String url = flib.readDataFromProperty(PROP_PATH,"url");
		 if(browservalue.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(browservalue.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
				
			}
			else if(browservalue.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else {
				System.out.println("Invalid BrowserValue!!!");
			}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(url);
	}
       public void closeBrowser()
       {
             driver.quit();
    	   
}
}
