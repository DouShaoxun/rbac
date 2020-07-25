package cn.dsx.rbac.app.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dousx
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户ID")
      @TableId(value = "USER_ID", type = IdType.ASSIGN_ID)
    private Long userId;

    @ApiModelProperty(value = "用户名")
    @TableField("USERNAME")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "部门ID")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "邮箱")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "联系电话")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "状态 0锁定 1有效")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "MODIFY_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @ApiModelProperty(value = "最近访问时间")
    @TableField("LAST_LOGIN_TIME")
    private Date lastLoginTime;

    @ApiModelProperty(value = "性别 0男 1女 2保密")
    @TableField("SSEX")
    private String ssex;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "用户头像")
    @TableField("AVATAR")
    private String avatar;


}
