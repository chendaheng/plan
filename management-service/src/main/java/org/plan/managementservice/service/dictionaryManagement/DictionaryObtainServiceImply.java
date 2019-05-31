package org.plan.managementservice.service.dictionaryManagement;

import org.plan.managementfacade.model.dictionaryModel.CategoryProperty;
import org.plan.managementfacade.model.dictionaryModel.DictionaryCategory;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.dictionaryManagement.DictionaryObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictionaryObtainServiceImply {
    @Autowired
    private DictionaryObtainMapper dictionaryObtainMapper;

    public List<DictionaryCategory> getAllDictionaryCategory () {
        return dictionaryObtainMapper.getAllDictionaryCategory();
    }

    public int getDictionaryCategoryIdByName (String name) {
        List<Integer> categoryIdList = dictionaryObtainMapper.getDictionaryCategoryIdByName(name);
        int count = categoryIdList.size();
        if (count == 1) {
            // 正常，返回对应id
            return categoryIdList.get(0);
        } else if (count == 0){
            // 未查询到相应数据
            return ErrorCode.dataNotExist;
        } else {
            // count既不为1也不为0，说明数据库中name重复，请运维人员检查数据库
            return ErrorCode.databaseError;
        }
    }

    public List<CategoryProperty> getCategoryPropertyByCategory (int categoryId) {
        return dictionaryObtainMapper.getCategoryPropertyByCategory(categoryId);
    }
}
