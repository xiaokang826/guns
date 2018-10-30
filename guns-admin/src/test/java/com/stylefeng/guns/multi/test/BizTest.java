package com.stylefeng.guns.multi.test;

import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.reportform.service.IReportDataService;
import com.stylefeng.guns.multi.service.TestService;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
//    @Test
//    public void test(){ //枚举类的属性和value的值hashcode不一致 需要注意
//        Object strA = DBTypeEnum.guns.getValue();
//        Object strB = DBTypeEnum.guns;
//        Map<Object,Object> map = new HashMap<>();
//        map.put(strA,"blabla");
//        map.put(strB,"piapia");
//        System.out.println(strA+":"+strB+"->"+strA.equals(strB));
//        System.out.println(strA.hashCode()+"======="+strB.hashCode());
//        map.forEach((k,v)->{
//            System.out.println(k.getClass());
//            System.out.println(k.toString()+":"+v.toString());
//        });
//    }

    @Autowired
    private IReportDataService reportDataService;

//    @Select()
//    @Update()
    @Test
    public void test(){
        Map<String, Object> map = new HashMap<>();
        for (int i = 1; i < 1001; i++) {
            map.put("account_change_time",subMonth(i % 10));
            map.put("user_name","panghu"+i);
            map.put("game_name",i % 3 == 0 ? "炸金花" : i % 3 == 1 ? "牛牛" : "牌九");
            map.put("room_type",i % 2 == 0 ? "普通房" : "高级房");
            map.put("table_number","1"+i);
            map.put("seat_number","100"+i);
            map.put("leisure",i % 5 == 0 ? "庄" : "闲");
            map.put("initial_amount","1"+i);
            map.put("total_bet",i+"0");
            map.put("valid_bet",i+"0");
            map.put("win_lose_amount",i+"0");
            map.put("board_number","zhajinhua-8"+i+"001");
            map.put("game_result",i % 3 == 0 ? "+"+i*10 : "-"+i*10);
            map.put("game_start_time",subMonth(i % 10));
            map.put("game_end_time",subMonth(i % 10));
            map.put("log_details","皮卡丘，我们走，吃炸鸡，喝啤酒"+i*8*8*8*8);
            map.put("order_number","asd457-qwe_789/qq&"+i);
            map.put("order_details","充值"+i+"00");
            map.put("account_type",i % 3 == 0 ? "游戏赢分" : "游戏输分");
            map.put("amount_before_change",i*2+"00");
            map.put("account_change_amount",i+"0");
            map.put("amount_after_change",i*2*100+i*10);
            map.put("operator","panghu"+i);
            reportDataService.insertMapData(map);
        }
    }

    /****
     * 传入具体日期 ，返回具体日期增加一个月。
     * @param day 需要减少的天数
     * @return 2017-05-13
     * @throws ParseException
     */
    private Date subMonth(int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.DAY_OF_MONTH, -day);
        Date date = rightNow.getTime();
        return date;
    }
}
