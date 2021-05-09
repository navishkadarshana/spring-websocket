package lk.ijse.spring.util;

public class StandradResponse {

    private int code;
    private String massage;
    private Object data;

    public StandradResponse() {
    }

    public StandradResponse(int code, String massage, Object data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



}
