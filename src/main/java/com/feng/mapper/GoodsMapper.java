package com.feng.mapper;

import com.feng.model.Goods;
import com.feng.model.GoodsVO;

/**
 * @author asura
 */
public interface GoodsMapper {
    Goods findGoodsById(int id);

    GoodsVO findGoodsWithUserById(int id);
}
