package cn.dsx.rbac.common.utils;

import cn.dsx.rbac.app.bean.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.wf.jwtp.provider.Token;

/**
 * @Classname: UserUtils
 * @Author: Dsx
 * @Date: 2020/07/25/23:50
 */
@Component
public class UserUtils {
    public static String status = "1"; //用户禁用状态

    @Autowired
    private RedisTemplate redisTemplate;

    public User getCurrentUser() {
        Token token = HttpServletRequestUtils.getCurrentToken();
        User currentUser = null;
        if (token != null) {
            currentUser = (User) redisTemplate.opsForValue().get(token.getUserId());
        }
        return currentUser;
    }
}
