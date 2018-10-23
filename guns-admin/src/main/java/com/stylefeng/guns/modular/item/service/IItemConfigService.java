package com.stylefeng.guns.modular.item.service;

import com.stylefeng.guns.modular.item.model.ItemConfig;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author panghu
 * @since 2018-10-22
 */
public interface IItemConfigService extends IService<ItemConfig> {

    List<Map<String, Object>> selectItemConfig(@Param("condition") String condition,
                                               @Param("game") String game,
                                               @Param("type") String type);
}
