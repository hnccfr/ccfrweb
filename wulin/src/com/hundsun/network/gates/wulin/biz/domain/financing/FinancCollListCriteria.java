/*      */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class FinancCollListCriteria
/*      */ {
/*      */   protected String orderByClause;
/*      */   protected boolean distinct;
/*      */   protected List<Criteria> oredCriteria;
/*      */ 
/*      */   public FinancCollListCriteria()
/*      */   {
/*   30 */     this.oredCriteria = new ArrayList();
/*      */   }
/*      */ 
/*      */   protected FinancCollListCriteria(FinancCollListCriteria example)
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
/*      */   public static class Criteria extends FinancCollListCriteria.GeneratedCriteria {
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
/*      */     public FinancCollListCriteria.Criteria andIdIsNull() {
/*  205 */       addCriterion("ID is null");
/*  206 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdIsNotNull() {
/*  210 */       addCriterion("ID is not null");
/*  211 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdEqualTo(Long value) {
/*  215 */       addCriterion("ID =", value, "id");
/*  216 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdNotEqualTo(Long value) {
/*  220 */       addCriterion("ID <>", value, "id");
/*  221 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdGreaterThan(Long value) {
/*  225 */       addCriterion("ID >", value, "id");
/*  226 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/*  230 */       addCriterion("ID >=", value, "id");
/*  231 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdLessThan(Long value) {
/*  235 */       addCriterion("ID <", value, "id");
/*  236 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/*  240 */       addCriterion("ID <=", value, "id");
/*  241 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdIn(List<Long> values) {
/*  245 */       addCriterion("ID in", values, "id");
/*  246 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdNotIn(List<Long> values) {
/*  250 */       addCriterion("ID not in", values, "id");
/*  251 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdBetween(Long value1, Long value2) {
/*  255 */       addCriterion("ID between", value1, value2, "id");
/*  256 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/*  260 */       addCriterion("ID not between", value1, value2, "id");
/*  261 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoIsNull() {
/*  265 */       addCriterion("SERIAL_NO is null");
/*  266 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoIsNotNull() {
/*  270 */       addCriterion("SERIAL_NO is not null");
/*  271 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoEqualTo(Long value) {
/*  275 */       addCriterion("SERIAL_NO =", value, "serialNo");
/*  276 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoNotEqualTo(Long value) {
/*  280 */       addCriterion("SERIAL_NO <>", value, "serialNo");
/*  281 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoGreaterThan(Long value) {
/*  285 */       addCriterion("SERIAL_NO >", value, "serialNo");
/*  286 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoGreaterThanOrEqualTo(Long value) {
/*  290 */       addCriterion("SERIAL_NO >=", value, "serialNo");
/*  291 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoLessThan(Long value) {
/*  295 */       addCriterion("SERIAL_NO <", value, "serialNo");
/*  296 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoLessThanOrEqualTo(Long value) {
/*  300 */       addCriterion("SERIAL_NO <=", value, "serialNo");
/*  301 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoIn(List<Long> values) {
/*  305 */       addCriterion("SERIAL_NO in", values, "serialNo");
/*  306 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoNotIn(List<Long> values) {
/*  310 */       addCriterion("SERIAL_NO not in", values, "serialNo");
/*  311 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoBetween(Long value1, Long value2) {
/*  315 */       addCriterion("SERIAL_NO between", value1, value2, "serialNo");
/*  316 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andSerialNoNotBetween(Long value1, Long value2) {
/*  320 */       addCriterion("SERIAL_NO not between", value1, value2, "serialNo");
/*  321 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdIsNull() {
/*  325 */       addCriterion("WAREHOUSE_ID is null");
/*  326 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdIsNotNull() {
/*  330 */       addCriterion("WAREHOUSE_ID is not null");
/*  331 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdEqualTo(Long value) {
/*  335 */       addCriterion("WAREHOUSE_ID =", value, "warehouseId");
/*  336 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdNotEqualTo(Long value) {
/*  340 */       addCriterion("WAREHOUSE_ID <>", value, "warehouseId");
/*  341 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdGreaterThan(Long value) {
/*  345 */       addCriterion("WAREHOUSE_ID >", value, "warehouseId");
/*  346 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdGreaterThanOrEqualTo(Long value) {
/*  350 */       addCriterion("WAREHOUSE_ID >=", value, "warehouseId");
/*  351 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdLessThan(Long value) {
/*  355 */       addCriterion("WAREHOUSE_ID <", value, "warehouseId");
/*  356 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdLessThanOrEqualTo(Long value) {
/*  360 */       addCriterion("WAREHOUSE_ID <=", value, "warehouseId");
/*  361 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdIn(List<Long> values) {
/*  365 */       addCriterion("WAREHOUSE_ID in", values, "warehouseId");
/*  366 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdNotIn(List<Long> values) {
/*  370 */       addCriterion("WAREHOUSE_ID not in", values, "warehouseId");
/*  371 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdBetween(Long value1, Long value2) {
/*  375 */       addCriterion("WAREHOUSE_ID between", value1, value2, "warehouseId");
/*  376 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andWarehouseIdNotBetween(Long value1, Long value2) {
/*  380 */       addCriterion("WAREHOUSE_ID not between", value1, value2, "warehouseId");
/*  381 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdIsNull() {
/*  385 */       addCriterion("GOODS_LIST_ID is null");
/*  386 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdIsNotNull() {
/*  390 */       addCriterion("GOODS_LIST_ID is not null");
/*  391 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdEqualTo(Long value) {
/*  395 */       addCriterion("GOODS_LIST_ID =", value, "goodsListId");
/*  396 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdNotEqualTo(Long value) {
/*  400 */       addCriterion("GOODS_LIST_ID <>", value, "goodsListId");
/*  401 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdGreaterThan(Long value) {
/*  405 */       addCriterion("GOODS_LIST_ID >", value, "goodsListId");
/*  406 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdGreaterThanOrEqualTo(Long value) {
/*  410 */       addCriterion("GOODS_LIST_ID >=", value, "goodsListId");
/*  411 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdLessThan(Long value) {
/*  415 */       addCriterion("GOODS_LIST_ID <", value, "goodsListId");
/*  416 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdLessThanOrEqualTo(Long value) {
/*  420 */       addCriterion("GOODS_LIST_ID <=", value, "goodsListId");
/*  421 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdIn(List<Long> values) {
/*  425 */       addCriterion("GOODS_LIST_ID in", values, "goodsListId");
/*  426 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdNotIn(List<Long> values) {
/*  430 */       addCriterion("GOODS_LIST_ID not in", values, "goodsListId");
/*  431 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdBetween(Long value1, Long value2) {
/*  435 */       addCriterion("GOODS_LIST_ID between", value1, value2, "goodsListId");
/*  436 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGoodsListIdNotBetween(Long value1, Long value2) {
/*  440 */       addCriterion("GOODS_LIST_ID not between", value1, value2, "goodsListId");
/*  441 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioIsNull() {
/*  445 */       addCriterion("RATIO is null");
/*  446 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioIsNotNull() {
/*  450 */       addCriterion("RATIO is not null");
/*  451 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioEqualTo(BigDecimal value) {
/*  455 */       addCriterion("RATIO =", value, "ratio");
/*  456 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioNotEqualTo(BigDecimal value) {
/*  460 */       addCriterion("RATIO <>", value, "ratio");
/*  461 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioGreaterThan(BigDecimal value) {
/*  465 */       addCriterion("RATIO >", value, "ratio");
/*  466 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioGreaterThanOrEqualTo(BigDecimal value) {
/*  470 */       addCriterion("RATIO >=", value, "ratio");
/*  471 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioLessThan(BigDecimal value) {
/*  475 */       addCriterion("RATIO <", value, "ratio");
/*  476 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioLessThanOrEqualTo(BigDecimal value) {
/*  480 */       addCriterion("RATIO <=", value, "ratio");
/*  481 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioIn(List<BigDecimal> values) {
/*  485 */       addCriterion("RATIO in", values, "ratio");
/*  486 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioNotIn(List<BigDecimal> values) {
/*  490 */       addCriterion("RATIO not in", values, "ratio");
/*  491 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioBetween(BigDecimal value1, BigDecimal value2) {
/*  495 */       addCriterion("RATIO between", value1, value2, "ratio");
/*  496 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andRatioNotBetween(BigDecimal value1, BigDecimal value2) {
/*  500 */       addCriterion("RATIO not between", value1, value2, "ratio");
/*  501 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumIsNull() {
/*  505 */       addCriterion("CUR_COLL_NUM is null");
/*  506 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumIsNotNull() {
/*  510 */       addCriterion("CUR_COLL_NUM is not null");
/*  511 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumEqualTo(BigDecimal value) {
/*  515 */       addCriterion("CUR_COLL_NUM =", value, "curCollNum");
/*  516 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumNotEqualTo(BigDecimal value) {
/*  520 */       addCriterion("CUR_COLL_NUM <>", value, "curCollNum");
/*  521 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumGreaterThan(BigDecimal value) {
/*  525 */       addCriterion("CUR_COLL_NUM >", value, "curCollNum");
/*  526 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumGreaterThanOrEqualTo(BigDecimal value) {
/*  530 */       addCriterion("CUR_COLL_NUM >=", value, "curCollNum");
/*  531 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumLessThan(BigDecimal value) {
/*  535 */       addCriterion("CUR_COLL_NUM <", value, "curCollNum");
/*  536 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumLessThanOrEqualTo(BigDecimal value) {
/*  540 */       addCriterion("CUR_COLL_NUM <=", value, "curCollNum");
/*  541 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumIn(List<BigDecimal> values) {
/*  545 */       addCriterion("CUR_COLL_NUM in", values, "curCollNum");
/*  546 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumNotIn(List<BigDecimal> values) {
/*  550 */       addCriterion("CUR_COLL_NUM not in", values, "curCollNum");
/*  551 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumBetween(BigDecimal value1, BigDecimal value2) {
/*  555 */       addCriterion("CUR_COLL_NUM between", value1, value2, "curCollNum");
/*  556 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurCollNumNotBetween(BigDecimal value1, BigDecimal value2) {
/*  560 */       addCriterion("CUR_COLL_NUM not between", value1, value2, "curCollNum");
/*  561 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceIsNull() {
/*  565 */       addCriterion("CUR_UNIT_PRICE is null");
/*  566 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceIsNotNull() {
/*  570 */       addCriterion("CUR_UNIT_PRICE is not null");
/*  571 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceEqualTo(Long value) {
/*  575 */       addCriterion("CUR_UNIT_PRICE =", value, "curUnitPrice");
/*  576 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceNotEqualTo(Long value) {
/*  580 */       addCriterion("CUR_UNIT_PRICE <>", value, "curUnitPrice");
/*  581 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceGreaterThan(Long value) {
/*  585 */       addCriterion("CUR_UNIT_PRICE >", value, "curUnitPrice");
/*  586 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceGreaterThanOrEqualTo(Long value) {
/*  590 */       addCriterion("CUR_UNIT_PRICE >=", value, "curUnitPrice");
/*  591 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceLessThan(Long value) {
/*  595 */       addCriterion("CUR_UNIT_PRICE <", value, "curUnitPrice");
/*  596 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceLessThanOrEqualTo(Long value) {
/*  600 */       addCriterion("CUR_UNIT_PRICE <=", value, "curUnitPrice");
/*  601 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceIn(List<Long> values) {
/*  605 */       addCriterion("CUR_UNIT_PRICE in", values, "curUnitPrice");
/*  606 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceNotIn(List<Long> values) {
/*  610 */       addCriterion("CUR_UNIT_PRICE not in", values, "curUnitPrice");
/*  611 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceBetween(Long value1, Long value2) {
/*  615 */       addCriterion("CUR_UNIT_PRICE between", value1, value2, "curUnitPrice");
/*  616 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurUnitPriceNotBetween(Long value1, Long value2) {
/*  620 */       addCriterion("CUR_UNIT_PRICE not between", value1, value2, "curUnitPrice");
/*  621 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceIsNull() {
/*  625 */       addCriterion("CUR_TOTAL_PRICE is null");
/*  626 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceIsNotNull() {
/*  630 */       addCriterion("CUR_TOTAL_PRICE is not null");
/*  631 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceEqualTo(Long value) {
/*  635 */       addCriterion("CUR_TOTAL_PRICE =", value, "curTotalPrice");
/*  636 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceNotEqualTo(Long value) {
/*  640 */       addCriterion("CUR_TOTAL_PRICE <>", value, "curTotalPrice");
/*  641 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceGreaterThan(Long value) {
/*  645 */       addCriterion("CUR_TOTAL_PRICE >", value, "curTotalPrice");
/*  646 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceGreaterThanOrEqualTo(Long value) {
/*  650 */       addCriterion("CUR_TOTAL_PRICE >=", value, "curTotalPrice");
/*  651 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceLessThan(Long value) {
/*  655 */       addCriterion("CUR_TOTAL_PRICE <", value, "curTotalPrice");
/*  656 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceLessThanOrEqualTo(Long value) {
/*  660 */       addCriterion("CUR_TOTAL_PRICE <=", value, "curTotalPrice");
/*  661 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceIn(List<Long> values) {
/*  665 */       addCriterion("CUR_TOTAL_PRICE in", values, "curTotalPrice");
/*  666 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceNotIn(List<Long> values) {
/*  670 */       addCriterion("CUR_TOTAL_PRICE not in", values, "curTotalPrice");
/*  671 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceBetween(Long value1, Long value2) {
/*  675 */       addCriterion("CUR_TOTAL_PRICE between", value1, value2, "curTotalPrice");
/*  676 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andCurTotalPriceNotBetween(Long value1, Long value2) {
/*  680 */       addCriterion("CUR_TOTAL_PRICE not between", value1, value2, "curTotalPrice");
/*  681 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidIsNull() {
/*  685 */       addCriterion("IS_VALID is null");
/*  686 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidIsNotNull() {
/*  690 */       addCriterion("IS_VALID is not null");
/*  691 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidEqualTo(Short value) {
/*  695 */       addCriterion("IS_VALID =", value, "isValid");
/*  696 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidNotEqualTo(Short value) {
/*  700 */       addCriterion("IS_VALID <>", value, "isValid");
/*  701 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidGreaterThan(Short value) {
/*  705 */       addCriterion("IS_VALID >", value, "isValid");
/*  706 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidGreaterThanOrEqualTo(Short value) {
/*  710 */       addCriterion("IS_VALID >=", value, "isValid");
/*  711 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidLessThan(Short value) {
/*  715 */       addCriterion("IS_VALID <", value, "isValid");
/*  716 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidLessThanOrEqualTo(Short value) {
/*  720 */       addCriterion("IS_VALID <=", value, "isValid");
/*  721 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidIn(List<Short> values) {
/*  725 */       addCriterion("IS_VALID in", values, "isValid");
/*  726 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidNotIn(List<Short> values) {
/*  730 */       addCriterion("IS_VALID not in", values, "isValid");
/*  731 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidBetween(Short value1, Short value2) {
/*  735 */       addCriterion("IS_VALID between", value1, value2, "isValid");
/*  736 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andIsValidNotBetween(Short value1, Short value2) {
/*  740 */       addCriterion("IS_VALID not between", value1, value2, "isValid");
/*  741 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckIsNull() {
/*  745 */       addCriterion("MERCH_ACK is null");
/*  746 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckIsNotNull() {
/*  750 */       addCriterion("MERCH_ACK is not null");
/*  751 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckEqualTo(Short value) {
/*  755 */       addCriterion("MERCH_ACK =", value, "merchAck");
/*  756 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckNotEqualTo(Short value) {
/*  760 */       addCriterion("MERCH_ACK <>", value, "merchAck");
/*  761 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckGreaterThan(Short value) {
/*  765 */       addCriterion("MERCH_ACK >", value, "merchAck");
/*  766 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckGreaterThanOrEqualTo(Short value) {
/*  770 */       addCriterion("MERCH_ACK >=", value, "merchAck");
/*  771 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckLessThan(Short value) {
/*  775 */       addCriterion("MERCH_ACK <", value, "merchAck");
/*  776 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckLessThanOrEqualTo(Short value) {
/*  780 */       addCriterion("MERCH_ACK <=", value, "merchAck");
/*  781 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckIn(List<Short> values) {
/*  785 */       addCriterion("MERCH_ACK in", values, "merchAck");
/*  786 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckNotIn(List<Short> values) {
/*  790 */       addCriterion("MERCH_ACK not in", values, "merchAck");
/*  791 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckBetween(Short value1, Short value2) {
/*  795 */       addCriterion("MERCH_ACK between", value1, value2, "merchAck");
/*  796 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckNotBetween(Short value1, Short value2) {
/*  800 */       addCriterion("MERCH_ACK not between", value1, value2, "merchAck");
/*  801 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonIsNull() {
/*  805 */       addCriterion("MERCH_ACK_PERSON is null");
/*  806 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonIsNotNull() {
/*  810 */       addCriterion("MERCH_ACK_PERSON is not null");
/*  811 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonEqualTo(String value) {
/*  815 */       addCriterion("MERCH_ACK_PERSON =", value, "merchAckPerson");
/*  816 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonNotEqualTo(String value) {
/*  820 */       addCriterion("MERCH_ACK_PERSON <>", value, "merchAckPerson");
/*  821 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonGreaterThan(String value) {
/*  825 */       addCriterion("MERCH_ACK_PERSON >", value, "merchAckPerson");
/*  826 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonGreaterThanOrEqualTo(String value) {
/*  830 */       addCriterion("MERCH_ACK_PERSON >=", value, "merchAckPerson");
/*  831 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonLessThan(String value) {
/*  835 */       addCriterion("MERCH_ACK_PERSON <", value, "merchAckPerson");
/*  836 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonLessThanOrEqualTo(String value) {
/*  840 */       addCriterion("MERCH_ACK_PERSON <=", value, "merchAckPerson");
/*  841 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonLike(String value) {
/*  845 */       addCriterion("MERCH_ACK_PERSON like", value, "merchAckPerson");
/*  846 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonNotLike(String value) {
/*  850 */       addCriterion("MERCH_ACK_PERSON not like", value, "merchAckPerson");
/*  851 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonIn(List<String> values) {
/*  855 */       addCriterion("MERCH_ACK_PERSON in", values, "merchAckPerson");
/*  856 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonNotIn(List<String> values) {
/*  860 */       addCriterion("MERCH_ACK_PERSON not in", values, "merchAckPerson");
/*  861 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonBetween(String value1, String value2) {
/*  865 */       addCriterion("MERCH_ACK_PERSON between", value1, value2, "merchAckPerson");
/*  866 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckPersonNotBetween(String value1, String value2) {
/*  870 */       addCriterion("MERCH_ACK_PERSON not between", value1, value2, "merchAckPerson");
/*  871 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateIsNull() {
/*  875 */       addCriterion("MERCH_ACK_DATE is null");
/*  876 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateIsNotNull() {
/*  880 */       addCriterion("MERCH_ACK_DATE is not null");
/*  881 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateEqualTo(Date value) {
/*  885 */       addCriterion("MERCH_ACK_DATE =", value, "merchAckDate");
/*  886 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateNotEqualTo(Date value) {
/*  890 */       addCriterion("MERCH_ACK_DATE <>", value, "merchAckDate");
/*  891 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateGreaterThan(Date value) {
/*  895 */       addCriterion("MERCH_ACK_DATE >", value, "merchAckDate");
/*  896 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateGreaterThanOrEqualTo(Date value) {
/*  900 */       addCriterion("MERCH_ACK_DATE >=", value, "merchAckDate");
/*  901 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateLessThan(Date value) {
/*  905 */       addCriterion("MERCH_ACK_DATE <", value, "merchAckDate");
/*  906 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateLessThanOrEqualTo(Date value) {
/*  910 */       addCriterion("MERCH_ACK_DATE <=", value, "merchAckDate");
/*  911 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateIn(List<Date> values) {
/*  915 */       addCriterion("MERCH_ACK_DATE in", values, "merchAckDate");
/*  916 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateNotIn(List<Date> values) {
/*  920 */       addCriterion("MERCH_ACK_DATE not in", values, "merchAckDate");
/*  921 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateBetween(Date value1, Date value2) {
/*  925 */       addCriterion("MERCH_ACK_DATE between", value1, value2, "merchAckDate");
/*  926 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andMerchAckDateNotBetween(Date value1, Date value2) {
/*  930 */       addCriterion("MERCH_ACK_DATE not between", value1, value2, "merchAckDate");
/*  931 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckIsNull() {
/*  935 */       addCriterion("BANKS_ACK is null");
/*  936 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckIsNotNull() {
/*  940 */       addCriterion("BANKS_ACK is not null");
/*  941 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckEqualTo(Short value) {
/*  945 */       addCriterion("BANKS_ACK =", value, "banksAck");
/*  946 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckNotEqualTo(Short value) {
/*  950 */       addCriterion("BANKS_ACK <>", value, "banksAck");
/*  951 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckGreaterThan(Short value) {
/*  955 */       addCriterion("BANKS_ACK >", value, "banksAck");
/*  956 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckGreaterThanOrEqualTo(Short value) {
/*  960 */       addCriterion("BANKS_ACK >=", value, "banksAck");
/*  961 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckLessThan(Short value) {
/*  965 */       addCriterion("BANKS_ACK <", value, "banksAck");
/*  966 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckLessThanOrEqualTo(Short value) {
/*  970 */       addCriterion("BANKS_ACK <=", value, "banksAck");
/*  971 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckIn(List<Short> values) {
/*  975 */       addCriterion("BANKS_ACK in", values, "banksAck");
/*  976 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckNotIn(List<Short> values) {
/*  980 */       addCriterion("BANKS_ACK not in", values, "banksAck");
/*  981 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckBetween(Short value1, Short value2) {
/*  985 */       addCriterion("BANKS_ACK between", value1, value2, "banksAck");
/*  986 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckNotBetween(Short value1, Short value2) {
/*  990 */       addCriterion("BANKS_ACK not between", value1, value2, "banksAck");
/*  991 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonIsNull() {
/*  995 */       addCriterion("BANKS_ACK_PERSON is null");
/*  996 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonIsNotNull() {
/* 1000 */       addCriterion("BANKS_ACK_PERSON is not null");
/* 1001 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonEqualTo(String value) {
/* 1005 */       addCriterion("BANKS_ACK_PERSON =", value, "banksAckPerson");
/* 1006 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonNotEqualTo(String value) {
/* 1010 */       addCriterion("BANKS_ACK_PERSON <>", value, "banksAckPerson");
/* 1011 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonGreaterThan(String value) {
/* 1015 */       addCriterion("BANKS_ACK_PERSON >", value, "banksAckPerson");
/* 1016 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonGreaterThanOrEqualTo(String value) {
/* 1020 */       addCriterion("BANKS_ACK_PERSON >=", value, "banksAckPerson");
/* 1021 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonLessThan(String value) {
/* 1025 */       addCriterion("BANKS_ACK_PERSON <", value, "banksAckPerson");
/* 1026 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonLessThanOrEqualTo(String value) {
/* 1030 */       addCriterion("BANKS_ACK_PERSON <=", value, "banksAckPerson");
/* 1031 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonLike(String value) {
/* 1035 */       addCriterion("BANKS_ACK_PERSON like", value, "banksAckPerson");
/* 1036 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonNotLike(String value) {
/* 1040 */       addCriterion("BANKS_ACK_PERSON not like", value, "banksAckPerson");
/* 1041 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonIn(List<String> values) {
/* 1045 */       addCriterion("BANKS_ACK_PERSON in", values, "banksAckPerson");
/* 1046 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonNotIn(List<String> values) {
/* 1050 */       addCriterion("BANKS_ACK_PERSON not in", values, "banksAckPerson");
/* 1051 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonBetween(String value1, String value2) {
/* 1055 */       addCriterion("BANKS_ACK_PERSON between", value1, value2, "banksAckPerson");
/* 1056 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckPersonNotBetween(String value1, String value2) {
/* 1060 */       addCriterion("BANKS_ACK_PERSON not between", value1, value2, "banksAckPerson");
/* 1061 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateIsNull() {
/* 1065 */       addCriterion("BANKS_ACK_DATE is null");
/* 1066 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateIsNotNull() {
/* 1070 */       addCriterion("BANKS_ACK_DATE is not null");
/* 1071 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateEqualTo(Date value) {
/* 1075 */       addCriterion("BANKS_ACK_DATE =", value, "banksAckDate");
/* 1076 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateNotEqualTo(Date value) {
/* 1080 */       addCriterion("BANKS_ACK_DATE <>", value, "banksAckDate");
/* 1081 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateGreaterThan(Date value) {
/* 1085 */       addCriterion("BANKS_ACK_DATE >", value, "banksAckDate");
/* 1086 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateGreaterThanOrEqualTo(Date value) {
/* 1090 */       addCriterion("BANKS_ACK_DATE >=", value, "banksAckDate");
/* 1091 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateLessThan(Date value) {
/* 1095 */       addCriterion("BANKS_ACK_DATE <", value, "banksAckDate");
/* 1096 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateLessThanOrEqualTo(Date value) {
/* 1100 */       addCriterion("BANKS_ACK_DATE <=", value, "banksAckDate");
/* 1101 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateIn(List<Date> values) {
/* 1105 */       addCriterion("BANKS_ACK_DATE in", values, "banksAckDate");
/* 1106 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateNotIn(List<Date> values) {
/* 1110 */       addCriterion("BANKS_ACK_DATE not in", values, "banksAckDate");
/* 1111 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateBetween(Date value1, Date value2) {
/* 1115 */       addCriterion("BANKS_ACK_DATE between", value1, value2, "banksAckDate");
/* 1116 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andBanksAckDateNotBetween(Date value1, Date value2) {
/* 1120 */       addCriterion("BANKS_ACK_DATE not between", value1, value2, "banksAckDate");
/* 1121 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckIsNull() {
/* 1125 */       addCriterion("STORE_ACK is null");
/* 1126 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckIsNotNull() {
/* 1130 */       addCriterion("STORE_ACK is not null");
/* 1131 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckEqualTo(Short value) {
/* 1135 */       addCriterion("STORE_ACK =", value, "storeAck");
/* 1136 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckNotEqualTo(Short value) {
/* 1140 */       addCriterion("STORE_ACK <>", value, "storeAck");
/* 1141 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckGreaterThan(Short value) {
/* 1145 */       addCriterion("STORE_ACK >", value, "storeAck");
/* 1146 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckGreaterThanOrEqualTo(Short value) {
/* 1150 */       addCriterion("STORE_ACK >=", value, "storeAck");
/* 1151 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckLessThan(Short value) {
/* 1155 */       addCriterion("STORE_ACK <", value, "storeAck");
/* 1156 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckLessThanOrEqualTo(Short value) {
/* 1160 */       addCriterion("STORE_ACK <=", value, "storeAck");
/* 1161 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckIn(List<Short> values) {
/* 1165 */       addCriterion("STORE_ACK in", values, "storeAck");
/* 1166 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckNotIn(List<Short> values) {
/* 1170 */       addCriterion("STORE_ACK not in", values, "storeAck");
/* 1171 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckBetween(Short value1, Short value2) {
/* 1175 */       addCriterion("STORE_ACK between", value1, value2, "storeAck");
/* 1176 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckNotBetween(Short value1, Short value2) {
/* 1180 */       addCriterion("STORE_ACK not between", value1, value2, "storeAck");
/* 1181 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonIsNull() {
/* 1185 */       addCriterion("STORE_ACK_PERSON is null");
/* 1186 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonIsNotNull() {
/* 1190 */       addCriterion("STORE_ACK_PERSON is not null");
/* 1191 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonEqualTo(String value) {
/* 1195 */       addCriterion("STORE_ACK_PERSON =", value, "storeAckPerson");
/* 1196 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonNotEqualTo(String value) {
/* 1200 */       addCriterion("STORE_ACK_PERSON <>", value, "storeAckPerson");
/* 1201 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonGreaterThan(String value) {
/* 1205 */       addCriterion("STORE_ACK_PERSON >", value, "storeAckPerson");
/* 1206 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonGreaterThanOrEqualTo(String value) {
/* 1210 */       addCriterion("STORE_ACK_PERSON >=", value, "storeAckPerson");
/* 1211 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonLessThan(String value) {
/* 1215 */       addCriterion("STORE_ACK_PERSON <", value, "storeAckPerson");
/* 1216 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonLessThanOrEqualTo(String value) {
/* 1220 */       addCriterion("STORE_ACK_PERSON <=", value, "storeAckPerson");
/* 1221 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonLike(String value) {
/* 1225 */       addCriterion("STORE_ACK_PERSON like", value, "storeAckPerson");
/* 1226 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonNotLike(String value) {
/* 1230 */       addCriterion("STORE_ACK_PERSON not like", value, "storeAckPerson");
/* 1231 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonIn(List<String> values) {
/* 1235 */       addCriterion("STORE_ACK_PERSON in", values, "storeAckPerson");
/* 1236 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonNotIn(List<String> values) {
/* 1240 */       addCriterion("STORE_ACK_PERSON not in", values, "storeAckPerson");
/* 1241 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonBetween(String value1, String value2) {
/* 1245 */       addCriterion("STORE_ACK_PERSON between", value1, value2, "storeAckPerson");
/* 1246 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckPersonNotBetween(String value1, String value2) {
/* 1250 */       addCriterion("STORE_ACK_PERSON not between", value1, value2, "storeAckPerson");
/* 1251 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateIsNull() {
/* 1255 */       addCriterion("STORE_ACK_DATE is null");
/* 1256 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateIsNotNull() {
/* 1260 */       addCriterion("STORE_ACK_DATE is not null");
/* 1261 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateEqualTo(Date value) {
/* 1265 */       addCriterion("STORE_ACK_DATE =", value, "storeAckDate");
/* 1266 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateNotEqualTo(Date value) {
/* 1270 */       addCriterion("STORE_ACK_DATE <>", value, "storeAckDate");
/* 1271 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateGreaterThan(Date value) {
/* 1275 */       addCriterion("STORE_ACK_DATE >", value, "storeAckDate");
/* 1276 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateGreaterThanOrEqualTo(Date value) {
/* 1280 */       addCriterion("STORE_ACK_DATE >=", value, "storeAckDate");
/* 1281 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateLessThan(Date value) {
/* 1285 */       addCriterion("STORE_ACK_DATE <", value, "storeAckDate");
/* 1286 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateLessThanOrEqualTo(Date value) {
/* 1290 */       addCriterion("STORE_ACK_DATE <=", value, "storeAckDate");
/* 1291 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateIn(List<Date> values) {
/* 1295 */       addCriterion("STORE_ACK_DATE in", values, "storeAckDate");
/* 1296 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateNotIn(List<Date> values) {
/* 1300 */       addCriterion("STORE_ACK_DATE not in", values, "storeAckDate");
/* 1301 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateBetween(Date value1, Date value2) {
/* 1305 */       addCriterion("STORE_ACK_DATE between", value1, value2, "storeAckDate");
/* 1306 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andStoreAckDateNotBetween(Date value1, Date value2) {
/* 1310 */       addCriterion("STORE_ACK_DATE not between", value1, value2, "storeAckDate");
/* 1311 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckIsNull() {
/* 1315 */       addCriterion("REGU_ACK is null");
/* 1316 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckIsNotNull() {
/* 1320 */       addCriterion("REGU_ACK is not null");
/* 1321 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckEqualTo(Short value) {
/* 1325 */       addCriterion("REGU_ACK =", value, "reguAck");
/* 1326 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckNotEqualTo(Short value) {
/* 1330 */       addCriterion("REGU_ACK <>", value, "reguAck");
/* 1331 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckGreaterThan(Short value) {
/* 1335 */       addCriterion("REGU_ACK >", value, "reguAck");
/* 1336 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckGreaterThanOrEqualTo(Short value) {
/* 1340 */       addCriterion("REGU_ACK >=", value, "reguAck");
/* 1341 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckLessThan(Short value) {
/* 1345 */       addCriterion("REGU_ACK <", value, "reguAck");
/* 1346 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckLessThanOrEqualTo(Short value) {
/* 1350 */       addCriterion("REGU_ACK <=", value, "reguAck");
/* 1351 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckIn(List<Short> values) {
/* 1355 */       addCriterion("REGU_ACK in", values, "reguAck");
/* 1356 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckNotIn(List<Short> values) {
/* 1360 */       addCriterion("REGU_ACK not in", values, "reguAck");
/* 1361 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckBetween(Short value1, Short value2) {
/* 1365 */       addCriterion("REGU_ACK between", value1, value2, "reguAck");
/* 1366 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckNotBetween(Short value1, Short value2) {
/* 1370 */       addCriterion("REGU_ACK not between", value1, value2, "reguAck");
/* 1371 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonIsNull() {
/* 1375 */       addCriterion("REGU_ACK_PERSON is null");
/* 1376 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonIsNotNull() {
/* 1380 */       addCriterion("REGU_ACK_PERSON is not null");
/* 1381 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonEqualTo(String value) {
/* 1385 */       addCriterion("REGU_ACK_PERSON =", value, "reguAckPerson");
/* 1386 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonNotEqualTo(String value) {
/* 1390 */       addCriterion("REGU_ACK_PERSON <>", value, "reguAckPerson");
/* 1391 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonGreaterThan(String value) {
/* 1395 */       addCriterion("REGU_ACK_PERSON >", value, "reguAckPerson");
/* 1396 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonGreaterThanOrEqualTo(String value) {
/* 1400 */       addCriterion("REGU_ACK_PERSON >=", value, "reguAckPerson");
/* 1401 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonLessThan(String value) {
/* 1405 */       addCriterion("REGU_ACK_PERSON <", value, "reguAckPerson");
/* 1406 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonLessThanOrEqualTo(String value) {
/* 1410 */       addCriterion("REGU_ACK_PERSON <=", value, "reguAckPerson");
/* 1411 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonLike(String value) {
/* 1415 */       addCriterion("REGU_ACK_PERSON like", value, "reguAckPerson");
/* 1416 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonNotLike(String value) {
/* 1420 */       addCriterion("REGU_ACK_PERSON not like", value, "reguAckPerson");
/* 1421 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonIn(List<String> values) {
/* 1425 */       addCriterion("REGU_ACK_PERSON in", values, "reguAckPerson");
/* 1426 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonNotIn(List<String> values) {
/* 1430 */       addCriterion("REGU_ACK_PERSON not in", values, "reguAckPerson");
/* 1431 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonBetween(String value1, String value2) {
/* 1435 */       addCriterion("REGU_ACK_PERSON between", value1, value2, "reguAckPerson");
/* 1436 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckPersonNotBetween(String value1, String value2) {
/* 1440 */       addCriterion("REGU_ACK_PERSON not between", value1, value2, "reguAckPerson");
/* 1441 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateIsNull() {
/* 1445 */       addCriterion("REGU_ACK_DATE is null");
/* 1446 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateIsNotNull() {
/* 1450 */       addCriterion("REGU_ACK_DATE is not null");
/* 1451 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateEqualTo(Date value) {
/* 1455 */       addCriterion("REGU_ACK_DATE =", value, "reguAckDate");
/* 1456 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateNotEqualTo(Date value) {
/* 1460 */       addCriterion("REGU_ACK_DATE <>", value, "reguAckDate");
/* 1461 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateGreaterThan(Date value) {
/* 1465 */       addCriterion("REGU_ACK_DATE >", value, "reguAckDate");
/* 1466 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateGreaterThanOrEqualTo(Date value) {
/* 1470 */       addCriterion("REGU_ACK_DATE >=", value, "reguAckDate");
/* 1471 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateLessThan(Date value) {
/* 1475 */       addCriterion("REGU_ACK_DATE <", value, "reguAckDate");
/* 1476 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateLessThanOrEqualTo(Date value) {
/* 1480 */       addCriterion("REGU_ACK_DATE <=", value, "reguAckDate");
/* 1481 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateIn(List<Date> values) {
/* 1485 */       addCriterion("REGU_ACK_DATE in", values, "reguAckDate");
/* 1486 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateNotIn(List<Date> values) {
/* 1490 */       addCriterion("REGU_ACK_DATE not in", values, "reguAckDate");
/* 1491 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateBetween(Date value1, Date value2) {
/* 1495 */       addCriterion("REGU_ACK_DATE between", value1, value2, "reguAckDate");
/* 1496 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andReguAckDateNotBetween(Date value1, Date value2) {
/* 1500 */       addCriterion("REGU_ACK_DATE not between", value1, value2, "reguAckDate");
/* 1501 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckIsNull() {
/* 1505 */       addCriterion("PLAT_ACK is null");
/* 1506 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckIsNotNull() {
/* 1510 */       addCriterion("PLAT_ACK is not null");
/* 1511 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckEqualTo(Short value) {
/* 1515 */       addCriterion("PLAT_ACK =", value, "platAck");
/* 1516 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckNotEqualTo(Short value) {
/* 1520 */       addCriterion("PLAT_ACK <>", value, "platAck");
/* 1521 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckGreaterThan(Short value) {
/* 1525 */       addCriterion("PLAT_ACK >", value, "platAck");
/* 1526 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckGreaterThanOrEqualTo(Short value) {
/* 1530 */       addCriterion("PLAT_ACK >=", value, "platAck");
/* 1531 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckLessThan(Short value) {
/* 1535 */       addCriterion("PLAT_ACK <", value, "platAck");
/* 1536 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckLessThanOrEqualTo(Short value) {
/* 1540 */       addCriterion("PLAT_ACK <=", value, "platAck");
/* 1541 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckIn(List<Short> values) {
/* 1545 */       addCriterion("PLAT_ACK in", values, "platAck");
/* 1546 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckNotIn(List<Short> values) {
/* 1550 */       addCriterion("PLAT_ACK not in", values, "platAck");
/* 1551 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckBetween(Short value1, Short value2) {
/* 1555 */       addCriterion("PLAT_ACK between", value1, value2, "platAck");
/* 1556 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckNotBetween(Short value1, Short value2) {
/* 1560 */       addCriterion("PLAT_ACK not between", value1, value2, "platAck");
/* 1561 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonIsNull() {
/* 1565 */       addCriterion("PLAT_ACK_PERSON is null");
/* 1566 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonIsNotNull() {
/* 1570 */       addCriterion("PLAT_ACK_PERSON is not null");
/* 1571 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonEqualTo(String value) {
/* 1575 */       addCriterion("PLAT_ACK_PERSON =", value, "platAckPerson");
/* 1576 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonNotEqualTo(String value) {
/* 1580 */       addCriterion("PLAT_ACK_PERSON <>", value, "platAckPerson");
/* 1581 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonGreaterThan(String value) {
/* 1585 */       addCriterion("PLAT_ACK_PERSON >", value, "platAckPerson");
/* 1586 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonGreaterThanOrEqualTo(String value) {
/* 1590 */       addCriterion("PLAT_ACK_PERSON >=", value, "platAckPerson");
/* 1591 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonLessThan(String value) {
/* 1595 */       addCriterion("PLAT_ACK_PERSON <", value, "platAckPerson");
/* 1596 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonLessThanOrEqualTo(String value) {
/* 1600 */       addCriterion("PLAT_ACK_PERSON <=", value, "platAckPerson");
/* 1601 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonLike(String value) {
/* 1605 */       addCriterion("PLAT_ACK_PERSON like", value, "platAckPerson");
/* 1606 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonNotLike(String value) {
/* 1610 */       addCriterion("PLAT_ACK_PERSON not like", value, "platAckPerson");
/* 1611 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonIn(List<String> values) {
/* 1615 */       addCriterion("PLAT_ACK_PERSON in", values, "platAckPerson");
/* 1616 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonNotIn(List<String> values) {
/* 1620 */       addCriterion("PLAT_ACK_PERSON not in", values, "platAckPerson");
/* 1621 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonBetween(String value1, String value2) {
/* 1625 */       addCriterion("PLAT_ACK_PERSON between", value1, value2, "platAckPerson");
/* 1626 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckPersonNotBetween(String value1, String value2) {
/* 1630 */       addCriterion("PLAT_ACK_PERSON not between", value1, value2, "platAckPerson");
/* 1631 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateIsNull() {
/* 1635 */       addCriterion("PLAT_ACK_DATE is null");
/* 1636 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateIsNotNull() {
/* 1640 */       addCriterion("PLAT_ACK_DATE is not null");
/* 1641 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateEqualTo(Date value) {
/* 1645 */       addCriterion("PLAT_ACK_DATE =", value, "platAckDate");
/* 1646 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateNotEqualTo(Date value) {
/* 1650 */       addCriterion("PLAT_ACK_DATE <>", value, "platAckDate");
/* 1651 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateGreaterThan(Date value) {
/* 1655 */       addCriterion("PLAT_ACK_DATE >", value, "platAckDate");
/* 1656 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateGreaterThanOrEqualTo(Date value) {
/* 1660 */       addCriterion("PLAT_ACK_DATE >=", value, "platAckDate");
/* 1661 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateLessThan(Date value) {
/* 1665 */       addCriterion("PLAT_ACK_DATE <", value, "platAckDate");
/* 1666 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateLessThanOrEqualTo(Date value) {
/* 1670 */       addCriterion("PLAT_ACK_DATE <=", value, "platAckDate");
/* 1671 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateIn(List<Date> values) {
/* 1675 */       addCriterion("PLAT_ACK_DATE in", values, "platAckDate");
/* 1676 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateNotIn(List<Date> values) {
/* 1680 */       addCriterion("PLAT_ACK_DATE not in", values, "platAckDate");
/* 1681 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateBetween(Date value1, Date value2) {
/* 1685 */       addCriterion("PLAT_ACK_DATE between", value1, value2, "platAckDate");
/* 1686 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andPlatAckDateNotBetween(Date value1, Date value2) {
/* 1690 */       addCriterion("PLAT_ACK_DATE not between", value1, value2, "platAckDate");
/* 1691 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyIsNull() {
/* 1695 */       addCriterion("GMT_MODIFY is null");
/* 1696 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyIsNotNull() {
/* 1700 */       addCriterion("GMT_MODIFY is not null");
/* 1701 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyEqualTo(Date value) {
/* 1705 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/* 1706 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/* 1710 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/* 1711 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/* 1715 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/* 1716 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/* 1720 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/* 1721 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyLessThan(Date value) {
/* 1725 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/* 1726 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/* 1730 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/* 1731 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyIn(List<Date> values) {
/* 1735 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/* 1736 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/* 1740 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/* 1741 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/* 1745 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/* 1746 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/* 1750 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/* 1751 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateIsNull() {
/* 1755 */       addCriterion("GMT_CREATE is null");
/* 1756 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateIsNotNull() {
/* 1760 */       addCriterion("GMT_CREATE is not null");
/* 1761 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateEqualTo(Date value) {
/* 1765 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/* 1766 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/* 1770 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/* 1771 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/* 1775 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/* 1776 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/* 1780 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/* 1781 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateLessThan(Date value) {
/* 1785 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/* 1786 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/* 1790 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/* 1791 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateIn(List<Date> values) {
/* 1795 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/* 1796 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/* 1800 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/* 1801 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/* 1805 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/* 1806 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */ 
/*      */     public FinancCollListCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/* 1810 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/* 1811 */       return (FinancCollListCriteria.Criteria)this;
/*      */     }
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancCollListCriteria
 * JD-Core Version:    0.6.0
 */