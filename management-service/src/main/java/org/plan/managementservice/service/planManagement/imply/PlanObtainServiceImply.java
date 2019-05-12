package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.PlanExceptionResp;
import org.plan.managementfacade.model.planModel.PlanSearchResp;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PlanObtainServiceImply {
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
}
