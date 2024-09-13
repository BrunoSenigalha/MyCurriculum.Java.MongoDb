package com.brunosenigalha.curriculumMongoDb.dto;

public class AddressDTO {

    private String zipCode;
    private String state;
    private String city;
    private String country;

    public AddressDTO(String zipCode, String state, String city, String country) {
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}


