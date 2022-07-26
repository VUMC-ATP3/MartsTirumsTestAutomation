Feature: 10. Homework in Cucumber

  @browser
  Scenario: First positive scenario
    Given user is navigated to 'https://www.saucedemo.com/'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    Then user is successfully logged in
    When user adds item to cart
    And user clicks cart button
    When user clicks checkout button
    When user enter name 'Marts' and Lastname 'Tirums' and zip 'LV2127'
    And user clicks continue button
    And user clicks finish button
    Then order is created successfully

  @browser
  Scenario Outline: Second error message scenario
    Given user is navigated to 'https://www.saucedemo.com/'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    When user adds item to cart
    And user clicks cart button
    When user clicks checkout button
    When user enter name '<name>' and Lastname '<lastname>' and zip '<zip>'
    And user clicks continue button
    Then user sees error message '<error message>'
    Examples:
      | name  | lastname | zip | error message                  |
      |       |          |     | Error: First Name is required  |
      |       | Tirums   |     | Error: First Name is required  |
      | Marts |          |     | Error: Last Name is required   |
      | Marts | Tirums   |     | Error: Postal Code is required |


