Feature:

  Scenario: Add a new user
    Given a new user is ready to be added with following details
      | id          | username   | firstName | lastName | email          | password    | phone       | status |
      | <generated> | testuser17 | James     | Jameson  | test@email.com | <generated> | +4369912345 | 1      |
    #When the request is sent to add a new user
    #Then the response status code is 200
    #And the details returned in the response are
     # | id          | username   | firstName | lastName | email          | password    | phone       | status |
      #| <generated> | testuser17 | James     | Jameson  | test@email.com | <generated> | +4369912345 | 1      |
