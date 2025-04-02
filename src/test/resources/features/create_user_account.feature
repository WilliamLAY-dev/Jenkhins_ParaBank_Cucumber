Feature: Inscription d'un nouvel utilisateur

  Background:

    Given Utilisateur lance la page "<https://parabank.parasoft.com/parabank/register.htm>"

  Scenario: Inscription d'un nouvel utilisateur avec des identifiants valides

    When Utilisateur rentre son prénom sur la page d'inscription
    And Utilisateur rentre son nom de famille sur la page d'inscription
    And Utilisateur rentre son adresse sur la page d'inscription
    And Utilisateur rentre sa ville sur la page d'inscription
    And Utilisateur rentre son pays sur la page d'inscription
    And Utilisateur rentre son zip code sur la page d'inscription
    And Utilisateur rentre son numéro de téléphone sur la page d'inscription
    And Utilisateur rentre SSN sur la page d'inscription
    And Utilisateur rentre son nom d'utilisateur sur la page d'inscription
    And Utilisateur rentre son mot de passe sur la page d'inscription
    And Utilisateur rentre sa confirmation de mot de passe sur la page d'inscription
    And Utilisateur clique sur le bouton Register dela page d'inscription
    Then Utilisateur est inscrit à l'application ParaBank et est redirigé sur la page d'accueil de l'application
