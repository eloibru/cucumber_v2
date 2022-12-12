Feature: Advanced search scenarion


  Scenario: Ebay logo on search page
    Given I am on ebay advanced search page
    When i click on the ebay logo
    Then I navigate to the Ebay home page


  Scenario: Ebay advance search with datatable
    Given I am on ebay advanced search page
    When i_advance_search_an_item_via_person
      | include | exclude | minPrice | maxPrice |
      | Jav46464a    | pythin  | 0        | 0     |
      | test    | brol    | 0        | 1000     |
    And I advance search an item
    And I click search
    Then I validate at least 2 items are present in advance search


  Scenario: Ebay advance search with Scenario outline
    Given I am on ebay advanced search page
    When I advance search an item
    And I use as searchCriteria
      | type | exclude | min | max |
      | Java | python  | 0   | 300 |
    And I click search
    Then I validate at least 2 items are present in advance search


  Scenario Outline: Ebay advance search with Scenario outline
    Given I am on ebay advanced search page
    When I advance search an item
    Then I search for '<search>' and exclude '<exclude>' with a minimum price of '<minimum>' and a maximum price '<maximum>'
    And I click search
    Then I validate at least '<found>' items are present in advance search
    Examples:
      | search      | exclude | minimum | maximum | found |
      | Iphone      | samsung | 0       | 1500    | 10    |
      | sdfsqdfqsdf | -       | 0       | 0       | 0     |