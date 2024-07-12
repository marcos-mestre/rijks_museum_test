package com.mmestre.model;

@lombok.Getter @lombok.Setter
public class CollectionDetailsResponse {
    private long elapsedMilliseconds;
    private ArtObject artObject;
    private ArtObjectPage artObjectPage;
}
