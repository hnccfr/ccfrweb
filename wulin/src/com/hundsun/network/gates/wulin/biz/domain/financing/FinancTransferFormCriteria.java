/*      */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class FinancTransferFormCriteria
/*      */ {
/*      */   protected String orderByClause;
/*      */   protected boolean distinct;
/*      */   protected List<Criteria> oredCriteria;
/*      */ 
/*      */   public FinancTransferFormCriteria()
/*      */   {
/*   30 */     this.oredCriteria = new ArrayList();
/*      */   }
/*      */ 
/*      */   protected FinancTransferFormCriteria(FinancTransferFormCriteria example)
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
/*      */   public static class Criteria extends FinancTransferFormCriteria.GeneratedCriteria {
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
/*      */     public FinancTransferFormCriteria.Criteria andIdIsNull() {
/*  205 */       addCriterion("ID is null");
/*  206 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdIsNotNull() {
/*  210 */       addCriterion("ID is not null");
/*  211 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdEqualTo(Long value) {
/*  215 */       addCriterion("ID =", value, "id");
/*  216 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdNotEqualTo(Long value) {
/*  220 */       addCriterion("ID <>", value, "id");
/*  221 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdGreaterThan(Long value) {
/*  225 */       addCriterion("ID >", value, "id");
/*  226 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/*  230 */       addCriterion("ID >=", value, "id");
/*  231 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdLessThan(Long value) {
/*  235 */       addCriterion("ID <", value, "id");
/*  236 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/*  240 */       addCriterion("ID <=", value, "id");
/*  241 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdIn(List<Long> values) {
/*  245 */       addCriterion("ID in", values, "id");
/*  246 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdNotIn(List<Long> values) {
/*  250 */       addCriterion("ID not in", values, "id");
/*  251 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdBetween(Long value1, Long value2) {
/*  255 */       addCriterion("ID between", value1, value2, "id");
/*  256 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/*  260 */       addCriterion("ID not between", value1, value2, "id");
/*  261 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdIsNull() {
/*  265 */       addCriterion("BUYER_ACCOUNT_ID is null");
/*  266 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdIsNotNull() {
/*  270 */       addCriterion("BUYER_ACCOUNT_ID is not null");
/*  271 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdEqualTo(Long value) {
/*  275 */       addCriterion("BUYER_ACCOUNT_ID =", value, "buyerAccountId");
/*  276 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdNotEqualTo(Long value) {
/*  280 */       addCriterion("BUYER_ACCOUNT_ID <>", value, "buyerAccountId");
/*  281 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdGreaterThan(Long value) {
/*  285 */       addCriterion("BUYER_ACCOUNT_ID >", value, "buyerAccountId");
/*  286 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdGreaterThanOrEqualTo(Long value) {
/*  290 */       addCriterion("BUYER_ACCOUNT_ID >=", value, "buyerAccountId");
/*  291 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdLessThan(Long value) {
/*  295 */       addCriterion("BUYER_ACCOUNT_ID <", value, "buyerAccountId");
/*  296 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdLessThanOrEqualTo(Long value) {
/*  300 */       addCriterion("BUYER_ACCOUNT_ID <=", value, "buyerAccountId");
/*  301 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdIn(List<Long> values) {
/*  305 */       addCriterion("BUYER_ACCOUNT_ID in", values, "buyerAccountId");
/*  306 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdNotIn(List<Long> values) {
/*  310 */       addCriterion("BUYER_ACCOUNT_ID not in", values, "buyerAccountId");
/*  311 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdBetween(Long value1, Long value2) {
/*  315 */       addCriterion("BUYER_ACCOUNT_ID between", value1, value2, "buyerAccountId");
/*  316 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andBuyerAccountIdNotBetween(Long value1, Long value2) {
/*  320 */       addCriterion("BUYER_ACCOUNT_ID not between", value1, value2, "buyerAccountId");
/*  321 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdIsNull() {
/*  325 */       addCriterion("SELLER_ACCOUNT_ID is null");
/*  326 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdIsNotNull() {
/*  330 */       addCriterion("SELLER_ACCOUNT_ID is not null");
/*  331 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdEqualTo(Long value) {
/*  335 */       addCriterion("SELLER_ACCOUNT_ID =", value, "sellerAccountId");
/*  336 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdNotEqualTo(Long value) {
/*  340 */       addCriterion("SELLER_ACCOUNT_ID <>", value, "sellerAccountId");
/*  341 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdGreaterThan(Long value) {
/*  345 */       addCriterion("SELLER_ACCOUNT_ID >", value, "sellerAccountId");
/*  346 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdGreaterThanOrEqualTo(Long value) {
/*  350 */       addCriterion("SELLER_ACCOUNT_ID >=", value, "sellerAccountId");
/*  351 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdLessThan(Long value) {
/*  355 */       addCriterion("SELLER_ACCOUNT_ID <", value, "sellerAccountId");
/*  356 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdLessThanOrEqualTo(Long value) {
/*  360 */       addCriterion("SELLER_ACCOUNT_ID <=", value, "sellerAccountId");
/*  361 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdIn(List<Long> values) {
/*  365 */       addCriterion("SELLER_ACCOUNT_ID in", values, "sellerAccountId");
/*  366 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdNotIn(List<Long> values) {
/*  370 */       addCriterion("SELLER_ACCOUNT_ID not in", values, "sellerAccountId");
/*  371 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdBetween(Long value1, Long value2) {
/*  375 */       addCriterion("SELLER_ACCOUNT_ID between", value1, value2, "sellerAccountId");
/*  376 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andSellerAccountIdNotBetween(Long value1, Long value2) {
/*  380 */       addCriterion("SELLER_ACCOUNT_ID not between", value1, value2, "sellerAccountId");
/*  381 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdIsNull() {
/*  385 */       addCriterion("ORDER_ID is null");
/*  386 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdIsNotNull() {
/*  390 */       addCriterion("ORDER_ID is not null");
/*  391 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdEqualTo(Long value) {
/*  395 */       addCriterion("ORDER_ID =", value, "orderId");
/*  396 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdNotEqualTo(Long value) {
/*  400 */       addCriterion("ORDER_ID <>", value, "orderId");
/*  401 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdGreaterThan(Long value) {
/*  405 */       addCriterion("ORDER_ID >", value, "orderId");
/*  406 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
/*  410 */       addCriterion("ORDER_ID >=", value, "orderId");
/*  411 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdLessThan(Long value) {
/*  415 */       addCriterion("ORDER_ID <", value, "orderId");
/*  416 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdLessThanOrEqualTo(Long value) {
/*  420 */       addCriterion("ORDER_ID <=", value, "orderId");
/*  421 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdIn(List<Long> values) {
/*  425 */       addCriterion("ORDER_ID in", values, "orderId");
/*  426 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdNotIn(List<Long> values) {
/*  430 */       addCriterion("ORDER_ID not in", values, "orderId");
/*  431 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdBetween(Long value1, Long value2) {
/*  435 */       addCriterion("ORDER_ID between", value1, value2, "orderId");
/*  436 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andOrderIdNotBetween(Long value1, Long value2) {
/*  440 */       addCriterion("ORDER_ID not between", value1, value2, "orderId");
/*  441 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdIsNull() {
/*  445 */       addCriterion("FINANC_APPLICATION_ID is null");
/*  446 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdIsNotNull() {
/*  450 */       addCriterion("FINANC_APPLICATION_ID is not null");
/*  451 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdEqualTo(Long value) {
/*  455 */       addCriterion("FINANC_APPLICATION_ID =", value, "financApplicationId");
/*  456 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdNotEqualTo(Long value) {
/*  460 */       addCriterion("FINANC_APPLICATION_ID <>", value, "financApplicationId");
/*  461 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdGreaterThan(Long value) {
/*  465 */       addCriterion("FINANC_APPLICATION_ID >", value, "financApplicationId");
/*  466 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdGreaterThanOrEqualTo(Long value) {
/*  470 */       addCriterion("FINANC_APPLICATION_ID >=", value, "financApplicationId");
/*  471 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdLessThan(Long value) {
/*  475 */       addCriterion("FINANC_APPLICATION_ID <", value, "financApplicationId");
/*  476 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdLessThanOrEqualTo(Long value) {
/*  480 */       addCriterion("FINANC_APPLICATION_ID <=", value, "financApplicationId");
/*  481 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdIn(List<Long> values) {
/*  485 */       addCriterion("FINANC_APPLICATION_ID in", values, "financApplicationId");
/*  486 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdNotIn(List<Long> values) {
/*  490 */       addCriterion("FINANC_APPLICATION_ID not in", values, "financApplicationId");
/*  491 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdBetween(Long value1, Long value2) {
/*  495 */       addCriterion("FINANC_APPLICATION_ID between", value1, value2, "financApplicationId");
/*  496 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andFinancApplicationIdNotBetween(Long value1, Long value2) {
/*  500 */       addCriterion("FINANC_APPLICATION_ID not between", value1, value2, "financApplicationId");
/*  501 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdIsNull() {
/*  505 */       addCriterion("WAREHOUSE_ID is null");
/*  506 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdIsNotNull() {
/*  510 */       addCriterion("WAREHOUSE_ID is not null");
/*  511 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdEqualTo(Long value) {
/*  515 */       addCriterion("WAREHOUSE_ID =", value, "warehouseId");
/*  516 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdNotEqualTo(Long value) {
/*  520 */       addCriterion("WAREHOUSE_ID <>", value, "warehouseId");
/*  521 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdGreaterThan(Long value) {
/*  525 */       addCriterion("WAREHOUSE_ID >", value, "warehouseId");
/*  526 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdGreaterThanOrEqualTo(Long value) {
/*  530 */       addCriterion("WAREHOUSE_ID >=", value, "warehouseId");
/*  531 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdLessThan(Long value) {
/*  535 */       addCriterion("WAREHOUSE_ID <", value, "warehouseId");
/*  536 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdLessThanOrEqualTo(Long value) {
/*  540 */       addCriterion("WAREHOUSE_ID <=", value, "warehouseId");
/*  541 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdIn(List<Long> values) {
/*  545 */       addCriterion("WAREHOUSE_ID in", values, "warehouseId");
/*  546 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdNotIn(List<Long> values) {
/*  550 */       addCriterion("WAREHOUSE_ID not in", values, "warehouseId");
/*  551 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdBetween(Long value1, Long value2) {
/*  555 */       addCriterion("WAREHOUSE_ID between", value1, value2, "warehouseId");
/*  556 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andWarehouseIdNotBetween(Long value1, Long value2) {
/*  560 */       addCriterion("WAREHOUSE_ID not between", value1, value2, "warehouseId");
/*  561 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdIsNull() {
/*  565 */       addCriterion("GOODS_ID is null");
/*  566 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdIsNotNull() {
/*  570 */       addCriterion("GOODS_ID is not null");
/*  571 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdEqualTo(Long value) {
/*  575 */       addCriterion("GOODS_ID =", value, "goodsId");
/*  576 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdNotEqualTo(Long value) {
/*  580 */       addCriterion("GOODS_ID <>", value, "goodsId");
/*  581 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdGreaterThan(Long value) {
/*  585 */       addCriterion("GOODS_ID >", value, "goodsId");
/*  586 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
/*  590 */       addCriterion("GOODS_ID >=", value, "goodsId");
/*  591 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdLessThan(Long value) {
/*  595 */       addCriterion("GOODS_ID <", value, "goodsId");
/*  596 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
/*  600 */       addCriterion("GOODS_ID <=", value, "goodsId");
/*  601 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdIn(List<Long> values) {
/*  605 */       addCriterion("GOODS_ID in", values, "goodsId");
/*  606 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdNotIn(List<Long> values) {
/*  610 */       addCriterion("GOODS_ID not in", values, "goodsId");
/*  611 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdBetween(Long value1, Long value2) {
/*  615 */       addCriterion("GOODS_ID between", value1, value2, "goodsId");
/*  616 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
/*  620 */       addCriterion("GOODS_ID not between", value1, value2, "goodsId");
/*  621 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityIsNull() {
/*  625 */       addCriterion("QUANTITY is null");
/*  626 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityIsNotNull() {
/*  630 */       addCriterion("QUANTITY is not null");
/*  631 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityEqualTo(BigDecimal value) {
/*  635 */       addCriterion("QUANTITY =", value, "quantity");
/*  636 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityNotEqualTo(BigDecimal value) {
/*  640 */       addCriterion("QUANTITY <>", value, "quantity");
/*  641 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityGreaterThan(BigDecimal value) {
/*  645 */       addCriterion("QUANTITY >", value, "quantity");
/*  646 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityGreaterThanOrEqualTo(BigDecimal value) {
/*  650 */       addCriterion("QUANTITY >=", value, "quantity");
/*  651 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityLessThan(BigDecimal value) {
/*  655 */       addCriterion("QUANTITY <", value, "quantity");
/*  656 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityLessThanOrEqualTo(BigDecimal value) {
/*  660 */       addCriterion("QUANTITY <=", value, "quantity");
/*  661 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityIn(List<BigDecimal> values) {
/*  665 */       addCriterion("QUANTITY in", values, "quantity");
/*  666 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityNotIn(List<BigDecimal> values) {
/*  670 */       addCriterion("QUANTITY not in", values, "quantity");
/*  671 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityBetween(BigDecimal value1, BigDecimal value2) {
/*  675 */       addCriterion("QUANTITY between", value1, value2, "quantity");
/*  676 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
/*  680 */       addCriterion("QUANTITY not between", value1, value2, "quantity");
/*  681 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceIsNull() {
/*  685 */       addCriterion("PRICE is null");
/*  686 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceIsNotNull() {
/*  690 */       addCriterion("PRICE is not null");
/*  691 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceEqualTo(Long value) {
/*  695 */       addCriterion("PRICE =", value, "price");
/*  696 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceNotEqualTo(Long value) {
/*  700 */       addCriterion("PRICE <>", value, "price");
/*  701 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceGreaterThan(Long value) {
/*  705 */       addCriterion("PRICE >", value, "price");
/*  706 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceGreaterThanOrEqualTo(Long value) {
/*  710 */       addCriterion("PRICE >=", value, "price");
/*  711 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceLessThan(Long value) {
/*  715 */       addCriterion("PRICE <", value, "price");
/*  716 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceLessThanOrEqualTo(Long value) {
/*  720 */       addCriterion("PRICE <=", value, "price");
/*  721 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceIn(List<Long> values) {
/*  725 */       addCriterion("PRICE in", values, "price");
/*  726 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceNotIn(List<Long> values) {
/*  730 */       addCriterion("PRICE not in", values, "price");
/*  731 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceBetween(Long value1, Long value2) {
/*  735 */       addCriterion("PRICE between", value1, value2, "price");
/*  736 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andPriceNotBetween(Long value1, Long value2) {
/*  740 */       addCriterion("PRICE not between", value1, value2, "price");
/*  741 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceIsNull() {
/*  745 */       addCriterion("TOTAL_PRICE is null");
/*  746 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceIsNotNull() {
/*  750 */       addCriterion("TOTAL_PRICE is not null");
/*  751 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceEqualTo(Long value) {
/*  755 */       addCriterion("TOTAL_PRICE =", value, "totalPrice");
/*  756 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceNotEqualTo(Long value) {
/*  760 */       addCriterion("TOTAL_PRICE <>", value, "totalPrice");
/*  761 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceGreaterThan(Long value) {
/*  765 */       addCriterion("TOTAL_PRICE >", value, "totalPrice");
/*  766 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceGreaterThanOrEqualTo(Long value) {
/*  770 */       addCriterion("TOTAL_PRICE >=", value, "totalPrice");
/*  771 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceLessThan(Long value) {
/*  775 */       addCriterion("TOTAL_PRICE <", value, "totalPrice");
/*  776 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceLessThanOrEqualTo(Long value) {
/*  780 */       addCriterion("TOTAL_PRICE <=", value, "totalPrice");
/*  781 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceIn(List<Long> values) {
/*  785 */       addCriterion("TOTAL_PRICE in", values, "totalPrice");
/*  786 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceNotIn(List<Long> values) {
/*  790 */       addCriterion("TOTAL_PRICE not in", values, "totalPrice");
/*  791 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceBetween(Long value1, Long value2) {
/*  795 */       addCriterion("TOTAL_PRICE between", value1, value2, "totalPrice");
/*  796 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andTotalPriceNotBetween(Long value1, Long value2) {
/*  800 */       addCriterion("TOTAL_PRICE not between", value1, value2, "totalPrice");
/*  801 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusIsNull() {
/*  805 */       addCriterion("DEAL_STATUS is null");
/*  806 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusIsNotNull() {
/*  810 */       addCriterion("DEAL_STATUS is not null");
/*  811 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusEqualTo(Short value) {
/*  815 */       addCriterion("DEAL_STATUS =", value, "dealStatus");
/*  816 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusNotEqualTo(Short value) {
/*  820 */       addCriterion("DEAL_STATUS <>", value, "dealStatus");
/*  821 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusGreaterThan(Short value) {
/*  825 */       addCriterion("DEAL_STATUS >", value, "dealStatus");
/*  826 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusGreaterThanOrEqualTo(Short value) {
/*  830 */       addCriterion("DEAL_STATUS >=", value, "dealStatus");
/*  831 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusLessThan(Short value) {
/*  835 */       addCriterion("DEAL_STATUS <", value, "dealStatus");
/*  836 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusLessThanOrEqualTo(Short value) {
/*  840 */       addCriterion("DEAL_STATUS <=", value, "dealStatus");
/*  841 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusIn(List<Short> values) {
/*  845 */       addCriterion("DEAL_STATUS in", values, "dealStatus");
/*  846 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusNotIn(List<Short> values) {
/*  850 */       addCriterion("DEAL_STATUS not in", values, "dealStatus");
/*  851 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusBetween(Short value1, Short value2) {
/*  855 */       addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
/*  856 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealStatusNotBetween(Short value1, Short value2) {
/*  860 */       addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
/*  861 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonIsNull() {
/*  865 */       addCriterion("DEAL_PERSON is null");
/*  866 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonIsNotNull() {
/*  870 */       addCriterion("DEAL_PERSON is not null");
/*  871 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonEqualTo(String value) {
/*  875 */       addCriterion("DEAL_PERSON =", value, "dealPerson");
/*  876 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonNotEqualTo(String value) {
/*  880 */       addCriterion("DEAL_PERSON <>", value, "dealPerson");
/*  881 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonGreaterThan(String value) {
/*  885 */       addCriterion("DEAL_PERSON >", value, "dealPerson");
/*  886 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonGreaterThanOrEqualTo(String value) {
/*  890 */       addCriterion("DEAL_PERSON >=", value, "dealPerson");
/*  891 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonLessThan(String value) {
/*  895 */       addCriterion("DEAL_PERSON <", value, "dealPerson");
/*  896 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonLessThanOrEqualTo(String value) {
/*  900 */       addCriterion("DEAL_PERSON <=", value, "dealPerson");
/*  901 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonLike(String value) {
/*  905 */       addCriterion("DEAL_PERSON like", value, "dealPerson");
/*  906 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonNotLike(String value) {
/*  910 */       addCriterion("DEAL_PERSON not like", value, "dealPerson");
/*  911 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonIn(List<String> values) {
/*  915 */       addCriterion("DEAL_PERSON in", values, "dealPerson");
/*  916 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonNotIn(List<String> values) {
/*  920 */       addCriterion("DEAL_PERSON not in", values, "dealPerson");
/*  921 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonBetween(String value1, String value2) {
/*  925 */       addCriterion("DEAL_PERSON between", value1, value2, "dealPerson");
/*  926 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealPersonNotBetween(String value1, String value2) {
/*  930 */       addCriterion("DEAL_PERSON not between", value1, value2, "dealPerson");
/*  931 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateIsNull() {
/*  935 */       addCriterion("DEAL_DATE is null");
/*  936 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateIsNotNull() {
/*  940 */       addCriterion("DEAL_DATE is not null");
/*  941 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateEqualTo(Date value) {
/*  945 */       addCriterion("DEAL_DATE =", value, "dealDate");
/*  946 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateNotEqualTo(Date value) {
/*  950 */       addCriterion("DEAL_DATE <>", value, "dealDate");
/*  951 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateGreaterThan(Date value) {
/*  955 */       addCriterion("DEAL_DATE >", value, "dealDate");
/*  956 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateGreaterThanOrEqualTo(Date value) {
/*  960 */       addCriterion("DEAL_DATE >=", value, "dealDate");
/*  961 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateLessThan(Date value) {
/*  965 */       addCriterion("DEAL_DATE <", value, "dealDate");
/*  966 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateLessThanOrEqualTo(Date value) {
/*  970 */       addCriterion("DEAL_DATE <=", value, "dealDate");
/*  971 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateIn(List<Date> values) {
/*  975 */       addCriterion("DEAL_DATE in", values, "dealDate");
/*  976 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateNotIn(List<Date> values) {
/*  980 */       addCriterion("DEAL_DATE not in", values, "dealDate");
/*  981 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateBetween(Date value1, Date value2) {
/*  985 */       addCriterion("DEAL_DATE between", value1, value2, "dealDate");
/*  986 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andDealDateNotBetween(Date value1, Date value2) {
/*  990 */       addCriterion("DEAL_DATE not between", value1, value2, "dealDate");
/*  991 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorIsNull() {
/*  995 */       addCriterion("CREATOR is null");
/*  996 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorIsNotNull() {
/* 1000 */       addCriterion("CREATOR is not null");
/* 1001 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorEqualTo(String value) {
/* 1005 */       addCriterion("CREATOR =", value, "creator");
/* 1006 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorNotEqualTo(String value) {
/* 1010 */       addCriterion("CREATOR <>", value, "creator");
/* 1011 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorGreaterThan(String value) {
/* 1015 */       addCriterion("CREATOR >", value, "creator");
/* 1016 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorGreaterThanOrEqualTo(String value) {
/* 1020 */       addCriterion("CREATOR >=", value, "creator");
/* 1021 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorLessThan(String value) {
/* 1025 */       addCriterion("CREATOR <", value, "creator");
/* 1026 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorLessThanOrEqualTo(String value) {
/* 1030 */       addCriterion("CREATOR <=", value, "creator");
/* 1031 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorLike(String value) {
/* 1035 */       addCriterion("CREATOR like", value, "creator");
/* 1036 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorNotLike(String value) {
/* 1040 */       addCriterion("CREATOR not like", value, "creator");
/* 1041 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorIn(List<String> values) {
/* 1045 */       addCriterion("CREATOR in", values, "creator");
/* 1046 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorNotIn(List<String> values) {
/* 1050 */       addCriterion("CREATOR not in", values, "creator");
/* 1051 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorBetween(String value1, String value2) {
/* 1055 */       addCriterion("CREATOR between", value1, value2, "creator");
/* 1056 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andCreatorNotBetween(String value1, String value2) {
/* 1060 */       addCriterion("CREATOR not between", value1, value2, "creator");
/* 1061 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierIsNull() {
/* 1065 */       addCriterion("MODIFIER is null");
/* 1066 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierIsNotNull() {
/* 1070 */       addCriterion("MODIFIER is not null");
/* 1071 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierEqualTo(String value) {
/* 1075 */       addCriterion("MODIFIER =", value, "modifier");
/* 1076 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierNotEqualTo(String value) {
/* 1080 */       addCriterion("MODIFIER <>", value, "modifier");
/* 1081 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierGreaterThan(String value) {
/* 1085 */       addCriterion("MODIFIER >", value, "modifier");
/* 1086 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierGreaterThanOrEqualTo(String value) {
/* 1090 */       addCriterion("MODIFIER >=", value, "modifier");
/* 1091 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierLessThan(String value) {
/* 1095 */       addCriterion("MODIFIER <", value, "modifier");
/* 1096 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierLessThanOrEqualTo(String value) {
/* 1100 */       addCriterion("MODIFIER <=", value, "modifier");
/* 1101 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierLike(String value) {
/* 1105 */       addCriterion("MODIFIER like", value, "modifier");
/* 1106 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierNotLike(String value) {
/* 1110 */       addCriterion("MODIFIER not like", value, "modifier");
/* 1111 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierIn(List<String> values) {
/* 1115 */       addCriterion("MODIFIER in", values, "modifier");
/* 1116 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierNotIn(List<String> values) {
/* 1120 */       addCriterion("MODIFIER not in", values, "modifier");
/* 1121 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierBetween(String value1, String value2) {
/* 1125 */       addCriterion("MODIFIER between", value1, value2, "modifier");
/* 1126 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andModifierNotBetween(String value1, String value2) {
/* 1130 */       addCriterion("MODIFIER not between", value1, value2, "modifier");
/* 1131 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateIsNull() {
/* 1135 */       addCriterion("GMT_CREATE is null");
/* 1136 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateIsNotNull() {
/* 1140 */       addCriterion("GMT_CREATE is not null");
/* 1141 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateEqualTo(Date value) {
/* 1145 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/* 1146 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/* 1150 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/* 1151 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/* 1155 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/* 1156 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/* 1160 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/* 1161 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateLessThan(Date value) {
/* 1165 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/* 1166 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/* 1170 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/* 1171 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateIn(List<Date> values) {
/* 1175 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/* 1176 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/* 1180 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/* 1181 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/* 1185 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/* 1186 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/* 1190 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/* 1191 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyIsNull() {
/* 1195 */       addCriterion("GMT_MODIFY is null");
/* 1196 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyIsNotNull() {
/* 1200 */       addCriterion("GMT_MODIFY is not null");
/* 1201 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyEqualTo(Date value) {
/* 1205 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/* 1206 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/* 1210 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/* 1211 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/* 1215 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/* 1216 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/* 1220 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/* 1221 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyLessThan(Date value) {
/* 1225 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/* 1226 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/* 1230 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/* 1231 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyIn(List<Date> values) {
/* 1235 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/* 1236 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/* 1240 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/* 1241 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/* 1245 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/* 1246 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancTransferFormCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/* 1250 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/* 1251 */       return (FinancTransferFormCriteria.Criteria)this;
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancTransferFormCriteria
 * JD-Core Version:    0.6.0
 */