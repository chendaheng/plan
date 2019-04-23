package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("新增系列模型")
public class RangeAddRequest {

    private String name;
    private int customerId;
    private int brandId;
    private int clothingLevelId;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getClothingLevelId() {
        return clothingLevelId;
    }

    public void setClothingLevelId(int clothingLevelId) {
        this.clothingLevelId = clothingLevelId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
