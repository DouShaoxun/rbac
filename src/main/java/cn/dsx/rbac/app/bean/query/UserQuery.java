package cn.dsx.rbac.app.bean.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Classname: UserQuery
 * @Author: Dsx
 * @Date: 2020/07/26/10:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class UserQuery implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "用户名")
    private String username;


}
