package com.stylefeng.guns.modular.item.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import java.util.Map;

/**
 * 菜单列表的包装类
 *
 * @author fengshuonan
 * @date 2017年2月19日15:07:29
 */
public class ItemConfigWarpper extends BaseControllerWarpper {

//    public ItemConfigWarpper(List<Object> list) {
//        List<Map<String,Object>> mapList = new ArrayList<>();
//        for(Object obj : list){
//            Map<String, Object> map = new HashMap<>();
//            Field[] fields = obj.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                int mod = field.getModifiers();
//                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
//                    continue;
//                }
//                field.setAccessible(true);
//                try {
//                    field.set(obj, map.get(field.getName()));
//                } catch (IllegalAccessException e) {
//                    System.out.println("类转map 转换异常！！！");
//                }
//            }
//            mapList.add(map);
//        }
//        ItemConfigWarpper(mapList);
//    }

    public ItemConfigWarpper(List<Map<String,Object>> list) {
        super(list);
    }

    /**
     * 此处是用作转换页面显示的值
     * 比如将1、0转换成开、关
     * key为js表格里的field字段的值
     */
    @Override
    public void warpTheMap(Map<String, Object> map) {
        //map.put("status", 开);
    }

}
