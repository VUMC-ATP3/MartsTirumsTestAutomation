Feature: this is example how scenario outline works

  @browser
  Scenario Outline: User sees correct error message
    Given user is navigated to 'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username '<username>' and password '<password>'
    And user clicks login button
    Then user sees error message '<error_text>'
    Examples:
      | username      | password     | error_text                                                                |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
      | user          | parole123    | Epic sadface: Username and password do not match any user in this service |
      |               |              | Epic sadface: Username is required                                        |

  @browser
  Scenario Outline: User sees correct page titles
    Given user is navigated to '<url>'
    Then user sees page title '<page_title>'
    Examples:
      | url                              | page_title                                                              |
      | https://www.audi.com/en.html     | Audi.com – the international Audi website \| audi.com                   |
      | https://www.bmw.lv/lv/index.html | BMW vienīgais oficiālas BMW pārstāvis Latvijā \| Inchcape Motors Latvia |
      | https://www.subaru.lv/           | Subaru Latvija                                                          |
