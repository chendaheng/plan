package org.plan.managementservice.mapper.baseInfoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.baseInfoModel.requestModel.MessageSearchReq;

public class BaseInfoObtainProvider {
    public String getBrandName (@Param("customerId") Integer customerId, @Param("userId") Integer userId) {
        return new SQL() {
            {
                SELECT("distinct brand.id, brand.name");
                FROM("brand").LEFT_OUTER_JOIN("user_customer_brand ON brand.id=user_customer_brand.brandId");
                if (customerId != null) {
                    WHERE("brand.customerId=#{customerId}");
                }
                WHERE("userId=#{userId}");
            }
        }.toString();
    }

    public String getBrandByParams (@Param("name") String name, @Param("customerId") Integer customerId) {
        return new SQL() {
            {
                SELECT("brand.*, customer.name AS customerName");
                FROM("brand").LEFT_OUTER_JOIN("customer ON brand.customerId=customer.id");
                if (name != null) {
                    WHERE("(brand.name LIKE '%" + name + "%'" + " OR brand.abbr ='" + name + "')");
                }
                if (customerId != null) {
                    WHERE("brand.customerId=" + customerId);
                }
            }
        }.toString();
    }

    public String getReceiveMessageResponse(@Param("messageSearchReq") MessageSearchReq messageSearchReq) {
        // 根据条件搜索当前用户接受的消息
        return new SQL(){
            {
                SELECT("*");
                FROM("message");
                if (messageSearchReq.getStartDate() != null){
                    WHERE("createTime>='" + messageSearchReq.getStartDate().toString() + "'");
                }
                if (messageSearchReq.getEndDate() != null){
                    WHERE("createTime<='" + messageSearchReq.getEndDate().toString() + "'");
                }
                WHERE("receiverId" + "=" + messageSearchReq.getUserId());
            }
        }.toString();
    }

    public String getSendMessageResponse(@Param("messageSearchReq") MessageSearchReq messageSearchReq) {
        // 根据条件搜索当前用户发送的消息
        return new SQL(){
            {
                SELECT("*");
                FROM("message");
                if (messageSearchReq.getStartDate() != null){
                    WHERE("createTime>='" + messageSearchReq.getStartDate().toString() + "'");
                }
                if (messageSearchReq.getEndDate() != null){
                    WHERE("createTime<='" + messageSearchReq.getEndDate().toString() + "'");
                }
                WHERE("senderId" + "=" + messageSearchReq.getUserId());
            }
        }.toString();
    }
}
