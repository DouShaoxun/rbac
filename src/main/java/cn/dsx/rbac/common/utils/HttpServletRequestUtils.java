package cn.dsx.rbac.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.wf.jwtp.provider.Token;
import org.wf.jwtp.util.SubjectUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Classname: HttpServletRequestUtils
 * @Author: Dsx
 * @Date: 2020/07/26/10:40
 */
public class HttpServletRequestUtils {

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }


    /**
     * 获取当前登录用户id
     * @return
     */
    public static String getCurrentUserId() {
        HttpServletRequest request = getRequest();
        Token token = SubjectUtil.getToken(request);
        if (token != null) {
            return token.getUserId();
        }
        return null;
    }


    /**
     * 获取当前用户登录token
     * @return
     */
    public static Token getCurrentToken() {
        HttpServletRequest request = getRequest();
        return SubjectUtil.getToken(request);
    }

}
