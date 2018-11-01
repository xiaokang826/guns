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
import com.stylefeng.guns.modular.game.model.NiuniuCommon;
import com.stylefeng.guns.modular.game.service.INiuniuCommonService;

/**
 * 牛牛通用配置控制器
 *
 * @author fengshuonan
 * @Date 2018-11-01 14:15:20
 */
@Controller
@RequestMapping("/niuniuCommon")
public class NiuniuCommonController extends BaseController {

    private String PREFIX = "/game/niuniuCommon/";

    @Autowired
    private INiuniuCommonService niuniuCommonService;

    /**
     * 跳转到牛牛通用配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "niuniuCommon.html";
    }

    /**
     * 跳转到添加牛牛通用配置
     */
    @RequestMapping("/niuniuCommon_add")
    public String niuniuCommonAdd() {
        return PREFIX + "niuniuCommon_add.html";
    }

    /**
     * 跳转到修改牛牛通用配置
     */
    @RequestMapping("/niuniuCommon_update/{niuniuCommonId}")
    @DataSource(DBTypeEnum.niuniu)
    public String niuniuCommonUpdate(@PathVariable Integer niuniuCommonId, Model model) {
        NiuniuCommon niuniuCommon = niuniuCommonService.selectById(niuniuCommonId);
        model.addAttribute("item",niuniuCommon);
        LogObjectHolder.me().set(niuniuCommon);
        return PREFIX + "niuniuCommon_edit.html";
    }

    /**
     * 获取牛牛通用配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object list(String condition) {
        return niuniuCommonService.selectList(null);
    }

    /**
     * 新增牛牛通用配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object add(NiuniuCommon niuniuCommon) {
        niuniuCommonService.insert(niuniuCommon);
        return SUCCESS_TIP;
    }

    /**
     * 删除牛牛通用配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object delete(@RequestParam Integer niuniuCommonId) {
        niuniuCommonService.deleteById(niuniuCommonId);
        return SUCCESS_TIP;
    }

    /**
     * 修改牛牛通用配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object update(NiuniuCommon niuniuCommon) {
        niuniuCommonService.updateById(niuniuCommon);
        return SUCCESS_TIP;
    }

    /**
     * 牛牛通用配置详情
     */
    @RequestMapping(value = "/detail/{niuniuCommonId}")
    @ResponseBody
    @DataSource(DBTypeEnum.niuniu)
    public Object detail(@PathVariable("niuniuCommonId") Integer niuniuCommonId) {
        return niuniuCommonService.selectById(niuniuCommonId);
    }
}
