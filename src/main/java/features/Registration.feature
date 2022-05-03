@LectieAvansata
Feature: Registration flow feature

  Background:
    Given "HomePage" is accessed

  @ExecutaAcestTC
  Scenario: The registration page can be accessed from navigation bar
    When user clicks on registration button from navigation bar
    Then Correct "RegisterPage" endpoint is displayed

  @Run
  Scenario: Opencart page is accessible
    Then "https://demo-opencart.com" is present within the current url

  @LectieAvansata
  Scenario Outline:  error message is displayed when providing wrong  data for <affectedField>
    Given "RegisterPage" is accessed
    When the register fields are populated with the following data:
      | firstName       | <first name>  |
      | lastName        | <last name>   |
      | email           | <email>       |
      | phoneNumber     | <phoneNumber> |
      | password        | Parola123!    |
      | confirmPassword | Parola123!    |
    And privacyCheckBox is clicked
    And Continue button is clicked
    Then the following keywords are present within the error message
      | <errorMessage> |
    Examples:
      | affectedField | first name                          | last name | email         | phoneNumber  | errorMessage                                    |
      | Email         | John                                | Peterson  |               | 464644646452 | appear to be valid!                             |
      | First Name    |                                     | Peterson  | 123@yahoo.com | 44444119     | First Name must be between 1 and 32 characters! |
      | Last Name     | John                                |           | 123@yahoo.com | 651651       | Last Name must be between 1 and 32 characters!  |
      | Phone         | John                                | Peterson  | 123@yahoo.com |              | Telephone must be between 3 and 32 characters!  |
      | Phone         | John                                | Peterson  | 123@yahoo.com | 12           | Telephone must be between 3 and 32 characters!  |
      | First Name    | JohnJohnJohnJohnJohnJohnJohnJohnjjj | Peterson  | 123@yahoo.com | 1251565111   | First Name must be between 1 and 32 characters! |