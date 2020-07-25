package cn.dsx.rbac.app.service.impl;

import cn.dsx.rbac.app.bean.entity.Menu;
import cn.dsx.rbac.app.mapper.MenuMapper;
import cn.dsx.rbac.app.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
