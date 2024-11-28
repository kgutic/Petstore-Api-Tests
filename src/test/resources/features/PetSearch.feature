Feature: Search for pets in the store

  Scenario: Find a specific pet by ID
    Given a new pet is successfully added with following details
      | id          | name | categoryId | categoryName | photoUrls                             | tagId | tagName | status    |
      | <generated> | cat  | 1          | My cats      | www.testkitty.com, www.testkitty3.com | 1     | testTag | available |
    When the request is sent to search for this pet by ID
    Then the response status code is 200
    And following details are returned in the response
      | id          | name | categoryId | categoryName | photoUrls                             | tagId | tagName | status    |
      | <generated> | cat  | 1          | My cats      | www.testkitty.com, www.testkitty3.com | 1     | testTag | available |