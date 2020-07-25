package cn.dsx.rbac.app.controller;

import cn.dsx.rbac.app.bean.form.LoginForm;
import cn.dsx.rbac.app.service.UserService;
import cn.dsx.rbac.common.exception.ParamErrorException;
import cn.dsx.rbac.common.result.Result;
import cn.dsx.rbac.common.result.ResultCodeEnum;
import cn.dsx.rbac.common.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wf.jwtp.annotation.Ignore;
import org.wf.jwtp.provider.Token;

/**
 * @Classname: LoginController
 * @Author: Dsx
 * @Date: 2020/07/25/22:02
 */

@RestController
@RequestMapping("/app/login")
public class LoginController {


    @Autowired
    private UserService userService;


    @Ignore // 标记当前路径 不需要token
    @PostMapping("/")
    public Result login(@RequestBody @Validated LoginForm loginForm,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ParamErrorException(ResultCodeEnum.PARAM_ERROR);
        }
        Token token = userService.genderTokenByUser(loginForm);
        return ResultUtils.ok().data("token", token);
    }
}
