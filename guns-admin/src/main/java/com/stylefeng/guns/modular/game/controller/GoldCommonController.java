package com.stylefeng.guns.modular.game.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.game.model.DominoCommon;
import com.stylefeng.guns.modular.game.model.DominoRoom;
import com.stylefeng.guns.modular.game.warpper.GoldCommonWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.game.model.GoldCommon;
import com.stylefeng.guns.modular.game.service.IGoldCommonService;

import java.util.List;
import java.util.Map;

/**
 * 炸金花通用配置控制器
 *
 * @author fengshuonan
 * @Date 2018-11-01 14:25:42
 */
@Controller
@RequestMapping("/goldCommon")
public class GoldCommonController extends BaseController {

    private String PREFIX = "/game/goldCommon/";

    @Autowired
    private IGoldCommonService goldCommonService;

    /**
     * 跳转到炸金花通用配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "goldCommon.html";
    }

    /**
     * 跳转到添加炸金花通用配置
     */
    @RequestMapping("/goldCommon_add")
    public String goldCommonAdd(Model model) {
        model.addAttribute("operation", "add");
        model.addAttribute("item", new GoldCommon());
        return PREFIX + "goldCommon_operation.html";
    }

    /**
     * 跳转到修改炸金花通用配置
     */
    @RequestMapping("/goldCommon_update/{goldCommonId}")
    @DataSource(DBTypeEnum.gold)
    public String goldCommonUpdate(@PathVariable Integer goldCommonId, Model model) {
        GoldCommon goldCommon = goldCommonService.selectById(goldCommonId);
        model.addAttribute("operation", "update");
        model.addAttribute("item",goldCommon);
        LogObjectHolder.me().set(goldCommon);
        return PREFIX + "goldCommon_operation.html";
    }

    /**
     * 获取炸金花通用配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object list(String condition) {
        List<Map<String,Object>> list = goldCommonService.selectList();
        return super.warpObject(new GoldCommonWarpper(list));
    }

    /**
     * 新增炸金花通用配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object add(GoldCommon goldCommon) {
        goldCommonService.insert(goldCommon);
        return SUCCESS_TIP;
    }

    /**
     * 删除炸金花通用配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object delete(@RequestParam Integer goldCommonId) {
        goldCommonService.deleteById(goldCommonId);
        return SUCCESS_TIP;
    }

    /**
     * 修改炸金花通用配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object update(GoldCommon goldCommon) {
        goldCommonService.updateById(goldCommon);
        return SUCCESS_TIP;
    }

    /**
     * 炸金花通用配置详情
     */
    @RequestMapping(value = "/detail/{goldCommonId}")
    @ResponseBody
    @DataSource(DBTypeEnum.gold)
    public Object detail(@PathVariable("goldCommonId") Integer goldCommonId) {
        return goldCommonService.selectById(goldCommonId);
    }
}
