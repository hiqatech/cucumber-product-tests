#Author: hiqatech@gmail.com
#Keywords Summary : Cognizant Tests

Feature: Cognizant Asset Management Process Tests

  @CognizantETLRegression
  Scenario:Cognizant - I can run my process
    Given I open the "MyCars.xlsx" on "workbook1" from the "Downloads"
    And I open the "MyCarsUpdater.xlsx" on "workbook2" from the "Downloads"
    And I update the "workbook1" by the "workbook2" by "ID"
    And I close the "MyCarsUpdater.xlsx" on "workbook2"
    And I save and close the "MyCars.xlsx" on "workbook1"
    #And I delete the "MyCars.xlsx" from the "Downloads"