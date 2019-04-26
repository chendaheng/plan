package org.plan.managementfacade.model.enumModel;

public enum AddingMode {
    MANUAL("手动",1),
    EXCEL("导入",2);

    private String type;
    private int index;

    private AddingMode(String type, int index){
        this.type = type;
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public static String getType(int index) {
        for (AddingMode addingMode : AddingMode.values()){
            if (addingMode.getIndex() == index){
                return addingMode.type;
            }
        }
        return null;
    }

    public static int getIndex(String type){
        for (AddingMode addingMode : AddingMode.values()){
            if (addingMode.getType().equals(type)){
                return addingMode.index;
            }
        }
        return 0;
    }
}
