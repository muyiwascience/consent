@regression
Feature: Create Consent

  @create
  Scenario: Creating a consent - Valid
    Given I have access to consent service
    When I create a consent using "validCreate.json"
    Then the following create consent result is available

  @create
  Scenario: Creating a consent - Invalid
    Given I have access to consent service
    When I create a consent using "invalidCreate.json"
    Then the following create consent invalid result is available