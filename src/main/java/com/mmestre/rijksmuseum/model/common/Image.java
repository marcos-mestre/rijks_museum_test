package com.mmestre.rijksmuseum.model.common;

@lombok.Getter @lombok.Setter
public class Image {
    private String guid;
    private int offsetPercentageX;
    private int offsetPercentageY;
    private int width;
    private int height;
    private String url;
}
