package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UeAccountExample {
    /**
     * 主键字段
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    protected String pk_name = "ue_account_id";

    /**
     * 排序字段
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    protected String orderByClause;

    /**
     * 去重复
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    protected boolean distinct;

    /**
     * 条件集
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    protected List<Criteria> oredCriteria;

    public UeAccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setPk_name(String pk_name) {
        this.pk_name = pk_name;
    }

    public String getPk_name() {
        return pk_name;
    }

    /**
     * 排序字段
     * @ibatorgenerated 2016-05-06 14:30:59
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置去重复
     * @ibatorgenerated 2016-05-06 14:30:59
     */
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

    /**
     * 条件查询要先创建Criteria
     * @ibatorgenerated 2016-05-06 14:30:59
     */
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

    /**
     * 
     * 内类部，系统内部调用1
     * @ibatorgenerated 2016-05-06 14:30:59
     */
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

        public Criteria andUeAccountIdIsNull() {
            addCriterion("ue_account_id is null");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdIsNotNull() {
            addCriterion("ue_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdEqualTo(Integer value) {
            addCriterion("ue_account_id =", value, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdNotEqualTo(Integer value) {
            addCriterion("ue_account_id <>", value, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdGreaterThan(Integer value) {
            addCriterion("ue_account_id >", value, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ue_account_id >=", value, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdLessThan(Integer value) {
            addCriterion("ue_account_id <", value, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("ue_account_id <=", value, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdIn(List<Integer> values) {
            addCriterion("ue_account_id in", values, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdNotIn(List<Integer> values) {
            addCriterion("ue_account_id not in", values, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("ue_account_id between", value1, value2, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andUeAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ue_account_id not between", value1, value2, "ueAccountId");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNull() {
            addCriterion("available is null");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNotNull() {
            addCriterion("available is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableEqualTo(BigDecimal value) {
            addCriterion("available =", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotEqualTo(BigDecimal value) {
            addCriterion("available <>", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThan(BigDecimal value) {
            addCriterion("available >", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("available >=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThan(BigDecimal value) {
            addCriterion("available <", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("available <=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableIn(List<BigDecimal> values) {
            addCriterion("available in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotIn(List<BigDecimal> values) {
            addCriterion("available not in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available not between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdIsNull() {
            addCriterion("lender_login_id is null");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdIsNotNull() {
            addCriterion("lender_login_id is not null");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdEqualTo(Integer value) {
            addCriterion("lender_login_id =", value, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdNotEqualTo(Integer value) {
            addCriterion("lender_login_id <>", value, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdGreaterThan(Integer value) {
            addCriterion("lender_login_id >", value, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lender_login_id >=", value, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdLessThan(Integer value) {
            addCriterion("lender_login_id <", value, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdLessThanOrEqualTo(Integer value) {
            addCriterion("lender_login_id <=", value, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdIn(List<Integer> values) {
            addCriterion("lender_login_id in", values, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdNotIn(List<Integer> values) {
            addCriterion("lender_login_id not in", values, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdBetween(Integer value1, Integer value2) {
            addCriterion("lender_login_id between", value1, value2, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andLenderLoginIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lender_login_id not between", value1, value2, "lenderLoginId");
            return (Criteria) this;
        }

        public Criteria andExpectedIsNull() {
            addCriterion("expected is null");
            return (Criteria) this;
        }

        public Criteria andExpectedIsNotNull() {
            addCriterion("expected is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedEqualTo(BigDecimal value) {
            addCriterion("expected =", value, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedNotEqualTo(BigDecimal value) {
            addCriterion("expected <>", value, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedGreaterThan(BigDecimal value) {
            addCriterion("expected >", value, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expected >=", value, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedLessThan(BigDecimal value) {
            addCriterion("expected <", value, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expected <=", value, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedIn(List<BigDecimal> values) {
            addCriterion("expected in", values, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedNotIn(List<BigDecimal> values) {
            addCriterion("expected not in", values, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expected between", value1, value2, "expected");
            return (Criteria) this;
        }

        public Criteria andExpectedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expected not between", value1, value2, "expected");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * ue_account
     * @ibatorgenerated do_not_delete_during_merge 2016-05-06 14:30:59
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 内类部，系统内部调用1
     * @ibatorgenerated 2016-05-06 14:30:59
     */
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