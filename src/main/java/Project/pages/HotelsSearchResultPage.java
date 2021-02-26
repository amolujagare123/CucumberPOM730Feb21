package Project.pages;

import Project.StepDefinitions.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResultPage extends Base{

    By starProperty = By.xpath("//span[contains(@class,'star-rating-text')]");

    By dealPriceLabel = By.xpath("//li[contains(@class,'deal-of-the-day')]//ins");

    By distanceAirPortTxt = By.xpath("//div[contains(@class,'location-info')]//li[2]");

    By hotelsNames = By.xpath("//h3[@class='p-name']/a");




    public ArrayList<String> getHotelsNames()
    {
        return getElementTextList(hotelsNames);
    }


    public ArrayList<Double> getAirportDistList()
    {

        ArrayList<String> distTxtList =getElementTextList(distanceAirPortTxt);

        ArrayList<Double> distList = new ArrayList<>();

        for(int i=0;i<distTxtList.size();i++)
        {
            //1.9 km to Chhatrapati Shivaji International Airport (BOM)
            String distStr = distTxtList.get(i).split(" ")[0];
            distList.add(Double.parseDouble(distStr));
        }

        System.out.println(distList);
        return distList;

    }


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
