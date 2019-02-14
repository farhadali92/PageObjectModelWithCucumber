Feature: free crm application test
  Scenario: validate free crm home page test

  Given user Navigates to freeCRM website
    And user enters username and password
    And user clicks on login button
    Then homepage should be displayed
    Then user open contacts page
    And user clicks on create contact button
    Then user enters data
      | Email | Firstname | Lastname | JobTitle |
      | test1@gmail.com | fa | A | Test |
      | test2@gmail.com | far | Al | Tester |
      | test3@gmail.com | farh | Ali | Test Analyst |







