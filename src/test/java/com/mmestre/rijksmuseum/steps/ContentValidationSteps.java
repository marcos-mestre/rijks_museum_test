package com.mmestre.rijksmuseum.steps;

import com.mmestre.rijksmuseum.client.CollectionClient;
import com.mmestre.rijksmuseum.client.CollectionDetailsClient;
import com.mmestre.rijksmuseum.client.CollectionImageClient;
import com.mmestre.rijksmuseum.model.collection.CollectionResponse;
import com.mmestre.rijksmuseum.model.common.ArtObject;
import com.mmestre.rijksmuseum.model.details.CollectionDetailsResponse;
import com.mmestre.rijksmuseum.model.image.CollectionImageResponse;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
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

    @Then("all the artObjects received in the Collection Response must be sorted out in {word} way")
    public void checkArtObjectsSorting(String expectedSortMethod) {
        CollectionResponse responseAsBean = CollectionClient.getResponseAsBean();
        assertNotEquals(0, responseAsBean.getArtObjects().size());
        List<String> retrievedListOfObjectNumbers = responseAsBean.getArtObjects().stream().map(ArtObject::getObjectNumber).toList();
        List<Long> retrievedListOfSortingDate = new ArrayList<>();
        retrievedListOfObjectNumbers.forEach(on ->{
            new CollectionDetailsClient().queryCollectionDetails("nl", on, Map.of());
            retrievedListOfSortingDate.add(CollectionDetailsClient.getResponseAsBean().getArtObject().getDating().getSortingDate());
        });
        List<Long> sortedList;
        if (expectedSortMethod.equalsIgnoreCase("chronological")){
            sortedList = sortInChronological(retrievedListOfSortingDate);
        } else if (expectedSortMethod.equalsIgnoreCase("achronological")){
            sortedList = sortInAchronological(retrievedListOfSortingDate);
        } else {
            throw new UnsupportedOperationException(String.format("The sort method %s has not been implemented yet.", expectedSortMethod));
        }
        for (int i = 0; i < retrievedListOfSortingDate.size(); i++) {
            log.info("ObjectId: {}, retrieved date {}, sorted date: {}",
                    retrievedListOfObjectNumbers.get(i), retrievedListOfSortingDate.get(i), sortedList.get(i));
            assertEquals(retrievedListOfSortingDate.get(i).longValue(),sortedList.get(i).longValue(), "The sorted values are not matching.");
        }
    }

    private List<Long> sortInChronological(List<Long> inputList){
        return new ArrayList<>(inputList).stream().sorted().toList();
    }

    private List<Long> sortInAchronological(List<Long> inputList){
        return new ArrayList<>(inputList).stream().sorted(Comparator.reverseOrder()).toList();
    }
}
