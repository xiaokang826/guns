package com.stylefeng.guns.modular.reportform.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.reportform.warpper.WinLoseReportWarpper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
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

import java.util.List;
import java.util.Map;

/**
 * 输赢报表控制器
 *
 * @author fengshuonan
 * @Date 2018-10-25 15:58:35
 */
@Controller
@RequestMapping("/reportData")
public class ReportDataController extends BaseController {

    private String PREFIX = "/reportform/";

    @Autowired
    private IReportDataService reportDataService;

    private List<Map<String,Object>> list = null;

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
    public Object list(String gameType, String roomType, String userName, String beginTime, String endTime) {
        List<Map<String,Object>> list = reportDataService.selectWinLoseReport(gameType,roomType,userName,beginTime,endTime);
//        int validBet = 0;
//        int winLoseAmount = 0;
//        if(list != null) {
//            for (Map<String,Object> map : list) {
//                validBet += (Integer) map.get("validBet");
//                winLoseAmount += (Integer) map.get("winLoseAmount");
//            }
//        }
//        super.getSession().setAttribute("validBet", validBet);
//        super.getSession().setAttribute("winLoseAmount", winLoseAmount);
        this.list = list;
        return super.warpObject(new WinLoseReportWarpper(list));
    }

    /**
     * 获取输赢报表列表
     */
    @RequestMapping(value = "/demo")
    @ResponseBody
    public String demo(@PathVariable Integer Id,Model model) {
        System.out.println("================"+Id);
        List<Map<String,Object>> list = this.list;
        int validBet = 0;
        int winLoseAmount = 0;
        if(list != null) {
            for (Map<String,Object> map : list) {
                validBet += (Integer) map.get("validBet");
                winLoseAmount += (Integer) map.get("winLoseAmount");
            }
        }
        model.addAttribute("operation",winLoseAmount);
        return winLoseAmount+"";
//        return super.warpObject(new WinLoseReportWarpper(list));
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
