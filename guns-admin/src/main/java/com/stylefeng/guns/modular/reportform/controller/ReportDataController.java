package com.stylefeng.guns.modular.reportform.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.reportform.model.WinLoseReport;
import com.stylefeng.guns.modular.reportform.warpper.WinLoseReportWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.reportform.service.IWinLoseReportService;

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
    private IWinLoseReportService reportDataService;

    private List<Map<String,Object>> list = null;

    /**
     * 跳转到输赢报表首页
     */
    @RequestMapping("")
    public String index(Integer id, Model model) {
        System.out.println("============"+id);
        model.addAttribute("id",id);
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
        WinLoseReport winLoseReport = reportDataService.selectById(reportDataId);
        model.addAttribute("item", winLoseReport);
        LogObjectHolder.me().set(winLoseReport);
        return PREFIX + "reportData_edit.html";
    }

    /**
     * 获取输赢报表列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @DataSource(DBTypeEnum.report)
    public Object list(String gameType, String roomType, String userName, String beginTime, String endTime, Model model) {
        model.addAttribute("id",1111);
        List<Map<String,Object>> list = reportDataService.selectWinLoseReport(gameType,roomType,userName,beginTime,endTime);
        this.list = list;//每次查询出来更新list 以便ajax更新前端显示
        return super.warpObject(new WinLoseReportWarpper(list));
    }

    /**
     * 获取输赢报表列表
     */
    @RequestMapping(value = "/refresh")
    @ResponseBody
    public String demo(String gameType) {//参数的key和ajax set的key需一致
        int validBet = 0;
        int winLoseAmount = 0;
        if(list != null) {
            for (Map<String,Object> map : list) {
                validBet += (Integer) map.get("validBet");
                winLoseAmount += (Integer) map.get("winLoseAmount");
            }
        }
        System.out.println(validBet+"==========="+winLoseAmount);
        return "总有效投注："+validBet+"，总输赢："+winLoseAmount;
    }

    /**
     * 新增输赢报表
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WinLoseReport winLoseReport) {
        reportDataService.insert(winLoseReport);
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
    public Object update(WinLoseReport winLoseReport) {
        reportDataService.updateById(winLoseReport);
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
