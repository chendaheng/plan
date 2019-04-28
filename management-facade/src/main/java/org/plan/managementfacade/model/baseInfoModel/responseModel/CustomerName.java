package org.plan.managementfacade.model.baseInfoModel.responseModel;

import io.swagger.annotations.ApiModel;

@ApiModel("客户名称模型")
public class CustomerName {
    private Integer id;
    private String name;

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
}
