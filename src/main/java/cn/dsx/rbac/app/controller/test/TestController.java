package cn.dsx.rbac.app.controller.test;

import cn.dsx.rbac.common.result.Result;
import cn.dsx.rbac.common.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wf.jwtp.annotation.Ignore;
import org.wf.jwtp.annotation.RequiresPermissions;
import org.wf.jwtp.annotation.RequiresRoles;
import org.wf.jwtp.provider.Token;
import org.wf.jwtp.util.SubjectUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname: TestController
 * @Author: Dsx
 * @Date: 2020/07/26/0:22
 */
@RestController
@RequestMapping("/app/test")
@RequiresRoles("admin")
public class TestController {


    @RequiresPermissions("system")
    @PostMapping("/1")
    public Result test1(String name,HttpServletRequest request) {
        Token token = SubjectUtil.getToken(request);
        return ResultUtils.ok().data("name", name);

    }



    @Ignore // 忽略 权限认证
    @PostMapping("/2")
    public Result test2(String name, HttpServletRequest request)  {
        Token token = SubjectUtil.getToken(request);// @Ignore token 为null
        System.out.println(name);
        return ResultUtils.ok().data("name", name);
    }


}
