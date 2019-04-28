package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("绑定款式组参数模型")
public class BindStyleGroupRequest {

    private Integer styleGroupId;
    private String styleGroupNumber;
    private String styleGroupName;
    private String styleNumber;

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

    public String getStyleNumber() {
        return styleNumber;
    }

    public void setStyleNumber(String styleNumber) {
        this.styleNumber = styleNumber;
    }
}
