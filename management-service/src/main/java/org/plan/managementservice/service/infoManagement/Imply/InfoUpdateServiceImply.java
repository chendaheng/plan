package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;
import org.plan.managementfacade.service.infoService.InfoUpdateService;
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
        if (rangeResult.size() == 1){
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
        if (rangeResult.size() > 1){
            logger.error("数据不唯一,更新失败，请检查数据库");
            return ErrorCode.notUnique;
        }
        else {
            logger.error("其他错误");
            return ErrorCode.otherUnique;
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
        if (styleGroupResult.size() == 1){
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
        if (styleGroupResult.size() > 1){
            logger.error("数据不唯一,更新失败，请检查数据库");
            return ErrorCode.notUnique;
        }
        else {
            logger.error("其他错误");
            return ErrorCode.otherUnique;
        }
    }

    @Override
    public int unbindStyleGroup(StyleGroupUpdateRequest styleGroupUpdateRequest) {
        // 解绑款式组
        styleGroupUpdateRequest.setState(1);
        return infoUpdateMapper.updateStyleGroup(styleGroupUpdateRequest);
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
        if (styleResult.size() > 1){
            logger.error("数据不唯一,更新失败，请检查数据库");
            return ErrorCode.notUnique;
        }
        else {
            logger.error("其他错误");
            return ErrorCode.otherUnique;
        }
    }
}
