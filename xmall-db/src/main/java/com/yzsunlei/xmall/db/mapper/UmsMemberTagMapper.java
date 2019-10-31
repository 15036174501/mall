package com.yzsunlei.xmall.db.mapper;

import com.yzsunlei.xmall.db.model.UmsMemberTag;
import com.yzsunlei.xmall.db.model.UmsMemberTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberTagMapper {
    int countByExample(UmsMemberTagExample example);

    int deleteByExample(UmsMemberTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberTag record);

    int insertSelective(UmsMemberTag record);

    List<UmsMemberTag> selectByExample(UmsMemberTagExample example);

    UmsMemberTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberTag record, @Param("example") UmsMemberTagExample example);

    int updateByExample(@Param("record") UmsMemberTag record, @Param("example") UmsMemberTagExample example);

    int updateByPrimaryKeySelective(UmsMemberTag record);

    int updateByPrimaryKey(UmsMemberTag record);
}