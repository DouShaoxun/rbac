package cn.dsx.rbac.common.aspect;

import cn.dsx.rbac.common.utils.HttpServletRequestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.wf.jwtp.provider.Token;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @Classname: LogAspect
 * @Author: Dsx
 * @Date: 2020/07/26/9:34
 */
@Aspect
@Order(9999) // 切面执行顺序
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * controller 层切点
     */
    //@Pointcut("execution(* cn.dsx.rbac.app.controller..*.*(..))")
    @Pointcut("@annotation(cn.dsx.rbac.common.annotation.LogAnnotation)")
    public void controllerPointcut() {
    }

    /**
     * controller 层出入参日志记录
     *
     * @param joinPoint 切点
     * @return
     */
    @Around(value = "controllerPointcut()")
    public Object controllerLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        /**
         * 获取 request 中包含的请求参数
         */
        String uuid = UUID.randomUUID().toString();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Token token = HttpServletRequestUtils.getCurrentToken();// 解析token
        String userId = null;
        if (token != null) {
            userId = token.getUserId();
        }
        /**
         * 获取切点请求参数(class,method)
         */
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        StringBuilder params = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Object[] objects = joinPoint.getArgs();
            for (Object arg : objects) {

                if (arg != null && !(arg instanceof ServletRequest) && !(arg instanceof ServletResponse)) {
                    params.append(mapper.writeValueAsString(arg));
                }
            }
        }
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            params.append(request.getQueryString());
        }
        /**
         * 入参日志
         */
        logger.info("[AOP-LOG-START]\n\tuserId:{}\n\trequestMark: {}\n\trequestIP: {}\n\tcontentType:{}\n\trequestUrl: {}\n\t" +
                        "requestMethod: {}\n\trequestParams: {}\n\ttargetClassAndMethod: {}#{}", userId, uuid, request.getRemoteAddr(),
                request.getHeader("Content-Type"), request.getRequestURL(), request.getMethod(), params.toString(),
                method.getDeclaringClass().getName(), method.getName());
        /**
         * 出参日志
         */
        Object result = joinPoint.proceed();
        logger.info("[AOP-LOG-END]\n\t{}", result);
        return result;
    }
}



