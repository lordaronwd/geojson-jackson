package org.geojson;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Circle extends GeoJsonObject {

    private LngLatAlt coordinates;
    private Double radius;
    @JsonInclude
    private Map<String, Object> properties = new HashMap<String, Object>();

    public Circle() {
    }

    public Circle(LngLatAlt coordinates, Double radius) {
        this.coordinates = coordinates;
        this.radius = radius;
    }

    public Circle(double longitude, double latitude, Double radius) {
        this.coordinates = new LngLatAlt(longitude, latitude);
        this.radius = radius;
    }

    public Circle(double longitude, double latitude, double altitude, Double radius) {
        this.coordinates = new LngLatAlt(longitude, latitude, altitude);
        this.radius = radius;
    }

    public Circle(double longitude, double latitude, double altitude, Double radius, double... additionalElements) {
        this.coordinates = new LngLatAlt(longitude, latitude, altitude, additionalElements);
        this.radius = radius;
    }

    public LngLatAlt getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LngLatAlt coordinates) {
        this.coordinates = coordinates;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    @Override
    public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
        return geoJsonObjectVisitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String toString() {
        return String.format("Circle{coordinates=[%s], radius=[%f]}", coordinates, radius) + super.toString();
    }
}
