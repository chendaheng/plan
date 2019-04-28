package org.plan.managementfacade.model.infoModel.responseModel;

import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;

@ApiModel("系列返回模型")
public class RangeResponse {
    private Integer id;
    private String number;
    private String name;
    private Integer customerId;
    private String customerName; // 待取
    private Integer brandId;
    private String brandName; // 待取
    private Integer clothingLevelId;
    private String clothingLevelName; // 待取
    private Integer styleQuantity;
    private String deptName; // 待取
    private Integer addingMode;
    private String addingModeStr;
    private Integer state;
    private Integer createrId;
    private String createrName; // 待取
    private Timestamp createTime;
    private String note;
    private Boolean havePredictPlan;
    private Boolean havePlan;
    private Boolean isCompleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getClothingLevelId() {
        return clothingLevelId;
    }

    public void setClothingLevelId(Integer clothingLevelId) {
        this.clothingLevelId = clothingLevelId;
    }

    public String getClothingLevelName() {
        return clothingLevelName;
    }

    public void setClothingLevelName(String clothingLevelName) {
        this.clothingLevelName = clothingLevelName;
    }

    public Integer getStyleQuantity() {
        return styleQuantity;
    }

    public void setStyleQuantity(Integer styleQuantity) {
        this.styleQuantity = styleQuantity;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getAddingMode() {
        return addingMode;
    }

    public void setAddingMode(Integer addingMode) {
        this.addingMode = addingMode;
    }

    public String getAddingModeStr() {
        return addingModeStr;
    }

    public void setAddingModeStr(String addingModeStr) {
        this.addingModeStr = addingModeStr;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
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
