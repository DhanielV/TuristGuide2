package com.example.turistguide2.model;

public enum Tags {

    ANT_TOURISM("Anti-tourism"),
    OVERCROWDED("Overcrowded"),
    CRUISES("Cruises"),
    ENVIRONMENT("Environment"),
    POLLUTION("Pollution"),
    FRAGILE_ECOSYSTEM("Fragile ecosystem"),
    COMMERCIALIZATION("Commercialization"),
    HOTSPOT("Hotspot");

    private final String displayName;

    Tags(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
