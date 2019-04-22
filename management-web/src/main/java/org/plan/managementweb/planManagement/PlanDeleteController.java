package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.enumModel.State;
import org.plan.managementservice.service.planManagement.imply.PlanDeleteServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划服务接口")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST},
        origins = "*")
public class PlanDeleteController {
    @Autowired
    private PlanDeleteServiceImply planDeleteService;

    @RequestMapping (value = "/deletePlan", method = RequestMethod.POST)
    @ApiOperation(value = "依据计划id删除计划")
    public int deletePlanById(@RequestParam("id") int id) {
        int state = State.getIndex("已删除");
        return planDeleteService.deletePlan(id, state);
    }
}