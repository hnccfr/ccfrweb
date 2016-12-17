/*    */ package com.hundsun.network.gates.wulin.common.utils;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.utils.CopyUtil;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ProjectCopyUtil<E>
/*    */ {
/*    */   public static void copyProperties(List<ProjectMetasDTO> projectMetasDTOList, List<ProjectMetas> projectMetasList)
/*    */   {
/* 32 */     for (Object obj : projectMetasDTOList) {
/* 33 */       ProjectMetas projectMetas = new ProjectMetas();
/* 34 */       CopyUtil.copyProperties(obj, projectMetas);
/* 35 */       projectMetasList.add(projectMetas);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.common.utils.ProjectCopyUtil
 * JD-Core Version:    0.6.0
 */