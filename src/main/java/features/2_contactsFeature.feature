@contactsfeature
Feature: free crm application contacts page test

   Scenario: validate free crm contact page test

    Given user open contacts page
    And user clicks on create contact button
    Then user enters data
      | Email           | Firstname | Lastname | JobTitle     |
      | test1@gmail.com | fa        | A        | Test         |
      | test2@gmail.com | far       | Al       | Tester       |
      | test3@gmail.com | farh      | Ali      | Test Analyst |
