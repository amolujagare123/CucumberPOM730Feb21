package Project.StepDefinitions;

import Project.pages.HotelsSearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

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
}
