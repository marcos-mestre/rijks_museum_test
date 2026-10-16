package com.mmestre.rijksmuseum.client;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

class RestClient {
    protected static final String key = System.getProperty("key");
    private static final String baseUrl = "https://www.rijksmuseum.nl";
    private static volatile boolean initiated;

    protected RestClient() {
        if (!initiated) {
            synchronized (this) {
                if (!initiated) {
                    RestAssured.baseURI = baseUrl;
                    RestAssured.defaultParser = Parser.JSON;
                    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
                }
            }
        }
        initiated = true;
    }

    protected RequestSpecification getReqSpecification() {
        RequestSpecification requestSpecification = RestAssured.given().urlEncodingEnabled(false);
        RequestLogSpecification log = requestSpecification.log();
        return log.all();
    }

    protected Map<String, String> addKeyToTheParams(Map<String, String> parameters) {
        Map<String, String> curatedParams = new HashMap<>();
        curatedParams.put("key", key);
        curatedParams.putAll(parameters);
        return curatedParams;
    }
}
