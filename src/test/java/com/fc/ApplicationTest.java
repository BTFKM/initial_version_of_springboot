package com.fc;


import com.fc.test.model.workorder.AlarmworkOrder;
import com.fc.test.model.workorder.NotificationLog;
import com.fc.test.service.AlarmWorkOrderServer;
import com.fc.test.util.NotifyPushUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ClassName com.fc.ApplicationTest
 * @Author sjf
 * @mail sjf10050@outlook.com
 * @Date 2019-06-19 09:13
 * @Description 应用测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private NotifyPushUtil notifyPushUtil;
    @Autowired
    private AlarmWorkOrderServer workOrderService;

    @Test
    public void contextLoads() {


/*        List<AlarmworkOrder> alarmWorkOrderEntityList = workOrderService.getAllOrder();
        for (AlarmworkOrder alarmWorkOrderEntity : alarmWorkOrderEntityList) {
            System.out.println(alarmWorkOrderEntity.toString());
        }

        List<NotificationLog> notificationLogEntities = workOrderService.getPushLog();
        for (NotificationLog notificationLogEntity : notificationLogEntities) {
            System.out.println(notificationLogEntity.toString());
        }
        workOrderService.markOrder(2, 2);*/
        System.out.println(new Date());

    }

}
