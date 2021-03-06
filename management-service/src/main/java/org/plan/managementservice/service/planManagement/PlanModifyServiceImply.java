package org.plan.managementservice.service.planManagement;

import org.plan.managementfacade.model.baseInfoModel.sqlModel.SerialNoRegular;
import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.requestModel.PlanTemplateAddReq;
import org.plan.managementfacade.model.planModel.requestModel.PlanToTemplateReq;
import org.plan.managementfacade.model.planModel.sqlModel.*;
import org.plan.managementfacade.model.planModel.requestModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.Test;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
import org.plan.managementservice.mapper.infoManagement.InfoUpdateMapper;
import org.plan.managementservice.mapper.planManagement.PlanModifyMapper;
import org.plan.managementservice.mapper.planManagement.PlanUpdateMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.plan.managementservice.service.baseInfoManagement.BaseInfoObtainServiceImply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PlanModifyServiceImply {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");
    private Integer nodeId = 1;

    @Autowired
    private PlanModifyMapper planModifyMapper;
    @Autowired
    private PlanObtainMapper planObtainMapper;
    @Autowired
    private  PlanUpdateMapper planUpdateMapper;
    @Autowired
    private InfoObtainMapper infoObtainMapper;
    @Autowired
    private InfoUpdateMapper infoUpdateMapper;
    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;
    @Autowired
    private BaseInfoObtainServiceImply baseInfoObtainServiceImply;


    public int addPlan (PlanAddReq planAddReq, String userName, String deptName) {
        // 同一系列下同一类型计划名称不得重复,不包括已删除计划
        String name = planAddReq.getName();
        int rangeId = planAddReq.getRangeId();
        PlanType type = planAddReq.getType();
        int planObjectId = planAddReq.getPlanObjectId();
        boolean isRoot = planAddReq.getIsRoot();
        int count = planObtainMapper.countPlanByNameRangeIdType(name, rangeId, type, PlanState.DELETED);
        if (count > 0) {
            logger.error("计划名称重复,新增计划失败。当前新增计划的名称为:" + name);
            return ErrorCode.planNameDuplication;
        }
        if (isRoot) {
            // 对于根计划，应确保仅有一个
            count = planObtainMapper.countRootPlanByTypeAndPlanObject(type, planObjectId, true, PlanState.DELETED);
            if (count > 0) {
                logger.error("当前计划对象根计划已存在，无法新增根计划！");
                return ErrorCode.rootPlanExist;
            }
            // 将款式组根计划的父id设为系列根计划的id
            if (type == PlanType.STYLEGROUP) {
                Integer parentIdOfRange = planObtainMapper.getRangeRootPlanId(rangeId, PlanType.RANGE, PlanState.DELETED);
                if (parentIdOfRange == null) {
                    logger.error("系列根计划不存在,新增款式组根计划失败。");
                    return ErrorCode.rangeRootPlanNotExist;
                } else {
                    planAddReq.setParentId(parentIdOfRange);
                }
            }
            // 将款式根计划的父id设为款式组根计划的id
            if (type == PlanType.STYLE) {
                Integer styleGroupId = infoObtainMapper.getStyleGroupIdByStyleId(planAddReq.getPlanObjectId());
                Integer parentIdOfStyleGroup = planObtainMapper.getStyleGroupRootPlanId(styleGroupId, PlanType.STYLEGROUP, PlanState.DELETED);
                if (parentIdOfStyleGroup == null) {
                    logger.error("款式组根计划不存在,新增款式根计划失败");
                    return ErrorCode.styleGroupRootPlanNotExist;
                } else {
                    planAddReq.setParentId(parentIdOfStyleGroup);
                }
            }
        }
        int parentId = planAddReq.getParentId();
        // 所有计划必须在父计划下发后才可制定，且开始结束时间位于父计划区间内
        if (parentId != 0) {
            PlanState parentPlanState = planObtainMapper.getPlanStateById(parentId);
            if (parentPlanState != PlanState.DISTRIBUTED) {
                logger.error("父计划未下发,新增计划失败。当前计划的父计划的id为:" + parentId);
                return ErrorCode.parentNotDistributed;
            }
            String startDate = planAddReq.getStartDate();
            String endDate = planAddReq.getEndDate();
            String parentStartDate = planObtainMapper.getPlanStartDateById(parentId);
            String parentEndDate = planObtainMapper.getPlanEndDateById(parentId);
            if (startDate.compareTo(parentStartDate) < 0 || endDate.compareTo(parentEndDate) > 0) {
                logger.error("计划开始结束时间超额,新增计划失败。");
                return ErrorCode.dateOutOfRange;
            }
        }
//        // 同类型子计划的款数之和不得超过父计划的款数
//        if (parentId != 0) {
//            int parentQuantity = planObtainMapper.getPlanQuantityById(parentId);
//            int sumOfQuantity = planAddReq.getQuantity();
//            List<Integer> quantityList = planObtainMapper.getPlanQuantityByParentIdAndType(parentId, type, PlanState.DELETED);
//            for (Integer i : quantityList) {
//                sumOfQuantity += i;
//            }
//            if (sumOfQuantity > parentQuantity) {
//                logger.error("计划款数超额,新增计划失败。父计划的款数为:" + parentQuantity);
//                return ErrorCode.quantityExceed;
//            }
//        }
        // 以上条件都满足时，添加计划
        Plan plan = new Plan(planAddReq);
//        String lastNumber = planObtainMapper.getLastPlanNumber();
//        String number = SerialNumberGenerate.generateNumber("JX", lastNumber);
//        plan.setNumber(number);
        SerialNoRegular serialNoRegular = baseInfoObtainMapper.getSerialNoRegularByObject("计划").get(0);
        String serialNo = baseInfoObtainServiceImply.generateSerialNo(serialNoRegular);
        plan.setNumber(serialNo);
        plan.setState(PlanState.MADE);
        plan.setCreaterName(userName);
        plan.setDeptName(deptName);
        int result = planModifyMapper.addPlan(plan);
        // 对于根计划，添加时需同时将系列/款式组/款数的havePlan状态更新
        if (isRoot) {
            switch (type) {
                case PREDICT:
                    infoUpdateMapper.updateRangeHavePredictPlanById(planAddReq.getPlanObjectId(), true);
                    break;
                case RANGE:
                    infoUpdateMapper.updateRangeHavePlanById(planAddReq.getPlanObjectId(), true);
                    break;
                case STYLEGROUP:
                    infoUpdateMapper.updateStyleGroupHavePlanById(planAddReq.getPlanObjectId(), true);
                    break;
                case STYLE:
                    infoUpdateMapper.updateStyleHavePlanById(planAddReq.getPlanObjectId(), true);
                    break;
            }
        }
        // result大于0表示插入成功，将生成的planId返回，否则返回result(0)，表示出现异常问题
        if (result > 0) {
            return plan.getId();
        } else {
            return result;
        }
    }

    public List<String> addPlanFiles (List<MultipartFile> files, Integer planId, String filePackage) {
        List<String> result = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String filePath = filePackage + planId + "/" + file.getOriginalFilename();
                    File localFile = new File(filePath);
                    File parentFile = localFile.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdir();
                    }
                    boolean fileExist = localFile.exists();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(localFile));
                    stream.write(bytes);
                    stream.close();
                    // 该文件原先不存在时，将其与plan的关系存入数据库，否则新文件直接将原文件覆盖
                    if (!fileExist) {
                        planModifyMapper.addPlanFile(planId, file.getOriginalFilename());
                    }
                    String success = "文件" + file.getOriginalFilename() + "上传成功";
                    result.add(success);
                } catch (Exception e) {
                    String error = "文件" + file.getOriginalFilename() + "上传失败 ==> " + e.getMessage();
                    logger.error(error);
                    result.add(error);
                }
            } else {
                String miss = "文件" + file.getOriginalFilename() + "为空，上传失败";
                result.add(miss);
            }
        }
        return result;
    }

    public int addPlanTemplate (PlanTemplateAddReq addReq, int createrId, String createrName) {
        int result = ErrorCode.conflictWithExistPlan;
        // 利用中序遍历将模板树上的每个节点的id设置好，并在完成遍历后将nodeId重设回1，以便下一个模板树使用
        // 为防止多线程下对nodeId的共同写出现问题，采用synchronized确保线程安全
        TemplateTree tree = addReq.getTree();
        synchronized (nodeId) {
            midTraversal(tree);
            nodeId = 1;
        }
        try {
            result = planModifyMapper.addPlanTemplate(addReq, createrId, createrName);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    public int saveToPlanTemplate (PlanToTemplateReq planToTemplateReq, Integer createrId, String createrName) {
        Integer rangeId = planToTemplateReq.getRangeId();
        String name = planToTemplateReq.getName();
        String customerName = planToTemplateReq.getCustomerName();
        String brandName = planToTemplateReq.getBrandName();
        boolean isPublic = planToTemplateReq.isPublic();
        // 依据系列id取出该系列下所有计划的id，name，parentId
        List<PlanForTemplate> planList = planObtainMapper.getRangePlanForTemplate(rangeId, PlanType.RANGE, PlanState.DELETED);
        PlanForTemplate rootPlan = planList.get(0);
        // 取出的计划中第一个计划应为根计划，若不是，计划id的编号可能出现问题，报错
        if (rootPlan.getParentId() != 0) {
            logger.error("数据库设计中父计划id应小于子计划，当前状态不符合，请检查");
            return ErrorCode.illegalStateUpdate;
        }
        // 此map用于存放planId与其对应生成的模板树节点间的关系，从而重建模板树的父子关系
        Map<Integer, TemplateTree> idTemplateTreeMap = new HashMap<>();
        // 模板树的根节点
        TemplateTree root = new TemplateTree();
        root.setId(nodeId);
        root.setPlanName(rootPlan.getName());
        idTemplateTreeMap.put(rootPlan.getId(), root);
        // 将取出的计划组装为模板树
        synchronized (nodeId) {
            nodeId++;
            for (PlanForTemplate plan : planList) {
                if (plan.getParentId() == 0) {
                    continue;
                }
                TemplateTree tree = new TemplateTree();
                tree.setId(nodeId++);
                tree.setPlanName(plan.getName());
                TemplateTree parentTree = idTemplateTreeMap.get(plan.getParentId());
                if (parentTree.getChildren() == null) {
                    parentTree.setChildren(new ArrayList<TemplateTree>());
                }
                parentTree.addChild(tree);
                idTemplateTreeMap.put(plan.getId(), tree);
            }
            nodeId = 1;
        }
        return planModifyMapper.saveToPlanTemplate(name, customerName, brandName, root, createrId, createrName, isPublic);



    }

    // 由于涉及到对多张表操作，添加@Transactional注解，确保在出现未知异常情况下进行数据库操作回滚
    @Transactional
    public int quotePlanTemplate (Integer rangeId, Integer quantity, Integer planTemplateId, String userName, String deptName) {
        PlanTemplate planTemplate = planObtainMapper.getPlanTemplateById(planTemplateId);
        TemplateTree tree = planTemplate.getTree();
        Integer nodeId = tree.getId();
        String planName = tree.getPlanName();
        TemplateInstance instance = new TemplateInstance(rangeId, userName, deptName, tree);
        planModifyMapper.addTemplateInstance(instance);
        Integer instanceId = instance.getId();
        // 构造新的计划插入数据库，并获取生成的计划id
        PlanAddReq planAddReq = new PlanAddReq(planName, rangeId, PlanType.RANGE, true, 0, rangeId, quantity);
        int result = addPlan(planAddReq, userName, deptName);
        // 若添加成功，则返回值是添加的计划的id，没能插入为0，负数则为插入计划过程中出现了已知错误
        if (result > 0) {
            int planId = result;
            // 添加计划成功后，将plan与instance关系存入plan_instance表
            PlanInstance planInstance = new PlanInstance(planId, instanceId, nodeId);
            return planModifyMapper.addPlanInstance(planInstance);
        } else if (result == 0){
            logger.error("引用模板时插入数据库的计划失败，");
            return ErrorCode.unkownError;
        } else {
            return result;
        }

    }

    public int quotePredictPlan (int rangeId, String userName, String deptName) {
        // 获取系列对应的预测计划
        List<Plan> predictPlanList = planObtainMapper.getRootPlanByPlanObjectIdAndType(rangeId, PlanType.PREDICT, PlanState.DELETED);
        // 若一个系列有一个以上的预测计划，返回数据库错误信息
        if (predictPlanList.size() > 1) {
            logger.error("id为" + rangeId + "的系列存在两个及以上的预测计划，不符合系统规范，请检查数据库");
            return ErrorCode.databaseError;
        }
        // 若相应预测计划不存在，返回预测计划不存在错误信息
        if (predictPlanList.size() == 0) {
            logger.error("id为" + rangeId + "的系列目前无预测计划，无法引用");
            return ErrorCode.predictPlanNotExist;
        }
        // 将预测计划信息取出，生成新的系列根计划
        Plan predictPlan = predictPlanList.get(0);
        PlanAddReq planAddReq = new PlanAddReq(predictPlan);
        planAddReq.setProposal(planAddReq.getName());
        planAddReq.setDescription("引用预测计划生成");
        planAddReq.setType(PlanType.RANGE);
        return addPlan(planAddReq, userName, deptName);
    }

    public int quoteRangePlan (int styleGroupId, int rangeId, String userName, String deptName) {
        // 获取系列根计划
        List<Plan> rangePlanList = planObtainMapper.getRootPlanByPlanObjectIdAndType(rangeId, PlanType.RANGE, PlanState.DELETED);
        // 若一个系列有一个以上的根计划，返回数据库错误信息
        if (rangePlanList.size() > 1) {
            logger.error("id为" + rangeId + "的系列存在两个及以上的系列根计划，不符合系统规范，请检查数据库");
            return ErrorCode.databaseError;
        }
        // 若相应系列根计划不存在，返回系列根计划不存在错误信息
        if (rangePlanList.size() == 0) {
            logger.error("id为" + rangeId + "的系列目前无预测计划，无法引用");
            return ErrorCode.rangeRootPlanNotExist;
        }
        // 取出系列根计划信息，生成新的款式组根计划
        Plan rangePlan = rangePlanList.get(0);
        PlanAddReq planAddReq = new PlanAddReq(rangePlan);
//        planAddReq.setName("新的款式组根计划");
//        planAddReq.setProposal("新的款式组根计划");
//        planAddReq.setDescription("由引用系列计划生成");
        planAddReq.setType(PlanType.STYLEGROUP);
        planAddReq.setPlanObjectId(styleGroupId);
        return addPlan(planAddReq, userName, deptName);
    }


    public int addExceptionForPlan(PlanException planException) {
        SerialNoRegular serialNoRegular = baseInfoObtainMapper.getSerialNoRegularByObject("异常").get(0);
        String serialNo = baseInfoObtainServiceImply.generateSerialNo(serialNoRegular);
        planException.setNumber(serialNo);
//        String lastNumber = planObtainMapper.getLastExceptionNumber();
//        String number = SerialNumberGenerate.generateNumber("YC", lastNumber);
//        planException.setNumber(number);
        int result = planModifyMapper.addExceptionForPlan(planException);
        // 添加异常信息成功时,将对应计划的haveException修改为true
        if (result == 1) {
            planUpdateMapper.updatePlanHaveExceptionById(planException.getPlanId());
        }
        return result;
    }

    public int deletePlan(int id, String userName) {
        // 只有当计划状态为已制定/被驳回时才能删除
        Plan plan = planObtainMapper.getPlanById(id);
        PlanState planState = plan.getState();
        if (planState != PlanState.MADE && planState != PlanState.REFUSED) {
            logger.error("id为" + id + "的计划状态不是已制定也不是已驳回,无法进行删除操作。");
            return ErrorCode.illegalStateUpdate;
        } else {
            int result = planUpdateMapper.deletePlanById(id, PlanState.DELETED, userName);
            boolean isRoot = plan.getIsRoot();
            PlanType type = plan.getType();
            int planObjectId = plan.getPlanObjectId();
            // 删除计划为根计划时，需同步更新系列/款式组/款式中的havePlan状态信息
            if (isRoot) {
                switch (type) {
                    case PREDICT:
                        infoUpdateMapper.updateRangeHavePredictPlanById(planObjectId, false);
                        break;
                    case RANGE:
                        infoUpdateMapper.updateRangeHavePlanById(planObjectId, false);
                        break;
                    case STYLEGROUP:
                        infoUpdateMapper.updateStyleGroupHavePlanById(planObjectId, false);
                        break;
                    case STYLE:
                        infoUpdateMapper.updateStyleHavePlanById(planObjectId, false);
                        break;
                }
            }
            return result;
        }
    }

    public int deletePlanFile(Integer planId, String filename) {
        return planModifyMapper.deletePlanFile(planId, filename);
    }

    public int deletePlanTemplate(Integer id) {
        return planModifyMapper.deletePlanTemplateById(id);
    }

    // 利用中序遍历将模板树上的每个节点的id设置好(从1开始往后增加)
    private void midTraversal (TemplateTree templateTree) {
        if (templateTree != null) {
            templateTree.setId(nodeId++);
            List<TemplateTree> treeList = templateTree.getChildren();
            if (treeList != null) {
                for (TemplateTree tree : treeList) {
                    midTraversal(tree);
                }
            }
        }
    }

    public int addTest (Test t) {
        return planModifyMapper.addTest(t);
    }

    public List<Test> getTest () {
        try {
            return planModifyMapper.getTest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
