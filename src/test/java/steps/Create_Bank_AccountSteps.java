package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccount_Page;

public class Create_Bank_AccountSteps extends CreateAccount_Page {
    @When("L'utilisateur clique sur le bouton Open New Account de la page d'accueil")
    public void lUtilisateurCliqueSurLeNewAccountdelapagedaccueil() {
        open_new_account_button.click();
    }

    @And("L'utilisateur choisit le type de compte")
    public void lUtilisateurChoisitLeTypeDeCompte() {
        checking_account_option.click();
    }

    @And("L'utilisateur choisit le dépot initial")
    public void lUtilisateurChoisitLeDepotInitial() {
        mininum_amount_option_1.click();
    }

    @And("L'utilisateur clique sur le bouton Open New Account de la page de confirmation")
    public void lUtilisateurCliqueSurLeBoutonOpenNewAccountdelapagedeconfirmation() {

        confirm_open_account_button.click();

    }

    @Then("Un message de confirmation est affiché avec le numéro de compte")
    public void unMessageDeConfirmationEstAfficheAvecLeNumeroDeCompte() {

        System.out.println("Un message de confirmation est affiché avec le numéro de compte");
    }

    @And("L'utilisateur clique sur le bouton du menu déroulant du type de compte")
    public void lUtilisateurCliqueSurLeBoutonDuMenuDeroulantDuTypeDeCompte() {

        account_type_dropdown.click();

    }

    @And("L'utilisateur clique sur le bouton du menu déroulant du dépot initial")
    public void lUtilisateurCliqueSurLeBoutonDuMenuDeroulantDuDepotInitial() {

        mininum_amount_dropdown.click();
    }

}
