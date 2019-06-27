package org.plan.managementservice.mapper.baseInfoManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;

@Mapper
public interface BaseInfoUpdateMapper {
    @Update("UPDATE product SET number=#{product.number}, name=#{product.name}, description=#{product.description}, " +
            "deptName=#{product.deptName} WHERE id=#{product.id};")
    int updateProduct(@Param("product") Product product);

    @Update("UPDATE customer SET name=#{customer.name}, abbr=#{customer.abbr}, description=#{customer.description}, " +
            "groupName=#{customer.groupName} WHERE id=#{customer.id};")
    int updateCustomer(@Param("customer") Customer customer);

    @Update("UPDATE brand SET name=#{brand.name}, abbr=#{brand.abbr}, description=#{brand.description}, " +
            "customerId=#{brand.customerId} WHERE id=#{brand.id};")
    int updateBrand(@Param("brand") Brand brand);

    @Update("UPDATE clothinglevel SET name=#{clothingLevel.name}, description=#{clothingLevel.description} " +
            "WHERE id=#{clothingLevel.id};")
    int updateClothingLevel(@Param("clothingLevel") ClothingLevel clothingLevel);

    // 更新单号规则
    @Update("UPDATE serialno_regular SET numberPrefix=#{numberPrefix}, numberLength=#{numberLength}, " +
            "lastNumberLength=#{lastNumberLength} WHERE id=#{id};")
    int updateSerialNoRegular(@Param("id")int id, @Param("numberPrefix")String numberPrefix, @Param("numberLength")int numberLength, @Param("lastNumberLength")int lastNumberLength);

//    // 更新单号规则里的afterChangeGenerate属性
//    @Update("UPDATE serialno_regular SET afterChangeGenerate = 1 WHERE id=#{id};")
//    int updateSerialNoRegularFlag(@Param("id")int id);
}
