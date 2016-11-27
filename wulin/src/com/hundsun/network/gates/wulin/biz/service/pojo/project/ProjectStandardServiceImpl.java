/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectStandardDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectStandardService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("standardService")
/*    */ public class ProjectStandardServiceImpl extends BaseService
/*    */   implements ProjectStandardService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectStandardDAO standardDAO;
/*    */ 
/*    */   public List<ProjectStandard> selectListByProTypeCode(String proTypeCode)
/*    */   {
/* 22 */     if (StringUtil.isEmpty(proTypeCode)) {
/* 23 */       return null;
/*    */     }
/*    */ 
/* 26 */     List codeList = new ArrayList();
/* 27 */     codeList.add(proTypeCode);
/*    */ 
/* 29 */     String tCode = "";
/* 30 */     int i = 0;
/* 31 */     while ((proTypeCode.length() > 0) && (proTypeCode.indexOf("|") > 0)) {
/* 32 */       String tmpCode = proTypeCode.substring(0, proTypeCode.indexOf("|"));
/* 33 */       if (i > 0)
/* 34 */         tCode = tCode + "|" + tmpCode;
/*    */       else {
/* 36 */         tCode = tmpCode;
/*    */       }
/* 38 */       codeList.add(tCode);
/* 39 */       proTypeCode = proTypeCode.substring(proTypeCode.indexOf("|") + 1, proTypeCode.length());
/* 40 */       i++;
/*    */     }
/*    */ 
/* 43 */     return this.standardDAO.getStandardListByQuery(codeList);
/*    */   }
/*    */ 
/*    */   public ProjectStandard getStandardById(Long id)
/*    */   {
/* 54 */     return this.standardDAO.getStandardById(id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.project.ProjectStandardServiceImpl
 * JD-Core Version:    0.6.0
 */