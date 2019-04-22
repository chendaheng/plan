package org.plan.managementservice.mapper.dictionaryManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.plan.managementfacade.model.dictionaryModel.CategoryReq;
import org.plan.managementfacade.model.dictionaryModel.PropertyReq;

@Mapper
public interface DictionaryModifyMapper {
    @Insert("INSERT INTO dictionaryCategory(category, code) VALUES(#{categoryReq.category},#{categoryReq.code});")
    int addCategory(@Param("categoryReq") CategoryReq categoryReq);

    @Insert("INSERT INTO categoryProperty(name, code, categoryId) VALUES(#{propertyReq.name}, #{propertyReq.code}, #{propertyReq.categoryId});")
    int addProperty(@Param("propertyReq") PropertyReq propertyReq);

    @Delete("DELETE FROM dictionaryCategory WHERE id=#{id};")
    int deleteCategoryById(@Param("id") int id);

    @Delete("DELETE FROM categoryProperty WHERE id=#{id};")
    int deletePropertyById(@Param("id") int id);
}
