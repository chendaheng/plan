package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.Test;

import java.time.temporal.ValueRange;

public class PlanModifyProvider {
    public String addPlan (Plan plan) {
        return new SQL() {
            {
                INSERT_INTO("plan");
                if (plan.getId() != null) {
                    VALUES("id",  plan.getId() + "");
                }
                if (plan.getNumber() != null) {
                    VALUES("number", "'" + plan.getNumber() + "'");
                }
                if (plan.getName() != null) {
                    VALUES("name", "'" + plan.getName() + "'");
                }
                if (plan.getRangeId() != null) {
                    VALUES("rangeId", plan.getRangeId() + "");
                }
                if (plan.getType() != null) {
                    VALUES("type",  plan.getType().getIndex() + "");
                }
                VALUES("isRoot", plan.isRoot() + "");
                if (plan.getParentId() != null) {
                    VALUES("parentId", plan.getParentId() + "");
                }
                if (plan.getPlanObjectId() != null) {
                    VALUES("planObjectId", plan.getPlanObjectId() + "");
                }
                if (plan.getProjectType() != null) {
                    VALUES("projectType", plan.getProjectType().getIndex() + "");
                }
                if (plan.getOrder() != null) {
                    VALUES("order", plan.getOrder() + "");
                }
                if (plan.getQuantity() != null) {
                    VALUES("quantity", plan.getQuantity() + "");
                }
                if (plan.getProductId() != null) {
                    VALUES("productId", plan.getProductId() + "");
                }
                if (plan.getProductDate() != null) {
                    VALUES("productDate", "'" + plan.getProductDate() + "'");
                }
                if (plan.getProductDateType() != null) {
                    VALUES("productDateType", "'" + plan.getProductDateType() + "'");
                }
                if (plan.getStartDate() != null) {
                    VALUES("startDate", "'" + plan.getStartDate() + "'");
                }
                if (plan.getEndDate() != null) {
                    VALUES("endDate", "'" + plan.getEndDate() + "'");
                }
                if (plan.getProposal() != null) {
                    VALUES("proposal", "'" + plan.getProposal() + "'");
                }
                if (plan.getDescription() != null) {
                    VALUES("description", "'" + plan.getDescription() + "'");
                }
                if (plan.getState() != null) {
                    VALUES("state", plan.getState().getIndex() + "");
                }
                VALUES("createrId", plan.getCreaterId() + "");
                VALUES("createrName", "'" + plan.getCreaterName() + "'");
                VALUES("deptName", "'" + plan.getDeptName() + "'");
                if (plan.getCreateTime() != null) {
                    VALUES("createTime", "'" + plan.getCreateTime() + "'");
                }
                if (plan.getRejectReason() != null) {
                    VALUES("rejectReason", "'" + plan.getRejectReason() + "'");
                }
                if (plan.getDeleteTime() != null) {
                    VALUES("deleteTime", "'" + plan.getDeleteTime() + "'");
                }
                VALUES("haveException", plan.isHaveException() + "");
                if (plan.getNote() != null) {
                    VALUES("note", "'" + plan.getNote() + "'");
                }
            }
        }.toString();

    }
//    public String addTest (@Param("test") Test test) {
//        return new SQL() {
//            {
//                INSERT_INTO("test");
//                VALUES("id", "'" + test.getId() + "'");
//                VALUES("type", "'" + test.getType().getIndex() + "'");
//                VALUES("note", "'" + test.getNote() + "'");
//            }
//        }.toString();
//    }
}
