package com.stylefeng.guns.modular.reportform.dao;

import com.stylefeng.guns.modular.reportform.model.ReportData;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panghu
 * @since 2018-10-25
 */
public interface ReportDataMapper extends BaseMapper<ReportData> {

    int insertMapData(@Param("map") Map<String, Object> map);

    List<Map<String,Object>> selectWinLoseReport(@Param("gameType") String gameType,
                                                 @Param("roomType") String roomType,
                                                 @Param("userName") String userName,
                                                 @Param("beginTime") String beginTime,
                                                 @Param("endTime") String endTime);
}
