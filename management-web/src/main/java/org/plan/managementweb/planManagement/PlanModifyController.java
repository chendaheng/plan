package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.Test;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.planManagement.imply.PlanModifyServiceImply;
import org.plan.managementservice.service.planManagement.imply.PlanUpdateServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划服务接口")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.DELETE},
        origins = "*")
public class PlanModifyController {
    @Autowired
    private PlanModifyServiceImply planModifyService;
    @Autowired
    private PlanUpdateServiceImply planUpdateService;

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Test> test () {
        return planModifyService.getTest();
    }

    @PostMapping(value = "/test")
    public int test(@RequestBody Test t) {
        return planModifyService.addTest(t);
    }

    @PostMapping(value = "/addPlan")
    @ApiOperation(value = "新增计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addPlan (@RequestBody @NotNull PlanAddReq planAddReq) {
        if (CheckObject.isContainsEmpty(planAddReq)) {
            return ErrorCode.requiredFieldMiss;
        } else {
            return planModifyService.addPlan(planAddReq);
        }
    }

    @DeleteMapping (value = "/deletePlan")
    @ApiOperation(value = "依据计划id删除计划")
    public int deletePlanById(@RequestParam("id") int id) {
        return planModifyService.deletePlan(id);
    }
}
