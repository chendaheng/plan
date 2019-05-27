package org.plan.managementservice.general;

/**
 * 用于统一管理本系统出现各种错误时返回给前端的错误信息
 * @author malous
 * @version 1.0
 */
public class ErrorCode {
/*------------------------------------基础信息/数据字典/权限管理错误码------------------------------------*/
    // 未知错误
    public static Integer unkownError = 0;
    // 传送的对象属性中存在null时返回该错误
    public static Integer fieldIsEmpty = -1;
    // 传送的参数与数据库中唯一值字段重复
    public static Integer paramDuplication = -2;
    // 传送的参数存在不一致的情况
    public static Integer dataInconsistency = -3;
    // 当前数据库记录不符合逻辑要求！
    public static Integer databaseError = -4;
    // 所要查询的数据在数据库中不存在
    public static Integer dataNotExist = -5;

/*-----------------------------------------------信息管理错误码-------------------------------------------*/

    // 新增的数据数据库中已经存在
    public static Integer dataExist = -1;
    // 传入信息的字段确实
    public static Integer dataNotMatch = -2;
    // 数据库操作错误
    public static Integer sqlError = -3;
    // 数据不唯一
    public static Integer notUnique = -4;
    // 数据库其他错误
    public static Integer otherError = -5;
    // 数据不存在
    public static Integer nullError = -6;
    // 数据状态错误
    public static Integer stateError = -7;

/*------------------------------------------计划管理错误码----------------------------------------------*/
    // 所需属性值缺失
    public static Integer requiredFieldMiss = -1;
    // 计划名称重复
    public static Integer planNameDuplication = -2;
    // 父计划未下发
    public static Integer parentNotDistributed = -3;
    // 系列根计划不存在
    public static Integer rangeRootPlanNotExist = -4;
    // 款式组根计划不存在
    public static Integer styleGroupRootPlanNotExist = -5;
    // 根计划已存在
    public static Integer rootPlanExist = -6;
    // 计划开始结束时间超额
    public static Integer dateOutOfRange = -7;
    // 计划款数超额
    public static Integer quantityExceed = -8;
    // 引用预测计划时预测计划不存在
    public static Integer predictPlanNotExist = -1;
    // 当前计划状态不允许执行此操作
    public static Integer illegalStateUpdate = -1;
    // 与已有计划冲突
    public static Integer conflictWithExistPlan = -2;

}
