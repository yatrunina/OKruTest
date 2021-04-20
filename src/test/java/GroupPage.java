import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupPage {

    WebDriver driver;

    String GROUPCARD_XPATH = ".//div[contains(@data-l,\"groupId\")]";
    String AUTO_XPATH = ".//a[contains(@data-l,\"t,automoto\")]";
    String MYGROUPS_PATH = ".//a[text()='Мои группы']";

    String AUTOMOTO_URL = "https://ok.ru/groups/automoto";
    String MYGROUPS_URL = "/groups/mine";

    GroupPage(WebDriver driver){
        this.driver = driver;
    }

    // TODO check()  нет, хорошо бы написать

    //TODO automoto было бы логичней передавать в метод, а не задавать в пейдже.
    // Тогда будет универсальный метод для разных категорий
    public void selectCategory(){
        driver.findElement(By.xpath(AUTO_XPATH)).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.urlToBe(AUTOMOTO_URL));
    }

    public List<CardElement> getGroupsList(){

        return (driver.findElements(By.xpath(GROUPCARD_XPATH)))
                .stream()
                .map(webElement->new CardElement(webElement))
                .collect(Collectors.toList());
    }

    public MyGroupsPage selectMyGroups(){
        driver.findElement(By.xpath(MYGROUPS_PATH)).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.urlContains(MYGROUPS_URL));

        return new MyGroupsPage(driver);
    }
}
