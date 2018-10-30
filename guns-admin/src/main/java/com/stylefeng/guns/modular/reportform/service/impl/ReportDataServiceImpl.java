package com.stylefeng.guns.modular.reportform.service.impl;

import com.stylefeng.guns.core.mutidatasource.DBTypeEnum;
import com.stylefeng.guns.core.mutidatasource.annotion.DataSource;
import com.stylefeng.guns.modular.reportform.model.ReportData;
import com.stylefeng.guns.modular.reportform.dao.ReportDataMapper;
import com.stylefeng.guns.modular.reportform.service.IReportDataService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panghu
 * @since 2018-10-25
 */
@Service
public class ReportDataServiceImpl extends ServiceImpl<ReportDataMapper, ReportData> implements IReportDataService {

    /**
     * 向数据库插入模拟数据
     * @param map
     * @return
     */
    @Override
    @DataSource(DBTypeEnum.report)
    public int insertMapData(Map<String, Object> map) {
        return this.baseMapper.insertMapData(map);
    }

    /**
     * 根据条件查询输赢报表数据
     * @param gameType
     * @param roomType
     * @param userName
     * @param beginTime
     * @param endTime
     * @return
     */
    @Override
    public List<Map<String, Object>> selectWinLoseReport(String gameType, String roomType, String userName, String beginTime, String endTime) {
        return this.baseMapper.selectWinLoseReport(gameType,roomType,userName,beginTime,endTime);
    }
}
