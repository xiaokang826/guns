package com.stylefeng.guns.core.config;

import com.stylefeng.guns.core.mutidatasource.aop.MultiSourceExAop;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 多数据源配置
 *
 * @author stylefeng
 * @Date 2017/5/20 21:58
 */
//根据加载顺序 此类没什么卵用
@Configuration
@ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "true")
public class DefaultMultiConfig {

    @Bean
    public MultiSourceExAop multiSourceExAop() {
        return new MultiSourceExAop();
    }
}
