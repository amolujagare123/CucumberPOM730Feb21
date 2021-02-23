package Project.pages;

import org.openqa.selenium.By;

public class LoginPage  extends  DarkSkyAPIPage{

    By loginButton = By.xpath("//button[@type='submit']");

    public void clickLoginButton()
    {
        clickOn(loginButton);
    }
}
