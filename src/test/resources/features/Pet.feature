Feature: Manage Pets
  As a user of the Petstore API
  I want to add, retrieve, and delete pets
  So that I can manage the pet inventory effectively

  Scenario: Add a new pet
    Given a new pet is ready to be added with following details
      | id          | name | categoryId | categoryName | photoUrls                         | tagId | tagName | status    |
      | <generated> | dog  | 1          | My dogs      | www.testdog.com, www.testdog2.com | 1     | testTag | available |
    When the request is sent to add a new pet
    Then the response status code is 200
    And following details are returned in the response
      | id          | name | categoryId | categoryName | photoUrls                         | tagId | tagName | status    |
      | <generated> | dog  | 1          | My dogs      | www.testdog.com, www.testdog2.com | 1     | testTag | available |

  Scenario: Find a specific pet by ID
    Given a new pet is successfully added with following details
      | id          | name | categoryId | categoryName | photoUrls                             | tagId | tagName | status    |
      | <generated> | cat  | 1          | My cats      | www.testkitty.com, www.testkitty3.com | 1     | testTag | available |
    When the request is sent to search for this pet by ID
    Then the response status code is 200
    And following details are returned in the response
      | id          | name | categoryId | categoryName | photoUrls                             | tagId | tagName | status    |
      | <generated> | cat  | 1          | My cats      | www.testkitty.com, www.testkitty3.com | 1     | testTag | available |

  Scenario: Delete an existing pet
    Given a new pet is successfully added with following details
      | id          | name | categoryId | categoryName | photoUrls                             | tagId | tagName | status    |
      | <generated> | cat  | 1          | My cats      | www.testkitty.com, www.testkitty2.com | 1     | testTag | available |
    When the request is sent to delete this pet
    Then the response status code is 200
    And the pet no longer exists in the store