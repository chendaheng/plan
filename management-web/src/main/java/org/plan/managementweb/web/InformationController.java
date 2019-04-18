package org.plan.managementweb.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementservice.service.InformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.plan.managementfacade.model.responseModel.*;

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
    public List <CustomerName> getCustomerName(){
        return informationServiceImpl.getCustomerName();
    }
}

