/*      */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class FinancWarehouseCriteria
/*      */ {
/*      */   protected String orderByClause;
/*      */   protected boolean distinct;
/*      */   protected List<Criteria> oredCriteria;
/*      */ 
/*      */   public FinancWarehouseCriteria()
/*      */   {
/*   30 */     this.oredCriteria = new ArrayList();
/*      */   }
/*      */ 
/*      */   protected FinancWarehouseCriteria(FinancWarehouseCriteria example)
/*      */   {
/*   37 */     this.orderByClause = example.orderByClause;
/*   38 */     this.oredCriteria = example.oredCriteria;
/*   39 */     this.distinct = example.distinct;
/*      */   }
/*      */ 
/*      */   public void setOrderByClause(String orderByClause)
/*      */   {
/*   46 */     this.orderByClause = orderByClause;
/*      */   }
/*      */ 
/*      */   public String getOrderByClause()
/*      */   {
/*   53 */     return this.orderByClause;
/*      */   }
/*      */ 
/*      */   public void setDistinct(boolean distinct)
/*      */   {
/*   60 */     this.distinct = distinct;
/*      */   }
/*      */ 
/*      */   public boolean isDistinct()
/*      */   {
/*   67 */     return this.distinct;
/*      */   }
/*      */ 
/*      */   public List<Criteria> getOredCriteria()
/*      */   {
/*   74 */     return this.oredCriteria;
/*      */   }
/*      */ 
/*      */   public void or(Criteria criteria)
/*      */   {
/*   81 */     this.oredCriteria.add(criteria);
/*      */   }
/*      */ 
/*      */   public Criteria or()
/*      */   {
/*   88 */     Criteria criteria = createCriteriaInternal();
/*   89 */     this.oredCriteria.add(criteria);
/*   90 */     return criteria;
/*      */   }
/*      */ 
/*      */   public Criteria createCriteria()
/*      */   {
/*   97 */     Criteria criteria = createCriteriaInternal();
/*   98 */     if (this.oredCriteria.size() == 0) {
/*   99 */       this.oredCriteria.add(criteria);
/*      */     }
/*  101 */     return criteria;
/*      */   }
/*      */ 
/*      */   protected Criteria createCriteriaInternal()
/*      */   {
/*  108 */     Criteria criteria = new Criteria();
/*  109 */     return criteria;
/*      */   }
/*      */ 
/*      */   public void clear()
/*      */   {
/*  116 */     this.oredCriteria.clear();
/*  117 */     this.orderByClause = null;
/*  118 */     this.distinct = false;
/*      */   }
/*      */ 
/*      */   public static class Criteria extends FinancWarehouseCriteria.GeneratedCriteria {
/*      */   }
/*      */ 
/*      */   protected static abstract class GeneratedCriteria {
/*      */     protected List<String> criteriaWithoutValue;
/*      */     protected List<Map<String, Object>> criteriaWithSingleValue;
/*      */     protected List<Map<String, Object>> criteriaWithListValue;
/*      */     protected List<Map<String, Object>> criteriaWithBetweenValue;
/*      */ 
/*      */     protected GeneratedCriteria() {
/*  135 */       this.criteriaWithoutValue = new ArrayList();
/*  136 */       this.criteriaWithSingleValue = new ArrayList();
/*  137 */       this.criteriaWithListValue = new ArrayList();
/*  138 */       this.criteriaWithBetweenValue = new ArrayList();
/*      */     }
/*      */ 
/*      */     public boolean isValid() {
/*  142 */       return (this.criteriaWithoutValue.size() > 0) || (this.criteriaWithSingleValue.size() > 0) || (this.criteriaWithListValue.size() > 0) || (this.criteriaWithBetweenValue.size() > 0);
/*      */     }
/*      */ 
/*      */     public List<String> getCriteriaWithoutValue()
/*      */     {
/*  149 */       return this.criteriaWithoutValue;
/*      */     }
/*      */ 
/*      */     public List<Map<String, Object>> getCriteriaWithSingleValue() {
/*  153 */       return this.criteriaWithSingleValue;
/*      */     }
/*      */ 
/*      */     public List<Map<String, Object>> getCriteriaWithListValue() {
/*  157 */       return this.criteriaWithListValue;
/*      */     }
/*      */ 
/*      */     public List<Map<String, Object>> getCriteriaWithBetweenValue() {
/*  161 */       return this.criteriaWithBetweenValue;
/*      */     }
/*      */ 
/*      */     protected void addCriterion(String condition) {
/*  165 */       if (condition == null) {
/*  166 */         throw new RuntimeException("Value for condition cannot be null");
/*      */       }
/*  168 */       this.criteriaWithoutValue.add(condition);
/*      */     }
/*      */ 
/*      */     protected void addCriterion(String condition, Object value, String property) {
/*  172 */       if (value == null) {
/*  173 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*      */       }
/*  175 */       Map map = new HashMap();
/*  176 */       map.put("condition", condition);
/*  177 */       map.put("value", value);
/*  178 */       this.criteriaWithSingleValue.add(map);
/*      */     }
/*      */ 
/*      */     protected void addCriterion(String condition, List<? extends Object> values, String property) {
/*  182 */       if ((values == null) || (values.size() == 0)) {
/*  183 */         throw new RuntimeException("Value list for " + property + " cannot be null or empty");
/*      */       }
/*  185 */       Map map = new HashMap();
/*  186 */       map.put("condition", condition);
/*  187 */       map.put("values", values);
/*  188 */       this.criteriaWithListValue.add(map);
/*      */     }
/*      */ 
/*      */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/*  192 */       if ((value1 == null) || (value2 == null)) {
/*  193 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*      */       }
/*  195 */       List list = new ArrayList();
/*  196 */       list.add(value1);
/*  197 */       list.add(value2);
/*  198 */       Map map = new HashMap();
/*  199 */       map.put("condition", condition);
/*  200 */       map.put("values", list);
/*  201 */       this.criteriaWithBetweenValue.add(map);
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdIsNull() {
/*  205 */       addCriterion("ID is null");
/*  206 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdIsNotNull() {
/*  210 */       addCriterion("ID is not null");
/*  211 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdEqualTo(Long value) {
/*  215 */       addCriterion("ID =", value, "id");
/*  216 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdNotEqualTo(Long value) {
/*  220 */       addCriterion("ID <>", value, "id");
/*  221 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdGreaterThan(Long value) {
/*  225 */       addCriterion("ID >", value, "id");
/*  226 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/*  230 */       addCriterion("ID >=", value, "id");
/*  231 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdLessThan(Long value) {
/*  235 */       addCriterion("ID <", value, "id");
/*  236 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/*  240 */       addCriterion("ID <=", value, "id");
/*  241 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdIn(List<Long> values) {
/*  245 */       addCriterion("ID in", values, "id");
/*  246 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdNotIn(List<Long> values) {
/*  250 */       addCriterion("ID not in", values, "id");
/*  251 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdBetween(Long value1, Long value2) {
/*  255 */       addCriterion("ID between", value1, value2, "id");
/*  256 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/*  260 */       addCriterion("ID not between", value1, value2, "id");
/*  261 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdIsNull() {
/*  265 */       addCriterion("USER_ACCOUNT_ID is null");
/*  266 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdIsNotNull() {
/*  270 */       addCriterion("USER_ACCOUNT_ID is not null");
/*  271 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdEqualTo(Long value) {
/*  275 */       addCriterion("USER_ACCOUNT_ID =", value, "userAccountId");
/*  276 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdNotEqualTo(Long value) {
/*  280 */       addCriterion("USER_ACCOUNT_ID <>", value, "userAccountId");
/*  281 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdGreaterThan(Long value) {
/*  285 */       addCriterion("USER_ACCOUNT_ID >", value, "userAccountId");
/*  286 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdGreaterThanOrEqualTo(Long value) {
/*  290 */       addCriterion("USER_ACCOUNT_ID >=", value, "userAccountId");
/*  291 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdLessThan(Long value) {
/*  295 */       addCriterion("USER_ACCOUNT_ID <", value, "userAccountId");
/*  296 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdLessThanOrEqualTo(Long value) {
/*  300 */       addCriterion("USER_ACCOUNT_ID <=", value, "userAccountId");
/*  301 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdIn(List<Long> values) {
/*  305 */       addCriterion("USER_ACCOUNT_ID in", values, "userAccountId");
/*  306 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdNotIn(List<Long> values) {
/*  310 */       addCriterion("USER_ACCOUNT_ID not in", values, "userAccountId");
/*  311 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdBetween(Long value1, Long value2) {
/*  315 */       addCriterion("USER_ACCOUNT_ID between", value1, value2, "userAccountId");
/*  316 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andUserAccountIdNotBetween(Long value1, Long value2) {
/*  320 */       addCriterion("USER_ACCOUNT_ID not between", value1, value2, "userAccountId");
/*  321 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdIsNull() {
/*  325 */       addCriterion("DEPOSITORY_ID is null");
/*  326 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdIsNotNull() {
/*  330 */       addCriterion("DEPOSITORY_ID is not null");
/*  331 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdEqualTo(Long value) {
/*  335 */       addCriterion("DEPOSITORY_ID =", value, "depositoryId");
/*  336 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdNotEqualTo(Long value) {
/*  340 */       addCriterion("DEPOSITORY_ID <>", value, "depositoryId");
/*  341 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdGreaterThan(Long value) {
/*  345 */       addCriterion("DEPOSITORY_ID >", value, "depositoryId");
/*  346 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdGreaterThanOrEqualTo(Long value) {
/*  350 */       addCriterion("DEPOSITORY_ID >=", value, "depositoryId");
/*  351 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdLessThan(Long value) {
/*  355 */       addCriterion("DEPOSITORY_ID <", value, "depositoryId");
/*  356 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdLessThanOrEqualTo(Long value) {
/*  360 */       addCriterion("DEPOSITORY_ID <=", value, "depositoryId");
/*  361 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdIn(List<Long> values) {
/*  365 */       addCriterion("DEPOSITORY_ID in", values, "depositoryId");
/*  366 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdNotIn(List<Long> values) {
/*  370 */       addCriterion("DEPOSITORY_ID not in", values, "depositoryId");
/*  371 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdBetween(Long value1, Long value2) {
/*  375 */       addCriterion("DEPOSITORY_ID between", value1, value2, "depositoryId");
/*  376 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andDepositoryIdNotBetween(Long value1, Long value2) {
/*  380 */       addCriterion("DEPOSITORY_ID not between", value1, value2, "depositoryId");
/*  381 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoIsNull() {
/*  385 */       addCriterion("WAREHOUSE_NO is null");
/*  386 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoIsNotNull() {
/*  390 */       addCriterion("WAREHOUSE_NO is not null");
/*  391 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoEqualTo(String value) {
/*  395 */       addCriterion("WAREHOUSE_NO =", value, "warehouseNo");
/*  396 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoNotEqualTo(String value) {
/*  400 */       addCriterion("WAREHOUSE_NO <>", value, "warehouseNo");
/*  401 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoGreaterThan(String value) {
/*  405 */       addCriterion("WAREHOUSE_NO >", value, "warehouseNo");
/*  406 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoGreaterThanOrEqualTo(String value) {
/*  410 */       addCriterion("WAREHOUSE_NO >=", value, "warehouseNo");
/*  411 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoLessThan(String value) {
/*  415 */       addCriterion("WAREHOUSE_NO <", value, "warehouseNo");
/*  416 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoLessThanOrEqualTo(String value) {
/*  420 */       addCriterion("WAREHOUSE_NO <=", value, "warehouseNo");
/*  421 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoLike(String value) {
/*  425 */       addCriterion("WAREHOUSE_NO like", value, "warehouseNo");
/*  426 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoNotLike(String value) {
/*  430 */       addCriterion("WAREHOUSE_NO not like", value, "warehouseNo");
/*  431 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoIn(List<String> values) {
/*  435 */       addCriterion("WAREHOUSE_NO in", values, "warehouseNo");
/*  436 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoNotIn(List<String> values) {
/*  440 */       addCriterion("WAREHOUSE_NO not in", values, "warehouseNo");
/*  441 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoBetween(String value1, String value2) {
/*  445 */       addCriterion("WAREHOUSE_NO between", value1, value2, "warehouseNo");
/*  446 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andWarehouseNoNotBetween(String value1, String value2) {
/*  450 */       addCriterion("WAREHOUSE_NO not between", value1, value2, "warehouseNo");
/*  451 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameIsNull() {
/*  455 */       addCriterion("COMP_NAME is null");
/*  456 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameIsNotNull() {
/*  460 */       addCriterion("COMP_NAME is not null");
/*  461 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameEqualTo(String value) {
/*  465 */       addCriterion("COMP_NAME =", value, "compName");
/*  466 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameNotEqualTo(String value) {
/*  470 */       addCriterion("COMP_NAME <>", value, "compName");
/*  471 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameGreaterThan(String value) {
/*  475 */       addCriterion("COMP_NAME >", value, "compName");
/*  476 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameGreaterThanOrEqualTo(String value) {
/*  480 */       addCriterion("COMP_NAME >=", value, "compName");
/*  481 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameLessThan(String value) {
/*  485 */       addCriterion("COMP_NAME <", value, "compName");
/*  486 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameLessThanOrEqualTo(String value) {
/*  490 */       addCriterion("COMP_NAME <=", value, "compName");
/*  491 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameLike(String value) {
/*  495 */       addCriterion("COMP_NAME like", value, "compName");
/*  496 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameNotLike(String value) {
/*  500 */       addCriterion("COMP_NAME not like", value, "compName");
/*  501 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameIn(List<String> values) {
/*  505 */       addCriterion("COMP_NAME in", values, "compName");
/*  506 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameNotIn(List<String> values) {
/*  510 */       addCriterion("COMP_NAME not in", values, "compName");
/*  511 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameBetween(String value1, String value2) {
/*  515 */       addCriterion("COMP_NAME between", value1, value2, "compName");
/*  516 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCompNameNotBetween(String value1, String value2) {
/*  520 */       addCriterion("COMP_NAME not between", value1, value2, "compName");
/*  521 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardIsNull() {
/*  525 */       addCriterion("LOSS_STANDARD is null");
/*  526 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardIsNotNull() {
/*  530 */       addCriterion("LOSS_STANDARD is not null");
/*  531 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardEqualTo(String value) {
/*  535 */       addCriterion("LOSS_STANDARD =", value, "lossStandard");
/*  536 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardNotEqualTo(String value) {
/*  540 */       addCriterion("LOSS_STANDARD <>", value, "lossStandard");
/*  541 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardGreaterThan(String value) {
/*  545 */       addCriterion("LOSS_STANDARD >", value, "lossStandard");
/*  546 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardGreaterThanOrEqualTo(String value) {
/*  550 */       addCriterion("LOSS_STANDARD >=", value, "lossStandard");
/*  551 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardLessThan(String value) {
/*  555 */       addCriterion("LOSS_STANDARD <", value, "lossStandard");
/*  556 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardLessThanOrEqualTo(String value) {
/*  560 */       addCriterion("LOSS_STANDARD <=", value, "lossStandard");
/*  561 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardLike(String value) {
/*  565 */       addCriterion("LOSS_STANDARD like", value, "lossStandard");
/*  566 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardNotLike(String value) {
/*  570 */       addCriterion("LOSS_STANDARD not like", value, "lossStandard");
/*  571 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardIn(List<String> values) {
/*  575 */       addCriterion("LOSS_STANDARD in", values, "lossStandard");
/*  576 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardNotIn(List<String> values) {
/*  580 */       addCriterion("LOSS_STANDARD not in", values, "lossStandard");
/*  581 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardBetween(String value1, String value2) {
/*  585 */       addCriterion("LOSS_STANDARD between", value1, value2, "lossStandard");
/*  586 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLossStandardNotBetween(String value1, String value2) {
/*  590 */       addCriterion("LOSS_STANDARD not between", value1, value2, "lossStandard");
/*  591 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoIsNull() {
/*  595 */       addCriterion("INSURANCE_NO is null");
/*  596 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoIsNotNull() {
/*  600 */       addCriterion("INSURANCE_NO is not null");
/*  601 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoEqualTo(String value) {
/*  605 */       addCriterion("INSURANCE_NO =", value, "insuranceNo");
/*  606 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoNotEqualTo(String value) {
/*  610 */       addCriterion("INSURANCE_NO <>", value, "insuranceNo");
/*  611 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoGreaterThan(String value) {
/*  615 */       addCriterion("INSURANCE_NO >", value, "insuranceNo");
/*  616 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoGreaterThanOrEqualTo(String value) {
/*  620 */       addCriterion("INSURANCE_NO >=", value, "insuranceNo");
/*  621 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoLessThan(String value) {
/*  625 */       addCriterion("INSURANCE_NO <", value, "insuranceNo");
/*  626 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoLessThanOrEqualTo(String value) {
/*  630 */       addCriterion("INSURANCE_NO <=", value, "insuranceNo");
/*  631 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoLike(String value) {
/*  635 */       addCriterion("INSURANCE_NO like", value, "insuranceNo");
/*  636 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoNotLike(String value) {
/*  640 */       addCriterion("INSURANCE_NO not like", value, "insuranceNo");
/*  641 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoIn(List<String> values) {
/*  645 */       addCriterion("INSURANCE_NO in", values, "insuranceNo");
/*  646 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoNotIn(List<String> values) {
/*  650 */       addCriterion("INSURANCE_NO not in", values, "insuranceNo");
/*  651 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoBetween(String value1, String value2) {
/*  655 */       addCriterion("INSURANCE_NO between", value1, value2, "insuranceNo");
/*  656 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNoNotBetween(String value1, String value2) {
/*  660 */       addCriterion("INSURANCE_NO not between", value1, value2, "insuranceNo");
/*  661 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameIsNull() {
/*  665 */       addCriterion("INSURANCE_NAME is null");
/*  666 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameIsNotNull() {
/*  670 */       addCriterion("INSURANCE_NAME is not null");
/*  671 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameEqualTo(String value) {
/*  675 */       addCriterion("INSURANCE_NAME =", value, "insuranceName");
/*  676 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameNotEqualTo(String value) {
/*  680 */       addCriterion("INSURANCE_NAME <>", value, "insuranceName");
/*  681 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameGreaterThan(String value) {
/*  685 */       addCriterion("INSURANCE_NAME >", value, "insuranceName");
/*  686 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameGreaterThanOrEqualTo(String value) {
/*  690 */       addCriterion("INSURANCE_NAME >=", value, "insuranceName");
/*  691 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameLessThan(String value) {
/*  695 */       addCriterion("INSURANCE_NAME <", value, "insuranceName");
/*  696 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameLessThanOrEqualTo(String value) {
/*  700 */       addCriterion("INSURANCE_NAME <=", value, "insuranceName");
/*  701 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameLike(String value) {
/*  705 */       addCriterion("INSURANCE_NAME like", value, "insuranceName");
/*  706 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameNotLike(String value) {
/*  710 */       addCriterion("INSURANCE_NAME not like", value, "insuranceName");
/*  711 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameIn(List<String> values) {
/*  715 */       addCriterion("INSURANCE_NAME in", values, "insuranceName");
/*  716 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameNotIn(List<String> values) {
/*  720 */       addCriterion("INSURANCE_NAME not in", values, "insuranceName");
/*  721 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameBetween(String value1, String value2) {
/*  725 */       addCriterion("INSURANCE_NAME between", value1, value2, "insuranceName");
/*  726 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceNameNotBetween(String value1, String value2) {
/*  730 */       addCriterion("INSURANCE_NAME not between", value1, value2, "insuranceName");
/*  731 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountIsNull() {
/*  735 */       addCriterion("INSURANCE_AMOUNT is null");
/*  736 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountIsNotNull() {
/*  740 */       addCriterion("INSURANCE_AMOUNT is not null");
/*  741 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountEqualTo(Long value) {
/*  745 */       addCriterion("INSURANCE_AMOUNT =", value, "insuranceAmount");
/*  746 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountNotEqualTo(Long value) {
/*  750 */       addCriterion("INSURANCE_AMOUNT <>", value, "insuranceAmount");
/*  751 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountGreaterThan(Long value) {
/*  755 */       addCriterion("INSURANCE_AMOUNT >", value, "insuranceAmount");
/*  756 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountGreaterThanOrEqualTo(Long value) {
/*  760 */       addCriterion("INSURANCE_AMOUNT >=", value, "insuranceAmount");
/*  761 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountLessThan(Long value) {
/*  765 */       addCriterion("INSURANCE_AMOUNT <", value, "insuranceAmount");
/*  766 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountLessThanOrEqualTo(Long value) {
/*  770 */       addCriterion("INSURANCE_AMOUNT <=", value, "insuranceAmount");
/*  771 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountIn(List<Long> values) {
/*  775 */       addCriterion("INSURANCE_AMOUNT in", values, "insuranceAmount");
/*  776 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountNotIn(List<Long> values) {
/*  780 */       addCriterion("INSURANCE_AMOUNT not in", values, "insuranceAmount");
/*  781 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountBetween(Long value1, Long value2) {
/*  785 */       addCriterion("INSURANCE_AMOUNT between", value1, value2, "insuranceAmount");
/*  786 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceAmountNotBetween(Long value1, Long value2) {
/*  790 */       addCriterion("INSURANCE_AMOUNT not between", value1, value2, "insuranceAmount");
/*  791 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromIsNull() {
/*  795 */       addCriterion("INSURANCE_DATE_FROM is null");
/*  796 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromIsNotNull() {
/*  800 */       addCriterion("INSURANCE_DATE_FROM is not null");
/*  801 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromEqualTo(Date value) {
/*  805 */       addCriterion("INSURANCE_DATE_FROM =", value, "insuranceDateFrom");
/*  806 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromNotEqualTo(Date value) {
/*  810 */       addCriterion("INSURANCE_DATE_FROM <>", value, "insuranceDateFrom");
/*  811 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromGreaterThan(Date value) {
/*  815 */       addCriterion("INSURANCE_DATE_FROM >", value, "insuranceDateFrom");
/*  816 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromGreaterThanOrEqualTo(Date value) {
/*  820 */       addCriterion("INSURANCE_DATE_FROM >=", value, "insuranceDateFrom");
/*  821 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromLessThan(Date value) {
/*  825 */       addCriterion("INSURANCE_DATE_FROM <", value, "insuranceDateFrom");
/*  826 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromLessThanOrEqualTo(Date value) {
/*  830 */       addCriterion("INSURANCE_DATE_FROM <=", value, "insuranceDateFrom");
/*  831 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromIn(List<Date> values) {
/*  835 */       addCriterion("INSURANCE_DATE_FROM in", values, "insuranceDateFrom");
/*  836 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromNotIn(List<Date> values) {
/*  840 */       addCriterion("INSURANCE_DATE_FROM not in", values, "insuranceDateFrom");
/*  841 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromBetween(Date value1, Date value2) {
/*  845 */       addCriterion("INSURANCE_DATE_FROM between", value1, value2, "insuranceDateFrom");
/*  846 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateFromNotBetween(Date value1, Date value2) {
/*  850 */       addCriterion("INSURANCE_DATE_FROM not between", value1, value2, "insuranceDateFrom");
/*  851 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToIsNull() {
/*  855 */       addCriterion("INSURANCE_DATE_TO is null");
/*  856 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToIsNotNull() {
/*  860 */       addCriterion("INSURANCE_DATE_TO is not null");
/*  861 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToEqualTo(Date value) {
/*  865 */       addCriterion("INSURANCE_DATE_TO =", value, "insuranceDateTo");
/*  866 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToNotEqualTo(Date value) {
/*  870 */       addCriterion("INSURANCE_DATE_TO <>", value, "insuranceDateTo");
/*  871 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToGreaterThan(Date value) {
/*  875 */       addCriterion("INSURANCE_DATE_TO >", value, "insuranceDateTo");
/*  876 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToGreaterThanOrEqualTo(Date value) {
/*  880 */       addCriterion("INSURANCE_DATE_TO >=", value, "insuranceDateTo");
/*  881 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToLessThan(Date value) {
/*  885 */       addCriterion("INSURANCE_DATE_TO <", value, "insuranceDateTo");
/*  886 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToLessThanOrEqualTo(Date value) {
/*  890 */       addCriterion("INSURANCE_DATE_TO <=", value, "insuranceDateTo");
/*  891 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToIn(List<Date> values) {
/*  895 */       addCriterion("INSURANCE_DATE_TO in", values, "insuranceDateTo");
/*  896 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToNotIn(List<Date> values) {
/*  900 */       addCriterion("INSURANCE_DATE_TO not in", values, "insuranceDateTo");
/*  901 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToBetween(Date value1, Date value2) {
/*  905 */       addCriterion("INSURANCE_DATE_TO between", value1, value2, "insuranceDateTo");
/*  906 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andInsuranceDateToNotBetween(Date value1, Date value2) {
/*  910 */       addCriterion("INSURANCE_DATE_TO not between", value1, value2, "insuranceDateTo");
/*  911 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonIsNull() {
/*  915 */       addCriterion("HANDLE_PERSON is null");
/*  916 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonIsNotNull() {
/*  920 */       addCriterion("HANDLE_PERSON is not null");
/*  921 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonEqualTo(String value) {
/*  925 */       addCriterion("HANDLE_PERSON =", value, "handlePerson");
/*  926 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonNotEqualTo(String value) {
/*  930 */       addCriterion("HANDLE_PERSON <>", value, "handlePerson");
/*  931 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonGreaterThan(String value) {
/*  935 */       addCriterion("HANDLE_PERSON >", value, "handlePerson");
/*  936 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonGreaterThanOrEqualTo(String value) {
/*  940 */       addCriterion("HANDLE_PERSON >=", value, "handlePerson");
/*  941 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonLessThan(String value) {
/*  945 */       addCriterion("HANDLE_PERSON <", value, "handlePerson");
/*  946 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonLessThanOrEqualTo(String value) {
/*  950 */       addCriterion("HANDLE_PERSON <=", value, "handlePerson");
/*  951 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonLike(String value) {
/*  955 */       addCriterion("HANDLE_PERSON like", value, "handlePerson");
/*  956 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonNotLike(String value) {
/*  960 */       addCriterion("HANDLE_PERSON not like", value, "handlePerson");
/*  961 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonIn(List<String> values) {
/*  965 */       addCriterion("HANDLE_PERSON in", values, "handlePerson");
/*  966 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonNotIn(List<String> values) {
/*  970 */       addCriterion("HANDLE_PERSON not in", values, "handlePerson");
/*  971 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonBetween(String value1, String value2) {
/*  975 */       addCriterion("HANDLE_PERSON between", value1, value2, "handlePerson");
/*  976 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andHandlePersonNotBetween(String value1, String value2) {
/*  980 */       addCriterion("HANDLE_PERSON not between", value1, value2, "handlePerson");
/*  981 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperIsNull() {
/*  985 */       addCriterion("STOREKEEPER is null");
/*  986 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperIsNotNull() {
/*  990 */       addCriterion("STOREKEEPER is not null");
/*  991 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperEqualTo(String value) {
/*  995 */       addCriterion("STOREKEEPER =", value, "storekeeper");
/*  996 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperNotEqualTo(String value) {
/* 1000 */       addCriterion("STOREKEEPER <>", value, "storekeeper");
/* 1001 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperGreaterThan(String value) {
/* 1005 */       addCriterion("STOREKEEPER >", value, "storekeeper");
/* 1006 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperGreaterThanOrEqualTo(String value) {
/* 1010 */       addCriterion("STOREKEEPER >=", value, "storekeeper");
/* 1011 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperLessThan(String value) {
/* 1015 */       addCriterion("STOREKEEPER <", value, "storekeeper");
/* 1016 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperLessThanOrEqualTo(String value) {
/* 1020 */       addCriterion("STOREKEEPER <=", value, "storekeeper");
/* 1021 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperLike(String value) {
/* 1025 */       addCriterion("STOREKEEPER like", value, "storekeeper");
/* 1026 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperNotLike(String value) {
/* 1030 */       addCriterion("STOREKEEPER not like", value, "storekeeper");
/* 1031 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperIn(List<String> values) {
/* 1035 */       addCriterion("STOREKEEPER in", values, "storekeeper");
/* 1036 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperNotIn(List<String> values) {
/* 1040 */       addCriterion("STOREKEEPER not in", values, "storekeeper");
/* 1041 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperBetween(String value1, String value2) {
/* 1045 */       addCriterion("STOREKEEPER between", value1, value2, "storekeeper");
/* 1046 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorekeeperNotBetween(String value1, String value2) {
/* 1050 */       addCriterion("STOREKEEPER not between", value1, value2, "storekeeper");
/* 1051 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderIsNull() {
/* 1055 */       addCriterion("LEADER is null");
/* 1056 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderIsNotNull() {
/* 1060 */       addCriterion("LEADER is not null");
/* 1061 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderEqualTo(String value) {
/* 1065 */       addCriterion("LEADER =", value, "leader");
/* 1066 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderNotEqualTo(String value) {
/* 1070 */       addCriterion("LEADER <>", value, "leader");
/* 1071 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderGreaterThan(String value) {
/* 1075 */       addCriterion("LEADER >", value, "leader");
/* 1076 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderGreaterThanOrEqualTo(String value) {
/* 1080 */       addCriterion("LEADER >=", value, "leader");
/* 1081 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderLessThan(String value) {
/* 1085 */       addCriterion("LEADER <", value, "leader");
/* 1086 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderLessThanOrEqualTo(String value) {
/* 1090 */       addCriterion("LEADER <=", value, "leader");
/* 1091 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderLike(String value) {
/* 1095 */       addCriterion("LEADER like", value, "leader");
/* 1096 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderNotLike(String value) {
/* 1100 */       addCriterion("LEADER not like", value, "leader");
/* 1101 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderIn(List<String> values) {
/* 1105 */       addCriterion("LEADER in", values, "leader");
/* 1106 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderNotIn(List<String> values) {
/* 1110 */       addCriterion("LEADER not in", values, "leader");
/* 1111 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderBetween(String value1, String value2) {
/* 1115 */       addCriterion("LEADER between", value1, value2, "leader");
/* 1116 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andLeaderNotBetween(String value1, String value2) {
/* 1120 */       addCriterion("LEADER not between", value1, value2, "leader");
/* 1121 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateIsNull() {
/* 1125 */       addCriterion("STORAGE_DATE is null");
/* 1126 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateIsNotNull() {
/* 1130 */       addCriterion("STORAGE_DATE is not null");
/* 1131 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateEqualTo(Date value) {
/* 1135 */       addCriterion("STORAGE_DATE =", value, "storageDate");
/* 1136 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateNotEqualTo(Date value) {
/* 1140 */       addCriterion("STORAGE_DATE <>", value, "storageDate");
/* 1141 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateGreaterThan(Date value) {
/* 1145 */       addCriterion("STORAGE_DATE >", value, "storageDate");
/* 1146 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateGreaterThanOrEqualTo(Date value) {
/* 1150 */       addCriterion("STORAGE_DATE >=", value, "storageDate");
/* 1151 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateLessThan(Date value) {
/* 1155 */       addCriterion("STORAGE_DATE <", value, "storageDate");
/* 1156 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateLessThanOrEqualTo(Date value) {
/* 1160 */       addCriterion("STORAGE_DATE <=", value, "storageDate");
/* 1161 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateIn(List<Date> values) {
/* 1165 */       addCriterion("STORAGE_DATE in", values, "storageDate");
/* 1166 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateNotIn(List<Date> values) {
/* 1170 */       addCriterion("STORAGE_DATE not in", values, "storageDate");
/* 1171 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateBetween(Date value1, Date value2) {
/* 1175 */       addCriterion("STORAGE_DATE between", value1, value2, "storageDate");
/* 1176 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStorageDateNotBetween(Date value1, Date value2) {
/* 1180 */       addCriterion("STORAGE_DATE not between", value1, value2, "storageDate");
/* 1181 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusIsNull() {
/* 1185 */       addCriterion("CHECK_STATUS is null");
/* 1186 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusIsNotNull() {
/* 1190 */       addCriterion("CHECK_STATUS is not null");
/* 1191 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusEqualTo(Short value) {
/* 1195 */       addCriterion("CHECK_STATUS =", value, "checkStatus");
/* 1196 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusNotEqualTo(Short value) {
/* 1200 */       addCriterion("CHECK_STATUS <>", value, "checkStatus");
/* 1201 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusGreaterThan(Short value) {
/* 1205 */       addCriterion("CHECK_STATUS >", value, "checkStatus");
/* 1206 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusGreaterThanOrEqualTo(Short value) {
/* 1210 */       addCriterion("CHECK_STATUS >=", value, "checkStatus");
/* 1211 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusLessThan(Short value) {
/* 1215 */       addCriterion("CHECK_STATUS <", value, "checkStatus");
/* 1216 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusLessThanOrEqualTo(Short value) {
/* 1220 */       addCriterion("CHECK_STATUS <=", value, "checkStatus");
/* 1221 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusIn(List<Short> values) {
/* 1225 */       addCriterion("CHECK_STATUS in", values, "checkStatus");
/* 1226 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusNotIn(List<Short> values) {
/* 1230 */       addCriterion("CHECK_STATUS not in", values, "checkStatus");
/* 1231 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusBetween(Short value1, Short value2) {
/* 1235 */       addCriterion("CHECK_STATUS between", value1, value2, "checkStatus");
/* 1236 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckStatusNotBetween(Short value1, Short value2) {
/* 1240 */       addCriterion("CHECK_STATUS not between", value1, value2, "checkStatus");
/* 1241 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceIsNull() {
/* 1245 */       addCriterion("ASSESSING_PRICE is null");
/* 1246 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceIsNotNull() {
/* 1250 */       addCriterion("ASSESSING_PRICE is not null");
/* 1251 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceEqualTo(Long value) {
/* 1255 */       addCriterion("ASSESSING_PRICE =", value, "assessingPrice");
/* 1256 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceNotEqualTo(Long value) {
/* 1260 */       addCriterion("ASSESSING_PRICE <>", value, "assessingPrice");
/* 1261 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceGreaterThan(Long value) {
/* 1265 */       addCriterion("ASSESSING_PRICE >", value, "assessingPrice");
/* 1266 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceGreaterThanOrEqualTo(Long value) {
/* 1270 */       addCriterion("ASSESSING_PRICE >=", value, "assessingPrice");
/* 1271 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceLessThan(Long value) {
/* 1275 */       addCriterion("ASSESSING_PRICE <", value, "assessingPrice");
/* 1276 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceLessThanOrEqualTo(Long value) {
/* 1280 */       addCriterion("ASSESSING_PRICE <=", value, "assessingPrice");
/* 1281 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceIn(List<Long> values) {
/* 1285 */       addCriterion("ASSESSING_PRICE in", values, "assessingPrice");
/* 1286 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceNotIn(List<Long> values) {
/* 1290 */       addCriterion("ASSESSING_PRICE not in", values, "assessingPrice");
/* 1291 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceBetween(Long value1, Long value2) {
/* 1295 */       addCriterion("ASSESSING_PRICE between", value1, value2, "assessingPrice");
/* 1296 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andAssessingPriceNotBetween(Long value1, Long value2) {
/* 1300 */       addCriterion("ASSESSING_PRICE not between", value1, value2, "assessingPrice");
/* 1301 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioIsNull() {
/* 1305 */       addCriterion("RATIO is null");
/* 1306 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioIsNotNull() {
/* 1310 */       addCriterion("RATIO is not null");
/* 1311 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioEqualTo(BigDecimal value) {
/* 1315 */       addCriterion("RATIO =", value, "ratio");
/* 1316 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioNotEqualTo(BigDecimal value) {
/* 1320 */       addCriterion("RATIO <>", value, "ratio");
/* 1321 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioGreaterThan(BigDecimal value) {
/* 1325 */       addCriterion("RATIO >", value, "ratio");
/* 1326 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioGreaterThanOrEqualTo(BigDecimal value) {
/* 1330 */       addCriterion("RATIO >=", value, "ratio");
/* 1331 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioLessThan(BigDecimal value) {
/* 1335 */       addCriterion("RATIO <", value, "ratio");
/* 1336 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioLessThanOrEqualTo(BigDecimal value) {
/* 1340 */       addCriterion("RATIO <=", value, "ratio");
/* 1341 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioIn(List<BigDecimal> values) {
/* 1345 */       addCriterion("RATIO in", values, "ratio");
/* 1346 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioNotIn(List<BigDecimal> values) {
/* 1350 */       addCriterion("RATIO not in", values, "ratio");
/* 1351 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioBetween(BigDecimal value1, BigDecimal value2) {
/* 1355 */       addCriterion("RATIO between", value1, value2, "ratio");
/* 1356 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andRatioNotBetween(BigDecimal value1, BigDecimal value2) {
/* 1360 */       addCriterion("RATIO not between", value1, value2, "ratio");
/* 1361 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonIsNull() {
/* 1365 */       addCriterion("CHECK_PERSON is null");
/* 1366 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonIsNotNull() {
/* 1370 */       addCriterion("CHECK_PERSON is not null");
/* 1371 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonEqualTo(String value) {
/* 1375 */       addCriterion("CHECK_PERSON =", value, "checkPerson");
/* 1376 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonNotEqualTo(String value) {
/* 1380 */       addCriterion("CHECK_PERSON <>", value, "checkPerson");
/* 1381 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonGreaterThan(String value) {
/* 1385 */       addCriterion("CHECK_PERSON >", value, "checkPerson");
/* 1386 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonGreaterThanOrEqualTo(String value) {
/* 1390 */       addCriterion("CHECK_PERSON >=", value, "checkPerson");
/* 1391 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonLessThan(String value) {
/* 1395 */       addCriterion("CHECK_PERSON <", value, "checkPerson");
/* 1396 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonLessThanOrEqualTo(String value) {
/* 1400 */       addCriterion("CHECK_PERSON <=", value, "checkPerson");
/* 1401 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonLike(String value) {
/* 1405 */       addCriterion("CHECK_PERSON like", value, "checkPerson");
/* 1406 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonNotLike(String value) {
/* 1410 */       addCriterion("CHECK_PERSON not like", value, "checkPerson");
/* 1411 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonIn(List<String> values) {
/* 1415 */       addCriterion("CHECK_PERSON in", values, "checkPerson");
/* 1416 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonNotIn(List<String> values) {
/* 1420 */       addCriterion("CHECK_PERSON not in", values, "checkPerson");
/* 1421 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonBetween(String value1, String value2) {
/* 1425 */       addCriterion("CHECK_PERSON between", value1, value2, "checkPerson");
/* 1426 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckPersonNotBetween(String value1, String value2) {
/* 1430 */       addCriterion("CHECK_PERSON not between", value1, value2, "checkPerson");
/* 1431 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateIsNull() {
/* 1435 */       addCriterion("CHECK_DATE is null");
/* 1436 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateIsNotNull() {
/* 1440 */       addCriterion("CHECK_DATE is not null");
/* 1441 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateEqualTo(Date value) {
/* 1445 */       addCriterion("CHECK_DATE =", value, "checkDate");
/* 1446 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateNotEqualTo(Date value) {
/* 1450 */       addCriterion("CHECK_DATE <>", value, "checkDate");
/* 1451 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateGreaterThan(Date value) {
/* 1455 */       addCriterion("CHECK_DATE >", value, "checkDate");
/* 1456 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
/* 1460 */       addCriterion("CHECK_DATE >=", value, "checkDate");
/* 1461 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateLessThan(Date value) {
/* 1465 */       addCriterion("CHECK_DATE <", value, "checkDate");
/* 1466 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateLessThanOrEqualTo(Date value) {
/* 1470 */       addCriterion("CHECK_DATE <=", value, "checkDate");
/* 1471 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateIn(List<Date> values) {
/* 1475 */       addCriterion("CHECK_DATE in", values, "checkDate");
/* 1476 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateNotIn(List<Date> values) {
/* 1480 */       addCriterion("CHECK_DATE not in", values, "checkDate");
/* 1481 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateBetween(Date value1, Date value2) {
/* 1485 */       addCriterion("CHECK_DATE between", value1, value2, "checkDate");
/* 1486 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andCheckDateNotBetween(Date value1, Date value2) {
/* 1490 */       addCriterion("CHECK_DATE not between", value1, value2, "checkDate");
/* 1491 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckIsNull() {
/* 1495 */       addCriterion("MERCH_ACK is null");
/* 1496 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckIsNotNull() {
/* 1500 */       addCriterion("MERCH_ACK is not null");
/* 1501 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckEqualTo(Short value) {
/* 1505 */       addCriterion("MERCH_ACK =", value, "merchAck");
/* 1506 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckNotEqualTo(Short value) {
/* 1510 */       addCriterion("MERCH_ACK <>", value, "merchAck");
/* 1511 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckGreaterThan(Short value) {
/* 1515 */       addCriterion("MERCH_ACK >", value, "merchAck");
/* 1516 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckGreaterThanOrEqualTo(Short value) {
/* 1520 */       addCriterion("MERCH_ACK >=", value, "merchAck");
/* 1521 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckLessThan(Short value) {
/* 1525 */       addCriterion("MERCH_ACK <", value, "merchAck");
/* 1526 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckLessThanOrEqualTo(Short value) {
/* 1530 */       addCriterion("MERCH_ACK <=", value, "merchAck");
/* 1531 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckIn(List<Short> values) {
/* 1535 */       addCriterion("MERCH_ACK in", values, "merchAck");
/* 1536 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckNotIn(List<Short> values) {
/* 1540 */       addCriterion("MERCH_ACK not in", values, "merchAck");
/* 1541 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckBetween(Short value1, Short value2) {
/* 1545 */       addCriterion("MERCH_ACK between", value1, value2, "merchAck");
/* 1546 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckNotBetween(Short value1, Short value2) {
/* 1550 */       addCriterion("MERCH_ACK not between", value1, value2, "merchAck");
/* 1551 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonIsNull() {
/* 1555 */       addCriterion("MERCH_ACK_PERSON is null");
/* 1556 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonIsNotNull() {
/* 1560 */       addCriterion("MERCH_ACK_PERSON is not null");
/* 1561 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonEqualTo(String value) {
/* 1565 */       addCriterion("MERCH_ACK_PERSON =", value, "merchAckPerson");
/* 1566 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonNotEqualTo(String value) {
/* 1570 */       addCriterion("MERCH_ACK_PERSON <>", value, "merchAckPerson");
/* 1571 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonGreaterThan(String value) {
/* 1575 */       addCriterion("MERCH_ACK_PERSON >", value, "merchAckPerson");
/* 1576 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonGreaterThanOrEqualTo(String value) {
/* 1580 */       addCriterion("MERCH_ACK_PERSON >=", value, "merchAckPerson");
/* 1581 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonLessThan(String value) {
/* 1585 */       addCriterion("MERCH_ACK_PERSON <", value, "merchAckPerson");
/* 1586 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonLessThanOrEqualTo(String value) {
/* 1590 */       addCriterion("MERCH_ACK_PERSON <=", value, "merchAckPerson");
/* 1591 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonLike(String value) {
/* 1595 */       addCriterion("MERCH_ACK_PERSON like", value, "merchAckPerson");
/* 1596 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonNotLike(String value) {
/* 1600 */       addCriterion("MERCH_ACK_PERSON not like", value, "merchAckPerson");
/* 1601 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonIn(List<String> values) {
/* 1605 */       addCriterion("MERCH_ACK_PERSON in", values, "merchAckPerson");
/* 1606 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonNotIn(List<String> values) {
/* 1610 */       addCriterion("MERCH_ACK_PERSON not in", values, "merchAckPerson");
/* 1611 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonBetween(String value1, String value2) {
/* 1615 */       addCriterion("MERCH_ACK_PERSON between", value1, value2, "merchAckPerson");
/* 1616 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckPersonNotBetween(String value1, String value2) {
/* 1620 */       addCriterion("MERCH_ACK_PERSON not between", value1, value2, "merchAckPerson");
/* 1621 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateIsNull() {
/* 1625 */       addCriterion("MERCH_ACK_DATE is null");
/* 1626 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateIsNotNull() {
/* 1630 */       addCriterion("MERCH_ACK_DATE is not null");
/* 1631 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateEqualTo(Date value) {
/* 1635 */       addCriterion("MERCH_ACK_DATE =", value, "merchAckDate");
/* 1636 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateNotEqualTo(Date value) {
/* 1640 */       addCriterion("MERCH_ACK_DATE <>", value, "merchAckDate");
/* 1641 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateGreaterThan(Date value) {
/* 1645 */       addCriterion("MERCH_ACK_DATE >", value, "merchAckDate");
/* 1646 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateGreaterThanOrEqualTo(Date value) {
/* 1650 */       addCriterion("MERCH_ACK_DATE >=", value, "merchAckDate");
/* 1651 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateLessThan(Date value) {
/* 1655 */       addCriterion("MERCH_ACK_DATE <", value, "merchAckDate");
/* 1656 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateLessThanOrEqualTo(Date value) {
/* 1660 */       addCriterion("MERCH_ACK_DATE <=", value, "merchAckDate");
/* 1661 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateIn(List<Date> values) {
/* 1665 */       addCriterion("MERCH_ACK_DATE in", values, "merchAckDate");
/* 1666 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateNotIn(List<Date> values) {
/* 1670 */       addCriterion("MERCH_ACK_DATE not in", values, "merchAckDate");
/* 1671 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateBetween(Date value1, Date value2) {
/* 1675 */       addCriterion("MERCH_ACK_DATE between", value1, value2, "merchAckDate");
/* 1676 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMerchAckDateNotBetween(Date value1, Date value2) {
/* 1680 */       addCriterion("MERCH_ACK_DATE not between", value1, value2, "merchAckDate");
/* 1681 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyIsNull() {
/* 1685 */       addCriterion("GMT_MODIFY is null");
/* 1686 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyIsNotNull() {
/* 1690 */       addCriterion("GMT_MODIFY is not null");
/* 1691 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyEqualTo(Date value) {
/* 1695 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/* 1696 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/* 1700 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/* 1701 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/* 1705 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/* 1706 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/* 1710 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/* 1711 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyLessThan(Date value) {
/* 1715 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/* 1716 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/* 1720 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/* 1721 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyIn(List<Date> values) {
/* 1725 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/* 1726 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/* 1730 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/* 1731 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/* 1735 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/* 1736 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/* 1740 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/* 1741 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateIsNull() {
/* 1745 */       addCriterion("GMT_CREATE is null");
/* 1746 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateIsNotNull() {
/* 1750 */       addCriterion("GMT_CREATE is not null");
/* 1751 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateEqualTo(Date value) {
/* 1755 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/* 1756 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/* 1760 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/* 1761 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/* 1765 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/* 1766 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/* 1770 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/* 1771 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateLessThan(Date value) {
/* 1775 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/* 1776 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/* 1780 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/* 1781 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateIn(List<Date> values) {
/* 1785 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/* 1786 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/* 1790 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/* 1791 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/* 1795 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/* 1796 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/* 1800 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/* 1801 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoIsNull() {
/* 1805 */       addCriterion("MEMO is null");
/* 1806 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoIsNotNull() {
/* 1810 */       addCriterion("MEMO is not null");
/* 1811 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoEqualTo(String value) {
/* 1815 */       addCriterion("MEMO =", value, "memo");
/* 1816 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoNotEqualTo(String value) {
/* 1820 */       addCriterion("MEMO <>", value, "memo");
/* 1821 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoGreaterThan(String value) {
/* 1825 */       addCriterion("MEMO >", value, "memo");
/* 1826 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoGreaterThanOrEqualTo(String value) {
/* 1830 */       addCriterion("MEMO >=", value, "memo");
/* 1831 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoLessThan(String value) {
/* 1835 */       addCriterion("MEMO <", value, "memo");
/* 1836 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoLessThanOrEqualTo(String value) {
/* 1840 */       addCriterion("MEMO <=", value, "memo");
/* 1841 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoLike(String value) {
/* 1845 */       addCriterion("MEMO like", value, "memo");
/* 1846 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoNotLike(String value) {
/* 1850 */       addCriterion("MEMO not like", value, "memo");
/* 1851 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoIn(List<String> values) {
/* 1855 */       addCriterion("MEMO in", values, "memo");
/* 1856 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoNotIn(List<String> values) {
/* 1860 */       addCriterion("MEMO not in", values, "memo");
/* 1861 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoBetween(String value1, String value2) {
/* 1865 */       addCriterion("MEMO between", value1, value2, "memo");
/* 1866 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andMemoNotBetween(String value1, String value2) {
/* 1870 */       addCriterion("MEMO not between", value1, value2, "memo");
/* 1871 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeIsNull() {
/* 1875 */       addCriterion("STORE_ACK_CHANGE is null");
/* 1876 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeIsNotNull() {
/* 1880 */       addCriterion("STORE_ACK_CHANGE is not null");
/* 1881 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeEqualTo(Short value) {
/* 1885 */       addCriterion("STORE_ACK_CHANGE =", value, "storeAckChange");
/* 1886 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeNotEqualTo(Short value) {
/* 1890 */       addCriterion("STORE_ACK_CHANGE <>", value, "storeAckChange");
/* 1891 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeGreaterThan(Short value) {
/* 1895 */       addCriterion("STORE_ACK_CHANGE >", value, "storeAckChange");
/* 1896 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeGreaterThanOrEqualTo(Short value) {
/* 1900 */       addCriterion("STORE_ACK_CHANGE >=", value, "storeAckChange");
/* 1901 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeLessThan(Short value) {
/* 1905 */       addCriterion("STORE_ACK_CHANGE <", value, "storeAckChange");
/* 1906 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeLessThanOrEqualTo(Short value) {
/* 1910 */       addCriterion("STORE_ACK_CHANGE <=", value, "storeAckChange");
/* 1911 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeIn(List<Short> values) {
/* 1915 */       addCriterion("STORE_ACK_CHANGE in", values, "storeAckChange");
/* 1916 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeNotIn(List<Short> values) {
/* 1920 */       addCriterion("STORE_ACK_CHANGE not in", values, "storeAckChange");
/* 1921 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeBetween(Short value1, Short value2) {
/* 1925 */       addCriterion("STORE_ACK_CHANGE between", value1, value2, "storeAckChange");
/* 1926 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancWarehouseCriteria.Criteria andStoreAckChangeNotBetween(Short value1, Short value2) {
/* 1930 */       addCriterion("STORE_ACK_CHANGE not between", value1, value2, "storeAckChange");
/* 1931 */       return (FinancWarehouseCriteria.Criteria)this;
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancWarehouseCriteria
 * JD-Core Version:    0.6.0
 */