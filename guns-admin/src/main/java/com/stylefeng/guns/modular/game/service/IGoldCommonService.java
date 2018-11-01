package com.stylefeng.guns.modular.game.service;

import com.stylefeng.guns.modular.game.model.GoldCommon;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panghu
 * @since 2018-11-01
 */
public interface IGoldCommonService extends IService<GoldCommon> {

    List<Map<String,Object>> selectList();
}
