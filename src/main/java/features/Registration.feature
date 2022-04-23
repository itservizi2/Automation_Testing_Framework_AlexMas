Feature: Registration flow feature
@ExecutaAcestTC


  Scenario: The registration page can be accessed from navigation bar
    Given "https://demo-opencart.com" is accessed
    When user clicks on registration button from navigation bar
    Then "index.php?route=account/register" is present within the current url

  Scenario: Opencart page is accessible
    When "https://demo-opencart.com" is accessed
    Then "https://demo-opencart.com" is present within the current url
