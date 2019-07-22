package top.zw.o2o.dto;

public class Result <T> {
    //是否成功
    private boolean success;
    //成功返回的数据
    private T data;
    private String errMsg;
    private int errorCode;
    public Result(){

    }

    public Result(boolean success,T data){
        this.success = success;
        this.data = data;
    }

    public Result(boolean success,int errorCode,String errMsg){
        this.success = success;
        this.errMsg = errMsg;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
