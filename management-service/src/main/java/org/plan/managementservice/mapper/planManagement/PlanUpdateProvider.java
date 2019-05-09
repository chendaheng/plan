package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.planModel.PlanUpdateReq;

public class PlanUpdateProvider {
    public String updatePlan (PlanUpdateReq planUpdateReq) {
        return new SQL() {
            {
                UPDATE("plan");
                if (planUpdateReq.getName() != null){
                    SET("name" + "='" + planUpdateReq.getName() + "'");
                }
                if (planUpdateReq.getProjectType() != null){
                    SET("projectType" + "=" + planUpdateReq.getProjectType());
                }
                if (planUpdateReq.getQuantity() != null){
                    SET("quantity" + "=" + planUpdateReq.getQuantity());
                }
                if (planUpdateReq.getProductId() != null){
                    SET("productId" + "=" + planUpdateReq.getProductId());
                }
                if (planUpdateReq.getProductDate() != null){
                    SET("productDate" + "='" + planUpdateReq.getProductDate() + "'");
                }
                if (planUpdateReq.getProductDateType() != null) {
                    SET("productDateType" + "='" + planUpdateReq.getProductDateType() + "'");
                }
                if (planUpdateReq.getStartDate() != null) {
                    SET("startDate" + "='" + planUpdateReq.getStartDate() + "'");
                }
                if (planUpdateReq.getEndDate() != null) {
                    SET("endDate" + "='" + planUpdateReq.getEndDate() + "'");
                }
                if (planUpdateReq.getProposal() != null) {
                    SET("proposal" + "='" + planUpdateReq.getProposal() + "'");
                }
                if (planUpdateReq.getDescription() != null) {
                    SET("description" + "='" + planUpdateReq.getDescription() + "'");
                }
                if (planUpdateReq.getNote() != null) {
                    SET("note" + "='" + planUpdateReq.getNote() + "'");
                }
                WHERE("id" + "=" + planUpdateReq.getId());
            }
        }.toString();
    }
}
