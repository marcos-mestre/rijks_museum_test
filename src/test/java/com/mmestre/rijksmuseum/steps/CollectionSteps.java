package com.mmestre.rijksmuseum.steps;

import com.mmestre.rijksmuseum.client.CollectionClient;
import com.mmestre.rijksmuseum.client.CollectionDetailsClient;
import com.mmestre.rijksmuseum.client.CollectionImageClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.Map;

public class CollectionSteps {
    @Given("I send a Collection request with the involvedMaker {word}")
    public void collectionByInvolvedMaker(String involvedMaker) {
        Map<String, String> parameters = Map.of("involvedMaker", involvedMaker);
        new CollectionClient().queryCollection("nl", parameters);
    }

    @Given("I send a Collection request without key to the involvedMaker {word}")
    public void collectionByInvolvedMakerWithoutKey(String involvedMaker) {
        Map<String, String> parameters = Map.of("involvedMaker", involvedMaker);
        new CollectionClient().queryCollectionWithoutKey("nl", parameters);
    }


    @Given("I send a Collection request without key using the following parameters:")
    public void collectionWithoutKey(DataTable table) {
        Map<String,String> parameters = table.asMap();
        new CollectionClient().queryCollectionWithoutKey("nl", parameters);
    }

    @Given("I call the Collection API using the method {word}")
    public void collectionByMethod(String method) {
        new CollectionClient().sendDifferentMethod(method);
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
