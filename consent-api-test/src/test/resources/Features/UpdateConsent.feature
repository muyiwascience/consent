@regression
Feature: Update Consent

  @update
  Scenario: Updating a consent - valid
    Given I have access to consent service
    When I update a consent using "validUpdate.json" on "1"
    Then the following update consent result is available

  @update
  Scenario: Updating a consent - invalid
    Given I have access to consent service
    When I update a consent using "invalidUpdate.json" on "ZZ1XXXXX12"
    Then the following update consent invalid result is available