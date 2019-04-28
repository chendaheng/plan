package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;
import org.plan.managementfacade.service.infoService.*;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.infoManagement.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoUpdateServiceImply implements InfoUpdateService {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoUpdateMapper infoUpdateMapper;

    @Autowired
    private InfoObtainMapper infoObtainMapper;

    @Override
    public int updateRange(RangeUpdateRequest rangeUpdateRequest) {
        // 更新系列信息
        String name = rangeUpdateRequest.getName();
        List <Range> rangeResult = infoObtainMapper.getRangeByName(name);
        if (rangeResult.size() == 0){
            logger.info("当前传入的系列名称不存在，操作将更新系列名称");
            return infoUpdateMapper.updateRange(rangeUpdateRequest);
        }
        else if (rangeResult.size() == 1){
            int idDatabase = rangeResult.get(0).getId();
            int id = rangeUpdateRequest.getId();
            if (idDatabase == id){
                logger.info("当前更新系列名称不变，将更新其他信息");
                return infoUpdateMapper.updateRange(rangeUpdateRequest);
            }
            else {
                logger.error("数据库中已存在相同的系列名称,更新失败");
                return ErrorCode.dataExist;
            }
        }
        else if (rangeResult.size() > 1){
            logger.error("数据不唯一,更新失败，请检查数据库");
            return ErrorCode.notUnique;
        }
        else {
            logger.error("其他错误");
            return ErrorCode.otherError;
        }
    }

    @Override
    public int updateStyleGroup(StyleGroupUpdateRequest styleGroupUpdateRequest) {
        // 更新款式组信息
        String name = styleGroupUpdateRequest.getName();
        List <StyleGroup> styleGroupResult = infoObtainMapper.getStyleGroupByName(name);
        if (styleGroupResult.size() == 0){
            logger.info("当前传入的款式组名称不存在，操作将更新款式组名称");
            return infoUpdateMapper.updateStyleGroup(styleGroupUpdateRequest);
        }
        else if (styleGroupResult.size() == 1){
            int idDatabase = styleGroupResult.get(0).getId();
            int id = styleGroupUpdateRequest.getId();
            if (idDatabase == id){
                logger.info("当前更新款式组名称不变，将更新其他信息");
                return infoUpdateMapper.updateStyleGroup(styleGroupUpdateRequest);
            }
            else {
                logger.error("数据库中已存在相同的款式组名称,更新失败");
                return ErrorCode.dataExist;
            }
        }
        else if (styleGroupResult.size() > 1){
            logger.error("数据不唯一,更新失败，请检查数据库");
            return ErrorCode.notUnique;
        }
        else {
            logger.error("其他错误");
            return ErrorCode.otherError;
        }
    }

    @Override
    public int updateStyle(StyleUpdateRequest styleUpdateRequest) {
        // 更新款式信息
        String number = styleUpdateRequest.getNumber();
        List <Style> styleResult = infoObtainMapper.getStyleByNumber(number);
        if (styleResult.size() == 0){
            logger.info("当前传入的款号不存在，操作将更新款号");
            return infoUpdateMapper.updateStyle(styleUpdateRequest);
        }
        if (styleResult.size() == 1){
            int idDatabase = styleResult.get(0).getId();
            int id = styleUpdateRequest.getId();
            if (idDatabase == id){
                logger.info("当前更新款号不变，将更新其他信息");
                return infoUpdateMapper.updateStyle(styleUpdateRequest);
            }
            else {
                logger.error("数据库中已存在相同的款号,更新失败");
                return ErrorCode.dataExist;
            }
        }
        else if (styleResult.size() > 1){
            logger.error("数据不唯一,更新失败，请检查数据库");
            return ErrorCode.notUnique;
        }
        else {
            logger.error("其他错误");
            return ErrorCode.otherError;
        }
    }

    @Override
    public int bindStyleGroup(List <BindStyleGroupRequest> bindStyleGroupRequestList) {
        // 绑定款式组
        int updateStyleCount = 0; // 记录被更新style的数量
        for (BindStyleGroupRequest bindStyleGroupRequest : bindStyleGroupRequestList){
            int styleGroupId = bindStyleGroupRequest.getStyleGroupId();
            String styleGroupNumber = bindStyleGroupRequest.getStyleGroupNumber();
            String styleGroupName = bindStyleGroupRequest.getStyleGroupName();
            // 更新款式组状态
            if (updateStyleCount == 0){
                StyleGroupUpdateRequest styleGroupUpdateRequest = new StyleGroupUpdateRequest();
                styleGroupUpdateRequest.setId(styleGroupId);
                styleGroupUpdateRequest.setState(2);
                int updateStyleGroup = infoUpdateMapper.updateStyleGroup(styleGroupUpdateRequest);
                if (updateStyleGroup == 1){
                    logger.info("成功修改款式组状态");
                }
            }
            // 更新款式信息和状态
            String styleNumber = bindStyleGroupRequest.getStyleNumber();
            StyleUpdateRequest styleUpdateRequest = new StyleUpdateRequest();
            List <Style> styleResult = infoObtainMapper.getStyleByNumber(styleNumber);
            if (styleResult.size() == 1){
                int id = styleResult.get(0).getId();
                styleUpdateRequest.setId(id);
                styleUpdateRequest.setStyleGroupId(styleGroupId);
                styleUpdateRequest.setStyleGroupNumber(styleGroupNumber);
                styleUpdateRequest.setStyleGroupName(styleGroupName);
                styleUpdateRequest.setState(2);
                int updateStyle = infoUpdateMapper.updateStyle(styleUpdateRequest);
                if (updateStyle == 1){
                    logger.info("成功更新款式信息，当前款式id为"+ id);
                    updateStyleCount += 1;
                }
                else {
                    logger.error("更新款式信息失败，当前款式id为"+ id);
                }
            }
            else if (styleResult.size() == 0){
                logger.error("对应的款式数据不存在,更新失败，请检查数据库");
            }
            else if (styleResult.size() > 1){
                logger.error("数据不唯一,更新失败，请检查数据库");
            }
            else {
                logger.error("其他错误");
            }
        }
        return updateStyleCount;
    }

    @Override
    public int unbindStyleGroup(int id) {
        // 解绑款式组
        int updateStyleCount = 0; // 记录被更新style的数量
        // 更新款式组状态
        StyleGroupUpdateRequest styleGroupUpdateRequest = new StyleGroupUpdateRequest();
        styleGroupUpdateRequest.setId(id);
        styleGroupUpdateRequest.setState(1);
        int updateStyleGroup = infoUpdateMapper.updateStyleGroup(styleGroupUpdateRequest);
        if (updateStyleGroup == 1){
            List <Style> styleResult = infoObtainMapper.getStyleByStyleGroupId(id);
            if (styleResult.size() == 0){
                logger.error("该款式组没有对应的款式，请检查数据库");
            }
            else if (styleResult.size() > 0){
                for (Style style : styleResult){
                    StyleUpdateRequest styleUpdateRequest = new StyleUpdateRequest();
                    int styleId = style.getId();
                    styleUpdateRequest.setId(styleId);
                    styleUpdateRequest.setStyleGroupId(null);
                    styleUpdateRequest.setStyleGroupName("");
                    styleUpdateRequest.setStyleGroupNumber("");
                    styleUpdateRequest.setState(1);
                    int updateStyle = infoUpdateMapper.updateStyle(styleUpdateRequest);
                    if (updateStyle == 1){
                        logger.info("成功更新款式信息，当前款式id为"+ styleId);
                        updateStyleCount += 1;
                    }
                    else {
                        logger.error("更新款式信息失败，当前款式id为"+ styleId);
                    }
                }
                if (styleResult.size() == updateStyleCount){
                    logger.info("解绑成功，信息已完全更新");
                }
                else {
                    logger.warn("传入列表的长度为" + styleResult.size() + ",实际更新的长度为" + updateStyleCount + ",请检查数据库");
                }
            }
            else {
                logger.error("其他错误");
            }
        }
        else {
            logger.error("更新款式组信息失败，当前款式组id为"+ id);
            return ErrorCode.sqlError;
        }
        return updateStyleCount;
    }
}
