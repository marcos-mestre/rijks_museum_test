package com.mmestre.rijksmuseum.model.details;

import com.mmestre.rijksmuseum.model.common.ArtObject;

@lombok.Getter @lombok.Setter
public class CollectionDetailsResponse {
    private long elapsedMilliseconds;
    private ArtObject artObject;
    private ArtObjectPage artObjectPage;
}
