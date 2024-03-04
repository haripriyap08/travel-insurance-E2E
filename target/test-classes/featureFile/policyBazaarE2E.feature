Feature: Policy bazaar
  @test
  Scenario Outline: Travel Insurance
    Given User navigate to policy bazaar website
    Then User verifies title of policy bazaar page
    When User clicks on Travel Insurance button in policy bazaar home page
    Then User Verifies title of Travel Insurance page
    When User enters "<location>" of European countries in destination box and click on next  in travel page
    When User selects dates from calender for start and end in Travel Insurance page Trip "<smonthyear>""<sdate>""<emonthyear>""<edate>"
    When User selects number of people travelling
    And User accordingly select ages of people in respective age dropdowns shown when clicked on age boxes
    And User clicks on Proceed to medical history after selecting age of people
    When User clicks no radio button  in medical history part
    When User enters valid "<mobile number>" in mobilenumber box and click viewplans in contact details
    When User clicks on Student plan Traveller check boxes and select plans
    When User clicks on Sort by button and selects Premium low to high dropdown in policy bazaar
    And User store the details insurance provider company name and amount of first 3 insurance plans
    When User clicks on policy bazaar icon
    Then User verifies title of redirected page

    Examples: 
      | location | smonthyear | sdate | emonthyear | edate | mobile number |
      | Italy    | April 2024 |    24 | May 2024   |    24 |    9898999654 |

  @test
  Scenario Outline: Car Insurance
    Given User should be in Policy bazaar home page
    When User clicks on Car Insurance in policy bazaar home page
    Then User verifies title of Car insurance page
    When User clicks on View prices button without giving car number in box
    Then capture the error message displayed
    When User clicks on View prices button by giving valid "<car number>" in box
    When User selects car details "<Car Brand>","<Car Model>","<Car Fuel>","<Car Variant>","<Car reg year>" in car insurance
    When User enters valid "<name>" in fullname box "<email>" in email box and "<mobileno>" in mobileno box
    Then User captures error message if email is invalid
    And User validate if all details valid details and click on next
    When User clicks on policy bazaar to go back home
    Then User verifies title of policy bazaar again after redirection

    Examples: 
      | car number | Car Brand | Car Model | Car Fuel | Car Variant               					| Car reg year  | name 		 | email         | mobileno   |
      | TN-23-6543 | KIA       | Sonet     | Diesel   | GTX Plus 1.5 AT (1493 cc) 					| Brand New Car | abcd		 | abc					 | 9876023652 |

	@test
  Scenario Outline: Health Insurance
    Given User should be in policy bazaar home page for health insurance
    When User clicked on Insurance Products dropdown
    Then User store all the health insurance menu in dropdown displayed
    When User clicked on health insurance  and navigated to health insurance page
    Then User verify title of health insurance page
    And user  provided valid data with "<member>","<age>","<city>","<name>","<wrongMobNo>","<invphoneNo>","<validMobNo>"
    And click on continue
    Then sort results as low to high and capture the first three insurance packages and providers

    Examples: 
      | member | age      | city      | name | wrongMobNo | invphoneNo | validMobNo |
      | self   | 22 Years | Hyderabad | hari | 1234567891 | 9876543234 | 9876543453 |
