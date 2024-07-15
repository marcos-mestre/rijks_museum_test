@ParameterValidation
Feature: Collection API parameters control

  | Parameter | Format              | Default | Notes                                           |
  | key       | a-z/0-9             |         | Your API-key, mandatory for every request.      |
  | format    | json / jsonp / xml  | json    | The format of the result.                       |
  | culture   | nl / en             |	 	  | The language to search in (and of the results). |
  ...

  Scenario: Passing an unsupported culture parameter should return error 404 Not found
    When I send a Collection request using the following parameters:
      | culture       | sp                 |
      | involvedMaker | Rembrandt+van+Rijn |
    Then the Collection API must return status 404