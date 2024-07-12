package com.mmestre.model;

import com.google.gson.annotations.SerializedName;

@lombok.Getter @lombok.Setter
public class CountFacets {
    @SerializedName("hasimage")
    private long hasImage;
    @SerializedName("ondisplay")
    private long onDisplay;
}
