package cn.dsx.rbac;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RbacApplicationTests {

    @Autowired

    @Test
    void contextLoads() {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        String id = "1287007439761289218";
        System.out.println(id.length());
        for (int i = 0; i < 10; i++) {
            String uid2 = snowflake.nextId() + "";
            System.out.println(uid2);
            System.out.println(uid2.length());
        }
    }

}
