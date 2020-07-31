package top.newfoodie.common.exception;

/**
 * 异常统一处理
 */
public class FoodieException extends RuntimeException {

    private Integer code;

    private String message;

    public FoodieException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
