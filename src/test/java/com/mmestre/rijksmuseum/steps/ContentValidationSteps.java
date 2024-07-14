package com.mmestre.rijksmuseum.steps;

import com.mmestre.rijksmuseum.client.CollectionClient;
import com.mmestre.rijksmuseum.client.CollectionDetailsClient;
import com.mmestre.rijksmuseum.client.CollectionImageClient;
import com.mmestre.rijksmuseum.model.collection.CollectionResponse;
import com.mmestre.rijksmuseum.model.details.CollectionDetailsResponse;
import com.mmestre.rijksmuseum.model.image.CollectionImageResponse;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ContentValidationSteps {
    @Then("all the artObjects received in the Collection Response must be made by {string}")
    public void artObjectsMatchesMaker(String expectedMaker) {
        CollectionResponse collectionResponse = CollectionClient.getResponseAsBean();
        assertNotEquals(0, collectionResponse.getArtObjects().size(),
                "There should be at least one art object to compare.");
        List<Executable> assertions = collectionResponse.getArtObjects().stream()
                .<Executable>map(artObject -> () -> assertEquals(expectedMaker, artObject.getPrincipalOrFirstMaker(),
                        artObject.getId() + ": For this object the maker didn't match.")).collect(Collectors.toList());
        assertAll("Not all the art objects matches the expected maker.", assertions);
    }

    @Then("I receive a CollectionDetails response for one object with the id {word}")
    public void artObjectMatchesId(String expectedId) {
        CollectionDetailsResponse collectionDetailsResponse = CollectionDetailsClient.getResponseAsBean();
        assertNotNull(collectionDetailsResponse.getArtObject(), "The response didn't include any art object.");
        assertEquals(expectedId, collectionDetailsResponse.getArtObject().getObjectNumber(), "The art object number doesn't match.");
    }

    @Then("I receive a collection image response with at least {int} image(s)")
    public void minimumImagesReceived(int minimumImages) {
        CollectionImageResponse collectionImageResponse = CollectionImageClient.getResponseAsBean();
        assertNotNull(collectionImageResponse, "The response couldn't been parsed to the CollectionImageResponse class.");
        assertNotNull(collectionImageResponse.getLevels(), "Then response didn't return a list of levels");
        int imagesReceived = collectionImageResponse.getLevels().size();
        assertTrue(imagesReceived >= minimumImages, String.format("The images received (%s) should be at least %s.", imagesReceived, minimumImages));
    }
}
