package com.fc.test.model.workorder;

import java.io.Serializable;
import java.util.Date;

public class AlarmworkOrder implements Serializable {
    private Integer orderId;

    private String groupId;

    private String deviceId;

    private Byte workingState;

    private Date orderCreateTime;

    private Date orderFinishTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Byte getWorkingState() {
        return workingState;
    }

    public void setWorkingState(Byte workingState) {
        this.workingState = workingState;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Date orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }
}