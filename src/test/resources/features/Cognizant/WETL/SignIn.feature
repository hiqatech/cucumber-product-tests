#Author: hiqatech@gmail.com
#Keywords Summary : Cognizant Tests

Feature: Cognizant Asset Management Process Tests

  @CognizantWebRegression
  Scenario:Cognizant Web - I can signin
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
    And I "enter" "oneIt" into the "app_search_field"
    When I "click" the "app_search_button"
    When I "click" the "search_result_first_image"
    And I wait "10" sec/s for "000"
    And I "enter" "material movement" into the "one_it_search_fileld"
    When I "click" the "search_button"
    When I "click" the "search_result_first_launch"
    When I "click" the "mmo_closure"
    When I "click" the "mmi_closure"
    And I select the "Switzerland" "option" from the "location_dropdown"
    When I "click" the "go_button"
    When I "click" the "bulk_return_button"
    And I upload the "MyCars1.xlsx" to the "upload_button"
    And I wait "2" sec/s for "upload"

    And I go to the share path
    #https://cognizantonline.sharepoint.com/sites/UKEurope-IT/Shared%20Documents/Forms/AllItems.aspx?RootFolder=%2Fsites%2FUKEurope%2DIT%2FShared%20Documents%2FLocal%5FHAR%20%2D%20UKI%20%26%20CE%202021%2FLaptop%20%26%20Desktop%20%2D%20Local%5FHAR




    #And I "click" the "download_button"
    #And I send enter keys to the popup window
    #And I wait "2" sec/s for "download"
    #And I click the "browser_back_button"
    #And I "click" the "my_repository_name"
    And I "click" the "add_file_dropdown"
    And I "click" the "upload_file_option"
    And I upload the "MyCars1.xlsx" to the "choose_your_files_field"
    And I wait "2" sec/s for "upload"
