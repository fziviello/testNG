Feature: Mobile Test

  Rule: Only Mobile App Test

  @android
  Scenario: User log in
    Given I launch Android mobile app
    When insert user admin and password admin
    When click Login button
    Then close App
