package top.newfoodie.domain.vo.req;

import top.newfoodie.domain.base.BaseRequest;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class CheckDBReq extends BaseRequest {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
