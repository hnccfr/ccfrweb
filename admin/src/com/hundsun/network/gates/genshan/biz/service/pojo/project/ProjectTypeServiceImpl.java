/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectTypeAttriDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectTypeDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectType;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeJson;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService;
/*     */ import com.hundsun.network.gates.genshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeAttriDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectTypeRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectTypeAttriServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectTypeServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectTypeService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("projectTypeService")
/*     */ public class ProjectTypeServiceImpl extends BaseService
/*     */   implements ProjectTypeService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectTypeDAO projectTypeDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectTypeAttriDAO projectTypeAttriDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteProjectTypeService remoteProjectTypeService;
/*     */ 
/*     */   public List<ProjectTypeJson> queryProjectTypeTree(String code)
/*     */   {
/*  47 */     List<ProjectTypeDTO> list = new ArrayList();
/*  48 */     ProjectTypeRequest request = new ProjectTypeRequest();
/*  49 */     request.setActive(false);
/*  50 */     request.setProjectCode(code);
/*     */     try {
/*  52 */       ProjectTypeServiceResult result = this.remoteProjectTypeService.getProjectTypeByCode(request);
/*     */ 
/*  54 */       if (result.correct())
/*  55 */         list = result.getData();
/*     */     }
/*     */     catch (Exception e) {
/*  58 */       e.printStackTrace();
/*  59 */       this.log.error("remoteProjectTypeService.getProjectTypeByCode fail", e);
/*  60 */       return null;
/*     */     }
/*  62 */     List jsonList = new ArrayList();
/*  63 */     if ((null != list) && (!list.isEmpty())) {
/*  64 */       for (ProjectTypeDTO type : list) {
/*  65 */         String parentcodeShort = null == type.getParCode() ? "" : type.getParCode();
/*     */ 
/*  71 */         ProjectTypeJson jsonDTO = new ProjectTypeJson(type, parentcodeShort);
/*  72 */         jsonList.add(jsonDTO);
/*     */       }
/*     */     }
/*  75 */     return jsonList;
/*     */   }
/*     */ 
/*     */   private List<ProjectTypeJson> setJsonList(List<ProjectTypeJson> jsonList, List<ProjectType> list, String parentcode)
/*     */   {
/*  81 */     if ((null == list) || (list.isEmpty())) {
/*  82 */       return jsonList;
/*     */     }
/*  84 */     for (ProjectType type : list) {
/*  85 */       ProjectTypeJson jsonDTO = new ProjectTypeJson(type, parentcode);
/*  86 */       jsonList.add(jsonDTO);
/*     */     }
/*  88 */     return jsonList;
/*     */   }
/*     */ 
/*     */   public List<ProjectType> getProTypeListBySelective(ProjectType proType)
/*     */   {
/*  96 */     return this.projectTypeDAO.getProTypeListBySelective(proType);
/*     */   }
/*     */ 
/*     */   private List<ProjectType> getProjectTypeByParentcode(List<ProjectType> list, String parentcode)
/*     */   {
/* 101 */     if ((null == list) || (list.isEmpty())) {
/* 102 */       return null;
/*     */     }
/* 104 */     List childList = new ArrayList();
/* 105 */     for (ProjectType type : list) {
/* 106 */       if (String.valueOf(parentcode).equals(String.valueOf(type.getParCode()))) {
/* 107 */         childList.add(type);
/*     */       }
/*     */     }
/* 110 */     return childList;
/*     */   }
/*     */ 
/*     */   public List<ProjectTypeAttri> getProjectAttriListByQuery(String proTypeCode)
/*     */   {
/* 116 */     if (StringUtil.isEmpty(proTypeCode)) {
/* 117 */       return null;
/*     */     }
/*     */ 
/* 120 */     List codeList = splitProTypeCode(proTypeCode);
/* 121 */     return this.projectTypeAttriDAO.getProjectAttriListByQuery(codeList);
/*     */   }
/*     */ 
/*     */   public void insertProjectType(ProjectType record)
/*     */   {
/* 126 */     this.projectTypeDAO.insert(record);
/*     */   }
/*     */ 
/*     */   public String getCodeWhenInsert(String parCode)
/*     */   {
/* 131 */     ProjectType queryObj = new ProjectType();
/* 132 */     queryObj.setParCode(parCode);
/* 133 */     int count = this.projectTypeDAO.getProjectNumByObj(queryObj);
/* 134 */     return parCode + "|" + (count + 4) + "";
/*     */   }
/*     */ 
/*     */   public ProjectType getProjectTypeByCode(String code)
/*     */   {
/* 139 */     return this.projectTypeDAO.getProjectTypeByCode(code);
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(ProjectType record)
/*     */   {
/* 144 */     return this.projectTypeDAO.updateByPrimaryKeySelective(record);
/*     */   }
/*     */ 
/*     */   public int updateEnableStatus(String code, int enable)
/*     */   {
/* 149 */     return this.projectTypeDAO.updateEnableStatus(code, enable);
/*     */   }
/*     */ 
/*     */   public void insertProjectTypeAttri(ProjectTypeAttri projectTypeAttri)
/*     */   {
/* 154 */     this.projectTypeAttriDAO.insert(projectTypeAttri);
/*     */   }
/*     */ 
/*     */   public ProjectTypeAttri getProjectTypeAttriById(Long id)
/*     */   {
/* 159 */     return this.projectTypeAttriDAO.selectByPrimaryKey(id);
/*     */   }
/*     */ 
/*     */   public List<ProjectTypeAttri> getProjectAttriListBySelective(ProjectTypeAttri proTyepAttri)
/*     */   {
/* 167 */     Map map = new HashMap();
/* 168 */     List codeList = splitProTypeCode(proTyepAttri.getProTypeCode());
/* 169 */     map.put("codeList", codeList);
/* 170 */     map.put("id", proTyepAttri.getId());
/* 171 */     map.put("keyName", proTyepAttri.getKeyName());
/* 172 */     map.put("keyTitle", proTyepAttri.getKeyTitle());
/*     */ 
/* 174 */     return this.projectTypeAttriDAO.getProjectAttriListBySelective(map);
/*     */   }
/*     */ 
/*     */   public int updateAttriByPrimaryKey(ProjectTypeAttri record)
/*     */   {
/* 179 */     return this.projectTypeAttriDAO.updateByPrimaryKey(record);
/*     */   }
/*     */ 
/*     */   public int updateAttriEnableStatus(Long id, Long enable)
/*     */   {
/* 184 */     return this.projectTypeAttriDAO.updateEnableStatus(id, enable);
/*     */   }
/*     */ 
/*     */   private List<String> splitProTypeCode(String proTypeCode)
/*     */   {
/* 191 */     if (StringUtil.isEmpty(proTypeCode)) {
/* 192 */       return null;
/*     */     }
/*     */ 
/* 195 */     List codeList = new ArrayList();
/* 196 */     codeList.add(proTypeCode);
/*     */ 
/* 198 */     String tCode = "";
/* 199 */     int i = 0;
/* 200 */     while ((proTypeCode.length() > 0) && (proTypeCode.indexOf("|") > 0)) {
/* 201 */       String tmpCode = proTypeCode.substring(0, proTypeCode.indexOf("|"));
/* 202 */       if (i > 0)
/* 203 */         tCode = tCode + "|" + tmpCode;
/*     */       else {
/* 205 */         tCode = tmpCode;
/*     */       }
/* 207 */       codeList.add(tCode);
/* 208 */       proTypeCode = proTypeCode.substring(proTypeCode.indexOf("|") + 1, proTypeCode.length());
/* 209 */       i++;
/*     */     }
/* 211 */     return codeList;
/*     */   }
/*     */ 
/*     */   public List<ProjectTypeAttri> queryProjectTypeAttri(String code) {
/* 215 */     List list = new ArrayList();
/* 216 */     List<ProjectTypeAttriDTO> dtoList = new ArrayList();
/* 217 */     ProjectTypeRequest request = new ProjectTypeRequest();
/* 218 */     request.setProjectCode(code);
/*     */     try {
/* 220 */       ProjectTypeAttriServiceResult result = this.remoteProjectTypeService.getProjectTypeAttriByCode(request);
/*     */ 
/* 222 */       if (result.correct())
/* 223 */         dtoList = result.getData();
/*     */     }
/*     */     catch (Exception e) {
/* 226 */       e.printStackTrace();
/* 227 */       this.log.error("remoteProjectTypeService.getProjectTypeByCode fail", e);
/* 228 */       return list;
/*     */     }
/* 230 */     if (null != dtoList) {
/* 231 */       for (ProjectTypeAttriDTO dto : dtoList) {
/* 232 */         list.add(ConvertUtils.convert(dto));
/*     */       }
/*     */     }
/* 235 */     return list;
/*     */   }
/*     */ 
/*     */   public List<ProjectType> getProjectTypeForScreen()
/*     */   {
/* 241 */     return this.projectTypeDAO.getProjectTypeForScreen();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.project.ProjectTypeServiceImpl
 * JD-Core Version:    0.6.0
 */