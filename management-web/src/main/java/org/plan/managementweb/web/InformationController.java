package org.plan.managementweb.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.responseModel.RangeName;
import org.plan.managementservice.service.InformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.plan.managementfacade.model.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;

import java.util.List;

@RestController
@RequestMapping("/infoManagement")
@Api(value = "计划服务信息服务接口")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class InformationController {

    @Autowired
    private InformationServiceImpl informationServiceImpl;

    @RequestMapping (value = "/getCustomerName", method = RequestMethod.GET)
    @ApiOperation(value = "获取客户名称")
    public List <CustomerName> getCustomerName(@RequestHeader(value = "user-id") String userIdInHeader){
        int userId = Integer.parseInt(userIdInHeader);
        return informationServiceImpl.getCustomerName(userId);
    }

    @RequestMapping (value = "/getBrandName", method = RequestMethod.GET)
    @ApiOperation(value = "获取品牌名称")
    public List <BrandName> getBrandName(){
        return informationServiceImpl.getBrandName();
    }

    @RequestMapping (value = "/getRangeName", method = RequestMethod.GET)
    @ApiOperation(value = "获取系列名称")
    public List <RangeName> getRangeName(){
        return informationServiceImpl.getRangeName();
    }

    @RequestMapping (value = "/getClothingLevelName", method = RequestMethod.GET)
    @ApiOperation(value = "获取服装层次名称")
    public List <ClothingLevelName> getClothingLevelName(){
        return informationServiceImpl.getClothingLevelName();
    }



}

