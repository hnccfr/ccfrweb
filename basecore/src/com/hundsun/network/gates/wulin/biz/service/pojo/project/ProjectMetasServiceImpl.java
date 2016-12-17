/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.project;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectMetasServiceResult;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectMetasDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.ProjectMetasQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectMetasService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("projectMetasService")
/*     */ public class ProjectMetasServiceImpl extends BaseService
/*     */   implements ProjectMetasService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasDAO projectMetasDAO;
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  25 */     return 0;
/*     */   }
/*     */ 
/*     */   public void insert(ProjectMetas record) {
/*  29 */     this.projectMetasDAO.insert(record);
/*     */   }
/*     */ 
/*     */   public void insertSelective(ProjectMetas record) {
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(ProjectMetas record) {
/*  36 */     return 0;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(ProjectMetas record) {
/*  40 */     return 0;
/*     */   }
/*     */ 
/*     */   public void insert(List<ProjectMetas> metasList) {
/*  44 */     this.projectMetasDAO.insert(metasList);
/*     */   }
/*     */ 
/*     */   public ProjectMetasServiceResult getAllProjectMetas()
/*     */   {
/*  54 */     ProjectMetasServiceResult result = new ProjectMetasServiceResult();
/*  55 */     ProjectMetasQuery metasQuery = new ProjectMetasQuery();
/*  56 */     metasQuery.setOrderStr("projectId desc");
/*  57 */     List projectMetasList = this.projectMetasDAO.selectProjectMetasByObj(metasQuery);
/*  58 */     List dtoList = new ArrayList();
/*     */     try {
/*  60 */       dtoList = converntObjList2DTOList(projectMetasList, dtoList);
/*     */     } catch (Exception e) {
/*  62 */       this.log.error("将projectMetasList对象数组转换为projectMetasDTO数组出错：converntObjList2DTOList(prolList, dtoList);", e);
/*     */ 
/*  66 */       result.setErrorInfo("将projectMetasList对象数组转换为projectMetasDTO数组出错：converntObjList2DTOList(prolList, dtoList);");
/*     */     }
/*     */ 
/*  69 */     result.setProjectMetasDTOList(dtoList);
/*  70 */     return result;
/*     */   }
/*     */ 
/*     */   private List<ProjectMetasDTO> converntObjList2DTOList(List<ProjectMetas> objList, List<ProjectMetasDTO> dtoList)
/*     */     throws Exception
/*     */   {
/*  84 */     for (ProjectMetas projectMetas : objList) {
/*  85 */       ProjectMetasDTO projectMetasDTO = new ProjectMetasDTO();
/*  86 */       BeanUtils.copyProperties(projectMetasDTO, projectMetas);
/*  87 */       dtoList.add(projectMetasDTO);
/*     */     }
/*  89 */     return dtoList;
/*     */   }
/*     */ 
/*     */   public ProjectMetasServiceResult getProjectMetas(String projectCode)
/*     */   {
/*  94 */     ProjectMetasServiceResult result = new ProjectMetasServiceResult();
/*  95 */     ProjectMetasQuery metasQuery = new ProjectMetasQuery();
/*  96 */     metasQuery.setOrderStr("projectId desc");
/*  97 */     metasQuery.setProjectCode(projectCode);
/*  98 */     List projectMetasList = this.projectMetasDAO.selectProjectMetasByObj(metasQuery);
/*  99 */     List dtoList = new ArrayList();
/*     */     try {
/* 101 */       dtoList = converntObjList2DTOList(projectMetasList, dtoList);
/*     */     } catch (Exception e) {
/* 103 */       this.log.error("将projectMetasList对象数组转换为projectMetasDTO数组出错：converntObjList2DTOList(prolList, dtoList);", e);
/*     */ 
/* 107 */       result.setErrorInfo("将projectMetasList对象数组转换为projectMetasDTO数组出错：converntObjList2DTOList(prolList, dtoList);");
/*     */     }
/*     */ 
/* 110 */     result.setProjectMetasDTOList(dtoList);
/* 111 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.project.ProjectMetasServiceImpl
 * JD-Core Version:    0.6.0
 */