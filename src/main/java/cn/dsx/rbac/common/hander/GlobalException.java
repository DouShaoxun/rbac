package cn.dsx.rbac.common.hander;

import cn.dsx.rbac.common.exception.ParamErrorException;
import cn.dsx.rbac.common.exception.UserNotFoundException;
import cn.dsx.rbac.common.exception.UserPasswordMismatchException;
import cn.dsx.rbac.common.result.Result;
import cn.dsx.rbac.common.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wf.jwtp.exception.ErrorTokenException;
import org.wf.jwtp.exception.ExpiredTokenException;
import org.wf.jwtp.exception.UnauthorizedException;

/**
 * 全局异常拦截器
 *
 * @Classname: GlobalException
 * @Author: Dsx
 * @Date: 2020/07/25/15:38
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalException {

    /**
     * 未携带token,或者token不合法,或者redis中token已被删除
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ErrorTokenException.class)
    public Result exceptionHandler(ErrorTokenException e) {
        return ResultUtils.error().message(e.getMessage());
    }

    /**
     * 登录已过期
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ExpiredTokenException.class)
    public Result expiredTokenException(ExpiredTokenException e) {
        return ResultUtils.error().message(e.getMessage());
    }


    /**
     * 没有权限
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Result unauthorizedException(UnauthorizedException e) {
        return ResultUtils.error().message(e.getMessage());
    }


    @ExceptionHandler(UserNotFoundException.class)
    public Result userNotFoundException(UserNotFoundException e) {
        return ResultUtils.error().message(e.getMessage());
    }


    @ExceptionHandler(UserPasswordMismatchException.class)
    public Result userPasswordMismatchException(UserPasswordMismatchException e) {
        return ResultUtils.error().message(e.getMessage());
    }




    @ExceptionHandler(ParamErrorException.class)
    public Result paramErrorException(ParamErrorException e) {
        return ResultUtils.error().message(e.getMessage());
    }


}
