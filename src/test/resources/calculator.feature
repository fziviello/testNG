Feature: Execute a Calculator Operations

  Rule: Only Calculator Test

  @calculator
  Scenario: Sum two numbers
    Given two numbers 10 and 5
    Then the sum is 15

  @calculator
  Scenario: Difference two numbers
    Given two numbers 10 and 5
    Then the difference is 5

  @calculator
  Scenario: Multiply two numbers
    Given two numbers 10 and 5
    Then the multiply is 50

  @calculator
  Scenario: Sum data table numbers
    When load sum dataTable
    |10|5|
    |20|5|
    Then check the sum result
    |15|
    |25|

  @calculator
  Scenario Outline: Check is Prime
    Given try the number <Number>
    Then is prime<isPrime>
    Examples:
    |Number|isPrime|
    |1|false|
    |2|true|
    |3|true|
    |4|false|
