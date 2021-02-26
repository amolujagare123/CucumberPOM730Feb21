package Project.StepDefinitions;

import Project.pages.HotelsSearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;

public class HotelsSD {

    HotelsSearchResultPage hotelsSearchResultPage = new HotelsSearchResultPage();
    @Given("^I am on hotels.com home page$")
    public void i_am_on_hotelscom_home_page() throws Throwable {

        String expected ="Hotels.com India";
        String actual = SharedSD.getDriver().getTitle();
        Assert.assertEquals(actual,expected,
                "We are not on the hotels.com page");
    }

    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String dealPrice)
             {

                 int dealPriceActual = hotelsSearchResultPage.getDealPrice();
                 System.out.println("dealPriceActual="+dealPriceActual);

                 int dealPriceExpected = Integer.parseInt(dealPrice);
                 System.out.println("dealPriceExpected="+dealPriceExpected);

                 boolean result =  ( dealPriceActual < dealPriceExpected);

                 Assert.assertTrue(result,"deal price is greater than expected price ");


    }

    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of airport$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_airport(String expectedRangeStr) throws Throwable {

        Double expectedRange = Double.parseDouble(expectedRangeStr);

        ArrayList<Double> distList = hotelsSearchResultPage.getAirportDistList();


        boolean flag = true;

        ArrayList<Double> greaterDistList = new ArrayList<>();
        for (int i=0;i<distList.size();i++)
        {
            if(distList.get(i)>expectedRange)
            {
                flag=false;
                greaterDistList.add(distList.get(i));
            }
        }

        Assert.assertTrue(flag,"some distances are greater than:"+expectedRange+
                "\n those are:"+greaterDistList);

    }

    @And("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String expectedHotel)  {

        ArrayList<String> hotelsList = hotelsSearchResultPage.getHotelsNames();

        boolean flag = false;

        for(int i=0;i<hotelsList.size();i++)
        {
            System.out.println(hotelsList.get(i));

            if(hotelsList.get(i).contains(expectedHotel))
                flag =true;
        }

        Assert.assertTrue(flag,expectedHotel
                +":This hotel is not present in the search result");
    }
}
