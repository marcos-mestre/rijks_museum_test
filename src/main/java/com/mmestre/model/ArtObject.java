package com.mmestre.model;

import java.util.List;

@lombok.Getter @lombok.Setter
public class ArtObject {
    private Links links;
    private String id;
    private String priref;
    private String objectNumber;
    private String language;
    private String title;
    private String copyrightHolder;
    private boolean hasImage;
    private String principalOrFirstMaker;
    private String longTitle;
    private boolean showImage;
    private boolean permitDownload;
    private Image webImage;
    private Image headerImage;
    private List<Colors> colors;
    private List<ColorsWithNormalization> colorsWithNormalization;
    private List<Colors> normalizedColors;
    private List<Colors> normalized32Colors;
    private List<String> materialsThesaurus;
    private List<String> techniquesThesaurus;
    private List<String> productionPlacesThesaurus;
    private List<String> titles;
    private String description;
    private String labelText;
    private List<String> objectTypes;
    private List<String> objectCollection;
    private List<Maker> makers;
    private List<Maker> principalMakers;
    private String plaqueDescriptionDutch;
    private String plaqueDescriptionEnglish;
    private String principalMaker;
    private String artistRole;
    private List<String> associations;
    private Acquisition acquisition;
    private List<String> exhibitions;
    private List<String> materials;
    private List<String> techniques;
    private List<String> productionPlaces;
    private Dating dating;
    private Classification classification;
    private List<String> historicalPersons;
    private List<String> inscriptions;
    private List<String> documentation;
    private List<String> catRefRPK;
    private List<Dimension> dimensions;
    private List<String> physicalProperties;
    private String physicalMedium;
    private String subTitle;
    private String scLabelLine;
    private Label label;
    private String location;
}
