package com.stylefeng.guns.modular.game.service;

import com.stylefeng.guns.modular.game.model.DominoRoom;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panghu
 * @since 2018-10-31
 */
public interface IDominoRoomService extends IService<DominoRoom> {

    List<Map<String,Object>> selectList();
}
