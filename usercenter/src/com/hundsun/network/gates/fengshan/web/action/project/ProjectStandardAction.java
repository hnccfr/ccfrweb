/*    */ package com.hundsun.network.gates.fengshan.web.action.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectStandardService;
/*    */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectStandardDTO;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectStandardRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectStandardServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectStandardService;
/*    */ import java.util.List;
/*    */ import org.apache.commons.beanutils.BeanUtils;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class ProjectStandardAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectStandardService projectStandardService;
/*    */ 
/*    */   @Autowired
/*    */   private RemoteProjectStandardService remoteProjectStandardService;
/*    */ 
/*    */   @RequestMapping(value={"project/standard"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @ResponseBody
/*    */   public List<ProjectStandard> getProjectStandardByProjectTypeCode(@RequestParam(value="projectTypeCode", required=false) String projectTypeCode)
/*    */   {
/* 51 */     List list = this.projectStandardService.getStandardByProTypeCode(projectTypeCode);
/*    */ 
/* 53 */     return list;
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/home/standard/show"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String showStandard(@RequestParam("sid") Long sid, Model model)
/*    */     throws Exception
/*    */   {
/* 61 */     ProjectStandardRequest request = new ProjectStandardRequest();
/* 62 */     ProjectStandardServiceResult result = new ProjectStandardServiceResult();
/* 63 */     ProjectStandard standard = new ProjectStandard();
/*    */ 
/* 65 */     request.setSid(sid);
/* 66 */     result = this.remoteProjectStandardService.getStandardById(request);
/* 67 */     if (result != null) {
/* 68 */       List rList = result.getData();
/* 69 */       if ((rList != null) && (rList.size() > 0)) {
/* 70 */         ProjectStandardDTO dto = (ProjectStandardDTO)rList.get(0);
/* 71 */         BeanUtils.copyProperties(standard, dto);
/*    */       }
/*    */     }
/* 74 */     model.addAttribute("standard", standard);
/* 75 */     return "/home/standard/show";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.project.ProjectStandardAction
 * JD-Core Version:    0.6.0
 */