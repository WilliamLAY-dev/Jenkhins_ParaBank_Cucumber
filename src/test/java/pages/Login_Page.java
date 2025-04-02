package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

public class Login_Page {

    @FindBy (name="username")
    public WebElement username;

    @FindBy (name="password")
    public WebElement password;

    @FindBy (xpath="/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input")
    public WebElement login_button;

    public Login_Page() {

        PageFactory.initElements(BaseTest.getDriver(), this);
    }

}
