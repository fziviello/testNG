Feature: User Certification

  Rule: Only user Test

  @user
  Scenario: User is Passed
    Given that the user Fabio is given a task to clear Java certification exam
    When Fabio got 95 marks in exam
    Then Fabio is known as Java certified
