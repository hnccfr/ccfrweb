/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectTypeRequest;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectTypeAttriDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectTypeDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectType;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectTypeAttri;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectTypeService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectTypeService")
/*    */ public class ProjectTypeServiceImpl extends BaseService
/*    */   implements ProjectTypeService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectTypeDAO projectTypeDAO;
/*    */ 
/*    */   @Autowired
/*    */   private ProjectTypeAttriDAO projectTypeAttriDAO;
/*    */ 
/*    */   public List<ProjectTypeAttri> getProjectAttriListByQuery(String proTypeCode)
/*    */   {
/* 33 */     if (StringUtil.isEmpty(proTypeCode)) {
/* 34 */       return null;
/*    */     }
/*    */ 
/* 37 */     List codeList = new ArrayList();
/* 38 */     codeList.add(proTypeCode);
/*    */ 
/* 40 */     String tCode = "";
/* 41 */     int i = 0;
/* 42 */     while ((proTypeCode.length() > 0) && (proTypeCode.indexOf("|") > 0)) {
/* 43 */       String tmpCode = proTypeCode.substring(0, proTypeCode.indexOf("|"));
/* 44 */       if (i > 0)
/* 45 */         tCode = tCode + "|" + tmpCode;
/*    */       else {
/* 47 */         tCode = tmpCode;
/*    */       }
/* 49 */       codeList.add(tCode);
/* 50 */       proTypeCode = proTypeCode.substring(proTypeCode.indexOf("|") + 1, proTypeCode.length());
/* 51 */       i++;
/*    */     }
/*    */ 
/* 54 */     return this.projectTypeAttriDAO.getProjectAttriListByQuery(codeList);
/*    */   }
/*    */ 
/*    */   public List<ProjectType> getProjectByCode(ProjectTypeRequest request)
/*    */   {
/* 59 */     Map map = new HashMap();
/* 60 */     map.put("parCode", request.getProjectCode());
/* 61 */     if (request.isActive()) {
/* 62 */       map.put("enable", "0");
/*    */     }
/* 64 */     return this.projectTypeDAO.queryProjectTypeAllChild(map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.project.ProjectTypeServiceImpl
 * JD-Core Version:    0.6.0
 */