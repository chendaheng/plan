package org.plan.managementservice.general;

/**
 * 用于统一管理本系统出现各种错误时返回给前端的错误信息
 * @author malous
 * @version 1.0
 */
public class ErrorCode {
    // 未知错误
    public static Integer unkownError = 0;
    // 传送的对象属性中存在null时返回该错误
    public static Integer errCodeClassIsEmpty = -1;
    // 传送的参数重复
    public static Integer paramDuplication = -2;
    // 传送的参数存在不一致的情况
    public static Integer dataInconsistency = -3;
    // 新增的数据数据库中已经存在
    public static Integer dataExist = -1;
    // 传入信息的字段不匹配
    public static Integer dataNotMatch = -1;
    // 数据库操作错误
    public static Integer sqlError = -1;
    // 数据不唯一
    public static Integer notUnique = -1;
    // 数据库其他错误
    public static Integer otherError = -1;
    // 数据不存在
    public static Integer nullError = -1;
}
