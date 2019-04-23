package org.plan.managementweb.baseInfoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.baseInfoModel.responseModel.BrandName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.ClothingLevelName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.CustomerName;
import org.plan.managementservice.service.baseInfoManagement.Imply.BaseInfoObtainServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/baseInfoManagement")
@Api(value = "获取基本信息")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        origins = "*")
public class BaseInfoObtainController {

    @Autowired
    private BaseInfoObtainServiceImply baseInfoObtainServiceImply;

    @RequestMapping (value = "/getCustomerName", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户名称")
    public List <CustomerName> getCustomerName(){
        return baseInfoObtainServiceImply.getCustomerName();
    }

    @RequestMapping (value = "/getBrandName", method = RequestMethod.GET)
    @ApiOperation(value = "获取品牌名称")
    public List <BrandName> getBrandName(){
        return baseInfoObtainServiceImply.getBrandName();
    }

    @RequestMapping (value = "/getClothingLevelName", method = RequestMethod.GET)
    @ApiOperation(value = "获取服装层次名称")
    public List <ClothingLevelName> getClothingLevelName(){
        return baseInfoObtainServiceImply.getClothingLevelName();
    }

}
