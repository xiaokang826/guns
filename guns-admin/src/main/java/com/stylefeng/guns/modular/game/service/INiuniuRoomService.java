package com.stylefeng.guns.modular.game.service;

import com.stylefeng.guns.modular.game.model.NiuniuRoom;
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
public interface INiuniuRoomService extends IService<NiuniuRoom> {

    List<Map<String,Object>> selectList();
}
