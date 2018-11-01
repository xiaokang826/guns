package com.stylefeng.guns.modular.game.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

import java.util.List;
import java.util.Map;

public class GoldCommonWarpper extends BaseControllerWarpper {

    public GoldCommonWarpper(List<Map<String,Object>> list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
//        System.out.println("我只是路过~~~~");
        String playType = "待续...";
        switch ((Integer)map.get("playType")){
            case 1:
                playType = "classic";
                break;
            case 2:
                playType = "joker";
                break;
            case 3:
                playType = "hukam";
                break;
            case 4:
                playType = "changeCard";
                break;
            case 5:
                playType = "blind";
                break;
            case 6:
                playType = "dealer";
                break;
        }
        map.put("playType",playType);
        map.put("isChangeCard",(Boolean)map.get("isChangeCard")? "开" : "关");
        map.put("settleType",(Integer)map.get("settleType") == 1 ? "底池上限" : "轮次上限");
        map.put("isAllowSideshow",(Boolean)map.get("isAllowSideshow") ? "需要" : "不需要");
        map.put("isSideshowUser",(Boolean)map.get("isSideshowUser") ? "允许" : "不允许");
    }
}
