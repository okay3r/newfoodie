package top.newfoodie.common.api;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class ResponseFactory {
    public static <T> CommonResponse<T> buildCommonResponse() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(true);
        return commonResponse;
    }

    public static <T> CommonResponse<T> buildCommonResponse(T data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setData(data);
        return commonResponse;
    }

    public static <T> CommonResponse<T> buildCommonResponse(T data, Paging paging) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setData(data);
        commonResponse.setPaging(paging);
        return commonResponse;
    }
}
