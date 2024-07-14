@SecurityValidation
Feature: Collection API security measures

  The Collection API only supports access through GET method using a valid key

  Scenario: requesting the collection without a key must return error 401 unauthorized
    Given I send a Collection request without key to the involvedMaker Rembrandt+van+Rijn
    Then the Collection API must return status 401

  Scenario: requesting the collection with a wrong key must return error 401 unauthorized
    Given I send a Collection request without key using the following parameters:
      | key           | AAAAAA             |
      | involvedMaker | Rembrandt+van+Rijn |
    Then the Collection API must return status 401

  Scenario Outline: use the API method <method> must return error 405 method now allowed
    Given I call the Collection API using the method <method>
    Then the Collection API must return status 405
    Scenarios:
      | method |
      | POST   |
      | PATCH  |
      | DELETE |