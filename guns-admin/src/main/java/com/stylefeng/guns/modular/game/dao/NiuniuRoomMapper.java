package com.stylefeng.guns.modular.game.dao;

import com.stylefeng.guns.modular.game.model.NiuniuRoom;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panghu
 * @since 2018-11-01
 */
public interface NiuniuRoomMapper extends BaseMapper<NiuniuRoom> {

    List<Map<String,Object>> selectList();
}
