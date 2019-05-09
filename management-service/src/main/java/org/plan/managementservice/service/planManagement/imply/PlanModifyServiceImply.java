package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.PlanException;
import org.plan.managementfacade.model.planModel.Test;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.general.SerialNumberGenerate;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
import org.plan.managementservice.mapper.infoManagement.InfoUpdateMapper;
import org.plan.managementservice.mapper.planManagement.PlanModifyMapper;
import org.plan.managementservice.mapper.planManagement.PlanUpdateMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class PlanModifyServiceImply {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

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

    public int addPlan (PlanAddReq planAddReq, int userId, String userName, String deptName) {
        // 同一系列下同一类型计划名称不得重复,不包括已删除计划
        String name = planAddReq.getName();
        int rangeId = planAddReq.getRangeId();
        PlanType type = planAddReq.getType();
        boolean isRoot = planAddReq.isRoot();
        int count = planObtainMapper.countPlanByNameRangeIdType(name, rangeId, type, PlanState.DELETED);
        if (count > 0) {
            logger.error("计划名称重复,新增计划失败。当前新增计划的名称为:" + name);
            return ErrorCode.planNameDuplication;
        }
        // 将款式组根计划的父id设为系列根计划的id
        if (type == PlanType.STYLEGROUP && isRoot) {
            int parentIdOfRange = planObtainMapper.getRangeRootPlanId(rangeId, PlanType.RANGE);
            if (parentIdOfRange == 0) {
                logger.error("系列根计划不存在,新增系列计划失败。");
                return ErrorCode.rangeRootPlanNotExist;
            } else {
                planAddReq.setParentId(parentIdOfRange);
            }
        }
        // 将款式根计划的父id设为款式组根计划的id
        if (type == PlanType.STYLE && isRoot) {
            int styleGroupId = infoObtainMapper.getStyleGroupIdByStyleId(planAddReq.getPlanObjectId());
            int parentIdOfStyleGroup = planObtainMapper.getStyleGroupRootPlanId(styleGroupId, PlanType.STYLEGROUP);
            if (parentIdOfStyleGroup == 0) {
                logger.error("款式组根计划不存在,新增款式组计划失败");
                return ErrorCode.styleGroupRootPlanNotExist;
            } else {
                planAddReq.setParentId(parentIdOfStyleGroup);
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
        // 同类型子计划的款数之和不得超过父计划的款数
        if (parentId != 0) {
            int parentQuantity = planObtainMapper.getPlanQuantityById(parentId);
            int sumOfQuantity = planAddReq.getQuantity();
            List<Integer> quantityList = planObtainMapper.getPlanQuantityByParentIdAndType(parentId, type, PlanState.DELETED);
            for (Integer i : quantityList) {
                sumOfQuantity += i;
            }
            if (sumOfQuantity > parentQuantity) {
                logger.error("计划款数超额,新增计划失败。父计划的款数为:" + parentQuantity);
                return ErrorCode.quantityExceed;
            }
        }
        // 以上条件都满足时，添加计划
        Plan plan = new Plan(planAddReq);
        plan.setNumber("JX" + Calendar.YEAR + Calendar.MONTH + Calendar.DAY_OF_MONTH + "001");
        System.out.println(plan.getNumber());
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
        return result;
    }

    public int addExceptionForPlan(PlanException planException) {
        String lastNumber = planObtainMapper.getLastExceptionNumber();
        String number = SerialNumberGenerate.generateNumber("YC", lastNumber);
        planException.setNumber(number);
        return planModifyMapper.addExceptionForPlan(planException);
    }

    public int deletePlan(int id) {
        // 只有当计划状态为已制定/被驳回时才能删除
        Plan plan = planObtainMapper.getPlanById(id);
        PlanState planState = plan.getState();
        if (planState != PlanState.MADE && planState != PlanState.REFUSED) {
            logger.error("id为" + id + "的计划状态不是已制定也不是已驳回,无法进行删除操作。");
            return ErrorCode.illegalStateUpdate;
        } else {
            int result = planUpdateMapper.deletePlanById(id, PlanState.DELETED);
            boolean isRoot = plan.isRoot();
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
