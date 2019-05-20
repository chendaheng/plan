package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.requestModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.sqlModel.PlanException;
import org.plan.managementfacade.model.planModel.Test;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.general.GatewayInfo;
import org.plan.managementservice.service.planManagement.imply.PlanModifyServiceImply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划信息增删接口", tags = {"计划信息增删接口"})
//@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
//        methods = {RequestMethod.POST, RequestMethod.DELETE},
//        origins = "*")
public class PlanModifyController {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");
    @Autowired
    private PlanModifyServiceImply planModifyService;

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Test> test () {
        return null;
    }

    @PostMapping(value = "/test")
    public int test(@RequestBody Test t) {
        return planModifyService.addTest(t);
    }

    @PostMapping(value = "/addPlan")
    @ApiOperation(value = "新增计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addPlan (@RequestBody @NotNull PlanAddReq planAddReq) {
        if (CheckObject.isContainsEmpty(planAddReq)) {
            logger.error("所需属性值缺失");
            return ErrorCode.requiredFieldMiss;
        } else {
            String userName = "孙博士";
            String deptName = "设计管理部";
            return planModifyService.addPlan(planAddReq, userName, deptName);
        }
    }

    @PostMapping(value = "/quotePredictPlan")
    @ApiOperation(value = "引用预测计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int quotePredictPlan (@RequestBody Map<String, Object> params) {
        if (params.containsKey("rangeId")) {
            int rangeId = (int) params.get("rangeId");
            String userName = "孙博士";
            String deptName = "设计管理部";
            return planModifyService.quotePredictPlan(rangeId, userName, deptName);
        } else {
            return ErrorCode.requiredFieldMiss;
        }
    }

    @PostMapping(value = "/quoteRangePlan")
    @ApiOperation(value = "引用系列计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int quoteRangePlan (@RequestBody Map<String, Object> params) {
        if (params.containsKey("styleGroupId") && params.containsKey("rangeId")) {
            int styleGroupId = (int) params.get("styleGroupId");
            int rangeId = (int) params.get("rangeId");
            String userName = "孙博士";
            String deptName = "设计管理部";
            return planModifyService.quoteRangePlan(styleGroupId, rangeId, userName, deptName);
        } else {
            return ErrorCode.requiredFieldMiss;
        }
    }

    @PostMapping(value = "/addException")
    @ApiOperation(value = "为计划添加异常信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addExceptionForPlan (@RequestBody @NotNull PlanException planException) {
        // 新增异常时必须传入相应计划的id以及异常原因
        if (planException.getPlanId() == null || planException.getCause() == null) {
            return ErrorCode.requiredFieldMiss;
        } else {
            String userName = "孙博士";
            planException.setUserName(userName);
            return planModifyService.addExceptionForPlan(planException);
        }
    }

    @DeleteMapping (value = "/deletePlan")
    @ApiOperation(value = "依据计划id删除计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deletePlanById(@RequestParam("id") int id) {
        String userName = "孙博士";
        return planModifyService.deletePlan(id, userName);
    }
}
