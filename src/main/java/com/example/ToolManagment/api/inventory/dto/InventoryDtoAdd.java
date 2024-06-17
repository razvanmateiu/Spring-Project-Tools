package com.example.ToolManagment.api.inventory.dto;

import java.sql.Date;

public class InventoryDtoAdd {
    Integer idTool;
    Integer idSite;
    Date entryDate;
    Date exitDate;

    public Integer getIdTool() {
        return idTool;
    }

    public Integer getIdSite() {
        return idSite;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }
}
