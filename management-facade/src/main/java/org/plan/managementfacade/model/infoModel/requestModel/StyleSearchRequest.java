package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;

@ApiModel("获取款式条件参数模型")
public class StyleSearchRequest {

    private int userId = -1;
    private int id = -1;
    private String number = null;
    private int customerId = -1;
    private int brandId = -1;
    private int rangeId = -1;
    private int clothingLevelId = -1;
    private Timestamp startDate = null;
    private Timestamp endDate = null;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public int getRangeId() {
        return rangeId;
    }

    public void setRangeId(int rangeId) {
        this.rangeId = rangeId;
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
