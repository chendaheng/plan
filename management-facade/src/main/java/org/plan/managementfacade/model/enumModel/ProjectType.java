package org.plan.managementfacade.model.enumModel;

public enum ProjectType {
    HEADER( "头样", 1),
    SALE("销样", 2),
    CARGO("大货", 3);

    private String type;
    private int index;
    private static final int ERROR = -1;

    // 构造方法
    private ProjectType(String type, int index) {
        this.type = type;
        this.index = index;
    }

    public static String getType(int index) {
        for (ProjectType projectType : ProjectType.values()) {
            if (projectType.getIndex() == index) {
                return projectType.type;
            }
        }
        return null;
    }

    public static int getIndex(String type) {
        for (ProjectType projectType : ProjectType.values()) {
            if (projectType.getType().equals(type)) {
                return projectType.index;
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
