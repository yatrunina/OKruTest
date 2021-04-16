import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExistChecker {

    public static boolean checkExist(WebElement element, String path){
        try {
            element.findElement(By.xpath(path));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public static boolean checkExist(WebDriver driver, String path){
        try{
            driver.findElement(By.xpath(path));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
}
