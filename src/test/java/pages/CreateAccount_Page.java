package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

public class CreateAccount_Page {

    public CreateAccount_Page() {

        PageFactory.initElements(BaseTest.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[1]/a")
    public WebElement open_new_account_button;

    @FindBy(id ="type")
    public WebElement account_type_dropdown;

    @FindBy(xpath ="/html/body/div[1]/div[3]/div[2]/div/div[1]/form/select[1]/option[1]")
    public WebElement checking_account_option;

    @FindBy(xpath ="/html/body/div[1]/div[3]/div[2]/div/div[1]/form/select[1]/option[2]")
    public WebElement savings_account_option;

    @FindBy(id ="fromAccountId")
    public WebElement mininum_amount_dropdown;

    @FindBy(xpath ="/html/body/div[1]/div[3]/div[2]/div/div[1]/form/select[2]/option[1]")
    public WebElement mininum_amount_option_1;

    @FindBy(xpath ="/html/body/div[1]/div[3]/div[2]/div/div[1]/form/div/input")
    public WebElement confirm_open_account_button;

}
