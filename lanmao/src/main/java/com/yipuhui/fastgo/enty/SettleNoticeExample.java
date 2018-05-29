package com.yipuhui.fastgo.enty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class SettleNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettleNoticeExample() {
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

        public Criteria andSerlnumIsNull() {
            addCriterion("serlNum is null");
            return (Criteria) this;
        }

        public Criteria andSerlnumIsNotNull() {
            addCriterion("serlNum is not null");
            return (Criteria) this;
        }

        public Criteria andSerlnumEqualTo(String value) {
            addCriterion("serlNum =", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumNotEqualTo(String value) {
            addCriterion("serlNum <>", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumGreaterThan(String value) {
            addCriterion("serlNum >", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumGreaterThanOrEqualTo(String value) {
            addCriterion("serlNum >=", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumLessThan(String value) {
            addCriterion("serlNum <", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumLessThanOrEqualTo(String value) {
            addCriterion("serlNum <=", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumLike(String value) {
            addCriterion("serlNum like", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumNotLike(String value) {
            addCriterion("serlNum not like", value, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumIn(List<String> values) {
            addCriterion("serlNum in", values, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumNotIn(List<String> values) {
            addCriterion("serlNum not in", values, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumBetween(String value1, String value2) {
            addCriterion("serlNum between", value1, value2, "serlnum");
            return (Criteria) this;
        }

        public Criteria andSerlnumNotBetween(String value1, String value2) {
            addCriterion("serlNum not between", value1, value2, "serlnum");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNull() {
            addCriterion("idNo is null");
            return (Criteria) this;
        }

        public Criteria andIdnoIsNotNull() {
            addCriterion("idNo is not null");
            return (Criteria) this;
        }

        public Criteria andIdnoEqualTo(String value) {
            addCriterion("idNo =", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotEqualTo(String value) {
            addCriterion("idNo <>", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThan(String value) {
            addCriterion("idNo >", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoGreaterThanOrEqualTo(String value) {
            addCriterion("idNo >=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThan(String value) {
            addCriterion("idNo <", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLessThanOrEqualTo(String value) {
            addCriterion("idNo <=", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoLike(String value) {
            addCriterion("idNo like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotLike(String value) {
            addCriterion("idNo not like", value, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoIn(List<String> values) {
            addCriterion("idNo in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotIn(List<String> values) {
            addCriterion("idNo not in", values, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoBetween(String value1, String value2) {
            addCriterion("idNo between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andIdnoNotBetween(String value1, String value2) {
            addCriterion("idNo not between", value1, value2, "idno");
            return (Criteria) this;
        }

        public Criteria andAccnumIsNull() {
            addCriterion("accNum is null");
            return (Criteria) this;
        }

        public Criteria andAccnumIsNotNull() {
            addCriterion("accNum is not null");
            return (Criteria) this;
        }

        public Criteria andAccnumEqualTo(String value) {
            addCriterion("accNum =", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumNotEqualTo(String value) {
            addCriterion("accNum <>", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumGreaterThan(String value) {
            addCriterion("accNum >", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumGreaterThanOrEqualTo(String value) {
            addCriterion("accNum >=", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumLessThan(String value) {
            addCriterion("accNum <", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumLessThanOrEqualTo(String value) {
            addCriterion("accNum <=", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumLike(String value) {
            addCriterion("accNum like", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumNotLike(String value) {
            addCriterion("accNum not like", value, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumIn(List<String> values) {
            addCriterion("accNum in", values, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumNotIn(List<String> values) {
            addCriterion("accNum not in", values, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumBetween(String value1, String value2) {
            addCriterion("accNum between", value1, value2, "accnum");
            return (Criteria) this;
        }

        public Criteria andAccnumNotBetween(String value1, String value2) {
            addCriterion("accNum not between", value1, value2, "accnum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNull() {
            addCriterion("noticeTime is null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNotNull() {
            addCriterion("noticeTime is not null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeEqualTo(Date value) {
            addCriterion("noticeTime =", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotEqualTo(Date value) {
            addCriterion("noticeTime <>", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThan(Date value) {
            addCriterion("noticeTime >", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("noticeTime >=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThan(Date value) {
            addCriterion("noticeTime <", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThanOrEqualTo(Date value) {
            addCriterion("noticeTime <=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIn(List<Date> values) {
            addCriterion("noticeTime in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotIn(List<Date> values) {
            addCriterion("noticeTime not in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeBetween(Date value1, Date value2) {
            addCriterion("noticeTime between", value1, value2, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotBetween(Date value1, Date value2) {
            addCriterion("noticeTime not between", value1, value2, "noticetime");
            return (Criteria) this;
        }

        public Criteria andClientcodeIsNull() {
            addCriterion("clientCode is null");
            return (Criteria) this;
        }

        public Criteria andClientcodeIsNotNull() {
            addCriterion("clientCode is not null");
            return (Criteria) this;
        }

        public Criteria andClientcodeEqualTo(String value) {
            addCriterion("clientCode =", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeNotEqualTo(String value) {
            addCriterion("clientCode <>", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeGreaterThan(String value) {
            addCriterion("clientCode >", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeGreaterThanOrEqualTo(String value) {
            addCriterion("clientCode >=", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeLessThan(String value) {
            addCriterion("clientCode <", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeLessThanOrEqualTo(String value) {
            addCriterion("clientCode <=", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeLike(String value) {
            addCriterion("clientCode like", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeNotLike(String value) {
            addCriterion("clientCode not like", value, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeIn(List<String> values) {
            addCriterion("clientCode in", values, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeNotIn(List<String> values) {
            addCriterion("clientCode not in", values, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeBetween(String value1, String value2) {
            addCriterion("clientCode between", value1, value2, "clientcode");
            return (Criteria) this;
        }

        public Criteria andClientcodeNotBetween(String value1, String value2) {
            addCriterion("clientCode not between", value1, value2, "clientcode");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNull() {
            addCriterion("serviceType is null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNotNull() {
            addCriterion("serviceType is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypeEqualTo(String value) {
            addCriterion("serviceType =", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotEqualTo(String value) {
            addCriterion("serviceType <>", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThan(String value) {
            addCriterion("serviceType >", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("serviceType >=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThan(String value) {
            addCriterion("serviceType <", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThanOrEqualTo(String value) {
            addCriterion("serviceType <=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLike(String value) {
            addCriterion("serviceType like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotLike(String value) {
            addCriterion("serviceType not like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeIn(List<String> values) {
            addCriterion("serviceType in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotIn(List<String> values) {
            addCriterion("serviceType not in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeBetween(String value1, String value2) {
            addCriterion("serviceType between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotBetween(String value1, String value2) {
            addCriterion("serviceType not between", value1, value2, "servicetype");
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