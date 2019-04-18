package org.plan.managementfacade.model.responseModel;

import io.swagger.annotations.ApiModel;

@ApiModel("服装层次名称模型")
public class ClothingLevelName {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
