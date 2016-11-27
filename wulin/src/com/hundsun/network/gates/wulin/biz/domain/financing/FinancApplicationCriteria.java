/*      */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class FinancApplicationCriteria
/*      */ {
/*      */   protected String orderByClause;
/*      */   protected boolean distinct;
/*      */   protected List<Criteria> oredCriteria;
/*      */ 
/*      */   public FinancApplicationCriteria()
/*      */   {
/*   30 */     this.oredCriteria = new ArrayList();
/*      */   }
/*      */ 
/*      */   protected FinancApplicationCriteria(FinancApplicationCriteria example)
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
/*      */   public static class Criteria extends FinancApplicationCriteria.GeneratedCriteria {
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
/*      */     public FinancApplicationCriteria.Criteria andIdIsNull() {
/*  205 */       addCriterion("ID is null");
/*  206 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdIsNotNull() {
/*  210 */       addCriterion("ID is not null");
/*  211 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdEqualTo(Long value) {
/*  215 */       addCriterion("ID =", value, "id");
/*  216 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdNotEqualTo(Long value) {
/*  220 */       addCriterion("ID <>", value, "id");
/*  221 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdGreaterThan(Long value) {
/*  225 */       addCriterion("ID >", value, "id");
/*  226 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/*  230 */       addCriterion("ID >=", value, "id");
/*  231 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdLessThan(Long value) {
/*  235 */       addCriterion("ID <", value, "id");
/*  236 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/*  240 */       addCriterion("ID <=", value, "id");
/*  241 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdIn(List<Long> values) {
/*  245 */       addCriterion("ID in", values, "id");
/*  246 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdNotIn(List<Long> values) {
/*  250 */       addCriterion("ID not in", values, "id");
/*  251 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdBetween(Long value1, Long value2) {
/*  255 */       addCriterion("ID between", value1, value2, "id");
/*  256 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/*  260 */       addCriterion("ID not between", value1, value2, "id");
/*  261 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdIsNull() {
/*  265 */       addCriterion("ORDER_ID is null");
/*  266 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdIsNotNull() {
/*  270 */       addCriterion("ORDER_ID is not null");
/*  271 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdEqualTo(Long value) {
/*  275 */       addCriterion("ORDER_ID =", value, "orderId");
/*  276 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdNotEqualTo(Long value) {
/*  280 */       addCriterion("ORDER_ID <>", value, "orderId");
/*  281 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdGreaterThan(Long value) {
/*  285 */       addCriterion("ORDER_ID >", value, "orderId");
/*  286 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
/*  290 */       addCriterion("ORDER_ID >=", value, "orderId");
/*  291 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdLessThan(Long value) {
/*  295 */       addCriterion("ORDER_ID <", value, "orderId");
/*  296 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdLessThanOrEqualTo(Long value) {
/*  300 */       addCriterion("ORDER_ID <=", value, "orderId");
/*  301 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdIn(List<Long> values) {
/*  305 */       addCriterion("ORDER_ID in", values, "orderId");
/*  306 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdNotIn(List<Long> values) {
/*  310 */       addCriterion("ORDER_ID not in", values, "orderId");
/*  311 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdBetween(Long value1, Long value2) {
/*  315 */       addCriterion("ORDER_ID between", value1, value2, "orderId");
/*  316 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOrderIdNotBetween(Long value1, Long value2) {
/*  320 */       addCriterion("ORDER_ID not between", value1, value2, "orderId");
/*  321 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdIsNull() {
/*  325 */       addCriterion("WAREHOUSE_ID is null");
/*  326 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdIsNotNull() {
/*  330 */       addCriterion("WAREHOUSE_ID is not null");
/*  331 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdEqualTo(Long value) {
/*  335 */       addCriterion("WAREHOUSE_ID =", value, "warehouseId");
/*  336 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdNotEqualTo(Long value) {
/*  340 */       addCriterion("WAREHOUSE_ID <>", value, "warehouseId");
/*  341 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdGreaterThan(Long value) {
/*  345 */       addCriterion("WAREHOUSE_ID >", value, "warehouseId");
/*  346 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdGreaterThanOrEqualTo(Long value) {
/*  350 */       addCriterion("WAREHOUSE_ID >=", value, "warehouseId");
/*  351 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdLessThan(Long value) {
/*  355 */       addCriterion("WAREHOUSE_ID <", value, "warehouseId");
/*  356 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdLessThanOrEqualTo(Long value) {
/*  360 */       addCriterion("WAREHOUSE_ID <=", value, "warehouseId");
/*  361 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdIn(List<Long> values) {
/*  365 */       addCriterion("WAREHOUSE_ID in", values, "warehouseId");
/*  366 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdNotIn(List<Long> values) {
/*  370 */       addCriterion("WAREHOUSE_ID not in", values, "warehouseId");
/*  371 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdBetween(Long value1, Long value2) {
/*  375 */       addCriterion("WAREHOUSE_ID between", value1, value2, "warehouseId");
/*  376 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andWarehouseIdNotBetween(Long value1, Long value2) {
/*  380 */       addCriterion("WAREHOUSE_ID not between", value1, value2, "warehouseId");
/*  381 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdIsNull() {
/*  385 */       addCriterion("APPLICANT_ID is null");
/*  386 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdIsNotNull() {
/*  390 */       addCriterion("APPLICANT_ID is not null");
/*  391 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdEqualTo(Long value) {
/*  395 */       addCriterion("APPLICANT_ID =", value, "applicantId");
/*  396 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdNotEqualTo(Long value) {
/*  400 */       addCriterion("APPLICANT_ID <>", value, "applicantId");
/*  401 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdGreaterThan(Long value) {
/*  405 */       addCriterion("APPLICANT_ID >", value, "applicantId");
/*  406 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdGreaterThanOrEqualTo(Long value) {
/*  410 */       addCriterion("APPLICANT_ID >=", value, "applicantId");
/*  411 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdLessThan(Long value) {
/*  415 */       addCriterion("APPLICANT_ID <", value, "applicantId");
/*  416 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdLessThanOrEqualTo(Long value) {
/*  420 */       addCriterion("APPLICANT_ID <=", value, "applicantId");
/*  421 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdIn(List<Long> values) {
/*  425 */       addCriterion("APPLICANT_ID in", values, "applicantId");
/*  426 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdNotIn(List<Long> values) {
/*  430 */       addCriterion("APPLICANT_ID not in", values, "applicantId");
/*  431 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdBetween(Long value1, Long value2) {
/*  435 */       addCriterion("APPLICANT_ID between", value1, value2, "applicantId");
/*  436 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicantIdNotBetween(Long value1, Long value2) {
/*  440 */       addCriterion("APPLICANT_ID not between", value1, value2, "applicantId");
/*  441 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdIsNull() {
/*  445 */       addCriterion("LOAN_ACCOUNT_ID is null");
/*  446 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdIsNotNull() {
/*  450 */       addCriterion("LOAN_ACCOUNT_ID is not null");
/*  451 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdEqualTo(Long value) {
/*  455 */       addCriterion("LOAN_ACCOUNT_ID =", value, "loanAccountId");
/*  456 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdNotEqualTo(Long value) {
/*  460 */       addCriterion("LOAN_ACCOUNT_ID <>", value, "loanAccountId");
/*  461 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdGreaterThan(Long value) {
/*  465 */       addCriterion("LOAN_ACCOUNT_ID >", value, "loanAccountId");
/*  466 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdGreaterThanOrEqualTo(Long value) {
/*  470 */       addCriterion("LOAN_ACCOUNT_ID >=", value, "loanAccountId");
/*  471 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdLessThan(Long value) {
/*  475 */       addCriterion("LOAN_ACCOUNT_ID <", value, "loanAccountId");
/*  476 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdLessThanOrEqualTo(Long value) {
/*  480 */       addCriterion("LOAN_ACCOUNT_ID <=", value, "loanAccountId");
/*  481 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdIn(List<Long> values) {
/*  485 */       addCriterion("LOAN_ACCOUNT_ID in", values, "loanAccountId");
/*  486 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdNotIn(List<Long> values) {
/*  490 */       addCriterion("LOAN_ACCOUNT_ID not in", values, "loanAccountId");
/*  491 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdBetween(Long value1, Long value2) {
/*  495 */       addCriterion("LOAN_ACCOUNT_ID between", value1, value2, "loanAccountId");
/*  496 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoanAccountIdNotBetween(Long value1, Long value2) {
/*  500 */       addCriterion("LOAN_ACCOUNT_ID not between", value1, value2, "loanAccountId");
/*  501 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeIsNull() {
/*  505 */       addCriterion("BUSINESS_CODE is null");
/*  506 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeIsNotNull() {
/*  510 */       addCriterion("BUSINESS_CODE is not null");
/*  511 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeEqualTo(String value) {
/*  515 */       addCriterion("BUSINESS_CODE =", value, "businessCode");
/*  516 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeNotEqualTo(String value) {
/*  520 */       addCriterion("BUSINESS_CODE <>", value, "businessCode");
/*  521 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeGreaterThan(String value) {
/*  525 */       addCriterion("BUSINESS_CODE >", value, "businessCode");
/*  526 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeGreaterThanOrEqualTo(String value) {
/*  530 */       addCriterion("BUSINESS_CODE >=", value, "businessCode");
/*  531 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeLessThan(String value) {
/*  535 */       addCriterion("BUSINESS_CODE <", value, "businessCode");
/*  536 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeLessThanOrEqualTo(String value) {
/*  540 */       addCriterion("BUSINESS_CODE <=", value, "businessCode");
/*  541 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeLike(String value) {
/*  545 */       addCriterion("BUSINESS_CODE like", value, "businessCode");
/*  546 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeNotLike(String value) {
/*  550 */       addCriterion("BUSINESS_CODE not like", value, "businessCode");
/*  551 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeIn(List<String> values) {
/*  555 */       addCriterion("BUSINESS_CODE in", values, "businessCode");
/*  556 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeNotIn(List<String> values) {
/*  560 */       addCriterion("BUSINESS_CODE not in", values, "businessCode");
/*  561 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeBetween(String value1, String value2) {
/*  565 */       addCriterion("BUSINESS_CODE between", value1, value2, "businessCode");
/*  566 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessCodeNotBetween(String value1, String value2) {
/*  570 */       addCriterion("BUSINESS_CODE not between", value1, value2, "businessCode");
/*  571 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeIsNull() {
/*  575 */       addCriterion("PARTNER_CODE is null");
/*  576 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeIsNotNull() {
/*  580 */       addCriterion("PARTNER_CODE is not null");
/*  581 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeEqualTo(String value) {
/*  585 */       addCriterion("PARTNER_CODE =", value, "partnerCode");
/*  586 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeNotEqualTo(String value) {
/*  590 */       addCriterion("PARTNER_CODE <>", value, "partnerCode");
/*  591 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeGreaterThan(String value) {
/*  595 */       addCriterion("PARTNER_CODE >", value, "partnerCode");
/*  596 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeGreaterThanOrEqualTo(String value) {
/*  600 */       addCriterion("PARTNER_CODE >=", value, "partnerCode");
/*  601 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeLessThan(String value) {
/*  605 */       addCriterion("PARTNER_CODE <", value, "partnerCode");
/*  606 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeLessThanOrEqualTo(String value) {
/*  610 */       addCriterion("PARTNER_CODE <=", value, "partnerCode");
/*  611 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeLike(String value) {
/*  615 */       addCriterion("PARTNER_CODE like", value, "partnerCode");
/*  616 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeNotLike(String value) {
/*  620 */       addCriterion("PARTNER_CODE not like", value, "partnerCode");
/*  621 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeIn(List<String> values) {
/*  625 */       addCriterion("PARTNER_CODE in", values, "partnerCode");
/*  626 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeNotIn(List<String> values) {
/*  630 */       addCriterion("PARTNER_CODE not in", values, "partnerCode");
/*  631 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeBetween(String value1, String value2) {
/*  635 */       addCriterion("PARTNER_CODE between", value1, value2, "partnerCode");
/*  636 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andPartnerCodeNotBetween(String value1, String value2) {
/*  640 */       addCriterion("PARTNER_CODE not between", value1, value2, "partnerCode");
/*  641 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountIsNull() {
/*  645 */       addCriterion("AGENT_SUB_ACCOUNT is null");
/*  646 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountIsNotNull() {
/*  650 */       addCriterion("AGENT_SUB_ACCOUNT is not null");
/*  651 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountEqualTo(String value) {
/*  655 */       addCriterion("AGENT_SUB_ACCOUNT =", value, "agentSubAccount");
/*  656 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountNotEqualTo(String value) {
/*  660 */       addCriterion("AGENT_SUB_ACCOUNT <>", value, "agentSubAccount");
/*  661 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountGreaterThan(String value) {
/*  665 */       addCriterion("AGENT_SUB_ACCOUNT >", value, "agentSubAccount");
/*  666 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountGreaterThanOrEqualTo(String value) {
/*  670 */       addCriterion("AGENT_SUB_ACCOUNT >=", value, "agentSubAccount");
/*  671 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountLessThan(String value) {
/*  675 */       addCriterion("AGENT_SUB_ACCOUNT <", value, "agentSubAccount");
/*  676 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountLessThanOrEqualTo(String value) {
/*  680 */       addCriterion("AGENT_SUB_ACCOUNT <=", value, "agentSubAccount");
/*  681 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountLike(String value) {
/*  685 */       addCriterion("AGENT_SUB_ACCOUNT like", value, "agentSubAccount");
/*  686 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountNotLike(String value) {
/*  690 */       addCriterion("AGENT_SUB_ACCOUNT not like", value, "agentSubAccount");
/*  691 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountIn(List<String> values) {
/*  695 */       addCriterion("AGENT_SUB_ACCOUNT in", values, "agentSubAccount");
/*  696 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountNotIn(List<String> values) {
/*  700 */       addCriterion("AGENT_SUB_ACCOUNT not in", values, "agentSubAccount");
/*  701 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountBetween(String value1, String value2) {
/*  705 */       addCriterion("AGENT_SUB_ACCOUNT between", value1, value2, "agentSubAccount");
/*  706 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentSubAccountNotBetween(String value1, String value2) {
/*  710 */       addCriterion("AGENT_SUB_ACCOUNT not between", value1, value2, "agentSubAccount");
/*  711 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameIsNull() {
/*  715 */       addCriterion("AGENT_NAME is null");
/*  716 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameIsNotNull() {
/*  720 */       addCriterion("AGENT_NAME is not null");
/*  721 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameEqualTo(String value) {
/*  725 */       addCriterion("AGENT_NAME =", value, "agentName");
/*  726 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameNotEqualTo(String value) {
/*  730 */       addCriterion("AGENT_NAME <>", value, "agentName");
/*  731 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameGreaterThan(String value) {
/*  735 */       addCriterion("AGENT_NAME >", value, "agentName");
/*  736 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameGreaterThanOrEqualTo(String value) {
/*  740 */       addCriterion("AGENT_NAME >=", value, "agentName");
/*  741 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameLessThan(String value) {
/*  745 */       addCriterion("AGENT_NAME <", value, "agentName");
/*  746 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameLessThanOrEqualTo(String value) {
/*  750 */       addCriterion("AGENT_NAME <=", value, "agentName");
/*  751 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameLike(String value) {
/*  755 */       addCriterion("AGENT_NAME like", value, "agentName");
/*  756 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameNotLike(String value) {
/*  760 */       addCriterion("AGENT_NAME not like", value, "agentName");
/*  761 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameIn(List<String> values) {
/*  765 */       addCriterion("AGENT_NAME in", values, "agentName");
/*  766 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameNotIn(List<String> values) {
/*  770 */       addCriterion("AGENT_NAME not in", values, "agentName");
/*  771 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameBetween(String value1, String value2) {
/*  775 */       addCriterion("AGENT_NAME between", value1, value2, "agentName");
/*  776 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andAgentNameNotBetween(String value1, String value2) {
/*  780 */       addCriterion("AGENT_NAME not between", value1, value2, "agentName");
/*  781 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoIsNull() {
/*  785 */       addCriterion("FINANCING_NO is null");
/*  786 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoIsNotNull() {
/*  790 */       addCriterion("FINANCING_NO is not null");
/*  791 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoEqualTo(String value) {
/*  795 */       addCriterion("FINANCING_NO =", value, "financingNo");
/*  796 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoNotEqualTo(String value) {
/*  800 */       addCriterion("FINANCING_NO <>", value, "financingNo");
/*  801 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoGreaterThan(String value) {
/*  805 */       addCriterion("FINANCING_NO >", value, "financingNo");
/*  806 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoGreaterThanOrEqualTo(String value) {
/*  810 */       addCriterion("FINANCING_NO >=", value, "financingNo");
/*  811 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoLessThan(String value) {
/*  815 */       addCriterion("FINANCING_NO <", value, "financingNo");
/*  816 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoLessThanOrEqualTo(String value) {
/*  820 */       addCriterion("FINANCING_NO <=", value, "financingNo");
/*  821 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoLike(String value) {
/*  825 */       addCriterion("FINANCING_NO like", value, "financingNo");
/*  826 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoNotLike(String value) {
/*  830 */       addCriterion("FINANCING_NO not like", value, "financingNo");
/*  831 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoIn(List<String> values) {
/*  835 */       addCriterion("FINANCING_NO in", values, "financingNo");
/*  836 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoNotIn(List<String> values) {
/*  840 */       addCriterion("FINANCING_NO not in", values, "financingNo");
/*  841 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoBetween(String value1, String value2) {
/*  845 */       addCriterion("FINANCING_NO between", value1, value2, "financingNo");
/*  846 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingNoNotBetween(String value1, String value2) {
/*  850 */       addCriterion("FINANCING_NO not between", value1, value2, "financingNo");
/*  851 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountIsNull() {
/*  855 */       addCriterion("SUB_ACCOUNT is null");
/*  856 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountIsNotNull() {
/*  860 */       addCriterion("SUB_ACCOUNT is not null");
/*  861 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountEqualTo(String value) {
/*  865 */       addCriterion("SUB_ACCOUNT =", value, "subAccount");
/*  866 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountNotEqualTo(String value) {
/*  870 */       addCriterion("SUB_ACCOUNT <>", value, "subAccount");
/*  871 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountGreaterThan(String value) {
/*  875 */       addCriterion("SUB_ACCOUNT >", value, "subAccount");
/*  876 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountGreaterThanOrEqualTo(String value) {
/*  880 */       addCriterion("SUB_ACCOUNT >=", value, "subAccount");
/*  881 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountLessThan(String value) {
/*  885 */       addCriterion("SUB_ACCOUNT <", value, "subAccount");
/*  886 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountLessThanOrEqualTo(String value) {
/*  890 */       addCriterion("SUB_ACCOUNT <=", value, "subAccount");
/*  891 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountLike(String value) {
/*  895 */       addCriterion("SUB_ACCOUNT like", value, "subAccount");
/*  896 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountNotLike(String value) {
/*  900 */       addCriterion("SUB_ACCOUNT not like", value, "subAccount");
/*  901 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountIn(List<String> values) {
/*  905 */       addCriterion("SUB_ACCOUNT in", values, "subAccount");
/*  906 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountNotIn(List<String> values) {
/*  910 */       addCriterion("SUB_ACCOUNT not in", values, "subAccount");
/*  911 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountBetween(String value1, String value2) {
/*  915 */       addCriterion("SUB_ACCOUNT between", value1, value2, "subAccount");
/*  916 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andSubAccountNotBetween(String value1, String value2) {
/*  920 */       addCriterion("SUB_ACCOUNT not between", value1, value2, "subAccount");
/*  921 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesIsNull() {
/*  925 */       addCriterion("BUSINESS_TYPES is null");
/*  926 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesIsNotNull() {
/*  930 */       addCriterion("BUSINESS_TYPES is not null");
/*  931 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesEqualTo(Short value) {
/*  935 */       addCriterion("BUSINESS_TYPES =", value, "businessTypes");
/*  936 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesNotEqualTo(Short value) {
/*  940 */       addCriterion("BUSINESS_TYPES <>", value, "businessTypes");
/*  941 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesGreaterThan(Short value) {
/*  945 */       addCriterion("BUSINESS_TYPES >", value, "businessTypes");
/*  946 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesGreaterThanOrEqualTo(Short value) {
/*  950 */       addCriterion("BUSINESS_TYPES >=", value, "businessTypes");
/*  951 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesLessThan(Short value) {
/*  955 */       addCriterion("BUSINESS_TYPES <", value, "businessTypes");
/*  956 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesLessThanOrEqualTo(Short value) {
/*  960 */       addCriterion("BUSINESS_TYPES <=", value, "businessTypes");
/*  961 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesIn(List<Short> values) {
/*  965 */       addCriterion("BUSINESS_TYPES in", values, "businessTypes");
/*  966 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesNotIn(List<Short> values) {
/*  970 */       addCriterion("BUSINESS_TYPES not in", values, "businessTypes");
/*  971 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesBetween(Short value1, Short value2) {
/*  975 */       addCriterion("BUSINESS_TYPES between", value1, value2, "businessTypes");
/*  976 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessTypesNotBetween(Short value1, Short value2) {
/*  980 */       addCriterion("BUSINESS_TYPES not between", value1, value2, "businessTypes");
/*  981 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelIsNull() {
/*  985 */       addCriterion("BUSINESS_MODEL is null");
/*  986 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelIsNotNull() {
/*  990 */       addCriterion("BUSINESS_MODEL is not null");
/*  991 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelEqualTo(Short value) {
/*  995 */       addCriterion("BUSINESS_MODEL =", value, "businessModel");
/*  996 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelNotEqualTo(Short value) {
/* 1000 */       addCriterion("BUSINESS_MODEL <>", value, "businessModel");
/* 1001 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelGreaterThan(Short value) {
/* 1005 */       addCriterion("BUSINESS_MODEL >", value, "businessModel");
/* 1006 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelGreaterThanOrEqualTo(Short value) {
/* 1010 */       addCriterion("BUSINESS_MODEL >=", value, "businessModel");
/* 1011 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelLessThan(Short value) {
/* 1015 */       addCriterion("BUSINESS_MODEL <", value, "businessModel");
/* 1016 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelLessThanOrEqualTo(Short value) {
/* 1020 */       addCriterion("BUSINESS_MODEL <=", value, "businessModel");
/* 1021 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelIn(List<Short> values) {
/* 1025 */       addCriterion("BUSINESS_MODEL in", values, "businessModel");
/* 1026 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelNotIn(List<Short> values) {
/* 1030 */       addCriterion("BUSINESS_MODEL not in", values, "businessModel");
/* 1031 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelBetween(Short value1, Short value2) {
/* 1035 */       addCriterion("BUSINESS_MODEL between", value1, value2, "businessModel");
/* 1036 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andBusinessModelNotBetween(Short value1, Short value2) {
/* 1040 */       addCriterion("BUSINESS_MODEL not between", value1, value2, "businessModel");
/* 1041 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceIsNull() {
/* 1045 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE is null");
/* 1046 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceIsNotNull() {
/* 1050 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE is not null");
/* 1051 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceEqualTo(Long value) {
/* 1055 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE =", value, "depositSubAccountBalance");
/* 1056 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceNotEqualTo(Long value) {
/* 1060 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE <>", value, "depositSubAccountBalance");
/* 1061 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceGreaterThan(Long value) {
/* 1065 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE >", value, "depositSubAccountBalance");
/* 1066 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceGreaterThanOrEqualTo(Long value) {
/* 1070 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE >=", value, "depositSubAccountBalance");
/* 1071 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceLessThan(Long value) {
/* 1075 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE <", value, "depositSubAccountBalance");
/* 1076 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceLessThanOrEqualTo(Long value) {
/* 1080 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE <=", value, "depositSubAccountBalance");
/* 1081 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceIn(List<Long> values) {
/* 1085 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE in", values, "depositSubAccountBalance");
/* 1086 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceNotIn(List<Long> values) {
/* 1090 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE not in", values, "depositSubAccountBalance");
/* 1091 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceBetween(Long value1, Long value2) {
/* 1095 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE between", value1, value2, "depositSubAccountBalance");
/* 1096 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andDepositSubAccountBalanceNotBetween(Long value1, Long value2) {
/* 1100 */       addCriterion("DEPOSIT_SUB_ACCOUNT_BALANCE not between", value1, value2, "depositSubAccountBalance");
/* 1101 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceIsNull() {
/* 1105 */       addCriterion("TOTAL_LOAN_BALANCE is null");
/* 1106 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceIsNotNull() {
/* 1110 */       addCriterion("TOTAL_LOAN_BALANCE is not null");
/* 1111 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceEqualTo(Long value) {
/* 1115 */       addCriterion("TOTAL_LOAN_BALANCE =", value, "totalLoanBalance");
/* 1116 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceNotEqualTo(Long value) {
/* 1120 */       addCriterion("TOTAL_LOAN_BALANCE <>", value, "totalLoanBalance");
/* 1121 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceGreaterThan(Long value) {
/* 1125 */       addCriterion("TOTAL_LOAN_BALANCE >", value, "totalLoanBalance");
/* 1126 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceGreaterThanOrEqualTo(Long value) {
/* 1130 */       addCriterion("TOTAL_LOAN_BALANCE >=", value, "totalLoanBalance");
/* 1131 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceLessThan(Long value) {
/* 1135 */       addCriterion("TOTAL_LOAN_BALANCE <", value, "totalLoanBalance");
/* 1136 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceLessThanOrEqualTo(Long value) {
/* 1140 */       addCriterion("TOTAL_LOAN_BALANCE <=", value, "totalLoanBalance");
/* 1141 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceIn(List<Long> values) {
/* 1145 */       addCriterion("TOTAL_LOAN_BALANCE in", values, "totalLoanBalance");
/* 1146 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceNotIn(List<Long> values) {
/* 1150 */       addCriterion("TOTAL_LOAN_BALANCE not in", values, "totalLoanBalance");
/* 1151 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceBetween(Long value1, Long value2) {
/* 1155 */       addCriterion("TOTAL_LOAN_BALANCE between", value1, value2, "totalLoanBalance");
/* 1156 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalLoanBalanceNotBetween(Long value1, Long value2) {
/* 1160 */       addCriterion("TOTAL_LOAN_BALANCE not between", value1, value2, "totalLoanBalance");
/* 1161 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioIsNull() {
/* 1165 */       addCriterion("FINANCING_RATIO is null");
/* 1166 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioIsNotNull() {
/* 1170 */       addCriterion("FINANCING_RATIO is not null");
/* 1171 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioEqualTo(BigDecimal value) {
/* 1175 */       addCriterion("FINANCING_RATIO =", value, "financingRatio");
/* 1176 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioNotEqualTo(BigDecimal value) {
/* 1180 */       addCriterion("FINANCING_RATIO <>", value, "financingRatio");
/* 1181 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioGreaterThan(BigDecimal value) {
/* 1185 */       addCriterion("FINANCING_RATIO >", value, "financingRatio");
/* 1186 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioGreaterThanOrEqualTo(BigDecimal value) {
/* 1190 */       addCriterion("FINANCING_RATIO >=", value, "financingRatio");
/* 1191 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioLessThan(BigDecimal value) {
/* 1195 */       addCriterion("FINANCING_RATIO <", value, "financingRatio");
/* 1196 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioLessThanOrEqualTo(BigDecimal value) {
/* 1200 */       addCriterion("FINANCING_RATIO <=", value, "financingRatio");
/* 1201 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioIn(List<BigDecimal> values) {
/* 1205 */       addCriterion("FINANCING_RATIO in", values, "financingRatio");
/* 1206 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioNotIn(List<BigDecimal> values) {
/* 1210 */       addCriterion("FINANCING_RATIO not in", values, "financingRatio");
/* 1211 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioBetween(BigDecimal value1, BigDecimal value2) {
/* 1215 */       addCriterion("FINANCING_RATIO between", value1, value2, "financingRatio");
/* 1216 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andFinancingRatioNotBetween(BigDecimal value1, BigDecimal value2) {
/* 1220 */       addCriterion("FINANCING_RATIO not between", value1, value2, "financingRatio");
/* 1221 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableIsNull() {
/* 1225 */       addCriterion("LOANS_AMOUNT_AVAILABLE is null");
/* 1226 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableIsNotNull() {
/* 1230 */       addCriterion("LOANS_AMOUNT_AVAILABLE is not null");
/* 1231 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableEqualTo(Long value) {
/* 1235 */       addCriterion("LOANS_AMOUNT_AVAILABLE =", value, "loansAmountAvailable");
/* 1236 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableNotEqualTo(Long value) {
/* 1240 */       addCriterion("LOANS_AMOUNT_AVAILABLE <>", value, "loansAmountAvailable");
/* 1241 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableGreaterThan(Long value) {
/* 1245 */       addCriterion("LOANS_AMOUNT_AVAILABLE >", value, "loansAmountAvailable");
/* 1246 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableGreaterThanOrEqualTo(Long value) {
/* 1250 */       addCriterion("LOANS_AMOUNT_AVAILABLE >=", value, "loansAmountAvailable");
/* 1251 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableLessThan(Long value) {
/* 1255 */       addCriterion("LOANS_AMOUNT_AVAILABLE <", value, "loansAmountAvailable");
/* 1256 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableLessThanOrEqualTo(Long value) {
/* 1260 */       addCriterion("LOANS_AMOUNT_AVAILABLE <=", value, "loansAmountAvailable");
/* 1261 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableIn(List<Long> values) {
/* 1265 */       addCriterion("LOANS_AMOUNT_AVAILABLE in", values, "loansAmountAvailable");
/* 1266 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableNotIn(List<Long> values) {
/* 1270 */       addCriterion("LOANS_AMOUNT_AVAILABLE not in", values, "loansAmountAvailable");
/* 1271 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableBetween(Long value1, Long value2) {
/* 1275 */       addCriterion("LOANS_AMOUNT_AVAILABLE between", value1, value2, "loansAmountAvailable");
/* 1276 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andLoansAmountAvailableNotBetween(Long value1, Long value2) {
/* 1280 */       addCriterion("LOANS_AMOUNT_AVAILABLE not between", value1, value2, "loansAmountAvailable");
/* 1281 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountIsNull() {
/* 1285 */       addCriterion("APPLICATION_AMOUNT is null");
/* 1286 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountIsNotNull() {
/* 1290 */       addCriterion("APPLICATION_AMOUNT is not null");
/* 1291 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountEqualTo(Long value) {
/* 1295 */       addCriterion("APPLICATION_AMOUNT =", value, "applicationAmount");
/* 1296 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountNotEqualTo(Long value) {
/* 1300 */       addCriterion("APPLICATION_AMOUNT <>", value, "applicationAmount");
/* 1301 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountGreaterThan(Long value) {
/* 1305 */       addCriterion("APPLICATION_AMOUNT >", value, "applicationAmount");
/* 1306 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountGreaterThanOrEqualTo(Long value) {
/* 1310 */       addCriterion("APPLICATION_AMOUNT >=", value, "applicationAmount");
/* 1311 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountLessThan(Long value) {
/* 1315 */       addCriterion("APPLICATION_AMOUNT <", value, "applicationAmount");
/* 1316 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountLessThanOrEqualTo(Long value) {
/* 1320 */       addCriterion("APPLICATION_AMOUNT <=", value, "applicationAmount");
/* 1321 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountIn(List<Long> values) {
/* 1325 */       addCriterion("APPLICATION_AMOUNT in", values, "applicationAmount");
/* 1326 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountNotIn(List<Long> values) {
/* 1330 */       addCriterion("APPLICATION_AMOUNT not in", values, "applicationAmount");
/* 1331 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountBetween(Long value1, Long value2) {
/* 1335 */       addCriterion("APPLICATION_AMOUNT between", value1, value2, "applicationAmount");
/* 1336 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplicationAmountNotBetween(Long value1, Long value2) {
/* 1340 */       addCriterion("APPLICATION_AMOUNT not between", value1, value2, "applicationAmount");
/* 1341 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyIsNull() {
/* 1345 */       addCriterion("OWN_PAY_MONEY is null");
/* 1346 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyIsNotNull() {
/* 1350 */       addCriterion("OWN_PAY_MONEY is not null");
/* 1351 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyEqualTo(Long value) {
/* 1355 */       addCriterion("OWN_PAY_MONEY =", value, "ownPayMoney");
/* 1356 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyNotEqualTo(Long value) {
/* 1360 */       addCriterion("OWN_PAY_MONEY <>", value, "ownPayMoney");
/* 1361 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyGreaterThan(Long value) {
/* 1365 */       addCriterion("OWN_PAY_MONEY >", value, "ownPayMoney");
/* 1366 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyGreaterThanOrEqualTo(Long value) {
/* 1370 */       addCriterion("OWN_PAY_MONEY >=", value, "ownPayMoney");
/* 1371 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyLessThan(Long value) {
/* 1375 */       addCriterion("OWN_PAY_MONEY <", value, "ownPayMoney");
/* 1376 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyLessThanOrEqualTo(Long value) {
/* 1380 */       addCriterion("OWN_PAY_MONEY <=", value, "ownPayMoney");
/* 1381 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyIn(List<Long> values) {
/* 1385 */       addCriterion("OWN_PAY_MONEY in", values, "ownPayMoney");
/* 1386 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyNotIn(List<Long> values) {
/* 1390 */       addCriterion("OWN_PAY_MONEY not in", values, "ownPayMoney");
/* 1391 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyBetween(Long value1, Long value2) {
/* 1395 */       addCriterion("OWN_PAY_MONEY between", value1, value2, "ownPayMoney");
/* 1396 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andOwnPayMoneyNotBetween(Long value1, Long value2) {
/* 1400 */       addCriterion("OWN_PAY_MONEY not between", value1, value2, "ownPayMoney");
/* 1401 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrIsNull() {
/* 1405 */       addCriterion("APPLY_DATE_STR is null");
/* 1406 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrIsNotNull() {
/* 1410 */       addCriterion("APPLY_DATE_STR is not null");
/* 1411 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrEqualTo(String value) {
/* 1415 */       addCriterion("APPLY_DATE_STR =", value, "applyDateStr");
/* 1416 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrNotEqualTo(String value) {
/* 1420 */       addCriterion("APPLY_DATE_STR <>", value, "applyDateStr");
/* 1421 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrGreaterThan(String value) {
/* 1425 */       addCriterion("APPLY_DATE_STR >", value, "applyDateStr");
/* 1426 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrGreaterThanOrEqualTo(String value) {
/* 1430 */       addCriterion("APPLY_DATE_STR >=", value, "applyDateStr");
/* 1431 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrLessThan(String value) {
/* 1435 */       addCriterion("APPLY_DATE_STR <", value, "applyDateStr");
/* 1436 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrLessThanOrEqualTo(String value) {
/* 1440 */       addCriterion("APPLY_DATE_STR <=", value, "applyDateStr");
/* 1441 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrLike(String value) {
/* 1445 */       addCriterion("APPLY_DATE_STR like", value, "applyDateStr");
/* 1446 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrNotLike(String value) {
/* 1450 */       addCriterion("APPLY_DATE_STR not like", value, "applyDateStr");
/* 1451 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrIn(List<String> values) {
/* 1455 */       addCriterion("APPLY_DATE_STR in", values, "applyDateStr");
/* 1456 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrNotIn(List<String> values) {
/* 1460 */       addCriterion("APPLY_DATE_STR not in", values, "applyDateStr");
/* 1461 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrBetween(String value1, String value2) {
/* 1465 */       addCriterion("APPLY_DATE_STR between", value1, value2, "applyDateStr");
/* 1466 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andApplyDateStrNotBetween(String value1, String value2) {
/* 1470 */       addCriterion("APPLY_DATE_STR not between", value1, value2, "applyDateStr");
/* 1471 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoIsNull() {
/* 1475 */       addCriterion("CUSTOMER_NO is null");
/* 1476 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoIsNotNull() {
/* 1480 */       addCriterion("CUSTOMER_NO is not null");
/* 1481 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoEqualTo(String value) {
/* 1485 */       addCriterion("CUSTOMER_NO =", value, "customerNo");
/* 1486 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoNotEqualTo(String value) {
/* 1490 */       addCriterion("CUSTOMER_NO <>", value, "customerNo");
/* 1491 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoGreaterThan(String value) {
/* 1495 */       addCriterion("CUSTOMER_NO >", value, "customerNo");
/* 1496 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoGreaterThanOrEqualTo(String value) {
/* 1500 */       addCriterion("CUSTOMER_NO >=", value, "customerNo");
/* 1501 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoLessThan(String value) {
/* 1505 */       addCriterion("CUSTOMER_NO <", value, "customerNo");
/* 1506 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoLessThanOrEqualTo(String value) {
/* 1510 */       addCriterion("CUSTOMER_NO <=", value, "customerNo");
/* 1511 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoLike(String value) {
/* 1515 */       addCriterion("CUSTOMER_NO like", value, "customerNo");
/* 1516 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoNotLike(String value) {
/* 1520 */       addCriterion("CUSTOMER_NO not like", value, "customerNo");
/* 1521 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoIn(List<String> values) {
/* 1525 */       addCriterion("CUSTOMER_NO in", values, "customerNo");
/* 1526 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoNotIn(List<String> values) {
/* 1530 */       addCriterion("CUSTOMER_NO not in", values, "customerNo");
/* 1531 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoBetween(String value1, String value2) {
/* 1535 */       addCriterion("CUSTOMER_NO between", value1, value2, "customerNo");
/* 1536 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCustomerNoNotBetween(String value1, String value2) {
/* 1540 */       addCriterion("CUSTOMER_NO not between", value1, value2, "customerNo");
/* 1541 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursIsNull() {
/* 1545 */       addCriterion("TRADING_HOURS is null");
/* 1546 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursIsNotNull() {
/* 1550 */       addCriterion("TRADING_HOURS is not null");
/* 1551 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursEqualTo(String value) {
/* 1555 */       addCriterion("TRADING_HOURS =", value, "tradingHours");
/* 1556 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursNotEqualTo(String value) {
/* 1560 */       addCriterion("TRADING_HOURS <>", value, "tradingHours");
/* 1561 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursGreaterThan(String value) {
/* 1565 */       addCriterion("TRADING_HOURS >", value, "tradingHours");
/* 1566 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursGreaterThanOrEqualTo(String value) {
/* 1570 */       addCriterion("TRADING_HOURS >=", value, "tradingHours");
/* 1571 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursLessThan(String value) {
/* 1575 */       addCriterion("TRADING_HOURS <", value, "tradingHours");
/* 1576 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursLessThanOrEqualTo(String value) {
/* 1580 */       addCriterion("TRADING_HOURS <=", value, "tradingHours");
/* 1581 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursLike(String value) {
/* 1585 */       addCriterion("TRADING_HOURS like", value, "tradingHours");
/* 1586 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursNotLike(String value) {
/* 1590 */       addCriterion("TRADING_HOURS not like", value, "tradingHours");
/* 1591 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursIn(List<String> values) {
/* 1595 */       addCriterion("TRADING_HOURS in", values, "tradingHours");
/* 1596 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursNotIn(List<String> values) {
/* 1600 */       addCriterion("TRADING_HOURS not in", values, "tradingHours");
/* 1601 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursBetween(String value1, String value2) {
/* 1605 */       addCriterion("TRADING_HOURS between", value1, value2, "tradingHours");
/* 1606 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTradingHoursNotBetween(String value1, String value2) {
/* 1610 */       addCriterion("TRADING_HOURS not between", value1, value2, "tradingHours");
/* 1611 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusIsNull() {
/* 1615 */       addCriterion("STATUS is null");
/* 1616 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusIsNotNull() {
/* 1620 */       addCriterion("STATUS is not null");
/* 1621 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusEqualTo(Short value) {
/* 1625 */       addCriterion("STATUS =", value, "status");
/* 1626 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusNotEqualTo(Short value) {
/* 1630 */       addCriterion("STATUS <>", value, "status");
/* 1631 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusGreaterThan(Short value) {
/* 1635 */       addCriterion("STATUS >", value, "status");
/* 1636 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusGreaterThanOrEqualTo(Short value) {
/* 1640 */       addCriterion("STATUS >=", value, "status");
/* 1641 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusLessThan(Short value) {
/* 1645 */       addCriterion("STATUS <", value, "status");
/* 1646 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusLessThanOrEqualTo(Short value) {
/* 1650 */       addCriterion("STATUS <=", value, "status");
/* 1651 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusIn(List<Short> values) {
/* 1655 */       addCriterion("STATUS in", values, "status");
/* 1656 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusNotIn(List<Short> values) {
/* 1660 */       addCriterion("STATUS not in", values, "status");
/* 1661 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusBetween(Short value1, Short value2) {
/* 1665 */       addCriterion("STATUS between", value1, value2, "status");
/* 1666 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andStatusNotBetween(Short value1, Short value2) {
/* 1670 */       addCriterion("STATUS not between", value1, value2, "status");
/* 1671 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentIsNull() {
/* 1675 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT is null");
/* 1676 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentIsNotNull() {
/* 1680 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT is not null");
/* 1681 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentEqualTo(Long value) {
/* 1685 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT =", value, "totalCumulativeRepayment");
/* 1686 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentNotEqualTo(Long value) {
/* 1690 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT <>", value, "totalCumulativeRepayment");
/* 1691 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentGreaterThan(Long value) {
/* 1695 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT >", value, "totalCumulativeRepayment");
/* 1696 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentGreaterThanOrEqualTo(Long value) {
/* 1700 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT >=", value, "totalCumulativeRepayment");
/* 1701 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentLessThan(Long value) {
/* 1705 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT <", value, "totalCumulativeRepayment");
/* 1706 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentLessThanOrEqualTo(Long value) {
/* 1710 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT <=", value, "totalCumulativeRepayment");
/* 1711 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentIn(List<Long> values) {
/* 1715 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT in", values, "totalCumulativeRepayment");
/* 1716 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentNotIn(List<Long> values) {
/* 1720 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT not in", values, "totalCumulativeRepayment");
/* 1721 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentBetween(Long value1, Long value2) {
/* 1725 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT between", value1, value2, "totalCumulativeRepayment");
/* 1726 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeRepaymentNotBetween(Long value1, Long value2) {
/* 1730 */       addCriterion("TOTAL_CUMULATIVE_REPAYMENT not between", value1, value2, "totalCumulativeRepayment");
/* 1731 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestIsNull() {
/* 1735 */       addCriterion("TOTAL_CUMULATIVE_INTEREST is null");
/* 1736 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestIsNotNull() {
/* 1740 */       addCriterion("TOTAL_CUMULATIVE_INTEREST is not null");
/* 1741 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestEqualTo(Long value) {
/* 1745 */       addCriterion("TOTAL_CUMULATIVE_INTEREST =", value, "totalCumulativeInterest");
/* 1746 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestNotEqualTo(Long value) {
/* 1750 */       addCriterion("TOTAL_CUMULATIVE_INTEREST <>", value, "totalCumulativeInterest");
/* 1751 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestGreaterThan(Long value) {
/* 1755 */       addCriterion("TOTAL_CUMULATIVE_INTEREST >", value, "totalCumulativeInterest");
/* 1756 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestGreaterThanOrEqualTo(Long value) {
/* 1760 */       addCriterion("TOTAL_CUMULATIVE_INTEREST >=", value, "totalCumulativeInterest");
/* 1761 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestLessThan(Long value) {
/* 1765 */       addCriterion("TOTAL_CUMULATIVE_INTEREST <", value, "totalCumulativeInterest");
/* 1766 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestLessThanOrEqualTo(Long value) {
/* 1770 */       addCriterion("TOTAL_CUMULATIVE_INTEREST <=", value, "totalCumulativeInterest");
/* 1771 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestIn(List<Long> values) {
/* 1775 */       addCriterion("TOTAL_CUMULATIVE_INTEREST in", values, "totalCumulativeInterest");
/* 1776 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestNotIn(List<Long> values) {
/* 1780 */       addCriterion("TOTAL_CUMULATIVE_INTEREST not in", values, "totalCumulativeInterest");
/* 1781 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestBetween(Long value1, Long value2) {
/* 1785 */       addCriterion("TOTAL_CUMULATIVE_INTEREST between", value1, value2, "totalCumulativeInterest");
/* 1786 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andTotalCumulativeInterestNotBetween(Long value1, Long value2) {
/* 1790 */       addCriterion("TOTAL_CUMULATIVE_INTEREST not between", value1, value2, "totalCumulativeInterest");
/* 1791 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusIsNull() {
/* 1795 */       addCriterion("ACTIVITES_STATUS is null");
/* 1796 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusIsNotNull() {
/* 1800 */       addCriterion("ACTIVITES_STATUS is not null");
/* 1801 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusEqualTo(Short value) {
/* 1805 */       addCriterion("ACTIVITES_STATUS =", value, "activitesStatus");
/* 1806 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusNotEqualTo(Short value) {
/* 1810 */       addCriterion("ACTIVITES_STATUS <>", value, "activitesStatus");
/* 1811 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusGreaterThan(Short value) {
/* 1815 */       addCriterion("ACTIVITES_STATUS >", value, "activitesStatus");
/* 1816 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusGreaterThanOrEqualTo(Short value) {
/* 1820 */       addCriterion("ACTIVITES_STATUS >=", value, "activitesStatus");
/* 1821 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusLessThan(Short value) {
/* 1825 */       addCriterion("ACTIVITES_STATUS <", value, "activitesStatus");
/* 1826 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusLessThanOrEqualTo(Short value) {
/* 1830 */       addCriterion("ACTIVITES_STATUS <=", value, "activitesStatus");
/* 1831 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusIn(List<Short> values) {
/* 1835 */       addCriterion("ACTIVITES_STATUS in", values, "activitesStatus");
/* 1836 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusNotIn(List<Short> values) {
/* 1840 */       addCriterion("ACTIVITES_STATUS not in", values, "activitesStatus");
/* 1841 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusBetween(Short value1, Short value2) {
/* 1845 */       addCriterion("ACTIVITES_STATUS between", value1, value2, "activitesStatus");
/* 1846 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andActivitesStatusNotBetween(Short value1, Short value2) {
/* 1850 */       addCriterion("ACTIVITES_STATUS not between", value1, value2, "activitesStatus");
/* 1851 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultIsNull() {
/* 1855 */       addCriterion("REC_RESULT is null");
/* 1856 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultIsNotNull() {
/* 1860 */       addCriterion("REC_RESULT is not null");
/* 1861 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultEqualTo(Short value) {
/* 1865 */       addCriterion("REC_RESULT =", value, "recResult");
/* 1866 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultNotEqualTo(Short value) {
/* 1870 */       addCriterion("REC_RESULT <>", value, "recResult");
/* 1871 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultGreaterThan(Short value) {
/* 1875 */       addCriterion("REC_RESULT >", value, "recResult");
/* 1876 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultGreaterThanOrEqualTo(Short value) {
/* 1880 */       addCriterion("REC_RESULT >=", value, "recResult");
/* 1881 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultLessThan(Short value) {
/* 1885 */       addCriterion("REC_RESULT <", value, "recResult");
/* 1886 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultLessThanOrEqualTo(Short value) {
/* 1890 */       addCriterion("REC_RESULT <=", value, "recResult");
/* 1891 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultIn(List<Short> values) {
/* 1895 */       addCriterion("REC_RESULT in", values, "recResult");
/* 1896 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultNotIn(List<Short> values) {
/* 1900 */       addCriterion("REC_RESULT not in", values, "recResult");
/* 1901 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultBetween(Short value1, Short value2) {
/* 1905 */       addCriterion("REC_RESULT between", value1, value2, "recResult");
/* 1906 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andRecResultNotBetween(Short value1, Short value2) {
/* 1910 */       addCriterion("REC_RESULT not between", value1, value2, "recResult");
/* 1911 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateIsNull() {
/* 1915 */       addCriterion("GMT_CREATE is null");
/* 1916 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateIsNotNull() {
/* 1920 */       addCriterion("GMT_CREATE is not null");
/* 1921 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateEqualTo(Date value) {
/* 1925 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/* 1926 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/* 1930 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/* 1931 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/* 1935 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/* 1936 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/* 1940 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/* 1941 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateLessThan(Date value) {
/* 1945 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/* 1946 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/* 1950 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/* 1951 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateIn(List<Date> values) {
/* 1955 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/* 1956 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/* 1960 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/* 1961 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/* 1965 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/* 1966 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/* 1970 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/* 1971 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyIsNull() {
/* 1975 */       addCriterion("GMT_MODIFY is null");
/* 1976 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyIsNotNull() {
/* 1980 */       addCriterion("GMT_MODIFY is not null");
/* 1981 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyEqualTo(Date value) {
/* 1985 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/* 1986 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/* 1990 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/* 1991 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/* 1995 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/* 1996 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/* 2000 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/* 2001 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyLessThan(Date value) {
/* 2005 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/* 2006 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/* 2010 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/* 2011 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyIn(List<Date> values) {
/* 2015 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/* 2016 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/* 2020 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/* 2021 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/* 2025 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/* 2026 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/* 2030 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/* 2031 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorIsNull() {
/* 2035 */       addCriterion("CREATOR is null");
/* 2036 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorIsNotNull() {
/* 2040 */       addCriterion("CREATOR is not null");
/* 2041 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorEqualTo(String value) {
/* 2045 */       addCriterion("CREATOR =", value, "creator");
/* 2046 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorNotEqualTo(String value) {
/* 2050 */       addCriterion("CREATOR <>", value, "creator");
/* 2051 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorGreaterThan(String value) {
/* 2055 */       addCriterion("CREATOR >", value, "creator");
/* 2056 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorGreaterThanOrEqualTo(String value) {
/* 2060 */       addCriterion("CREATOR >=", value, "creator");
/* 2061 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorLessThan(String value) {
/* 2065 */       addCriterion("CREATOR <", value, "creator");
/* 2066 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorLessThanOrEqualTo(String value) {
/* 2070 */       addCriterion("CREATOR <=", value, "creator");
/* 2071 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorLike(String value) {
/* 2075 */       addCriterion("CREATOR like", value, "creator");
/* 2076 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorNotLike(String value) {
/* 2080 */       addCriterion("CREATOR not like", value, "creator");
/* 2081 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorIn(List<String> values) {
/* 2085 */       addCriterion("CREATOR in", values, "creator");
/* 2086 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorNotIn(List<String> values) {
/* 2090 */       addCriterion("CREATOR not in", values, "creator");
/* 2091 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorBetween(String value1, String value2) {
/* 2095 */       addCriterion("CREATOR between", value1, value2, "creator");
/* 2096 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCreatorNotBetween(String value1, String value2) {
/* 2100 */       addCriterion("CREATOR not between", value1, value2, "creator");
/* 2101 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierIsNull() {
/* 2105 */       addCriterion("MODIFIER is null");
/* 2106 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierIsNotNull() {
/* 2110 */       addCriterion("MODIFIER is not null");
/* 2111 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierEqualTo(String value) {
/* 2115 */       addCriterion("MODIFIER =", value, "modifier");
/* 2116 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierNotEqualTo(String value) {
/* 2120 */       addCriterion("MODIFIER <>", value, "modifier");
/* 2121 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierGreaterThan(String value) {
/* 2125 */       addCriterion("MODIFIER >", value, "modifier");
/* 2126 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierGreaterThanOrEqualTo(String value) {
/* 2130 */       addCriterion("MODIFIER >=", value, "modifier");
/* 2131 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierLessThan(String value) {
/* 2135 */       addCriterion("MODIFIER <", value, "modifier");
/* 2136 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierLessThanOrEqualTo(String value) {
/* 2140 */       addCriterion("MODIFIER <=", value, "modifier");
/* 2141 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierLike(String value) {
/* 2145 */       addCriterion("MODIFIER like", value, "modifier");
/* 2146 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierNotLike(String value) {
/* 2150 */       addCriterion("MODIFIER not like", value, "modifier");
/* 2151 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierIn(List<String> values) {
/* 2155 */       addCriterion("MODIFIER in", values, "modifier");
/* 2156 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierNotIn(List<String> values) {
/* 2160 */       addCriterion("MODIFIER not in", values, "modifier");
/* 2161 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierBetween(String value1, String value2) {
/* 2165 */       addCriterion("MODIFIER between", value1, value2, "modifier");
/* 2166 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andModifierNotBetween(String value1, String value2) {
/* 2170 */       addCriterion("MODIFIER not between", value1, value2, "modifier");
/* 2171 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteIsNull() {
/* 2175 */       addCriterion("COLL_ACK_COMPLETE is null");
/* 2176 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteIsNotNull() {
/* 2180 */       addCriterion("COLL_ACK_COMPLETE is not null");
/* 2181 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteEqualTo(Long value) {
/* 2185 */       addCriterion("COLL_ACK_COMPLETE =", value, "collAckComplete");
/* 2186 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteNotEqualTo(Long value) {
/* 2190 */       addCriterion("COLL_ACK_COMPLETE <>", value, "collAckComplete");
/* 2191 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteGreaterThan(Long value) {
/* 2195 */       addCriterion("COLL_ACK_COMPLETE >", value, "collAckComplete");
/* 2196 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteGreaterThanOrEqualTo(Long value) {
/* 2200 */       addCriterion("COLL_ACK_COMPLETE >=", value, "collAckComplete");
/* 2201 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteLessThan(Long value) {
/* 2205 */       addCriterion("COLL_ACK_COMPLETE <", value, "collAckComplete");
/* 2206 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteLessThanOrEqualTo(Long value) {
/* 2210 */       addCriterion("COLL_ACK_COMPLETE <=", value, "collAckComplete");
/* 2211 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteIn(List<Long> values) {
/* 2215 */       addCriterion("COLL_ACK_COMPLETE in", values, "collAckComplete");
/* 2216 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteNotIn(List<Long> values) {
/* 2220 */       addCriterion("COLL_ACK_COMPLETE not in", values, "collAckComplete");
/* 2221 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteBetween(Long value1, Long value2) {
/* 2225 */       addCriterion("COLL_ACK_COMPLETE between", value1, value2, "collAckComplete");
/* 2226 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollAckCompleteNotBetween(Long value1, Long value2) {
/* 2230 */       addCriterion("COLL_ACK_COMPLETE not between", value1, value2, "collAckComplete");
/* 2231 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoIsNull() {
/* 2235 */       addCriterion("COLL_SERIAL_NO is null");
/* 2236 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoIsNotNull() {
/* 2240 */       addCriterion("COLL_SERIAL_NO is not null");
/* 2241 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoEqualTo(Long value) {
/* 2245 */       addCriterion("COLL_SERIAL_NO =", value, "collSerialNo");
/* 2246 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoNotEqualTo(Long value) {
/* 2250 */       addCriterion("COLL_SERIAL_NO <>", value, "collSerialNo");
/* 2251 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoGreaterThan(Long value) {
/* 2255 */       addCriterion("COLL_SERIAL_NO >", value, "collSerialNo");
/* 2256 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoGreaterThanOrEqualTo(Long value) {
/* 2260 */       addCriterion("COLL_SERIAL_NO >=", value, "collSerialNo");
/* 2261 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoLessThan(Long value) {
/* 2265 */       addCriterion("COLL_SERIAL_NO <", value, "collSerialNo");
/* 2266 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoLessThanOrEqualTo(Long value) {
/* 2270 */       addCriterion("COLL_SERIAL_NO <=", value, "collSerialNo");
/* 2271 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoIn(List<Long> values) {
/* 2275 */       addCriterion("COLL_SERIAL_NO in", values, "collSerialNo");
/* 2276 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoNotIn(List<Long> values) {
/* 2280 */       addCriterion("COLL_SERIAL_NO not in", values, "collSerialNo");
/* 2281 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoBetween(Long value1, Long value2) {
/* 2285 */       addCriterion("COLL_SERIAL_NO between", value1, value2, "collSerialNo");
/* 2286 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancApplicationCriteria.Criteria andCollSerialNoNotBetween(Long value1, Long value2) {
/* 2290 */       addCriterion("COLL_SERIAL_NO not between", value1, value2, "collSerialNo");
/* 2291 */       return (FinancApplicationCriteria.Criteria)this;
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancApplicationCriteria
 * JD-Core Version:    0.6.0
 */