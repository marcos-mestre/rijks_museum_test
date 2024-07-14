package com.mmestre.rijksmuseum.client;

import com.mmestre.rijksmuseum.model.collection.CollectionResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.Map;

public class CollectionClient extends RestClient {
    @Getter
    public static Response response;

    public void queryCollection(String culture, Map<String, String> parameters) {
        Map<String, String> paramsWithKey = addKeyToTheParams(parameters);
        queryCollectionWithoutKey(culture, paramsWithKey);
    }

    public void queryCollectionWithoutKey(String culture, Map<String, String> parameters) {
        RequestSpecification collectionRequest = getReqSpecification();
        response = collectionRequest.queryParams(parameters).get(String.format("/api/%s/collection", culture));
    }

    public static CollectionResponse getResponseAsBean() {
        if (response == null) {
            throw new NullPointerException("The CollectionClient must receive an answer before to get the value as java bean.");
        }
        return response.as(CollectionResponse.class);
    }

    public void sendDifferentMethod(String apiMethod) {
        Map<String, String> paramsWithKey = addKeyToTheParams(Map.of());
        String culture = "nl";
        RequestSpecification collectionRequest = getReqSpecification();
        switch (apiMethod) {
            case "POST" ->
                    response = collectionRequest.queryParams(paramsWithKey).post(String.format("/api/%s/collection", culture));
            case "PATCH" ->
                    response = collectionRequest.queryParams(paramsWithKey).patch(String.format("/api/%s/collection", culture));
            case "DELETE" ->
                    response = collectionRequest.queryParams(paramsWithKey).delete(String.format("/api/%s/collection", culture));
            default ->
                    throw new UnsupportedOperationException(String.format("Method %s not implemented yet.", apiMethod));
        }
    }
}
