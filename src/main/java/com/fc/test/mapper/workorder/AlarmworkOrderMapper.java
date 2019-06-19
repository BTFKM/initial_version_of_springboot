package com.fc.test.mapper.workorder;

import com.fc.test.model.workorder.AlarmworkOrder;
import com.fc.test.model.workorder.AlarmworkOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmworkOrderMapper {
    long countByExample(AlarmworkOrderExample example);

    int deleteByExample(AlarmworkOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(AlarmworkOrder record);

    int insertSelective(AlarmworkOrder record);

    List<AlarmworkOrder> selectByExample(AlarmworkOrderExample example);

    AlarmworkOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") AlarmworkOrder record, @Param("example") AlarmworkOrderExample example);

    int updateByExample(@Param("record") AlarmworkOrder record, @Param("example") AlarmworkOrderExample example);

    int updateByPrimaryKeySelective(AlarmworkOrder record);

    int updateByPrimaryKey(AlarmworkOrder record);
}