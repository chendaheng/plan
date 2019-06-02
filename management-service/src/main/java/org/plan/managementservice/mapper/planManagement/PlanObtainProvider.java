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
                WHERE("isCompleted=false");
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
                WHERE("type!=" + PlanType.PREDICT.getIndex());
                WHERE("state!=" + PlanState.DELETED.getIndex());
                WHERE("isCompleted=false");
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
                WHERE("type!=" + PlanType.PREDICT.getIndex());
                WHERE("(state=" + PlanState.SUBMIT.getIndex() + " OR state=" + PlanState.PASS.getIndex() + " OR state=" + PlanState.DISTRIBUTED.getIndex() + ")");
                WHERE("isCompleted=false");
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
                WHERE("type!=" + PlanType.PREDICT.getIndex());
                WHERE("(state=" + PlanState.PASS.getIndex() + " OR state=" + PlanState.DISTRIBUTED.getIndex() + ")");
                WHERE("isCompleted=false");
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
                WHERE("isCompleted=false");
            }
        }.toString();
    }

    public String getDistributedPlanListByParams (Map<String, Object> params) {
        String[] keyList = {"customerId", "brandId", "rangeId", "name", "clothingLevelId", "executerId"};
        return new SQL() {
            {
                SELECT("*").FROM("distributedplansearch");
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
                WHERE("isCompleted=false");
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

    public String getCompletedPlanListByParams(Map<String, Object> params) {
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
                WHERE("isCompleted=true");
            }
        }.toString();
    }

    public String getRootPlanByParams(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("planObjectId, type").FROM("plan");
                if (params.containsKey("name")) {
                    WHERE("name LIKE '%" + params.get("name").toString() + "%'");
                }
                if (params.containsKey("startDate")) {
                    WHERE("startDate>='" + params.get("startDate").toString() + "'");
                }
                if (params.containsKey("endDate")) {
                    WHERE("endDate<='" + params.get("endDate").toString() + "'");
                }
                if (params.containsKey("createrName")) {
                    WHERE("createrName='" + params.get("createrName").toString() + "'");
                }
                if (params.containsKey("id")) {
                    WHERE("parentId='" + params.get("id").toString() + "'");
                } else {
                    WHERE("parentId=0");
                }
                WHERE("isRoot=true");
                WHERE("type!='" + PlanType.PREDICT.getIndex() + "'");
            }
        }.toString();
    }
}
