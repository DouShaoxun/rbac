package cn.dsx.rbac.app.controller.test;

import cn.dsx.rbac.app.bean.entity.User;
import cn.dsx.rbac.app.bean.query.UserQuery;
import cn.dsx.rbac.common.annotation.LogAnnotation;
import cn.dsx.rbac.common.result.Result;
import cn.dsx.rbac.common.utils.ResultUtils;
import cn.dsx.rbac.common.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wf.jwtp.annotation.Ignore;
import org.wf.jwtp.annotation.RequiresPermissions;
import org.wf.jwtp.annotation.RequiresRoles;

/**
 * @Classname: TestController
 * @Author: Dsx
 * @Date: 2020/07/26/0:22
 */
@RestController
@RequestMapping("/app/test")
@RequiresRoles("admin")
public class TestController {

    @Autowired
    UserUtils userUtils;

    @LogAnnotation
    @RequiresPermissions("system")
    @PostMapping("/1")
    public Result test1(@RequestBody UserQuery userQuery) {
        User currentUser = userUtils.getCurrentUser();
        return ResultUtils.ok().data("name", userQuery.toString());
    }


    @RequiresPermissions("p2")
    @PostMapping("/2")
    public Result test2(@RequestBody UserQuery userQuery) {
        return ResultUtils.ok().data("name", userQuery);
    }

    @LogAnnotation
    @Ignore // 忽略 权限认证
    @PostMapping("/3")
    public Result test3(@RequestBody UserQuery userQuery) {
        return ResultUtils.ok().data("name", userQuery);
    }

}
