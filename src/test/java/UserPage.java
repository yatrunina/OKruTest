import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {

    WebDriver driver;

    String GROUP_PATH = ".//a[@data-l=\"t,userAltGroup\"]";
    String GROUPS_URL = "/groups";

    UserPage(WebDriver driver){
        this.driver = driver;

        check();
    }

    protected void check(){

    }


    public GroupPage moveToGroups(){

        driver.findElement(By.xpath(GROUP_PATH)).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.urlContains(GROUPS_URL));
        return new GroupPage(driver);
    }
}
