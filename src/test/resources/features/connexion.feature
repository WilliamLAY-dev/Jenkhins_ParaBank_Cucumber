Feature: Connexion à l'application Para Bank

  @ConnxionReussieParaBank
  Scenario: Connexion réussie avec des identifiants valides avec ParaBank
    Given L'utilisateur lance la page parabank.parasoft.com
    When L'utilisateur rentre son login
    And L'utilisateur rentre son mot de passe
    And L'utilisateur clique sur le bouton login
    Then L'utilisateur est connecté à l'application SauceDemo et est redirigé sur la page d'accueil de l'application

    Scenario: Connexion échouée avec un mot de passe invalide
    Given L'utilisateur lance la page parabank.parasoft.com
    When L'utilisateur rentre son login
    And L'utilisateur rentre son mot de passe invalide
    And L'utilisateur clique sur le bouton login
    Then L'authentification échoue et un message d'erreur est affiché