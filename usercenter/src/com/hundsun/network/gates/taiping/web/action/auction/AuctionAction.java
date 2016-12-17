/*     */ package com.hundsun.network.gates.taiping.web.action.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.remote.AjaxResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionHallDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallBidServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.result.HallServiceResult;
/*     */ import com.hundsun.network.gates.taiping.biz.domain.auction.HallJoin;
/*     */ import com.hundsun.network.gates.taiping.biz.service.auction.AuctionService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.IOException;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.codehaus.jackson.map.ObjectMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class AuctionAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuctionService auctionService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_LOGIN})
/*     */   @RequestMapping(value={"auction/join"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String joinFirst(@RequestParam("projectCode") String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/*  57 */     if (null == userAgent) {
/*  58 */       model.addAttribute("message", getMessage("auction.error.unlogin", new String[0]));
/*  59 */       return "error";
/*     */     }
/*     */ 
/*  62 */     if ((null == projectCode) || ("".equals(projectCode))) {
/*  63 */       model.addAttribute("message", getMessage("auction.error.projectcode", new String[0]));
/*  64 */       return "error";
/*     */     }
/*     */ 
/*  67 */     HallServiceResult result = this.auctionService.joinAuctionHall(projectCode, userAgent.getAccount(), null);
/*     */ 
/*  70 */     Long projectId = this.projectListingService.getProjectIdByCode(projectCode);
/*  71 */     if (!result.correct()) {
/*  72 */       if (EnumHallErrorNO.HALL_ERROR.getValue() == result.getErrorNO().intValue()) {
/*  73 */         model.addAttribute("message", getMessage("auction.error.hall.err", new String[0]));
/*  74 */         model.addAttribute("projectId", projectId);
/*  75 */         return "auction/error";
/*     */       }
/*  77 */       if ((EnumHallErrorNO.PARAMETER_WATCHPASSWORD_NEED.getValue() == result.getErrorNO().intValue()) || (EnumHallErrorNO.WAITSTART_ERROR.getValue() == result.getErrorNO().intValue()))
/*     */       {
/*  79 */         HallJoin hallJoin = new HallJoin();
/*  80 */         hallJoin.setProjectCode(projectCode);
/*  81 */         model.addAttribute("sKey", result.getErrorNO().toString());
/*  82 */         if (EnumHallErrorNO.WAITSTART_ERROR.getValue() == result.getErrorNO().intValue()) {
/*  83 */           model.addAttribute("msec", result.getAuctionHallDTO().getBidStartCountDownMilliSeconds());
/*     */ 
/*  85 */           model.addAttribute("hallUserType", result.getHallUserType());
/*     */         }
/*  87 */         model.addAttribute("hallJoin", hallJoin);
/*  88 */         return "auction/access";
/*     */       }
/*     */     }
/*  91 */     ObjectMapper mapper = new ObjectMapper();
/*  92 */     String hallJson = "";
/*     */     try {
/*  94 */       hallJson = mapper.writeValueAsString(result);
/*     */     } catch (IOException e) {
/*  96 */       e.printStackTrace();
/*  97 */       if (this.log.isErrorEnabled()) {
/*  98 */         this.log.error("", e);
/*     */       }
/*     */     }
/* 101 */     model.addAttribute("hall", hallJson);
/* 102 */     model.addAttribute("projectId", projectId);
/* 103 */     model.addAttribute("projectCode", projectCode);
/* 104 */     return "auction/hall";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_LOGIN})
/*     */   @RequestMapping({"auction/access"})
/*     */   public String join(@ModelAttribute("hallJoin") HallJoin hallJoin, BindingResult bindResult, UserAgent userAgent, ModelMap model) {
/* 112 */     if (null == userAgent) {
/* 113 */       model.addAttribute("message", getMessage("auction.error.unlogin", new String[0]));
/* 114 */       return "error";
/*     */     }
/*     */ 
/* 117 */     if ((null == hallJoin.getProjectCode()) || ("".equals(hallJoin.getProjectCode()))) {
/* 118 */       model.addAttribute("message", getMessage("auction.error.projectcode", new String[0]));
/* 119 */       return "error";
/*     */     }
/*     */ 
/* 122 */     HallServiceResult result = this.auctionService.joinAuctionHall(hallJoin.getProjectCode(), userAgent.getAccount(), hallJoin.getWatchPassword());
/*     */ 
/* 124 */     Long projectId = this.projectListingService.getProjectIdByCode(hallJoin.getProjectCode());
/* 125 */     if (!result.correct()) {
/* 126 */       if (EnumHallErrorNO.PARAMETER_WATCHPASSWORD_ERROR.getValue() == result.getErrorNO().intValue()) {
/* 127 */         bindResult.rejectValue("watchPassword", "auction.error.authorizdcode.err", null, null);
/* 128 */         model.addAttribute("sKey", Integer.valueOf(EnumHallErrorNO.PARAMETER_WATCHPASSWORD_NEED.getValue()));
/* 129 */         return "auction/access";
/*     */       }
/* 131 */       if (EnumHallErrorNO.HALL_ERROR.getValue() == result.getErrorNO().intValue()) {
/* 132 */         model.addAttribute("message", getMessage("auction.error.hall.err", new String[0]));
/* 133 */         model.addAttribute("projectId", projectId);
/* 134 */         return "auction/error";
/*     */       }
/* 136 */       if ((EnumHallErrorNO.PARAMETER_WATCHPASSWORD_NEED.getValue() == result.getErrorNO().intValue()) || (EnumHallErrorNO.WAITSTART_ERROR.getValue() == result.getErrorNO().intValue()))
/*     */       {
/* 138 */         model.addAttribute("sKey", result.getErrorNO().toString());
/* 139 */         if (EnumHallErrorNO.WAITSTART_ERROR.getValue() == result.getErrorNO().intValue()) {
/* 140 */           model.addAttribute("msec", result.getAuctionHallDTO().getBidStartCountDownMilliSeconds());
/*     */ 
/* 142 */           model.addAttribute("hallUserType", result.getHallUserType());
/*     */         }
/* 144 */         model.addAttribute("hallJoin", hallJoin);
/* 145 */         return "auction/access";
/*     */       }
/*     */     }
/* 148 */     ObjectMapper mapper = new ObjectMapper();
/* 149 */     String hallJson = "";
/*     */     try {
/* 151 */       hallJson = mapper.writeValueAsString(result);
/*     */     } catch (IOException e) {
/* 153 */       e.printStackTrace();
/* 154 */       if (this.log.isErrorEnabled()) {
/* 155 */         this.log.error("", e);
/*     */       }
/*     */     }
/* 158 */     model.addAttribute("hall", hallJson);
/* 159 */     model.addAttribute("projectId", projectId);
/* 160 */     model.addAttribute("projectCode", hallJoin.getProjectCode());
/* 161 */     return "auction/hall";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_BID})
/*     */   @RequestMapping({"auction/bid"})
/*     */   @ResponseBody
/*     */   public AjaxResult bid(@RequestParam("price") Long price, @RequestParam("priority") String priority, @RequestParam("projectCode") String projectCode, @RequestParam("bidderTrademark") String bidderTrademark, HttpServletRequest httpServletRequest, UserAgent userAgent)
/*     */   {
/* 177 */     AjaxResult result = new AjaxResult();
/*     */ 
/* 179 */     if ((StringUtil.isEmpty(priority)) || ((!EnumActiveStatus.No.getValue().equals(priority)) && (!EnumActiveStatus.Yes.getValue().equals(priority))))
/*     */     {
/* 182 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_ERROR_NULL.getName());
/* 183 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_ERROR_NULL.getValue()));
/* 184 */       return result;
/*     */     }
/*     */ 
/* 187 */     HallBidServiceRequest request = new HallBidServiceRequest();
/* 188 */     request.setBidderTrademark(bidderTrademark);
/* 189 */     request.setBidOperatorAccount(userAgent.getAccount());
/* 190 */     request.setIp(CommonUtils.getIpAddr(httpServletRequest));
/* 191 */     request.setOperator(userAgent.getAccount());
/* 192 */     request.setPrice(price);
/* 193 */     request.setProjectCode(projectCode);
/* 194 */     request.setUsePriority(priority);
/* 195 */     result.setServiceResult(this.auctionService.bidderDid(request));
/* 196 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_AUCTIONNER})
/*     */   @RequestMapping({"auction/auctioneer/do"})
/*     */   @ResponseBody
/*     */   public AjaxResult auctioneerDo(@RequestParam("projectCode") String projectCode, @RequestParam("cmd") String cmd, @RequestParam("status") String status, UserAgent userAgent)
/*     */   {
/* 212 */     AjaxResult result = new AjaxResult();
/* 213 */     result.setServiceResult(this.auctionService.auctioneerDo(userAgent.getAccount(), projectCode, cmd, status));
/*     */ 
/* 215 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_RESERVE_PRICE})
/*     */   @RequestMapping({"auction/auctioneer/setReservePrice"})
/*     */   @ResponseBody
/*     */   public AjaxResult setReservePrice(@RequestParam("projectCode") String projectCode, @RequestParam("reservePrice") Long reservePrice, UserAgent userAgent)
/*     */   {
/* 230 */     AjaxResult result = new AjaxResult();
/* 231 */     result.setServiceResult(this.auctionService.auctioneerSetReservePrice(userAgent.getAccount(), projectCode, reservePrice));
/*     */ 
/* 233 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_BID_RATE})
/*     */   @RequestMapping({"auction/auctioneer/updateBidRate"})
/*     */   @ResponseBody
/*     */   public AjaxResult updateBidRate(@RequestParam("projectCode") String projectCode, @RequestParam("bidRate") Long bidRate, UserAgent userAgent)
/*     */   {
/* 248 */     AjaxResult result = new AjaxResult();
/* 249 */     result.setServiceResult(this.auctionService.auctioneerUpdateBidRate(userAgent.getAccount(), projectCode, bidRate));
/*     */ 
/* 251 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.web.action.auction.AuctionAction
 * JD-Core Version:    0.6.0
 */