package com.example.hw2_weather_forecasts;

public class City {
    private String name;
    private double lat;
    private double lon;

    public City(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String toString() {
        return "City: " + this.name + "\nLat: " + this.lat + "\nLon: " + this.lon;
    }
}
