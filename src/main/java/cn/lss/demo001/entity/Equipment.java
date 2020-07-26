package cn.lss.demo001.entity;

import java.util.Objects;

public class Equipment {

    private int id;
    private String city;
    private String province;
    private int available;
    private String street;
    private String number;
    private String description;
    private Double longitude;
    private Double latitude;
    private String categoryName;
    private String name;
    public Equipment() {
    }

    public Equipment(String city, String province, int available, String street, String number, String description, Double longitude, Double latitude, String categoryName, String name) {
        this.city = city;
        this.province = province;
        this.available = available;
        this.street = street;
        this.number = number;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.categoryName = categoryName;
        this.name = name;
    }

    public Equipment(String name,String categoryName,Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.categoryName = categoryName;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id == equipment.id &&
                available == equipment.available &&
                Objects.equals(city, equipment.city) &&
                Objects.equals(province, equipment.province) &&
                Objects.equals(street, equipment.street) &&
                Objects.equals(number, equipment.number) &&
                Objects.equals(description, equipment.description) &&
                Objects.equals(longitude, equipment.longitude) &&
                Objects.equals(latitude, equipment.latitude) &&
                Objects.equals(categoryName, equipment.categoryName) &&
                Objects.equals(name, equipment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, province, available, street, number, description, longitude, latitude, categoryName, name);
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", available=" + available +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", categoryName='" + categoryName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
