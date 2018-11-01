package com.stylefeng.guns.modular.code.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.config.properties.DruidProperties;
import com.stylefeng.guns.core.config.properties.MultiDataSourceProperties;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
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

import javax.annotation.Resource;

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

//    @Autowired //多数据源 此处有多个相同类型的bean
    @Resource(name = "GoldDataSourceProperties") //此处bean的名称为MultiDataSourceConfig里注册的bean名称(默认是方法名)
    private MultiDataSourceProperties multiDataSourceProperties;

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
        genQo.setUrl(multiDataSourceProperties.getUrl());
        genQo.setUserName(multiDataSourceProperties.getUsername());
        genQo.setPassword(multiDataSourceProperties.getPassword());
        if("顶级".equals(genQo.getParentMenuName())) {//顶级菜单不需要查询相关联菜单名称
            genQo.setPcodeAndPcodes(new String[]{"0", ""});
        }else{
            Menu menu = menuService.getMenusByName(genQo.getParentMenuName());
            genQo.setPcodeAndPcodes(new String[]{menu.getCode(), menu.getPcodes()});
        }
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
