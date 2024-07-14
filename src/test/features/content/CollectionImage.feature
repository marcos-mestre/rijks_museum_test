@ContentValidation
Feature: Collection Image API

  GET /api/[culture]/collection/[object-number]/tiles gives all the information you need to show the image split up in
  tiles. This is used to implement the zoom functionality on the Rijksmuseum website.

  Scenario: querying the collection image from an art object will return information useful to show images
    Given I send a Collection image request for the object SK-C-5
    Then I receive a collection image response with at least 1 image