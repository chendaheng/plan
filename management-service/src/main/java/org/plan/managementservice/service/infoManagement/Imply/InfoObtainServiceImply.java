package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.enumModel.*;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.plan.managementfacade.service.infoService.*;
import org.plan.managementservice.mapper.infoManagement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoObtainServiceImply implements InfoObtainService {

    @Autowired
    private InfoObtainMapper infoObtainMapper;

    @Override
    public List <RangeName> getRangeName(Integer brandId) {
        // 获取系列名称
        if (brandId != null){
            return infoObtainMapper.getRangeName(brandId);
        }
        else {
            return infoObtainMapper.getAllRangeName();
        }
    }

    @Override
    public List <RangeResponse> getRangeResponse(RangeSearchRequest rangeSearchRequest) {
        // 获取系列response信息
        List <RangeResponse> rangeResponseResult = infoObtainMapper.getRangeResponseByCondition(rangeSearchRequest);
        for (RangeResponse rangeResponse: rangeResponseResult){
            int addingMode = rangeResponse.getAddingMode();
            String addingModeStr = AddingMode.getType(addingMode);
            rangeResponse.setAddingModeStr(addingModeStr);
            int state = rangeResponse.getState();
            String stateStr = InfoState.getName(state);
            rangeResponse.setStateStr(stateStr);

        }
        return rangeResponseResult;
    }

    @Override
    public List <StyleGroupName> getStyleGroupName(Integer rangeId) {
        // 获取款式组名称
        if (rangeId != null){
            return infoObtainMapper.getStyleGroupNameByRangeId(rangeId);
        }
        else {
            return infoObtainMapper.getAllStyleGroupName();
        }
    }

    @Override
    public List<StyleGroupResponse> getStyleGroupResponse(StyleGroupSearchRequest styleGroupSearchRequest) {
        // 获取款式组response信息
        List <StyleGroupResponse> styleGroupResponsesResult = infoObtainMapper.getStyleGroupResponseByCondition(styleGroupSearchRequest);
        for (StyleGroupResponse styleGroupResponse : styleGroupResponsesResult){
            int state = styleGroupResponse.getState();
            String stateStr = InfoState.getName(state);
            styleGroupResponse.setStateStr(stateStr);
        }
        return styleGroupResponsesResult;
    }

    @Override
    public List <StyleNumber> getStyleNumber(Integer rangeId) {
        // 根据rangeId获取款号
        if (rangeId != null){
            return infoObtainMapper.getStyleNumberByRangeId(rangeId);
        }
        else {
            return infoObtainMapper.getAllStyleNumber();
        }
    }

    @Override
    public List <StyleResponse> getStyleResponse(StyleSearchRequest styleSearchRequest) {
        // 获取款式response信息
        List <StyleResponse> styleResponseResult = infoObtainMapper.getStyleResponseByCondition(styleSearchRequest);
        for (StyleResponse styleResponse : styleResponseResult){
            int addingMode = styleResponse.getAddingMode();
            String addingModeStr = AddingMode.getType(addingMode);
            styleResponse.setAddingModeStr(addingModeStr);
        }
        return styleResponseResult;
    }
}
