package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.PlanUpdateReq;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.planManagement.imply.PlanModifyServiceImply;
import org.plan.managementservice.service.planManagement.imply.PlanUpdateServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划信息更新接口", tags = {"计划信息更新接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST},
        origins = "*")
public class PlanUpdateController {
    @Autowired
    private PlanUpdateServiceImply planUpdateService;

    @PostMapping (value = "/updatePlan")
    @ApiOperation(value = "依据计划id回收已删除计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updatePlan(@RequestBody @NotNull PlanUpdateReq planUpdateReq) {
        if (CheckObject.isContainsEmpty(planUpdateReq)) {
            return ErrorCode.requiredFieldMiss;
        } else {
            return planUpdateService.updatePlan(planUpdateReq);
        }
    }

    @GetMapping (value = "/restorePlan")
    @ApiOperation(value = "依据计划id回收已删除计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int restorePlanById(@RequestParam("id") int id) {
        return planUpdateService.restorePlan(id);
    }
}
