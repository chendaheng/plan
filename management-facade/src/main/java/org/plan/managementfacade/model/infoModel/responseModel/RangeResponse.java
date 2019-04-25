package org.plan.managementfacade.model.infoModel.responseModel;

import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;

@ApiModel("系列返回模型")
public class RangeResponse {
    private int id;
    private String number;
    private String name;
    private int customerId;
    private String customerName; // 待取
    private int brandId;
    private String brandName; // 待取
    private int clothingLevelId;
    private String clothingLevelName; // 待取
    private int styleQuantity;
    private String deptName; // 待取
    private int addingMode;
    private String addingModeStr;
    private int state;
    private int createrId;
    private String createrName; // 待取
    private Timestamp createTime;
    private String note;
    private Boolean havePredictPlan;
    private Boolean havePlan;
    private Boolean isCompleted;

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

    public int getStyleQuantity() {
        return styleQuantity;
    }

    public void setStyleQuantity(int styleQuantity) {
        this.styleQuantity = styleQuantity;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getHavePredictPlan() {
        return havePredictPlan;
    }

    public void setHavePredictPlan(Boolean havePredictPlan) {
        this.havePredictPlan = havePredictPlan;
    }

    public Boolean getHavePlan() {
        return havePlan;
    }

    public void setHavePlan(Boolean havePlan) {
        this.havePlan = havePlan;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
