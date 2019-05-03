package org.plan.managementfacade.model.enumModel;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumSerializer.class)
public enum ProjectType implements IEnum{
    HEADER(1, "头样"),
    SALE(2, "销样"),
    CARGO(3, "大货");

    private Integer index;
    private String name;

    // 构造方法
    private ProjectType(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public static ProjectType getProjectType (int index) {
        for (ProjectType projectType : ProjectType.values()) {
            if (projectType.index == index) {
                return projectType;
            }
        }
        return null;
    }

    public static ProjectType getProjectType (String name) {
        for (ProjectType projectType : ProjectType.values()) {
            if (projectType.name.equals(name)) {
                return projectType;
            }
        }
        return null;
    }

    public static String getName (Integer index) {
        for (ProjectType projectType : ProjectType.values()) {
            if (projectType.index.equals(index)) {
                return projectType.name;
            }
        }
        return null;
    }

    public String getName () {
        return name;
    }

    public static Integer getIndex(String name) {
        for (ProjectType projectType : ProjectType.values()) {
            if (projectType.name.equals(name)) {
                return projectType.index;
            }
        }
        return null;
    }

    public Integer getIndex() {
        return index;
    }
}
