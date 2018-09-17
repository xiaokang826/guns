package com.stylefeng.guns.generator.action;


import com.stylefeng.guns.generator.action.config.GunsGeneratorConfig;
import com.stylefeng.guns.generator.action.config.WebGeneratorConfig;
import com.stylefeng.guns.generator.action.model.GenQo;

/**
 * 代码生成器,可以生成实体,dao,service,controller,html,js
 *
 * @author stylefeng
 * @Date 2017/5/21 12:38
 */
public class GunsCodeGenerator {

    public static void main(String[] args) {

//        /**
//         * Mybatis-Plus的代码生成器:
//         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
//         */
//        GunsGeneratorConfig gunsGeneratorConfig = new GunsGeneratorConfig();
//        gunsGeneratorConfig.doMpGeneration();
//
//        /**
//         * guns的生成器:
//         *      guns的代码生成器可以生成controller,html页面,页面对应的js
//         */
//        gunsGeneratorConfig.doGunsGeneration();

        GenQo genQo = new GenQo();
        genQo.setUserName("root");
        genQo.setPassword("root");
        genQo.setUrl("jdbc:mysql://10.0.0.117:3306/spring_boot?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC");
        genQo.setTableName("item_config");//表名
        genQo.setProjectPath("D:\\blabla");//路径
        genQo.setAuthor("panghu");//作者
        genQo.setProjectPackage("piapia");//项目地址
        genQo.setCorePackage("core");
        genQo.setIgnoreTabelPrefix("");//忽略的表前缀,如sys_
        genQo.setModuleName("item");//模块名称
        genQo.setBizName("道具配置");//别名
        genQo.setParentMenuName("顶级");

        genQo.setControllerSwitch(true);
        genQo.setIndexPageSwitch(true);
        genQo.setAddPageSwitch(true);
        genQo.setEditPageSwitch(true);
        genQo.setJsSwitch(true);
        genQo.setInfoJsSwitch(true);
        genQo.setDaoSwitch(true);
        genQo.setServiceSwitch(true);
        genQo.setEntitySwitch(true);
        genQo.setSqlSwitch(true);
        WebGeneratorConfig webGeneratorConfig = new WebGeneratorConfig(genQo);
        webGeneratorConfig.doMpGeneration();
        webGeneratorConfig.doGunsGeneration();
    }

}