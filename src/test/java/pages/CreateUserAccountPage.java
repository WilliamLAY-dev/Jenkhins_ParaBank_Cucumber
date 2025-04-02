package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserAccountPage {
    
    @FindBy (id="user-name")
    public WebElement username;

    @FindBy (id="password")
    public WebElement password;

}
