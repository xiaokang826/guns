package com.stylefeng.guns.modular.game.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.game.model.DominoRoom;
import com.stylefeng.guns.modular.game.warpper.DominoRoomWarpper;
import com.stylefeng.guns.modular.reportform.warpper.WinLoseReportWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.game.service.IDominoRoomService;

import java.util.List;
import java.util.Map;

/**
 * 游戏房间配置控制器
 *
 * @author fengshuonan
 * @Date 2018-10-31 10:22:21
 */
@Controller
@RequestMapping("/dominoRoom")
public class DominoRoomController extends BaseController {

    private String PREFIX = "/game/dominoRoom/";

    @Autowired
    private IDominoRoomService roomConfigService;

    /**
     * 跳转到游戏房间配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dominoRoom.html";
    }

    /**
     * 跳转到添加游戏房间配置
     */
    @RequestMapping("/dominoRoom_add")
    public String roomConfigAdd() {
        return PREFIX + "dominoRoom_add.html";
    }

    /**
     * 跳转到修改游戏房间配置
     */
    @RequestMapping("/dominoRoom_update/{roomConfigId}")
    @DataSource(DBTypeEnum.domino)
    public String roomConfigUpdate(@PathVariable Integer roomConfigId, Model model) {
        DominoRoom dominoRoom = roomConfigService.selectById(roomConfigId);
        model.addAttribute("item", dominoRoom);
        LogObjectHolder.me().set(dominoRoom);
        return PREFIX + "dominoRoom_edit.html";
    }

    /**
     * 获取游戏房间配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object list(String condition) {
        List<Map<String,Object>> list = roomConfigService.selectList();
        return super.warpObject(new DominoRoomWarpper(list));
    }

    /**
     * 新增游戏房间配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object add(DominoRoom dominoRoom) {
        roomConfigService.insert(dominoRoom);
        return SUCCESS_TIP;
    }

    /**
     * 删除游戏房间配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object delete(@RequestParam Integer dominoRoomId) {
        roomConfigService.deleteById(dominoRoomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改游戏房间配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object update(DominoRoom dominoRoom) {
        roomConfigService.updateById(dominoRoom);
        return SUCCESS_TIP;
    }

    /**
     * 游戏房间配置详情
     */
    @RequestMapping(value = "/detail/{roomConfigId}")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object detail(@PathVariable("roomConfigId") Integer roomConfigId) {
        return roomConfigService.selectById(roomConfigId);
    }
}
