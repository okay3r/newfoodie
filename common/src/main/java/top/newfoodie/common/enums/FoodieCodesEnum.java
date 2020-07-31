package top.newfoodie.common.enums;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public enum FoodieCodesEnum {
    SUCCESS(100000, "请求成功"),
    INTERNAL_ERROR(100001, "内部异常"),
    PARAMS_ILLEGAL(100002, "参数错误"),
    ;

    private Integer code;

    private String message;

    FoodieCodesEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
