@RunContact
Feature: Contact Page Test Cases

  Scenario: Contact Page is accessible from home page footer
    Given "HomePage" is accessed
    When Contact Us button from footer is clicked
    Then Correct "ContactPage" endpoint is displayed
    And "cart.com/index.php?route=information/contact" is present within the current url

  Scenario: The most important data like address and phone is displayed on contact page
    When "ContactPage" is accessed
    Then the most important contact details are displayed