package org.plan.managementfacade.model.enumModel;

public enum PlanType {
    PREDICT( "预测计划", 1),
    RANGE("系列计划", 2),
    STYLEGROUP("款式组计划", 3),
    STYLE("款式计划", 4);

    private String type;
    private int index;
    private static final int ERROR = -1;

    // 构造方法
    private PlanType(String type, int index) {
        this.type = type;
        this.index = index;
    }

    public static String getType(int index) {
        for (PlanType planType : PlanType.values()) {
            if (planType.getIndex() == index) {
                return planType.type;
            }
        }
        return null;
    }

    public static int getIndex(String type) {
        for (PlanType planType : PlanType.values()) {
            if (planType.getType().equals(type)) {
                return planType.index;
            }
        }
        return ERROR;
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }
}
