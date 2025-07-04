#Author: hiqatech@gmail.com
#Keywords Summary : Booking REST Service Test

Feature: BookingREST Test

  Background:
    Given I setup the "BookingRest" on "QA"

  @BookingRestSmoke
  Scenario:BookingRest - I add and remove books
    And I get the auth token by "TOOLSQA-Test" and "Test@@123"
    When I send "GET" request to "/BookStore/v1/Books"
    And I get the 1st book from the store available
    When I add a book to my reading list
    Then The book is added
    When I remove a book from my reading list
    Then The book is removed
