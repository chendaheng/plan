package org.plan.managementservice.service.infoManagement;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.infoManagement.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoUpdateServiceImply{

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoUpdateMapper infoUpdateMapper;

    @Autowired
    private InfoObtainMapper infoObtainMapper;

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

    public int updateStyle(StyleUpdateRequest styleUpdateRequest) {
        // 更新款式信息
        int id = styleUpdateRequest.getId();
        int rangeId = styleUpdateRequest.getRangeId();
        String number = styleUpdateRequest.getNumber();
        List <Style> styleResultById = infoObtainMapper.getStyleById(id);
        if (styleResultById.size() == 0){
            logger.info("当前id对于的系列信息不存在,请检查数据库");
            return ErrorCode.nullError;
        }
        if (styleResultById.size() == 1){
            Style style = styleResultById.get(0);
            int state = style.getState();
            if (state == 2){
                logger.warn("id为" + id + "的款式的状态为已绑定,无法修改信息");
                return ErrorCode.stateError;
            }
            else {
                int rangeIdDatabase = style.getRangeId();
                String numberDatabase = style.getNumber();
                if (number.equals(numberDatabase)){
                    if (rangeId == rangeIdDatabase){
                        logger.info("当前更新: 款号不变,系列Id不变");
                        return infoUpdateMapper.updateStyle(styleUpdateRequest);
                    }
                    else {
                        logger.info("当前更新: 款号不变,系列Id改变。注意: 当前更新会影响系列款数变化");
                        int updateStyleResult = infoUpdateMapper.updateStyle(styleUpdateRequest);
                        if (updateStyleResult == 1){
                            int addNewStyleQuantityResult = infoUpdateMapper.addStyleQuantityInRange(rangeId);
                            int minusOleStyleQuantityResult = infoUpdateMapper.minusStyleQuantityInRange(rangeIdDatabase);
                            if (addNewStyleQuantityResult == 1 && minusOleStyleQuantityResult == 1){
                                logger.info("id为" + rangeId + "的系列款数成功加1," + "id为" + rangeIdDatabase + "的系列款数成功减1");
                            }
                            else {
                                logger.warn("系列款数更新出错,请检查数据库");
                            }
                        }
                        return updateStyleResult;
                    }
                }
                else {
                    List <Style> styleResultByNumber = infoObtainMapper.getStyleByNumber(number);
                    if (styleResultByNumber.size() == 0){
                        if (rangeId == rangeIdDatabase){
                            logger.info("当前更新: 款号改变,系列Id不变");
                            return infoUpdateMapper.updateStyle(styleUpdateRequest);
                        }
                        else {
                            logger.info("当前更新: 款号改变,系列Id改变。注意: 当前更新会影响系列款数变化");
                            int updateStyleResult = infoUpdateMapper.updateStyle(styleUpdateRequest);
                            if (updateStyleResult == 1){
                                int addNewStyleQuantityResult = infoUpdateMapper.addStyleQuantityInRange(rangeId);
                                int minusOleStyleQuantityResult = infoUpdateMapper.minusStyleQuantityInRange(rangeIdDatabase);
                                if (addNewStyleQuantityResult == 1 && minusOleStyleQuantityResult == 1){
                                    logger.info("id为" + rangeId + "的系列款数成功加1," + "id为" + rangeIdDatabase + "的系列款数成功减1");
                                }
                                else {
                                    logger.warn("系列款数更新出错,请检查数据库");
                                }
                            }
                            return updateStyleResult;
                        }
                    }
                    else if (styleResultByNumber.size() == 1){
                        logger.error("数据库中已存在相同的款号,更新失败");
                        return ErrorCode.dataExist;
                    }
                    else {
                        logger.error("当前传入系列的number在数据库中对应多条记录,请检查数据库");
                        return ErrorCode.notUnique;
                    }
                }
            }
        }
        else if (styleResultById.size() > 1){
            logger.error("数据不唯一,更新失败，请检查数据库");
            return ErrorCode.notUnique;
        }
        else {
            logger.error("其他错误");
            return ErrorCode.otherError;
        }
    }

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
        if (updateStyleCount > 0){
            int styleGroupId = bindStyleGroupRequestList.get(0).getStyleGroupId();
            int addResult = infoUpdateMapper.addStyleGroupQuantity(styleGroupId,updateStyleCount);
            if (addResult == 1){
                logger.info("成功将id为: " + styleGroupId + "的款式组的quantity加" + updateStyleCount);
            }
            else {
                logger.error("将id为: " + styleGroupId + "的款式组的quantity更新失败,请检查数据库");
            }
        }
        return updateStyleCount;
    }

    public int unbindStyleGroup(int id) {
        // 解绑款式组
        List <StyleGroup> styleGroupResult = infoObtainMapper.getStyleGroupById(id);
        if (styleGroupResult.size() != 1){
            logger.error("id为" + id + "的款式组信息不存在,解绑失败,请检查数据库");
            return ErrorCode.nullError;
        }
        else {
            StyleGroup styleGroup = styleGroupResult.get(0);
            int state = styleGroup.getState();
            if (state == 1){
                logger.warn("id为" + id + "的款式组的状态为未绑定,无法进行解绑操作");
                return ErrorCode.stateError;
            }
            else {
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
                            int updateStyle = infoUpdateMapper.unbindStyleFromStyleGroup(style.getId());
                            if (updateStyle == 1){
                                logger.info("成功更新款式信息，当前款式id为"+ style.getId());
                                updateStyleCount += 1;
                            }
                            else {
                                logger.error("更新款式信息失败，当前款式id为"+ style.getId());
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
                if (updateStyleCount > 0){
                    int styleGroupId = styleGroupResult.get(0).getId();
                    int minusResult = infoUpdateMapper.minusStyleGroupQuantity(styleGroupId,updateStyleCount);
                    if (minusResult == 1){
                        logger.info("成功将id为: " + styleGroupId + "的款式组的quantity减" + updateStyleCount);
                    }
                    else {
                        logger.error("将id为: " + styleGroupId + "的款式组的quantity更新失败,请检查数据库");
                    }
                }
                return updateStyleCount;
            }
        }
    }

    public int completeRangeById (int id) {
        logger.info("将系列id为" + id + "的系列完成");
        return infoUpdateMapper.completeRangeById(id);
    }
}
