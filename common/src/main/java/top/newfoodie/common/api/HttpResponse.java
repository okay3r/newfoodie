package top.newfoodie.common.api;

import top.newfoodie.domain.base.BaseObject;

/**
 * 基础返回
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class HttpResponse extends BaseObject {

    private Integer code;

    private String message;

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
