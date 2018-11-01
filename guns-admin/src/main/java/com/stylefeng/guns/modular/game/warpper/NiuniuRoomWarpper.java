package com.stylefeng.guns.modular.game.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

import java.util.List;
import java.util.Map;

public class NiuniuRoomWarpper extends BaseControllerWarpper {

    public NiuniuRoomWarpper(List<Map<String,Object>> list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
//        System.out.println("我只是路过~~~~");
        map.put("onOff",(Integer)map.get("onOff") == 1 ? "开" : "关");
//        map.put("serviceCharge",(Double)map.get("serviceCharge")*100+"%");
    }
}
