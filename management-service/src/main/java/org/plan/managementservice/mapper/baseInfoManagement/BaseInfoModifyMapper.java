package org.plan.managementservice.mapper.baseInfoManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.plan.managementfacade.model.baseInfoModel.requestModel.*;

@Mapper
public interface BaseInfoModifyMapper {
    @Insert("INSERT INTO product(number, name, description, deptName) VALUES(#{productReq.number}, #{productReq.name}, #{productReq.description}, #{productReq.deptName});")
    int addProduct (@Param("productReq") ProductReq productReq);

    @Insert("INSERT INTO customer(name, abbr, description, groupName) VALUES(#{customerReq.name}, #{customerReq.abbr}, #{customerReq.description}, #{customerReq.groupName});")
    int addCustomer (@Param("customerReq") CustomerReq customerReq);

    @Insert("INSERT INTO brand(name, abbr, description, customerId) VALUES(#{brandReq.name}, #{brandReq.abbr}, #{brandReq.description}, #{brandReq.customerId});")
    int addBrand (@Param("brandReq") BrandReq brandReq);

    @Insert("INSERT INTO clothinglevel(name, description) VALUES(#{clothingLevelReq.name}, #{clothingLevelReq.description});")
    int addClothingLevel (@Param("clothingLevelReq") ClothingLevelReq clothingLevelReq);

    @Delete("DELETE FROM product WHERE id=#{id};")
    int deleteProduct (@Param("id") int id);

    @Delete("DELETE FROM customer WHERE id=#{id};")
    int deleteCustomer (@Param("id") int id);

    @Delete("DELETE FROM brand WHERE id=#{id};")
    int deleteBrand (@Param("id") int id);

    @Delete("DELETE FROM clothinglevel WHERE id=#{id};")
    int deleteClothingLevel (@Param("id") int id);

    // 添加消息
    @Insert("INSERT INTO message(senderId, senderName, receiverId, receiverName, messageDetails) VALUES(#{messageAddReq.senderId}, #{messageAddReq.senderName}, #{messageAddReq.receiverId}, #{messageAddReq.receiverName} ,#{messageAddReq.messageDetails})")
    int addMessage(@Param("messageAddReq") MessageAddReq messageAddReq);
}
