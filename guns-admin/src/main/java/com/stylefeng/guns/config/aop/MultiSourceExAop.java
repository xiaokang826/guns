package com.stylefeng.guns.config.aop;

import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.DataSourceContextHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

/**
 * 多数据源切换的aop
 *
 * @author fengshuonan
 * @date 2017年3月5日 上午10:22:16
 */
@Aspect
//@Component //core包有一个aop已经注册过，此处再用此注解会出现重名报错
public class MultiSourceExAop implements Ordered {

    private Logger log = LoggerFactory.getLogger(this.getClass());

//    @Pointcut(value = "@annotation(com.stylefeng.guns.core.mutidatasource.annotion.DataSource)")
//    private void cur() {}

//    @Pointcut("execution(* com.stylefeng.guns.modular.item..*Service.*(..)) ")
//    @Pointcut("execution(* com.baomidou.mybatisplus.service.IService.~~*(..)) ")
    //此处需要注意：controller里所有的方法都将会切换数据源
    //解决办法：在方法使用注解切换数据源(此处需要优化)
    @Pointcut("execution(* com.stylefeng.guns.modular.item..*.*(..)) ")
    private void cut() {}

    @Before("cut()")
    public void data(){
        log.info("切换到item 数据源...");
        DataSourceContextHolder.setDataSourceType(DBTypeEnum.item);
        log.info("设置数据源为->：" + DBTypeEnum.item);
//        around(DBTypeEnum.item);
    }

   /* before、after 和 around 来区别是在每个 joint point 之前、之后还是代替执行
    aop执行顺序 @around(.proceed()) -> @Before -> @around -> @after -> @afterReturning
    public void around(DBTypeEnum dbTypeEnum){
        Signature signature = point.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        MethodSignature currentMethod = (MethodSignature) point.getSignature();
        DataSource datasource = currentMethod.getMethod().getAnnotation(DataSource.class);
        DataSourceContextHolder.setDataSourceType(dataSourceName);
        log.info("设置数据源为->：" + dataSourceName);
    }*/

    @After("cut()")
    public void after(){
        log.debug("清空数据源信息！");
        DataSourceContextHolder.clearDataSourceType();
    }

    /**
     * aop的顺序要早于spring的事务
     */
    @Override
    public int getOrder() {
        return 1;
    }

}
