package com.stylefeng.guns.modular.game.service.impl;

import com.stylefeng.guns.modular.game.model.NiuniuRoom;
import com.stylefeng.guns.modular.game.dao.NiuniuRoomMapper;
import com.stylefeng.guns.modular.game.service.INiuniuRoomService;
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
 * @since 2018-11-01
 */
@Service
public class NiuniuRoomServiceImpl extends ServiceImpl<NiuniuRoomMapper, NiuniuRoom> implements INiuniuRoomService {

    @Override
    public List<Map<String, Object>> selectList() {
        return this.baseMapper.selectList();
    }
}
