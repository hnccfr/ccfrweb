/*     */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.SelectValueDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDataShowType;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class ProjectTypeAttri extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 2457419162044737865L;
/*     */   private Long id;
/*     */   private String proTypeCode;
/*     */   private String keyName;
/*     */   private String keyTitle;
/*     */   private String inputType;
/*     */   private String text;
/*     */   private Map<String, String> textMap;
/*     */   private HashMap<String, String> selectValueMap;
/*     */   private List<SelectValueDTO> selectValues;
/*     */   private String remark;
/*     */   private Short enable;
/*     */   private Short rank;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Short isRequired;
/*     */   private String valueValidate;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 111 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 118 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProTypeCode()
/*     */   {
/* 125 */     return this.proTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProTypeCode(String proTypeCode)
/*     */   {
/* 132 */     this.proTypeCode = proTypeCode;
/*     */   }
/*     */ 
/*     */   public String getKeyName()
/*     */   {
/* 139 */     return this.keyName;
/*     */   }
/*     */ 
/*     */   public void setKeyName(String keyName)
/*     */   {
/* 146 */     this.keyName = keyName;
/*     */   }
/*     */ 
/*     */   public String getKeyTitle()
/*     */   {
/* 153 */     return this.keyTitle;
/*     */   }
/*     */ 
/*     */   public void setKeyTitle(String keyTitle)
/*     */   {
/* 160 */     this.keyTitle = keyTitle;
/*     */   }
/*     */ 
/*     */   public String getInputType()
/*     */   {
/* 167 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType)
/*     */   {
/* 174 */     this.inputType = inputType;
/*     */   }
/*     */ 
/*     */   public String getText()
/*     */   {
/* 183 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void setText(String text)
/*     */   {
/* 193 */     if ((StringUtil.isNotEmpty(text)) && (StringUtil.isNotEmpty(this.inputType)) && ((EnumDataShowType.SELECT.getValue().equals(this.inputType.toUpperCase())) || (EnumDataShowType.CHECKBOX.getValue().equals(this.inputType.toUpperCase())) || (EnumDataShowType.RADIO.getValue().equals(this.inputType.toUpperCase()))))
/*     */     {
/* 198 */       if (this.selectValueMap == null) {
/* 199 */         this.selectValueMap = new HashMap();
/*     */       }
/* 201 */       String[] objMap = text.split("-");
/* 202 */       if ((objMap != null) && (objMap.length > 0)) {
/* 203 */         for (String selectObj : objMap) {
/* 204 */           if ((selectObj != null) && (!"".equals(selectObj)) && (selectObj.length() > 0)) {
/* 205 */             String[] kvMap = selectObj.split(":");
/* 206 */             if ((!"".equals(kvMap)) && (kvMap != null) && (kvMap.length > 1)) {
/* 207 */               this.selectValueMap.put(kvMap[0], kvMap[1]);
/* 208 */               SelectValueDTO selectValue = new SelectValueDTO();
/* 209 */               selectValue.setKey(kvMap[0]);
/* 210 */               selectValue.setName(kvMap[1]);
/* 211 */               addSelectValue(selectValue);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 217 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 224 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 231 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Short getEnable()
/*     */   {
/* 238 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable)
/*     */   {
/* 245 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public Short getRank()
/*     */   {
/* 252 */     return this.rank;
/*     */   }
/*     */ 
/*     */   public void setRank(Short rank)
/*     */   {
/* 259 */     this.rank = rank;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 266 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 273 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 280 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 287 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 294 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 301 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Short getIsRequired()
/*     */   {
/* 312 */     return this.isRequired;
/*     */   }
/*     */ 
/*     */   public void setIsRequired(Short isRequired)
/*     */   {
/* 323 */     this.isRequired = isRequired;
/*     */   }
/*     */ 
/*     */   public String getValueValidate()
/*     */   {
/* 330 */     return this.valueValidate;
/*     */   }
/*     */ 
/*     */   public void setValueValidate(String valueValidate)
/*     */   {
/* 337 */     this.valueValidate = valueValidate;
/*     */   }
/*     */ 
/*     */   public HashMap<String, String> getSelectValueMap() {
/* 341 */     return this.selectValueMap;
/*     */   }
/*     */ 
/*     */   public void setSelectValueMap(HashMap<String, String> selectValueMap) {
/* 345 */     this.selectValueMap = selectValueMap;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getTextMap() {
/* 349 */     return this.textMap;
/*     */   }
/*     */ 
/*     */   public void setTextMap(Map<String, String> textMap) {
/* 353 */     this.textMap = textMap;
/*     */   }
/*     */ 
/*     */   public void addSelectValue(SelectValueDTO selectValue) {
/* 357 */     if ((this.selectValues == null) || (this.selectValues.size() < 1))
/* 358 */       this.selectValues = new ArrayList();
/* 359 */     this.selectValues.add(selectValue);
/*     */   }
/*     */ 
/*     */   public List<SelectValueDTO> getSelectValues() {
/* 363 */     return this.selectValues;
/*     */   }
/*     */ 
/*     */   public void setSelectValues(List<SelectValueDTO> selectValues) {
/* 367 */     if ((selectValues != null) && (selectValues.size() > 0)) {
/* 368 */       if (this.selectValueMap == null) {
/* 369 */         this.selectValueMap = new HashMap();
/*     */       }
/* 371 */       for (SelectValueDTO selectObj : selectValues) {
/* 372 */         this.selectValueMap.put(selectObj.getKey(), selectObj.getName());
/*     */       }
/*     */     }
/* 375 */     this.selectValues = selectValues;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri
 * JD-Core Version:    0.6.0
 */