/*      */ package com.hundsun.network.gates.fengshan.biz.service.pojo.project;
/*      */ 
/*      */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectListingDAO;
/*      */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectStandardDAO;
/*      */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectTypeAttriDAO;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.common.CacheDTO;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.AttriMeta;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetasBO;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTradeBO;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionMulitBidProjectQuery;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectStandardQuery;
/*      */ import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
/*      */ import com.hundsun.network.gates.fengshan.biz.enums.EnumListingType;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.common.UploadService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectMetasService;
/*      */ import com.hundsun.network.gates.fengshan.web.util.ConvertUtils;
/*      */ import com.hundsun.network.gates.fengshan.web.util.ProjectCopyUtil;
/*      */ import com.hundsun.network.gates.luosi.biz.domain.PackageTradeData;
/*      */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*      */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*      */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*      */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectBaseSettingDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserCreditDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserLevelDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectBaseSettingRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectListingRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserCreditRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLevelRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectBaseSettingServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserCreditServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserLevelServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectBaseSettingService;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectListingService;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*      */ import com.hundsun.network.melody.common.util.Money;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.math.BigDecimal;
/*      */ import java.text.ParseException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.stereotype.Service;
/*      */ import org.springframework.transaction.TransactionStatus;
/*      */ import org.springframework.transaction.support.TransactionCallback;
/*      */ import org.springframework.transaction.support.TransactionTemplate;
/*      */ 
/*      */ @Service("projectListingService")
/*      */ public class ProjectListingServiceImpl extends BaseService
/*      */   implements ProjectListingService
/*      */ {
/*      */ 
/*      */   @Autowired
/*      */   private ProjectListingDAO projectListingDAO;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectTypeAttriDAO projectTypeAttriDAO;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectMetasService projectMetasService;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectStandardDAO projectProjectStandardDAO;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteProjectListingService remoteProjectListingService;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteUserService remoteUserService;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteProjectBaseSettingService remoteProjectBaseSettingService;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteFundService remoteFundService;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteSystemBaseService remoteSystemBaseService;
/*      */ 
/*      */   @Autowired
/*      */   private UploadService uploadService;
/*  105 */   private static Map<String, CacheDTO<? extends Collection>> cache = new HashMap();
/*      */ 
/*      */   public void getProjectListingByQuery(ProjectListingQuery query) {
/*  108 */     if (query.getTitle() != null) {
/*  109 */       query.setTitle(query.getTitle().trim());
/*      */     }
/*  111 */     if (query.getCode() != null) {
/*  112 */       query.setCode(query.getCode().trim());
/*      */     }
/*  114 */     if (query.getUserAccount() != null) {
/*  115 */       query.setUserAccount(query.getUserAccount().trim());
/*      */     }
/*  117 */     if (query.getStorehouse() != null) {
/*  118 */       query.setStorehouse(query.getStorehouse().trim());
/*      */     }
/*  120 */     this.projectListingDAO.selectByQuery(query);
/*      */   }
/*      */ 
/*      */   public ProjectListing getProjectListingByCode(String code)
/*      */   {
/*  130 */     if (code == null) {
/*  131 */       return null;
/*      */     }
/*  133 */     ProjectListing projectListing = this.projectListingDAO.selectByCode(code);
/*  134 */     return doCommonProject(projectListing);
/*      */   }
/*      */ 
/*      */   private ProjectListing doCommonProject(ProjectListing projectListing)
/*      */   {
/*  145 */     if (projectListing == null) {
/*  146 */       return null;
/*      */     }
/*      */ 
/*  150 */     String proTypeCode = projectListing.getProjectTypeCode();
/*  151 */     String tradingType = projectListing.getTradingType();
/*  152 */     Long projectListingId = projectListing.getId();
/*  153 */     List<String> codeList = new ArrayList();
/*  154 */     codeList.add(proTypeCode);
/*  155 */     String tCode = "";
/*  156 */     int i = 0;
/*  157 */     while ((proTypeCode.length() > 0) && (proTypeCode.indexOf("|") > 0)) {
/*  158 */       String tmpCode = proTypeCode.substring(0, proTypeCode.indexOf("|"));
/*  159 */       if (i > 0)
/*  160 */         tCode = tCode + "|" + tmpCode;
/*      */       else {
/*  162 */         tCode = tmpCode;
/*      */       }
/*  164 */       codeList.add(tCode);
/*  165 */       proTypeCode = proTypeCode.substring(proTypeCode.indexOf("|") + 1, proTypeCode.length());
/*  166 */       i++;
/*      */     }
/*      */ 
/*  169 */     List<ProjectTypeAttri> attris = this.projectTypeAttriDAO.getProjectAttriListByQuery(codeList);
/*      */ 
/*  171 */     List ptypeAttri = 
/*  172 */       PackageTradeData.getProjectMetasTradeDate(tradingType, projectListing.getListingType());
/*  173 */     ProjectCopyUtil.copyProjectTypeAttriDTOListAdd2ProjectTypeAttriList(ptypeAttri, attris);
/*      */ 
/*  175 */     List metas = this.projectMetasService
/*  176 */       .getAllProjectMetasByProjectId(projectListingId);
/*  177 */     Map map = convertMetas2Map(metas);
/*      */ 
/*  181 */     List attriMetas = new ArrayList();
/*  182 */     List tradeMetas = new ArrayList();
/*      */     AttriMeta attriMeta;
/*  183 */     for (ProjectTypeAttri attr : attris) {
/*  184 */       attriMeta = new AttriMeta();
/*  185 */       attriMeta.setAttr(attr);
/*  186 */       ProjectMetas aMeta = (ProjectMetas)map.get(attr.getKeyName());
/*  187 */       attriMeta.setMeta(aMeta == null ? new ProjectMetas() : aMeta);
/*  188 */       if (aMeta != null) {
/*  189 */         if (EnumMetaGroup.TRADINGTYPE.getValue().equals(aMeta.getMetaGroup()))
/*  190 */           tradeMetas.add(attriMeta);
/*      */         else {
/*  192 */           attriMetas.add(attriMeta);
/*      */         }
/*      */       }
/*      */     }
/*  196 */     projectListing.setTradeMeta(tradeMetas);
/*  197 */     projectListing.setAttriMeta(attriMetas);
/*      */ 
/*  201 */     List standardList = new ArrayList();
/*  202 */     for (String aCode : codeList) {
/*  203 */       ProjectStandardQuery query = new ProjectStandardQuery();
/*  204 */       query.setProjectTypeCode(aCode);
/*  205 */       query.setPageSize(2147483647);
/*  206 */       this.projectProjectStandardDAO.selectPageList(query);
/*  207 */       List tmp_list = query.getData();
/*  208 */       standardList.addAll(tmp_list);
/*      */     }
/*  210 */     projectListing.setProjectStandardList(standardList);
/*      */ 
/*  212 */     return projectListing;
/*      */   }
/*      */ 
/*      */   public ProjectListing getProjectListingById(Long projectListingId)
/*      */   {
/*  223 */     if (projectListingId == null) {
/*  224 */       return null;
/*      */     }
/*      */ 
/*  227 */     ProjectListing projectListing = this.projectListingDAO.selectByPrimaryKey(projectListingId);
/*      */ 
/*  229 */     return doCommonProject(projectListing);
/*      */   }
/*      */ 
/*      */   private Map<String, ProjectMetas> convertMetas2Map(List<ProjectMetas> metas)
/*      */   {
/*  234 */     Map map = new HashMap();
/*  235 */     for (ProjectMetas aMetas : metas)
/*  236 */       map.put(aMetas.getMetaKey(), aMetas);
/*  237 */     return map;
/*      */   }
/*      */ 
/*      */   public int deletProjectListingById(Long id)
/*      */   {
/*  251 */     if (id == null) {
/*  252 */       return 0;
/*      */     }
/*  254 */     return this.projectListingDAO.deleteByPrimaryKey(id);
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult updateProjectListing(ProjectListing projectListing)
/*      */   {
/*  265 */     if (projectListing == null) {
/*  266 */       return null;
/*      */     }
/*  268 */     ProjectListingRequest request = new ProjectListingRequest();
/*      */ 
/*  270 */     request.setProjectListingDTO(ConvertUtils.convertProjectListing2EditDTO(projectListing));
/*      */ 
/*  272 */     if ((StringUtil.isBlank(projectListing.getBreedStandard())) && 
/*  273 */       (projectListing.getMetaValues() != null) && (projectListing.getMetaValues().length > 0))
/*  274 */       request.setProjectMetasDTOList(ConvertUtils.convertMetaValues2DTO(projectListing));
/*  275 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*  276 */     result = this.remoteProjectListingService.updateProjectListing(request);
/*  277 */     return result;
/*      */   }
/*      */ 
/*      */   public List<TradeShowDTO> getProjectTradeTypeAttri(String tradeType, String listingType)
/*      */   {
/*  291 */     List list = new ArrayList();
/*  292 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(tradeType)) {
/*  293 */       ProjectListingDTO plDto = new ProjectListingDTO();
/*  294 */       plDto.setListingType(listingType);
/*      */ 
/*  296 */       list = PackageTradeData.getPlaceOrderShowDTO(plDto);
/*  297 */     } else if ((EnumTradingType.BID_ORDER.getValue().equals(tradeType)) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(tradeType))) {
/*  298 */       list = PackageTradeData.getBidOrderShowDTO();
/*  299 */       for (int i = 0; i < list.size(); i++) {
/*  300 */         TradeShowDTO ts = (TradeShowDTO)list.get(i);
/*  301 */         if ("watchPassword".equals(ts.getKey())) {
/*  302 */           list.remove(i);
/*      */         }
/*  305 */         else if ("auctioneerAccount".equals(ts.getKey())) {
/*  306 */           list.remove(i);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*  311 */     else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(tradeType)) {
/*  312 */       list = PackageTradeData.getTransferOrderShowDTO();
/*  313 */     } else if (EnumTradingType.TENDER_ORDER.getValue().equals(tradeType)) {
/*  314 */       list = PackageTradeData.getTenderOrderShowDTO();
/*      */     }
/*  316 */     return list;
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult addProjectListing(ProjectListing projectListing, ProjectMetasBO metesBo)
/*      */   {
/*  331 */     if (projectListing == null) {
/*  332 */       return null;
/*      */     }
/*  334 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*      */ 
/*  336 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*  337 */     projectListingDTO = ConvertUtils.convertProjectListing2ProjectListingDTO(projectListing);
/*  338 */     List projectMetasDTOList = new ArrayList();
/*      */     try {
/*  340 */       ProjectCopyUtil.copyMetasList2DTOList(metesBo.getMetaValues(), projectMetasDTOList);
/*      */     } catch (Exception e) {
/*  342 */       this.log.debug(e + "类型转换出错！");
/*  343 */       result.setErrorNO(Integer.valueOf(0));
/*  344 */       result.setErrorInfo("类型转换出错！");
/*  345 */       return result;
/*      */     }
/*      */ 
/*  348 */     String projectTypeCode = projectListing.getProjectTypeCode();
/*  349 */     String userAccount = projectListing.getUserAccount();
/*      */ 
/*  351 */     UserLevelDTO userLevelDTO = new UserLevelDTO();
/*      */     try {
/*  353 */       userLevelDTO = getUserLevelByAccount(userAccount);
/*      */     } catch (Exception e) {
/*  355 */       this.log.error(e + "根据用户账户获得用户积分错误！");
/*  356 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/*  357 */       result.setErrorInfo("根据用户账户获得用户积分错误！");
/*  358 */       return result;
/*      */     }
/*      */ 
/*  361 */     UserCreditDTO userCreditDTO = new UserCreditDTO();
/*      */     try {
/*  363 */       userCreditDTO = getUserCredit(userAccount);
/*      */     } catch (Exception e) {
/*  365 */       this.log.error(e + "根据用户账户获得用户信誉错误！");
/*  366 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/*  367 */       result.setErrorInfo("根据用户账户获得用户信誉错误！");
/*  368 */       return result;
/*      */     }
/*      */ 
/*  372 */     String memberLevel = userLevelDTO.getMemberLevel();
/*  373 */     Long goodComment = Long.valueOf(0L);
/*  374 */     Long badComment = Long.valueOf(0L);
/*      */ 
/*  376 */     if (EnumListingType.BUY.getValue().equals(projectListing.getListingType())) {
/*  377 */       goodComment = userCreditDTO.getBuyGoodNum();
/*  378 */       badComment = userCreditDTO.getBuyBadNum();
/*      */     } else {
/*  380 */       goodComment = userCreditDTO.getSellerGoodNum();
/*  381 */       badComment = userCreditDTO.getSellerBadNum();
/*      */     }
/*      */ 
/*  384 */     ProjectBaseSettingRequest pbsRequest = new ProjectBaseSettingRequest();
/*      */ 
/*  386 */     pbsRequest.setProTypeCode(projectTypeCode);
/*  387 */     pbsRequest.setTradingType(projectListing.getTradingType());
/*  388 */     pbsRequest.setMemberLevel(memberLevel);
/*  389 */     pbsRequest.setGoodComment(goodComment);
/*  390 */     pbsRequest.setBadComment(badComment);
/*      */ 
/*  392 */     ProjectBaseSettingDTO projectBaseSettingDTO = new ProjectBaseSettingDTO();
/*      */     try {
/*  394 */       projectBaseSettingDTO = getProjectBaseSet(pbsRequest);
/*      */     }
/*      */     catch (ServiceException e)
/*      */     {
/*  404 */       this.log.error("获得下单交易保证金错误！" + e);
/*  405 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/*  406 */       result.setErrorInfo("获得下单交易保证金错误！");
/*  407 */       return result;
/*      */     }
/*      */ 
/*  412 */     ProjectListingRequest request = new ProjectListingRequest();
/*  413 */     projectListingDTO.setProcessAuditNodes(projectBaseSettingDTO.getListingCheckProcess());
/*  414 */     projectListingDTO.setAuditNode(projectListingDTO.getProcessAuditNodes().trim().substring(0, 
/*  415 */       1));
/*      */ 
/*  419 */     request.setProjectListingDTO(projectListingDTO);
/*  420 */     request.setProjectMetasDTOList(projectMetasDTOList);
/*  421 */     if (this.remoteProjectListingService == null) {
/*  422 */       result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getValue()));
/*  423 */       result.setErrorInfo(EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getInfo());
/*      */     }
/*  425 */     result = this.remoteProjectListingService.addProjectListing(request);
/*      */ 
/*  430 */     int integral = 0;
/*      */     try
/*      */     {
/*  438 */       UserLevelRequest urequest = new UserLevelRequest();
/*  439 */       urequest.setIntegral(Integer.valueOf(integral));
/*  440 */       urequest.setUserAccount(projectListing.getUserAccount());
/*  441 */       urequest.setOperator(projectListing.getUserAccount());
/*  442 */       urequest.setOperateCode(EnumSystemDictKey.PROJECT_LISTING_ADDINTEGRAL.getValue());
/*  443 */       if (this.remoteUserService == null) {
/*  444 */         this.log.debug("===========连接远程用户的用户接口失败！");
/*      */       }
/*      */       else {
/*  447 */         UserLevelServiceResult uresult = this.remoteUserService.updateUserLevel(urequest);
/*  448 */         if (uresult == null)
/*  449 */           this.log.debug("====挂牌新增会员积分=======连接远程用户的用户接口新增会员积分失败！+ 会员名称：" + 
/*  450 */             urequest.getOperator() + "   获得积分：" + urequest.getIntegral() + 
/*  451 */             " 时间：" + new Date());
/*  452 */         else if (!uresult.correct())
/*  453 */           this.log.debug(uresult.getErrorInfo());
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  458 */       this.log.debug(e + "====挂牌新增会员积分=======连接远程用户的用户接口新增会员积分失败！+ 会员名称：" + 
/*  459 */         projectListing.getUserAccount() + "   获得积分：" + integral + " 时间：" + 
/*  460 */         new Date());
/*      */     }
/*  462 */     return result;
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult updateProjectListingStatusById(ProjectListing projectListing)
/*      */   {
/*  473 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*  474 */     if (projectListing == null) {
/*  475 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/*  476 */       result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/*  477 */       return result;
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  482 */       String projectId = projectListing.getId().toString();
/*  483 */       String userAccount = projectListing.getUserAccount();
/*  484 */       String fundAccount = projectListing.getFundAccount();
/*  485 */       String tradingType = projectListing.getTradingType();
/*      */ 
/*  487 */       Long orderJyProportionCash = getListingJYDeposit(projectListing, projectListing
/*  488 */         .getUserAccount());
/*      */ 
/*  491 */       Long listingUnturnover = Long.valueOf(0L);
/*      */ 
/*  498 */       TransRequest frequest = new TransRequest();
/*  499 */       frequest.setFundAccount(fundAccount);
/*  500 */       frequest.setOrderProperty(tradingType);
/*  501 */       frequest.setFreezeFeeAmount(listingUnturnover);
/*  502 */       frequest.setBizNo(projectId);
/*  503 */       frequest.setOperator(userAccount);
/*  504 */       frequest.setFreezeDepositAmount(Long.valueOf(orderJyProportionCash.longValue() * projectListing.getQuantity().longValue()));
/*  505 */       FundOperateResult foresult = this.remoteFundService.freezeFundByTrade(frequest);
/*  506 */       if (foresult == null) {
/*  507 */         this.log.debug("调用资金的远程接口失败");
/*  508 */         result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getValue()));
/*  509 */         result.setErrorInfo(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getInfo());
/*  510 */         throw new ServiceException(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getInfo(), 
/*  511 */           Integer.valueOf(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getValue()));
/*  512 */       }if (foresult.isError()) {
/*  513 */         this.log.debug("调用资金的远程接口失败:" + foresult.getErrorInfo());
/*  514 */         result.setErrorNO(Integer.valueOf(foresult.getErrorNO()));
/*  515 */         result.setErrorInfo(foresult.getErrorInfo());
/*  516 */         throw new ServiceException(foresult.getErrorInfo(), Integer.valueOf(foresult
/*  517 */           .getErrorNO()));
/*      */       }
/*      */ 
/*  527 */       this.log.debug("=============TODO   调用资金接口，扣除项目的挂牌交易保证金 :");
/*      */ 
/*  533 */       ProjectListing newPrj = new ProjectListing();
/*  534 */       newPrj.setId(projectListing.getId());
/*  535 */       newPrj.setStatus(EnumProjectStatus.AUDIT.getValue());
/*  536 */       newPrj.setDeposit(orderJyProportionCash);
/*  537 */       projectListing = null;
/*  538 */       ProjectListingRequest request = new ProjectListingRequest();
/*  539 */       ProjectListingDTO projectListingDTO = 
/*  540 */         ConvertUtils.convertProjectListing2ProjectListingDTO(newPrj);
/*  541 */       request.setProjectListingDTO(projectListingDTO);
/*      */ 
/*  543 */       result = this.remoteProjectListingService.updateProjectListingStatusById(request);
/*  544 */       return result;
/*      */     } catch (ServiceException e) {
/*  546 */       result.setErrorInfo(e.getErrorInfo());
/*  547 */       result.setErrorNO(e.getErrorNO());
/*  548 */       this.log.info(" " + e.getErrorInfo());
/*  549 */       return result;
/*      */     } catch (Exception e) {
/*  551 */       this.log.info(e);
/*  552 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/*  553 */       result.setErrorInfo(e.getMessage());
/*  554 */     }return result;
/*      */   }
/*      */ 
/*      */   public void matcheProjectListingByQuery(ProjectListingQuery query)
/*      */   {
/*  565 */     if (query.getId() != null) {
/*  566 */       ProjectListing projectListing = this.projectListingDAO.selectByPrimaryKey(query.getId());
/*      */ 
/*  569 */       query.setTradingType(projectListing.getTradingType());
/*  570 */       query.setBreedStandard(projectListing.getBreedStandard());
/*      */ 
/*  572 */       if (projectListing.getListingType().equals(EnumListingType.BUY.getValue()))
/*  573 */         query.setListingType(EnumListingType.SELL.getValue());
/*      */       else {
/*  575 */         query.setListingType(EnumListingType.BUY.getValue());
/*      */       }
/*  577 */       query.setDeliveryDate(projectListing.getDeliveryDate());
/*  578 */       query.setListingPrice(projectListing.getListingPrice());
/*  579 */       query.setStatus(EnumProjectStatus.TRADE.getValue());
/*      */ 
/*  581 */       this.projectListingDAO.selectByQuery(query);
/*      */     }
/*      */   }
/*      */ 
/*      */   public ProjectListing getProjectListingDetailByCode(String code)
/*      */   {
/*  592 */     ProjectListing projectListing = new ProjectListing();
/*  593 */     if (StringUtil.isNotEmpty(code))
/*  594 */       projectListing = this.projectListingDAO.selectByCode(code);
/*  595 */     return getProjectListingDetail(projectListing);
/*      */   }
/*      */ 
/*      */   public ProjectListing getProjectListingDetailById(Long id)
/*      */   {
/*  605 */     ProjectListing projectListing = new ProjectListing();
/*  606 */     if (id != null)
/*  607 */       projectListing = this.projectListingDAO.selectByPrimaryKey(id);
/*  608 */     return getProjectListingDetail(projectListing);
/*      */   }
/*      */ 
/*      */   public ProjectListing getProjectListingDetail(ProjectListing projectListing)
/*      */   {
/*  618 */     ProjectListing prj = new ProjectListing();
/*  619 */     if (projectListing.getId() != null)
/*  620 */       prj = this.projectListingDAO.selectByPrimaryKey(projectListing.getId());
/*  621 */     List<ProjectMetas> metaList = this.projectMetasService.getMetasByProjectId(projectListing
/*  622 */       .getId());
/*  623 */     List attrList = new ArrayList();
/*  624 */     for (ProjectMetas prjMeta : metaList) {
/*  625 */       AttriMeta attriMeta = new AttriMeta();
/*  626 */       attriMeta.setMeta(prjMeta);
/*  627 */       attrList.add(attriMeta);
/*      */     }
/*  629 */     prj.setAttriMeta(attrList);
/*  630 */     return prj;
/*      */   }
/*      */ 
/*      */   private UserCreditDTO getUserCredit(String userAccount)
/*      */     throws ServiceException
/*      */   {
/*  640 */     UserCreditRequest ucRequest = new UserCreditRequest();
/*  641 */     ucRequest.setUserAccount(userAccount);
/*  642 */     UserCreditServiceResult ucResult = this.remoteUserService.selectByUserAccount(ucRequest);
/*  643 */     if (ucResult == null) {
/*  644 */       throw new ServiceException(EnumTradeResultErrors.SERVER_ERROR.getInfo(), 
/*  645 */         Integer.valueOf(EnumTradeResultErrors.SERVER_ERROR.getValue()));
/*      */     }
/*  647 */     if (!ucResult.correct()) {
/*  648 */       throw new ServiceException(ucResult.getErrorInfo(), Integer.valueOf(ucResult
/*  649 */         .getErrorNO().intValue()));
/*      */     }
/*  651 */     return ucResult.getUserCreditDTO();
/*      */   }
/*      */ 
/*      */   private UserLevelDTO getUserLevelByAccount(String userAccount)
/*      */     throws ServiceException
/*      */   {
/*  661 */     UserLevelRequest request = new UserLevelRequest();
/*  662 */     request.setUserAccount(userAccount);
/*  663 */     UserLevelServiceResult ulResult = this.remoteUserService.selectUserLevelByAccount(request);
/*  664 */     if (ulResult == null) {
/*  665 */       throw new ServiceException(EnumTradeResultErrors.SERVER_ERROR.getInfo(), 
/*  666 */         Integer.valueOf(EnumTradeResultErrors.SERVER_ERROR.getValue()));
/*      */     }
/*  668 */     if (!ulResult.correct()) {
/*  669 */       throw new ServiceException(ulResult.getErrorInfo(), Integer.valueOf(ulResult
/*  670 */         .getErrorNO().intValue()));
/*      */     }
/*  672 */     return ulResult.getUserLevelDTO();
/*      */   }
/*      */ 
/*      */   private Long getListingJyProportionCash(Long totalPay, String proTypeCode, String memberLevel, Long goodComment, Long badComment)
/*      */     throws ServiceException
/*      */   {
/*  695 */     ProjectBaseSettingRequest pbsRequest = new ProjectBaseSettingRequest();
/*  696 */     pbsRequest.setDictParaCode(EnumSystemDictKey.LISTING_JY_PROPORTION.getValue());
/*  697 */     pbsRequest.setProTypeCode(proTypeCode);
/*  698 */     pbsRequest.setTradingType(EnumTradingType.PLACE_ORDER.getValue());
/*  699 */     pbsRequest.setMemberLevel(memberLevel);
/*  700 */     pbsRequest.setGoodComment(goodComment);
/*  701 */     pbsRequest.setBadComment(badComment);
/*  702 */     ProjectBaseSettingDTO projectBaseSettingDTO = getProjectBaseSet(pbsRequest);
/*  703 */     BigDecimal listingJyProportion = BigDecimal.valueOf(0L);
/*  704 */     if (projectBaseSettingDTO.getListingJyProportion() != null) {
/*  705 */       listingJyProportion = 
/*  706 */         BigDecimal.valueOf(projectBaseSettingDTO.getListingJyProportion().longValue()).movePointLeft(4);
/*      */     }
/*  708 */     Long listingJyProportionCash = Long.valueOf(0L);
/*  709 */     BigDecimal gb = new BigDecimal(totalPay.longValue());
/*  710 */     gb = gb.multiply(listingJyProportion);
/*  711 */     listingJyProportionCash = Long.valueOf(gb.longValue());
/*      */ 
/*  717 */     return listingJyProportionCash;
/*      */   }
/*      */ 
/*      */   private ProjectBaseSettingDTO getProjectBaseSet(ProjectBaseSettingRequest pbsRequest)
/*      */     throws ServiceException
/*      */   {
/*  728 */     ProjectBaseSettingServiceResult pbssResult = this.remoteProjectBaseSettingService
/*  729 */       .getProjectBaseSet(pbsRequest);
/*  730 */     if ((pbssResult == null) || (pbssResult.getProjectBaseSettingDTO() == null)) {
/*  731 */       throw new ServiceException(EnumTradeResultErrors.GET_PROJECT_BASE_INFO_ERROR.getInfo(), 
/*  732 */         Integer.valueOf(EnumTradeResultErrors.GET_PROJECT_BASE_INFO_ERROR.getValue()));
/*      */     }
/*  734 */     if (!pbssResult.correct()) {
/*  735 */       throw new ServiceException(pbssResult.getErrorInfo(), Integer.valueOf(pbssResult
/*  736 */         .getErrorNO().intValue()));
/*      */     }
/*  738 */     return pbssResult.getProjectBaseSettingDTO();
/*      */   }
/*      */ 
/*      */   public List<ProjectListing> selectLatestProjectListing(Integer count, String projectTypeCode)
/*      */   {
/*  750 */     ProjectListingQuery query = new ProjectListingQuery();
/*  751 */     query.setProjectRootTypeCode(projectTypeCode);
/*  752 */     query.setPageSize(count.intValue());
/*  753 */     query.setStatus(EnumProjectStatus.TRADE.getValue());
/*  754 */     query.setSysTimeFlag("Y");
/*  755 */     this.projectListingDAO.selectByQuery(query);
/*  756 */     List result = new ArrayList();
/*  757 */     for (int i = 0; i < count.intValue(); i++)
/*  758 */       if (i < query.getData().size()) {
/*  759 */         ProjectListing pro = (ProjectListing)query.getData().get(i);
/*      */ 
/*  765 */         String forestryQuantityDes = "";
/*  766 */         ProjectMetas projectMetas = new ProjectMetas();
/*  767 */         projectMetas.setProjectId(pro.getId());
/*  768 */         projectMetas.setMetaKey("AREA");
/*  769 */         String mushu = this.projectMetasService.getMetaValue(projectMetas);
/*  770 */         projectMetas.setMetaKey("AREA_UNIT");
/*  771 */         String mu = this.projectMetasService.getMetaValue(projectMetas);
/*  772 */         if ((StringUtil.isNotBlank(mushu)) && (StringUtil.isNotBlank(mu))) {
/*  773 */           forestryQuantityDes = mushu + mu;
/*      */         }
/*  775 */         pro.setForestryQuantityDes(forestryQuantityDes);
/*      */ 
/*  777 */         result.add(pro);
/*      */       } else {
/*  779 */         result.add(new ProjectListing());
/*      */       }
/*  781 */     return result;
/*      */   }
/*      */ 
/*      */   public Map<String, List<ProjectListing>> selectLatestProjectListing(Integer count)
/*      */   {
/*  792 */     if ((cache.get("cmsPro") == null) || (((CacheDTO)cache.get("cmsPro")).isOutTime()))
/*  793 */       updateLatestProjectListingCache(count);
/*  794 */     List proList = (List)((CacheDTO)cache.get("cmsPro")).getData();
/*  795 */     Map map = new HashMap();
/*  796 */     map.put("type1", (List)proList.get(0));
/*  797 */     map.put("type2", (List)proList.get(1));
/*  798 */     map.put("type3", (List)proList.get(2));
/*  799 */     map.put("type4", (List)proList.get(3));
/*  800 */     map.put("other", (List)proList.get(4));
/*  801 */     return map;
/*      */   }
/*      */ 
/*      */   private void updateLatestProjectListingCache(Integer count)
/*      */   {
/*  811 */     CacheDTO cmsPro = new CacheDTO();
/*  812 */     ArrayList proList = new ArrayList();
/*      */ 
/*  814 */     proList.add(0, selectLatestProjectListing(count, "0|1"));
/*  815 */     proList.add(1, selectLatestProjectListing(count, "0|2"));
/*  816 */     proList.add(2, selectLatestProjectListing(count, "0|3"));
/*  817 */     proList.add(3, selectLatestProjectListing(count, "0|4"));
/*  818 */     proList.add(4, selectLatestProjectListing(count, "other"));
/*  819 */     cmsPro.setData(proList);
/*  820 */     cmsPro.setOutMs(1800000L);
/*      */     try {
/*  822 */       cmsPro.setUpdateTimeMs(DateUtil.getCurrentDay().getTimeInMillis());
/*      */     } catch (ParseException e) {
/*  824 */       e.printStackTrace();
/*      */     }
/*  826 */     cache.put("cmsPro", cmsPro);
/*      */   }
/*      */ 
/*      */   public List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType type, Long interval)
/*      */   {
/*  831 */     return this.projectListingDAO.queryProjectListingByDate(type, interval);
/*      */   }
/*      */ 
/*      */   public void selectAuctionProjectlist(ProjectListingQuery query)
/*      */   {
/*  840 */     this.projectListingDAO.selectAuctionProjectlist(query);
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult updateProjectListing(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*      */   {
/*  854 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))
/*  855 */       ProjectCopyUtil.copyProjectTradeBO2ProjectListing(tradeBo, projectListing);
/*  856 */     ProjectListingRequest request = new ProjectListingRequest();
/*      */ 
/*  858 */     request.setProjectListingDTO(ConvertUtils.convertProjectListing2EditDTO(projectListing));
/*      */ 
/*  861 */     if ((StringUtil.isBlank(projectListing.getBreedStandard())) && 
/*  862 */       (projectListing.getMetaValues() != null) && (projectListing.getMetaValues().length > 0)) {
/*  863 */       request.setProjectMetasDTOList(ConvertUtils.convertMetaValues2DTO(projectListing));
/*      */     }
/*  865 */     if ((projectListing.getTradeMetas() != null) && (projectListing.getTradeMetas().length > 0)) {
/*  866 */       request.addProjectMetasDTOList(ConvertUtils.convertMetaValues2DTO(projectListing, 
/*  867 */         tradeBo.getTradeMetas()));
/*      */     }
/*      */ 
/*  871 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*  872 */     result = this.remoteProjectListingService.updateProjectListing(request);
/*  873 */     return result;
/*      */   }
/*      */ 
/*      */   public int existsAuctioner(String projectCode, String userAccount)
/*      */   {
/*  884 */     return this.projectListingDAO.existsAuctioner(projectCode, userAccount);
/*      */   }
/*      */ 
/*      */   public Long getListingJYDeposit(ProjectListing projectListing, String userAccount)
/*      */     throws ServiceException
/*      */   {
/*  899 */     Long listingJYdepositScale = getListingJYDepositScale(projectListing, userAccount);
/*  900 */     if (listingJYdepositScale != null) {
/*  901 */       BigDecimal listingJyProportion = null;
/*  902 */       if ((listingJYdepositScale != null) && (listingJYdepositScale.longValue() > 0L)) {
/*  903 */         listingJyProportion = BigDecimal.valueOf(listingJYdepositScale.longValue()).movePointLeft(4);
/*      */       }
/*  905 */       Money money = new Money();
/*  906 */       money.setCent(projectListing.getListingPrice().longValue());
/*  907 */       return Long.valueOf(money.multiply(listingJyProportion).getCent());
/*      */     }
/*  909 */     return Long.valueOf(0L);
/*      */   }
/*      */ 
/*      */   public Long getListingJYDepositScale(ProjectListing projectListing, String userAccount)
/*      */     throws ServiceException
/*      */   {
/*  925 */     UserLevelDTO userLevelDTO = getUserLevelByAccount(userAccount);
/*  926 */     UserCreditDTO userCreditDTO = getUserCredit(userAccount);
/*      */ 
/*  928 */     ProjectBaseSettingRequest pbsRequest = new ProjectBaseSettingRequest();
/*  929 */     pbsRequest.setDictParaCode(EnumSystemDictKey.LISTING_JY_PROPORTION.getValue());
/*  930 */     pbsRequest.setProTypeCode(projectListing.getProjectTypeCode());
/*  931 */     pbsRequest.setTradingType(projectListing.getTradingType());
/*      */ 
/*  933 */     String memberLevel = userLevelDTO.getMemberLevel();
/*  934 */     Long goodComment = Long.valueOf(0L);
/*  935 */     Long badComment = Long.valueOf(0L);
/*  936 */     if (EnumListingType.BUY.getValue().equals(projectListing.getListingType())) {
/*  937 */       goodComment = userCreditDTO.getSellerGoodNum();
/*  938 */       badComment = userCreditDTO.getSellerBadNum();
/*      */     } else {
/*  940 */       goodComment = userCreditDTO.getBuyGoodNum();
/*  941 */       badComment = userCreditDTO.getBuyBadNum();
/*      */     }
/*      */ 
/*  944 */     pbsRequest.setMemberLevel(memberLevel);
/*  945 */     pbsRequest.setGoodComment(goodComment);
/*  946 */     pbsRequest.setBadComment(badComment);
/*  947 */     ProjectBaseSettingServiceResult pbssResult = this.remoteProjectBaseSettingService
/*  948 */       .getProjectBaseSet(pbsRequest);
/*  949 */     return pbssResult.getProjectBaseSettingDTO().getListingJyProportion();
/*      */   }
/*      */ 
/*      */   public void queryAuctionMulitBidProjectChecked(AuctionMulitBidProjectQuery query)
/*      */   {
/*  954 */     List projectStatus = new ArrayList();
/*  955 */     projectStatus.add(EnumProjectStatus.OVER);
/*  956 */     projectStatus.add(EnumProjectStatus.TRADE);
/*  957 */     query.setProjectStatus(projectStatus);
/*  958 */     query.setReviewed(EnumActiveStatus.Yes);
/*  959 */     queryAuctionMulitBidProject(query);
/*      */   }
/*      */ 
/*      */   public void queryAuctionMulitBidProjectUnchecked(AuctionMulitBidProjectQuery query)
/*      */   {
/*  964 */     List projectStatus = new ArrayList();
/*  965 */     projectStatus.add(EnumProjectStatus.TRADE);
/*  966 */     query.setProjectStatus(projectStatus);
/*  967 */     query.setReviewed(EnumActiveStatus.No);
/*  968 */     queryAuctionMulitBidProject(query);
/*      */   }
/*      */ 
/*      */   public void queryAuctionMulitBidProject(AuctionMulitBidProjectQuery query)
/*      */   {
/*  973 */     query.setReviewerKey(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT);
/*  974 */     query.setBidStartTimeKey(EnumMulitBidOrderProperty.BID_START_TIME);
/*  975 */     query.setTradingType(EnumTradingType.MULIT_BID_ORDER);
/*  976 */     this.projectListingDAO.queryAuctionMulitBidProject(query);
/*      */   }
/*      */ 
/*      */   public Long getProjectIdByCode(String projectCode)
/*      */   {
/*  981 */     return this.projectListingDAO.getProjectIdByCode(projectCode);
/*      */   }
/*      */ 
/*      */   public Integer deleteFile(ProjectListing projectListing)
/*      */   {
/*  986 */     final ProjectListing project = projectListing;
/*  987 */     int result = ((Integer)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public Integer doInTransaction(TransactionStatus status) {
/*      */         try {
/*  990 */           ProjectListing updateProject = new ProjectListing();
/*  991 */           updateProject = project;
/*  992 */           int console = ProjectListingServiceImpl.this.projectListingDAO.updateAttachedFilePath(updateProject);
/*  993 */           if (console == 0) {
/*  994 */             status.setRollbackOnly();
/*  995 */             ProjectListingServiceImpl.this.log.error("update file path error when update the database");
/*  996 */             return Integer.valueOf(0);
/*      */           }
/*  998 */           if (!ProjectListingServiceImpl.this.uploadService.deleteOriginalFile(project.getAttachedFilePath())) {
/*  999 */             status.setRollbackOnly();
/* 1000 */             ProjectListingServiceImpl.this.log.error("update file path error when delete the orginal file in server");
/* 1001 */             return Integer.valueOf(0);
/*      */           }
/*      */ 
/* 1004 */           return Integer.valueOf(1);
/*      */         } catch (Exception e) {
/* 1006 */           status.setRollbackOnly();
/* 1007 */           ProjectListingServiceImpl.this.log.equals("update file path error, cause by:" + e);
/* 1008 */         }return Integer.valueOf(0);
/*      */       }
/*      */     })).intValue();
/*      */ 
/* 1012 */     return Integer.valueOf(result);
/*      */   }
/*      */ 
/*      */   public Integer updateAttachedFile(ProjectListing projectListing)
/*      */   {
/* 1017 */     return Integer.valueOf(this.projectListingDAO.updateAttachedFilePath(projectListing));
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.project.ProjectListingServiceImpl
 * JD-Core Version:    0.6.0
 */