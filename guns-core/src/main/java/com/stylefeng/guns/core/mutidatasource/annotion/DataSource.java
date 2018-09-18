package com.stylefeng.guns.core.mutidatasource.annotion;

import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;

import java.lang.annotation.*;

/**
 * 
 * 多数据源标识
 *
 * @author fengshuonan
 * @date 2017年3月5日 上午9:44:24
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DataSource {
	//String value() default "dataSourceGuns";
	DBTypeEnum value() default DBTypeEnum.guns;
}
