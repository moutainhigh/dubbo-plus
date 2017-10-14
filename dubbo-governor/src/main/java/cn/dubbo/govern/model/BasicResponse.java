package cn.dubbo.govern.model;

public class BasicResponse {

    public static final short SUCCESS=0,FAILED=1;

    private short result=SUCCESS;
    private String memo;

    public short getResult() {
        return result;
    }

    public void setResult(short result) {
        this.result = result;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
