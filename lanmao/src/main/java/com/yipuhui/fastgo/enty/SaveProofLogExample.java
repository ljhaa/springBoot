package com.yipuhui.fastgo.enty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaveProofLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaveProofLogExample() {
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

        public Criteria andLenderNumIsNull() {
            addCriterion("lender_num is null");
            return (Criteria) this;
        }

        public Criteria andLenderNumIsNotNull() {
            addCriterion("lender_num is not null");
            return (Criteria) this;
        }

        public Criteria andLenderNumEqualTo(String value) {
            addCriterion("lender_num =", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumNotEqualTo(String value) {
            addCriterion("lender_num <>", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumGreaterThan(String value) {
            addCriterion("lender_num >", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumGreaterThanOrEqualTo(String value) {
            addCriterion("lender_num >=", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumLessThan(String value) {
            addCriterion("lender_num <", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumLessThanOrEqualTo(String value) {
            addCriterion("lender_num <=", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumLike(String value) {
            addCriterion("lender_num like", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumNotLike(String value) {
            addCriterion("lender_num not like", value, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumIn(List<String> values) {
            addCriterion("lender_num in", values, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumNotIn(List<String> values) {
            addCriterion("lender_num not in", values, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumBetween(String value1, String value2) {
            addCriterion("lender_num between", value1, value2, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andLenderNumNotBetween(String value1, String value2) {
            addCriterion("lender_num not between", value1, value2, "lenderNum");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeIsNull() {
            addCriterion("save_proof_type is null");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeIsNotNull() {
            addCriterion("save_proof_type is not null");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeEqualTo(String value) {
            addCriterion("save_proof_type =", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeNotEqualTo(String value) {
            addCriterion("save_proof_type <>", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeGreaterThan(String value) {
            addCriterion("save_proof_type >", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeGreaterThanOrEqualTo(String value) {
            addCriterion("save_proof_type >=", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeLessThan(String value) {
            addCriterion("save_proof_type <", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeLessThanOrEqualTo(String value) {
            addCriterion("save_proof_type <=", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeLike(String value) {
            addCriterion("save_proof_type like", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeNotLike(String value) {
            addCriterion("save_proof_type not like", value, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeIn(List<String> values) {
            addCriterion("save_proof_type in", values, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeNotIn(List<String> values) {
            addCriterion("save_proof_type not in", values, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeBetween(String value1, String value2) {
            addCriterion("save_proof_type between", value1, value2, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofTypeNotBetween(String value1, String value2) {
            addCriterion("save_proof_type not between", value1, value2, "saveProofType");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonIsNull() {
            addCriterion("save_proof_json is null");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonIsNotNull() {
            addCriterion("save_proof_json is not null");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonEqualTo(String value) {
            addCriterion("save_proof_json =", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonNotEqualTo(String value) {
            addCriterion("save_proof_json <>", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonGreaterThan(String value) {
            addCriterion("save_proof_json >", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonGreaterThanOrEqualTo(String value) {
            addCriterion("save_proof_json >=", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonLessThan(String value) {
            addCriterion("save_proof_json <", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonLessThanOrEqualTo(String value) {
            addCriterion("save_proof_json <=", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonLike(String value) {
            addCriterion("save_proof_json like", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonNotLike(String value) {
            addCriterion("save_proof_json not like", value, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonIn(List<String> values) {
            addCriterion("save_proof_json in", values, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonNotIn(List<String> values) {
            addCriterion("save_proof_json not in", values, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonBetween(String value1, String value2) {
            addCriterion("save_proof_json between", value1, value2, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofJsonNotBetween(String value1, String value2) {
            addCriterion("save_proof_json not between", value1, value2, "saveProofJson");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeIsNull() {
            addCriterion("save_proof_time is null");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeIsNotNull() {
            addCriterion("save_proof_time is not null");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeEqualTo(Date value) {
            addCriterion("save_proof_time =", value, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeNotEqualTo(Date value) {
            addCriterion("save_proof_time <>", value, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeGreaterThan(Date value) {
            addCriterion("save_proof_time >", value, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("save_proof_time >=", value, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeLessThan(Date value) {
            addCriterion("save_proof_time <", value, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeLessThanOrEqualTo(Date value) {
            addCriterion("save_proof_time <=", value, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeIn(List<Date> values) {
            addCriterion("save_proof_time in", values, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeNotIn(List<Date> values) {
            addCriterion("save_proof_time not in", values, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeBetween(Date value1, Date value2) {
            addCriterion("save_proof_time between", value1, value2, "saveProofTime");
            return (Criteria) this;
        }

        public Criteria andSaveProofTimeNotBetween(Date value1, Date value2) {
            addCriterion("save_proof_time not between", value1, value2, "saveProofTime");
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