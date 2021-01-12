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
    And I receive the OTPNumber to my phoneNumber
    And I "enter" "OTPNumber" into the "otp_number_field"
    When I "click" the "otp_number_submit_button"
    And I wait "10" sec/s for "login"
    Then I am on the "MyProfile" page
    And I should see the "my_profile_menu"

