package org.plan.managementfacade.model.infoModel.responseModel;

import io.swagger.annotations.ApiModel;

@ApiModel("款号模型")
public class StyleNumber {

    private Integer id;
    private String number;

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
}
