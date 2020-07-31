/*
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 */
package top.newfoodie.common.validator;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import top.newfoodie.common.enums.FoodieCodesEnum;
import top.newfoodie.common.exception.FoodieException;

import javax.validation.ConstraintViolation;
import java.security.KeyException;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 参数检查
 *
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class ParamsValidateHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParamsValidateHandler.class);

    public static void doBindingResultCheck(BindingResult bindingResult) throws KeyException {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            StringBuilder errorSB = new StringBuilder();
            for (FieldError fieldError : fieldErrorList) {
                errorSB.append(fieldError.getDefaultMessage());
                LOGGER.info("参数错误,具体信息:{}", errorSB.toString());
                throw new FoodieException(FoodieCodesEnum.PARAMS_ILLEGAL.getCode(), errorSB.toString());
            }
        }
    }

    public static <T> void doConstraintViolationCheck(Set<ConstraintViolation<T>> constraintViolationSet) throws FoodieException {
        if (CollectionUtils.isNotEmpty(constraintViolationSet)) {
            StringBuilder errorSB = new StringBuilder();
            for (ConstraintViolation constraintViolation : constraintViolationSet) {
                errorSB.append(constraintViolation.getMessage());
                LOGGER.info("参数错误,具体信息:{}", errorSB.toString());
                throw new FoodieException(FoodieCodesEnum.PARAMS_ILLEGAL.getCode(), errorSB.toString());
            }
        }
    }
}