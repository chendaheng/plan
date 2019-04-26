package org.plan.managementfacade.model.infoModel.responseModel;

import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;

@ApiModel("款式返回模型")
public class StyleResponse {
    private int id;
    private String number;
    private int rangeId;
    private String rangeNumber; // 待取
    private String rangeName; // 待取
    private int styleGroupId;
    private String styleGroupNumber;
    private String styleGroupName;
    private int customerId; // 待取
    private String customerName; // 待取
    private int brandId; // 待取
    private String brandName; // 待取
    private int clothingLevelId; // 待取
    private String clothingLevelName; // 待取
    private int createrId;
    private String createrName;
    private Timestamp createTime;
    private String deptName;
    private int addingMode;
    private String addingModeStr;
    private int state;
    private Boolean havePlan;

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

    public int getRangeId() {
        return rangeId;
    }

    public void setRangeId(int rangeId) {
        this.rangeId = rangeId;
    }

    public String getRangeNumber() {
        return rangeNumber;
    }

    public void setRangeNumber(String rangeNumber) {
        this.rangeNumber = rangeNumber;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public int getStyleGroupId() {
        return styleGroupId;
    }

    public void setStyleGroupId(int styleGroupId) {
        this.styleGroupId = styleGroupId;
    }

    public String getStyleGroupNumber() {
        return styleGroupNumber;
    }

    public void setStyleGroupNumber(String styleGroupNumber) {
        this.styleGroupNumber = styleGroupNumber;
    }

    public String getStyleGroupName() {
        return styleGroupName;
    }

    public void setStyleGroupName(String styleGroupName) {
        this.styleGroupName = styleGroupName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getClothingLevelId() {
        return clothingLevelId;
    }

    public void setClothingLevelId(int clothingLevelId) {
        this.clothingLevelId = clothingLevelId;
    }

    public String getClothingLevelName() {
        return clothingLevelName;
    }

    public void setClothingLevelName(String clothingLevelName) {
        this.clothingLevelName = clothingLevelName;
    }

    public int getCreaterId() {
        return createrId;
    }

    public void setCreaterId(int createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getAddingMode() {
        return addingMode;
    }

    public void setAddingMode(int addingMode) {
        this.addingMode = addingMode;
    }

    public String getAddingModeStr() {
        return addingModeStr;
    }

    public void setAddingModeStr(String addingModeStr) {
        this.addingModeStr = addingModeStr;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Boolean getHavePlan() {
        return havePlan;
    }

    public void setHavePlan(Boolean havePlan) {
        this.havePlan = havePlan;
    }
}
