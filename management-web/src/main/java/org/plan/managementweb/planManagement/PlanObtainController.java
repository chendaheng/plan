package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.PlanTree;
import org.plan.managementfacade.model.planModel.responseModel.ChildrenPlanResp;
import org.plan.managementfacade.model.planModel.responseModel.PlanExceptionResp;
import org.plan.managementfacade.model.planModel.responseModel.PlanSearchResp;
import org.plan.managementservice.general.GatewayInfo;
import org.plan.managementservice.service.planManagement.imply.PlanObtainServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划信息获取接口", tags = {"计划信息获取接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class PlanObtainController {
    /*--------------------此处为临时设定，userId与userName应从网关获取-------------------------------------*/
//    private static final int userId = 3;
//    private static final String userName = "张三";
//    private static final String deptName = "设计管理部";

    @Autowired
    private PlanObtainServiceImply planObtainService;

    @GetMapping(value = "/getPlanList")
    @ApiOperation(value = "按权限获取计划列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanSearchResp> getPlanList (@RequestParam Map<String, Object> params) {
        // 前端必须传入当前搜索阶段，否则返回错误
        if (params.get("stage") == null) {
            return null;
        } else {
            int userId = GatewayInfo.getUserId();
            String userName = GatewayInfo.getUserName();
            params.put("userId", userId);
            return planObtainService.getPlanList(params);
        }
    }

    @GetMapping(value = "/getDistributedPlanList")
    @ApiOperation(value = "获取被下发计划列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanSearchResp> getDistributedPlanList (@RequestParam Map<String, Object> params) {
        int userId = GatewayInfo.getUserId();
        params.put("executerId", userId);
        return planObtainService.getDistributedPlanList(params);
    }

    @GetMapping(value = "/getChildrenPlanList")
    @ApiOperation(value = "获取子计划列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ChildrenPlanResp> getChildrenPlanList (@RequestParam("id") int parentId) {
        return planObtainService.getChildrenPlanList(parentId);
    }

    @GetMapping(value = "/getExceptionList")
    @ApiOperation(value = "按权限获取计划异常列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanExceptionResp> getPlanExceptionList (@RequestParam Map<String, Object> params) {
        int userId = GatewayInfo.getUserId();
        params.put("userId", userId);
        return planObtainService.getPlanExceptionList(params);
    }

    @GetMapping(value = "/getPlanTree")
    @ApiOperation(value = "依据计划id获取相应计划树", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PlanTree getPlanTree (@RequestParam("id") int id) {
        return planObtainService.getPlanTree(id);
    }

}
