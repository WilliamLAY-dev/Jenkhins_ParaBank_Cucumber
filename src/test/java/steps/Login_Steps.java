package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Login_Page;
import utils.BaseTest;

import java.time.Duration;

public class Login_Steps extends Login_Page {

    @Given("L'utilisateur lance la page parabank.parasoft.com")
    public void lUtilisateurLanceLaPageParabankParasoftCom() {

        BaseTest.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        
    }

    @When("L'utilisateur rentre son login")
    public void lUtilisateurRentreSonLogin() {

        BaseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        username.sendKeys("john");
    }

    @And("L'utilisateur rentre son mot de passe")
    public void lUtilisateurRentreSonMotDePasse() {

        BaseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        password.sendKeys("demo");
    }

    @And("L'utilisateur clique sur le bouton login")
    public void lUtilisateurCliqueSurLeBoutonLogin() {

        BaseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        login_button.click();
    }

    @Then("L'utilisateur est connecté à l'application SauceDemo et est redirigé sur la page d'accueil de l'application")
    public void lUtilisateurEstConnecteALApplicationSauceDemoEtEstRedirigeSurLaPageDAccueilDeLApplication() {

        System.out.println("L'utilisateur est connecté à l'application Parabank et est redirigé sur la page d'accueil de l'application");

    }

    @And("L'utilisateur rentre son mot de passe invalide")
    public void lUtilisateurRentreSonMotDePasseInvalide() {

        BaseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        password.sendKeys("invalid");
    }

    @Then("L'authentification échoue et un message d'erreur est affiché")
    public void lAuthentificationEchoueEtUnMessageDErreurEstAffiche() {

        System.out.println("L'authentification échoue et un message d'erreur est affiché");
    }

}
