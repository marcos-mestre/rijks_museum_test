package com.mmestre.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.Map;

public class CollectionClient extends RestClient {
    @Getter
    public static Response response;

    public void queryCollection(String culture, Map<String, String> parameters) {
        Map<String, String> curatedParams = getCuratedParams(parameters);
        RequestSpecification collectionRequest = getReqSpecification();
        response = collectionRequest.queryParams(curatedParams).get(String.format("/api/%s/collection", culture));
    }
}
