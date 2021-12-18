@Regression
Feature: Feature to test HomePage

  Scenario: Check HomePage is loaded successfully

    Given user hits the application url
    Then validate title "The Best Free Ukrainian Dating Site| Romanceabroad.Com" and that user is navigated to the HomePage
    Then Check main tabs by name
      | tabName         |
      | HOME            |
      | HOW WE WORK     |
      | PRETTY WOMEN    |
      | PHOTOS          |
      | GIFTS           |
      | TOUR TO UKRAINE |
      | BLOG            |
    Then validate that registration button is displayed
    Then validate that "BOOK NOW " text is displayed
