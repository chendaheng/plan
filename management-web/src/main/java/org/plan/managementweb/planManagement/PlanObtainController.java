package org.plan.managementweb.planManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.responseModel.*;
import org.plan.managementservice.general.GatewayInfo;
import org.plan.managementservice.service.planManagement.PlanObtainServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划信息获取接口", tags = {"计划信息获取接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class PlanObtainController {

    @Autowired
    private PlanObtainServiceImply planObtainService;
    @Value("${plan.file.dir}")
    private String filePackage;

    @GetMapping(value = "/getPlanList")
    @ApiOperation(value = "按权限获取计划列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanSearchResp> getPlanList (@RequestParam Map<String, Object> params) {
        // 前端必须传入当前搜索阶段，否则返回错误
        if (params.get("stage") == null) {
            return null;
        } else {
            int userId = GatewayInfo.getUserId();
            params.put("userId", userId);
            return planObtainService.getPlanList(params);
        }
    }

    @GetMapping(value = "/downloadPlanFile")
    @ApiOperation(value = "下载计划对应文件", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String downloadPlanFile (@RequestParam("planId") Integer planId, @RequestParam("filename") String filename, HttpServletResponse response) {
        File file = new File(filePackage + planId + "/" + filename);
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;
            try {
                response.setHeader("content-type", "application/force-download");
                response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "UTF-8"));
                byte[] bytes = new byte[1024];
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                OutputStream os = response.getOutputStream();
                int i = bufferedInputStream.read(bytes);
                while(i != -1) {
                    os.write(bytes, 0 ,i);
                    i = bufferedInputStream.read(bytes);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return "异常情况，下载失败，请联系系统管理员";
        } else {
            return "该文件不存在，下载失败";
        }
    }

    @GetMapping(value = "/getDistributedPlanList")
    @ApiOperation(value = "获取被下发计划列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanSearchResp> getDistributedPlanList (@RequestParam Map<String, Object> params) {
        int userId = GatewayInfo.getUserId();
        params.put("executerId", userId);
        return planObtainService.getDistributedPlanList(params);
    }

    @GetMapping(value = "/getCompletedPlanList")
    @ApiOperation(value = "按权限获取已完成计划列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanSearchResp> getCompletedPlanList (@RequestParam Map<String, Object> params) {
        int userId = GatewayInfo.getUserId();
        params.put("userId", userId);
        return planObtainService.getCompletedPlanList(params);
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

    @GetMapping(value = "/getGanttForRangePlan")
    @ApiOperation(value = "获取系列计划甘特图", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanForGantt> getGanttForRangePlan (@RequestParam Map<String, Object> params) {
        return planObtainService.getGanttForPlan(params);
    }

    @GetMapping(value = "/getGanttForStyleGroupPlan")
    @ApiOperation(value = "依据系列根计划id获取款式组计划甘特图", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanForGantt> getGanttForStyleGroupPlan (@RequestParam Map<String, Object> params) {
        return planObtainService.getGanttForPlan(params);
    }

    @GetMapping(value = "/getGanttForStylePlan")
    @ApiOperation(value = "依据款式组根计划id获取款式计划甘特图", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PlanForGantt> getGanttForStylePlan (@RequestParam Map<String, Object> params) {
        return planObtainService.getGanttForPlan(params);
    }

}
