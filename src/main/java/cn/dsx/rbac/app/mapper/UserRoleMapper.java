package cn.dsx.rbac.app.mapper;

import cn.dsx.rbac.app.bean.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dousx
 * @since 2020-07-25
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<String> selectByUserId(@Param("userId")Long userId);

}
