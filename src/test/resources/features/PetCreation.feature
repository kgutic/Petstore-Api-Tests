Feature: Add new pets to the store

  Scenario: Add a new pet
    Given a new pet is ready to be added with following details
      | id          | name | categoryId | categoryName | photoUrls       | tagId | tagName | status    |
      | <generated> | dog  | 1          | My dogs      | www.testdog.com | 1     | testTag | available |
    When the request is sent to add a new pet
    Then the response status code is 200
    And following details are returned in the response
      | id          | name | categoryId | categoryName | photoUrls       | tagId | tagName | status    |
      | <generated> | dog  | 1          | My dogs      | www.testdog.com | 1     | testTag | available |