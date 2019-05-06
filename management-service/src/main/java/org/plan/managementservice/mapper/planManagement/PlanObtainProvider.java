package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;

import java.util.Map;

public class PlanObtainProvider {
    public String getPlanListInPredictByParams (Map<String, Object> params) {
        String[] keyList = {"customerId", "brandId", "rangeId", "name", "clothingLevelId", "userId"};
        return new SQL() {
            {
                SELECT("*").FROM("plansearch");
                for (String key : keyList) {
                    if (params.containsKey(key)) {
                        Object value = params.get(key);
                        WHERE(key + "='" + value + "'");
                    }
                }
                if (params.containsKey("startDate")) {
                    WHERE("createTime>='" + params.get("startDate").toString() + "'");
                }
                if (params.containsKey("endDate")) {
                    WHERE("createTime<='" + params.get("endDate").toString() + "'");
                }
                WHERE("type=" + PlanType.PREDICT.getIndex());
                WHERE("state!=" + PlanState.DELETED.getIndex());
            }
        }.toString();
    }


    public String getPlanListInManageByParams (Map<String, Object> params) {
        String[] keyList = {"customerId", "brandId", "rangeId", "name", "clothingLevelId", "userId"};
        return new SQL() {
            {
                SELECT("*").FROM("plansearch");
                for (String key : keyList) {
                    if (params.containsKey(key)) {
                        Object value = params.get(key);
                        WHERE(key + "='" + value + "'");
                    }
                }
                if (params.containsKey("startDate")) {
                    WHERE("createTime>='" + params.get("startDate").toString() + "'");
                }
                if (params.containsKey("endDate")) {
                    WHERE("createTime<='" + params.get("endDate").toString() + "'");
                }
                WHERE("state!=" + PlanState.DELETED.getIndex());
            }
        }.toString();
    }

    public String getPlanListInReviewByParams (Map<String, Object> params) {
        String[] keyList = {"customerId", "brandId", "rangeId", "name", "clothingLevelId", "userId"};
        return new SQL() {
            {
                SELECT("*").FROM("plansearch");
                for (String key : keyList) {
                    if (params.containsKey(key)) {
                        Object value = params.get(key);
                        WHERE(key + "='" + value + "'");
                    }
                }
                if (params.containsKey("startDate")) {
                    WHERE("createTime>='" + params.get("startDate").toString() + "'");
                }
                if (params.containsKey("endDate")) {
                    WHERE("createTime<='" + params.get("endDate").toString() + "'");
                }
                WHERE("state=" + PlanState.SUBMIT.getIndex()).OR().WHERE("state=" + PlanState.PASS.getIndex());
            }
        }.toString();
    }

    public String getPlanListInDistributeByParams (Map<String, Object> params) {
        String[] keyList = {"customerId", "brandId", "rangeId", "name", "clothingLevelId", "userId"};
        return new SQL() {
            {
                SELECT("*").FROM("plansearch");
                for (String key : keyList) {
                    if (params.containsKey(key)) {
                        Object value = params.get(key);
                        WHERE(key + "='" + value + "'");
                    }
                }
                if (params.containsKey("startDate")) {
                    WHERE("createTime>='" + params.get("startDate").toString() + "'");
                }
                if (params.containsKey("endDate")) {
                    WHERE("createTime<='" + params.get("endDate").toString() + "'");
                }
                WHERE("state=" + PlanState.PASS.getIndex()).OR().WHERE("state=" + PlanState.DISTRIBUTED.getIndex());
            }
        }.toString();
    }

    public String getPlanListInDeleteByParams (Map<String, Object> params) {
        String[] keyList = {"customerId", "brandId", "rangeId", "name", "clothingLevelId", "userId"};
        return new SQL() {
            {
                SELECT("*").FROM("plansearch");
                for (String key : keyList) {
                    if (params.containsKey(key)) {
                        Object value = params.get(key);
                        WHERE(key + "='" + value + "'");
                    }
                }
                if (params.containsKey("startDate")) {
                    WHERE("createTime>='" + params.get("startDate").toString() + "'");
                }
                if (params.containsKey("endDate")) {
                    WHERE("createTime<='" + params.get("endDate").toString() + "'");
                }
                WHERE("state=" + PlanState.DELETED.getIndex());
            }
        }.toString();
    }

    public String getPlanExceptionListByParams(Map<String, Object> params) {
        String[] keyList = {"customerId", "brandId", "rangeId", "userId"};
        return new SQL() {
            {
                SELECT("*").FROM("planexceptionsearch");
                for (String key : keyList) {
                    if (params.containsKey(key)) {
                        Object value = params.get(key);
                        WHERE(key + "='" + value + "'");
                    }
                }
                if (params.containsKey("startDate")) {
                    WHERE("createTime>='" + params.get("startDate").toString() + "'");
                }
                if (params.containsKey("endDate")) {
                    WHERE("createTime<='" + params.get("endDate").toString() + "'");
                }
            }
        }.toString();
    }
}
