package top.zw.o2o.enums;

public enum ShopStateEnum {
    CHECk(0,"审核中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),PASS(2,"通过认证")
    ,INNER_ERROR(-1001,"内部系统错误"),NULL_SJOPID(-1001,"内部系统错误"),
    NULL_SHOP(-1003,"shop信息为空");
    private int state;
    private String stateInfo;
    private ShopStateEnum(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    /**
     * 依据state返回enum
     */
    public static ShopStateEnum stateOf(int state){
        for(ShopStateEnum stateEnum : values()){
            if(stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }


}
