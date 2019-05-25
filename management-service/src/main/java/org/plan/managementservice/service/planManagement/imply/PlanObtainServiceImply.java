package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.requestModel.PlanTree;
import org.plan.managementfacade.model.planModel.requestModel.PlanTreeForGantt;
import org.plan.managementfacade.model.planModel.responseModel.ChildrenPlanResp;
import org.plan.managementfacade.model.planModel.responseModel.PlanExceptionResp;
import org.plan.managementfacade.model.planModel.responseModel.PlanSearchResp;
import org.plan.managementfacade.model.planModel.sqlModel.Plan;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.PreferencesFactory;

@Component
public class PlanObtainServiceImply {
    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");
    @Autowired
    private PlanObtainMapper planObtainMapper;
    @Autowired
    private InfoObtainMapper infoObtainMapper;

    public List<PlanSearchResp> getPlanList (Map<String, Object> params) {
        String stage = params.get("stage").toString();
        List<PlanSearchResp> planSearchList;
        switch (stage) {
            // 预测计划的查询返回用户具有权限的全部预测计划，包括已制定与已提交两种状态
            case "predict":
                planSearchList = planObtainMapper.getPlanListInPredict(params);
                break;
            // 计划管理页面的查询，返回用户具有权限的所有系列/款式组/款式计划，除已删除状态外其余计划均返回
            case "manage":
                planSearchList = planObtainMapper.getPlanListInManage(params);
                break;
            // 计划审核页面的查询，返回用户具有权限的所有非预测计划，状态为已提交和已审核
            case "review":
                planSearchList = planObtainMapper.getPlanListInReview(params);
                break;
            // 计划下发页面的查询，返回用户具有权限的所有非预测计划，状态为已审核和已下发
            case "distribute":
                planSearchList = planObtainMapper.getPlanListInDistribute(params);
                break;
            // 已删除计划页面的查询，返回用户具有权限的所有计划，状态为已删除
            case "delete":
                planSearchList = planObtainMapper.getPlanListInDelete(params);
                break;
            default:
                return null;
        }
        // 依据parentId获取parentName,依据planObjectId和type获取planObject
        for (PlanSearchResp planSearch : planSearchList) {
            int parentId = planSearch.getParentId();
            int planObjectId = planSearch.getPlanObjectId();
            PlanType type = planSearch.getType();
            String parentName = planObtainMapper.getPlanNameById(parentId);
            String planObject;
            switch (type) {
                case PREDICT: case RANGE:
                    planObject = infoObtainMapper.getRangeNameById(planObjectId);
                    break;
                case STYLEGROUP:
                    planObject = infoObtainMapper.getStyleGroupNameById(planObjectId);
                    break;
                case STYLE:
                    planObject = infoObtainMapper.getStyleNumberById(planObjectId);
                    break;
                default:
                    return null;
            }
            planSearch.setParentName(parentName);
            planSearch.setPlanObject(planObject);
        }
        return planSearchList;
    }

    public List<ChildrenPlanResp> getChildrenPlanList (int parentId) {
        PlanType type = planObtainMapper.getPlanTypeById(parentId);
        return planObtainMapper.getPlanByParentIdAndType(parentId, type, PlanState.DELETED);
    }

    public List<PlanSearchResp> getDistributedPlanList (Map<String, Object> params) {
        List<PlanSearchResp> planSearchList = planObtainMapper.getDistributedPlanListByParams(params);
        // 依据parentId获取parentName,依据planObjectId和type获取planObject
        for (PlanSearchResp planSearch : planSearchList) {
            int parentId = planSearch.getParentId();
            int planObjectId = planSearch.getPlanObjectId();
            PlanType type = planSearch.getType();
            String parentName = planObtainMapper.getPlanNameById(parentId);
            String planObject;
            switch (type) {
                case PREDICT: case RANGE:
                    planObject = infoObtainMapper.getRangeNameById(planObjectId);
                    break;
                case STYLEGROUP:
                    planObject = infoObtainMapper.getStyleGroupNameById(planObjectId);
                    break;
                case STYLE:
                    planObject = infoObtainMapper.getStyleNumberById(planObjectId);
                    break;
                default:
                    return null;
            }
            planSearch.setParentName(parentName);
            planSearch.setPlanObject(planObject);
        }
        return planSearchList;
    }

    public List<PlanSearchResp> getCompletedPlanList (Map<String, Object> params) {
        List<PlanSearchResp> planSearchList = planObtainMapper.getCompletedPlanListByParams(params);
        // 依据parentId获取parentName,依据planObjectId和type获取planObject
        for (PlanSearchResp planSearch : planSearchList) {
            int parentId = planSearch.getParentId();
            int planObjectId = planSearch.getPlanObjectId();
            PlanType type = planSearch.getType();
            String parentName = planObtainMapper.getPlanNameById(parentId);
            String planObject;
            switch (type) {
                case PREDICT: case RANGE:
                    planObject = infoObtainMapper.getRangeNameById(planObjectId);
                    break;
                case STYLEGROUP:
                    planObject = infoObtainMapper.getStyleGroupNameById(planObjectId);
                    break;
                case STYLE:
                    planObject = infoObtainMapper.getStyleNumberById(planObjectId);
                    break;
                default:
                    return null;
            }
            planSearch.setParentName(parentName);
            planSearch.setPlanObject(planObject);
        }
        return planSearchList;
    }

    public List<PlanExceptionResp> getPlanExceptionList (Map<String, Object> params) {
        List<PlanExceptionResp> planExceptionList = planObtainMapper.getPlanExceptionList(params);;
        // 依据parentId获取parentName,依据planObjectId和type获取planObject
        for (PlanExceptionResp planException : planExceptionList) {
            int planObjectId = planException.getPlanObjectId();
            PlanType type = planException.getType();
            String planObject;
            switch (type) {
                case PREDICT: case RANGE:
                    planObject = infoObtainMapper.getRangeNameById(planObjectId);
                    break;
                case STYLEGROUP:
                    planObject = infoObtainMapper.getStyleGroupNameById(planObjectId);
                    break;
                case STYLE:
                    planObject = infoObtainMapper.getStyleNumberById(planObjectId);
                    break;
                default:
                    return null;
            }
            planException.setPlanObject(planObject);
        }
        return planExceptionList;
    }

    public PlanTree getPlanTree (int id) {
        // 通过传入的计划id获取该计划所在计划树的根计划
        Plan originalPlan = planObtainMapper.getPlanById(id);
        PlanType type = originalPlan.getType();
        int planObjectId = originalPlan.getPlanObjectId();
        List<Plan> rootPlanList = planObtainMapper.getRootPlanByPlanObjectIdAndType(planObjectId, type, PlanState.DELETED);
        // 若该计划树根节点超过一个，返回错误信息
        if (rootPlanList.size() > 1) {
            logger.error("该计划所在计划树存在两个根节点，不符合系统规范，请检查数据库");
            return null;
        }
        // 若该计划根节点不存在，返回错误信息
        if (rootPlanList.size() == 0) {
            logger.error("该计划所在计划树根节点不存在，不符合系统规范，请检查数据库");
            return null;
        }
        Plan rootPlan = rootPlanList.get(0);
        // 构造计划树根节点
        PlanTree root = new PlanTree(rootPlan.getId(), rootPlan.getNumber(), rootPlan.getName());
        // 构造一个id与tree对应的map用于层序遍历组成计划树
        Map<Integer, PlanTree> idPlanTreeMap = new HashMap<>();
        idPlanTreeMap.put(root.getId(), root);
        // 依据planObjectId获取该计划树上全部计划
        List<Plan> planList = planObtainMapper.getPlanByPlanObjectId(planObjectId, PlanState.DELETED);
        for (Plan plan : planList) {
            if (plan.getIsRoot()) {
                continue;
            }
            // 除根计划外每个计划都做成一个节点
            int planId = plan.getId();
            String number = plan.getNumber();
            String name = plan.getName();
            PlanTree node = new PlanTree(planId, number, name);
            // 将新的节点加至其父节点之下并加入map
            int parentId = plan.getParentId();
            PlanTree parent = idPlanTreeMap.get(parentId);
            if (parent.getChildren() == null) {
                parent.setChildren(new ArrayList<>());
            }
            parent.addChildren(node);
            idPlanTreeMap.put(planId, node);
        }
        return root;
    }

    public List<PlanTreeForGantt> getGanttForRangePlan (Map<String, Object> params) {
        List<PlanTreeForGantt> result = planObtainMapper.getRootPlanForGantt(params);
        return null;
    }
}
