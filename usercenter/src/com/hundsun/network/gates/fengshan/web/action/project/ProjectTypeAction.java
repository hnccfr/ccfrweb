/*    */ package com.hundsun.network.gates.fengshan.web.action.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetasBO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeJson;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectMetasService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectTypeService;
/*    */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class ProjectTypeAction extends BaseAction
/*    */ {
/* 33 */   protected final Log logger = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private ProjectTypeService projectTypeService;
/*    */ 
/*    */   @Autowired
/*    */   private ProjectMetasService projectMetasService;
/*    */ 
/* 49 */   @RequestMapping({"/ajax/getProjectTypeTree"})
/*    */   @ResponseBody
/*    */   public List<ProjectTypeJson> getProjectTypeTree() { return this.projectTypeService.queryProjectTypeTree("0");
/*    */   }
/*    */ 
/*    */   @RequestMapping({"/project/type/attri"})
/*    */   public void getProjectTypeAttri(@RequestParam(value="typeCode", required=false) String typeCode, @RequestParam(value="projectId", required=false) String projectId, ModelMap model)
/*    */   {
/* 62 */     model.addAttribute("projectTypeAttriList", this.projectTypeService.queryProjectTypeAttri(typeCode));
/*    */ 
/* 64 */     ProjectMetasBO bo = new ProjectMetasBO();
/* 65 */     if (StringUtil.isNotEmpty(projectId)) {
/* 66 */       List metas = this.projectMetasService.getMetasByProjectIdAndMetaGroup(Long.valueOf(projectId), EnumMetaGroup.PROJECTTYPE.getValue());
/*    */ 
/* 68 */       bo.setMetaValues(metas);
/*    */     }
/* 70 */     model.addAttribute("metesBo", bo);
/*    */   }
/*    */ 
/*    */   @RequestMapping({"/project/type/attri/submit"})
/*    */   public String submitProjectTypeAttri(@ModelAttribute("bo") ProjectMetasBO bo, ModelMap model)
/*    */   {
/* 81 */     return "/demo/tree";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.project.ProjectTypeAction
 * JD-Core Version:    0.6.0
 */