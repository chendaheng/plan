package org.plan.managementservice.mapper.baseInfoManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;

import java.util.List;

@Mapper
public interface BaseInfoObtainMapper {
    @Select("SELECT * FROM product;")
    List<Product> getAllProduct();

    @Select("SELECT * FROM product WHERE name LIKE CONCAT('%',#{name},'%');")
    List<Product> getProductByName(@Param("name") String name);

    @Select("SELECT * FROM product WHERE name=#{name} AND deptName=#{deptName};")
    List<Product> getProductByNameAndDept(@Param("name") String name, @Param("deptName") String deptName);

    @Select("SELECT COUNT(*) FROM product WHERE name=#{name} AND deptName=#{deptName};")
    int countProductByNameAndDept(@Param("name") String name, @Param("deptName") String deptName);

    @Select("SELECT * FROM customer;")
    List<Customer> getAllCustomer();

    @Select("SELECT * FROM customer WHERE name LIKE CONCAT('%',#{name},'%') OR abbr=#{name};")
    List<Customer> getCustomerByName(@Param("name") String name);

    @Select("SELECT distinct customer.id, customer.name FROM customer LEFT JOIN user_customer_brand " +
            "ON customer.id=user_customer_brand.customerId WHERE user_customer_brand.userId=#{userId};")
    List <CustomerName> getCustomerName(@Param("userId") int userId);

    @SelectProvider(type = BaseInfoObtainProvider.class, method = "getBrandByParams")
    List<BrandResp> getBrandByParams(String name, Integer customerId);

    @Select("SELECT * FROM brand WHERE name=#{name} AND customerId=#{customerId};")
    List<Brand> getBrandByNameAndCustomer(@Param("name") String name, @Param("customerId") int customerId);

    @SelectProvider(type = BaseInfoObtainProvider.class, method = "getBrandName")
    List<BrandName> getBrandName(@Param("customerId") Integer customerId, @Param("userId") Integer userId);

    @Select("SELECT COUNT(*) FROM brand WHERE name=#{name} AND customerId=#{customerId};")
    int countBrandByNameAndCustomer(@Param("name") String name, @Param("customerId") int customerId);

    @Select("SELECT * FROM clothinglevel;")
    List<ClothingLevel> getAllClothingLevel();

    @Select("SELECT * FROM clothinglevel WHERE name=#{name};")
    List<ClothingLevel> getClothingLevelByName(@Param("name") String name);

    @Select("SELECT id, name FROM clothinglevel;")
    List<ClothingLevelName> getClothingLevelName();

    @Select("SELECT id FROM brand WHERE customerId=#{customerId};")
    List<Integer> getBrandIdByCustomerId(@Param("customerId") int customerId);

    @Select("SELECT customerId FROM brand WHERE id=#{brandId};")
    Integer getCustomerIdByBrandId(@Param("brandId") int brandId);

    @Select("SELECT userId, userName FROM user_customer_brand WHERE brandId=#{brandId};")
    List<UserName> getUserNameByBrandId(@Param("brandId") Integer brandId);
}
