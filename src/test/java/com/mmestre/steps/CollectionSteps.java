package com.mmestre.steps;

import com.mmestre.client.CollectionClient;
import com.mmestre.client.CollectionDetailsClient;
import com.mmestre.client.CollectionImageClient;
import io.cucumber.java.en.Given;

import java.util.Map;

public class CollectionSteps {
    @Given("I send a Collection request with the involvedMaker {word}")
    public void collectionByInvolvedMaker(String involvedMaker) {
        Map<String, String> parameters = Map.of("involvedMaker", involvedMaker);
        new CollectionClient().queryCollection("nl", parameters);
    }

    @Given("I send a Collection details request for the object {word}")
    public void collectionDetailsById(String id) {
        Map<String, String> parameters = Map.of();
        new CollectionDetailsClient().queryCollectionDetails("nl", id, parameters);
    }

    @Given("I send a Collection image request for the object {word}")
    public void collectionImageById(String id) {
        Map<String, String> parameters = Map.of();
        new CollectionImageClient().queryCollectionDetails("nl", id, parameters);
    }
}
