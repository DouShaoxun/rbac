package cn.dsx.rbac.common.exception;

import cn.dsx.rbac.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Classname: UserNotFoundException
 * @Author: Dsx
 * @Date: 2020/07/25/22:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserNotFoundException extends RuntimeException {
    private Integer code;

    public UserNotFoundException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public UserNotFoundException(ResultCodeEnum resultCodeEnum) {
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
