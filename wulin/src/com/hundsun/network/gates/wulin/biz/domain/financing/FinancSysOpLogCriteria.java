/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class FinancSysOpLogCriteria
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public FinancSysOpLogCriteria()
/*     */   {
/*  29 */     this.oredCriteria = new ArrayList();
/*     */   }
/*     */ 
/*     */   protected FinancSysOpLogCriteria(FinancSysOpLogCriteria example)
/*     */   {
/*  36 */     this.orderByClause = example.orderByClause;
/*  37 */     this.oredCriteria = example.oredCriteria;
/*  38 */     this.distinct = example.distinct;
/*     */   }
/*     */ 
/*     */   public void setOrderByClause(String orderByClause)
/*     */   {
/*  45 */     this.orderByClause = orderByClause;
/*     */   }
/*     */ 
/*     */   public String getOrderByClause()
/*     */   {
/*  52 */     return this.orderByClause;
/*     */   }
/*     */ 
/*     */   public void setDistinct(boolean distinct)
/*     */   {
/*  59 */     this.distinct = distinct;
/*     */   }
/*     */ 
/*     */   public boolean isDistinct()
/*     */   {
/*  66 */     return this.distinct;
/*     */   }
/*     */ 
/*     */   public List<Criteria> getOredCriteria()
/*     */   {
/*  73 */     return this.oredCriteria;
/*     */   }
/*     */ 
/*     */   public void or(Criteria criteria)
/*     */   {
/*  80 */     this.oredCriteria.add(criteria);
/*     */   }
/*     */ 
/*     */   public Criteria or()
/*     */   {
/*  87 */     Criteria criteria = createCriteriaInternal();
/*  88 */     this.oredCriteria.add(criteria);
/*  89 */     return criteria;
/*     */   }
/*     */ 
/*     */   public Criteria createCriteria()
/*     */   {
/*  96 */     Criteria criteria = createCriteriaInternal();
/*  97 */     if (this.oredCriteria.size() == 0) {
/*  98 */       this.oredCriteria.add(criteria);
/*     */     }
/* 100 */     return criteria;
/*     */   }
/*     */ 
/*     */   protected Criteria createCriteriaInternal()
/*     */   {
/* 107 */     Criteria criteria = new Criteria();
/* 108 */     return criteria;
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 115 */     this.oredCriteria.clear();
/* 116 */     this.orderByClause = null;
/* 117 */     this.distinct = false;
/*     */   }
/*     */ 
/*     */   public static class Criteria extends FinancSysOpLogCriteria.GeneratedCriteria {
/*     */   }
/*     */ 
/*     */   protected static abstract class GeneratedCriteria {
/*     */     protected List<String> criteriaWithoutValue;
/*     */     protected List<Map<String, Object>> criteriaWithSingleValue;
/*     */     protected List<Map<String, Object>> criteriaWithListValue;
/*     */     protected List<Map<String, Object>> criteriaWithBetweenValue;
/*     */ 
/*     */     protected GeneratedCriteria() {
/* 134 */       this.criteriaWithoutValue = new ArrayList();
/* 135 */       this.criteriaWithSingleValue = new ArrayList();
/* 136 */       this.criteriaWithListValue = new ArrayList();
/* 137 */       this.criteriaWithBetweenValue = new ArrayList();
/*     */     }
/*     */ 
/*     */     public boolean isValid() {
/* 141 */       return (this.criteriaWithoutValue.size() > 0) || (this.criteriaWithSingleValue.size() > 0) || (this.criteriaWithListValue.size() > 0) || (this.criteriaWithBetweenValue.size() > 0);
/*     */     }
/*     */ 
/*     */     public List<String> getCriteriaWithoutValue()
/*     */     {
/* 148 */       return this.criteriaWithoutValue;
/*     */     }
/*     */ 
/*     */     public List<Map<String, Object>> getCriteriaWithSingleValue() {
/* 152 */       return this.criteriaWithSingleValue;
/*     */     }
/*     */ 
/*     */     public List<Map<String, Object>> getCriteriaWithListValue() {
/* 156 */       return this.criteriaWithListValue;
/*     */     }
/*     */ 
/*     */     public List<Map<String, Object>> getCriteriaWithBetweenValue() {
/* 160 */       return this.criteriaWithBetweenValue;
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition) {
/* 164 */       if (condition == null) {
/* 165 */         throw new RuntimeException("Value for condition cannot be null");
/*     */       }
/* 167 */       this.criteriaWithoutValue.add(condition);
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value, String property) {
/* 171 */       if (value == null) {
/* 172 */         throw new RuntimeException("Value for " + property + " cannot be null");
/*     */       }
/* 174 */       Map map = new HashMap();
/* 175 */       map.put("condition", condition);
/* 176 */       map.put("value", value);
/* 177 */       this.criteriaWithSingleValue.add(map);
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, List<? extends Object> values, String property) {
/* 181 */       if ((values == null) || (values.size() == 0)) {
/* 182 */         throw new RuntimeException("Value list for " + property + " cannot be null or empty");
/*     */       }
/* 184 */       Map map = new HashMap();
/* 185 */       map.put("condition", condition);
/* 186 */       map.put("values", values);
/* 187 */       this.criteriaWithListValue.add(map);
/*     */     }
/*     */ 
/*     */     protected void addCriterion(String condition, Object value1, Object value2, String property) {
/* 191 */       if ((value1 == null) || (value2 == null)) {
/* 192 */         throw new RuntimeException("Between values for " + property + " cannot be null");
/*     */       }
/* 194 */       List list = new ArrayList();
/* 195 */       list.add(value1);
/* 196 */       list.add(value2);
/* 197 */       Map map = new HashMap();
/* 198 */       map.put("condition", condition);
/* 199 */       map.put("values", list);
/* 200 */       this.criteriaWithBetweenValue.add(map);
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdIsNull() {
/* 204 */       addCriterion("ID is null");
/* 205 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdIsNotNull() {
/* 209 */       addCriterion("ID is not null");
/* 210 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdEqualTo(Long value) {
/* 214 */       addCriterion("ID =", value, "id");
/* 215 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdNotEqualTo(Long value) {
/* 219 */       addCriterion("ID <>", value, "id");
/* 220 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdGreaterThan(Long value) {
/* 224 */       addCriterion("ID >", value, "id");
/* 225 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 229 */       addCriterion("ID >=", value, "id");
/* 230 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdLessThan(Long value) {
/* 234 */       addCriterion("ID <", value, "id");
/* 235 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/* 239 */       addCriterion("ID <=", value, "id");
/* 240 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdIn(List<Long> values) {
/* 244 */       addCriterion("ID in", values, "id");
/* 245 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdNotIn(List<Long> values) {
/* 249 */       addCriterion("ID not in", values, "id");
/* 250 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdBetween(Long value1, Long value2) {
/* 254 */       addCriterion("ID between", value1, value2, "id");
/* 255 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/* 259 */       addCriterion("ID not between", value1, value2, "id");
/* 260 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionIsNull() {
/* 264 */       addCriterion("ACTION is null");
/* 265 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionIsNotNull() {
/* 269 */       addCriterion("ACTION is not null");
/* 270 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionEqualTo(String value) {
/* 274 */       addCriterion("ACTION =", value, "action");
/* 275 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionNotEqualTo(String value) {
/* 279 */       addCriterion("ACTION <>", value, "action");
/* 280 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionGreaterThan(String value) {
/* 284 */       addCriterion("ACTION >", value, "action");
/* 285 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionGreaterThanOrEqualTo(String value) {
/* 289 */       addCriterion("ACTION >=", value, "action");
/* 290 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionLessThan(String value) {
/* 294 */       addCriterion("ACTION <", value, "action");
/* 295 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionLessThanOrEqualTo(String value) {
/* 299 */       addCriterion("ACTION <=", value, "action");
/* 300 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionLike(String value) {
/* 304 */       addCriterion("ACTION like", value, "action");
/* 305 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionNotLike(String value) {
/* 309 */       addCriterion("ACTION not like", value, "action");
/* 310 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionIn(List<String> values) {
/* 314 */       addCriterion("ACTION in", values, "action");
/* 315 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionNotIn(List<String> values) {
/* 319 */       addCriterion("ACTION not in", values, "action");
/* 320 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionBetween(String value1, String value2) {
/* 324 */       addCriterion("ACTION between", value1, value2, "action");
/* 325 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andActionNotBetween(String value1, String value2) {
/* 329 */       addCriterion("ACTION not between", value1, value2, "action");
/* 330 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdIsNull() {
/* 334 */       addCriterion("RELATED_ID is null");
/* 335 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdIsNotNull() {
/* 339 */       addCriterion("RELATED_ID is not null");
/* 340 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdEqualTo(Long value) {
/* 344 */       addCriterion("RELATED_ID =", value, "relatedId");
/* 345 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdNotEqualTo(Long value) {
/* 349 */       addCriterion("RELATED_ID <>", value, "relatedId");
/* 350 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdGreaterThan(Long value) {
/* 354 */       addCriterion("RELATED_ID >", value, "relatedId");
/* 355 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdGreaterThanOrEqualTo(Long value) {
/* 359 */       addCriterion("RELATED_ID >=", value, "relatedId");
/* 360 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdLessThan(Long value) {
/* 364 */       addCriterion("RELATED_ID <", value, "relatedId");
/* 365 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdLessThanOrEqualTo(Long value) {
/* 369 */       addCriterion("RELATED_ID <=", value, "relatedId");
/* 370 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdIn(List<Long> values) {
/* 374 */       addCriterion("RELATED_ID in", values, "relatedId");
/* 375 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdNotIn(List<Long> values) {
/* 379 */       addCriterion("RELATED_ID not in", values, "relatedId");
/* 380 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdBetween(Long value1, Long value2) {
/* 384 */       addCriterion("RELATED_ID between", value1, value2, "relatedId");
/* 385 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedIdNotBetween(Long value1, Long value2) {
/* 389 */       addCriterion("RELATED_ID not between", value1, value2, "relatedId");
/* 390 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableIsNull() {
/* 394 */       addCriterion("RELATED_TABLE is null");
/* 395 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableIsNotNull() {
/* 399 */       addCriterion("RELATED_TABLE is not null");
/* 400 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableEqualTo(String value) {
/* 404 */       addCriterion("RELATED_TABLE =", value, "relatedTable");
/* 405 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableNotEqualTo(String value) {
/* 409 */       addCriterion("RELATED_TABLE <>", value, "relatedTable");
/* 410 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableGreaterThan(String value) {
/* 414 */       addCriterion("RELATED_TABLE >", value, "relatedTable");
/* 415 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableGreaterThanOrEqualTo(String value) {
/* 419 */       addCriterion("RELATED_TABLE >=", value, "relatedTable");
/* 420 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableLessThan(String value) {
/* 424 */       addCriterion("RELATED_TABLE <", value, "relatedTable");
/* 425 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableLessThanOrEqualTo(String value) {
/* 429 */       addCriterion("RELATED_TABLE <=", value, "relatedTable");
/* 430 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableLike(String value) {
/* 434 */       addCriterion("RELATED_TABLE like", value, "relatedTable");
/* 435 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableNotLike(String value) {
/* 439 */       addCriterion("RELATED_TABLE not like", value, "relatedTable");
/* 440 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableIn(List<String> values) {
/* 444 */       addCriterion("RELATED_TABLE in", values, "relatedTable");
/* 445 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableNotIn(List<String> values) {
/* 449 */       addCriterion("RELATED_TABLE not in", values, "relatedTable");
/* 450 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableBetween(String value1, String value2) {
/* 454 */       addCriterion("RELATED_TABLE between", value1, value2, "relatedTable");
/* 455 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andRelatedTableNotBetween(String value1, String value2) {
/* 459 */       addCriterion("RELATED_TABLE not between", value1, value2, "relatedTable");
/* 460 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdIsNull() {
/* 464 */       addCriterion("OPERATOR_ID is null");
/* 465 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdIsNotNull() {
/* 469 */       addCriterion("OPERATOR_ID is not null");
/* 470 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdEqualTo(Long value) {
/* 474 */       addCriterion("OPERATOR_ID =", value, "operatorId");
/* 475 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdNotEqualTo(Long value) {
/* 479 */       addCriterion("OPERATOR_ID <>", value, "operatorId");
/* 480 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdGreaterThan(Long value) {
/* 484 */       addCriterion("OPERATOR_ID >", value, "operatorId");
/* 485 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
/* 489 */       addCriterion("OPERATOR_ID >=", value, "operatorId");
/* 490 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdLessThan(Long value) {
/* 494 */       addCriterion("OPERATOR_ID <", value, "operatorId");
/* 495 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdLessThanOrEqualTo(Long value) {
/* 499 */       addCriterion("OPERATOR_ID <=", value, "operatorId");
/* 500 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdIn(List<Long> values) {
/* 504 */       addCriterion("OPERATOR_ID in", values, "operatorId");
/* 505 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdNotIn(List<Long> values) {
/* 509 */       addCriterion("OPERATOR_ID not in", values, "operatorId");
/* 510 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdBetween(Long value1, Long value2) {
/* 514 */       addCriterion("OPERATOR_ID between", value1, value2, "operatorId");
/* 515 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorIdNotBetween(Long value1, Long value2) {
/* 519 */       addCriterion("OPERATOR_ID not between", value1, value2, "operatorId");
/* 520 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameIsNull() {
/* 524 */       addCriterion("OPERATOR_NAME is null");
/* 525 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameIsNotNull() {
/* 529 */       addCriterion("OPERATOR_NAME is not null");
/* 530 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameEqualTo(String value) {
/* 534 */       addCriterion("OPERATOR_NAME =", value, "operatorName");
/* 535 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameNotEqualTo(String value) {
/* 539 */       addCriterion("OPERATOR_NAME <>", value, "operatorName");
/* 540 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameGreaterThan(String value) {
/* 544 */       addCriterion("OPERATOR_NAME >", value, "operatorName");
/* 545 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
/* 549 */       addCriterion("OPERATOR_NAME >=", value, "operatorName");
/* 550 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameLessThan(String value) {
/* 554 */       addCriterion("OPERATOR_NAME <", value, "operatorName");
/* 555 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameLessThanOrEqualTo(String value) {
/* 559 */       addCriterion("OPERATOR_NAME <=", value, "operatorName");
/* 560 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameLike(String value) {
/* 564 */       addCriterion("OPERATOR_NAME like", value, "operatorName");
/* 565 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameNotLike(String value) {
/* 569 */       addCriterion("OPERATOR_NAME not like", value, "operatorName");
/* 570 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameIn(List<String> values) {
/* 574 */       addCriterion("OPERATOR_NAME in", values, "operatorName");
/* 575 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameNotIn(List<String> values) {
/* 579 */       addCriterion("OPERATOR_NAME not in", values, "operatorName");
/* 580 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameBetween(String value1, String value2) {
/* 584 */       addCriterion("OPERATOR_NAME between", value1, value2, "operatorName");
/* 585 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorNameNotBetween(String value1, String value2) {
/* 589 */       addCriterion("OPERATOR_NAME not between", value1, value2, "operatorName");
/* 590 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateIsNull() {
/* 594 */       addCriterion("OPERATOR_DATE is null");
/* 595 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateIsNotNull() {
/* 599 */       addCriterion("OPERATOR_DATE is not null");
/* 600 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateEqualTo(Date value) {
/* 604 */       addCriterion("OPERATOR_DATE =", value, "operatorDate");
/* 605 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateNotEqualTo(Date value) {
/* 609 */       addCriterion("OPERATOR_DATE <>", value, "operatorDate");
/* 610 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateGreaterThan(Date value) {
/* 614 */       addCriterion("OPERATOR_DATE >", value, "operatorDate");
/* 615 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateGreaterThanOrEqualTo(Date value) {
/* 619 */       addCriterion("OPERATOR_DATE >=", value, "operatorDate");
/* 620 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateLessThan(Date value) {
/* 624 */       addCriterion("OPERATOR_DATE <", value, "operatorDate");
/* 625 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateLessThanOrEqualTo(Date value) {
/* 629 */       addCriterion("OPERATOR_DATE <=", value, "operatorDate");
/* 630 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateIn(List<Date> values) {
/* 634 */       addCriterion("OPERATOR_DATE in", values, "operatorDate");
/* 635 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateNotIn(List<Date> values) {
/* 639 */       addCriterion("OPERATOR_DATE not in", values, "operatorDate");
/* 640 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateBetween(Date value1, Date value2) {
/* 644 */       addCriterion("OPERATOR_DATE between", value1, value2, "operatorDate");
/* 645 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andOperatorDateNotBetween(Date value1, Date value2) {
/* 649 */       addCriterion("OPERATOR_DATE not between", value1, value2, "operatorDate");
/* 650 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessIsNull() {
/* 654 */       addCriterion("BUSINESS is null");
/* 655 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessIsNotNull() {
/* 659 */       addCriterion("BUSINESS is not null");
/* 660 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessEqualTo(String value) {
/* 664 */       addCriterion("BUSINESS =", value, "business");
/* 665 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessNotEqualTo(String value) {
/* 669 */       addCriterion("BUSINESS <>", value, "business");
/* 670 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessGreaterThan(String value) {
/* 674 */       addCriterion("BUSINESS >", value, "business");
/* 675 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessGreaterThanOrEqualTo(String value) {
/* 679 */       addCriterion("BUSINESS >=", value, "business");
/* 680 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessLessThan(String value) {
/* 684 */       addCriterion("BUSINESS <", value, "business");
/* 685 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessLessThanOrEqualTo(String value) {
/* 689 */       addCriterion("BUSINESS <=", value, "business");
/* 690 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessLike(String value) {
/* 694 */       addCriterion("BUSINESS like", value, "business");
/* 695 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessNotLike(String value) {
/* 699 */       addCriterion("BUSINESS not like", value, "business");
/* 700 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessIn(List<String> values) {
/* 704 */       addCriterion("BUSINESS in", values, "business");
/* 705 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessNotIn(List<String> values) {
/* 709 */       addCriterion("BUSINESS not in", values, "business");
/* 710 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessBetween(String value1, String value2) {
/* 714 */       addCriterion("BUSINESS between", value1, value2, "business");
/* 715 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andBusinessNotBetween(String value1, String value2) {
/* 719 */       addCriterion("BUSINESS not between", value1, value2, "business");
/* 720 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentIsNull() {
/* 724 */       addCriterion("CONTENT is null");
/* 725 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentIsNotNull() {
/* 729 */       addCriterion("CONTENT is not null");
/* 730 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentEqualTo(String value) {
/* 734 */       addCriterion("CONTENT =", value, "content");
/* 735 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentNotEqualTo(String value) {
/* 739 */       addCriterion("CONTENT <>", value, "content");
/* 740 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentGreaterThan(String value) {
/* 744 */       addCriterion("CONTENT >", value, "content");
/* 745 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentGreaterThanOrEqualTo(String value) {
/* 749 */       addCriterion("CONTENT >=", value, "content");
/* 750 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentLessThan(String value) {
/* 754 */       addCriterion("CONTENT <", value, "content");
/* 755 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentLessThanOrEqualTo(String value) {
/* 759 */       addCriterion("CONTENT <=", value, "content");
/* 760 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentLike(String value) {
/* 764 */       addCriterion("CONTENT like", value, "content");
/* 765 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentNotLike(String value) {
/* 769 */       addCriterion("CONTENT not like", value, "content");
/* 770 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentIn(List<String> values) {
/* 774 */       addCriterion("CONTENT in", values, "content");
/* 775 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentNotIn(List<String> values) {
/* 779 */       addCriterion("CONTENT not in", values, "content");
/* 780 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentBetween(String value1, String value2) {
/* 784 */       addCriterion("CONTENT between", value1, value2, "content");
/* 785 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andContentNotBetween(String value1, String value2) {
/* 789 */       addCriterion("CONTENT not between", value1, value2, "content");
/* 790 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateIsNull() {
/* 794 */       addCriterion("GMT_CREATE is null");
/* 795 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateIsNotNull() {
/* 799 */       addCriterion("GMT_CREATE is not null");
/* 800 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateEqualTo(Date value) {
/* 804 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/* 805 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/* 809 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/* 810 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/* 814 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/* 815 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/* 819 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/* 820 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateLessThan(Date value) {
/* 824 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/* 825 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/* 829 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/* 830 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateIn(List<Date> values) {
/* 834 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/* 835 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/* 839 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/* 840 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/* 844 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/* 845 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/* 849 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/* 850 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyIsNull() {
/* 854 */       addCriterion("GMT_MODIFY is null");
/* 855 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyIsNotNull() {
/* 859 */       addCriterion("GMT_MODIFY is not null");
/* 860 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyEqualTo(Date value) {
/* 864 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/* 865 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/* 869 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/* 870 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/* 874 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/* 875 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/* 879 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/* 880 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyLessThan(Date value) {
/* 884 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/* 885 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/* 889 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/* 890 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyIn(List<Date> values) {
/* 894 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/* 895 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/* 899 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/* 900 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/* 904 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/* 905 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancSysOpLogCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/* 909 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/* 910 */       return (FinancSysOpLogCriteria.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancSysOpLogCriteria
 * JD-Core Version:    0.6.0
 */