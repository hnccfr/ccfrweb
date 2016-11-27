/*    */ package com.hundsun.network.gates.genshan.web.action.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectMetasService;
/*    */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*    */ import com.hundsun.network.gates.genshan.web.util.TradeMoneyUtil;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ @Controller
/*    */ public class ProjectTradeTypeAction extends BaseAction
/*    */ {
/* 43 */   protected final Log logger = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private ProjectListingService projectListingService;
/*    */ 
/*    */   @Autowired
/*    */   private ProjectMetasService projectMetasService;
/*    */ 
/*    */   @RequestMapping({"/project/tradeType/attri"})
/*    */   public void getProjectTradeTypeAttri(@RequestParam(value="tradeType", required=false) String tradeType, @RequestParam(value="projectId", required=false) String projectId, @RequestParam(value="bsType", required=false) String bsType, HttpServletRequest request, ModelMap model)
/*    */   {
/* 60 */     ProjectTradeBO tradeBo = new ProjectTradeBO();
/* 61 */     if (StringUtil.isNotEmpty(projectId)) {
/* 62 */       ProjectListing projectListing = this.projectListingService.getProjectListingById(Long.valueOf(projectId));
/*    */ 
/* 64 */       List tradeMetas = new ArrayList();
/* 65 */       if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 66 */         tradeMetas = this.projectMetasService.getMetasByProjectListing(projectListing);
/*    */       } else {
/* 68 */         List pMetas = this.projectMetasService.getMetasByProjectIdAndMetaGroup(Long.valueOf(projectId), EnumMetaGroup.TRADINGTYPE.getValue());
/*    */ 
/* 70 */         tradeMetas = copyProjectMetasList2TradeShowDTOList(pMetas);
/*    */       }
/* 72 */       tradeBo.setTradeMetas(tradeMetas);
/* 73 */       TradeMoneyUtil.conver2ValueUnit(projectListing, tradeBo);
/*    */     }
/*    */ 
/* 77 */     model.addAttribute("attriList", this.projectListingService.getProjectTradeTypeAttri(tradeType, bsType));
/* 78 */     model.addAttribute("tradeBo", tradeBo);
/*    */   }
/*    */ 
/*    */   private List<TradeShowDTO> copyProjectMetasList2TradeShowDTOList(List<ProjectMetas> pMetas) {
/* 82 */     List tradeShowDTOList = new ArrayList();
/* 83 */     for (ProjectMetas projectMetas : pMetas) {
/* 84 */       tradeShowDTOList.add(copyProjectMetas2TradeShowDTO(projectMetas));
/*    */     }
/* 86 */     return tradeShowDTOList;
/*    */   }
/*    */ 
/*    */   private TradeShowDTO copyProjectMetas2TradeShowDTO(ProjectMetas projectMetas) {
/* 90 */     TradeShowDTO tradeShowDTO = new TradeShowDTO();
/* 91 */     tradeShowDTO.setInputValue(projectMetas.getMetaValue());
/* 92 */     tradeShowDTO.setKey(projectMetas.getMetaKey());
/* 93 */     tradeShowDTO.setLength(Integer.valueOf(1024));
/* 94 */     tradeShowDTO.setName(projectMetas.getMetaTitle());
/* 95 */     tradeShowDTO.setShowType(projectMetas.getInputType());
/* 96 */     return tradeShowDTO;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.project.ProjectTradeTypeAction
 * JD-Core Version:    0.6.0
 */