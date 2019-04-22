package org.plan.managementservice.mapper.dictionaryManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.plan.managementfacade.model.dictionaryModel.CategoryProperty;
import org.plan.managementfacade.model.dictionaryModel.DictionaryCategory;

@Mapper
public interface DictionaryUpdateMapper {
    @Update("UPDATE dictionaryCategory SET category=#{dictionaryCategory.category}, code=#{dictionaryCategory.code} WHERE id=#{dictionaryCategory.id};")
    int updateDictionaryCategory(@Param("dictionaryCategory") DictionaryCategory dictionaryCategory);

    @Update("UPDATE categoryProperty SET name=#{categoryProperty.name}, code=#{categoryProperty.code}, categoryId=#{categoryProperty.categoryId} WHERE id=#{categoryProperty.id};")
    int updateCategoryProperty(@Param("categoryProperty")CategoryProperty categoryProperty);
}
