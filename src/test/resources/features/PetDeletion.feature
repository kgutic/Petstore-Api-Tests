Feature: Delete a pet from the store

  Scenario: Delete an existing pet
    Given a new pet is added with following details
      | id          | name | categoryId | categoryName | photoUrls         | tagId | tagName | status    |
      | <generated> | cat  | 1          | My cats      | www.testkitty.com | 1     | testTag | available |
    When the request is sent to delete this pet
    Then the response status code is 200
    #And the pet is deleted from the store