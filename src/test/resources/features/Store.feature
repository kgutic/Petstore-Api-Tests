Feature: Place a new order for a pet

  Scenario: Add new order for an existing pet
    Given a new pet is successfully added with following details
      | petId       | name | categoryId | categoryName | photoUrls                             | tagId | tagName | status    |
      | <generated> | cat  | 1          | My cats      | www.testkitty.com, www.testkitty2.com | 1     | testTag | available |
    When the request is sent to place a new order for this pet with
      | orderId     | petId       | quantity | shipDate             | status   | complete |
      | <generated> | <generated> | 1        | 2024-11-26T12:00:00Z | approved | true     |
    Then the response status code is 200
    And the returned details in the response are
      | orderId     | petId       | quantity | shipDate             | status   | complete |
      | <generated> | <generated> | 1        | 2024-11-26T12:00:00Z | approved | true     |
