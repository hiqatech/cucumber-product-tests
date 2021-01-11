#Author: hiqatech@gmail.com
#Keywords Summary : GitHub Tests

Feature: GitHub Home Tests

  @GitHubWebRegression
  Scenario:GitHub Web - I can run my process
    Given I navigate to the Home page
    And I "click" the "sing_in_button"
    And I "enter" "hiqatech" into the "email_field"
    And I "enter" "Strid@b52" into the "password_field"
    When I "click" the "login_button"
    And I wait "10" sec/s for "login"
    And I am on the "Home" page
