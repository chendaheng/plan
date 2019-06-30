package org.plan.managementfacade.model.baseInfoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("搜索消息模型")
public class MessageSearchReq {
    private String startDate;
    private String endDate;
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
