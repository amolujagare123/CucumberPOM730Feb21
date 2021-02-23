package Project.pages;

import org.openqa.selenium.By;

public class DarkSkyAPIPage extends DarkSkyHomePage {

    By loginLink = By.xpath("//a[@class='button']");

    public void clickLoginLink()
    {
        clickOn(loginLink);
    }
}
