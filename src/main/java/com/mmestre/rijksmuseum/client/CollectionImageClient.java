package com.mmestre.rijksmuseum.client;

import com.mmestre.rijksmuseum.model.image.CollectionImageResponse;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.Map;

public class CollectionImageClient extends RestClient {

    @Getter
    public static Response response;

    public void queryCollectionDetails(String culture, String id, Map<String, String> parameters) {
        Map<String, String> curatedParams = getCuratedParams(parameters);
        RequestSpecification collectionRequest = getReqSpecification();
        response = collectionRequest.queryParams(curatedParams).get(String.format("/api/%s/collection/%s/tiles", culture, id));
    }

    public static CollectionImageResponse getResponseAsBean() {
        if (response == null) {
            throw new NullPointerException("The CollectionImageClient must receive an answer before to get the value as java bean.");
        }
        return response.as(CollectionImageResponse.class, ObjectMapperType.GSON);
    }
}