package com.stylefeng.guns.modular.reportform.service;

import com.stylefeng.guns.modular.reportform.model.ReportData;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panghu
 * @since 2018-10-25
 */
public interface IReportDataService extends IService<ReportData> {

    int insertMapData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> selectWinLoseReport(@Param("gameType") String gameType,
                                                 @Param("roomType") String roomType,
                                                 @Param("userName") String userName,
                                                 @Param("beginTime") String beginTime,
                                                 @Param("endTime") String endTime);
}
