package top.newfoodie.common.api;

import top.newfoodie.domain.base.BaseObject;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class CommonResponse<T> extends BaseObject {

    private Boolean success;

    private HttpResponse error;

    private T data;

    private Paging paging;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
