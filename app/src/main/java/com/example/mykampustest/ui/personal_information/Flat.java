package com.example.mykampustest.ui.personal_information;

public class Flat {
    private static final String URL_BASE = "https://kamtjatka.dk/lejemaal/kategori-";
    private String category;
    private String description;
    private String rent;
    private String url;

    public Flat(String category, String description, String rent, String urlAdd) {
        this.category = category;
        this.description = description;
        this.rent = rent;
        this.url = URL_BASE + urlAdd;
    }

    String getCategory() {
        return category;
    }

    String getDescription() {
        return description;
    }

    String getRent() {
        return rent;
    }

    String getUrl() {
        return url;
    }
}
