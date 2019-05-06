package org.plan.managementfacade.model.planModel;

import org.plan.managementfacade.model.enumModel.PlanType;

public class PlanExceptionResp {
    private Integer id;
    private String number;
    private Integer planId;
    private String planNumber;
    private String planName;
    private String customerName;
    private String brandName;
    private String rangeName;
    private PlanType type;
    private Integer planObjectId;
    private String planObject;
    private String cause;
    private String userName;
    private String createTime;

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

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public PlanType getType() {
        return type;
    }

    public void setType(PlanType type) {
        this.type = type;
    }

    public Integer getPlanObjectId() {
        return planObjectId;
    }

    public void setPlanObjectId(Integer planObjectId) {
        this.planObjectId = planObjectId;
    }

    public String getPlanObject() {
        return planObject;
    }

    public void setPlanObject(String planObject) {
        this.planObject = planObject;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
