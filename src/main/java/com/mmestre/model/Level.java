package com.mmestre.model;

import java.util.List;

@lombok.Getter @lombok.Setter
public class Level {
    private String name;
    private long width;
    private long height;
    private List<Tile> tiles;
}
