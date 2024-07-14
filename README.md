# rijks_museum_test

This project is an exercise of implementing backend testing using Cucumber-JVM as test framework.

The test subject is in this case a Rijksmuseum REST api. This API provides access to details from the ART objects from the museum.

## Museum documentation

* Museum URL: <https://www.rijksmuseum.nl/nl>
* Museum API documentation: <https://data.rijksmuseum.nl/object-metadata/api/>

## Tech stack

The technologies that are being in place in this project to test the API are the following:

* [Cucumber](https://cucumber.io/)
* [Java 17](https://www.oracle.com/java/technologies/javase/17-relnote-issues.html)
* [JUnit 5](https://junit.org/junit5/)
* [RestAssured](https://rest-assured.io/)
* [Gson](https://github.com/google/gson)
* [GitHub Actions](https://docs.github.com/en/actions)
* [Cucumber reports](https://reports.cucumber.io)

## Tests implemented

Currently only few test cases were implemented, as this exercise is only be designed to show the possibilities, but it is not trying to try to cover all the required scenarios.

From those, 3 scenarios are matching the examples provided by the API documentation at the beginning of July 2024.

## Test reports

The cucumber tests are being automatically uploaded to reports.cucumber.io, to the following collection.
https://reports.cucumber.io/report-collections/5bd3ceaf-63c2-4e97-a098-939b0e1409dd
