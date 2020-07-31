package top.newfoodie.common.api;

import top.newfoodie.domain.base.BaseObject;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class CommonResponse<T> extends BaseObject {

    private Integer status;

    private String msg;

    private HttpResponse error;

    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public HttpResponse getError() {
        return error;
    }

    public void setError(HttpResponse error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
