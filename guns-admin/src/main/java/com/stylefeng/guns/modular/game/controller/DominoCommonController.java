package com.stylefeng.guns.modular.game.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.game.model.DominoCommon;
import com.stylefeng.guns.modular.game.model.DominoRoom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.game.service.IDominoCommonService;

/**
 * 游戏通用配置控制器
 *
 * @author fengshuonan
 * @Date 2018-10-31 10:22:36
 */
@Controller
@RequestMapping("/dominoCommon")
public class DominoCommonController extends BaseController {

    private String PREFIX = "/game/dominoCommon/";

    @Autowired
    private IDominoCommonService commonConfigService;

    /**
     * 跳转到游戏通用配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dominoCommon.html";
    }

    /**
     * 跳转到添加游戏通用配置
     */
    @RequestMapping("/dominoCommon_add")
    public String commonConfigAdd(Model model) {
        model.addAttribute("operation", "add");
        model.addAttribute("item", new DominoCommon());
        return PREFIX + "dominoCommon_operation.html";
    }

    /**
     * 跳转到修改游戏通用配置
     */
    @RequestMapping("/dominoCommon_update/{commonConfigId}")
    @DataSource(DBTypeEnum.domino)
    public String commonConfigUpdate(@PathVariable Integer commonConfigId, Model model) {
        DominoCommon dominoCommon = commonConfigService.selectById(commonConfigId);
        model.addAttribute("operation", "update");
        model.addAttribute("item", dominoCommon);
        LogObjectHolder.me().set(dominoCommon);
        return PREFIX + "dominoCommon_operation.html";
    }

    /**
     * 获取游戏通用配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object list(String condition) {
        return commonConfigService.selectList(null);
    }

    /**
     * 新增游戏通用配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object add(DominoCommon dominoCommon) {
        commonConfigService.insert(dominoCommon);
        return SUCCESS_TIP;
    }

    /**
     * 删除游戏通用配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object delete(@RequestParam Integer dominoCommonId) {
        commonConfigService.deleteById(dominoCommonId);
        return SUCCESS_TIP;
    }

    /**
     * 修改游戏通用配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object update(DominoCommon dominoCommon) {
        commonConfigService.updateById(dominoCommon);
        return SUCCESS_TIP;
    }

    /**
     * 游戏通用配置详情
     */
    @RequestMapping(value = "/detail/{commonConfigId}")
    @ResponseBody
    @DataSource(DBTypeEnum.domino)
    public Object detail(@PathVariable("commonConfigId") Integer commonConfigId) {
        return commonConfigService.selectById(commonConfigId);
    }
}
