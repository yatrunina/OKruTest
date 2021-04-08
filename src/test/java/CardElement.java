import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardElement {

    WebElement card;

    String IMAGE_XPATH = ".//img[contains(@class,\"photo_img\")]";



    CardElement(WebElement card){
        this.card = card;
    }


    public boolean IMGexist(){
        return card.findElements(By.xpath(IMAGE_XPATH)).size() == 1;
    }

}
