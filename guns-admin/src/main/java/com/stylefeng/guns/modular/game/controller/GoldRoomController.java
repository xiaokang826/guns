package com.stylefeng.guns.modular.game.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.game.model.GoldRoom;
import com.stylefeng.guns.modular.game.service.IGoldRoomService;

/**
 * 炸金花房间配置控制器
 *
 * @author fengshuonan
 * @Date 2018-11-01 14:26:19
 */
@Controller
@RequestMapping("/goldRoom")
public class GoldRoomController extends BaseController {

    private String PREFIX = "/game/goldRoom/";

    @Autowired
    private IGoldRoomService goldRoomService;

    /**
     * 跳转到炸金花房间配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "goldRoom.html";
    }

    /**
     * 跳转到添加炸金花房间配置
     */
    @RequestMapping("/goldRoom_add")
    public String goldRoomAdd() {
        return PREFIX + "goldRoom_add.html";
    }

    /**
     * 跳转到修改炸金花房间配置
     */
    @RequestMapping("/goldRoom_update/{goldRoomId}")
    @DataSource(DBTypeEnum.gold)
    public String goldRoomUpdate(@PathVariable Integer goldRoomId, Model model) {
        GoldRoom goldRoom = goldRoomService.selectById(goldRoomId);
        model.addAttribute("item",goldRoom);
        LogObjectHolder.me().set(goldRoom);
        return PREFIX + "goldRoom_edit.html";
    }

    /**
     * 获取炸金花房间配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object list(String condition) {
        return goldRoomService.selectList(null);
    }

    /**
     * 新增炸金花房间配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object add(GoldRoom goldRoom) {
        goldRoomService.insert(goldRoom);
        return SUCCESS_TIP;
    }

    /**
     * 删除炸金花房间配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object delete(@RequestParam Integer goldRoomId) {
        goldRoomService.deleteById(goldRoomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改炸金花房间配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object update(GoldRoom goldRoom) {
        goldRoomService.updateById(goldRoom);
        return SUCCESS_TIP;
    }

    /**
     * 炸金花房间配置详情
     */
    @RequestMapping(value = "/detail/{goldRoomId}")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object detail(@PathVariable("goldRoomId") Integer goldRoomId) {
        return goldRoomService.selectById(goldRoomId);
    }
}
