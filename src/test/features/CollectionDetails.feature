Feature: Collection Details API

  GET /api/[culture]/collection/[object-number] gives more details of an object. Object numbers can be obtained from the results given in the Collection API.

  Scenario: requesting the collection details from an art object will retrieve more details on that
    Given I send a Collection details request for the object SK-C-5
    Then I receive a CollectionDetails response for one object with the id SK-C-5