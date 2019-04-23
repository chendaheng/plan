package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;

@ApiModel("获取系列条件模型")
public class RangeSearchRequest {
    private int id = -1;
    private int customerId = -1;
    private int brandId = -1;
    private int clothingLevelId = -1;
    private Timestamp startDate = null;
    private Timestamp endDate = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
