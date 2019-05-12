package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.PlanException;
import org.plan.managementfacade.model.planModel.Test;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.planManagement.imply.PlanModifyServiceImply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划信息增删接口", tags = {"计划信息增删接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.DELETE},
        origins = "*")
public class PlanModifyController {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    /*--------------------此处为临时设定，userId与userName应从网关获取-------------------------------------*/
    private static final int userId = 3;
    private static final String userName = "张三";
    private static final String deptName = "设计管理部";

    @Autowired
    private PlanModifyServiceImply planModifyService;

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
            logger.error("所需属性值缺失");
            return ErrorCode.requiredFieldMiss;
        } else {
            return planModifyService.addPlan(planAddReq, userName, deptName);
        }
    }

    @GetMapping(value = "/quotePredictPlan")
    @ApiOperation(value = "引用预测计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int quotePredictPlan (@RequestParam("rangeId") int rangeId) {
        return planModifyService.quotePredictPlan(rangeId, userName, deptName);
    }

    @PostMapping(value = "/addException")
    @ApiOperation(value = "为计划添加异常信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addExceptionForPlan (@RequestBody @NotNull PlanException planException) {
        // 新增异常时必须传入相应计划的id以及异常原因
        if (planException.getPlanId() == null || planException.getCause() == null) {
            return ErrorCode.requiredFieldMiss;
        } else {
            planException.setUserName(userName);
            return planModifyService.addExceptionForPlan(planException);
        }
    }

    @DeleteMapping (value = "/deletePlan")
    @ApiOperation(value = "依据计划id删除计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deletePlanById(@RequestParam("id") int id) {
        return planModifyService.deletePlan(id);
    }
}
