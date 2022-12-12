Feature: Ebay home page scenario


  Scenario: Advance search page
    Given I am on ebay home page
    When I click on logo
    Then I navigate to ebay home page

  Scenario: Advance search page
    Given I am on ebay home page
    When I click on advanced search
    Then I navigate to the Ebay advanced search page

  Scenario: Search
    Given I am on ebay home page
    When I search for 'Iphone x'
    Then I validate at least 25 items are present


  Scenario: search car in ebay
    Given I am on ebay home page
    When I search for 'Car'
    Then I validate at least 1 items are present



  Scenario: Search java in book
    Given I am on ebay home page
    When I search for 'java' in category 'Books'
    Then I validate at least 1 items are present



  Scenario Outline: Home page link
    Given I am on ebay home page
    When I click on '<link>'
    Then I navigate to '<url>' and title contains '<title>'
    Examples:
      | link        | url                                                            | title     |
      | Motors      | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | Auto part |
      | Motors      | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | Auto part |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124               | products  |

