package com.stylefeng.guns.modular.game.service.impl;

import com.stylefeng.guns.modular.game.model.DominoRoom;
import com.stylefeng.guns.modular.game.dao.DominoRoomMapper;
import com.stylefeng.guns.modular.game.service.IDominoRoomService;
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
 * @since 2018-10-31
 */
@Service
public class DominoRoomServiceImpl extends ServiceImpl<DominoRoomMapper, DominoRoom> implements IDominoRoomService {

    @Override
    public List<Map<String, Object>> selectList() {
        return this.baseMapper.selectList();
    }
}
