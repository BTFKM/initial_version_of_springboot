package com.fc.test.model.workorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNotificationIdIsNull() {
            addCriterion("notification_id is null");
            return (Criteria) this;
        }

        public Criteria andNotificationIdIsNotNull() {
            addCriterion("notification_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationIdEqualTo(Long value) {
            addCriterion("notification_id =", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotEqualTo(Long value) {
            addCriterion("notification_id <>", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdGreaterThan(Long value) {
            addCriterion("notification_id >", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("notification_id >=", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdLessThan(Long value) {
            addCriterion("notification_id <", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdLessThanOrEqualTo(Long value) {
            addCriterion("notification_id <=", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdIn(List<Long> values) {
            addCriterion("notification_id in", values, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotIn(List<Long> values) {
            addCriterion("notification_id not in", values, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdBetween(Long value1, Long value2) {
            addCriterion("notification_id between", value1, value2, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotBetween(Long value1, Long value2) {
            addCriterion("notification_id not between", value1, value2, "notificationId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIsNull() {
            addCriterion("notify_type is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIsNotNull() {
            addCriterion("notify_type is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeEqualTo(Byte value) {
            addCriterion("notify_type =", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotEqualTo(Byte value) {
            addCriterion("notify_type <>", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeGreaterThan(Byte value) {
            addCriterion("notify_type >", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("notify_type >=", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLessThan(Byte value) {
            addCriterion("notify_type <", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLessThanOrEqualTo(Byte value) {
            addCriterion("notify_type <=", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIn(List<Byte> values) {
            addCriterion("notify_type in", values, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotIn(List<Byte> values) {
            addCriterion("notify_type not in", values, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeBetween(Byte value1, Byte value2) {
            addCriterion("notify_type between", value1, value2, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("notify_type not between", value1, value2, "notifyType");
            return (Criteria) this;
        }

        public Criteria andPayloadIsNull() {
            addCriterion("payload is null");
            return (Criteria) this;
        }

        public Criteria andPayloadIsNotNull() {
            addCriterion("payload is not null");
            return (Criteria) this;
        }

        public Criteria andPayloadEqualTo(String value) {
            addCriterion("payload =", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadNotEqualTo(String value) {
            addCriterion("payload <>", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadGreaterThan(String value) {
            addCriterion("payload >", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadGreaterThanOrEqualTo(String value) {
            addCriterion("payload >=", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadLessThan(String value) {
            addCriterion("payload <", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadLessThanOrEqualTo(String value) {
            addCriterion("payload <=", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadLike(String value) {
            addCriterion("payload like", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadNotLike(String value) {
            addCriterion("payload not like", value, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadIn(List<String> values) {
            addCriterion("payload in", values, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadNotIn(List<String> values) {
            addCriterion("payload not in", values, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadBetween(String value1, String value2) {
            addCriterion("payload between", value1, value2, "payload");
            return (Criteria) this;
        }

        public Criteria andPayloadNotBetween(String value1, String value2) {
            addCriterion("payload not between", value1, value2, "payload");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressIsNull() {
            addCriterion("notify_address is null");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressIsNotNull() {
            addCriterion("notify_address is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressEqualTo(String value) {
            addCriterion("notify_address =", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressNotEqualTo(String value) {
            addCriterion("notify_address <>", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressGreaterThan(String value) {
            addCriterion("notify_address >", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("notify_address >=", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressLessThan(String value) {
            addCriterion("notify_address <", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressLessThanOrEqualTo(String value) {
            addCriterion("notify_address <=", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressLike(String value) {
            addCriterion("notify_address like", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressNotLike(String value) {
            addCriterion("notify_address not like", value, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressIn(List<String> values) {
            addCriterion("notify_address in", values, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressNotIn(List<String> values) {
            addCriterion("notify_address not in", values, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressBetween(String value1, String value2) {
            addCriterion("notify_address between", value1, value2, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyAddressNotBetween(String value1, String value2) {
            addCriterion("notify_address not between", value1, value2, "notifyAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyStateIsNull() {
            addCriterion("notify_state is null");
            return (Criteria) this;
        }

        public Criteria andNotifyStateIsNotNull() {
            addCriterion("notify_state is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyStateEqualTo(Byte value) {
            addCriterion("notify_state =", value, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateNotEqualTo(Byte value) {
            addCriterion("notify_state <>", value, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateGreaterThan(Byte value) {
            addCriterion("notify_state >", value, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("notify_state >=", value, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateLessThan(Byte value) {
            addCriterion("notify_state <", value, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateLessThanOrEqualTo(Byte value) {
            addCriterion("notify_state <=", value, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateIn(List<Byte> values) {
            addCriterion("notify_state in", values, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateNotIn(List<Byte> values) {
            addCriterion("notify_state not in", values, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateBetween(Byte value1, Byte value2) {
            addCriterion("notify_state between", value1, value2, "notifyState");
            return (Criteria) this;
        }

        public Criteria andNotifyStateNotBetween(Byte value1, Byte value2) {
            addCriterion("notify_state not between", value1, value2, "notifyState");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("push_time =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("push_time <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("push_time >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("push_time >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("push_time <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("push_time <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("push_time in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("push_time not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}