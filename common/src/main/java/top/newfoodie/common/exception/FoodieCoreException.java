package top.newfoodie.common.exception;

import top.newfoodie.common.enums.FoodieCodesEnum;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class FoodieCoreException extends FoodieException {

    public FoodieCoreException(FoodieCodesEnum foodieCodesEnum) {
        super(foodieCodesEnum.getCode(), foodieCodesEnum.getMessage());
    }

    public FoodieCoreException(Integer code, String message) {
        super(code, message);
    }
}
