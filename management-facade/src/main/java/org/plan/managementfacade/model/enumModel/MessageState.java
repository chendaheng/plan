package org.plan.managementfacade.model.enumModel;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumSerializer.class)
public enum MessageState implements IEnum{

    UNREAD(1, "未读"),
    READ(2, "已读");

    private Integer index;
    private String name;

    private MessageState (Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName (Integer index) {
        for (MessageState messageState : values()) {
            if (messageState.index.equals(index)) {
                return messageState.name;
            }
        }
        return null;
    }

    public static Integer getIndex (String name) {
        for (MessageState messageState : values()) {
            if (messageState.name.equals(name)) {
                return messageState.index;
            }
        }
        return null;
    }
}
