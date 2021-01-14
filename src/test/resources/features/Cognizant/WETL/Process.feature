#Author: hiqatech@gmail.com
#Keywords Summary : Cognizant Tests

Feature: Cognizant Asset Management Process Tests

  @CognizantWebRegression
  Scenario:Cognizant Web - I can run my process
    Given I navigate to the Home page
    And I "enter" "MyUserName" into the "email_field"
    When I "click" the "next_button"
    And I wait "2" sec/s for "next_window"
    And I "enter" "MyPassword" into the "password_field"
    When I "click" the "sign_in_button"
    #And I receive the OTPNumber to my phoneNumber
    #And I "enter" "OTPNumber" into the "otp_number_field"
    And I wait "20" sec/s for "otp_number"
    And I "click" the "otp_number_verify_button"
    And I "click" the "stay_sign_in_yes_button"
    And I wait "20" sec/s for "login"
    #And I "click" the "stay_sign_in_yes_button"
    Then I am on the "MyProfile" page
    And I should see the "view_profile_menu"
    And I "enter" "asset registration" into the "app_search_field"
    When I "click" the "app_search_button"
    When I "click" the "search_result_first_image"
    And I wait "10" sec/s for "000"