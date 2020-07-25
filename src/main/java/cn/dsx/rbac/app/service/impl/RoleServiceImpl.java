package cn.dsx.rbac.app.service.impl;

import cn.dsx.rbac.app.bean.entity.Role;
import cn.dsx.rbac.app.mapper.RoleMapper;
import cn.dsx.rbac.app.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
