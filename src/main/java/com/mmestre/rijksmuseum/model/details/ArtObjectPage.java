package com.mmestre.rijksmuseum.model.details;

import java.util.List;

@lombok.Getter @lombok.Setter
public class ArtObjectPage {
    private String id;
    private List<String> similarPages;
    private String lang;
    private String objectNumber;
    private List<String> tags;
    private String plaqueDescription;
    private String audioFile1;
    private String audioFileLabel1;
    private String audioFileLabel2;
    private String createdOn;
    private String updatedOn;
    private AdLibOverrides adlibOverrides;
}
