package com.stylefeng.guns.multi.test;

import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.multi.service.TestService;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务测试
 *
 * @author fengshuonan
 * @date 2017-06-23 23:12
 */
public class BizTest extends BaseJunit {

//    @Autowired
//    TestService testService;
//
//    @Test
//    public void test() {
//        testService.testGuns();
//
//        testService.testBiz();
//
//        //testService.testAll();
//    }
    @Test
    public void test(){ //枚举类的属性和value的值hashcode不一致 需要注意
        Object strA = DBTypeEnum.guns.getValue();
        Object strB = DBTypeEnum.guns;
        Map<Object,Object> map = new HashMap<>();
        map.put(strA,"blabla");
        map.put(strB,"piapia");
        System.out.println(strA+":"+strB+"->"+strA.equals(strB));
        System.out.println(strA.hashCode()+"======="+strB.hashCode());
        map.forEach((k,v)->{
            System.out.println(k.getClass());
            System.out.println(k.toString()+":"+v.toString());
        });
    }

    @Test
//    @Select()
//    @Update()
    public void test1(){
    }
}
