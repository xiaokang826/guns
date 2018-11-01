package com.stylefeng.guns.modular.game.service.impl;

import com.stylefeng.guns.modular.game.model.GoldCommon;
import com.stylefeng.guns.modular.game.dao.GoldCommonMapper;
import com.stylefeng.guns.modular.game.service.IGoldCommonService;
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
public class GoldCommonServiceImpl extends ServiceImpl<GoldCommonMapper, GoldCommon> implements IGoldCommonService {

    @Override
    public List<Map<String, Object>> selectList() {
        return this.baseMapper.selectList();
    }
}
