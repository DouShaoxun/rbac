package cn.dsx.rbac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.wf.jwtp.configuration.EnableJwtPermission;

/**
 * @author Dsx
 */
@SpringBootApplication
@ComponentScan(basePackages={"cn.dsx.rbac.app","cn.dsx.rbac.common"})
@MapperScan("cn.dsx.rbac.app.mapper")
@EnableJwtPermission // 开启JwtPermission
public class RbacApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacApplication.class, args);
    }

}
