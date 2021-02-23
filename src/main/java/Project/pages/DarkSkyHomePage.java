package Project.pages;

import Project.StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class DarkSkyHomePage extends  Base{

    By currentTempRow = By.xpath("//span[@class='summary swap']");
    // 76˚ Clear.
    By timeLineTempRow = By.xpath("//span[@class='first']//span");
    // 78°

    By timeListRow = By.xpath("//a[@data-day='0']//span[@class='toggle']");

   // By timeListRow = By.xpath("//div[@id='week']/a[1]/span[@class='toggle']");


    By expanderToday = By.xpath("//a[@data-day='0']");


    By minTempBar = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    By maxTempBar = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");

    By timeLineTemListRow = By.xpath("//div[contains(@class,'revealed')]//span[@class='temp']");

    By darkSkyAPILink = By.xpath("//a[normalize-space()='Dark Sky API']");

    public  void clickDarkSkyAPILink()
    {
        clickOn(darkSkyAPILink);
    }

    public ArrayList<String> getBarTempList()
    {
        ArrayList<String> tempList = new ArrayList<>();

        String minTemp = getElementTextList(timeLineTemListRow).get(0).split("˚")[0];
        String maxTemp = getElementTextList(timeLineTemListRow).get(1).split("˚")[0];

        tempList.add(minTemp);
        tempList.add(maxTemp);

        System.out.println(tempList);
        return tempList;
    }


    public ArrayList<String> getTimeTempList()
    {
        ArrayList<String> tempList = new ArrayList<>();

        String minTemp = getTextFromElement(minTempBar).split("˚")[0];
        String maxTemp = getTextFromElement(maxTempBar).split("˚")[0];

        tempList.add(minTemp);
        tempList.add(maxTemp);

        System.out.println(tempList);
        return tempList;
    }




    public void clickExpanderToday()
    {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(0,800)");

        clickOn(expanderToday);
    }


    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> timeListStr = getElementTextList(timeListRow);

        System.out.println(timeListStr);

        ArrayList<Integer> timeList = new ArrayList<>();

        for(int i=0;i<timeListStr.size();i++)
        {
            String timeRow = timeListStr.get(i);
            int l = timeRow.length();
            String timeStr = timeRow.substring(0,l-2);
            int time = Integer.parseInt(timeStr);
            timeList.add(time);
        }

        System.out.println(timeList);

        return timeList;
    }

    public String getCurrTemp()
    {
       String rowTemp =  getTextFromElement(currentTempRow);
        // 76˚ Clear.
        String tempStr = rowTemp.split("˚")[0]; //--> "76"

        return  tempStr; // 76
    }

    public String getTimelineTemp()
    {
        String rowTemp =  getTextFromElement(timeLineTempRow);
        // 76˚ Clear.
        String tempStr = rowTemp.split("°")[0]; //--> "78"

        return  tempStr; // 76
    }

}
