package com.example.ToolManagment.api.sites.dto;

public class SitesDtoAdd {
    String streetName;
    String streetNumber;
    String city;
    Integer postalCode;
    Integer idPerson;

    public String getStreetName() {
        return streetName;
    }
    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public Integer getIdPerson() {
        return idPerson;
    }
}
