package cn.dsx.rbac.common.exception;

import cn.dsx.rbac.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Classname: ParamErrorException
 * @Author: Dsx
 * @Date: 2020/07/25/23:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ParamErrorException extends RuntimeException {
    private Integer code;

    public ParamErrorException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ParamErrorException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "UserNotFoundException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
