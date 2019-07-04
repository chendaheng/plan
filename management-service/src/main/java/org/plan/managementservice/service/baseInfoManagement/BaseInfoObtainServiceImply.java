package org.plan.managementservice.service.baseInfoManagement;

import org.plan.managementfacade.model.baseInfoModel.requestModel.MessageSearchReq;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.ClothingLevel;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Customer;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Product;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.SerialNoRegular;
import org.plan.managementfacade.model.enumModel.MessageState;
import org.plan.managementservice.general.SerialNumberGenerate;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoUpdateMapper;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseInfoObtainServiceImply {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    @Autowired
    private BaseInfoUpdateMapper baseInfoUpdateMapper;

    @Autowired
    private InfoObtainMapper infoObtainMapper;

    @Autowired
    private PlanObtainMapper planObtainMapper;

    public List <Product> getProduct (String name) {
        if (name == null) {
            return baseInfoObtainMapper.getAllProduct();
        } else {
            return baseInfoObtainMapper.getProductByName(name);
        }
    }

    public List<Customer> getCustomer (String name) {
        if (name == null) {
            return baseInfoObtainMapper.getAllCustomer();
        } else {
            return baseInfoObtainMapper.getCustomerByName(name);
        }
    }

    public List<CustomerName> getCustomerName(int userId) {
        // 获取客户名称
        return baseInfoObtainMapper.getCustomerName(userId);
    }

    public List<BrandResp> getBrand (String name, Integer customerId) {
        return baseInfoObtainMapper.getBrandByParams(name, customerId);
    }

    public List<BrandName> getBrandName(Integer customerId, Integer userId) {
        // 获取品牌名称
        return baseInfoObtainMapper.getBrandName(customerId, userId);
    }

    public List<ClothingLevel> getClothingLevel (String name) {
        if (name == null) {
            return baseInfoObtainMapper.getAllClothingLevel();
        } else {
            return baseInfoObtainMapper.getClothingLevelByName(name);
        }
    }

    public List<ClothingLevelName> getClothingLevelName() {
        // 获取服装层次名称
        return baseInfoObtainMapper.getClothingLevelName();
    }

    public List<UserName> getUserNameByBrandId (Integer brandId) {
        return baseInfoObtainMapper.getUserNameByBrandId(brandId);
    }

    public SerialNoRegular getSerialNoRegularByNumberObject(String numberObject){
        // 根据单号的对象查找单号生成规则
        List <SerialNoRegular> serialNoRegularList = baseInfoObtainMapper.getSerialNoRegularByObject(numberObject);
        if (serialNoRegularList.size() > 1){
            logger.error("同一个对象对应多个生成规则,请检查数据库");
            return null;
        }
        else if (serialNoRegularList.size() == 1){
            return serialNoRegularList.get(0);
        }
        else {
            logger.error("输入的对象为" + numberObject + "该对象不存在生成规则,请检查");
            return null;
        }
    }

    public SerialNoRegular getSerialNoRegularById(int id){
        // 根据id查找单号生成规则
        return baseInfoObtainMapper.getSerialNoRegularById(id).get(0);
    }

    public String generateSerialNo(SerialNoRegular serialNoRegular){
        // 生成单号
        int id = serialNoRegular.getId();
        String numberObject = serialNoRegular.getNumberObject();
        Boolean afterChangeGenerate = serialNoRegular.getAfterChangeGenerate();
        String lastNumber = null;
        switch (numberObject){
            case "系列":
                lastNumber = infoObtainMapper.getLastRangeNumber();
                break;
            case "款式组":
                lastNumber = infoObtainMapper.getLastStyleGroupNumber();
                break;
            case "计划":
                lastNumber = planObtainMapper.getLastPlanNumber();
                break;
            case "异常":
                lastNumber = planObtainMapper.getLastExceptionNumber();
                break;
        }
        String serialNo = SerialNumberGenerate.generateSerialNumber(serialNoRegular, lastNumber);
        if (afterChangeGenerate == false){
            baseInfoUpdateMapper.updateSerialNoRegularFlag(id);
        }
        return serialNo;
    }

    public List <MessageReceiveResp> getReceiveMessageResponse(MessageSearchReq messageSearchReq){
        // 获取当前用户收到的所有消息
        List <MessageReceiveResp> messageReceiveRespResult = baseInfoObtainMapper.getReceiveMessageResponse(messageSearchReq);
        for (MessageReceiveResp messageReceiveResp : messageReceiveRespResult){
            int state = messageReceiveResp.getState();
            String stateStr = MessageState.getName(state);
            messageReceiveResp.setStateStr(stateStr);
        }
        return messageReceiveRespResult;
    }

    public List <MessageSendResp> getSendMessageResponse(MessageSearchReq messageSearchReq){
        // 根据当前用户的id获取所有发送的消息
        List <MessageSendResp> messageSendRespResult = baseInfoObtainMapper.getSendMessageResponse(messageSearchReq);
        for (MessageSendResp messageSendResp : messageSendRespResult){
            int state = messageSendResp.getState();
            String stateStr = MessageState.getName(state);
            messageSendResp.setStateStr("对方" + stateStr);
        }
        return messageSendRespResult;
    }
}
