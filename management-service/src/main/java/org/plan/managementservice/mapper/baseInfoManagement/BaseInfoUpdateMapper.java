package org.plan.managementservice.mapper.baseInfoManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Brand;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.ClothingLevel;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Customer;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Product;

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

    @Update("UPDATE clothingLevel SET name=#{clothingLevel.name}, description=#{clothingLevel.description} " +
            "WHERE id=#{clothingLevel.id};")
    int updateClothingLevel(@Param("clothingLevel")ClothingLevel clothingLevel);
}
