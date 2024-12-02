Feature: Manage Store Orders
  As a user of the Petstore API,
  I want to place, retrieve, and delete orders for pets,
  So that I can efficiently manage pet purchases and inventory

  Background: Add a new pet
    Given a new pet is successfully added with following details
      | petId       | name   | categoryId | categoryName | photoUrls                              | tagId | tagName | status    |
      | <generated> | rabbit | 1          | My rabbits   | www.testrabbit.com, www.tesrabbit2.com | 1     | testTag | available |

  Scenario: Add new order for an existing pet
    When the request is sent to place a new order for this pet with
      | orderId     | petId       | quantity | shipDate             | status   | complete |
      | <generated> | <generated> | 1        | 2024-11-26T12:00:00Z | approved | true     |
    Then the response status code is 200
    And the returned details in the response are
      | orderId     | petId       | quantity | shipDate             | status   | complete |
      | <generated> | <generated> | 1        | 2024-11-26T12:00:00Z | approved | true     |

  Scenario: Find a specific order by ID
    And a new order is successfully placed with
      | orderId     | petId       | quantity | shipDate             | status   | complete |
      | <generated> | <generated> | 1        | 2024-12-02T12:00:00Z | approved | true     |
    When the request is sent to search for this order by ID
    Then the response status code is 200
    And the returned details in the response are
      | orderId     | petId       | quantity | shipDate             | status   | complete |
      | <generated> | <generated> | 1        | 2024-12-02T12:00:00Z | approved | true     |

    Scenario: Delete an existing order
      And a new order is successfully placed with
        | orderId     | petId       | quantity | shipDate             | status   | complete |
        | <generated> | <generated> | 1        | 2024-12-02T12:00:00Z | approved | true     |
      When the request is sent to delete this order
      Then the response status code is 200
      And this order no longer exists in the store