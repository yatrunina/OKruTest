import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GroupPage {

    WebDriver driver;
    String GROUPCARD_XPATH = ".//div[contains(@data-l,\"groupId\")]";
    String IMAGE_XPATH = ".//img[contains(@class,\"photo_img\")]";
    String AUTO_XPATH = ".//a[contains(@data-l,\"t,automoto\")]";

    String AUTOMOTO_URL = "https://ok.ru/groups/automoto";


    GroupPage(WebDriver driver){
        this.driver = driver;
    }


    public void selectCategory(){
        driver.findElement(By.xpath(AUTO_XPATH)).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.urlToBe(AUTOMOTO_URL));
    }

    public List<WebElement> getGroupsList(){

        return driver.findElements(By.xpath(GROUPCARD_XPATH));
    }

    public boolean IMGexist(WebElement element){
        return element.findElements(By.xpath(IMAGE_XPATH)).size() == 1;
    }
}
