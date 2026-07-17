package ua.solvd.demoblaze.model;

public enum Product {
    SAMSUNG_GALAXY_S6("Samsung galaxy s6", "360"),
    NOKIA_LUMIA_1520("Nokia lumia 1520", "820"),
    NEXUS_6("Nexus 6", "650");

    private final String name;
    private final String price;

    Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}