package Project.StepDefinitions;

import Project.pages.HotelsHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RoomCountHotelsSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @When("^I select (.+) from room dropdown$")
    public void i_select_from_room_dropdown(String selectrooms) {

        hotelsHomePage.selectRoomcount(selectrooms);
    }

    @Then("^I verify (.+) room drop downs are/ is displayed$")
    public void i_verify_room_drop_downs_are_is_displayed(String numberofroomdropdown) throws Throwable {

        int expectedRoomcount = Integer.parseInt(numberofroomdropdown);

        int actualRoomcount = hotelsHomePage.getRoomRows();

        Assert.assertEquals(actualRoomcount,expectedRoomcount,"room count is different");

    }
}
