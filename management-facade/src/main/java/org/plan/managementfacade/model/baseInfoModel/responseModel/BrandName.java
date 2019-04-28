package org.plan.managementfacade.model.baseInfoModel.responseModel;

import io.swagger.annotations.ApiModel;

@ApiModel("品牌名称模型")
public class BrandName {
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
