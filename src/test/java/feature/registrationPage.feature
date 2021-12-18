@Regression
Feature: Feature to test RegistrationPage

  Scenario: Check regitsration

    Given user hits the application url
    When click registration button
    And complete first part of registration
    When complete second part of registration
      | month | day | year | city   | location                                          |
      | May   | 2   | 2002 | Sydney | North Sydney, State of New South Wales, Australia |

