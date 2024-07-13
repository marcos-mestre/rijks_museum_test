package com.mmestre.rijksmuseum.model.common;

import java.util.List;

@lombok.Getter @lombok.Setter
public class Classification {
    private List<String> iconClassIdentifier;
    private List<String> iconClassDescription;
    private List<String> motifs;
    private List<String> events;
    private List<String> periods;
    private List<String> places;
    private List<String> people;
    private List<String> objectNumbers;
}
