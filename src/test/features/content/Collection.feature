@ContentValidation
Feature: Collection API

  GET /api/[culture]/collection gives access to the collection with brief information about each object. The results are
  split up in result pages. By using the p and ps parameters you can fetch more results, up to a total of 10,000. All of
  the other parameters are identical to the advanced search page on the Rijksmuseum website. You can use that page to
  find out what’s the best query to use.

  Scenario: requesting the collection using a specific involvedMaker will return objects only from the chosen agent
    When I send a Collection request with the involvedMaker Rembrandt+van+Rijn
    Then all the artObjects received in the Collection Response must be made by "Rembrandt van Rijn"

  Scenario: requesting the collection being sort by chronological must return sorted objects
    When I send a Collection request using the following parameters:
      | involvedMaker | Vincent+van+Gogh |
      | ps            | 10               |
      | s             | chronologic      |
    Then all the artObjects received in the Collection Response must be sorted out in chronological way

  Scenario: requesting the collection being sort by chronological must return sorted objects
    When I send a Collection request using the following parameters:
      | involvedMaker | Vincent+van+Gogh |
      | ps            | 10               |
      | s             | achronologic     |
    Then all the artObjects received in the Collection Response must be sorted out in achronological way