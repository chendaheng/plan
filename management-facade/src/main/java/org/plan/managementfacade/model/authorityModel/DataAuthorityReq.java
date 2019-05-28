package org.plan.managementfacade.model.authorityModel;

import java.util.List;

public class DataAuthorityReq {
    private Integer userId;
    private String userName;
    private Integer customerId;
    private List<Integer> brandIdList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getBrandIdList() {
        return brandIdList;
    }

    public void setBrandIdList(List<Integer> brandIdList) {
        this.brandIdList = brandIdList;
    }
}
