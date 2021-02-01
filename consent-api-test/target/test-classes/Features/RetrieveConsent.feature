@regression
Feature: Retrieve Consent

  @retrieve
  Scenario: Retrieve a consent - valid
    Given I have access to consent service
    When I retrieve a consent using on "/invitation-code/1"
    Then the following get consent result is available