	Feature: Insurances_smoke

  @smoke
  Scenario Outline: Travel insurance home page
    Given user navigates policy bazaar homepage
    When user clicked on travel insurance link and navigated to destination page
    When user Entered valid destination "<place>" in text box
    Then user selects the place from dropdown and clicks next button1

    Examples: 
      | place |
      | Italy |

  @smoke
  Scenario: Travel insurance trip date page
    Given user navigates to trip dates page
    When user selects the start and end dates from the calender "<smonthyear>""<sdate>""<emonthyear>""<edate>"
    And clicks on next button in tripdate page
      | smonthyear | sdate | emonthyear | edate |
      | March 2024 |    24 | April 2024 |    24 |

  @smoke
  Scenario: Travel insurance traveller page
    Given user navigates to traveller page
    When user selects "2" people
    And selects their respective ages
    Then clicks on next button in traveller page

  @smoke
  Scenario: Travel insurance medical history page
    Given user navigates to medical history page
    When user select either of value i.e yes/no
    Then clicks on next button in medical history

  @smoke
  Scenario: Travel insurance results page
    Given user navigates to contact details page
    When user enters valid phone number in text box
    And user uncheck on whatsapp button to not get notifications
    Then user clicks on view plans button and user navigated to results page

  @smoke
  Scenario: back to home page from travel page
    Given user is in results page of travel insurance
    When user clicks on policy bazaar logo
    Then user navigattes to home page of policy bazaar

                   ####CAR INSURANCE ####
  @smoke
  Scenario: car insurance home page
    Given User should be in Policy bazaar home page
    When User clicks on Car Insurance in policy bazaar home page
    Then User verifies title of Car insurance page
    When User clicks on View prices button without giving car number in box
    Then capture the error message displayed

  @smoke
  Scenario Outline: car insurance car number page
    Given User should be in Policy bazaar home page
    When User clicks on Car Insurance in policy bazaar home page
    When User clicks on View prices button without giving car number in box
    Then capture the error message displayed
    When User clicks on View prices button by giving valid "<car number>" in box

    Examples: 
      | car number |
      | TN-23-6543 |

  @smoke
  Scenario Outline: car insurance brand name page
    Given user navigates to car insurance page
    When user selects a brand from car brands "<carBrand>"

    Examples: 
      | carBrand |
      | KIA      |

  @smoke
  Scenario: car insurance model name page
    Given user navigates to car insurance page
    When user navigate to model name page
    Then user selects the model name

  @smoke
  Scenario: car insurance fueltype page
    Given user navigates to car insurance page
    When user verifies fueltype page
    Then user selects fueltype name

  @smoke
  Scenario: car insurance variantType page
    Given user navigates to car insurance page
    When user verifies variantType page
    Then user selects a variantType

  @smoke
  Scenario: car insurance registeredyear page
    Given user navigates to car insurance page
    When user verifies registeredyear page
    Then user selects a registeredyear

  @smoke
  Scenario: car insurance contact details page all errors
    Given user navigates to car insurance page
    When user click on view prices button
    Then user capture error messages of all details

  @smoke
  Scenario: car insurance contact details page mobile error
    Given user navigates to car insurance page
    When user enters valid fullname, email and invalid phoneno
    Then user capture error message of invalid phoneno

  @smoke
  Scenario: car insurance contacts page mail error
    Given user navigates to car insurance page
    When user enters valid fullname, phone and invalid email
    Then user capture error message invalid mail

  @smoke
  Scenario: back to home page from travel page
    Given user is in car contact details page
    When user clicks on policy bazaar icon
    Then user navigates to home page of policy bazaar

  #### HEALTH INSURANCE #####
  
  @smoke
  Scenario: Health insurance menu
    Given User should be in policy bazaar home page for health insurance
    When User clicked on Insurance Products dropdown
    Then User store all the health insurance menu in dropdown displayed

  @smoke
  Scenario: Health insurance link
    Given User should be in policy bazaar home page for health insurance
    When User clicked on Insurance Products dropdown
    When User clicked on health insurance  and navigated to health insurance page
    Then User verify title of health insurance page

  @smoke
  Scenario: Health insurance candidate
    Given User should be in health insurance insurance who page
    When user clicks on select self as a member
    Then user clicks on continue button in insurance page

  @smoke
  Scenario: Health insurance age page
    Given user navigates to age page
    When user selects age from drop down
    And user click on continue button in age page

  @smoke
  Scenario: Health insurance city page
    Given user navigates to city page
    When user selects city from popular cities and clicks on continue button

  @smoke
  Scenario: Health insurance positive contact page
    Given user navigates to city page
    When user enters valid name and phone number in textboxes in contact details
    When user clicks on continue button in contact page
    And user unchecks whatsapp button and select noneofthese in medical history
