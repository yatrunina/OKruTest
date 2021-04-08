import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    BaseTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Education\\WebDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void driverExit(){
        driver.close();
        driver.quit();
    }
}
