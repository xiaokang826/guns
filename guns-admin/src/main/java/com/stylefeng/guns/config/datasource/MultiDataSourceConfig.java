package com.stylefeng.guns.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.stylefeng.guns.config.aop.MultiSourceExAop;
import com.stylefeng.guns.core.config.properties.DruidProperties;
import com.stylefeng.guns.core.config.properties.MultiDataSourceProperties;
import com.stylefeng.guns.core.datascope.DataScopeInterceptor;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * 多数据源配置<br/>
 * <p>
 * 注：由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
 *
 * @author stylefeng
 * @Date 2017/5/20 21:58
 */
@Configuration
@ConditionalOnProperty(prefix = "multi-datasource", name = "open", havingValue = "true")
//@ConditionalOnProperty(prefix = "guns.muti-datasource", name = "open", havingValue = "false", matchIfMissing = true)
@EnableTransactionManagement(order = 2)
@MapperScan(basePackages = {"com.stylefeng.guns.modular.*.dao","com.stylefeng.guns.multi.mapper"})
public class MultiDataSourceConfig {

    /** logger */
    private final static Logger logger = LoggerFactory.getLogger("com.stylefeng");

    @Bean
    @ConfigurationProperties(prefix = "multi-datasource.item")
    public MultiDataSourceProperties itemDataSourceProperties() {
        return new MultiDataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "multi-datasource.log")
    public MultiDataSourceProperties logDataSourceProperties() {
        return new MultiDataSourceProperties();
    }

    /**
     * guns的数据源
     */
    private DruidDataSource dataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 多数据源，第二个数据源
     */
    private DruidDataSource bizDataSource(DruidProperties druidProperties, MultiDataSourceProperties multiDataSourceProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        multiDataSourceProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 多数据源连接池配置
     */
    @Bean
    public DynamicDataSource mutiDataSource(DruidProperties druidProperties,
                                            @Qualifier("itemDataSourceProperties") MultiDataSourceProperties itemDataSourceProperties,
                                            @Qualifier("logDataSourceProperties") MultiDataSourceProperties logDataSourceProperties) {

        DruidDataSource dataSourceGuns = dataSource(druidProperties);
        DruidDataSource itemDataSource = bizDataSource(druidProperties, itemDataSourceProperties);
        DruidDataSource logDataSource = bizDataSource(druidProperties, logDataSourceProperties);

        try {
            dataSourceGuns.init();
            itemDataSource.init();
            logDataSource.init();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(DBTypeEnum.guns.getValue(), dataSourceGuns);
        hashMap.put(DBTypeEnum.item.getValue(), itemDataSource);
        hashMap.put(DBTypeEnum.log.getValue(), logDataSource);
//        hashMap.put("guns", dataSourceGuns);
//        hashMap.put("item", bizDataSource);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceGuns);
        return dynamicDataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 数据范围mybatis插件
     */
    @Bean
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor();
    }

    /**
     * 乐观锁mybatis插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 事务配置
     *
     * @author stylefeng
     * @Date 2018/6/27 23:11
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DynamicDataSource mutiDataSource) {
        return new DataSourceTransactionManager(mutiDataSource);
    }

    @Bean
    public MultiSourceExAop aop() {
        return new MultiSourceExAop();
    }
}
