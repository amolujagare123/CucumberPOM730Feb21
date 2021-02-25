package Project.StepDefinitions;

import Project.pages.HotelsHomePage;
import Project.pages.HotelsSearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class HotelsStarSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();
    HotelsSearchResultPage hotelsSearchResultPage = new HotelsSearchResultPage();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

        hotelsHomePage.setTxtDestination("Mumbai, India");
        hotelsHomePage.clickSearch();
    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {
        // stars = "5 stars"
        hotelsSearchResultPage.clickStar(stars.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars)
    {
        SharedSD.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        ArrayList<String> starList = hotelsSearchResultPage.getStarList();

        System.out.println(starList);

        // stars = "5 stars"
        // list --> 5-star

        String starNumber = stars.split(" ")[0];

        int size = starList.size();
        int occurance = Collections.frequency(starList,starNumber+"-star"); // 5-star

        boolean result = size==occurance;

        Assert.assertTrue(result,"al hotels are not '"+starNumber+" star' hotels");


    }
}
