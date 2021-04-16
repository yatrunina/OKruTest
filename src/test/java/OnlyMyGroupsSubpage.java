import org.openqa.selenium.WebElement;

public class OnlyMyGroupsSubpage {
    WebElement myGroupsSubpage;

    OnlyMyGroupsSubpage(WebElement element){
        this.myGroupsSubpage = element;
    }

    public boolean findGroupByHref(String href){
        String START_XPATH = ".//a[@href=\"";
        START_XPATH += (href + "\"]");

        return ExistChecker.checkExist(myGroupsSubpage, START_XPATH);
    }
}
