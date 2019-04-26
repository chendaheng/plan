package org.plan.managementservice.service.dictionaryManagement.Imply;

import org.plan.managementfacade.model.dictionaryModel.CategoryProperty;
import org.plan.managementfacade.model.dictionaryModel.DictionaryCategory;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.dictionaryManagement.DictionaryObtainMapper;
import org.plan.managementservice.mapper.dictionaryManagement.DictionaryUpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictionaryUpdateServiceImply {
    @Autowired
    private DictionaryUpdateMapper dictionaryUpdateMapper;
    @Autowired
    private DictionaryObtainMapper dictionaryObtainMapper;

    public int updateDictionaryCategory (DictionaryCategory dictionaryCategory) {
        return dictionaryUpdateMapper.updateDictionaryCategory(dictionaryCategory);
    }

    public int updateCategoryProperty (CategoryProperty categoryProperty) {
        //需确保更新后同类别下属性的name不重复
        int id = categoryProperty.getId();
        int categoryId = categoryProperty.getCategoryId();
        String name = categoryProperty.getName();
        List<CategoryProperty> categoryProperties = dictionaryObtainMapper.getCategoryPropertyByCategoryAndName(categoryId, name);
        int resutlt;
        switch (categoryProperties.size()) {
            //无重复值，直接更新
            case 0:
                resutlt = dictionaryUpdateMapper.updateCategoryProperty(categoryProperty);
                break;
            //有1个重复值，确定是否为更新的记录，是则更新，否则返回错误
            case 1:
                if (id == categoryProperties.get(0).getId()) {
                    resutlt = dictionaryUpdateMapper.updateCategoryProperty(categoryProperty);
                } else {
                    resutlt = ErrorCode.paramDuplication;
                }
                break;
            default:
                resutlt = ErrorCode.databaseError;
                break;
        }
        return resutlt;
    }
}
