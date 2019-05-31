package org.plan.managementservice.service.dictionaryManagement;

import org.plan.managementfacade.model.dictionaryModel.CategoryReq;
import org.plan.managementfacade.model.dictionaryModel.PropertyReq;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.dictionaryManagement.DictionaryModifyMapper;
import org.plan.managementservice.mapper.dictionaryManagement.DictionaryObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DictionaryModifyServiceImply {
    @Autowired
    private DictionaryModifyMapper dictionaryModifyMapper;
    @Autowired
    private DictionaryObtainMapper dictionaryObtainMapper;

    public int addCategory (CategoryReq categoryReq) {
        return dictionaryModifyMapper.addCategory(categoryReq);
    }

    public int addProperty (PropertyReq propertyReq) {
        //同类别下属性名不得重复
        int categoryId = propertyReq.getCategoryId();
        String name = propertyReq.getName();
        int count = dictionaryObtainMapper.getCategoryPropertyByCategoryAndName(categoryId, name).size();
        if (count == 0) {
            return dictionaryModifyMapper.addProperty(propertyReq);
        } else {
            return ErrorCode.paramDuplication;
        }
    }

    public int deleteCategoryById (int id) {
        return dictionaryModifyMapper.deleteCategoryById(id);
    }

    public int deletePropertyById (int id) {
        return dictionaryModifyMapper.deletePropertyById(id);
    }
}
