package Project.pages;

import Project.StepDefinitions.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResultPage extends Base{

    By starProperty = By.xpath("//span[contains(@class,'star-rating-text')]");

    By dealPriceLabel = By.xpath("//li[contains(@class,'deal-of-the-day')]//ins");


    public int getDealPrice()
    {
        String priceRow = getTextFromElement(dealPriceLabel);
        // Rs3,200

        String priceWithoutRS = priceRow.substring(2); // 3,200

        String priceWithoutComma ="";

        for(int i=0;i<priceWithoutRS.length();i++)
        {
            if(priceWithoutRS.charAt(i)!=',')
            {
                priceWithoutComma = priceWithoutComma + priceWithoutRS.charAt(i);
            }
        }//  priceWithoutComma = 3200


       return Integer.parseInt(priceWithoutComma);

    }



    public ArrayList<String> getStarList()
    {
        return getElementTextList(starProperty);
    }



    public void clickStar(String star)
    {
        SharedSD.getDriver()
                .findElement(By.xpath("//input[@id='f-star-rating-"+star+"']"))
                .click();
    }
}
