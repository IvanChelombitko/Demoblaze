package ua.solvd.demoblaze.enums;

public enum Product {
    SAMSUNG_GALAXY_S6("Samsung galaxy s6"),
    NOKIA_LUMIA_1520("Nokia lumia 1520"),
    NEXUS_6("Nexus 6");

    private final String name;

    Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}