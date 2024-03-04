Feature: Insurance_regression

  @regression
  Scenario: Travel Insurance results
    Given user is in results page of travel insurance
    When User click on Student plan Traveller check boxes and select plans
    When User click on Sort by button and selects Premium low to high dropdown in policy bazaar
    And User stores the details insurance provider company name and amount of first 3 insurance plans

  @regression
  Scenario: Travel insurance contact details page
    Given user navigates to contact details page
    When user enters invalid phone number
    Then user captures error message displayed

  @regression
  Scenario: Health Insurances results
    Given user navigates to health insurances details page
    Then sort results as low to high and capture the first three insurance packages and providers

  @regression
  Scenario: Health insurance positive contact page
    Given user navigates to city page
    When user enters valid name and invalid phone number in textboxes in health contact details
    When user clicks on continue button in contact page
