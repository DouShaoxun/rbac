package cn.dsx.rbac.common.utils;

import cn.dsx.rbac.common.result.Result;
import cn.dsx.rbac.common.result.ResultCodeEnum;

/**
 * @Classname: ResultUtils
 * @Author: Dsx
 * @Date: 2020/07/25/19:03
 */
public class ResultUtils {


    /**
     * 成功
     * @return
     */
    public static Result ok(){
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 失败
     * @return
     */
    public static Result error(){
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        result.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        result.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return result;
    }

    /**
     * 自定义
     * @param resultCodeEnum
     * @return
     */
    public static Result genResult(ResultCodeEnum resultCodeEnum){
        Result result = new Result();
        result.setSuccess(resultCodeEnum.getSuccess());
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }



}
