package top.newfoodie.common.api;

import org.springframework.http.HttpStatus;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class ResponseFactory {
    public static <T> CommonResponse<T> buildCommonResponse() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus(HttpStatus.OK.value());
        commonResponse.setMsg("OK");
        return commonResponse;
    }

    public static <T> CommonResponse<T> buildCommonResponse(T data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus(HttpStatus.OK.value());
        commonResponse.setData(data);
        commonResponse.setMsg("OK");
        return commonResponse;
    }

}
