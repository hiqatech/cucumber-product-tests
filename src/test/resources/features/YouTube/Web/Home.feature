#Author: hiqatech@gmail.com
#Keywords Summary : YouTube Home Tests

Feature: YouTube Home Tests

  @YouTubeWebRegression
  Scenario:YouTubeWeb - I can find videos with Zurich
    Given I navigate to the Home page
    And I "click" the "no_thanks_button"
    And I "click" the "i_agree_button"
    And I takes screenshot as "search_evidence_1"

