package top.newfoodie.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.newfoodie.common.api.CommonResponse;
import top.newfoodie.domain.base.BaseRequest;
import top.newfoodie.common.api.HttpResponse;
import top.newfoodie.common.enums.FoodieCodesEnum;
import top.newfoodie.common.exception.FoodieException;
import top.newfoodie.common.utils.Json4jacksonUtil;
import top.newfoodie.common.validator.ParamsValidateHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
@Aspect
@Component
public class ControllerAdvice implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

    @Override
    public int getOrder() {
        return 1;
    }

    @Pointcut("execution(* top.newfoodie.*.controller..*.*(..))")
    private void anyMethod() {

    }

    @Around("anyMethod()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录请求内容
        Signature signature = joinPoint.getSignature();

        MethodSignature methodSignature = (MethodSignature) signature;
        //支持基础数据类型
        Class<?> clz = ClassUtils.forName(methodSignature.getReturnType().getCanonicalName(), null);
        String targetMethodName = signature.getName();
        Object ret = null;
        //特定类型
        StringBuilder argsDump = new StringBuilder();
        BindingResult bindingResult = null;
        try {
            Object[] args = joinPoint.getArgs();
            if (args != null) {
                for (Object arg : args) {
                    if (arg instanceof BindingResult) {
                        bindingResult = (BindingResult) arg;
                    }
                    if (arg instanceof BaseRequest) {
                        argsDump.append(arg == null ? "null" : Json4jacksonUtil.toJson(arg)).append(",");
                    }
                }
            }

            LOGGER.info("==> Begin Method:{}, args:{}", targetMethodName, argsDump.toString());

            //参数校验
            if (bindingResult != null) {
                ParamsValidateHandler.doBindingResultCheck(bindingResult);
            }
            ret = joinPoint.proceed();
        } catch (FoodieException e) {
            LOGGER.error("occur exception, {}, args={}", e.getMessage(), argsDump, e);
            //返回类型是CommonResponse才去转换
            if (CommonResponse.class.isAssignableFrom(clz)) {
                ret = clz.newInstance();
            } else {
                throw e;
            }
            judgeResponseAndSetIfNeed(ret, e);
        } catch (Exception e) {
            LOGGER.error("occur exception, {}, args={}", e.getMessage(), argsDump, e);
            //返回类型是CommonResponse才去转换
            if (CommonResponse.class.isAssignableFrom(clz)) {
                ret = clz.newInstance();
            } else {
                throw e;
            }
            judgeResponseAndSetIfNeed(ret, e);
        } finally {
            long end = System.currentTimeMillis();
            Calendar c = Calendar.getInstance();
            long expendTime = end - start;
            c.setTimeInMillis(expendTime);
            StringBuilder returnValue = new StringBuilder();
            returnValue.append("==> End method :").append(targetMethodName).append(",return value:");
            if (ret != null) {
                returnValue.append("[").append(Json4jacksonUtil.toJson(ret)).append("]");
            } else {
                returnValue.append("[null]");
            }
            returnValue.append(". consuming time: ").append(expendTime).append("ms, formart ")
                    .append(c.get(Calendar.MINUTE)).append(":").append(c.get(Calendar.SECOND)).append(":")
                    .append(c.get(Calendar.MILLISECOND));
            LOGGER.info(returnValue.toString());
        }
        return ret;
    }

    // 判断是否需要异常转换称Response
    private void judgeResponseAndSetIfNeed(Object ret, Exception exception) {
        if (exception == null) {
            return;
        }
        if (ret instanceof CommonResponse) {
            CommonResponse response = (CommonResponse) ret;
            if (null != exception && exception instanceof FoodieException) {
                FoodieException ve = (FoodieException) exception;
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                HttpResponse error = new HttpResponse();
                error.setCode(ve.getCode());
                error.setMessage(ve.getMessage());
                response.setError(error);
                response.setMsg(error.getMessage());
                return;
            }
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            HttpResponse error = new HttpResponse();
            error.setCode(FoodieCodesEnum.INTERNAL_ERROR.getCode());
            error.setMessage(FoodieCodesEnum.INTERNAL_ERROR.getMessage());
            response.setError(error);
            response.setMsg(error.getMessage());
        }
    }
}
