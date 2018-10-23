package com.stylefeng.guns.modular.item.dao;

import com.stylefeng.guns.modular.item.model.ItemConfig;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author panghu
 * @since 2018-10-22
 */
public interface ItemConfigMapper extends BaseMapper<ItemConfig> {
    List<Map<String, Object>> selectItemConfig(@Param("condition") String condition,
                                               @Param("game") String game,
                                               @Param("type") String type);
}
