import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private String pageURl = "https://ok.ru/";

    String loginPATH = "field_email";
    String passwordPATH = "field_password";

    WebDriver driver;

    LoginPage(WebDriver driver){

        this.driver =driver;
        driver.get(pageURl);

        check();
    }

    // TODO нужно проверить, что загрузились основные элементы страницы.
    //  Например, мы не уверены, найдутся ли на странице поля, которые используем в методе логина

    private void check(){

    }

    public UserPage logIn(String username, String password){

        driver.findElement(By.id(loginPATH)).clear();
        driver.findElement(By.id(loginPATH)).sendKeys(username);
        driver.findElement(By.id(passwordPATH)).clear();
        driver.findElement(By.id(passwordPATH)).sendKeys(password);
        //TODO мой браузер в русской локали не нашел этот элемент по английскому названию локатора
        driver.findElement(By.xpath("//input[@value='Log in to OK']")).click();

        return new UserPage(driver);
    }
}
