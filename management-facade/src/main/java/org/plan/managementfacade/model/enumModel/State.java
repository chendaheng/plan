package org.plan.managementfacade.model.enumModel;

public enum State {
    MADE( "已制定", 1),
    SUBMIT("已提交", 2),
    REFUSED("被驳回", 3),
    PASS("已审核", 4),
    DISTRIBUTED("已下发", 5),
    DELETED("已删除", 6);

    private String statues;
    private int index;
    private static final int ERROR = -1;

    // 构造方法
    private State(String statues, int index) {
        this.statues = statues;
        this.index = index;
    }

    public static String getStatues(int index) {
        for (State state : State.values()) {
            if (state.getIndex() == index) {
                return state.statues;
            }
        }
        return null;
    }

    public static int getIndex(String statues) {
        for (State state : State.values()) {
            if (state.getStatus().equals(statues)) {
                return state.index;
            }
        }
        return ERROR;
    }

    public String getStatus() {
        return statues;
    }

    public int getIndex() {
        return index;
    }
}
