package cn.dsx.rbac.app.service;

import cn.dsx.rbac.app.bean.entity.User;
import cn.dsx.rbac.app.bean.form.LoginForm;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wf.jwtp.provider.Token;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dousx
 * @since 2020-07-25
 */
public interface UserService extends IService<User> {

    Token  genderTokenByUser(LoginForm loginForm);
}
