package com.stylefeng.guns.modular.item.itemConfig.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.system.model.ItemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.item.itemConfig.service.IItemConfigService;

/**
 * 道具配置控制器
 *
 * @author fengshuonan
 * @Date 2018-08-30 18:14:31
 */
@Controller
@RequestMapping("/itemConfig")
public class ItemConfigController extends BaseController {

    private String PREFIX = "/item/itemConfig/";

    @Autowired
    private IItemConfigService itemConfigService;

    /**
     * 跳转到道具配置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "itemConfig.html";
    }

    /**
     * 跳转到添加道具配置
     */
    @RequestMapping("/itemConfig_add")
    public String itemConfigAdd() {
        return PREFIX + "itemConfig_add.html";
    }

    /**
     * 跳转到修改道具配置
     */
    @RequestMapping("/itemConfig_update/{itemConfigId}")
    public String itemConfigUpdate(@PathVariable Integer itemConfigId, Model model) {
        ItemConfig itemConfig = itemConfigService.selectById(itemConfigId);
        model.addAttribute("item",itemConfig);
        LogObjectHolder.me().set(itemConfig);
        return PREFIX + "itemConfig_edit.html";
    }

    /**
     * 获取道具配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.item)
    public Object list(String condition) {
        return itemConfigService.selectList(null);
    }

    /**
     * 新增道具配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ItemConfig itemConfig) {
        itemConfigService.insert(itemConfig);
        return SUCCESS_TIP;
    }

    /**
     * 删除道具配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer itemConfigId) {
        itemConfigService.deleteById(itemConfigId);
        return SUCCESS_TIP;
    }

    /**
     * 修改道具配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ItemConfig itemConfig) {
        itemConfigService.updateById(itemConfig);
        return SUCCESS_TIP;
    }

    /**
     * 道具配置详情
     */
    @RequestMapping(value = "/detail/{itemConfigId}")
    @ResponseBody
    public Object detail(@PathVariable("itemConfigId") Integer itemConfigId) {
        return itemConfigService.selectById(itemConfigId);
    }
}
