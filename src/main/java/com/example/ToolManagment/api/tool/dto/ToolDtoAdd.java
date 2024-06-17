package com.example.ToolManagment.api.tool.dto;

public class ToolDtoAdd {
    String manufacturer;
    String type;
    Double price;
    Boolean status;
    Long qrCode;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getQrCode() {
        return qrCode;
    }
}
