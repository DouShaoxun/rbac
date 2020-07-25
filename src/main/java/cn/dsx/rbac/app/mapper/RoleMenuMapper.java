package cn.dsx.rbac.app.mapper;

import cn.dsx.rbac.app.bean.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dousx
 * @since 2020-07-25
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    List<String> selectByUserId(Long userId);
}
