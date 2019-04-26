package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.enumModel.State;
import org.plan.managementservice.service.planManagement.imply.PlanUpdateServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划服务接口")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.DELETE},
        origins = "*")
public class PlanModifyController {
    @Autowired
    private PlanUpdateServiceImply planUpdateService;

    @DeleteMapping (value = "/deletePlan")
    @ApiOperation(value = "依据计划id删除计划")
    public int deletePlanById(@RequestParam("id") int id) {
        int state = State.getIndex("已删除");
        return planUpdateService.deletePlan(id, state);
    }
}
