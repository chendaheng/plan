package org.plan.managementfacade.model.enumModel;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumSerializer.class)
public enum PlanState implements IEnum{
    MADE(1, "已制定"),
    SUBMIT(2, "已提交"),
    REFUSED(3, "被驳回"),
    PASS(4, "已审核"),
    DISTRIBUTED(5, "已下发"),
    DELETED(6, "已删除");

    private Integer index;
    private String name;

    private PlanState (Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public static PlanState getPlanState(int index) {
        for (PlanState planState : values()) {
            if (planState.index == index) {
                return planState;
            }
        }
        return null;
    }

    public static PlanState getPlanState (String name) {
        for (PlanState planState : values()) {
            if (planState.name.equals(name)) {
                return planState;
            }
        }
        return null;
    }

    public static String getName (Integer index) {
        for (PlanState planState : values()) {
            if (planState.index.equals(index)) {
                return planState.name;
            }
        }
        return null;
    }

    public String getName () {
        return name;
    }

    public static Integer getIndex (String name) {
        for (PlanState planState : values()) {
            if (planState.name.equals(name)) {
                return planState.index;
            }
        }
        return null;
    }

    public Integer getIndex () {
        return index;
    }
}
