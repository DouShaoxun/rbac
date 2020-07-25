package cn.dsx.rbac.app.service.impl;

import cn.dsx.rbac.app.bean.entity.UserRole;
import cn.dsx.rbac.app.mapper.UserRoleMapper;
import cn.dsx.rbac.app.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dousx
 * @since 2020-07-25
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
