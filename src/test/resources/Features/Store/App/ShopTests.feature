#Author: hiqatech@gmail.com
#Keywords Summary : Store App Test

Feature: StoreAppShop Test

  Background:
    Given I setup the "StoreAppShop" on "VirtualQA"

  @StoreAppSmoke
  Scenario:StoreAppShop - I can register
    Given I start the "android" "Pixel28" device for "General-store.apk" app
    And I select "text(\"Switzerland\")" from "countryDropDown" on app
    And I type "Zoltan" into "nameField" on app
    And I set "radioMale" radio on app
    Then I tap "letsGoShop" button on app
