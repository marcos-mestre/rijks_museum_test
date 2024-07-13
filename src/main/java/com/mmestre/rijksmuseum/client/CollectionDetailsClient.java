package com.mmestre.rijksmuseum.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.Map;

public class CollectionDetailsClient extends RestClient {
    @Getter
    public static Response response;

    public void queryCollectionDetails(String culture, String id, Map<String, String> parameters) {
        Map<String, String> curatedParams = getCuratedParams(parameters);
        RequestSpecification collectionRequest = getReqSpecification();
        response = collectionRequest.queryParams(curatedParams).get(String.format("/api/%s/collection/%s", culture, id));
    }
}
