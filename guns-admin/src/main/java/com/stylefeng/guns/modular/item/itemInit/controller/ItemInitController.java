package com.stylefeng.guns.modular.item.itemInit.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.constant.DatasourceEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.ItemInit;
import com.stylefeng.guns.modular.item.itemInit.service.IItemInitService;

/**
 * 道具赠送控制器
 *
 * @author fengshuonan
 * @Date 2018-08-30 18:51:33
 */
@Controller
@RequestMapping("/itemInit")
public class ItemInitController extends BaseController {
    /** logger */
    private final static Logger logger = LoggerFactory.getLogger(ItemInitController.class);

    private String PREFIX = "/item/itemInit/";

    @Autowired
    private IItemInitService itemInitService;

    /**
     * 跳转到道具赠送首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "itemInit.html";
    }

    /**
     * 跳转到添加道具赠送
     */
    @RequestMapping("/itemInit_add")
    public String itemInitAdd() {
        return PREFIX + "itemInit_add.html";
    }

    /**
     * 跳转到修改道具赠送
     */
    @RequestMapping("/itemInit_update/{itemInitId}")
    public String itemInitUpdate(@PathVariable Integer itemInitId, Model model) {
        ItemInit itemInit = itemInitService.selectById(itemInitId);
        model.addAttribute("item",itemInit);
        LogObjectHolder.me().set(itemInit);
        return PREFIX + "itemInit_edit.html";
    }

    /**
     * 获取道具赠送列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public Object list(String condition) {
        return itemInitService.selectList(null);
    }

    /**
     * 新增道具赠送
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ItemInit itemInit) {
        itemInitService.insert(itemInit);
        return SUCCESS_TIP;
    }

    /**
     * 删除道具赠送
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer itemInitId) {
        itemInitService.deleteById(itemInitId);
        return SUCCESS_TIP;
    }

    /**
     * 修改道具赠送
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ItemInit itemInit) {
        itemInitService.updateById(itemInit);
        return SUCCESS_TIP;
    }

    /**
     * 道具赠送详情
     */
    @RequestMapping(value = "/detail/{itemInitId}")
    @ResponseBody
    public Object detail(@PathVariable("itemInitId") Integer itemInitId) {
        return itemInitService.selectById(itemInitId);
    }
}
