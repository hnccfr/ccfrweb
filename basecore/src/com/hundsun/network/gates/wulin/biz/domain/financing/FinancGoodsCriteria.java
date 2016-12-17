/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class FinancGoodsCriteria
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public FinancGoodsCriteria()
/*     */   {
/*  29 */     this.oredCriteria = new ArrayList();
/*     */   }
/*     */ 
/*     */   protected FinancGoodsCriteria(FinancGoodsCriteria example)
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
/*     */   public static class Criteria extends FinancGoodsCriteria.GeneratedCriteria {
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
/*     */     public FinancGoodsCriteria.Criteria andIdIsNull() {
/* 204 */       addCriterion("ID is null");
/* 205 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdIsNotNull() {
/* 209 */       addCriterion("ID is not null");
/* 210 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdEqualTo(Long value) {
/* 214 */       addCriterion("ID =", value, "id");
/* 215 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdNotEqualTo(Long value) {
/* 219 */       addCriterion("ID <>", value, "id");
/* 220 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdGreaterThan(Long value) {
/* 224 */       addCriterion("ID >", value, "id");
/* 225 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 229 */       addCriterion("ID >=", value, "id");
/* 230 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdLessThan(Long value) {
/* 234 */       addCriterion("ID <", value, "id");
/* 235 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/* 239 */       addCriterion("ID <=", value, "id");
/* 240 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdIn(List<Long> values) {
/* 244 */       addCriterion("ID in", values, "id");
/* 245 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdNotIn(List<Long> values) {
/* 249 */       addCriterion("ID not in", values, "id");
/* 250 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdBetween(Long value1, Long value2) {
/* 254 */       addCriterion("ID between", value1, value2, "id");
/* 255 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/* 259 */       addCriterion("ID not between", value1, value2, "id");
/* 260 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdIsNull() {
/* 264 */       addCriterion("STANDARD_ID is null");
/* 265 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdIsNotNull() {
/* 269 */       addCriterion("STANDARD_ID is not null");
/* 270 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdEqualTo(Long value) {
/* 274 */       addCriterion("STANDARD_ID =", value, "standardId");
/* 275 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdNotEqualTo(Long value) {
/* 279 */       addCriterion("STANDARD_ID <>", value, "standardId");
/* 280 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdGreaterThan(Long value) {
/* 284 */       addCriterion("STANDARD_ID >", value, "standardId");
/* 285 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdGreaterThanOrEqualTo(Long value) {
/* 289 */       addCriterion("STANDARD_ID >=", value, "standardId");
/* 290 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdLessThan(Long value) {
/* 294 */       addCriterion("STANDARD_ID <", value, "standardId");
/* 295 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdLessThanOrEqualTo(Long value) {
/* 299 */       addCriterion("STANDARD_ID <=", value, "standardId");
/* 300 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdIn(List<Long> values) {
/* 304 */       addCriterion("STANDARD_ID in", values, "standardId");
/* 305 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdNotIn(List<Long> values) {
/* 309 */       addCriterion("STANDARD_ID not in", values, "standardId");
/* 310 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdBetween(Long value1, Long value2) {
/* 314 */       addCriterion("STANDARD_ID between", value1, value2, "standardId");
/* 315 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardIdNotBetween(Long value1, Long value2) {
/* 319 */       addCriterion("STANDARD_ID not between", value1, value2, "standardId");
/* 320 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameIsNull() {
/* 324 */       addCriterion("STANDARD_NAME is null");
/* 325 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameIsNotNull() {
/* 329 */       addCriterion("STANDARD_NAME is not null");
/* 330 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameEqualTo(String value) {
/* 334 */       addCriterion("STANDARD_NAME =", value, "standardName");
/* 335 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameNotEqualTo(String value) {
/* 339 */       addCriterion("STANDARD_NAME <>", value, "standardName");
/* 340 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameGreaterThan(String value) {
/* 344 */       addCriterion("STANDARD_NAME >", value, "standardName");
/* 345 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameGreaterThanOrEqualTo(String value) {
/* 349 */       addCriterion("STANDARD_NAME >=", value, "standardName");
/* 350 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameLessThan(String value) {
/* 354 */       addCriterion("STANDARD_NAME <", value, "standardName");
/* 355 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameLessThanOrEqualTo(String value) {
/* 359 */       addCriterion("STANDARD_NAME <=", value, "standardName");
/* 360 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameLike(String value) {
/* 364 */       addCriterion("STANDARD_NAME like", value, "standardName");
/* 365 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameNotLike(String value) {
/* 369 */       addCriterion("STANDARD_NAME not like", value, "standardName");
/* 370 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameIn(List<String> values) {
/* 374 */       addCriterion("STANDARD_NAME in", values, "standardName");
/* 375 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameNotIn(List<String> values) {
/* 379 */       addCriterion("STANDARD_NAME not in", values, "standardName");
/* 380 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameBetween(String value1, String value2) {
/* 384 */       addCriterion("STANDARD_NAME between", value1, value2, "standardName");
/* 385 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andStandardNameNotBetween(String value1, String value2) {
/* 389 */       addCriterion("STANDARD_NAME not between", value1, value2, "standardName");
/* 390 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeIsNull() {
/* 394 */       addCriterion("TYPE_CODE is null");
/* 395 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeIsNotNull() {
/* 399 */       addCriterion("TYPE_CODE is not null");
/* 400 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeEqualTo(String value) {
/* 404 */       addCriterion("TYPE_CODE =", value, "typeCode");
/* 405 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeNotEqualTo(String value) {
/* 409 */       addCriterion("TYPE_CODE <>", value, "typeCode");
/* 410 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeGreaterThan(String value) {
/* 414 */       addCriterion("TYPE_CODE >", value, "typeCode");
/* 415 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
/* 419 */       addCriterion("TYPE_CODE >=", value, "typeCode");
/* 420 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeLessThan(String value) {
/* 424 */       addCriterion("TYPE_CODE <", value, "typeCode");
/* 425 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeLessThanOrEqualTo(String value) {
/* 429 */       addCriterion("TYPE_CODE <=", value, "typeCode");
/* 430 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeLike(String value) {
/* 434 */       addCriterion("TYPE_CODE like", value, "typeCode");
/* 435 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeNotLike(String value) {
/* 439 */       addCriterion("TYPE_CODE not like", value, "typeCode");
/* 440 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeIn(List<String> values) {
/* 444 */       addCriterion("TYPE_CODE in", values, "typeCode");
/* 445 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeNotIn(List<String> values) {
/* 449 */       addCriterion("TYPE_CODE not in", values, "typeCode");
/* 450 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeBetween(String value1, String value2) {
/* 454 */       addCriterion("TYPE_CODE between", value1, value2, "typeCode");
/* 455 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeCodeNotBetween(String value1, String value2) {
/* 459 */       addCriterion("TYPE_CODE not between", value1, value2, "typeCode");
/* 460 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameIsNull() {
/* 464 */       addCriterion("TYPE_NAME is null");
/* 465 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameIsNotNull() {
/* 469 */       addCriterion("TYPE_NAME is not null");
/* 470 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameEqualTo(String value) {
/* 474 */       addCriterion("TYPE_NAME =", value, "typeName");
/* 475 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameNotEqualTo(String value) {
/* 479 */       addCriterion("TYPE_NAME <>", value, "typeName");
/* 480 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameGreaterThan(String value) {
/* 484 */       addCriterion("TYPE_NAME >", value, "typeName");
/* 485 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameGreaterThanOrEqualTo(String value) {
/* 489 */       addCriterion("TYPE_NAME >=", value, "typeName");
/* 490 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameLessThan(String value) {
/* 494 */       addCriterion("TYPE_NAME <", value, "typeName");
/* 495 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameLessThanOrEqualTo(String value) {
/* 499 */       addCriterion("TYPE_NAME <=", value, "typeName");
/* 500 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameLike(String value) {
/* 504 */       addCriterion("TYPE_NAME like", value, "typeName");
/* 505 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameNotLike(String value) {
/* 509 */       addCriterion("TYPE_NAME not like", value, "typeName");
/* 510 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameIn(List<String> values) {
/* 514 */       addCriterion("TYPE_NAME in", values, "typeName");
/* 515 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameNotIn(List<String> values) {
/* 519 */       addCriterion("TYPE_NAME not in", values, "typeName");
/* 520 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameBetween(String value1, String value2) {
/* 524 */       addCriterion("TYPE_NAME between", value1, value2, "typeName");
/* 525 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andTypeNameNotBetween(String value1, String value2) {
/* 529 */       addCriterion("TYPE_NAME not between", value1, value2, "typeName");
/* 530 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecIsNull() {
/* 534 */       addCriterion("SPEC is null");
/* 535 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecIsNotNull() {
/* 539 */       addCriterion("SPEC is not null");
/* 540 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecEqualTo(String value) {
/* 544 */       addCriterion("SPEC =", value, "spec");
/* 545 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecNotEqualTo(String value) {
/* 549 */       addCriterion("SPEC <>", value, "spec");
/* 550 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecGreaterThan(String value) {
/* 554 */       addCriterion("SPEC >", value, "spec");
/* 555 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecGreaterThanOrEqualTo(String value) {
/* 559 */       addCriterion("SPEC >=", value, "spec");
/* 560 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecLessThan(String value) {
/* 564 */       addCriterion("SPEC <", value, "spec");
/* 565 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecLessThanOrEqualTo(String value) {
/* 569 */       addCriterion("SPEC <=", value, "spec");
/* 570 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecLike(String value) {
/* 574 */       addCriterion("SPEC like", value, "spec");
/* 575 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecNotLike(String value) {
/* 579 */       addCriterion("SPEC not like", value, "spec");
/* 580 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecIn(List<String> values) {
/* 584 */       addCriterion("SPEC in", values, "spec");
/* 585 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecNotIn(List<String> values) {
/* 589 */       addCriterion("SPEC not in", values, "spec");
/* 590 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecBetween(String value1, String value2) {
/* 594 */       addCriterion("SPEC between", value1, value2, "spec");
/* 595 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andSpecNotBetween(String value1, String value2) {
/* 599 */       addCriterion("SPEC not between", value1, value2, "spec");
/* 600 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsIsNull() {
/* 604 */       addCriterion("UNITS is null");
/* 605 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsIsNotNull() {
/* 609 */       addCriterion("UNITS is not null");
/* 610 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsEqualTo(String value) {
/* 614 */       addCriterion("UNITS =", value, "units");
/* 615 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsNotEqualTo(String value) {
/* 619 */       addCriterion("UNITS <>", value, "units");
/* 620 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsGreaterThan(String value) {
/* 624 */       addCriterion("UNITS >", value, "units");
/* 625 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsGreaterThanOrEqualTo(String value) {
/* 629 */       addCriterion("UNITS >=", value, "units");
/* 630 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsLessThan(String value) {
/* 634 */       addCriterion("UNITS <", value, "units");
/* 635 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsLessThanOrEqualTo(String value) {
/* 639 */       addCriterion("UNITS <=", value, "units");
/* 640 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsLike(String value) {
/* 644 */       addCriterion("UNITS like", value, "units");
/* 645 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsNotLike(String value) {
/* 649 */       addCriterion("UNITS not like", value, "units");
/* 650 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsIn(List<String> values) {
/* 654 */       addCriterion("UNITS in", values, "units");
/* 655 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsNotIn(List<String> values) {
/* 659 */       addCriterion("UNITS not in", values, "units");
/* 660 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsBetween(String value1, String value2) {
/* 664 */       addCriterion("UNITS between", value1, value2, "units");
/* 665 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andUnitsNotBetween(String value1, String value2) {
/* 669 */       addCriterion("UNITS not between", value1, value2, "units");
/* 670 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableIsNull() {
/* 674 */       addCriterion("ENABLE is null");
/* 675 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableIsNotNull() {
/* 679 */       addCriterion("ENABLE is not null");
/* 680 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableEqualTo(String value) {
/* 684 */       addCriterion("ENABLE =", value, "enable");
/* 685 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableNotEqualTo(String value) {
/* 689 */       addCriterion("ENABLE <>", value, "enable");
/* 690 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableGreaterThan(String value) {
/* 694 */       addCriterion("ENABLE >", value, "enable");
/* 695 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableGreaterThanOrEqualTo(String value) {
/* 699 */       addCriterion("ENABLE >=", value, "enable");
/* 700 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableLessThan(String value) {
/* 704 */       addCriterion("ENABLE <", value, "enable");
/* 705 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableLessThanOrEqualTo(String value) {
/* 709 */       addCriterion("ENABLE <=", value, "enable");
/* 710 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableLike(String value) {
/* 714 */       addCriterion("ENABLE like", value, "enable");
/* 715 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableNotLike(String value) {
/* 719 */       addCriterion("ENABLE not like", value, "enable");
/* 720 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableIn(List<String> values) {
/* 724 */       addCriterion("ENABLE in", values, "enable");
/* 725 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableNotIn(List<String> values) {
/* 729 */       addCriterion("ENABLE not in", values, "enable");
/* 730 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableBetween(String value1, String value2) {
/* 734 */       addCriterion("ENABLE between", value1, value2, "enable");
/* 735 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andEnableNotBetween(String value1, String value2) {
/* 739 */       addCriterion("ENABLE not between", value1, value2, "enable");
/* 740 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateIsNull() {
/* 744 */       addCriterion("GMT_CREATE is null");
/* 745 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateIsNotNull() {
/* 749 */       addCriterion("GMT_CREATE is not null");
/* 750 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateEqualTo(Date value) {
/* 754 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/* 755 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/* 759 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/* 760 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/* 764 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/* 765 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/* 769 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/* 770 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateLessThan(Date value) {
/* 774 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/* 775 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/* 779 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/* 780 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateIn(List<Date> values) {
/* 784 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/* 785 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/* 789 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/* 790 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/* 794 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/* 795 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/* 799 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/* 800 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyIsNull() {
/* 804 */       addCriterion("GMT_MODIFY is null");
/* 805 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyIsNotNull() {
/* 809 */       addCriterion("GMT_MODIFY is not null");
/* 810 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyEqualTo(Date value) {
/* 814 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/* 815 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/* 819 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/* 820 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/* 824 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/* 825 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/* 829 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/* 830 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyLessThan(Date value) {
/* 834 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/* 835 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/* 839 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/* 840 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyIn(List<Date> values) {
/* 844 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/* 845 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/* 849 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/* 850 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/* 854 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/* 855 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancGoodsCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/* 859 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/* 860 */       return (FinancGoodsCriteria.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsCriteria
 * JD-Core Version:    0.6.0
 */