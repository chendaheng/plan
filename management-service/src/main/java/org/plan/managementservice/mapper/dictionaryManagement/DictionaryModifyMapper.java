package org.plan.managementservice.mapper.dictionaryManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.plan.managementfacade.model.dictionaryModel.CategoryReq;
import org.plan.managementfacade.model.dictionaryModel.PropertyReq;

@Mapper
public interface DictionaryModifyMapper {
    @Insert("INSERT INTO dictionarycategory(category, code) VALUES(#{categoryReq.category},#{categoryReq.code});")
    int addCategory(@Param("categoryReq") CategoryReq categoryReq);

    @Insert("INSERT INTO categoryproperty(name, code, categoryId) VALUES(#{propertyReq.name}, #{propertyReq.code}, #{propertyReq.categoryId});")
    int addProperty(@Param("propertyReq") PropertyReq propertyReq);

    @Delete("DELETE FROM dictionarycategory WHERE id=#{id};")
    int deleteCategoryById(@Param("id") int id);

    @Delete("DELETE FROM categoryproperty WHERE id=#{id};")
    int deletePropertyById(@Param("id") int id);
}
