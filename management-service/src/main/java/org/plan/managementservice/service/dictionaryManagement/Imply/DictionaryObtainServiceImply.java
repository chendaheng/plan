package org.plan.managementservice.service.dictionaryManagement.Imply;

import org.plan.managementfacade.model.dictionaryModel.CategoryProperty;
import org.plan.managementfacade.model.dictionaryModel.DictionaryCategory;
import org.plan.managementservice.mapper.dictionaryManagement.DictionaryObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictionaryObtainServiceImply {
    @Autowired
    DictionaryObtainMapper dictionaryObtainMapper;

    public List<DictionaryCategory> getAllDictionaryCategory () {
        return dictionaryObtainMapper.getAllDictionaryCategory();
    }

    public List<CategoryProperty> getCategoryPropertyByCategory (int categoryId) {
        return dictionaryObtainMapper.getCategoryPropertyByCategory(categoryId);
    }
}
