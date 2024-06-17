package com.example.ToolManagment.domain.tool;

import jakarta.persistence.*;

@Entity
@Table
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTool;
    String manufacturer;
    String type;
    Double price;
    Boolean status;
    Long qrCode;

    public int getIdTool() {
        return idTool;
    }

    public void setIdTool(int idTool) {
        this.idTool = idTool;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getQrCode() {
        return qrCode;
    }

    public void setQrCode(Long qrCode) {
        this.qrCode = qrCode;
    }
}
