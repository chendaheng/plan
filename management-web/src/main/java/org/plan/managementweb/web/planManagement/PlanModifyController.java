package org.plan.managementweb.web.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.enumModel.State;
import org.plan.managementservice.service.planManagement.imply.PlanModifyServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划服务接口")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class PlanModifyController {
    @Autowired
    private PlanModifyServiceImply planModifyService;

    @RequestMapping (value = "/restorePlan", method = RequestMethod.POST)
    @ApiOperation(value = "依据计划id恢复计划")
    public int deletePlanById(@RequestParam("id") int id) {
        int state = State.getIndex("已制定");
        return planModifyService.modifyPlan(id, state);
    }
}
