package org.plan.managementfacade.model.infoModel.responseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;

import java.sql.Timestamp;

@ApiModel("款式返回模型")
public class StyleResponse {
    private Integer id;
    private String number;
    private Integer rangeId;
    private String rangeNumber; // 待取
    private String rangeName; // 待取
    private Integer styleGroupId;
    private String styleGroupNumber;
    private String styleGroupName;
    private Integer customerId; // 待取
    private String customerName; // 待取
    private Integer brandId; // 待取
    private String brandName; // 待取
    private Integer clothingLevelId; // 待取
    private String clothingLevelName; // 待取
    private Integer createrId;
    private String createrName;
    private Timestamp createTime;
    private String deptName;
    private Integer addingMode;
    private String addingModeStr;
    private Integer state;
    private Boolean havePlan;

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

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
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

    public Integer getStyleGroupId() {
        return styleGroupId;
    }

    public void setStyleGroupId(Integer styleGroupId) {
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

    public Boolean getHavePlan() {
        return havePlan;
    }

    public void setHavePlan(Boolean havePlan) {
        this.havePlan = havePlan;
    }
}
