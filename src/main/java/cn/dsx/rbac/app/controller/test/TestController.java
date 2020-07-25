package cn.dsx.rbac.app.controller.test;

import cn.dsx.rbac.common.result.Result;
import cn.dsx.rbac.common.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wf.jwtp.annotation.RequiresPermissions;

/**
 * @Classname: TestController
 * @Author: Dsx
 * @Date: 2020/07/26/0:22
 */
@RestController
@RequestMapping("/app/test")
public class TestController {

    @RequiresPermissions("system")
    @PostMapping("/")
    public Result test1(@RequestBody String name) {

        return ResultUtils.ok().data("name", name);

    }
}
