package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.Test;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
import org.plan.managementservice.mapper.planManagement.PlanModifyMapper;
import org.plan.managementservice.mapper.planManagement.PlanUpdateMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class PlanModifyServiceImply {
    /*--------------------此处为临时设定，userId与userName应从网关获取-------------------------------------*/
    private static final int userId = 3;
    private static final String userName = "张三";
    @Autowired
    private PlanModifyMapper planModifyMapper;
    @Autowired
    private PlanObtainMapper planObtainMapper;
    @Autowired
    private  PlanUpdateMapper planUpdateMapper;
    @Autowired
    private InfoObtainMapper infoObtainMapper;

    public int addPlan (PlanAddReq planAddReq) {
        // 同一系列下同一类型计划名称不得重复
        String name = planAddReq.getName();
        int rangeId = planAddReq.getRangeId();
        PlanType type = planAddReq.getType();
        boolean isRoot = planAddReq.isRoot();
        int count = planObtainMapper.countPlanByNameRangeIdType(name, rangeId, type);
        if (count > 0) {
            return ErrorCode.planNameDuplication;
        }
        // 将款式组根计划的父id设为系列根计划的id
        if (type == PlanType.STYLEGROUP && isRoot) {
            int parentIdOfRange = planObtainMapper.getRangeRootPlanId(rangeId, PlanType.RANGE);
            if (parentIdOfRange == 0) {
                return ErrorCode.rangeRootPlanNotExist;
            } else {
                planAddReq.setParentId(parentIdOfRange);
                // 此处确保款式组根计划的款数之和不超过系列根计划——存疑，需确认
                int sumOfQuantity = planAddReq.getQuantity();
                int parentQuantity = planObtainMapper.getQuantityById(parentIdOfRange);
                List<Integer> quanttityList = planObtainMapper.getQuantityByParentIdAndType(parentIdOfRange, PlanType.STYLEGROUP, PlanState.DELETED);
                for (Integer i : quanttityList) {
                    sumOfQuantity += i;
                }
                if (sumOfQuantity > parentQuantity) {
                    return ErrorCode.quantityExceed;
                }
            }
        }
        // 将款式根计划的父id设为款式组根计划的id
        if (type == PlanType.STYLE && isRoot) {
            int styleGroupId = infoObtainMapper.getStyleGroupIdByStyleId(planAddReq.getPlanObjectId());
            int parentIdOfStyleGroup = planObtainMapper.getStyleGroupRootPlanId(styleGroupId, PlanType.STYLEGROUP);
            if (parentIdOfStyleGroup == 0) {
                return ErrorCode.styleGroupRootPlanNotExist;
            } else {
                planAddReq.setParentId(parentIdOfStyleGroup);
                // 此处确保款式根计划的款数之和不超过款式组根计划——存疑，需确认
                int sumOfQuantity = planAddReq.getQuantity();
                int parentQuantity = planObtainMapper.getQuantityById(parentIdOfStyleGroup);
                List<Integer> quanttityList = planObtainMapper.getQuantityByParentIdAndType(parentIdOfStyleGroup, PlanType.STYLE, PlanState.DELETED);
                for (Integer i : quanttityList) {
                    sumOfQuantity += i;
                }
                if (sumOfQuantity > parentQuantity) {
                    return ErrorCode.quantityExceed;
                }
            }
        }
        int parentId = planAddReq.getParentId();
        // 所有计划必须在父计划下发后才可制定，且开始结束时间位于父计划区间内
        if (parentId != 0) {
            PlanState parentPlanState = planObtainMapper.getPlanStateById(parentId);
            if (parentPlanState != PlanState.DISTRIBUTED) {
                return ErrorCode.parentNotDistributed;
            }
            String startDate = planAddReq.getStartDate();
            String endDate = planAddReq.getEndDate();
            String parentStartDate = planObtainMapper.getPlanStartDateById(parentId);
            String parentEndDate = planObtainMapper.getPlanEndDateById(parentId);
            if (startDate.compareTo(parentStartDate) < 0 || endDate.compareTo(parentEndDate) > 0) {
                return ErrorCode.dateOutOfRange;
            }
        }
        // 同类型子计划的款数之和不得超过父计划的款数
        if (parentId != 0 && !isRoot) {
            int parentQuantity = planObtainMapper.getQuantityById(parentId);
            int sumOfQuantity = planAddReq.getQuantity();
            List<Integer> quantityList = planObtainMapper.getQuantityByParentIdAndType(parentId, type, PlanState.DELETED);
            for (Integer i : quantityList) {
                sumOfQuantity += i;
            }
            if (sumOfQuantity > parentQuantity) {
                return ErrorCode.quantityExceed;
            }
        }
        // 以上条件都满足时，添加计划
        Plan plan = new Plan(planAddReq);
        plan.setNumber("JX" + Calendar.YEAR + Calendar.MONTH + Calendar.DAY_OF_MONTH + "001");
        System.out.println(plan.getNumber());
        plan.setState(PlanState.MADE);
        plan.setCreaterId(userId);
        plan.setCreaterName(userName);
        return planModifyMapper.addPlan(plan);
    }

    public int addPlan (Plan plan) {
        // 同一系列下同一类型计划名称不得重复
        String name = plan.getName();
        int rangeId = plan.getRangeId();
        PlanType type = plan.getType();
        boolean isRoot = plan.isRoot();
        int count = planObtainMapper.countPlanByNameRangeIdType(name, rangeId, type);
        if (count > 0) {
            return ErrorCode.planNameDuplication;
        }
        // 将款式组根计划的父id设为系列根计划的id
        if (type == PlanType.STYLEGROUP && isRoot) {
            int parentIdOfRange = planObtainMapper.getRangeRootPlanId(rangeId, PlanType.RANGE);
            if (parentIdOfRange == 0) {
                return ErrorCode.rangeRootPlanNotExist;
            } else {
                plan.setParentId(parentIdOfRange);
                // 此处确保款式组根计划的款数之和不超过系列根计划——存疑，需确认
                int sumOfQuantity = plan.getQuantity();
                int parentQuantity = planObtainMapper.getQuantityById(parentIdOfRange);
                List<Integer> quanttityList = planObtainMapper.getQuantityByParentIdAndType(parentIdOfRange, PlanType.STYLEGROUP, PlanState.DELETED);
                for (Integer i : quanttityList) {
                    sumOfQuantity += i;
                }
                if (sumOfQuantity > parentQuantity) {
                    return ErrorCode.quantityExceed;
                }
            }
        }
        // 将款式根计划的父id设为款式组根计划的id
        if (type == PlanType.STYLE && isRoot) {
            int styleGroupId = infoObtainMapper.getStyleGroupIdByStyleId(plan.getPlanObjectId());
            int parentIdOfStyleGroup = planObtainMapper.getStyleGroupRootPlanId(styleGroupId, PlanType.STYLEGROUP);
            if (parentIdOfStyleGroup == 0) {
                return ErrorCode.styleGroupRootPlanNotExist;
            } else {
                plan.setParentId(parentIdOfStyleGroup);
                // 此处确保款式根计划的款数之和不超过款式组根计划——存疑，需确认
                int sumOfQuantity = plan.getQuantity();
                int parentQuantity = planObtainMapper.getQuantityById(parentIdOfStyleGroup);
                List<Integer> quanttityList = planObtainMapper.getQuantityByParentIdAndType(parentIdOfStyleGroup, PlanType.STYLE, PlanState.DELETED);
                for (Integer i : quanttityList) {
                    sumOfQuantity += i;
                }
                if (sumOfQuantity > parentQuantity) {
                    return ErrorCode.quantityExceed;
                }
            }
        }
        int parentId = plan.getParentId();
        // 所有计划必须在父计划下发后才可制定，且开始结束时间位于父计划区间内
        if (parentId != 0) {
            PlanState parentPlanState = planObtainMapper.getPlanStateById(parentId);
            if (parentPlanState != PlanState.DISTRIBUTED) {
                return ErrorCode.parentNotDistributed;
            }
            String startDate = plan.getStartDate();
            String endDate = plan.getEndDate();
            String parentStartDate = planObtainMapper.getPlanStartDateById(parentId);
            String parentEndDate = planObtainMapper.getPlanEndDateById(parentId);
            if (startDate.compareTo(parentStartDate) < 0 || endDate.compareTo(parentEndDate) > 0) {
                return ErrorCode.dateOutOfRange;
            }
        }
        // 同类型子计划的款数之和不得超过父计划的款数
        if (parentId != 0 && !isRoot) {
            int parentQuantity = planObtainMapper.getQuantityById(parentId);
            int sumOfQuantity = plan.getQuantity();
            List<Integer> quantityList = planObtainMapper.getQuantityByParentIdAndType(parentId, type, PlanState.DELETED);
            for (Integer i : quantityList) {
                sumOfQuantity += i;
            }
            if (sumOfQuantity > parentQuantity) {
                return ErrorCode.quantityExceed;
            }
        }
        // 以上条件都满足时，添加计划
        return planModifyMapper.addPlan(plan);
    }

    public int deletePlan(int id) {
        // 只有当计划状态为已制定/被驳回时才能删除
        PlanState planState = planObtainMapper.getPlanStateById(id);
        if (planState != PlanState.MADE && planState != PlanState.REFUSED) {
            return ErrorCode.illegalStateUpdate;
        } else {
            return planUpdateMapper.updatePlanStateAndDeleteTimeById(id, PlanState.DELETED);
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
