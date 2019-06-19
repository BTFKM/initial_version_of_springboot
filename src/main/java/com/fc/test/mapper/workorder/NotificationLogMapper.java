package com.fc.test.mapper.workorder;

import com.fc.test.model.workorder.NotificationLog;
import com.fc.test.model.workorder.NotificationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationLogMapper {
    long countByExample(NotificationLogExample example);

    int deleteByExample(NotificationLogExample example);

    int deleteByPrimaryKey(Long notificationId);

    int insert(NotificationLog record);

    int insertSelective(NotificationLog record);

    List<NotificationLog> selectByExample(NotificationLogExample example);

    NotificationLog selectByPrimaryKey(Long notificationId);

    int updateByExampleSelective(@Param("record") NotificationLog record, @Param("example") NotificationLogExample example);

    int updateByExample(@Param("record") NotificationLog record, @Param("example") NotificationLogExample example);

    int updateByPrimaryKeySelective(NotificationLog record);

    int updateByPrimaryKey(NotificationLog record);
}