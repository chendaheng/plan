package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.DistributePlanReq;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.PlanUpdateReq;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.planManagement.PlanModifyMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.plan.managementservice.mapper.planManagement.PlanUpdateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanUpdateServiceImply {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private PlanObtainMapper planObtainMapper;
    @Autowired
    private PlanUpdateMapper planUpdateMapper;
    @Autowired
    private PlanModifyMapper planModifyMapper;

    public int updatePlan (PlanUpdateReq planUpdateReq) {
        Plan oldPlan = planObtainMapper.getPlanById(planUpdateReq.getId());
        // 仅有已制定和被驳回两种状态下的计划可以修改
        if (oldPlan.getState() != PlanState.MADE && oldPlan.getState() != PlanState.REFUSED) {
            return ErrorCode.illegalStateUpdate;
        }
        String name = planUpdateReq.getName();
        String startDate = planUpdateReq.getStartDate();
        String endDate = planUpdateReq.getEndDate();
        Integer quantity = planUpdateReq.getQuantity();
        int parentId = oldPlan.getParentId();
        // 若修改了名称，需确保当前名称与其他同类计划的名称不重复
        if (!name.equals(oldPlan.getName())) {
            int count = planObtainMapper.countPlanByNameRangeIdType(name, oldPlan.getRangeId(), oldPlan.getType(), PlanState.DELETED);
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
            if (parentId != 0) {
                int parentQuantity = planObtainMapper.getPlanQuantityById(parentId);
                int sumOfQuantity = quantity;
                List<Integer> quantityList = planObtainMapper.getPlanQuantityByParentIdAndType(parentId, type, PlanState.DELETED);
                for (Integer i : quantityList) {
                    sumOfQuantity += i;
                }
                sumOfQuantity -= oldPlan.getQuantity();
                if (sumOfQuantity > parentQuantity) {
                    return ErrorCode.quantityExceed;
                }
            }
        }
        return planUpdateMapper.updatePlan(planUpdateReq);
    }

    public int submitPlan (int id) {
        // 仅允许已制定和被驳回状态的计划提交
        PlanState planState = planObtainMapper.getPlanStateById(id);
        if (planState != PlanState.MADE && planState != PlanState.REFUSED) {
            logger.error("id为" + id + "的计划状态不是已制定也不是被驳回,无法进行提交操作。");
            return ErrorCode.illegalStateUpdate;
        } else {
            return planUpdateMapper.updatePlanStateById(id, PlanState.SUBMIT);
        }
    }

    public int passPlan (int id) {
        // 仅允许已提交的计划审核通过
        PlanState planState = planObtainMapper.getPlanStateById(id);
        if (planState != PlanState.SUBMIT) {
            logger.error("id为" + id + "的计划状态不是已提交,无法进行审核操作。");
            return ErrorCode.illegalStateUpdate;
        } else {
            return planUpdateMapper.updatePlanStateById(id, PlanState.PASS);
        }
    }

    public int failPlan (int id, String reason) {
        // 仅允许已提交的计划被驳回
        PlanState planState = planObtainMapper.getPlanStateById(id);
        if (planState != PlanState.SUBMIT) {
            logger.error("id为" + id + "的计划状态不是已提交,无法进行驳回操作。");
            return ErrorCode.illegalStateUpdate;
        } else {
            return planUpdateMapper.failPlanById(id, reason, PlanState.PASS);
        }
    }

    public int cancelPassPlan (int id) {
        // 仅允许已通过的计划取消审核
        PlanState planState = planObtainMapper.getPlanStateById(id);
        if (planState != PlanState.PASS) {
            return ErrorCode.illegalStateUpdate;
        } else {
            return planUpdateMapper.updatePlanStateById(id, PlanState.SUBMIT);
        }
    }

    public int distributePlan (DistributePlanReq planReq) {
        // 仅允许已通过的计划下发
        int planId = planReq.getPlanId();
        List<Integer> executerIdList = planReq.getExecuterIdList();
        PlanState planState = planObtainMapper.getPlanStateById(planId);
        if (planState != PlanState.PASS) {
            return ErrorCode.illegalStateUpdate;
        } else {
            // 将更新的记录数返回
            int result = 0;
            for (Integer executerId  : executerIdList) {
                // 将计划id与被下发人id记录下来，两属性值共同为主键不得重复，由数据库控制
                try {
                    result += planModifyMapper.distributePlanToUser(planId, executerId);
                } catch (Exception e) {
                    e.printStackTrace();
                    result += 0;
                }
            }
            result += planUpdateMapper.updatePlanStateById(planId, PlanState.DISTRIBUTED);
            return result;
        }
    }

    public int restorePlan (int id) {
        // 确保恢复的计划为已删除计划
        PlanState planState = planObtainMapper.getPlanStateById(id);
        if (planState != PlanState.DELETED) {
            return ErrorCode.illegalStateUpdate;
        }
        // 获取待恢复计划信息
        Plan deletedPlan = planObtainMapper.getPlanById(id);
        String name = deletedPlan.getName();
        int rangeId = deletedPlan.getRangeId();
        PlanType type = deletedPlan.getType();
        int quantity = deletedPlan.getQuantity();
        int parentId = deletedPlan.getParentId();
        // 恢复的计划名称不得与已有计划重复
        int count = planObtainMapper.countPlanByNameRangeIdType(name, rangeId, type, PlanState.DELETED);
        if (count > 0) {
            return ErrorCode.planNameDuplication;
        }
        // 待恢复计划存在父计划时，确保其计划款数与其他兄弟计划的款数之和不大于父计划
        if (parentId != 0) {
            int parentQuantity = planObtainMapper.getPlanQuantityById(parentId);
            int sumOfQuantity = quantity;
            List<Integer> quantityList = planObtainMapper.getPlanQuantityByParentIdAndType(parentId, type, PlanState.DELETED);
            for (Integer i : quantityList) {
                sumOfQuantity += i;
            }
            if (sumOfQuantity > parentQuantity) {
                return ErrorCode.quantityExceed;
            }
        }
        // 以上条件均满足时，恢复计划
        if (deletedPlan.getRejectReason() != null) {
            return planUpdateMapper.updatePlanStateById(id, PlanState.REFUSED);
        } else {
            return planUpdateMapper.updatePlanStateById(id, PlanState.MADE);
        }
    }
}
