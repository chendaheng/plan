package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.PlanUpdateReq;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.planManagement.PlanModifyMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.plan.managementservice.mapper.planManagement.PlanUpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanUpdateServiceImply {
    @Autowired
    private PlanObtainMapper planObtainMapper;
    @Autowired
    private PlanUpdateMapper planUpdateMapper;
    @Autowired
    private PlanModifyMapper planModifyMapper;
    @Autowired
    private PlanModifyServiceImply planModifyService;

    public int updatePlan (PlanUpdateReq planUpdateReq) {
        Plan oldPlan = planObtainMapper.getPlanById(planUpdateReq.getId());
        String name = planUpdateReq.getName();
        String startDate = planUpdateReq.getStartDate();
        String endDate = planUpdateReq.getEndDate();
        Integer quantity = planUpdateReq.getQuantity();
        int parentId = oldPlan.getParentId();
        // 若修改了名称，需确保当前名称与其他同类计划的名称不重复
        if (!name.equals(oldPlan.getName())) {
            int count = planObtainMapper.countPlanByNameRangeIdType(name, oldPlan.getRangeId(), oldPlan.getType());
            if (count > 1) {
                return ErrorCode.planNameDuplication;
            }
        }
        // 若修改了开始/结束时间，确保开始时间不早于父计划开始时间，结束时间不晚于父计划
        if (!startDate.equals(oldPlan.getStartDate()) && parentId != 0) {
            String parentStartDate = planObtainMapper.getPlanStartDateById(parentId);
            if (startDate.compareTo(parentStartDate) < 0) {
                return ErrorCode.dateOutOfRange;
            }
        }
        if (!endDate.equals(oldPlan.getEndDate()) && parentId != 0) {
            String parentEndDate = planObtainMapper.getPlanEndDateById(parentId);
            if (endDate.compareTo(parentEndDate) > 0) {
                return ErrorCode.dateOutOfRange;
            }
        }
        // 若计划款数增加，则需确保增加之后其父计划款数大于相应子计划款数之和
        if (quantity > oldPlan.getQuantity()) {
            PlanType type = oldPlan.getType();
            int parentQuantity = planObtainMapper.getQuantityById(parentId);
            int sumOfQuantity = quantity;
            List<Integer> quantityList = planObtainMapper.getQuantityByParentIdAndType(parentId, type, PlanState.DELETED);
            for (Integer i : quantityList) {
                sumOfQuantity += i;
            }
            sumOfQuantity -= oldPlan.getQuantity();
            if (sumOfQuantity > parentQuantity) {
                return ErrorCode.quantityExceed;
            }
        }
        return planUpdateMapper.updatePlan(planUpdateReq);
    }

    public int restorePlan (int id) {
        // 确保恢复的计划为已删除计划
        PlanState planState = planObtainMapper.getPlanStateById(id);
        if (planState != PlanState.DELETED) {
            return ErrorCode.illegalStateUpdate;
        }
        // 将原删除计划记录从数据库删除，重设计划状态后添加计划，若添加失败，将原先删除计划添加回去即可
        Plan deletedPlan = planObtainMapper.getPlanById(id);
        planModifyMapper.deletePlanById(id);
        if (deletedPlan.getRejectReason() != null) {
            deletedPlan.setState(PlanState.REFUSED);
        } else {
            deletedPlan.setState(PlanState.MADE);
        }
        int addDeletedPlanResult = planModifyService.addPlan(deletedPlan);
        if (addDeletedPlanResult > 0) {
            return addDeletedPlanResult;
        } else {
            deletedPlan.setState(PlanState.DELETED);
            planModifyMapper.addPlan(deletedPlan);
            return ErrorCode.conflictWithExistPlan;
        }
    }
}
