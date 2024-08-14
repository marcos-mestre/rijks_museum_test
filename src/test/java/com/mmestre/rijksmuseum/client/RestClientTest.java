package com.mmestre.rijksmuseum.client;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RestClientTest {

    private RestClient client;

    @BeforeEach
    void setUpClient() {
        System.setProperty("key", "testApiKey");
        client = new RestClient();
    }

    @Test
    void testInitializationRunsOnce() {
        String testUrl = "http://test.domain/";
        RestAssured.baseURI = testUrl;
        new RestClient();
        assertEquals(testUrl, RestAssured.baseURI,
                "The RestClient should initialize and setup the URL of the RestAssured framework only once");
    }

    @Test
    void testGetReqSpecification() {
        RequestSpecification spec = client.getReqSpecification();
        assertNotNull(spec, "The specification should be initialized.");
    }

    @Test
    void testAddKeyToTheParams() {
        Map<String, String> params = new HashMap<>();
        params.put("param1", "value1");

        Map<String, String> result = client.addKeyToTheParams(params);

        assertEquals("testApiKey", result.get("key"));
        assertEquals("value1", result.get("param1"));
    }
}