/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectMetasDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectStandardDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectTypeAttriDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectListingQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectStandardQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectMetasService;
/*     */ import com.hundsun.network.gates.genshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.genshan.web.util.ProjectCopyUtil;
/*     */ import com.hundsun.network.gates.genshan.web.validator.ProEditValidator;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.PackageTradeData;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectListingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectListingService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("projectListingService")
/*     */ public class ProjectListingServiceImpl extends BaseService
/*     */   implements ProjectListingService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasDAO projectMetasDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectTypeAttriDAO projectTypeAttriDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasService projectMetasService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectStandardDAO projectProjectStandardDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteProjectListingService remoteProjectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemMessageService remoteSystemMessageService;
/*     */ 
/*     */   @Value("${fengshan.domain}")
/*     */   private String fengshanDomain;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   public void paginate(ProjectListingQuery<ProjectListing> page)
/*     */   {
/*  92 */     this.projectListingDAO.paginate(page);
/*     */   }
/*     */ 
/*     */   public ProjectListing getProArriMetaInfo(Long projectListingId)
/*     */   {
/*  99 */     ProjectListing projectListing = this.projectListingDAO.selectByPrimaryKey(projectListingId);
/*     */ 
/* 104 */     String proTypeCode = projectListing.getProjectTypeCode();
/* 105 */     List codeList = new ArrayList();
/* 106 */     codeList.add(proTypeCode);
/* 107 */     String tCode = "";
/* 108 */     int i = 0;
/* 109 */     while ((proTypeCode.length() > 0) && (proTypeCode.indexOf("|") > 0)) {
/* 110 */       String tmpCode = proTypeCode.substring(0, proTypeCode.indexOf("|"));
/* 111 */       if (i > 0)
/* 112 */         tCode = tCode + "|" + tmpCode;
/*     */       else {
/* 114 */         tCode = tmpCode;
/*     */       }
/* 116 */       codeList.add(tCode);
/* 117 */       proTypeCode = proTypeCode.substring(proTypeCode.indexOf("|") + 1, proTypeCode.length());
/* 118 */       i++;
/*     */     }
/* 120 */     List<ProjectTypeAttri> attris = this.projectTypeAttriDAO.getProjectAttriListByQuery(codeList);
/*     */ 
/* 123 */     List metas = this.projectMetasService.getAllProjectMetasByProjectId(projectListingId);
/*     */ 
/* 125 */     Map map = convertMetas2Map(metas);
/*     */ 
/* 129 */     List attriMetas = new ArrayList();
/* 130 */     for (ProjectTypeAttri attr : attris) {
/* 131 */       convertAttrisText(attr);
/* 132 */       AttriMeta attriMeta = new AttriMeta();
/* 133 */       attriMeta.setAttr(attr);
/* 134 */       ProjectMetas aMeta = (ProjectMetas)map.get(attr.getKeyName());
/* 135 */       attriMeta.setMeta(aMeta == null ? new ProjectMetas() : aMeta);
/* 136 */       if (aMeta != null) attriMetas.add(attriMeta);
/*     */     }
/*     */ 
/* 139 */     projectListing.setAttriMeta(attriMetas);
/*     */ 
/* 151 */     ProjectStandard standard = this.projectProjectStandardDAO.selectByPrimaryKey(projectListing.getBreedStandardId());
/*     */ 
/* 153 */     projectListing.setStandard(standard);
/*     */ 
/* 160 */     return projectListing;
/*     */   }
/*     */ 
/*     */   private void convertAttrisText(ProjectTypeAttri attr)
/*     */   {
/* 165 */     if ((attr == null) || (attr.getText() == null))
/* 166 */       return;
/* 167 */     String[] attrText = attr.getText().split("-");
/* 168 */     Map map = new HashMap();
/* 169 */     for (String aText : attrText) {
/* 170 */       String[] text = aText.split(":");
/* 171 */       if (text.length == 2)
/* 172 */         map.put(text[0], text[1]);
/*     */     }
/* 174 */     attr.setTextMap(map);
/*     */   }
/*     */ 
/*     */   private Map<String, ProjectMetas> convertMetas2Map(List<ProjectMetas> metas) {
/* 178 */     Map map = new HashMap();
/* 179 */     for (ProjectMetas aMetas : metas)
/* 180 */       map.put(aMetas.getMetaKey(), aMetas);
/* 181 */     return map;
/*     */   }
/*     */ 
/*     */   public ProjectListing getProSimpInfo(Long projectListingId)
/*     */   {
/* 190 */     return this.projectListingDAO.getProSimpInfo(projectListingId);
/*     */   }
/*     */ 
/*     */   public ProjectListing getProInfo(Long projectListingId)
/*     */   {
/* 199 */     return this.projectListingDAO.selectByPrimaryKey(projectListingId);
/*     */   }
/*     */ 
/*     */   public int getNumOfAuditProject(ProjectListingQuery<ProjectListing> page) {
/* 203 */     return this.projectListingDAO.selectNumOfAuditProject(page).intValue();
/*     */   }
/*     */ 
/*     */   public String getMetaValue(ProjectMetas projectMetas)
/*     */   {
/* 208 */     return this.projectMetasDAO.selectOneMetaValue(projectMetas);
/*     */   }
/*     */ 
/*     */   public ProjectListing getProjectListingById(Long projectListingId)
/*     */   {
/* 218 */     if (null == projectListingId) {
/* 219 */       return null;
/*     */     }
/*     */ 
/* 222 */     ProjectListing projectListing = this.projectListingDAO.selectByPrimaryKey(projectListingId);
/*     */ 
/* 224 */     return doCommonProject(projectListing);
/*     */   }
/*     */ 
/*     */   public ProjectListing getProjectListingByCode(String projectCode)
/*     */   {
/* 234 */     if (null == projectCode) {
/* 235 */       return null;
/*     */     }
/*     */ 
/* 238 */     ProjectListing projectListing = this.projectListingDAO.selectByCode(projectCode);
/*     */ 
/* 240 */     return doCommonProject(projectListing);
/*     */   }
/*     */ 
/*     */   private ProjectListing doCommonProject(ProjectListing projectListing)
/*     */   {
/* 250 */     if (projectListing == null) {
/* 251 */       return null;
/*     */     }
/*     */ 
/* 255 */     String proTypeCode = projectListing.getProjectTypeCode();
/* 256 */     String tradingType = projectListing.getTradingType();
/* 257 */     Long projectListingId = projectListing.getId();
/* 258 */     List<String> codeList = new ArrayList();
/* 259 */     codeList.add(proTypeCode);
/* 260 */     String tCode = "";
/* 261 */     int i = 0;
/* 262 */     while ((proTypeCode.length() > 0) && (proTypeCode.indexOf("|") > 0)) {
/* 263 */       String tmpCode = proTypeCode.substring(0, proTypeCode.indexOf("|"));
/* 264 */       if (i > 0)
/* 265 */         tCode = tCode + "|" + tmpCode;
/*     */       else {
/* 267 */         tCode = tmpCode;
/*     */       }
/* 269 */       codeList.add(tCode);
/* 270 */       proTypeCode = proTypeCode.substring(proTypeCode.indexOf("|") + 1, proTypeCode.length());
/* 271 */       i++;
/*     */     }
/*     */ 
/* 274 */     List<ProjectTypeAttri> attris = this.projectTypeAttriDAO.getProjectAttriListByQuery(codeList);
/*     */ 
/* 276 */     List ptypeAttri = PackageTradeData.getProjectMetasTradeDate(tradingType, projectListing.getListingType());
/*     */ 
/* 278 */     ProjectCopyUtil.copyProjectTypeAttriDTOListAdd2ProjectTypeAttriList(ptypeAttri, attris);
/*     */ 
/* 280 */     List metas = this.projectMetasService.getAllProjectMetasByProjectId(projectListingId);
/*     */ 
/* 282 */     Map map = convertMetas2Map(metas);
/*     */ 
/* 286 */     List attriMetas = new ArrayList();
/* 287 */     List tradeMetas = new ArrayList();
/* 288 */     for (ProjectTypeAttri attr : attris) {
/* 289 */       AttriMeta attriMeta = new AttriMeta();
/* 290 */       attriMeta.setAttr(attr);
/* 291 */       ProjectMetas aMeta = (ProjectMetas)map.get(attr.getKeyName());
/* 292 */       attriMeta.setMeta(aMeta == null ? new ProjectMetas() : aMeta);
/* 293 */       if (aMeta != null) {
/* 294 */         if (EnumMetaGroup.TRADINGTYPE.getValue().equals(aMeta.getMetaGroup()))
/* 295 */           tradeMetas.add(attriMeta);
/*     */         else {
/* 297 */           attriMetas.add(attriMeta);
/*     */         }
/*     */       }
/*     */     }
/* 301 */     projectListing.setTradeMeta(tradeMetas);
/* 302 */     projectListing.setAttriMeta(attriMetas);
/*     */ 
/* 306 */     List standardList = new ArrayList();
/* 307 */     for (String aCode : codeList) {
/* 308 */       ProjectStandardQuery query = new ProjectStandardQuery();
/* 309 */       query.setProjectTypeCode(aCode);
/* 310 */       query.setPageSize(2147483647);
/* 311 */       this.projectProjectStandardDAO.selectPageList(query);
/* 312 */       List tmp_list = query.getData();
/* 313 */       standardList.addAll(tmp_list);
/*     */     }
/* 315 */     projectListing.setProjectStandardList(standardList);
/*     */ 
/* 317 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public List<TradeShowDTO> getProjectTradeTypeAttri(String tradeType, String listingType)
/*     */   {
/* 327 */     List list = new ArrayList();
/* 328 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(tradeType)) {
/* 329 */       ProjectListingDTO plDto = new ProjectListingDTO();
/* 330 */       plDto.setListingType(listingType);
/*     */ 
/* 332 */       list = PackageTradeData.getPlaceOrderShowDTO(plDto);
/*     */     }
/* 334 */     else if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(tradeType)) {
/* 335 */       list = PackageTradeData.getMulitBidOrderShowDTO();
/*     */     }
/* 337 */     else if (EnumTradingType.BID_ORDER.getValue().equals(tradeType)) {
/* 338 */       list = PackageTradeData.getBidOrderShowDTO();
/* 339 */     } else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(tradeType)) {
/* 340 */       list = PackageTradeData.getTransferOrderShowDTO();
/* 341 */     } else if (EnumTradingType.TENDER_ORDER.getValue().equals(tradeType)) {
/* 342 */       list = PackageTradeData.getTenderOrderShowDTO();
/*     */     }
/* 344 */     return list;
/*     */   }
/*     */ 
/*     */   public List<TradeShowDTO> getProjectTradeTypeAttri(String tradeType, HashMap<String, String> ignoreList, String listingType)
/*     */   {
/* 349 */     List list = new ArrayList();
/* 350 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(tradeType)) {
/* 351 */       ProjectListingDTO plDto = new ProjectListingDTO();
/* 352 */       plDto.setListingType(listingType);
/*     */ 
/* 354 */       list = PackageTradeData.getPlaceOrderShowDTO(plDto);
/*     */     }
/*     */     else {
/* 357 */       list = PackageTradeData.getBidOrderShowDTO(ignoreList);
/* 358 */     }return list;
/*     */   }
/*     */ 
/*     */   public Long getProjectIdByCode(String projectCode)
/*     */   {
/* 363 */     return this.projectListingDAO.getProjectId(projectCode);
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult updateProjectListing(ProjectListing projectListing)
/*     */   {
/* 373 */     ProjectListingRequest request = new ProjectListingRequest();
/*     */ 
/* 375 */     request.setProjectListingDTO(ConvertUtils.convertProjectListing2EditDTO(projectListing));
/*     */ 
/* 378 */     if ((StringUtil.isBlank(projectListing.getBreedStandard())) && (projectListing.getMetaValues() != null) && (projectListing.getMetaValues().length > 0))
/*     */     {
/* 380 */       request.setProjectMetasDTOList(ConvertUtils.convertMetaValues2DTO(projectListing));
/*     */     }
/* 382 */     else if ((projectListing.getTradeMetas() != null) && (projectListing.getTradeMetas().length > 0)) {
/* 383 */       request.setProjectMetasDTOList(ConvertUtils.convertMetaValues2DTO(projectListing));
/*     */     }
/*     */ 
/* 389 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 390 */     result = this.remoteProjectListingService.updateProjectListing(request);
/* 391 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult updateProjectListing(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/* 403 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))
/* 404 */       ProjectCopyUtil.copyProjectTradeBO2ProjectListing(tradeBo, projectListing);
/* 405 */     ProjectListingRequest request = new ProjectListingRequest();
/*     */ 
/* 407 */     request.setProjectListingDTO(ConvertUtils.convertProjectListing2EditDTO(projectListing));
/*     */ 
/* 410 */     if ((StringUtil.isBlank(projectListing.getBreedStandard())) && (projectListing.getMetaValues() != null) && (projectListing.getMetaValues().length > 0))
/*     */     {
/* 412 */       request.addProjectMetasDTOList(ConvertUtils.convertProjectMetaValues2ProjectMetaDTO(projectListing));
/*     */     }
/*     */ 
/* 415 */     if ((projectListing.getTradeMetas() != null) && (projectListing.getTradeMetas().length > 0)) {
/* 416 */       request.addProjectMetasDTOList(ConvertUtils.convertProjectMetaValues2ProjectMetaDTO(projectListing, tradeBo.getTradeMetas()));
/*     */     }
/*     */ 
/* 420 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 421 */     result = this.remoteProjectListingService.updateProjectListing(request);
/* 422 */     return result;
/*     */   }
/*     */ 
/*     */   public String selectOneMetaValue(ProjectMetas projectMetas)
/*     */   {
/* 432 */     return this.projectMetasDAO.selectOneMetaValue(projectMetas);
/*     */   }
/*     */ 
/*     */   public ProjectListing getSimpleInfoOfProject(String code)
/*     */   {
/* 445 */     return this.projectListingDAO.selectProjectListingByCode(code);
/*     */   }
/*     */ 
/*     */   public void sendMessageToReviewers(List<String> oldReviewerAccounts, ProjectTradeBO tradeBo, ProjectListing projectListing)
/*     */   {
/* 458 */     List beReviewers = new ArrayList();
/* 459 */     List cancleReviewers = new ArrayList();
/* 460 */     Map userListMap = spiltSetOrCancleUsers(oldReviewerAccounts, tradeBo, EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), projectListing.getId());
/* 461 */     beReviewers = (List)userListMap.get("beUsers");
/* 462 */     cancleReviewers = (List)userListMap.get("cancleUsers");
/*     */ 
/* 464 */     if ((null != beReviewers) && (beReviewers.size() != 0)) {
/* 465 */       SystemMessageRequest request = new SystemMessageRequest();
/* 466 */       request.setUserAccountList(beReviewers);
/* 467 */       request.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 468 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 469 */       request.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 470 */       request.setTitle("您已成为【" + projectListing.getTitle() + "】项目的评审员");
/* 471 */       StringBuffer bf = new StringBuffer();
/* 472 */       bf.append("尊敬的用户您好，您已成为<a style='color: blue;' href='http://" + this.fengshanDomain + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>项目的评审员之一。");
/*     */ 
/* 475 */       bf.append("你有权根据有效竞价人的最后自由报价是否符合要求，保持或取消竞价人进入大厅参加竞价的资格。请多多关注该项目的最新动态并且及时参与该项目的评审工作");
/* 476 */       bf.append("<br /> <strong > 评审时间是：</strong> 拍卖大厅激活后，拍卖开始时间到达之前。");
/* 477 */       bf.append("<br /><br />现在你可以去");
/* 478 */       bf.append("<a  style='color: blue;'  href='http://" + this.fengshanDomain + "/auction/reviewer/waituserprolist.htm' target='_blank' >评审</a>");
/*     */ 
/* 480 */       bf.append("竞价人的自由报价或");
/* 481 */       bf.append("<a   style='color: blue;'  href='http://" + this.fengshanDomain + "/auction/join.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >进入大厅</a>");
/*     */ 
/* 483 */       bf.append("观看。");
/* 484 */       request.setContent(bf.toString());
/*     */       try {
/* 486 */         this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       } catch (Exception e) {
/* 488 */         this.log.error("send systemMessage to cancled reviewers error, cause by:" + e);
/*     */       }
/*     */     }
/* 491 */     if ((null != cancleReviewers) && (cancleReviewers.size() != 0)) {
/* 492 */       SystemMessageRequest request = new SystemMessageRequest();
/* 493 */       request.setUserAccountList(cancleReviewers);
/* 494 */       request.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 495 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 496 */       request.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 497 */       request.setTitle("关于项目【" + projectListing.getTitle() + "】评审员资格的取消通知");
/* 498 */       request.setContent("尊敬的用户您好，您已经被取消了<a style='color: blue;' href='http://" + this.fengshanDomain + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>项目的评审员资格，如有疑问，请联系管理员！");
/*     */       try
/*     */       {
/* 502 */         this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       } catch (Exception e) {
/* 504 */         this.log.error("send systemMessage to cancled reviewers error, cause by:" + e);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void sendMessageToAuctioners(List<String> oldAuctionerAccounts, ProjectTradeBO tradeBo, ProjectListing projectListing)
/*     */   {
/* 519 */     List beReviewers = new ArrayList();
/* 520 */     List cancleReviewers = new ArrayList();
/* 521 */     Map userListMap = spiltSetOrCancleUsers(oldAuctionerAccounts, tradeBo, EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey(), projectListing.getId());
/* 522 */     beReviewers = (List)userListMap.get("beUsers");
/* 523 */     cancleReviewers = (List)userListMap.get("cancleUsers");
/*     */ 
/* 525 */     if ((null != beReviewers) && (beReviewers.size() != 0)) {
/* 526 */       SystemMessageRequest request = new SystemMessageRequest();
/* 527 */       request.setUserAccountList(beReviewers);
/* 528 */       request.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 529 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 530 */       request.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 531 */       request.setTitle("您已成为【" + projectListing.getTitle() + "】项目的拍卖师");
/* 532 */       StringBuffer bf = new StringBuffer();
/* 533 */       bf.append("尊敬的用户您好，您已成为<a style='color: blue;' href='http://" + this.fengshanDomain + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>项目的拍卖师。");
/*     */ 
/* 536 */       bf.append("请多多关注该项目的最新动态并且准时主持该项目的拍卖工作");
/* 537 */       request.setContent(bf.toString());
/*     */       try {
/* 539 */         this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       } catch (Exception e) {
/* 541 */         this.log.error("send systemMessage to cancled reviewers error, cause by:" + e);
/*     */       }
/*     */     }
/* 544 */     if ((null != cancleReviewers) && (cancleReviewers.size() != 0)) {
/* 545 */       SystemMessageRequest request = new SystemMessageRequest();
/* 546 */       request.setUserAccountList(cancleReviewers);
/* 547 */       request.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 548 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 549 */       request.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 550 */       request.setTitle("关于项目【" + projectListing.getTitle() + "】拍卖师资格的取消通知");
/* 551 */       request.setContent("尊敬的用户您好，您已经被取消了<a style='color: blue;' href='http://" + this.fengshanDomain + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>项目的拍卖师资格，如有疑问，请联系管理员！");
/*     */       try
/*     */       {
/* 555 */         this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       } catch (Exception e) {
/* 557 */         this.log.error("send systemMessage to cancled reviewers error, cause by:" + e);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public Map<String, List<String>> spiltSetOrCancleUsers(List<String> oldUsers, ProjectTradeBO tradeBo, String userTypeKey, Long projectId)
/*     */   {
/* 576 */     List beUsers = new ArrayList();
/* 577 */     List cancleUsers = new ArrayList();
/*     */ 
/* 579 */     ProEditValidator projeEditValidator = new ProEditValidator();
/* 580 */     HashMap keyValueMap = projeEditValidator.getMapFromList(tradeBo.getTradeMetas());
/* 581 */     TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(userTypeKey);
/* 582 */     List newUsers = new ArrayList();
/* 583 */     String inputValue = tradeShowDTO.getInputValue();
/* 584 */     List _newUsers = null;
/* 585 */     if (StringUtil.isNotEmpty(inputValue)) {
/* 586 */       _newUsers = Arrays.asList(inputValue.split(","));
/* 587 */       newUsers.addAll(_newUsers);
/*     */     } else {
/* 589 */       newUsers = null;
/*     */     }
/*     */ 
/* 594 */     beUsers = newUsers;
/* 595 */     cancleUsers = oldUsers;
/*     */ 
/* 603 */     if ((null != newUsers) && (null != oldUsers)) {
/* 604 */       for (int i = 0; i < oldUsers.size(); i++) {
/* 605 */         for (int j = 0; j < newUsers.size(); j++)
/* 606 */           if (((String)oldUsers.get(i)).equals(newUsers.get(j))) {
/* 607 */             beUsers.remove(oldUsers.get(i));
/* 608 */             cancleUsers.remove(oldUsers.get(i));
/*     */           }
/*     */       }
/*     */     }
/* 612 */     else if ((null != newUsers) && (null == oldUsers))
/* 613 */       beUsers = newUsers;
/* 614 */     else if ((null == newUsers) && (null != oldUsers)) {
/* 615 */       cancleUsers = oldUsers;
/*     */     }
/* 617 */     Map userListMap = new HashMap();
/* 618 */     userListMap.put("beUsers", beUsers);
/* 619 */     userListMap.put("cancleUsers", cancleUsers);
/* 620 */     return userListMap;
/*     */   }
/*     */ 
/*     */   public void sendMessageToAuctionners(ProjectListing projectListing, String ProjectStatus)
/*     */   {
/* 632 */     List auctionnerAccounts = getAuctionnersOrReviewers(projectListing.getId(), EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/* 633 */     if (auctionnerAccounts != null) {
/* 634 */       SystemMessageRequest request = new SystemMessageRequest();
/* 635 */       request.setUserAccountList(auctionnerAccounts);
/* 636 */       request.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 637 */       request.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 638 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 639 */       if (EnumProjectStatus.SUSPENSION.getValue().equals(ProjectStatus)) {
/* 640 */         request.setTitle("【" + projectListing.getTitle() + "】项目的停牌通知");
/* 641 */         request.setContent("尊敬的用户您好，您所主持的拍卖项目<a style='color: blue;' href='http://" + this.fengshanDomain + ":" + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>已经停牌");
/*     */       }
/* 644 */       else if (EnumProjectStatus.WITHDRAWAL.getValue().equals(ProjectStatus)) {
/* 645 */         request.setTitle("【" + projectListing.getTitle() + "】项目的撤牌通知");
/* 646 */         request.setContent("尊敬的用户您好，您所主持的拍卖项目<a style='color: blue;' href='http://" + this.fengshanDomain + ":" + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>已经撤牌，今后无需再关注此挂牌。");
/*     */       }
/* 649 */       else if (EnumProjectStatus.TRADE.getValue().equals(ProjectStatus)) {
/* 650 */         request.setTitle("【" + projectListing.getTitle() + "】项目的复牌通知");
/* 651 */         request.setContent("尊敬的用户您好，您所主持的拍卖项目<a style='color: blue;' href='http://" + this.fengshanDomain + ":" + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>已经复牌，请及时参与该项目的拍卖工作");
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 656 */         this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       } catch (Exception e) {
/* 658 */         this.log.error("send message to auctionners error cause by:" + e);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void sendMessageToReviewers(ProjectListing projectListing, String ProjectStatus)
/*     */   {
/* 672 */     List reviewerAccounts = getAuctionnersOrReviewers(projectListing.getId(), EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey());
/* 673 */     if (reviewerAccounts != null) {
/* 674 */       SystemMessageRequest request = new SystemMessageRequest();
/* 675 */       request.setUserAccountList(reviewerAccounts);
/* 676 */       request.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 677 */       request.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 678 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 679 */       if (EnumProjectStatus.SUSPENSION.getValue().equals(ProjectStatus)) {
/* 680 */         request.setTitle("【" + projectListing.getTitle() + "】项目的停牌通知");
/* 681 */         request.setContent("尊敬的用户您好，您所评审的拍卖项目<a style='color: blue;' href='http://" + this.fengshanDomain + ":" + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>已经停牌");
/*     */       }
/* 684 */       else if (EnumProjectStatus.WITHDRAWAL.getValue().equals(ProjectStatus)) {
/* 685 */         request.setTitle("【" + projectListing.getTitle() + "】项目的撤牌通知");
/* 686 */         request.setContent("尊敬的用户您好，您所评审的拍卖项目<a style='color: blue;' href='http://" + this.fengshanDomain + ":" + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>已经撤牌，今后无需再关注此挂牌。");
/*     */       }
/* 689 */       else if (EnumProjectStatus.TRADE.getValue().equals(ProjectStatus)) {
/* 690 */         request.setTitle("【" + projectListing.getTitle() + "】项目的复牌通知");
/* 691 */         request.setContent("尊敬的用户您好，您所评审的拍卖项目<a style='color: blue;' href='http://" + this.fengshanDomain + ":" + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>已经复牌，请及时参与该项目的评审工作");
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 696 */         this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       } catch (Exception e) {
/* 698 */         this.log.error("send message to reviewers error cause by:" + e);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<String> getAuctionnersOrReviewers(Long projectId, String userType)
/*     */   {
/* 713 */     List accounts = new ArrayList();
/* 714 */     ProjectMetas query = new ProjectMetas();
/* 715 */     query.setMetaKey(userType);
/* 716 */     query.setProjectId(projectId);
/* 717 */     String userAccounts = this.projectMetasDAO.selectOneMetaValue(query);
/* 718 */     if ((null != userAccounts) && (StringUtil.isNotEmpty(userAccounts))) {
/* 719 */       List _accounts = Arrays.asList(userAccounts.split(","));
/* 720 */       accounts.addAll(_accounts);
/*     */     } else {
/* 722 */       accounts = null;
/*     */     }
/* 724 */     return accounts;
/*     */   }
/*     */ 
/*     */   public List<ProjectListing> getProjectForScreen(Map<String, Object> map)
/*     */   {
/* 729 */     List<ProjectListing> list = this.projectListingDAO.getProjectForScreen(map);
/* 730 */     List result = new ArrayList();
/* 731 */     for (ProjectListing project : list) {
/* 732 */       ProjectListing projectWithOrder = doCommonProject(project);
/* 733 */       List orderList = this.tradeOrderDAO.selectByProjectCode(project.getCode());
/* 734 */       projectWithOrder.setTradeOrderList(orderList);
/* 735 */       result.add(projectWithOrder);
/*     */     }
/* 737 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.project.ProjectListingServiceImpl
 * JD-Core Version:    0.6.0
 */