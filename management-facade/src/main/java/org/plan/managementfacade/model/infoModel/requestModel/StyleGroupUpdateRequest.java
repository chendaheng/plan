package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("更新款式组信息参数模型")
public class StyleGroupUpdateRequest {
    private Integer id;
    private String name;
    private Integer rangeId;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
        this.rangeId = rangeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
