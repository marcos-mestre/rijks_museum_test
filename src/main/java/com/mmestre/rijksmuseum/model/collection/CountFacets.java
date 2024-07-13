package com.mmestre.rijksmuseum.model.collection;

import com.google.gson.annotations.SerializedName;

@lombok.Getter @lombok.Setter
public class CountFacets {
    @SerializedName("hasimage")
    private long hasImage;
    @SerializedName("ondisplay")
    private long onDisplay;
}
