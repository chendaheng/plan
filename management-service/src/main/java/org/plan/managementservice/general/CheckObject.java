package org.plan.managementservice.general;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 存放一些本系统中的通用工具类函数
 * @author malous
 * @version 1.0
 */
public class CheckObject {
    /**
     * 判断一个非空对象实例是否含有值为Null的属性
     * @param object
     * @return boolean
     * @author malous on 2019-04-22
     */
    public static boolean isContainsEmpty (@NotNull Object object) {
        boolean result = false;
            Class clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.get(object) == null) {
                        result = true;
                        break;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return result;
    }

    /**
     * 获取一个对象实例中属性值不为null的属性名称，封装于list中返回
     * @param object
     * @return List<String>
     * @author malous on 2019-4-26
     */
    public static List<String> getNotNullFields (@NotNull Object object) {
        List<String> fieldList = new ArrayList<>();
        fieldList.clear();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(object) != null) {
                    fieldList.add(field.getName());
                }
            }
            return fieldList;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
