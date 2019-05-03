package org.plan.managementfacade.model.enumModel;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumSerializer.class)
public enum PlanType implements IEnum{
    PREDICT(1, "预测计划"),
    RANGE(2, "系列计划"),
    STYLEGROUP(3, "款式组计划"),
    STYLE(4, "款式计划");

    private Integer index;
    private String name;

    private PlanType(Integer index, String name) {
        this.name = name;
        this.index = index;
    }

    public static PlanType getPlanType (int index) {
        for (PlanType planType : values()) {
            if (planType.index == index) {
                return planType;
            }
        }
        return null;
    }

    public static PlanType getPlanType (String name) {
        for (PlanType planType : values()) {
            if (planType.name.equals(name)) {
                return planType;
            }
        }
        return null;
    }

    public static String getName (Integer index) {
        for (PlanType planType : values()) {
            if (planType.index.equals(index)) {
                return planType.name;
            }
        }
        return null;
    }

    public String getName () {
        return name;
    }

    public static Integer getIndex (String name) {
        for (PlanType planType : values()) {
            if (planType.name.equals(name)) {
                return planType.index;
            }
        }
        return null;
    }

    public Integer getIndex () {
        return index;
    }
}
