package org.plan.managementweb.planManagement;

import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.planModel.requestModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.requestModel.PlanTemplateAddReq;
import org.plan.managementfacade.model.planModel.sqlModel.PlanException;
import org.plan.managementfacade.model.planModel.sqlModel.PlanTemplate;
import org.plan.managementfacade.model.planModel.sqlModel.TemplateTree;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.general.GatewayInfo;
import org.plan.managementservice.service.planManagement.PlanModifyServiceImply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/planManagement")
@Api(value = "计划信息增删接口", tags = {"计划信息增删接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.DELETE},
        origins = "*")
public class PlanModifyController {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");
    @Autowired
    private PlanModifyServiceImply planModifyService;
    @Value("${plan.file.dir}")
    private String filePackage;

//    @GetMapping(value = "/test")
//    @ApiOperation(value = "测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<Test> test () {
//        return null;
//    }
//
//    @PostMapping(value = "/test")
//    public String test(HttpServletRequest request) {
//        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
//        for (MultipartFile file : files) {
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
//                            new File(filePath + file.getOriginalFilename())));
//                    stream.write(bytes);
//                    stream.close();
//                } catch (Exception e) {
//                    String err = "文件" + file.getOriginalFilename() + "上传失败 ==> " + e.getMessage();
//                    logger.error(err);
//                    return err;
//                }
//            } else {
//                return "文件" + file.getOriginalFilename() + "为空，上传失败";
//            }
//        }
//        return "上传成功";
//    }

    /**
     *
     * @param planAddReq
     * @return 返回插入成功后对应计划的id
     */
    @PostMapping(value = "/addPlan")
    @ApiOperation(value = "新增计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addPlan (@RequestBody @NotNull PlanAddReq planAddReq) {
        if (CheckObject.isContainsEmpty(planAddReq)) {
            logger.error("所需属性值缺失");
            return ErrorCode.requiredFieldMiss;
        } else {
            String userName = GatewayInfo.getUserName();
            String deptName = GatewayInfo.getDeptName();
            return planModifyService.addPlan(planAddReq, userName, deptName);
        }
    }

    @PostMapping(value = "/addPlanFiles")
    @ApiOperation(value = "计划新增成功后将文件上传", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> addPlanFiles (HttpServletRequest httpServletRequest) {
        MultipartHttpServletRequest request = (MultipartHttpServletRequest) httpServletRequest;
        List<MultipartFile> files = request.getFiles("file");
        Integer planId = Integer.parseInt(request.getParameter("planId"));
        return planModifyService.addPlanFiles(files, planId, filePackage);
    }

    @PostMapping(value = "/addPlanTemplate")
    @ApiOperation(value = "添加计划模板", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addPlanTemplate (@RequestBody PlanTemplateAddReq addReq) {
        int createrId = GatewayInfo.getUserId();
        String createrName = GatewayInfo.getUserName();
        return planModifyService.addPlanTemplate(addReq, createrId, createrName);
    }

    @PostMapping(value = "/quotePlanTemplate")
    @ApiOperation(value = "引用计划模板", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int quotePlanTemplate (@RequestParam("rangeId") Integer rangeId, @RequestParam("quantity") Integer quantity, @RequestParam("planTemplateId") Integer planTemplateId) {
        String userName = GatewayInfo.getUserName();
        String deptName = GatewayInfo.getDeptName();
        return planModifyService.quotePlanTemplate(rangeId, quantity, planTemplateId, userName, deptName);
    }

    // TODO: 引用预测计划需要修改，以树形结构引用
    @PostMapping(value = "/quotePredictPlan")
    @ApiOperation(value = "引用预测计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int quotePredictPlan (@RequestBody Map<String, Object> params) {
        if (params.containsKey("rangeId")) {
            int rangeId = (int) params.get("rangeId");
            String userName = GatewayInfo.getUserName();
            String deptName = GatewayInfo.getDeptName();
            return planModifyService.quotePredictPlan(rangeId, userName, deptName);
        } else {
            return ErrorCode.requiredFieldMiss;
        }
    }

    // TODO: 引用系列计划也要修改，也需按树形结构进行引用
    @PostMapping(value = "/quoteRangePlan")
    @ApiOperation(value = "引用系列计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int quoteRangePlan (@RequestBody Map<String, Object> params) {
        if (params.containsKey("styleGroupId") && params.containsKey("rangeId")) {
            int styleGroupId = (int) params.get("styleGroupId");
            int rangeId = (int) params.get("rangeId");
            String userName = GatewayInfo.getUserName();
            String deptName = GatewayInfo.getDeptName();
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
            String userName = GatewayInfo.getUserName();
            planException.setUserName(userName);
            return planModifyService.addExceptionForPlan(planException);
        }
    }

    @DeleteMapping(value = "/deletePlan")
    @ApiOperation(value = "依据计划id删除计划", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deletePlanById(@RequestParam("id") int id) {
        String userName = GatewayInfo.getUserName();
        return planModifyService.deletePlan(id, userName);
    }

    @DeleteMapping(value = "/deletePlanFile")
    @ApiOperation(value = "依据计划id和文件名删除文件", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deletePlanFile(@RequestParam("planId") Integer planId, @RequestParam("filename") String filename) {
        String filePath = filePackage + planId + "/" + filename;
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return planModifyService.deletePlanFile(planId, filename);
            } else {
                return ErrorCode.unkownError;
            }
        } else {
            return ErrorCode.fileNotFound;
        }
    }

    @DeleteMapping(value = "/deletePlanTemplate")
    @ApiOperation(value = "依据计划模板id删除模板", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deletePlanTemplate(@RequestParam("id") Integer id) {
        return planModifyService.deletePlanTemplate(id);
    }
}
