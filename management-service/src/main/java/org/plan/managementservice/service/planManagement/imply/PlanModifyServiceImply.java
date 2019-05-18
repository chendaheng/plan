package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.sqlModel.Plan;
import org.plan.managementfacade.model.planModel.requestModel.PlanAddReq;
import org.plan.managementfacade.model.planModel.sqlModel.PlanException;
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
            count = planObtainMapper.countRootPlanByTypeAndPlanObject(type, planObjectId, true, PlanState.DISTRIBUTED);
            if (count > 0) {
                logger.error("当前计划对象根计划已存在，无法新增根计划！");
                return ErrorCode.rootPlanExist;
            }
            // 将款式组根计划的父id设为系列根计划的id
            if (type == PlanType.STYLEGROUP) {
                int parentIdOfRange = planObtainMapper.getRangeRootPlanId(rangeId, PlanType.RANGE, PlanState.DELETED);
                if (parentIdOfRange == 0) {
                    logger.error("系列根计划不存在,新增款式组根计划失败。");
                    return ErrorCode.rangeRootPlanNotExist;
                } else {
                    planAddReq.setParentId(parentIdOfRange);
                }
            }
            // 将款式根计划的父id设为款式组根计划的id
            if (type == PlanType.STYLE) {
                int styleGroupId = infoObtainMapper.getStyleGroupIdByStyleId(planAddReq.getPlanObjectId());
                int parentIdOfStyleGroup = planObtainMapper.getStyleGroupRootPlanId(styleGroupId, PlanType.STYLEGROUP, PlanState.DELETED);
                if (parentIdOfStyleGroup == 0) {
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
        String lastNumber = planObtainMapper.getLastPlanNumber();
        String number = SerialNumberGenerate.generateNumber("JX", lastNumber);
        plan.setNumber(number);
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
        planAddReq.setName("新的款式组根计划");
        planAddReq.setProposal("新的款式组根计划");
        planAddReq.setDescription("由引用系列计划生成");
        planAddReq.setType(PlanType.STYLEGROUP);
        planAddReq.setPlanObjectId(styleGroupId);
        return addPlan(planAddReq, userName, deptName);
    }


    public int addExceptionForPlan(PlanException planException) {
        String lastNumber = planObtainMapper.getLastExceptionNumber();
        String number = SerialNumberGenerate.generateNumber("YC", lastNumber);
        planException.setNumber(number);
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
