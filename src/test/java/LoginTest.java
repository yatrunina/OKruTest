import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginTest extends BaseTest{


    String username = "79267612747";
    String password = "ksdjfnjsdfnksdlf23r423n";

    List<CardElement> groupList;


    @Test
    public void start(){

        UserPage userPage = new LoginPage(this.driver).logIn(username, password);
        GroupPage group = userPage.moveToGroups();

        group.selectCategory(); //need to wait



        groupList = group.getGroupsList();

        Assert.assertTrue("Cards not found", groupList.size() != 0);

        for(CardElement card : groupList){
            //System.out.println(webElement.getText());
            Assert.assertTrue("Image not loaded", card.IMGexist());
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        this.driverExit();
    }

}
