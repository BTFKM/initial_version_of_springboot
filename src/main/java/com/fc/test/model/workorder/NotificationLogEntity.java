package com.fc.test.model.workorder;

import lombok.ToString;

import java.util.Date;
@ToString
public class NotificationLogEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_log.notification_id
     *
     * @mbg.generated
     */
    private Long notificationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_log.order_id
     *
     * @mbg.generated
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_log.notify_type
     *
     * @mbg.generated
     */
    private Byte notifyType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_log.payload
     *
     * @mbg.generated
     */
    private String payload;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_log.notify_address
     *
     * @mbg.generated
     */
    private String notifyAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_log.notify_state
     *
     * @mbg.generated
     */
    private Byte notifyState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification_log.push_time
     *
     * @mbg.generated
     */
    private Date pushTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_log.notification_id
     *
     * @return the value of notification_log.notification_id
     *
     * @mbg.generated
     */
    public Long getNotificationId() {
        return notificationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_log.notification_id
     *
     * @param notificationId the value for notification_log.notification_id
     *
     * @mbg.generated
     */
    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_log.order_id
     *
     * @return the value of notification_log.order_id
     *
     * @mbg.generated
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_log.order_id
     *
     * @param orderId the value for notification_log.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_log.notify_type
     *
     * @return the value of notification_log.notify_type
     *
     * @mbg.generated
     */
    public Byte getNotifyType() {
        return notifyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_log.notify_type
     *
     * @param notifyType the value for notification_log.notify_type
     *
     * @mbg.generated
     */
    public void setNotifyType(Byte notifyType) {
        this.notifyType = notifyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_log.payload
     *
     * @return the value of notification_log.payload
     *
     * @mbg.generated
     */
    public String getPayload() {
        return payload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_log.payload
     *
     * @param payload the value for notification_log.payload
     *
     * @mbg.generated
     */
    public void setPayload(String payload) {
        this.payload = payload == null ? null : payload.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_log.notify_address
     *
     * @return the value of notification_log.notify_address
     *
     * @mbg.generated
     */
    public String getNotifyAddress() {
        return notifyAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_log.notify_address
     *
     * @param notifyAddress the value for notification_log.notify_address
     *
     * @mbg.generated
     */
    public void setNotifyAddress(String notifyAddress) {
        this.notifyAddress = notifyAddress == null ? null : notifyAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_log.notify_state
     *
     * @return the value of notification_log.notify_state
     *
     * @mbg.generated
     */
    public Byte getNotifyState() {
        return notifyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_log.notify_state
     *
     * @param notifyState the value for notification_log.notify_state
     *
     * @mbg.generated
     */
    public void setNotifyState(Byte notifyState) {
        this.notifyState = notifyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification_log.push_time
     *
     * @return the value of notification_log.push_time
     *
     * @mbg.generated
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification_log.push_time
     *
     * @param pushTime the value for notification_log.push_time
     *
     * @mbg.generated
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}