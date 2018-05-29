package com.yipuhui.fastgo.enty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
public class SettleZzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettleZzExample() {
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

        public Criteria andOperationcodeIsNull() {
            addCriterion("operationCode is null");
            return (Criteria) this;
        }

        public Criteria andOperationcodeIsNotNull() {
            addCriterion("operationCode is not null");
            return (Criteria) this;
        }

        public Criteria andOperationcodeEqualTo(String value) {
            addCriterion("operationCode =", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeNotEqualTo(String value) {
            addCriterion("operationCode <>", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeGreaterThan(String value) {
            addCriterion("operationCode >", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("operationCode >=", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeLessThan(String value) {
            addCriterion("operationCode <", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeLessThanOrEqualTo(String value) {
            addCriterion("operationCode <=", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeLike(String value) {
            addCriterion("operationCode like", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeNotLike(String value) {
            addCriterion("operationCode not like", value, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeIn(List<String> values) {
            addCriterion("operationCode in", values, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeNotIn(List<String> values) {
            addCriterion("operationCode not in", values, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeBetween(String value1, String value2) {
            addCriterion("operationCode between", value1, value2, "operationcode");
            return (Criteria) this;
        }

        public Criteria andOperationcodeNotBetween(String value1, String value2) {
            addCriterion("operationCode not between", value1, value2, "operationcode");
            return (Criteria) this;
        }

        public Criteria andBusplatformIsNull() {
            addCriterion("busPlatform is null");
            return (Criteria) this;
        }

        public Criteria andBusplatformIsNotNull() {
            addCriterion("busPlatform is not null");
            return (Criteria) this;
        }

        public Criteria andBusplatformEqualTo(String value) {
            addCriterion("busPlatform =", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformNotEqualTo(String value) {
            addCriterion("busPlatform <>", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformGreaterThan(String value) {
            addCriterion("busPlatform >", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformGreaterThanOrEqualTo(String value) {
            addCriterion("busPlatform >=", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformLessThan(String value) {
            addCriterion("busPlatform <", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformLessThanOrEqualTo(String value) {
            addCriterion("busPlatform <=", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformLike(String value) {
            addCriterion("busPlatform like", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformNotLike(String value) {
            addCriterion("busPlatform not like", value, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformIn(List<String> values) {
            addCriterion("busPlatform in", values, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformNotIn(List<String> values) {
            addCriterion("busPlatform not in", values, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformBetween(String value1, String value2) {
            addCriterion("busPlatform between", value1, value2, "busplatform");
            return (Criteria) this;
        }

        public Criteria andBusplatformNotBetween(String value1, String value2) {
            addCriterion("busPlatform not between", value1, value2, "busplatform");
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

        public Criteria andRealserlnumIsNull() {
            addCriterion("realSerlNum is null");
            return (Criteria) this;
        }

        public Criteria andRealserlnumIsNotNull() {
            addCriterion("realSerlNum is not null");
            return (Criteria) this;
        }

        public Criteria andRealserlnumEqualTo(String value) {
            addCriterion("realSerlNum =", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumNotEqualTo(String value) {
            addCriterion("realSerlNum <>", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumGreaterThan(String value) {
            addCriterion("realSerlNum >", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumGreaterThanOrEqualTo(String value) {
            addCriterion("realSerlNum >=", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumLessThan(String value) {
            addCriterion("realSerlNum <", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumLessThanOrEqualTo(String value) {
            addCriterion("realSerlNum <=", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumLike(String value) {
            addCriterion("realSerlNum like", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumNotLike(String value) {
            addCriterion("realSerlNum not like", value, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumIn(List<String> values) {
            addCriterion("realSerlNum in", values, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumNotIn(List<String> values) {
            addCriterion("realSerlNum not in", values, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumBetween(String value1, String value2) {
            addCriterion("realSerlNum between", value1, value2, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andRealserlnumNotBetween(String value1, String value2) {
            addCriterion("realSerlNum not between", value1, value2, "realserlnum");
            return (Criteria) this;
        }

        public Criteria andOutuserIsNull() {
            addCriterion("outUser is null");
            return (Criteria) this;
        }

        public Criteria andOutuserIsNotNull() {
            addCriterion("outUser is not null");
            return (Criteria) this;
        }

        public Criteria andOutuserEqualTo(String value) {
            addCriterion("outUser =", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserNotEqualTo(String value) {
            addCriterion("outUser <>", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserGreaterThan(String value) {
            addCriterion("outUser >", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserGreaterThanOrEqualTo(String value) {
            addCriterion("outUser >=", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserLessThan(String value) {
            addCriterion("outUser <", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserLessThanOrEqualTo(String value) {
            addCriterion("outUser <=", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserLike(String value) {
            addCriterion("outUser like", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserNotLike(String value) {
            addCriterion("outUser not like", value, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserIn(List<String> values) {
            addCriterion("outUser in", values, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserNotIn(List<String> values) {
            addCriterion("outUser not in", values, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserBetween(String value1, String value2) {
            addCriterion("outUser between", value1, value2, "outuser");
            return (Criteria) this;
        }

        public Criteria andOutuserNotBetween(String value1, String value2) {
            addCriterion("outUser not between", value1, value2, "outuser");
            return (Criteria) this;
        }

        public Criteria andInuserIsNull() {
            addCriterion("inUser is null");
            return (Criteria) this;
        }

        public Criteria andInuserIsNotNull() {
            addCriterion("inUser is not null");
            return (Criteria) this;
        }

        public Criteria andInuserEqualTo(String value) {
            addCriterion("inUser =", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotEqualTo(String value) {
            addCriterion("inUser <>", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThan(String value) {
            addCriterion("inUser >", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThanOrEqualTo(String value) {
            addCriterion("inUser >=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThan(String value) {
            addCriterion("inUser <", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThanOrEqualTo(String value) {
            addCriterion("inUser <=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLike(String value) {
            addCriterion("inUser like", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotLike(String value) {
            addCriterion("inUser not like", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserIn(List<String> values) {
            addCriterion("inUser in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotIn(List<String> values) {
            addCriterion("inUser not in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserBetween(String value1, String value2) {
            addCriterion("inUser between", value1, value2, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotBetween(String value1, String value2) {
            addCriterion("inUser not between", value1, value2, "inuser");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeIsNull() {
            addCriterion("outUserFee is null");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeIsNotNull() {
            addCriterion("outUserFee is not null");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeEqualTo(BigDecimal value) {
            addCriterion("outUserFee =", value, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeNotEqualTo(BigDecimal value) {
            addCriterion("outUserFee <>", value, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeGreaterThan(BigDecimal value) {
            addCriterion("outUserFee >", value, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("outUserFee >=", value, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeLessThan(BigDecimal value) {
            addCriterion("outUserFee <", value, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("outUserFee <=", value, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeIn(List<BigDecimal> values) {
            addCriterion("outUserFee in", values, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeNotIn(List<BigDecimal> values) {
            addCriterion("outUserFee not in", values, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("outUserFee between", value1, value2, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andOutuserfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("outUserFee not between", value1, value2, "outuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeIsNull() {
            addCriterion("inUserFee is null");
            return (Criteria) this;
        }

        public Criteria andInuserfeeIsNotNull() {
            addCriterion("inUserFee is not null");
            return (Criteria) this;
        }

        public Criteria andInuserfeeEqualTo(BigDecimal value) {
            addCriterion("inUserFee =", value, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeNotEqualTo(BigDecimal value) {
            addCriterion("inUserFee <>", value, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeGreaterThan(BigDecimal value) {
            addCriterion("inUserFee >", value, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("inUserFee >=", value, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeLessThan(BigDecimal value) {
            addCriterion("inUserFee <", value, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("inUserFee <=", value, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeIn(List<BigDecimal> values) {
            addCriterion("inUserFee in", values, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeNotIn(List<BigDecimal> values) {
            addCriterion("inUserFee not in", values, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inUserFee between", value1, value2, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andInuserfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inUserFee not between", value1, value2, "inuserfee");
            return (Criteria) this;
        }

        public Criteria andThiplatformIsNull() {
            addCriterion("thiPlatform is null");
            return (Criteria) this;
        }

        public Criteria andThiplatformIsNotNull() {
            addCriterion("thiPlatform is not null");
            return (Criteria) this;
        }

        public Criteria andThiplatformEqualTo(String value) {
            addCriterion("thiPlatform =", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformNotEqualTo(String value) {
            addCriterion("thiPlatform <>", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformGreaterThan(String value) {
            addCriterion("thiPlatform >", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformGreaterThanOrEqualTo(String value) {
            addCriterion("thiPlatform >=", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformLessThan(String value) {
            addCriterion("thiPlatform <", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformLessThanOrEqualTo(String value) {
            addCriterion("thiPlatform <=", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformLike(String value) {
            addCriterion("thiPlatform like", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformNotLike(String value) {
            addCriterion("thiPlatform not like", value, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformIn(List<String> values) {
            addCriterion("thiPlatform in", values, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformNotIn(List<String> values) {
            addCriterion("thiPlatform not in", values, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformBetween(String value1, String value2) {
            addCriterion("thiPlatform between", value1, value2, "thiplatform");
            return (Criteria) this;
        }

        public Criteria andThiplatformNotBetween(String value1, String value2) {
            addCriterion("thiPlatform not between", value1, value2, "thiplatform");
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

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNull() {
            addCriterion("overTime is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNotNull() {
            addCriterion("overTime is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeEqualTo(Date value) {
            addCriterion("overTime =", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotEqualTo(Date value) {
            addCriterion("overTime <>", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThan(Date value) {
            addCriterion("overTime >", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("overTime >=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThan(Date value) {
            addCriterion("overTime <", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThanOrEqualTo(Date value) {
            addCriterion("overTime <=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeIn(List<Date> values) {
            addCriterion("overTime in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotIn(List<Date> values) {
            addCriterion("overTime not in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeBetween(Date value1, Date value2) {
            addCriterion("overTime between", value1, value2, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotBetween(Date value1, Date value2) {
            addCriterion("overTime not between", value1, value2, "overtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addTime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addtime");
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