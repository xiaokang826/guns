package com.stylefeng.guns.modular.code.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.config.properties.DruidProperties;
import com.stylefeng.guns.core.config.properties.MutiDataSourceProperties;
import com.stylefeng.guns.generator.action.config.WebGeneratorConfig;
import com.stylefeng.guns.generator.action.model.GenQo;
import com.stylefeng.guns.modular.code.factory.DefaultTemplateFactory;
import com.stylefeng.guns.modular.code.service.TableService;
import com.stylefeng.guns.modular.system.model.Menu;
import com.stylefeng.guns.modular.system.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 代码生成控制器
 *
 * @author fengshuonan
 * @Date 2017年11月30日16:39:19
 */
@Controller
@RequestMapping("/code")
public class CodeController extends BaseController {

    private static String PREFIX = "/code";

    @Autowired
    private TableService tableService;

    @Autowired
    private DruidProperties druidProperties;

    @Autowired //多数据源
    private MutiDataSourceProperties mutiDataSourceProperties;

    @Autowired
    private IMenuService menuService;

    /**
     * 跳转到代码生成主页
     */
    @RequestMapping("")
    public String blackboard(Model model) {
        model.addAttribute("tables", tableService.getAllTables());
        model.addAttribute("params", DefaultTemplateFactory.getDefaultParams());
        model.addAttribute("templates", DefaultTemplateFactory.getDefaultTemplates());
        return PREFIX + "/code.html";
    }

    /**
     * 生成代码
     */
    @ApiOperation("生成代码")
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    public Object generate(GenQo genQo) {
        genQo.setUrl(mutiDataSourceProperties.getUrl());
        genQo.setUserName(mutiDataSourceProperties.getUsername());
        genQo.setPassword(mutiDataSourceProperties.getPassword());
        Menu menu = menuService.getMenusByName(genQo.getParentMenuName());
        genQo.setPcodeAndPcodes(new String[]{menu.getCode(),menu.getPcodes()});
        WebGeneratorConfig webGeneratorConfig = new WebGeneratorConfig(genQo);
        webGeneratorConfig.doMpGeneration();
        webGeneratorConfig.doGunsGeneration();
        return SUCCESS_TIP;
    }

//    /**
//     * 生成代码
//     */
//    @ApiOperation("生成代码")
//    @RequestMapping(value = "/generate", method = RequestMethod.POST)
//    @ResponseBody
//    public Object generate(GenQo genQo) {
//        genQo.setUrl(druidProperties.getUrl());
//        genQo.setUserName(druidProperties.getUsername());
//        genQo.setPassword(druidProperties.getPassword());
//        WebGeneratorConfig webGeneratorConfig = new WebGeneratorConfig(genQo);
//        webGeneratorConfig.doMpGeneration();
//        webGeneratorConfig.doGunsGeneration();
//        return SUCCESS_TIP;
//    }
}
