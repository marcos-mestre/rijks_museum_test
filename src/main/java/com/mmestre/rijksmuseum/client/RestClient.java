package com.mmestre.rijksmuseum.client;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

class RestClient {
    protected static final String key = System.getProperty("api.key");
    private static final String baseUrl = "https://www.rijksmuseum.nl";
    private static volatile boolean initiated;

    protected RestClient() {
        if (!initiated) {
            synchronized (this) {
                if (!initiated) {
                    RestAssured.baseURI = baseUrl;
                    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
                }
            }
        }
        initiated = true;
    }

    protected RequestSpecification getReqSpecification() {
        return RestAssured.given().urlEncodingEnabled(false);
    }

    protected Map<String, String> addKeyToTheParams(Map<String, String> parameters) {
        Map<String, String> curatedParams = new HashMap<>();
        curatedParams.put("key", key);
        curatedParams.putAll(parameters);
        return curatedParams;
    }
}
