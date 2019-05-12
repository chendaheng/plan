package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.requestModel.ChildrenPlanReq;
import org.plan.managementfacade.model.planModel.requestModel.DistributePlanReq;
import org.plan.managementfacade.model.planModel.requestModel.PlanUpdateReq;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.planManagement.imply.PlanUpdateServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划信息更新接口", tags = {"计划信息更新接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.GET},
        origins = "*")
public class PlanUpdateController {
    @Autowired
    private PlanUpdateServiceImply planUpdateService;

    @PostMapping (value = "/updatePlan")
    @ApiOperation(value = "依据计划id更新计划信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updatePlanById(@RequestBody @NotNull PlanUpdateReq planUpdateReq) {
        if (CheckObject.isContainsEmpty(planUpdateReq)) {
            return ErrorCode.requiredFieldMiss;
        } else {
            return planUpdateService.updatePlan(planUpdateReq);
        }
    }

    @PostMapping (value = "/adjustPlanOrder")
    @ApiOperation(value = "调整计划顺序", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int adjustPlanOrder(@RequestBody @NotNull List<ChildrenPlanReq> childrenPlan) {
        for (ChildrenPlanReq childPlan : childrenPlan) {
            if (CheckObject.isContainsEmpty(childPlan)) {
                return ErrorCode.requiredFieldMiss;
            }
        }
        return planUpdateService.updatePlanOrder(childrenPlan);
    }

    @GetMapping (value = "/submitPlan")
    @ApiOperation(value = "依据计划id提交计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int submitPlanById(@RequestParam("id") int id) {
        return planUpdateService.submitPlan(id);
    }

    @GetMapping (value = "/passPlan")
    @ApiOperation(value = "依据计划id通过计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int passPlanById(@RequestParam("id") int id) {
        return planUpdateService.passPlan(id);
    }

    @GetMapping (value = "/failPlan")
    @ApiOperation(value = "依据计划id驳回计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int failPlanById(@RequestParam("id") int id, @RequestParam("reason") String reason) {
        return planUpdateService.failPlan(id, reason);
    }

    @GetMapping (value = "/cancelPassPlan")
    @ApiOperation(value = "依据计划id取消通过的计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int cancelPassPlanById(@RequestParam("id") int id) {
        return planUpdateService.cancelPassPlan(id);
    }

    @PostMapping (value = "/distributePlan")
    @ApiOperation(value = "依据计划id下发计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int distributePlan(@RequestBody DistributePlanReq planReq) {
        if (CheckObject.isContainsEmpty(planReq)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return planUpdateService.distributePlan(planReq);
        }
    }

    @GetMapping (value = "/restorePlan")
    @ApiOperation(value = "依据计划id回收已删除计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int restorePlanById(@RequestParam("id") int id) {
        return planUpdateService.restorePlan(id);
    }
}
