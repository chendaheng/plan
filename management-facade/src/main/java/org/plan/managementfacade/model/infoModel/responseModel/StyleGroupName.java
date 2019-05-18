package org.plan.managementfacade.model.infoModel.responseModel;

import io.swagger.annotations.ApiModel;

@ApiModel("款式组名称模型")
public class StyleGroupName {

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
