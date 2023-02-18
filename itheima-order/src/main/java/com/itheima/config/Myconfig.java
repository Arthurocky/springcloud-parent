package com.itheima.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 方式二：配置中心刷新配置
 * 创建配置类方式实现
 */
@Component
@Data
@ConfigurationProperties(prefix = "person")
public class Myconfig {

    private String name;

}
