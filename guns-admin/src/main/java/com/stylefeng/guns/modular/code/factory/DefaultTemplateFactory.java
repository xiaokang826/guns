package com.stylefeng.guns.modular.code.factory;


import com.stylefeng.guns.GunsApplication;
import com.stylefeng.guns.core.CoreFlag;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.generator.action.model.GenQo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板种类构建器
 *
 * @author fengshuonan
 * @date 2017-12-04-下午2:59
 */
public class DefaultTemplateFactory {

    /**
     * 获取所有的模板种类
     */
    public static List<Map<String,Object>> getDefaultTemplates(){
        ArrayList<Map<String, Object>> templates = new ArrayList<>();
        templates.add(create("controllerSwitch","controller-控制器开关"));
        templates.add(create("entitySwitch","entity-实体类开关"));
        templates.add(create("serviceSwitch","service-service开关"));
        templates.add(create("daoSwitch","dao-dao开关"));
        templates.add(create("indexPageSwitch","indexPage-首页开关"));
//        templates.add(create("addPageSwitch","addPage-添加页面开关"));
//        templates.add(create("editPageSwitch","editPage-编辑页面开关"));
        templates.add(create("editPageSwitch","operationPage-编辑页面开关"));
        templates.add(create("jsSwitch","indexJs-主页js开关"));
        templates.add(create("infoJsSwitch","infoJs-详情页js开关"));
        templates.add(create("sqlSwitch","sql-sql语句开关"));
        return templates;
    }

    /**
     * 获取默认的参数
     */
    public static GenQo getDefaultParams(){
        GenQo genQo = new GenQo();
        genQo.setProjectPath(ToolUtil.getWebRootPath(null));
        genQo.setAuthor("panghu");
        genQo.setProjectPackage(GunsApplication.class.getPackage().getName());
        genQo.setCorePackage(CoreFlag.class.getPackage().getName());
        genQo.setIgnoreTabelPrefix("");//需要去掉的表前缀
        genQo.setModuleName("system");
        genQo.setParentMenuName("系统管理");
        return genQo;
    }

    private static Map<String,Object> create(String key,String desc){
        HashMap<String, Object> template = new HashMap<>();
        template.put("key",key);
        template.put("desc",desc);
        return template;
    }
}
