package com.cviceni.cv5;

public class Weather {
    private String name;
    private String description;
    private double temperature;
    private double wind;

    public Weather(String name, String description, double temperature, double wind) {
        this.name = name;
        this.description = description;
        this.temperature = temperature;
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }
}
