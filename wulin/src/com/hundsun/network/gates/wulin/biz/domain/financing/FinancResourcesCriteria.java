/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class FinancResourcesCriteria
/*     */ {
/*     */   protected String orderByClause;
/*     */   protected boolean distinct;
/*     */   protected List<Criteria> oredCriteria;
/*     */ 
/*     */   public FinancResourcesCriteria()
/*     */   {
/*  29 */     this.oredCriteria = new ArrayList();
/*     */   }
/*     */ 
/*     */   protected FinancResourcesCriteria(FinancResourcesCriteria example)
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
/*     */   public static class Criteria extends FinancResourcesCriteria.GeneratedCriteria {
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
/*     */     public FinancResourcesCriteria.Criteria andIdIsNull() {
/* 204 */       addCriterion("ID is null");
/* 205 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdIsNotNull() {
/* 209 */       addCriterion("ID is not null");
/* 210 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdEqualTo(Long value) {
/* 214 */       addCriterion("ID =", value, "id");
/* 215 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdNotEqualTo(Long value) {
/* 219 */       addCriterion("ID <>", value, "id");
/* 220 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdGreaterThan(Long value) {
/* 224 */       addCriterion("ID >", value, "id");
/* 225 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdGreaterThanOrEqualTo(Long value) {
/* 229 */       addCriterion("ID >=", value, "id");
/* 230 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdLessThan(Long value) {
/* 234 */       addCriterion("ID <", value, "id");
/* 235 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdLessThanOrEqualTo(Long value) {
/* 239 */       addCriterion("ID <=", value, "id");
/* 240 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdIn(List<Long> values) {
/* 244 */       addCriterion("ID in", values, "id");
/* 245 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdNotIn(List<Long> values) {
/* 249 */       addCriterion("ID not in", values, "id");
/* 250 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdBetween(Long value1, Long value2) {
/* 254 */       addCriterion("ID between", value1, value2, "id");
/* 255 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andIdNotBetween(Long value1, Long value2) {
/* 259 */       addCriterion("ID not between", value1, value2, "id");
/* 260 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeIsNull() {
/* 264 */       addCriterion("TYPE is null");
/* 265 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeIsNotNull() {
/* 269 */       addCriterion("TYPE is not null");
/* 270 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeEqualTo(String value) {
/* 274 */       addCriterion("TYPE =", value, "type");
/* 275 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeNotEqualTo(String value) {
/* 279 */       addCriterion("TYPE <>", value, "type");
/* 280 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeGreaterThan(String value) {
/* 284 */       addCriterion("TYPE >", value, "type");
/* 285 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeGreaterThanOrEqualTo(String value) {
/* 289 */       addCriterion("TYPE >=", value, "type");
/* 290 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeLessThan(String value) {
/* 294 */       addCriterion("TYPE <", value, "type");
/* 295 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeLessThanOrEqualTo(String value) {
/* 299 */       addCriterion("TYPE <=", value, "type");
/* 300 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeLike(String value) {
/* 304 */       addCriterion("TYPE like", value, "type");
/* 305 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeNotLike(String value) {
/* 309 */       addCriterion("TYPE not like", value, "type");
/* 310 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeIn(List<String> values) {
/* 314 */       addCriterion("TYPE in", values, "type");
/* 315 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeNotIn(List<String> values) {
/* 319 */       addCriterion("TYPE not in", values, "type");
/* 320 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeBetween(String value1, String value2) {
/* 324 */       addCriterion("TYPE between", value1, value2, "type");
/* 325 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andTypeNotBetween(String value1, String value2) {
/* 329 */       addCriterion("TYPE not between", value1, value2, "type");
/* 330 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameIsNull() {
/* 334 */       addCriterion("NAME is null");
/* 335 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameIsNotNull() {
/* 339 */       addCriterion("NAME is not null");
/* 340 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameEqualTo(String value) {
/* 344 */       addCriterion("NAME =", value, "name");
/* 345 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameNotEqualTo(String value) {
/* 349 */       addCriterion("NAME <>", value, "name");
/* 350 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameGreaterThan(String value) {
/* 354 */       addCriterion("NAME >", value, "name");
/* 355 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameGreaterThanOrEqualTo(String value) {
/* 359 */       addCriterion("NAME >=", value, "name");
/* 360 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameLessThan(String value) {
/* 364 */       addCriterion("NAME <", value, "name");
/* 365 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameLessThanOrEqualTo(String value) {
/* 369 */       addCriterion("NAME <=", value, "name");
/* 370 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameLike(String value) {
/* 374 */       addCriterion("NAME like", value, "name");
/* 375 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameNotLike(String value) {
/* 379 */       addCriterion("NAME not like", value, "name");
/* 380 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameIn(List<String> values) {
/* 384 */       addCriterion("NAME in", values, "name");
/* 385 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameNotIn(List<String> values) {
/* 389 */       addCriterion("NAME not in", values, "name");
/* 390 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameBetween(String value1, String value2) {
/* 394 */       addCriterion("NAME between", value1, value2, "name");
/* 395 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameNotBetween(String value1, String value2) {
/* 399 */       addCriterion("NAME not between", value1, value2, "name");
/* 400 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnIsNull() {
/* 404 */       addCriterion("NAME_CN is null");
/* 405 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnIsNotNull() {
/* 409 */       addCriterion("NAME_CN is not null");
/* 410 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnEqualTo(String value) {
/* 414 */       addCriterion("NAME_CN =", value, "nameCn");
/* 415 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnNotEqualTo(String value) {
/* 419 */       addCriterion("NAME_CN <>", value, "nameCn");
/* 420 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnGreaterThan(String value) {
/* 424 */       addCriterion("NAME_CN >", value, "nameCn");
/* 425 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnGreaterThanOrEqualTo(String value) {
/* 429 */       addCriterion("NAME_CN >=", value, "nameCn");
/* 430 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnLessThan(String value) {
/* 434 */       addCriterion("NAME_CN <", value, "nameCn");
/* 435 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnLessThanOrEqualTo(String value) {
/* 439 */       addCriterion("NAME_CN <=", value, "nameCn");
/* 440 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnLike(String value) {
/* 444 */       addCriterion("NAME_CN like", value, "nameCn");
/* 445 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnNotLike(String value) {
/* 449 */       addCriterion("NAME_CN not like", value, "nameCn");
/* 450 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnIn(List<String> values) {
/* 454 */       addCriterion("NAME_CN in", values, "nameCn");
/* 455 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnNotIn(List<String> values) {
/* 459 */       addCriterion("NAME_CN not in", values, "nameCn");
/* 460 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnBetween(String value1, String value2) {
/* 464 */       addCriterion("NAME_CN between", value1, value2, "nameCn");
/* 465 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andNameCnNotBetween(String value1, String value2) {
/* 469 */       addCriterion("NAME_CN not between", value1, value2, "nameCn");
/* 470 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueIsNull() {
/* 474 */       addCriterion("VALUE is null");
/* 475 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueIsNotNull() {
/* 479 */       addCriterion("VALUE is not null");
/* 480 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueEqualTo(String value) {
/* 484 */       addCriterion("VALUE =", value, "value");
/* 485 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueNotEqualTo(String value) {
/* 489 */       addCriterion("VALUE <>", value, "value");
/* 490 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueGreaterThan(String value) {
/* 494 */       addCriterion("VALUE >", value, "value");
/* 495 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueGreaterThanOrEqualTo(String value) {
/* 499 */       addCriterion("VALUE >=", value, "value");
/* 500 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueLessThan(String value) {
/* 504 */       addCriterion("VALUE <", value, "value");
/* 505 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueLessThanOrEqualTo(String value) {
/* 509 */       addCriterion("VALUE <=", value, "value");
/* 510 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueLike(String value) {
/* 514 */       addCriterion("VALUE like", value, "value");
/* 515 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueNotLike(String value) {
/* 519 */       addCriterion("VALUE not like", value, "value");
/* 520 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueIn(List<String> values) {
/* 524 */       addCriterion("VALUE in", values, "value");
/* 525 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueNotIn(List<String> values) {
/* 529 */       addCriterion("VALUE not in", values, "value");
/* 530 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueBetween(String value1, String value2) {
/* 534 */       addCriterion("VALUE between", value1, value2, "value");
/* 535 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andValueNotBetween(String value1, String value2) {
/* 539 */       addCriterion("VALUE not between", value1, value2, "value");
/* 540 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkIsNull() {
/* 544 */       addCriterion("REMARK is null");
/* 545 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkIsNotNull() {
/* 549 */       addCriterion("REMARK is not null");
/* 550 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkEqualTo(String value) {
/* 554 */       addCriterion("REMARK =", value, "remark");
/* 555 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkNotEqualTo(String value) {
/* 559 */       addCriterion("REMARK <>", value, "remark");
/* 560 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkGreaterThan(String value) {
/* 564 */       addCriterion("REMARK >", value, "remark");
/* 565 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkGreaterThanOrEqualTo(String value) {
/* 569 */       addCriterion("REMARK >=", value, "remark");
/* 570 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkLessThan(String value) {
/* 574 */       addCriterion("REMARK <", value, "remark");
/* 575 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkLessThanOrEqualTo(String value) {
/* 579 */       addCriterion("REMARK <=", value, "remark");
/* 580 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkLike(String value) {
/* 584 */       addCriterion("REMARK like", value, "remark");
/* 585 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkNotLike(String value) {
/* 589 */       addCriterion("REMARK not like", value, "remark");
/* 590 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkIn(List<String> values) {
/* 594 */       addCriterion("REMARK in", values, "remark");
/* 595 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkNotIn(List<String> values) {
/* 599 */       addCriterion("REMARK not in", values, "remark");
/* 600 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkBetween(String value1, String value2) {
/* 604 */       addCriterion("REMARK between", value1, value2, "remark");
/* 605 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andRemarkNotBetween(String value1, String value2) {
/* 609 */       addCriterion("REMARK not between", value1, value2, "remark");
/* 610 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableIsNull() {
/* 614 */       addCriterion("ENABLE is null");
/* 615 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableIsNotNull() {
/* 619 */       addCriterion("ENABLE is not null");
/* 620 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableEqualTo(Short value) {
/* 624 */       addCriterion("ENABLE =", value, "enable");
/* 625 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableNotEqualTo(Short value) {
/* 629 */       addCriterion("ENABLE <>", value, "enable");
/* 630 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableGreaterThan(Short value) {
/* 634 */       addCriterion("ENABLE >", value, "enable");
/* 635 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableGreaterThanOrEqualTo(Short value) {
/* 639 */       addCriterion("ENABLE >=", value, "enable");
/* 640 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableLessThan(Short value) {
/* 644 */       addCriterion("ENABLE <", value, "enable");
/* 645 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableLessThanOrEqualTo(Short value) {
/* 649 */       addCriterion("ENABLE <=", value, "enable");
/* 650 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableIn(List<Short> values) {
/* 654 */       addCriterion("ENABLE in", values, "enable");
/* 655 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableNotIn(List<Short> values) {
/* 659 */       addCriterion("ENABLE not in", values, "enable");
/* 660 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableBetween(Short value1, Short value2) {
/* 664 */       addCriterion("ENABLE between", value1, value2, "enable");
/* 665 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andEnableNotBetween(Short value1, Short value2) {
/* 669 */       addCriterion("ENABLE not between", value1, value2, "enable");
/* 670 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeIsNull() {
/* 674 */       addCriterion("INPUT_TYPE is null");
/* 675 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeIsNotNull() {
/* 679 */       addCriterion("INPUT_TYPE is not null");
/* 680 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeEqualTo(String value) {
/* 684 */       addCriterion("INPUT_TYPE =", value, "inputType");
/* 685 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeNotEqualTo(String value) {
/* 689 */       addCriterion("INPUT_TYPE <>", value, "inputType");
/* 690 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeGreaterThan(String value) {
/* 694 */       addCriterion("INPUT_TYPE >", value, "inputType");
/* 695 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeGreaterThanOrEqualTo(String value) {
/* 699 */       addCriterion("INPUT_TYPE >=", value, "inputType");
/* 700 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeLessThan(String value) {
/* 704 */       addCriterion("INPUT_TYPE <", value, "inputType");
/* 705 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeLessThanOrEqualTo(String value) {
/* 709 */       addCriterion("INPUT_TYPE <=", value, "inputType");
/* 710 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeLike(String value) {
/* 714 */       addCriterion("INPUT_TYPE like", value, "inputType");
/* 715 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeNotLike(String value) {
/* 719 */       addCriterion("INPUT_TYPE not like", value, "inputType");
/* 720 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeIn(List<String> values) {
/* 724 */       addCriterion("INPUT_TYPE in", values, "inputType");
/* 725 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeNotIn(List<String> values) {
/* 729 */       addCriterion("INPUT_TYPE not in", values, "inputType");
/* 730 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeBetween(String value1, String value2) {
/* 734 */       addCriterion("INPUT_TYPE between", value1, value2, "inputType");
/* 735 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andInputTypeNotBetween(String value1, String value2) {
/* 739 */       addCriterion("INPUT_TYPE not between", value1, value2, "inputType");
/* 740 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateIsNull() {
/* 744 */       addCriterion("GMT_CREATE is null");
/* 745 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateIsNotNull() {
/* 749 */       addCriterion("GMT_CREATE is not null");
/* 750 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateEqualTo(Date value) {
/* 754 */       addCriterion("GMT_CREATE =", value, "gmtCreate");
/* 755 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateNotEqualTo(Date value) {
/* 759 */       addCriterion("GMT_CREATE <>", value, "gmtCreate");
/* 760 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateGreaterThan(Date value) {
/* 764 */       addCriterion("GMT_CREATE >", value, "gmtCreate");
/* 765 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
/* 769 */       addCriterion("GMT_CREATE >=", value, "gmtCreate");
/* 770 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateLessThan(Date value) {
/* 774 */       addCriterion("GMT_CREATE <", value, "gmtCreate");
/* 775 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
/* 779 */       addCriterion("GMT_CREATE <=", value, "gmtCreate");
/* 780 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateIn(List<Date> values) {
/* 784 */       addCriterion("GMT_CREATE in", values, "gmtCreate");
/* 785 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateNotIn(List<Date> values) {
/* 789 */       addCriterion("GMT_CREATE not in", values, "gmtCreate");
/* 790 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateBetween(Date value1, Date value2) {
/* 794 */       addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
/* 795 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
/* 799 */       addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
/* 800 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyIsNull() {
/* 804 */       addCriterion("GMT_MODIFY is null");
/* 805 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyIsNotNull() {
/* 809 */       addCriterion("GMT_MODIFY is not null");
/* 810 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyEqualTo(Date value) {
/* 814 */       addCriterion("GMT_MODIFY =", value, "gmtModify");
/* 815 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyNotEqualTo(Date value) {
/* 819 */       addCriterion("GMT_MODIFY <>", value, "gmtModify");
/* 820 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyGreaterThan(Date value) {
/* 824 */       addCriterion("GMT_MODIFY >", value, "gmtModify");
/* 825 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
/* 829 */       addCriterion("GMT_MODIFY >=", value, "gmtModify");
/* 830 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyLessThan(Date value) {
/* 834 */       addCriterion("GMT_MODIFY <", value, "gmtModify");
/* 835 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
/* 839 */       addCriterion("GMT_MODIFY <=", value, "gmtModify");
/* 840 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyIn(List<Date> values) {
/* 844 */       addCriterion("GMT_MODIFY in", values, "gmtModify");
/* 845 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyNotIn(List<Date> values) {
/* 849 */       addCriterion("GMT_MODIFY not in", values, "gmtModify");
/* 850 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyBetween(Date value1, Date value2) {
/* 854 */       addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
/* 855 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */ 
/*     */     public FinancResourcesCriteria.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
/* 859 */       addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
/* 860 */       return (FinancResourcesCriteria.Criteria)this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancResourcesCriteria
 * JD-Core Version:    0.6.0
 */