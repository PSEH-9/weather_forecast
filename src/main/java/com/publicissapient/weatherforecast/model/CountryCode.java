package com.publicissapient.weatherforecast.model;

public enum CountryCode {
    in("India"), us("USA");

    private String country;

    CountryCode(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
