import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {

    WebDriver driver;

    String GROUP_PATH = ".//a[@data-l=\"t,userAltGroup\"]";


    UserPage(WebDriver driver){
        this.driver = driver;

        check();
    }

    protected void check(){

    }


    public GroupPage moveToGroups(){

        driver.findElement(By.xpath(GROUP_PATH)).click();

        return new GroupPage(driver);
    }
}
