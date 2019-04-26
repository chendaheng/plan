package org.plan.managementservice.mapper.baseInfoManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;

import java.util.List;

@Mapper
public interface BaseInfoObtainMapper {
    @Select("SELECT * FROM product;")
    List<Product> getAllProduct();

    @Select("SELECT * FROM product WHERE name=#{name};")
    List<Product> getProductByName(@Param("name") String name);

    @Select("SELECT * FROM product WHERE name=#{name} AND deptName=#{deptName};")
    List<Product> getProductByNameAndDept(@Param("name") String name, @Param("deptName") String deptName);

    @Select("SELECT count(*) FROM product WHERE name=#{name} AND deptName={deptName};")
    int countProductByNameAndDept(@Param("name") String name, @Param("deptName") String deptName);

    @Select("SELECT * FROM customer;")
    List<Customer> getAllCustomer();

    @Select("SELECT * FROM customer WHERE name=#{name};")
    List<Customer> getCustomerByName(@Param("name") String name);

    @Select("SELECT distinct customer.id, customer.name FROM customer LEFT JOIN user_customer_brand " +
            "ON customer.id=user_customer_brand.userId WHERE user_customer_brand.userId=#{userId};")
    List<CustomerName> getCustomerName(@Param("userId") int userId);

    @Select("SELECT * FROM brand;")
    List<Brand> getAllBrand();

    @Select("SELECT * FROM brand WHERE name=#{name};")
    List<Brand> getBrandByName(@Param("name") String name);

    @Select("SELECT * FROM brand WHERE name=#{name} AND customerId=#{customerId};")
    List<Brand> getBrandByNameAndCustomer(@Param("name") String name, @Param("customerId") int customerId);

    @Select("SELECT id, name FROM brand WHERE customerId=#{customerId};")
    List<BrandName> getBrandName(@Param("customerId") int customerId);

    @Select("SELECT count(*) FROM brand WHERE name=#{name} AND customerId=#{customerId};")
    int countBrandByNameAndCustomer(@Param("name") String name, @Param("customerId") int customerId);

    @Select("SELECT * FROM clothingLevel;")
    List<ClothingLevel> getAllClothingLevel();

    @Select("SELECT * FROM clothingLevel WHERE name=#{name};")
    List<ClothingLevel> getClothingLevelByName(@Param("name") String name);

    @Select("SELECT id, name FROM clothingLevel;")
    List<ClothingLevelName> getClothingLevelName();

    @Select("SELECT id FROM brand WHERE customerId=#{customerId};")
    List<Integer> getBrandIdByCustomerId(@Param("customerId") int customerId);

    @Select("SELECT customerId FROM brand WHERE id=#{brandId};")
    int getCustomerIdByBrandId(@Param("brandID") int brandId);
}
