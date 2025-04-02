Feature: Creation d'un compte sur SauceDemo

  Background:
    Given L'utilisateur lance la page parabank.parasoft.com
    When L'utilisateur rentre son login
    And L'utilisateur rentre son mot de passe
    And L'utilisateur clique sur le bouton login
    Then L'utilisateur est connecté à l'application SauceDemo et est redirigé sur la page d'accueil de l'application

  Scenario: L'utilisateur crée un compte Bancaire

    When L'utilisateur clique sur le bouton Open New Account de la page d'accueil
    And L'utilisateur clique sur le bouton du menu déroulant du type de compte
    And L'utilisateur choisit le type de compte
    And L'utilisateur clique sur le bouton du menu déroulant du dépot initial
    And L'utilisateur choisit le dépot initial
    And L'utilisateur clique sur le bouton Open New Account de la page de confirmation
    Then Un message de confirmation est affiché avec le numéro de compte

