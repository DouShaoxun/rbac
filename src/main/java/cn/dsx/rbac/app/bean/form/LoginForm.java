package cn.dsx.rbac.app.bean.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Classname: LoginForm
 * @Author: Dsx
 * @Date: 2020/07/25/23:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {


    @ApiModelProperty(value = "用户名")
    @NotBlank
    String username;

    @ApiModelProperty(value = "密码")
    @NotBlank
    String password;

    @ApiModelProperty(value = "验证码")
    @NotBlank
    String verificationCode;

}
