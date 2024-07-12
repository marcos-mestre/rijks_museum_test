package com.mmestre.model;

import java.util.List;

@lombok.Getter @lombok.Setter
public class CollectionResponse {
    private long elapsedMilliseconds;
    private long count;
    private CountFacets countFacets;
    private List<ArtObject> artObjects;
}
