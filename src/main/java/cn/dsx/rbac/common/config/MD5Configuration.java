package cn.dsx.rbac.common.config;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: MD5Config
 * @Author: Dsx
 * @Date: 2020/07/25/22:20
 */
@Configuration
public class MD5Configuration {

    @Bean
    public Digester md5() {
        return new Digester(DigestAlgorithm.MD5);
    }

}
