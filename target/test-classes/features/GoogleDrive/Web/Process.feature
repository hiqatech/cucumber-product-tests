#Author: hiqatech@gmail.com
#Keywords Summary : DropBox Tests

Feature: DropBox Home Tests

  @DropBoxWebRegression
  Scenario:DropBox Web - I can run my process
    Given I navigate to the Home page
    And I "enter" "hiqatech@gmail.com" into the "email_field"
    And I "enter" "Strid@b52" into the "password_field"
    When I "click" the "sign_in_button"
    And I wait "10" sec/s for "login"
    And I am on the "MyPage" page


