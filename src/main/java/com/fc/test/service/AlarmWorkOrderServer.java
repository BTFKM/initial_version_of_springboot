package com.fc.test.service;

import cn.hutool.core.lang.Snowflake;
import com.fc.test.common.base.BaseService;

import com.fc.test.mapper.workorder.AlarmworkOrderMapper;
import com.fc.test.mapper.workorder.NotificationLogMapper;
import com.fc.test.model.custom.Tablepar;

import com.fc.test.model.workorder.AlarmworkOrder;
import com.fc.test.model.workorder.AlarmworkOrderExample;

import com.fc.test.model.workorder.NotificationLog;
import com.fc.test.model.workorder.NotificationLogExample;
import com.fc.test.util.NotifyPushUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Yi
 * @Date: 2019-6-18 20:52
 * @Version 1.0
 */
/**
 * @ClassName WorkOrderService
 * @Author sjf
 * @mail sjf10050@outlook.com
 * @Date 2019-06-19 08:35
 * @Description 预警工单服务
 */
@Service
public class AlarmWorkOrderServer implements BaseService<AlarmworkOrder,AlarmworkOrderExample> {

    @Autowired
    private AlarmworkOrderMapper alarmWorkOrderEntityMapper;
    @Autowired
    private NotificationLogMapper NotificationLogEntityMapper;
    @Autowired
    private NotifyPushUtil notifyPushUtil;


/*    List用
    用于展现工单*/
    public PageInfo<AlarmworkOrder> list(Tablepar tablepar, String belongname){
        AlarmworkOrderExample alarmworkOrderExample=new AlarmworkOrderExample();
        alarmworkOrderExample.setOrderByClause("order_id ASC");
        if(belongname!=null&&!"".equals(belongname)){
            alarmworkOrderExample.createCriteria().andGroupIdLike("%"+belongname+"%");
//            testExample.createCriteria().andUsernameLike("%"+username+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<AlarmworkOrder> list= alarmWorkOrderEntityMapper.selectByExample(alarmworkOrderExample);
        PageInfo<AlarmworkOrder> pageInfo = new PageInfo<AlarmworkOrder>(list);
        return  pageInfo;
    }


    /*    List用
        用于展现工单*/
    public PageInfo<AlarmworkOrder> listundo(Tablepar tablepar, String belongname){
        AlarmworkOrderExample alarmworkOrderExample=new AlarmworkOrderExample();
        alarmworkOrderExample.setOrderByClause("order_id ASC");
        alarmworkOrderExample.createCriteria().andWorkingStateEqualTo((byte)0);
        if(belongname!=null&&!"".equals(belongname)){
           alarmworkOrderExample.createCriteria().andGroupIdLike("%"+belongname+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<AlarmworkOrder> list= alarmWorkOrderEntityMapper.selectByExample(alarmworkOrderExample);
        PageInfo<AlarmworkOrder> pageInfo = new PageInfo<AlarmworkOrder>(list);
        return  pageInfo;
    }

    /*    List用
        用于展现工单*/
    public PageInfo<AlarmworkOrder> listdo(Tablepar tablepar, String belongname){
        AlarmworkOrderExample alarmworkOrderExample=new AlarmworkOrderExample();
        alarmworkOrderExample.setOrderByClause("order_id ASC");
        alarmworkOrderExample.createCriteria().andWorkingStateGreaterThan((byte)0);
        if(belongname!=null&&!"".equals(belongname)){
            alarmworkOrderExample.createCriteria().andGroupIdLike("%"+belongname+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<AlarmworkOrder> list= alarmWorkOrderEntityMapper.selectByExample(alarmworkOrderExample);
        PageInfo<AlarmworkOrder> pageInfo = new PageInfo<AlarmworkOrder>(list);
        return  pageInfo;
    }





    private String toAddress = "314994347@qq.com";
    private String fromAddress = "18551051565@163.com";

    //预警生成工单，为指定设备Id生成工单、发送邮件报警
    public void createOrder(String deviceId) {
        if (null == deviceId || deviceId.isEmpty()) {
            return;
        }
        //根据设备号生成新工单
        AlarmworkOrder alarmWorkOrderEntity = new AlarmworkOrder();
        alarmWorkOrderEntity.setDeviceId(deviceId);
        alarmWorkOrderEntity.setOrderCreateTime(new Date());
        //状态：
        // 0：初始状态
        // 1：完成
        // 4：取消
        alarmWorkOrderEntity.setWorkingState((byte) 0);
        int orderId = alarmWorkOrderEntityMapper.insertSelective(alarmWorkOrderEntity);

        //推送邮件
        String mailPayload = "设备：" + deviceId + "发出烟雾报警";
        notifyPushUtil.pushByMail("烟雾报警", mailPayload, toAddress, fromAddress);

        //写入推送日志
        NotificationLog notificationLogEntity = new NotificationLog();
        notificationLogEntity.setOrderId(orderId);
        notificationLogEntity.setNotifyAddress(toAddress);
        notificationLogEntity.setPushTime(new Date());
        notificationLogEntity.setPayload(mailPayload);
        notificationLogEntity.setNotifyState((byte) 1);
        //生成随机Id
        Snowflake snowflake = new Snowflake(1, 1);
        notificationLogEntity.setNotificationId(snowflake.nextId());
        notificationLogEntity.setNotifyType((byte) 1);
        NotificationLogEntityMapper.insertSelective(notificationLogEntity);
    }

    //获取所有工单
    public List<AlarmworkOrder> getAllOrder() {
        AlarmworkOrderExample entityExample = new AlarmworkOrderExample();
        return alarmWorkOrderEntityMapper.selectByExample(entityExample);
    }

    //标记工单状态
    public int markOrder(int orderId, int newState) {
        AlarmworkOrderExample entityExample = new AlarmworkOrderExample();
        entityExample.createCriteria().andOrderIdEqualTo(orderId);
        AlarmworkOrder alarmWorkOrderEntity = new AlarmworkOrder();
        alarmWorkOrderEntity.setOrderId(orderId);
        alarmWorkOrderEntity.setWorkingState((byte) newState);
        alarmWorkOrderEntity.setOrderFinishTime(new Date());
        return(alarmWorkOrderEntityMapper.updateByExampleSelective(alarmWorkOrderEntity, entityExample));
    }

    /*    List用
    用于展现邮件log*/
    public PageInfo<NotificationLog> listmail(Tablepar tablepar, String belongname){
        NotificationLogExample notificationLogExample=new NotificationLogExample();
        notificationLogExample.setOrderByClause("order_id ASC");
        if(belongname!=null&&!"".equals(belongname)){
            notificationLogExample.createCriteria().andPayloadLike("%"+belongname+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<NotificationLog> list= NotificationLogEntityMapper.selectByExample(notificationLogExample);
        PageInfo<NotificationLog> pageInfo = new PageInfo<NotificationLog>(list);
        return  pageInfo;
    }



    //邮件推动历史
    public List<NotificationLog> getPushLog() {
        return NotificationLogEntityMapper.selectByExample(new NotificationLogExample());
    }

    /**
     * 根据ID获取火灾状态
     * @param record
     * @return
     */
    public int getWorkingtate(int id) {
        return alarmWorkOrderEntityMapper.selectByPrimaryKey(id).getWorkingState();
    }











    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(AlarmworkOrder record) {
        return 0;
    }

    @Override
    public AlarmworkOrder selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AlarmworkOrder record) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(AlarmworkOrder record, AlarmworkOrderExample example) {
        return 0;
    }

    @Override
    public int updateByExample(AlarmworkOrder record, AlarmworkOrderExample example) {
        return 0;
    }

    @Override
    public List<AlarmworkOrder> selectByExample(AlarmworkOrderExample example) {
        return null;
    }

    @Override
    public long countByExample(AlarmworkOrderExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(AlarmworkOrderExample example) {
        return 0;
    }
}
