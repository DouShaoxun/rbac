package cn.dsx.rbac.common.exception;

import cn.dsx.rbac.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Classname: UserPasswordMismatchException
 * @Author: Dsx
 * @Date: 2020/07/25/22:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPasswordMismatchException extends RuntimeException {
    private Integer code;

    public UserPasswordMismatchException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public UserPasswordMismatchException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "UserPasswordMismatchException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
