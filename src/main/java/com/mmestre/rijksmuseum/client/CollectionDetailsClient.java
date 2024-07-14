package com.mmestre.rijksmuseum.client;

import com.mmestre.rijksmuseum.model.details.CollectionDetailsResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.Map;

public class CollectionDetailsClient extends RestClient {
    @Getter
    public static Response response;

    public void queryCollectionDetails(String culture, String id, Map<String, String> parameters) {
        Map<String, String> paramsWithKey = addKeyToTheParams(parameters);
        RequestSpecification collectionRequest = getReqSpecification();
        response = collectionRequest.queryParams(paramsWithKey).get(String.format("/api/%s/collection/%s", culture, id));
    }

    public static CollectionDetailsResponse getResponseAsBean() {
        if (response == null) {
            throw new NullPointerException("The CollectionDetailsClient must receive an answer before to get the value as java bean.");
        }
        return response.as(CollectionDetailsResponse.class);
    }
}
