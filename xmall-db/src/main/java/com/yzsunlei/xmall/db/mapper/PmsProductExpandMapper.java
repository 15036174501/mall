package com.yzsunlei.xmall.db.mapper;

import com.yzsunlei.xmall.db.model.PmsProduct;
import com.yzsunlei.xmall.db.model.PmsProductExample;
import com.yzsunlei.xmall.db.model.PmsProductExpand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductExpandMapper {

    List<PmsProductExpand>  getGoodsList();

    List<PmsProductExpand> getGoodsDetailAll(Long id);
}