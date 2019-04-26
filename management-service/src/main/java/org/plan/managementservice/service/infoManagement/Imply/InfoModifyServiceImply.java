package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;
import org.plan.managementfacade.service.infoService.*;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.baseInfoManagement.*;
import org.plan.managementservice.mapper.infoManagement.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InfoModifyServiceImply implements InfoModifyService {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoModifyMapper infoModifyMapper;

    @Autowired
    private InfoObtainMapper infoObtainMapper;

    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    @Override
    public int addRange(RangeAddRequest rangeAddRequest) {
        // 新增系列
        String name = rangeAddRequest.getName();
        List <Range> rangeResult = infoObtainMapper.getRangeByName(name);
        if (rangeResult.size() > 0){
            logger.error("数据库中已存在该系列的名称");
            return ErrorCode.dataExist;
        }else {
            rangeAddRequest.setNumber("XL_new");
            rangeAddRequest.setAddingMode(1);
            rangeAddRequest.setCreaterId(3);
            rangeAddRequest.setCreaterName("张三");
            rangeAddRequest.setDeptName("信息管理");
            return infoModifyMapper.addRange(rangeAddRequest);
        }
    }

    @Override
    public int addRangeList(List <RangeAddRequest> rangeAddRequestList) {
        // 批量新增系列
        int addRangeCount = 0;
        for (RangeAddRequest rangeAddRequest : rangeAddRequestList){
            String name = rangeAddRequest.getName();
            List <Range> rangeResult = infoObtainMapper.getRangeByName(name);
            if (rangeResult.size() > 0) {
                logger.info("数据库中已存在该系列的名称,当前系列的名称为:" + rangeAddRequest.getName());
            }
            else {
                rangeAddRequest.setNumber("XL_new");
                rangeAddRequest.setAddingMode(2);
                rangeAddRequest.setCreaterId(3);
                rangeAddRequest.setCreaterName("张三");
                int addResult = infoModifyMapper.addRange(rangeAddRequest);
                if (addResult == 1){
                    addRangeCount += addResult;
                }
                else {
                    logger.info("新增信息出错,当前系列的名称为:" + rangeAddRequest.getName());
                }
            }
        }
        return addRangeCount;
    }

    @Override
    public int deleteRange(int id) {
        // 删除系列
        return infoModifyMapper.deleteRange(id);
    }

    @Override
    public int addStyleGroup(StyleGroupAddRequest styleGroupAddRequest) {
        // 新增款式组
        String name = styleGroupAddRequest.getName();
        List <StyleGroup> styleGroupResult = infoObtainMapper.getStyleGroupByName(name);
        if (styleGroupResult.size() > 0){
            logger.error("数据库中已存在该款式组的名称");
            return ErrorCode.dataExist;
        }
        else {
            styleGroupAddRequest.setNumber("KSZ_new");
            styleGroupAddRequest.setCreaterId(3);
            styleGroupAddRequest.setCreaterName("张三");
            styleGroupAddRequest.setDeptName("信息管理");
            return infoModifyMapper.addStyleGroup(styleGroupAddRequest);
        }
    }

    @Override
    public int deleteStyleGroup(int id) {
        // 删除款式组
        List <StyleGroup> styleGroupResult = infoObtainMapper.getStyleGroupById(id);
        int state = styleGroupResult.get(0).getState();
        if (state == 2){
            logger.error("该款式组已经与款式绑定，无法删除");
            return ErrorCode.sqlError;
        }
        else {
            return infoModifyMapper.deleteStyleGroup(id);
        }
    }

    @Override
    public int addStyle(StyleAddRequest styleAddRequest) {
        // 新增款式
        String number = styleAddRequest.getNumber();
        List <Style> styleResult = infoObtainMapper.getStyleByNumber(number);
        if (styleResult.size() > 0){
            logger.error("数据库中已存在该款式的款号");
            return ErrorCode.dataExist;
        }
        else {
            styleAddRequest.setAddingMode(1);
            styleAddRequest.setCreaterId(3);
            styleAddRequest.setCreaterName("张三");
            styleAddRequest.setDeptName("信息管理");
            return infoModifyMapper.addStyle(styleAddRequest);
        }
    }

    @Override
    public int addStyleList(List<StyleAddRequest> styleAddRequestList) {
        // 批量新增款式
        int addRangeCount = 0;
        for (StyleAddRequest styleAddRequest : styleAddRequestList){
            String number = styleAddRequest.getNumber();
            List <Style> styleResult = infoObtainMapper.getStyleByNumber(number);
            if (styleResult.size() > 0){
                logger.error("数据库中已存在该款式的款号,当前款式的款号为:" + styleAddRequest.getNumber());
            }
            else {
                styleAddRequest.setAddingMode(2);
                styleAddRequest.setCreaterId(3);
                styleAddRequest.setCreaterName("张三");
                styleAddRequest.setDeptName("信息管理");
                int addResult = infoModifyMapper.addStyle(styleAddRequest);
                if (addResult == 1){
                    addRangeCount += addResult;
                }
                else {
                    logger.info("新增信息出错,当前款式的款号为:" + styleAddRequest.getNumber());
                }
            }
        }
        return addRangeCount;
    }

    @Override
    public int deleteStyle(int id) {
        // 删除款式
        List <Style> styleResult = infoObtainMapper.getStyleById(id);
        int state = styleResult.get(0).getState();
        if (state == 2){
            logger.error("该款式已经与款式组绑定，无法删除");
            return ErrorCode.sqlError;
        }
        else {
            return infoModifyMapper.deleteStyle(id);
        }
    }
}
