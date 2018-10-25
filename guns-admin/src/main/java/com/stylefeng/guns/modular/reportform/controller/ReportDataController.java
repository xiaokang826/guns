package com.stylefeng.guns.modular.reportform.controller;

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
import com.stylefeng.guns.modular.reportform.model.ReportData;
import com.stylefeng.guns.modular.reportform.service.IReportDataService;

/**
 * 输赢报表控制器
 *
 * @author fengshuonan
 * @Date 2018-10-25 15:58:35
 */
@Controller
@RequestMapping("/reportData")
public class ReportDataController extends BaseController {

    private String PREFIX = "/reportform/reportData/";

    @Autowired
    private IReportDataService reportDataService;

    /**
     * 跳转到输赢报表首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "reportData.html";
    }

    /**
     * 跳转到添加输赢报表
     */
    @RequestMapping("/reportData_add")
    public String reportDataAdd() {
        return PREFIX + "reportData_add.html";
    }

    /**
     * 跳转到修改输赢报表
     */
    @RequestMapping("/reportData_update/{reportDataId}")
    public String reportDataUpdate(@PathVariable Integer reportDataId, Model model) {
        ReportData reportData = reportDataService.selectById(reportDataId);
        model.addAttribute("item",reportData);
        LogObjectHolder.me().set(reportData);
        return PREFIX + "reportData_edit.html";
    }

    /**
     * 获取输赢报表列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.report)
    public Object list(String condition) {
        return reportDataService.selectList(null);
    }

    /**
     * 新增输赢报表
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ReportData reportData) {
        reportDataService.insert(reportData);
        return SUCCESS_TIP;
    }

    /**
     * 删除输赢报表
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer reportDataId) {
        reportDataService.deleteById(reportDataId);
        return SUCCESS_TIP;
    }

    /**
     * 修改输赢报表
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ReportData reportData) {
        reportDataService.updateById(reportData);
        return SUCCESS_TIP;
    }

    /**
     * 输赢报表详情
     */
    @RequestMapping(value = "/detail/{reportDataId}")
    @ResponseBody
    public Object detail(@PathVariable("reportDataId") Integer reportDataId) {
        return reportDataService.selectById(reportDataId);
    }
}
