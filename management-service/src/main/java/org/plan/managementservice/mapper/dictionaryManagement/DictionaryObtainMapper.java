package org.plan.managementservice.mapper.dictionaryManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.plan.managementfacade.model.dictionaryModel.CategoryProperty;
import org.plan.managementfacade.model.dictionaryModel.DictionaryCategory;

import java.util.List;

@Mapper
public interface DictionaryObtainMapper {
    @Select("SELECT * FROM dictionarycategory;")
    List<DictionaryCategory> getAllDictionaryCategory();

    @Select("SELECT id FROM dictionarycategory WHERE category=#{name};")
    List<Integer> getDictionaryCategoryIdByName(@Param("name") String name);

    @Select("SELECT * FROM categoryproperty WHERE categoryId=#{categoryId};")
    List<CategoryProperty> getCategoryPropertyByCategory(@Param("categoryId") int categoryId);

    @Select("SELECT * FROM categoryproperty WHERE categoryId=#{categoryId} AND name=#{name};")
    List<CategoryProperty> getCategoryPropertyByCategoryAndName(@Param("categoryId") int categoryId, @Param("name") String name);
}
