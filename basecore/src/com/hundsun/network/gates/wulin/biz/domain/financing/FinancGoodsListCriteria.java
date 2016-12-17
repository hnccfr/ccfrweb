/*      */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class FinancGoodsListCriteria
/*      */ {
/*      */   protected String orderByClause;
/*      */   protected boolean distinct;
/*      */   protected List<Criteria> oredCriteria;
/*      */ 
/*      */   public FinancGoodsListCriteria()
/*      */   {
/*   30 */     this.oredCriteria = new ArrayList();
/*      */   }
/*      */ 
/*      */   protected FinancGoodsListCriteria(FinancGoodsListCriteria example)
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
/*      */   public static class Criteria extends FinancGoodsListCriteria.GeneratedCriteria {
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
/*      */     public FinancGoodsListCriteria.Criteria andIdIsNull() {
/*  205 */       addCriterion("ID is null");
/*  206 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdIsNotNull() {
/*  210 */       addCriterion("ID is not null");
/*  211 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdEqualTo(Long value) {
/*  215 */       addCriterion("ID =", value, "id");
/*  216 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdNotEqualTo(Long value) {
/*  220 */       addCriterion("ID <>", value, "id");
/*  221 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdGreaterThan(Long value) {
/*  225 */       addCriterion("ID >", value, "id");
/*  226 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/*  230 */       addCriterion("ID >=", value, "id");
/*  231 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdLessThan(Long value) {
/*  235 */       addCriterion("ID <", value, "id");
/*  236 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/*  240 */       addCriterion("ID <=", value, "id");
/*  241 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdIn(List<Long> values) {
/*  245 */       addCriterion("ID in", values, "id");
/*  246 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdNotIn(List<Long> values) {
/*  250 */       addCriterion("ID not in", values, "id");
/*  251 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdBetween(Long value1, Long value2) {
/*  255 */       addCriterion("ID between", value1, value2, "id");
/*  256 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/*  260 */       addCriterion("ID not between", value1, value2, "id");
/*  261 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdIsNull() {
/*  265 */       addCriterion("WAREHOUSE_ID is null");
/*  266 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdIsNotNull() {
/*  270 */       addCriterion("WAREHOUSE_ID is not null");
/*  271 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdEqualTo(Long value) {
/*  275 */       addCriterion("WAREHOUSE_ID =", value, "warehouseId");
/*  276 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdNotEqualTo(Long value) {
/*  280 */       addCriterion("WAREHOUSE_ID <>", value, "warehouseId");
/*  281 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdGreaterThan(Long value) {
/*  285 */       addCriterion("WAREHOUSE_ID >", value, "warehouseId");
/*  286 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdGreaterThanOrEqualTo(Long value) {
/*  290 */       addCriterion("WAREHOUSE_ID >=", value, "warehouseId");
/*  291 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdLessThan(Long value) {
/*  295 */       addCriterion("WAREHOUSE_ID <", value, "warehouseId");
/*  296 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdLessThanOrEqualTo(Long value) {
/*  300 */       addCriterion("WAREHOUSE_ID <=", value, "warehouseId");
/*  301 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdIn(List<Long> values) {
/*  305 */       addCriterion("WAREHOUSE_ID in", values, "warehouseId");
/*  306 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdNotIn(List<Long> values) {
/*  310 */       addCriterion("WAREHOUSE_ID not in", values, "warehouseId");
/*  311 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdBetween(Long value1, Long value2) {
/*  315 */       addCriterion("WAREHOUSE_ID between", value1, value2, "warehouseId");
/*  316 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andWarehouseIdNotBetween(Long value1, Long value2) {
/*  320 */       addCriterion("WAREHOUSE_ID not between", value1, value2, "warehouseId");
/*  321 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdIsNull() {
/*  325 */       addCriterion("GOODS_ID is null");
/*  326 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdIsNotNull() {
/*  330 */       addCriterion("GOODS_ID is not null");
/*  331 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdEqualTo(Long value) {
/*  335 */       addCriterion("GOODS_ID =", value, "goodsId");
/*  336 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdNotEqualTo(Long value) {
/*  340 */       addCriterion("GOODS_ID <>", value, "goodsId");
/*  341 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdGreaterThan(Long value) {
/*  345 */       addCriterion("GOODS_ID >", value, "goodsId");
/*  346 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
/*  350 */       addCriterion("GOODS_ID >=", value, "goodsId");
/*  351 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdLessThan(Long value) {
/*  355 */       addCriterion("GOODS_ID <", value, "goodsId");
/*  356 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
/*  360 */       addCriterion("GOODS_ID <=", value, "goodsId");
/*  361 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdIn(List<Long> values) {
/*  365 */       addCriterion("GOODS_ID in", values, "goodsId");
/*  366 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdNotIn(List<Long> values) {
/*  370 */       addCriterion("GOODS_ID not in", values, "goodsId");
/*  371 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdBetween(Long value1, Long value2) {
/*  375 */       addCriterion("GOODS_ID between", value1, value2, "goodsId");
/*  376 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
/*  380 */       addCriterion("GOODS_ID not between", value1, value2, "goodsId");
/*  381 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameIsNull() {
/*  385 */       addCriterion("GOODS_NAME is null");
/*  386 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameIsNotNull() {
/*  390 */       addCriterion("GOODS_NAME is not null");
/*  391 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameEqualTo(String value) {
/*  395 */       addCriterion("GOODS_NAME =", value, "goodsName");
/*  396 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameNotEqualTo(String value) {
/*  400 */       addCriterion("GOODS_NAME <>", value, "goodsName");
/*  401 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameGreaterThan(String value) {
/*  405 */       addCriterion("GOODS_NAME >", value, "goodsName");
/*  406 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
/*  410 */       addCriterion("GOODS_NAME >=", value, "goodsName");
/*  411 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameLessThan(String value) {
/*  415 */       addCriterion("GOODS_NAME <", value, "goodsName");
/*  416 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameLessThanOrEqualTo(String value) {
/*  420 */       addCriterion("GOODS_NAME <=", value, "goodsName");
/*  421 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameLike(String value) {
/*  425 */       addCriterion("GOODS_NAME like", value, "goodsName");
/*  426 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameNotLike(String value) {
/*  430 */       addCriterion("GOODS_NAME not like", value, "goodsName");
/*  431 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameIn(List<String> values) {
/*  435 */       addCriterion("GOODS_NAME in", values, "goodsName");
/*  436 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameNotIn(List<String> values) {
/*  440 */       addCriterion("GOODS_NAME not in", values, "goodsName");
/*  441 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameBetween(String value1, String value2) {
/*  445 */       addCriterion("GOODS_NAME between", value1, value2, "goodsName");
/*  446 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsNameNotBetween(String value1, String value2) {
/*  450 */       addCriterion("GOODS_NAME not between", value1, value2, "goodsName");
/*  451 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecIsNull() {
/*  455 */       addCriterion("GOODS_SPEC is null");
/*  456 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecIsNotNull() {
/*  460 */       addCriterion("GOODS_SPEC is not null");
/*  461 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecEqualTo(String value) {
/*  465 */       addCriterion("GOODS_SPEC =", value, "goodsSpec");
/*  466 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecNotEqualTo(String value) {
/*  470 */       addCriterion("GOODS_SPEC <>", value, "goodsSpec");
/*  471 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecGreaterThan(String value) {
/*  475 */       addCriterion("GOODS_SPEC >", value, "goodsSpec");
/*  476 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecGreaterThanOrEqualTo(String value) {
/*  480 */       addCriterion("GOODS_SPEC >=", value, "goodsSpec");
/*  481 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecLessThan(String value) {
/*  485 */       addCriterion("GOODS_SPEC <", value, "goodsSpec");
/*  486 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecLessThanOrEqualTo(String value) {
/*  490 */       addCriterion("GOODS_SPEC <=", value, "goodsSpec");
/*  491 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecLike(String value) {
/*  495 */       addCriterion("GOODS_SPEC like", value, "goodsSpec");
/*  496 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecNotLike(String value) {
/*  500 */       addCriterion("GOODS_SPEC not like", value, "goodsSpec");
/*  501 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecIn(List<String> values) {
/*  505 */       addCriterion("GOODS_SPEC in", values, "goodsSpec");
/*  506 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecNotIn(List<String> values) {
/*  510 */       addCriterion("GOODS_SPEC not in", values, "goodsSpec");
/*  511 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecBetween(String value1, String value2) {
/*  515 */       addCriterion("GOODS_SPEC between", value1, value2, "goodsSpec");
/*  516 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsSpecNotBetween(String value1, String value2) {
/*  520 */       addCriterion("GOODS_SPEC not between", value1, value2, "goodsSpec");
/*  521 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsIsNull() {
/*  525 */       addCriterion("GOODS_UNITS is null");
/*  526 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsIsNotNull() {
/*  530 */       addCriterion("GOODS_UNITS is not null");
/*  531 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsEqualTo(String value) {
/*  535 */       addCriterion("GOODS_UNITS =", value, "goodsUnits");
/*  536 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsNotEqualTo(String value) {
/*  540 */       addCriterion("GOODS_UNITS <>", value, "goodsUnits");
/*  541 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsGreaterThan(String value) {
/*  545 */       addCriterion("GOODS_UNITS >", value, "goodsUnits");
/*  546 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsGreaterThanOrEqualTo(String value) {
/*  550 */       addCriterion("GOODS_UNITS >=", value, "goodsUnits");
/*  551 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsLessThan(String value) {
/*  555 */       addCriterion("GOODS_UNITS <", value, "goodsUnits");
/*  556 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsLessThanOrEqualTo(String value) {
/*  560 */       addCriterion("GOODS_UNITS <=", value, "goodsUnits");
/*  561 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsLike(String value) {
/*  565 */       addCriterion("GOODS_UNITS like", value, "goodsUnits");
/*  566 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsNotLike(String value) {
/*  570 */       addCriterion("GOODS_UNITS not like", value, "goodsUnits");
/*  571 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsIn(List<String> values) {
/*  575 */       addCriterion("GOODS_UNITS in", values, "goodsUnits");
/*  576 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsNotIn(List<String> values) {
/*  580 */       addCriterion("GOODS_UNITS not in", values, "goodsUnits");
/*  581 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsBetween(String value1, String value2) {
/*  585 */       addCriterion("GOODS_UNITS between", value1, value2, "goodsUnits");
/*  586 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGoodsUnitsNotBetween(String value1, String value2) {
/*  590 */       addCriterion("GOODS_UNITS not between", value1, value2, "goodsUnits");
/*  591 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityIsNull() {
/*  595 */       addCriterion("ORI_QUANTITY is null");
/*  596 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityIsNotNull() {
/*  600 */       addCriterion("ORI_QUANTITY is not null");
/*  601 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityEqualTo(BigDecimal value) {
/*  605 */       addCriterion("ORI_QUANTITY =", value, "oriQuantity");
/*  606 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityNotEqualTo(BigDecimal value) {
/*  610 */       addCriterion("ORI_QUANTITY <>", value, "oriQuantity");
/*  611 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityGreaterThan(BigDecimal value) {
/*  615 */       addCriterion("ORI_QUANTITY >", value, "oriQuantity");
/*  616 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityGreaterThanOrEqualTo(BigDecimal value) {
/*  620 */       addCriterion("ORI_QUANTITY >=", value, "oriQuantity");
/*  621 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityLessThan(BigDecimal value) {
/*  625 */       addCriterion("ORI_QUANTITY <", value, "oriQuantity");
/*  626 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityLessThanOrEqualTo(BigDecimal value) {
/*  630 */       addCriterion("ORI_QUANTITY <=", value, "oriQuantity");
/*  631 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityIn(List<BigDecimal> values) {
/*  635 */       addCriterion("ORI_QUANTITY in", values, "oriQuantity");
/*  636 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityNotIn(List<BigDecimal> values) {
/*  640 */       addCriterion("ORI_QUANTITY not in", values, "oriQuantity");
/*  641 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityBetween(BigDecimal value1, BigDecimal value2) {
/*  645 */       addCriterion("ORI_QUANTITY between", value1, value2, "oriQuantity");
/*  646 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
/*  650 */       addCriterion("ORI_QUANTITY not between", value1, value2, "oriQuantity");
/*  651 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityIsNull() {
/*  655 */       addCriterion("REMAIN_QUANTITY is null");
/*  656 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityIsNotNull() {
/*  660 */       addCriterion("REMAIN_QUANTITY is not null");
/*  661 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityEqualTo(BigDecimal value) {
/*  665 */       addCriterion("REMAIN_QUANTITY =", value, "remainQuantity");
/*  666 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityNotEqualTo(BigDecimal value) {
/*  670 */       addCriterion("REMAIN_QUANTITY <>", value, "remainQuantity");
/*  671 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityGreaterThan(BigDecimal value) {
/*  675 */       addCriterion("REMAIN_QUANTITY >", value, "remainQuantity");
/*  676 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityGreaterThanOrEqualTo(BigDecimal value) {
/*  680 */       addCriterion("REMAIN_QUANTITY >=", value, "remainQuantity");
/*  681 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityLessThan(BigDecimal value) {
/*  685 */       addCriterion("REMAIN_QUANTITY <", value, "remainQuantity");
/*  686 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityLessThanOrEqualTo(BigDecimal value) {
/*  690 */       addCriterion("REMAIN_QUANTITY <=", value, "remainQuantity");
/*  691 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityIn(List<BigDecimal> values) {
/*  695 */       addCriterion("REMAIN_QUANTITY in", values, "remainQuantity");
/*  696 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityNotIn(List<BigDecimal> values) {
/*  700 */       addCriterion("REMAIN_QUANTITY not in", values, "remainQuantity");
/*  701 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityBetween(BigDecimal value1, BigDecimal value2) {
/*  705 */       addCriterion("REMAIN_QUANTITY between", value1, value2, "remainQuantity");
/*  706 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andRemainQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
/*  710 */       addCriterion("REMAIN_QUANTITY not between", value1, value2, "remainQuantity");
/*  711 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceIsNull() {
/*  715 */       addCriterion("ORI_PRICE is null");
/*  716 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceIsNotNull() {
/*  720 */       addCriterion("ORI_PRICE is not null");
/*  721 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceEqualTo(Long value) {
/*  725 */       addCriterion("ORI_PRICE =", value, "oriPrice");
/*  726 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceNotEqualTo(Long value) {
/*  730 */       addCriterion("ORI_PRICE <>", value, "oriPrice");
/*  731 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceGreaterThan(Long value) {
/*  735 */       addCriterion("ORI_PRICE >", value, "oriPrice");
/*  736 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceGreaterThanOrEqualTo(Long value) {
/*  740 */       addCriterion("ORI_PRICE >=", value, "oriPrice");
/*  741 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceLessThan(Long value) {
/*  745 */       addCriterion("ORI_PRICE <", value, "oriPrice");
/*  746 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceLessThanOrEqualTo(Long value) {
/*  750 */       addCriterion("ORI_PRICE <=", value, "oriPrice");
/*  751 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceIn(List<Long> values) {
/*  755 */       addCriterion("ORI_PRICE in", values, "oriPrice");
/*  756 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceNotIn(List<Long> values) {
/*  760 */       addCriterion("ORI_PRICE not in", values, "oriPrice");
/*  761 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceBetween(Long value1, Long value2) {
/*  765 */       addCriterion("ORI_PRICE between", value1, value2, "oriPrice");
/*  766 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriPriceNotBetween(Long value1, Long value2) {
/*  770 */       addCriterion("ORI_PRICE not between", value1, value2, "oriPrice");
/*  771 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceIsNull() {
/*  775 */       addCriterion("ORI_TOTAL_PRICE is null");
/*  776 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceIsNotNull() {
/*  780 */       addCriterion("ORI_TOTAL_PRICE is not null");
/*  781 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceEqualTo(Long value) {
/*  785 */       addCriterion("ORI_TOTAL_PRICE =", value, "oriTotalPrice");
/*  786 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceNotEqualTo(Long value) {
/*  790 */       addCriterion("ORI_TOTAL_PRICE <>", value, "oriTotalPrice");
/*  791 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceGreaterThan(Long value) {
/*  795 */       addCriterion("ORI_TOTAL_PRICE >", value, "oriTotalPrice");
/*  796 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceGreaterThanOrEqualTo(Long value) {
/*  800 */       addCriterion("ORI_TOTAL_PRICE >=", value, "oriTotalPrice");
/*  801 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceLessThan(Long value) {
/*  805 */       addCriterion("ORI_TOTAL_PRICE <", value, "oriTotalPrice");
/*  806 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceLessThanOrEqualTo(Long value) {
/*  810 */       addCriterion("ORI_TOTAL_PRICE <=", value, "oriTotalPrice");
/*  811 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceIn(List<Long> values) {
/*  815 */       addCriterion("ORI_TOTAL_PRICE in", values, "oriTotalPrice");
/*  816 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceNotIn(List<Long> values) {
/*  820 */       addCriterion("ORI_TOTAL_PRICE not in", values, "oriTotalPrice");
/*  821 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceBetween(Long value1, Long value2) {
/*  825 */       addCriterion("ORI_TOTAL_PRICE between", value1, value2, "oriTotalPrice");
/*  826 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andOriTotalPriceNotBetween(Long value1, Long value2) {
/*  830 */       addCriterion("ORI_TOTAL_PRICE not between", value1, value2, "oriTotalPrice");
/*  831 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateIsNull() {
/*  835 */       addCriterion("GMT_CREATE is null");
/*  836 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateIsNotNull() {
/*  840 */       addCriterion("GMT_CREATE is not null");
/*  841 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateEqualTo(Date value) {
/*  845 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/*  846 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/*  850 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/*  851 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/*  855 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/*  856 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/*  860 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/*  861 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateLessThan(Date value) {
/*  865 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/*  866 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/*  870 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/*  871 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateIn(List<Date> values) {
/*  875 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/*  876 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/*  880 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/*  881 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/*  885 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/*  886 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/*  890 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/*  891 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyIsNull() {
/*  895 */       addCriterion("GMT_MODIFY is null");
/*  896 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyIsNotNull() {
/*  900 */       addCriterion("GMT_MODIFY is not null");
/*  901 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyEqualTo(Date value) {
/*  905 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/*  906 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/*  910 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/*  911 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/*  915 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/*  916 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/*  920 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/*  921 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyLessThan(Date value) {
/*  925 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/*  926 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/*  930 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/*  931 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyIn(List<Date> values) {
/*  935 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/*  936 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/*  940 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/*  941 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/*  945 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/*  946 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/*  950 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/*  951 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoIsNull() {
/*  955 */       addCriterion("MEMO is null");
/*  956 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoIsNotNull() {
/*  960 */       addCriterion("MEMO is not null");
/*  961 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoEqualTo(String value) {
/*  965 */       addCriterion("MEMO =", value, "memo");
/*  966 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoNotEqualTo(String value) {
/*  970 */       addCriterion("MEMO <>", value, "memo");
/*  971 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoGreaterThan(String value) {
/*  975 */       addCriterion("MEMO >", value, "memo");
/*  976 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoGreaterThanOrEqualTo(String value) {
/*  980 */       addCriterion("MEMO >=", value, "memo");
/*  981 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoLessThan(String value) {
/*  985 */       addCriterion("MEMO <", value, "memo");
/*  986 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoLessThanOrEqualTo(String value) {
/*  990 */       addCriterion("MEMO <=", value, "memo");
/*  991 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoLike(String value) {
/*  995 */       addCriterion("MEMO like", value, "memo");
/*  996 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoNotLike(String value) {
/* 1000 */       addCriterion("MEMO not like", value, "memo");
/* 1001 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoIn(List<String> values) {
/* 1005 */       addCriterion("MEMO in", values, "memo");
/* 1006 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoNotIn(List<String> values) {
/* 1010 */       addCriterion("MEMO not in", values, "memo");
/* 1011 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoBetween(String value1, String value2) {
/* 1015 */       addCriterion("MEMO between", value1, value2, "memo");
/* 1016 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andMemoNotBetween(String value1, String value2) {
/* 1020 */       addCriterion("MEMO not between", value1, value2, "memo");
/* 1021 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityIsNull() {
/* 1025 */       addCriterion("FROZEN_QUANTITY is null");
/* 1026 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityIsNotNull() {
/* 1030 */       addCriterion("FROZEN_QUANTITY is not null");
/* 1031 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityEqualTo(BigDecimal value) {
/* 1035 */       addCriterion("FROZEN_QUANTITY =", value, "frozenQuantity");
/* 1036 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityNotEqualTo(BigDecimal value) {
/* 1040 */       addCriterion("FROZEN_QUANTITY <>", value, "frozenQuantity");
/* 1041 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityGreaterThan(BigDecimal value) {
/* 1045 */       addCriterion("FROZEN_QUANTITY >", value, "frozenQuantity");
/* 1046 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityGreaterThanOrEqualTo(BigDecimal value) {
/* 1050 */       addCriterion("FROZEN_QUANTITY >=", value, "frozenQuantity");
/* 1051 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityLessThan(BigDecimal value) {
/* 1055 */       addCriterion("FROZEN_QUANTITY <", value, "frozenQuantity");
/* 1056 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityLessThanOrEqualTo(BigDecimal value) {
/* 1060 */       addCriterion("FROZEN_QUANTITY <=", value, "frozenQuantity");
/* 1061 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityIn(List<BigDecimal> values) {
/* 1065 */       addCriterion("FROZEN_QUANTITY in", values, "frozenQuantity");
/* 1066 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityNotIn(List<BigDecimal> values) {
/* 1070 */       addCriterion("FROZEN_QUANTITY not in", values, "frozenQuantity");
/* 1071 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityBetween(BigDecimal value1, BigDecimal value2) {
/* 1075 */       addCriterion("FROZEN_QUANTITY between", value1, value2, "frozenQuantity");
/* 1076 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancGoodsListCriteria.Criteria andFrozenQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
/* 1080 */       addCriterion("FROZEN_QUANTITY not between", value1, value2, "frozenQuantity");
/* 1081 */       return (FinancGoodsListCriteria.Criteria)this;
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsListCriteria
 * JD-Core Version:    0.6.0
 */