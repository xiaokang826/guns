package com.stylefeng.guns.modular.game.dao;

import com.stylefeng.guns.modular.game.model.DominoRoom;
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
 * @since 2018-10-31
 */
public interface DominoRoomMapper extends BaseMapper<DominoRoom> {

    List<Map<String,Object>> selectList();
}
