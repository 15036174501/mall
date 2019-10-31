package com.yzsunlei.xmall.db.mapper;

import com.yzsunlei.xmall.db.model.SmsHomeAdvertise;
import com.yzsunlei.xmall.db.model.SmsHomeAdvertiseExample;
import com.yzsunlei.xmall.db.model.SmsHomeAdvertiseExpand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsHomeAdvertiseExpandMapper {

    List<SmsHomeAdvertiseExpand> listHomeAdvertise(Integer type);

}