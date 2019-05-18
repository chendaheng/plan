package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("获取系列条件参数模型")
public class RangeSearchRequest {
    private Integer userId;
    private Integer id;
    private Integer customerId;
    private Integer brandId;
    private Integer clothingLevelId;
    private String startDate;
    private String endDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getClothingLevelId() {
        return clothingLevelId;
    }

    public void setClothingLevelId(Integer clothingLevelId) {
        this.clothingLevelId = clothingLevelId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
