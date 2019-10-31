package com.yzsunlei.xmall.db.mapper;

import com.yzsunlei.xmall.db.model.PmsProductCategoryExpand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductCategoryExpandMapper {

    List<PmsProductCategoryExpand> listWithRoot();


    List<PmsProductCategoryExpand> getCategoryDetail(long categoryId);
}