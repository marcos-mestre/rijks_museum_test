package com.mmestre.steps;

import com.mmestre.client.CollectionClient;
import com.mmestre.client.CollectionDetailsClient;
import com.mmestre.model.CollectionDetailsResponse;
import com.mmestre.model.CollectionResponse;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationSteps {
    @Then("all the artObjects must be made by {string}")
    public void artObjectsMatchesMaker(String expectedMaker) {
        Response response = CollectionClient.getResponse();
        CollectionResponse collectionResponse = response.as(CollectionResponse.class);
        assertNotEquals(0, collectionResponse.getArtObjects().size(),
                "There should be at least one art object to compare.");
        List<Executable> assertions = collectionResponse.getArtObjects().stream()
                .<Executable>map(artObject -> () -> assertEquals(expectedMaker, artObject.getPrincipalOrFirstMaker(),
                        artObject.getId() + ": For this object the maker didn't match.")).collect(Collectors.toList());
        assertAll("Not all the art objects matches the expected maker.", assertions);
    }

    @Then("I receive one object with the id {word}")
    public void artObjectMatchesId(String expectedId) {
        Response response = CollectionDetailsClient.getResponse();
        CollectionDetailsResponse collectionDetailsResponse = response.as(CollectionDetailsResponse.class);
        assertNotNull(collectionDetailsResponse.getArtObject(), "The response didn't include any art object.");
        assertEquals(expectedId, collectionDetailsResponse.getArtObject().getObjectNumber(), "The art object number doesn't match.");
    }
}
