package com.stylefeng.guns.modular.item.service.impl;

import com.stylefeng.guns.modular.item.model.ItemConfig;
import com.stylefeng.guns.modular.item.dao.ItemConfigMapper;
import com.stylefeng.guns.modular.item.service.IItemConfigService;
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
 * @since 2018-10-22
 */
@Service
public class ItemConfigServiceImpl extends ServiceImpl<ItemConfigMapper, ItemConfig> implements IItemConfigService {

    @Override
    public List<Map<String,Object>> selectItemConfig(String condition,String game,String type) {
        return this.baseMapper.selectItemConfig(condition,game,type);
    }
}
