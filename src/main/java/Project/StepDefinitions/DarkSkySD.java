package Project.StepDefinitions;

import Project.pages.DarkSkyHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;

public class DarkSkySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page() throws Throwable {

    String expected ="Dark Sky - Sansad Marg, New Delhi, Delhi";
    String actual = SharedSD.getDriver().getTitle();
        Assert.assertEquals(actual,expected,
                "We are not on the darksky homepage");


    }

    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline()
             {
              String expected =  darkSkyHomePage.getCurrTemp();
              String actual = darkSkyHomePage.getTimelineTemp();
                 System.out.println("expected="+expected);
                 System.out.println("actual="+actual);
              Assert.assertEquals(actual,expected);
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()
             {
                 ArrayList<Integer> timeList = darkSkyHomePage.getTimeList();
                 ArrayList<Integer> timeDiffList = new ArrayList<>();

                 for(int i=0;i<timeList.size()-1;i++) // 0 -- 10
                  {
                   int time1 = timeList.get(i);
                   int time2 = timeList.get(i+1);
                   int timeDiff = 0;

                   if(time2>time1)
                      timeDiff = time2 - time1;
                   else if(time2<time1)
                       timeDiff = (12+time2) - time1;

                   timeDiffList.add(timeDiff);
               }

                 System.out.println(timeDiffList);

                 int size = timeDiffList.size();
                 int occurance = Collections.frequency(timeDiffList,2);

                 boolean result = (size == occurance); // true /false

                 Assert.assertTrue(result,"all differences are not 2");


    }

    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly()
            {
                darkSkyHomePage.clickExpanderToday();
                System.out.println("Expected Temp =");
                ArrayList<String> expected = darkSkyHomePage.getBarTempList();

                System.out.println("Actual Temp =");
                ArrayList<String> actual = darkSkyHomePage.getTimeTempList();
                Assert.assertEquals(actual,expected);

            }

}
