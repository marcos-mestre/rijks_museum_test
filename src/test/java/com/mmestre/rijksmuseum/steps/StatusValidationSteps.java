package com.mmestre.rijksmuseum.steps;

import com.mmestre.rijksmuseum.client.CollectionClient;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StatusValidationSteps {

    @Then("the Collection API must return status {int}")
    public void checkCollectionStatus(int expectedStatusCode) {
        int currentStatusCode = CollectionClient.getResponse().getStatusCode();
        log.debug("Response status code: {}, expected status code: {}.", currentStatusCode, expectedStatusCode);
        CollectionClient.getResponse().then().statusCode(expectedStatusCode);
    }
}
