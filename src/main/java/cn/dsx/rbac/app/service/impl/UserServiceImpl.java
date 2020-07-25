package cn.dsx.rbac.app.service.impl;

import cn.dsx.rbac.app.bean.entity.User;
import cn.dsx.rbac.app.bean.form.LoginForm;
import cn.dsx.rbac.app.mapper.RoleMenuMapper;
import cn.dsx.rbac.app.mapper.UserMapper;
import cn.dsx.rbac.app.mapper.UserRoleMapper;
import cn.dsx.rbac.app.service.UserService;
import cn.dsx.rbac.common.exception.UserNotFoundException;
import cn.dsx.rbac.common.exception.UserPasswordMismatchException;
import cn.dsx.rbac.common.result.ResultCodeEnum;
import cn.dsx.rbac.common.utils.MD5Utils;
import cn.dsx.rbac.common.utils.UserUtils;
import cn.hutool.crypto.digest.Digester;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wf.jwtp.provider.Token;
import org.wf.jwtp.provider.TokenStore;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dousx
 * @since 2020-07-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private TokenStore tokenStore;

    @Autowired
    private Digester md5;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Token genderTokenByUser(LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        QueryWrapper<User> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("USERNAME", username);
        User user = userMapper.selectOne(QueryWrapper);
        if (user == null) {
            throw new UserNotFoundException(ResultCodeEnum.LOGIN_MOBILE_ERROR);
        }
        // 获取md5加密之后的密文
        String password2MD5 = md5.digestHex(MD5Utils.md5Key + username + password);
        if (!password2MD5.equals(user.getPassword())) {
            throw new UserPasswordMismatchException(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        if (!UserUtils.status.equals(user.getStatus())) {
            throw new UserPasswordMismatchException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }
        Long userId = user.getUserId();
        // 根据id获取 roles
        List<String> rolesName = userRoleMapper.selectByUserId(userId);
        String[] roles = rolesName.toArray(new String[rolesName.size()]);
        // 根据id获取 permissions(菜单或者按钮)
        List<String> permissionsName = roleMenuMapper.selectByUserId(userId);
        String[] permissions = permissionsName.toArray(new String[permissionsName.size()]);

        // 签发token  token默认时间 3600 秒
        Token token = tokenStore.createNewToken(username, permissions, roles);
        return token;
    }
}
