package org.plan.managementweb.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.WarehouseStockInPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.plan.managementservice.service.*;

import java.util.List;

@RestController
@RequestMapping("/planmanagement")
@Api(value = "计划管理接口")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class PlanController {

    @Autowired
    private PlanServiceImpl planServiceImpl;

    @RequestMapping (value = "/testController", method = RequestMethod.GET)
    @ApiOperation(value = "spring测试")
    public List<WarehouseStockInPlan> test(){
        System.out.println("测试成功");
        return planServiceImpl.getData();
    }
}
