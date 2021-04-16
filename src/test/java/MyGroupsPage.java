import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyGroupsPage {
    WebDriver myGroups;

    String ONLYMYGROUPS_XPATH = ".//div[@id=\"listBlockPanelDetailedUserGroupsListBlock\"]";

    MyGroupsPage(WebDriver driver){
        this.myGroups = driver;
    }


    public OnlyMyGroupsSubpage getMyGroupsSubpage(){

        if(!ExistChecker.checkExist(myGroups, ONLYMYGROUPS_XPATH)){
            return  null;
        }
        return  new OnlyMyGroupsSubpage(myGroups.findElement(By.xpath(ONLYMYGROUPS_XPATH)));
    }

}
