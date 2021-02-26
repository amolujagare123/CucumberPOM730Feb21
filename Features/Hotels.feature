Feature: Hotels.com website testing

  Background: opening the web page
    Given I am on hotels.com home page

# 1
  @VerifyStar
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
      | 4 stars |
      | 3 stars |

#2

  @hotelsInfo
  Scenario: List of all of hotel within 25 km radius of airport
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "30" Km radius of airport
    And I verify "Courtyard by Marriott" is within radius


#3
  @dealPrice
  Scenario: Verify todays deal price value
    Given I am on default locations search result screen
    Then I verify todays deal is less than "5000" rs

#4
  @roomCount
  Scenario Outline: Verify room count dropdown
    Given I am on hotels.com home page
    When I select <select_rooms> from room dropdown
    Then I verify <number_of_room_dropdown> room drop downs are/ is displayed

    Examples:
      |select_rooms            | number_of_room_dropdown |
      | 2                      | 2              			         |
      | 5                      | 5               			        |
      | 9+                     | 0                   			    |
