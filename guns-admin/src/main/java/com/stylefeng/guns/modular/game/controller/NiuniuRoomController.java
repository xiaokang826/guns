package com.stylefeng.guns.modular.game.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.game.model.DominoCommon;
import com.stylefeng.guns.modular.game.warpper.NiuniuRoomWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.game.model.NiuniuRoom;
import com.stylefeng.guns.modular.game.service.INiuniuRoomService;

import java.util.List;
import java.util.Map;

/**
 * 牛牛房间配置控制器
 *
 * @author fengshuonan
 * @Date 2018-11-01 14:15:47
 */
@Controller
@RequestMapping("/niuniuRoom")
public class NiuniuRoomController extends BaseController {

    private String PREFIX = "/game/niuniuRoom/";

    @Autowired
    private INiuniuRoomService niuniuRoomService;

    /**
     * 跳转到牛牛房间配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "niuniuRoom.html";
    }

    /**
     * 跳转到添加牛牛房间配置
     */
    @RequestMapping("/niuniuRoom_add")
    public String niuniuRoomAdd(Model model) {
        model.addAttribute("operation", "add");
        model.addAttribute("item", new NiuniuRoom());
        return PREFIX + "niuniuRoom_operation.html";
    }

    /**
     * 跳转到修改牛牛房间配置
     */
    @RequestMapping("/niuniuRoom_update/{niuniuRoomId}")
    @DataSource(DBTypeEnum.niuniu)
    public String niuniuRoomUpdate(@PathVariable Integer niuniuRoomId, Model model) {
        NiuniuRoom niuniuRoom = niuniuRoomService.selectById(niuniuRoomId);
        model.addAttribute("operation", "update");
        model.addAttribute("item",niuniuRoom);
        LogObjectHolder.me().set(niuniuRoom);
        return PREFIX + "niuniuRoom_operation.html";
    }

    /**
     * 获取牛牛房间配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object list(String condition) {
        List<Map<String,Object>> list = niuniuRoomService.selectList();
        return super.warpObject(new NiuniuRoomWarpper(list));
    }

    /**
     * 新增牛牛房间配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object add(NiuniuRoom niuniuRoom) {
        niuniuRoomService.insert(niuniuRoom);
        return SUCCESS_TIP;
    }

    /**
     * 删除牛牛房间配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object delete(@RequestParam Integer niuniuRoomId) {
        niuniuRoomService.deleteById(niuniuRoomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改牛牛房间配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object update(NiuniuRoom niuniuRoom) {
        niuniuRoomService.updateById(niuniuRoom);
        return SUCCESS_TIP;
    }

    /**
     * 牛牛房间配置详情
     */
    @RequestMapping(value = "/detail/{niuniuRoomId}")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object detail(@PathVariable("niuniuRoomId") Integer niuniuRoomId) {
        return niuniuRoomService.selectById(niuniuRoomId);
    }
}
