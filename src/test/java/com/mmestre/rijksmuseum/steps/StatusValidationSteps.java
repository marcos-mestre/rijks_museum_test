package com.mmestre.rijksmuseum.steps;

import com.mmestre.rijksmuseum.client.CollectionClient;
import io.cucumber.java.en.Then;

public class StatusValidationSteps {

    @Then("the Collection API must return status {int}")
    public void checkCollectionStatus(int expectedStatus) {
        CollectionClient.getResponse().then().statusCode(expectedStatus);
    }
}
