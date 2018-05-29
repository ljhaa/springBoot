package com.yipuhui.fastgo.enty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**  
 *    
 *   
 * @author 刘俊汉  
 * @date 2018/5/11 17:24  
 * @param   
 * @return   
 */ 
public class AccountCheckingLanmaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountCheckingLanmaoExample() {
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

    protected abstract static class BaseGeneratedCriteria {
        protected List<Criterion> criteria;

        protected BaseGeneratedCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("business_type like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("business_type not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformIsNull() {
            addCriterion("lanmao_relevance_platform is null");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformIsNotNull() {
            addCriterion("lanmao_relevance_platform is not null");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformEqualTo(String value) {
            addCriterion("lanmao_relevance_platform =", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformNotEqualTo(String value) {
            addCriterion("lanmao_relevance_platform <>", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformGreaterThan(String value) {
            addCriterion("lanmao_relevance_platform >", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformGreaterThanOrEqualTo(String value) {
            addCriterion("lanmao_relevance_platform >=", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformLessThan(String value) {
            addCriterion("lanmao_relevance_platform <", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformLessThanOrEqualTo(String value) {
            addCriterion("lanmao_relevance_platform <=", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformLike(String value) {
            addCriterion("lanmao_relevance_platform like", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformNotLike(String value) {
            addCriterion("lanmao_relevance_platform not like", value, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformIn(List<String> values) {
            addCriterion("lanmao_relevance_platform in", values, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformNotIn(List<String> values) {
            addCriterion("lanmao_relevance_platform not in", values, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformBetween(String value1, String value2) {
            addCriterion("lanmao_relevance_platform between", value1, value2, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andLanmaoRelevancePlatformNotBetween(String value1, String value2) {
            addCriterion("lanmao_relevance_platform not between", value1, value2, "lanmaoRelevancePlatform");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeIsNull() {
            addCriterion("bill_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeIsNotNull() {
            addCriterion("bill_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeEqualTo(Date value) {
            addCriterion("bill_creat_time =", value, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeNotEqualTo(Date value) {
            addCriterion("bill_creat_time <>", value, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeGreaterThan(Date value) {
            addCriterion("bill_creat_time >", value, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_creat_time >=", value, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeLessThan(Date value) {
            addCriterion("bill_creat_time <", value, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_creat_time <=", value, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeIn(List<Date> values) {
            addCriterion("bill_creat_time in", values, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeNotIn(List<Date> values) {
            addCriterion("bill_creat_time not in", values, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeBetween(Date value1, Date value2) {
            addCriterion("bill_creat_time between", value1, value2, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andBillCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_creat_time not between", value1, value2, "billCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends BaseGeneratedCriteria {

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