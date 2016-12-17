/*      */ package com.hundsun.network.gates.wulin.biz.service.pojo.project;
/*      */ 
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionBidderBidStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionMessageCode;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionResultTranResult;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAuditRes;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*      */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*      */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*      */ import com.hundsun.network.gates.luosi.common.result.ProjectBaseTradeServiceResult;
/*      */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*      */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.ProjectRequest;
/*      */ import com.hundsun.network.gates.luosi.taiping.reomte.service.RemoteAuctionPushletService;
/*      */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionMessageServiceRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumAnnouncementResultErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectListingResultErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.AnnouncementServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectAuditLogServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidRecordDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidRecordHisDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidderDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionFreeBidDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionHallDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionLatestBidDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionLogDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionResultDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageTextDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectAuditLogDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectListingDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectMetasDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.trade.TradeWishOrderDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionHall;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionLatestBid;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionLog;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionMulitBidProject;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionResult;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.message.MessageForMore;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.message.SystemMessageText;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectAuditLog;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.query.AuctionMulitBidProjectQuery;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.query.ProjectListingQuery;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*      */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserLevelService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.message.SystemMessageService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.operation.AnnouncementService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectListingService;
/*      */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.beanutils.BeanUtils;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.codehaus.jackson.map.ObjectMapper;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.beans.factory.annotation.Value;
/*      */ import org.springframework.context.MessageSource;
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
/*      */   private ProjectAuditLogDAO projectAuditLogDAO;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectMetasDAO projectMetasDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AnnouncementService announcementService;
/*      */ 
/*      */   @Autowired
/*      */   private SystemMessageTextDAO systemMessageTextDAO;
/*      */ 
/*      */   @Autowired
/*      */   private SystemMessageDAO systemMessageDAO;
/*      */ 
/*      */   @Autowired
/*      */   private TradeWishOrderDAO tradeWishOrderDAO;
/*      */ 
/*      */   @Autowired
/*      */   private UserAccountDAO userAccountDAO;
/*      */ 
/*      */   @Autowired
/*      */   private UserLevelService userLevelService;
/*      */ 
/*      */   @Autowired
/*      */   private SystemDictService systemDictService;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteFundService remoteFundService;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionHallDAO auctionHallDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionBidderDAO auctionBidderDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionBidRecordDAO auctionBidRecordDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionBidRecordHisDAO auctionBidRecordHisDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionLatestBidDAO auctionLatestBidDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionLogDAO auctionLogDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionResultDAO auctionResultDAO;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionFreeBidDAO auctionFreeBidDAO;
/*      */ 
/*      */   @Autowired
/*      */   private MessageSource messageSource;
/*      */ 
/*      */   @Autowired
/*      */   private SystemMessageService systemMessageService;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteAuctionPushletService remoteAuctionPushletService;
/*      */ 
/*      */   @Value("${fengshan.domain}")
/*      */   private String fengshanDomain;
/*      */ 
/*      */   public ProjectListingServiceResult addProjectListing(ProjectListing projectListing)
/*      */   {
/*  181 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*  182 */     if (null == projectListing) {
/*  183 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PARAMETER_ERROR.getValue()));
/*  184 */       result.setErrorInfo(EnumProjectListingResultErrors.PARAMETER_ERROR.getInfo());
/*  185 */       this.log.error(new StringBuilder().append("add projectListing fail, ").append(result.getErrorInfo()).toString());
/*  186 */       return result;
/*      */     }
/*      */     try {
/*  189 */       String projectId = this.projectListingDAO.addProjectListing(projectListing);
/*  190 */       projectListing.setId(Long.valueOf(projectId));
/*  191 */       ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*  192 */       BeanUtils.copyProperties(projectListingDTO, projectListing);
/*  193 */       result.setProjectListingDTO(projectListingDTO);
/*      */     } catch (IllegalAccessException e) {
/*  195 */       result.setErrorInfo("bean转换出错了！");
/*  196 */       this.log.error("addProjectListing BeanUtils.copyProperties 转换出错了。。。。", e);
/*      */     } catch (InvocationTargetException e) {
/*  198 */       this.log.error("", e);
/*      */     }
/*      */ 
/*  201 */     return result;
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult updateProjectListing(ProjectListing projectListing)
/*      */   {
/*  212 */     return updateProjectListing(projectListing, null);
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult updateProjectListing(ProjectListing projectListing, List<ProjectMetas> metas)
/*      */   {
/*  224 */     if (null == projectListing) {
/*  225 */       ProjectListingServiceResult result = new ProjectListingServiceResult();
/*  226 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PARAMETER_ERROR.getValue()));
/*  227 */       result.setErrorInfo(EnumProjectListingResultErrors.PARAMETER_ERROR.getInfo());
/*  228 */       if (this.log.isErrorEnabled())
/*  229 */         this.log.error(new StringBuilder().append("update projectListing fail, ").append(result.getErrorInfo()).toString());
/*  230 */       return result;
/*      */     }
/*  232 */     final ProjectListing project = projectListing;
/*  233 */     final List<ProjectMetas> metaList = metas;
/*      */ 
/*  235 */     ProjectListingServiceResult addResult = (ProjectListingServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*      */     {
/*      */       public ProjectListingServiceResult doInTransaction(TransactionStatus status) {
/*  238 */         ProjectListingServiceResult result = new ProjectListingServiceResult();
/*      */         try
/*      */         {
/*  241 */           ProjectListingServiceImpl.this.projectListingDAO.updateByPrimaryKeySelective(project);
/*  242 */           HashMap metaMap = new HashMap();
/*      */ 
/*  244 */           if ((metaList != null) && (metaList.size() > 0)) {
/*  245 */             for (ProjectMetas meta : metaList) {
/*  246 */               metaMap.put(meta.getMetaKey(), meta.getMetaValue());
/*      */ 
/*  248 */               ProjectMetas oldMeta = ProjectListingServiceImpl.this.projectMetasDAO.getProjectMetasByProIDAndKey(meta.getProjectId(), meta.getMetaKey());
/*      */ 
/*  251 */               if (oldMeta != null) {
/*  252 */                 meta.setId(oldMeta.getId());
/*  253 */                 ProjectListingServiceImpl.this.projectMetasDAO.updateByPrimaryKey(meta);
/*      */               } else {
/*  255 */                 ProjectListingServiceImpl.this.projectMetasDAO.insert(meta);
/*      */               }
/*      */             }
/*      */           }
/*  259 */           if (EnumTradingType.BID_ORDER.getValue().equals(project.getTradingType())) {
/*  260 */             AuctionLatestBid auctionLatestBid = ProjectListingServiceImpl.this.auctionLatestBidDAO.selectByProjectCode(project.getCode());
/*      */ 
/*  262 */             if ((auctionLatestBid != null) && (EnumAuctionBidderBidStatus.A.getValue().equals(auctionLatestBid.getLatestStatus())))
/*      */             {
/*  265 */               HashMap actionHallMap = new HashMap();
/*  266 */               actionHallMap.put(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey(), metaMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey()));
/*      */ 
/*  268 */               actionHallMap.put(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey(), metaMap.get(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey()));
/*      */ 
/*  270 */               actionHallMap.put("whereProjectCode", project.getCode());
/*      */ 
/*  273 */               ProjectListingServiceImpl.this.auctionHallDAO.updateByMap(actionHallMap);
/*      */             }
/*      */           }
/*      */         } catch (Exception e) {
/*  277 */           e.printStackTrace();
/*  278 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  279 */             ProjectListingServiceImpl.this.log.error("update ProjectListing internal error:", e);
/*  280 */           status.setRollbackOnly();
/*  281 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.INTERNAL_ERROR.getValue()));
/*  282 */           result.setErrorInfo(EnumProjectListingResultErrors.INTERNAL_ERROR.getInfo());
/*      */ 
/*  284 */           return result;
/*      */         }
/*  286 */         result.setProjectListingDTO(ConvertUtils.convertProjectListing2ProjectListingDTO(project));
/*      */ 
/*  288 */         return result;
/*      */       }
/*      */     });
/*  291 */     return addResult;
/*      */   }
/*      */ 
/*      */   public ProjectAuditLogServiceResult auditProjectListing(ProjectAuditLog projectAuditLog, ProjectListing project)
/*      */   {
/*  304 */     if ((null == projectAuditLog) || (null == projectAuditLog.getProjectId()) || (null == projectAuditLog.getAuditRes()))
/*      */     {
/*  306 */       ProjectAuditLogServiceResult result = new ProjectAuditLogServiceResult();
/*  307 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PARAMETER_ERROR.getValue()));
/*  308 */       result.setErrorInfo(EnumProjectListingResultErrors.PARAMETER_ERROR.getInfo());
/*  309 */       if (this.log.isErrorEnabled())
/*  310 */         this.log.error(new StringBuilder().append("audit projectListing fail, ").append(result.getErrorInfo()).toString());
/*  311 */       return result;
/*      */     }
/*  313 */     final ProjectAuditLog newAuditLog = projectAuditLog;
/*  314 */     final ProjectListing proListing = project;
/*      */ 
/*  317 */     ProjectAuditLogServiceResult auditResult = (ProjectAuditLogServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*      */     {
/*      */       public ProjectAuditLogServiceResult doInTransaction(TransactionStatus status) {
/*  320 */         ProjectAuditLogServiceResult result = new ProjectAuditLogServiceResult();
/*      */ 
/*  325 */         ProjectListing projectListing = ProjectListingServiceImpl.this.projectListingDAO.selectByPrimaryKey(newAuditLog.getProjectId());
/*      */ 
/*  327 */         if (!projectListing.isAudit()) {
/*  328 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getValue()));
/*      */ 
/*  330 */           result.setErrorInfo(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getInfo());
/*      */ 
/*  332 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  333 */             ProjectListingServiceImpl.this.log.error("audit projectListing fail, " + result.getErrorInfo());
/*  334 */           return result;
/*      */         }
/*      */ 
/*  337 */         String curNote = projectListing.getAuditNode();
/*  338 */         String processAuditNodes = projectListing.getProcessAuditNodes();
/*  339 */         int curNoteIndex = processAuditNodes.indexOf(curNote);
/*  340 */         if (curNoteIndex < 0) {
/*  341 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PRO_AUDIT_NOTE_ERROR.getValue()));
/*      */ 
/*  343 */           result.setErrorInfo(EnumProjectListingResultErrors.PRO_AUDIT_NOTE_ERROR.getInfo());
/*      */ 
/*  345 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  346 */             ProjectListingServiceImpl.this.log.error("audit projectListing fail, " + result.getErrorInfo());
/*  347 */           return result;
/*      */         }
/*      */ 
/*      */         try
/*      */         {
/*  354 */           newAuditLog.setProcessAuditNodes(projectListing.getProcessAuditNodes());
/*  355 */           newAuditLog.setAuditNode(curNote);
/*  356 */           ProjectListingServiceImpl.this.projectAuditLogDAO.insert(newAuditLog);
/*      */ 
/*  365 */           projectListing.setAuditNode(processAuditNodes.substring(curNoteIndex + 1, curNoteIndex + 2));
/*  366 */           if (EnumAuditRes.NO.getValue().equals(newAuditLog.getAuditRes()))
/*      */           {
/*  368 */             projectListing.setAuditNode(EnumCheckCommonNodes.END_NODE.getValue());
/*      */           }
/*  370 */           projectListing.setOldStatus("'" + EnumProjectStatus.AUDIT.getValue() + "'");
/*      */ 
/*  372 */           if (EnumCheckCommonNodes.END_NODE.getValue().equals(projectListing.getAuditNode())) {
/*  373 */             projectListing.setStatus(EnumAuditRes.YES.getValue().equals(newAuditLog.getAuditRes()) ? EnumProjectStatus.TRADE.getValue() : EnumProjectStatus.FAIL.getValue());
/*      */           }
/*      */ 
/*  377 */           projectListing.setOperator(newAuditLog.getOperator());
/*      */ 
/*  379 */           projectListing.setListingStartTime(proListing.getListingStartTime());
/*  380 */           projectListing.setListingEndTime(proListing.getListingEndTime());
/*  381 */           synchronized (this)
/*      */           {
/*  383 */             if (EnumAuditRes.YES.getValue().equals(newAuditLog.getAuditRes()))
/*  384 */               projectListing.setCode(ProjectListingServiceImpl.this.projectCodeCreator(projectListing));
/*  385 */             ProjectListingServiceImpl.this.projectListingDAO.updateStatusByIdWithOldStatus(projectListing);
/*      */           }
					HashMap metaMap;		
/*  387 */           metaMap = new HashMap();
/*      */ 
/*  389 */           if ((proListing.getTradeMetasList() != null) && (proListing.getTradeMetasList().size() > 0))
/*      */           {
/*  391 */             for (ProjectMetas meta : proListing.getTradeMetasList()) {
/*  392 */               metaMap.put(meta.getMetaKey(), meta.getMetaValue());
/*      */ 
/*  394 */               ProjectMetas oldMeta = ProjectListingServiceImpl.this.projectMetasDAO.getProjectMetasByProIDAndKey(meta.getProjectId(), meta.getMetaKey());
/*      */ 
/*  397 */               if (oldMeta != null) {
/*  398 */                 meta.setId(oldMeta.getId());
/*  399 */                 ProjectListingServiceImpl.this.projectMetasDAO.updateByPrimaryKey(meta);
/*      */               } else {
/*  401 */                 ProjectListingServiceImpl.this.projectMetasDAO.insert(meta);
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */         catch (Exception e)
/*      */         {
/*      */           
/*  406 */           e.printStackTrace();
/*  407 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  408 */             ProjectListingServiceImpl.this.log.error("audit ProjectListing internal error:", e);
/*  409 */           status.setRollbackOnly();
/*  410 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.INTERNAL_ERROR.getValue()));
/*  411 */           result.setErrorInfo(EnumProjectListingResultErrors.INTERNAL_ERROR.getInfo());
/*      */ 
/*  413 */           return result;
/*      */         }
/*      */ 
/*  418 */         SystemMessageRequest sysMessageRequest = new SystemMessageRequest();
/*  419 */         SystemMessageResult sysMessageResult = new SystemMessageResult();
/*  420 */         List receiveList = new ArrayList();
/*  421 */         receiveList.add(projectListing.getUserAccount());
/*  422 */         sysMessageRequest.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/*  423 */         sysMessageRequest.setOperator(EnumOperatorType.SYSTEM.getValue());
/*  424 */         sysMessageRequest.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/*  425 */         sysMessageRequest.setUserAccountList(receiveList);
/*  426 */         StringBuffer sb = new StringBuffer();
/*  427 */         sb.append("尊敬的用户您好，您提交的<a style='color: blue;' href='http://" + ProjectListingServiceImpl.this.fengshanDomain + "/project/detail.htm?id=" + projectListing.getId() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>项目");
/*      */ 
/*  433 */         if (!EnumAuditRes.YES.getValue().equals(newAuditLog.getAuditRes())) {
/*  434 */           if ((projectListing.getDeposit() == null) || (projectListing.getQuantity() == null))
/*      */           {
/*  436 */             if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  437 */               ProjectListingServiceImpl.this.log.error("挂牌保证金 为空");
/*  438 */             result.setErrorNOInfo(Integer.valueOf(EnumProjectListingResultErrors.PRO_CANCEL_FUND_ERROR.getValue()), EnumProjectListingResultErrors.PRO_CANCEL_FUND_ERROR.getInfo());
/*      */ 
/*  441 */             status.setRollbackOnly();
/*  442 */             return result;
/*      */           }
/*  444 */           Long projectJyDeposit = Long.valueOf(projectListing.getDeposit().longValue() * projectListing.getQuantity().longValue());
/*      */ 
/*  448 */           TransRequest transRequest = new TransRequest();
/*  449 */           UserAccount userAccount = ProjectListingServiceImpl.this.userAccountDAO.selectByUserAccount(projectListing.getUserAccount());
/*      */ 
/*  451 */           transRequest.setFundAccount(userAccount.getFundAccount());
/*  452 */           transRequest.setOrderProperty(projectListing.getTradingType());
/*  453 */           transRequest.setAmount(projectJyDeposit);
/*  454 */           transRequest.setBizNo("" + projectListing.getId());
/*  455 */           transRequest.setOperator(newAuditLog.getOperator());
/*  456 */           transRequest.setMemo("审核不通过，退还挂牌保证金额");
/*  457 */           if (projectJyDeposit.longValue() > 0L)
/*      */           {
/*  459 */             sysMessageRequest.setTitle("【" + projectListing.getTitle() + "】项目审核不通过");
/*  460 */             sysMessageRequest.setContent(sb.append("没有被审核通过，审核失败的原因是：" + newAuditLog.getAuditMemo()).toString());
/*      */ 
/*  462 */             sysMessageResult = ProjectListingServiceImpl.this.systemMessageService.sendSystemMessage(sysMessageRequest);
/*  463 */             if (sysMessageResult.error()) {
/*  464 */               status.setRollbackOnly();
/*  465 */               result.setErrorNO(sysMessageResult.getErrorNO());
/*  466 */               result.setErrorInfo(sysMessageResult.getErrorInfo());
/*  467 */               return result;
/*      */             }
/*      */ 
/*  470 */             FundOperateResult fundOperateResult = ProjectListingServiceImpl.this.remoteFundService.cancelFundByTrade(transRequest);
/*      */ 
/*  472 */             if (fundOperateResult.isError()) {
/*  473 */               if (ProjectListingServiceImpl.this.log.isErrorEnabled()) {
/*  474 */                 ProjectListingServiceImpl.this.log.error("调用资金接口 退还挂牌保证金 出错。资金接口返回错误信息：" + fundOperateResult.getErrorInfo());
/*      */               }
/*  476 */               result.setErrorNOInfo(Integer.valueOf(EnumProjectListingResultErrors.PRO_CANCEL_FUND_ERROR.getValue()), fundOperateResult.getErrorInfo());
/*      */ 
/*  482 */               status.setRollbackOnly();
/*  483 */               return result;
/*      */             }
/*      */           }
/*      */         } else {
/*  487 */           sysMessageRequest.setTitle("【" + projectListing.getTitle() + "】项目审核通过");
/*  488 */           sysMessageRequest.setContent(sb.append("已经审核通过，请关注项目的后续动态").toString());
/*  489 */           sysMessageResult = ProjectListingServiceImpl.this.systemMessageService.sendSystemMessage(sysMessageRequest);
/*  490 */           if (sysMessageResult.error()) {
/*  491 */             status.setRollbackOnly();
/*  492 */             result.setErrorNO(sysMessageResult.getErrorNO());
/*  493 */             result.setErrorInfo(sysMessageResult.getErrorInfo());
/*  494 */             return result;
/*      */           }
/*      */         }
/*      */ 
/*  498 */         if ((EnumAuditRes.YES.getValue().equals(newAuditLog.getAuditRes())) && (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */         {
/*  501 */           ProjectMetas oldMeta = ProjectListingServiceImpl.this.projectMetasDAO.getProjectMetasByProIDAndKey(projectListing.getId(), EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey());
/*      */ 
/*  504 */           String reviewerAccountStrs = oldMeta.getMetaValue();
/*  505 */           if ((oldMeta != null) && (StringUtil.isNotEmpty(reviewerAccountStrs))) {
/*  506 */             String[] reviewerAccountArry = reviewerAccountStrs.split(",");
/*  507 */             List userAccountList = new ArrayList();
/*  508 */             if ((reviewerAccountArry != null) && (reviewerAccountArry.length > 0)) {
/*  509 */               for (String str : reviewerAccountArry)
/*  510 */                 userAccountList.add(str);
/*      */             }
/*  512 */             Long systemMessageTextId = ProjectListingServiceImpl.this.createJudgeMessageText(projectListing);
/*      */ 
/*  514 */             ProjectListingServiceImpl.this.sendSystemMessageText(userAccountList, systemMessageTextId, EnumOperatorType.SYSTEM.getValue());
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  519 */         return result;
/*      */       }
/*      */     });
/*  524 */     return auditResult;
/*      */   }
/*      */ 
/*      */   public AnnouncementServiceResult suspension(Announcement proAnnouncement)
/*      */   {
/*  536 */     if ((null == proAnnouncement) || (null == proAnnouncement.getProjectId())) {
/*  537 */       AnnouncementServiceResult result = new AnnouncementServiceResult();
/*  538 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PARAMETER_ERROR.getValue()));
/*  539 */       result.setErrorInfo(EnumProjectListingResultErrors.PARAMETER_ERROR.getInfo());
/*  540 */       if (this.log.isErrorEnabled())
/*  541 */         this.log.error(new StringBuilder().append("resumption projectListing fail, ").append(result.getErrorInfo()).toString());
/*  542 */       return result;
/*      */     }
/*      */ 
/*  545 */     proAnnouncement.setStatus(EnumAnnouncementStatus.NORMAL.getValue());
/*  546 */     final Announcement announcement = proAnnouncement;
/*  547 */     final Long proId = announcement.getProjectId();
/*      */ 
/*  549 */     AnnouncementServiceResult suspensionResult = (AnnouncementServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*      */     {
/*      */       public AnnouncementServiceResult doInTransaction(TransactionStatus status) {
/*  552 */         AnnouncementServiceResult result = new AnnouncementServiceResult();
/*      */ 
/*  555 */         if (proId == null) {
/*  556 */           result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_PRO_NULL.getValue()));
/*  557 */           result.setErrorInfo(EnumAnnouncementResultErrors.ANN_PRO_NULL.getInfo());
/*  558 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  559 */             ProjectListingServiceImpl.this.log.error("suspension projectListing fail, " + result.getErrorInfo());
/*  560 */           return result;
/*      */         }
/*  562 */         ProjectListing projectListing = ProjectListingServiceImpl.this.projectListingDAO.getProSimpInfo(proId);
/*  563 */         if ((projectListing == null) || (!projectListing.isTrade())) {
/*  564 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getValue()));
/*      */ 
/*  566 */           result.setErrorInfo(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getInfo());
/*      */ 
/*  568 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  569 */             ProjectListingServiceImpl.this.log.error("suspension projectListing fail, " + result.getErrorInfo());
/*  570 */           return result;
/*      */         }
/*      */ 
/*      */         try
/*      */         {
/*  578 */           ProjectRequest projectRequest = new ProjectRequest();
/*  579 */           projectRequest.setProjectCode(projectListing.getCode());
/*  580 */           projectRequest.setTradingType(projectListing.getTradingType());
/*  581 */           projectRequest.setOperator(announcement.getCreator());
/*  582 */           projectRequest.setOperatorType(announcement.getCreatorType());
/*      */ 
/*  586 */           Long announcementId = ProjectListingServiceImpl.this.announcementService.insertNormal(announcement);
/*  587 */           AnnouncementDTO announcementDTO = new AnnouncementDTO();
/*  588 */           announcementDTO.setId(announcementId);
/*  589 */           result.setAnnouncementDTO(announcementDTO);
/*      */ 
/*  592 */           if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */           {
/*  596 */             ProjectListingServiceImpl.this.clearAuctionData(projectListing.getCode(), true, announcement.getCreator());
/*      */           }
/*      */ 
/*  600 */           projectListing.setStatus(EnumProjectStatus.SUSPENSION.getValue());
/*  601 */           projectListing.setOldStatus("'" + EnumProjectStatus.TRADE.getValue() + "'");
/*  602 */           projectListing.setOperator(announcement.getCreator());
/*      */ 
/*  604 */           ProjectListingServiceImpl.this.projectListingDAO.updateStatusByIdWithOldStatus(projectListing);
/*      */         }
/*      */         catch (Exception e) {
/*  607 */           e.printStackTrace();
/*  608 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  609 */             ProjectListingServiceImpl.this.log.error("suspension internal error:", e);
/*  610 */           status.setRollbackOnly();
/*  611 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.INTERNAL_ERROR.getValue()));
/*  612 */           result.setErrorInfo(EnumProjectListingResultErrors.INTERNAL_ERROR.getInfo());
/*      */ 
/*  614 */           return result;
/*      */         }
/*  616 */         return result;
/*      */       }
/*      */     });
/*  624 */     if (suspensionResult.correct())
/*      */     {
/*  626 */       Long systemMessageTextId = createSystemMessageText(announcement, proAnnouncement.getProjectId(), "suspension");
/*      */ 
/*  629 */       List userAccountList = getNeedMessageUserList(proId);
/*      */ 
/*  632 */       sendSystemMessageText(userAccountList, systemMessageTextId, announcement.getCreator());
/*      */ 
/*  635 */       ProjectListing projectListing = this.projectListingDAO.getProSimpInfo(proId);
/*  636 */       AuctionMessageServiceRequest request = new AuctionMessageServiceRequest();
/*  637 */       request.setMessage("项目已停牌，详情请关注公告");
/*      */ 
/*  639 */       request.setMessageCode(EnumAuctionMessageCode.Close.getValue());
/*  640 */       request.setProjectCode(projectListing.getCode());
/*  641 */       this.remoteAuctionPushletService.sendAuctionMessage(request);
/*      */     }
/*      */ 
/*  644 */     return suspensionResult;
/*      */   }
/*      */ 
/*      */   private void clearAuctionData(String projectCode, boolean isSuspension, String operator)
/*      */     throws Exception
/*      */   {
/*  654 */     if (this.log.isInfoEnabled())
/*  655 */       this.log.info("Clear Active-Auction Data");
/*  656 */     if (projectCode == null) {
/*  657 */       throw new Exception("projectCode is null");
/*      */     }
/*      */ 
/*  660 */     if (!isSuspension) {
/*  661 */       this.tradeWishOrderDAO.cancelCreateTradeWishOrder(projectCode);
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  669 */       if (isSuspension) {
/*  670 */         this.auctionFreeBidDAO.insertHisWithOutInitData(projectCode);
/*  671 */         this.auctionFreeBidDAO.deleteWithoutInitData(projectCode);
/*      */       } else {
/*  673 */         this.auctionFreeBidDAO.insertHisFromFreeBidByProjectCode(projectCode);
/*  674 */         this.auctionFreeBidDAO.deleteAllByProjectCode(projectCode);
/*      */       }
/*      */     } catch (Exception e) {
/*  677 */       e.printStackTrace();
/*  678 */       throw new Exception("insert auctionBidRecordHis or delete auctionFreeBid error");
/*      */     }
/*      */ 
/*  681 */     AuctionHall auctionHall = this.auctionHallDAO.selectByProjectCode(projectCode);
/*  682 */     AuctionLatestBid auctionLatestBid = this.auctionLatestBidDAO.selectByProjectCode(projectCode);
/*  683 */     if ((auctionHall == null) || (auctionLatestBid == null)) {
/*  684 */       if (this.log.isInfoEnabled())
/*  685 */         this.log.info("No Active-Auction Has Find");
/*  686 */       return;
/*      */     }
/*      */ 
/*  690 */     int delHallResult = 0;
/*      */     try {
/*  692 */       delHallResult = this.auctionHallDAO.deleteByProjectCode(projectCode);
/*      */     } catch (Exception e) {
/*  694 */       e.printStackTrace();
/*  695 */       throw new Exception("delete auctionHall error");
/*      */     }
/*  697 */     if (delHallResult < 1) {
/*  698 */       throw new Exception("delete auctionHall error");
/*      */     }
/*      */     try
/*      */     {
/*  702 */       this.auctionLatestBidDAO.deleteByProjectCode(projectCode);
/*      */     } catch (Exception e) {
/*  704 */       e.printStackTrace();
/*  705 */       throw new Exception("delete auctionLatestBid error");
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  710 */       this.auctionBidderDAO.deleteByProjectCode(projectCode);
/*      */     } catch (Exception e) {
/*  712 */       e.printStackTrace();
/*  713 */       throw new Exception("delete auctionBidder error");
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  718 */       this.auctionBidRecordHisDAO.insertHisFromBidRecordByProjectCode(projectCode);
/*      */     } catch (Exception e) {
/*  720 */       e.printStackTrace();
/*  721 */       throw new Exception("insert auctionBidRecordHis error");
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  726 */       this.auctionBidRecordDAO.deleteByProjectCode(projectCode);
/*      */     } catch (Exception e) {
/*  728 */       e.printStackTrace();
/*  729 */       throw new Exception("delete auctionBidRecord error");
/*      */     }
/*      */ 
/*  733 */     if (!isSuspension) {
/*  734 */       AuctionResult auctionResult = new AuctionResult();
/*  735 */       auctionResult.setProjectCode(projectCode);
/*  736 */       auctionResult.setTranResult(EnumAuctionResultTranResult.RESULT_CANCEL_FLOWPAT.getValue());
/*      */ 
/*  739 */       auctionResult.setAuctioneerAccount(auctionHall.getAuctioneerAccount());
/*  740 */       auctionResult.setValuationUnit(auctionHall.getValuationUnit());
/*      */ 
/*  743 */       auctionResult.setEndTime(new Date());
/*  744 */       if (operator == null)
/*      */       {
/*  746 */         auctionResult.setRemark("系统自动 撤牌流拍");
/*  747 */         auctionResult.setOperator(EnumOperatorType.SYSTEM.getValue());
/*      */       }
/*      */       else {
/*  750 */         auctionResult.setRemark("后台管理员操作 撤牌流拍");
/*  751 */         auctionResult.setOperator(operator);
/*      */       }
/*      */       try {
/*  754 */         this.auctionResultDAO.insert(auctionResult);
/*      */       } catch (Exception e) {
/*  756 */         e.printStackTrace();
/*  757 */         throw new Exception("insert auctionResult error");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  762 */     AuctionLog auctionLog = new AuctionLog();
/*  763 */     auctionLog.setProjectCode(projectCode);
/*  764 */     auctionLog.setBeforeStatus(auctionLatestBid.getLatestStatus());
/*  765 */     auctionLog.setNewStatus(EnumAuctionLatestStatus.Z.getValue());
/*      */ 
/*  768 */     ObjectMapper mapper = new ObjectMapper();
/*      */     try {
/*  770 */       auctionLog.setDataJson(mapper.writeValueAsString(auctionHall));
/*      */     } catch (Exception e) {
/*  772 */       e.printStackTrace();
/*  773 */       if (this.log.isErrorEnabled()) {
/*  774 */         this.log.error("convert auctionHall object to json string error");
/*      */       }
/*      */     }
/*  777 */     auctionLog.setRemark(new StringBuilder().append(operator == null ? "自动" : "管理员操作").append(isSuspension ? "停牌" : "撤牌").toString());
/*  778 */     auctionLog.setOperator(operator);
/*  779 */     auctionLog.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/*      */     try {
/*  781 */       this.auctionLogDAO.insert(auctionLog);
/*      */     } catch (Exception e) {
/*  783 */       e.printStackTrace();
/*  784 */       throw new Exception("insert auctionLog error");
/*      */     }
/*      */   }
/*      */ 
/*      */   public AnnouncementServiceResult resumption(Announcement proAnnouncement)
/*      */   {
/*  798 */     if ((null == proAnnouncement) || (null == proAnnouncement.getProjectId())) {
/*  799 */       AnnouncementServiceResult result = new AnnouncementServiceResult();
/*  800 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PARAMETER_ERROR.getValue()));
/*  801 */       result.setErrorInfo(EnumProjectListingResultErrors.PARAMETER_ERROR.getInfo());
/*  802 */       if (this.log.isErrorEnabled())
/*  803 */         this.log.error(new StringBuilder().append("resumption projectListing fail, ").append(result.getErrorInfo()).toString());
/*  804 */       return result;
/*      */     }
/*      */ 
/*  807 */     proAnnouncement.setStatus(EnumAnnouncementStatus.NORMAL.getValue());
/*  808 */     final Announcement announcement = proAnnouncement;
/*  809 */     final Long proId = announcement.getProjectId();
/*      */ 
/*  811 */     AnnouncementServiceResult resumptionResult = (AnnouncementServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*      */     {
/*      */       public AnnouncementServiceResult doInTransaction(TransactionStatus status) {
/*  814 */         AnnouncementServiceResult result = new AnnouncementServiceResult();
/*      */ 
/*  817 */         if (proId == null) {
/*  818 */           result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_PRO_NULL.getValue()));
/*  819 */           result.setErrorInfo(EnumAnnouncementResultErrors.ANN_PRO_NULL.getInfo());
/*  820 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  821 */             ProjectListingServiceImpl.this.log.error("suspension projectListing fail, " + result.getErrorInfo());
/*  822 */           return result;
/*      */         }
/*  824 */         ProjectListing projectListing = ProjectListingServiceImpl.this.projectListingDAO.getProSimpInfo(proId);
/*  825 */         if ((projectListing == null) || (!projectListing.isSuspension())) {
/*  826 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getValue()));
/*      */ 
/*  828 */           result.setErrorInfo(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getInfo());
/*      */ 
/*  830 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  831 */             ProjectListingServiceImpl.this.log.error("resumption projectListing fail, " + result.getErrorInfo());
/*  832 */           return result;
/*      */         }
/*      */ 
/*      */         try
/*      */         {
/*  841 */           Long announcementId = ProjectListingServiceImpl.this.announcementService.insertNormal(announcement);
/*  842 */           AnnouncementDTO announcementDTO = new AnnouncementDTO();
/*  843 */           announcementDTO.setId(announcementId);
/*  844 */           result.setAnnouncementDTO(announcementDTO);
/*      */ 
/*  847 */           projectListing.setStatus(EnumProjectStatus.TRADE.getValue());
/*  848 */           projectListing.setOldStatus("'" + EnumProjectStatus.SUSPENSION.getValue() + "'");
/*      */ 
/*  850 */           projectListing.setOperator(announcement.getCreator());
/*      */ 
/*  852 */           ProjectListingServiceImpl.this.projectListingDAO.updateStatusByIdWithOldStatus(projectListing);
/*      */         }
/*      */         catch (Exception e) {
/*  855 */           e.printStackTrace();
/*  856 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  857 */             ProjectListingServiceImpl.this.log.error("resumption internal error:", e);
/*  858 */           status.setRollbackOnly();
/*  859 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.INTERNAL_ERROR.getValue()));
/*  860 */           result.setErrorInfo(EnumProjectListingResultErrors.INTERNAL_ERROR.getInfo());
/*      */ 
/*  862 */           return result;
/*      */         }
/*  864 */         return result;
/*      */       }
/*      */     });
/*  871 */     if (resumptionResult.correct())
/*      */     {
/*  873 */       Long systemMessageTextId = createSystemMessageText(announcement, proAnnouncement.getProjectId(), "resumption");
/*      */ 
/*  876 */       List userAccountList = getNeedMessageUserList(proId);
/*      */ 
/*  879 */       sendSystemMessageText(userAccountList, systemMessageTextId, announcement.getCreator());
/*      */     }
/*  881 */     return resumptionResult;
/*      */   }
/*      */ 
/*      */   public AnnouncementServiceResult withdrawal(Announcement proAnnouncement, final boolean autoWithdrawal)
/*      */   {
/*  894 */     if ((null == proAnnouncement) || (null == proAnnouncement.getProjectId())) {
/*  895 */       AnnouncementServiceResult result = new AnnouncementServiceResult();
/*  896 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PARAMETER_ERROR.getValue()));
/*  897 */       result.setErrorInfo(EnumProjectListingResultErrors.PARAMETER_ERROR.getInfo());
/*  898 */       if (this.log.isErrorEnabled())
/*  899 */         this.log.error(new StringBuilder().append("withdrawal projectListing fail, ").append(result.getErrorInfo()).toString());
/*  900 */       return result;
/*      */     }
/*      */ 
/*  903 */     proAnnouncement.setStatus(EnumAnnouncementStatus.NORMAL.getValue());
/*  904 */     final Announcement announcement = proAnnouncement;
/*  905 */     final Long proId = announcement.getProjectId();
/*      */ 
/*  907 */     AnnouncementServiceResult withdrawalResult = (AnnouncementServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*      */     {
/*      */       public AnnouncementServiceResult doInTransaction(TransactionStatus status) {
/*  910 */         AnnouncementServiceResult result = new AnnouncementServiceResult();
/*      */ 
/*  913 */         if (proId == null) {
/*  914 */           result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_PRO_NULL.getValue()));
/*  915 */           result.setErrorInfo(EnumAnnouncementResultErrors.ANN_PRO_NULL.getInfo());
/*  916 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  917 */             ProjectListingServiceImpl.this.log.error("suspension projectListing fail, " + result.getErrorInfo());
/*  918 */           return result;
/*      */         }
/*  920 */         ProjectListing projectListing = ProjectListingServiceImpl.this.projectListingDAO.selectByPrimaryKey(proId);
/*  921 */         if ((!projectListing.isTrade()) && (!projectListing.isSuspension())) {
/*  922 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getValue()));
/*      */ 
/*  924 */           result.setErrorInfo(EnumProjectListingResultErrors.PRO_STATUS_ERROR.getInfo());
/*      */ 
/*  926 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/*  927 */             ProjectListingServiceImpl.this.log.error("resumption projectListing fail, " + result.getErrorInfo());
/*  928 */           return result;
/*      */         }
/*      */ 
/*      */         try
/*      */         {
/*  935 */           ProjectRequest projectRequest = new ProjectRequest();
/*  936 */           projectRequest.setProjectCode(projectListing.getCode());
/*  937 */           projectRequest.setTradingType(projectListing.getTradingType());
/*  938 */           projectRequest.setOperator(announcement.getCreator());
/*  939 */           projectRequest.setOperatorType(announcement.getCreatorType());
/*      */ 
/*  943 */           Long announcementId = ProjectListingServiceImpl.this.announcementService.insertNormal(announcement);
/*  944 */           AnnouncementDTO announcementDTO = new AnnouncementDTO();
/*  945 */           announcementDTO.setId(announcementId);
/*  946 */           result.setAnnouncementDTO(announcementDTO);
/*      */ 
/*  949 */           if (!autoWithdrawal) {
/*  950 */             int integral = 0;
/*      */ 
/*  955 */             ProjectListingServiceImpl.this.userLevelService.updateUserLevel(projectListing.getUserAccount(), integral);
/*      */ 
/*  957 */             ProjectListingServiceImpl.this.userLevelService.insertUserIntegralLog(projectListing.getUserAccount(), null, projectListing.getCode(), EnumSystemDictKey.PROJECT_CANCEL_INTEGRAL.getValue(), Integer.valueOf(integral), announcement.getCreator());
/*      */           }
/*      */ 
/*  964 */           projectListing.setStatus(EnumProjectStatus.WITHDRAWAL.getValue());
/*  965 */           projectListing.setOldStatus("'" + EnumProjectStatus.TRADE.getValue() + "','" + EnumProjectStatus.SUSPENSION.getValue() + "'");
/*      */ 
/*  968 */           projectListing.setOperator(announcement.getCreator());
/*      */ 
/*  970 */           ProjectListingServiceImpl.this.projectListingDAO.updateStatusByIdWithOldStatus(projectListing);
/*      */ 
/*  979 */           List tradeWishOrderList = ProjectListingServiceImpl.this.tradeWishOrderDAO.selectListInTradeByProjectCode(projectListing.getCode());
/*      */ 
/*  981 */           List transRequestList = ProjectListingServiceImpl.this.getCancelFundInWithdrawalList(projectListing, tradeWishOrderList, announcement.getCreator());
/*      */ 
/*  983 */           FundOperateResult fundOperateResult = ProjectListingServiceImpl.this.remoteFundService.cancelFundBatchByTrade(transRequestList);
/*      */ 
/*  985 */           if (fundOperateResult.isError()) {
/*  986 */             if (ProjectListingServiceImpl.this.log.isErrorEnabled()) {
/*  987 */               ProjectListingServiceImpl.this.log.error("调用资金接口 退还挂牌保证金 出错。资金接口返回错误信息：" + fundOperateResult.getErrorInfo());
/*      */             }
/*  989 */             result.setErrorNOInfo(Integer.valueOf(EnumProjectListingResultErrors.PRO_CANCEL_FUND_ERROR.getValue()), fundOperateResult.getErrorInfo());
/*      */ 
/*  994 */             status.setRollbackOnly();
/*  995 */             return result;
/*      */           }
/*      */ 
/* 1004 */           if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */           {
/* 1008 */             ProjectListingServiceImpl.this.clearAuctionData(projectListing.getCode(), false, autoWithdrawal ? null : announcement.getCreator());
/*      */           }
/*      */         }
/*      */         catch (Exception e) {
/* 1012 */           e.printStackTrace();
/* 1013 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/* 1014 */             ProjectListingServiceImpl.this.log.error("withdrawal internal error:", e);
/* 1015 */           status.setRollbackOnly();
/* 1016 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.INTERNAL_ERROR.getValue()));
/* 1017 */           result.setErrorInfo(EnumProjectListingResultErrors.INTERNAL_ERROR.getInfo());
/*      */ 
/* 1019 */           return result;
/*      */         }
/* 1021 */         return result;
/*      */       }
/*      */     });
/* 1027 */     if (withdrawalResult.correct())
/*      */     {
/* 1029 */       Long systemMessageTextId = createSystemMessageText(announcement, proAnnouncement.getProjectId(), "withdrawal");
/*      */ 
/* 1032 */       List userAccountList = getNeedMessageUserList(proId);
/*      */ 
/* 1035 */       sendSystemMessageText(userAccountList, systemMessageTextId, announcement.getCreator());
/*      */ 
/* 1038 */       ProjectListing projectListing = this.projectListingDAO.getProSimpInfo(proId);
/* 1039 */       AuctionMessageServiceRequest request = new AuctionMessageServiceRequest();
/* 1040 */       request.setMessage("项目已撤牌，详情请关注公告");
/* 1041 */       request.setProjectCode(projectListing.getCode());
/* 1042 */       this.remoteAuctionPushletService.sendAuctionMessage(request);
/*      */     }
/*      */ 
/* 1045 */     return withdrawalResult;
/*      */   }
/*      */ 
/*      */   private ServiceResult doWithdrawal(Long projectListingId, String operatorAccount)
/*      */   {
/* 1056 */     final Long proId = projectListingId;
/* 1057 */     final String operator = operatorAccount;
/*      */ 
/* 1059 */     ServiceResult withdrawalResult = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*      */     {
/*      */       public ServiceResult doInTransaction(TransactionStatus status) {
/* 1062 */         ServiceResult result = new ServiceResult();
/*      */         try
/*      */         {
/* 1065 */           ProjectListing projectListing = ProjectListingServiceImpl.this.projectListingDAO.getProSimpInfo(proId);
/*      */ 
/* 1067 */           projectListing.setStatus(EnumProjectStatus.WITHDRAWAL.getValue());
/* 1068 */           projectListing.setOldStatus("'" + EnumProjectStatus.TRADE.getValue() + "'");
/* 1069 */           projectListing.setOperator(operator);
/*      */ 
/* 1071 */           ProjectListingServiceImpl.this.projectListingDAO.updateStatusByIdWithOldStatus(projectListing);
/*      */         } catch (Exception e) {
/* 1073 */           e.printStackTrace();
/* 1074 */           if (ProjectListingServiceImpl.this.log.isErrorEnabled())
/* 1075 */             ProjectListingServiceImpl.this.log.error("withdrawal internal error:", e);
/* 1076 */           status.setRollbackOnly();
/* 1077 */           result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.INTERNAL_ERROR.getValue()));
/* 1078 */           result.setErrorInfo(EnumProjectListingResultErrors.INTERNAL_ERROR.getInfo());
/*      */ 
/* 1080 */           return result;
/*      */         }
/* 1082 */         return result;
/*      */       }
/*      */     });
/* 1085 */     return withdrawalResult;
/*      */   }
/*      */ 
/*      */   private List<TransRequest> getCancelFundInWithdrawalList(ProjectListing projectListing, List<TradeWishOrder> tradeWishOrderList, String operator)
/*      */     throws Exception
/*      */   {
/* 1093 */     if ((projectListing == null) || (operator == null)) {
/* 1094 */       throw new Exception("要撤牌的项目丢了！");
/*      */     }
/* 1096 */     List transRequestList = new ArrayList();
/*      */ 
/* 1099 */     if ((projectListing.getDeposit() == null) || (projectListing.getQuantity() == null)) {
/* 1100 */       throw new Exception("获得挂牌方交易保证金额 错误！");
/*      */     }
/* 1102 */     Long projectJyDeposit = Long.valueOf(projectListing.getDeposit().longValue() * projectListing.getQuantity().longValue());
/* 1103 */     TransRequest transRequest = new TransRequest();
/* 1104 */     UserAccount userAccount = this.userAccountDAO.selectByUserAccount(projectListing.getUserAccount());
/*      */ 
/* 1106 */     transRequest.setFundAccount(userAccount.getFundAccount());
/* 1107 */     transRequest.setOrderProperty(projectListing.getTradingType());
/* 1108 */     transRequest.setAmount(projectJyDeposit);
/* 1109 */     transRequest.setBizNo(new StringBuilder().append("").append(projectListing.getId()).toString());
/* 1110 */     transRequest.setOperator(operator);
/* 1111 */     transRequest.setMemo("项目撤牌，退还挂牌方交易保证金额");
/* 1112 */     if (projectJyDeposit.longValue() > 0L) {
/* 1113 */       transRequestList.add(transRequest);
/*      */     }
/*      */ 
/* 1118 */     for (TradeWishOrder tradeWishOrder : tradeWishOrderList)
/*      */     {
/* 1120 */       if (tradeWishOrder.getDeposit() == null) {
/* 1121 */         throw new Exception("获得下单方交易保证金额 错误！");
/*      */       }
/*      */ 
/* 1124 */       Long wishJyDeposit = tradeWishOrder.getDeposit();
/* 1125 */       TransRequest wishTransRequest = new TransRequest();
/* 1126 */       UserAccount wishUserAccount = this.userAccountDAO.selectByUserAccount(tradeWishOrder.getUserAccount());
/*      */ 
/* 1128 */       wishTransRequest.setFundAccount(wishUserAccount.getFundAccount());
/* 1129 */       wishTransRequest.setOrderProperty(projectListing.getTradingType());
/* 1130 */       wishTransRequest.setAmount(wishJyDeposit);
/* 1131 */       wishTransRequest.setBizNo(new StringBuilder().append("").append(tradeWishOrder.getWishOrderNum()).toString());
/* 1132 */       wishTransRequest.setOperator(operator);
/* 1133 */       wishTransRequest.setMemo("项目撤牌，退还下单方交易保证金额");
/* 1134 */       if (wishJyDeposit.longValue() > 0L) {
/* 1135 */         transRequestList.add(wishTransRequest);
/*      */       }
/*      */     }
/* 1138 */     return transRequestList;
/*      */   }
/*      */ 
/*      */   private Long createSystemMessageText(Announcement announcement, Long id, String operatFlag)
/*      */   {
/* 1148 */     SystemMessageText systemMessageText = new SystemMessageText();
/*      */ 
/* 1150 */     String content = announcement.getTitle();
/* 1151 */     String infoUrl = new StringBuilder().append("<a href='http://").append(this.fengshanDomain).append("/home/announcement/annList.htm?projectId=").append(id).append("' target='_blank' >查看项目公告</a>").toString();
/*      */ 
/* 1154 */     systemMessageText.setTitle(content);
/* 1155 */     String message = getMessage(new StringBuilder().append("project.auto.message.").append(operatFlag).toString(), new String[0]);
/* 1156 */     systemMessageText.setContent(new StringBuilder().append(message).append("<br/>").append(infoUrl).toString());
/*      */ 
/* 1158 */     systemMessageText.setOperator(announcement.getCreator());
/* 1159 */     return this.systemMessageTextDAO.insert(systemMessageText);
/*      */   }
/*      */ 
/*      */   private Long createJudgeMessageText(ProjectListing project)
/*      */   {
/* 1168 */     Long id = project.getId();
/* 1169 */     String projectCode = project.getCode();
/* 1170 */     SystemMessageText systemMessageText = new SystemMessageText();
/* 1171 */     StringBuffer bf = new StringBuffer();
/* 1172 */     bf.append(new StringBuilder().append("你已成为<a style='color: blue;' href='http://").append(this.fengshanDomain).append("/home/detail.htm?id=").append(id).append("' target='_blank' >【").append(project.getTitle()).append("】</a>项目的评审员之一。").toString());
/*      */ 
/* 1175 */     bf.append("你有权根据有效竞价人的最后自由报价是否符合要求，保持或取消竞价人进入大厅参加竞价的资格。");
/*      */ 
/* 1177 */     bf.append("<br /> <strong > 评审时间：</strong> 拍卖大厅激活后，拍卖开始时间到达之前。目前系统在拍卖开始前10分钟自动激活。");
/*      */ 
/* 1179 */     bf.append("<br /><br />现在你可以去");
/* 1180 */     bf.append(new StringBuilder().append("<a  style='color: blue;'  href='http://").append(this.fengshanDomain).append("/auction/reviewer/waituserprolist.htm' target='_blank' >评审</a>").toString());
/*      */ 
/* 1182 */     bf.append("竞价人的自由报价或");
/* 1183 */     bf.append(new StringBuilder().append("<a   style='color: blue;'  href='http://").append(this.fengshanDomain).append("/auction/join.htm?projectCode=").append(projectCode).append("' target='_blank' >进入大厅</a>").toString());
/*      */ 
/* 1185 */     bf.append("观看。");
/* 1186 */     systemMessageText.setTitle(new StringBuilder().append("你已成为【").append(project.getTitle()).append("】项目的评审员").toString());
/* 1187 */     systemMessageText.setContent(bf.toString());
/* 1188 */     systemMessageText.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 1189 */     return this.systemMessageTextDAO.insert(systemMessageText);
/*      */   }
/*      */ 
/*      */   private void sendSystemMessageText(List<String> userAccountList, Long textId, String sendAccount)
/*      */   {
/* 1194 */     MessageForMore messageForMore = new MessageForMore();
/* 1195 */     messageForMore.setUserAccountList(userAccountList);
/* 1196 */     messageForMore.setMessageId(textId);
/* 1197 */     messageForMore.setSendAccount(sendAccount);
/* 1198 */     this.systemMessageDAO.batchInsertMessage(messageForMore);
/*      */   }
/*      */ 
/*      */   private List<String> getNeedMessageUserList(Long proId)
/*      */   {
/* 1203 */     List userAccountList = new ArrayList();
/* 1204 */     ProjectListing project = this.projectListingDAO.getProSimpInfo(proId);
/* 1205 */     Set userAccountSet = new HashSet();
/* 1206 */     userAccountSet.add(project.getUserAccount());
/* 1207 */     userAccountList.add(project.getUserAccount());
/* 1208 */     if (project.getCode() == null) {
/* 1209 */       return userAccountList;
/*      */     }
/* 1211 */     List<TradeWishOrder> tradeWishOrderList = this.tradeWishOrderDAO.selectListByProjectCode(project.getCode());
/*      */ 
/* 1213 */     for (TradeWishOrder tradeWishOrder : tradeWishOrderList) {
/* 1214 */       if (userAccountSet.add(tradeWishOrder.getUserAccount())) {
/* 1215 */         userAccountList.add(tradeWishOrder.getUserAccount());
/*      */       }
/*      */     }
/* 1218 */     return userAccountList;
/*      */   }
/*      */ 
/*      */   public String projectCodeCreator(ProjectListing projectListing)
/*      */   {
/* 1228 */     String projectCode = "";
/* 1229 */     String projectTypeStr = projectListing.getListingType().substring(0, 1);
/* 1230 */     String dateStr = CommonUtils.convertDateToString("yyyy", projectListing.getGmtCreate());
/*      */ 
/* 1232 */     Map data = new HashMap();
/* 1233 */     data.put("listingType", projectListing.getListingType());
/* 1234 */     data.put("gmtCreate", projectListing.getGmtCreate());
/* 1235 */     String maxCode = this.projectListingDAO.getMaxProjectCode(data);
/* 1236 */     if (null == maxCode) {
/* 1237 */       projectCode = new StringBuilder().append(projectTypeStr).append(dateStr).append("0000000").toString();
/*      */     } else {
/* 1239 */       String seqStr = maxCode.substring(maxCode.length() - 7, maxCode.length());
/* 1240 */       long seqNum = Long.valueOf(seqStr).longValue() + 1L;
/* 1241 */       String seq = new StringBuilder().append("0000000").append(Long.valueOf(seqNum).toString()).toString();
/* 1242 */       String tempSeq = seq.substring(seq.length() - 7, seq.length());
/* 1243 */       projectCode = new StringBuilder().append(projectTypeStr).append(dateStr).append(tempSeq).toString();
/*      */     }
/* 1245 */     return projectCode;
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult tradeClearProject(ProjectListing projectListing)
/*      */   {
/* 1269 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 1270 */     ProjectListing projObjOld = this.projectListingDAO.selectByProjectCode(projectListing.getCode());
/* 1271 */     Long remain = Long.valueOf(projObjOld.getQuantity().longValue() - projectListing.getQuantity().longValue());
/* 1272 */     projectListing.setId(null);
/* 1273 */     projectListing.setTitle(null);
/* 1274 */     projectListing.setQuantity(remain);
/* 1275 */     if (remain.longValue() > 0L) {
/* 1276 */       this.projectListingDAO.updateProjectListing(projectListing);
/* 1277 */       projObjOld.setQuantity(remain);
/* 1278 */       ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*      */       try {
/* 1280 */         BeanUtils.copyProperties(projectListingDTO, projObjOld);
/*      */       } catch (Exception e) {
/* 1282 */         this.log.error("wulin projetlisting对象转换 projectlistingDTO 出错", e);
/* 1283 */         result.setErrorInfo("wulin projetlisting对象转换 projectlistingDTO 出错");
/*      */       }
/* 1285 */       result.setProjectListingDTO(projectListingDTO);
/*      */     } else {
/* 1287 */       projObjOld.setQuantity(Long.valueOf(0L));
/* 1288 */       projObjOld.setStatus(EnumProjectStatus.WITHDRAWAL.getValue());
/* 1289 */       ProjectListing projForUpdate = new ProjectListing();
/* 1290 */       projForUpdate.setStatus(EnumProjectStatus.WITHDRAWAL.getValue());
/* 1291 */       projForUpdate.setQuantity(Long.valueOf(0L));
/* 1292 */       projForUpdate.setCode(projectListing.getCode());
/* 1293 */       projForUpdate.setOperator(projectListing.getUserAccount());
/* 1294 */       this.projectListingDAO.updateProjectListing(projForUpdate);
/* 1295 */       projForUpdate = null;
/* 1296 */       ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*      */       try {
/* 1298 */         BeanUtils.copyProperties(projectListingDTO, projObjOld);
/*      */       } catch (Exception e) {
/* 1300 */         this.log.error("wulin projetlisting对象转换 projectlistingDTO 出错", e);
/* 1301 */         result.setErrorInfo("wulin projetlisting对象转换 projectlistingDTO 出错");
/*      */       }
/*      */ 
/* 1304 */       doWithdrawal(projObjOld.getId(), projectListing.getUserAccount());
/* 1305 */       result.setProjectListingDTO(projectListingDTO);
/*      */     }
/*      */ 
/* 1308 */     return result;
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult getAllProjectListing()
/*      */   {
/* 1317 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 1318 */     List prolList = getAllProjectListingList();
/* 1319 */     List dtoList = new ArrayList();
/*      */     try {
/* 1321 */       dtoList = convertObjList2DTOList(prolList, dtoList);
/*      */     } catch (Exception e) {
/* 1323 */       this.log.error("将projectListing对象数组转换为ProjectListingDTO数组出错：converntObjList2DTOList(prolList, dtoList);", e);
/*      */ 
/* 1327 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.PROJECT_LISTING_2_DTO_ERROR.getValue()));
/* 1328 */       result.setErrorInfo(EnumProjectErrors.PROJECT_LISTING_2_DTO_ERROR.getInfo());
/*      */     }
/* 1330 */     result.setProjectListingDTOList(dtoList);
/* 1331 */     return result;
/*      */   }
/*      */ 
/*      */   public ProjectBaseTradeServiceResult getAllProjectBaseTrade()
/*      */   {
/* 1341 */     ProjectBaseTradeServiceResult result = new ProjectBaseTradeServiceResult();
/* 1342 */     List prolList = getAllProjectListingList();
/* 1343 */     List baseTradeDTOList = new ArrayList();
/* 1344 */     baseTradeDTOList = convertProjectListing2BaseTradeDTO(prolList);
/* 1345 */     result.setBaseTradeDTOList(baseTradeDTOList);
/* 1346 */     return result;
/*      */   }
/*      */ 
/*      */   private List<BaseTradeDTO> convertProjectListing2BaseTradeDTO(List<ProjectListing> prolList) {
/* 1350 */     List baseTradeDTOList = new ArrayList();
/* 1351 */     for (ProjectListing projectListing : prolList) {
/* 1352 */       BaseTradeDTO baseTradeDTO = new BaseTradeDTO();
/* 1353 */       baseTradeDTO = ConvertUtils.convertProjectListing2BaseTradeDTO(projectListing);
/* 1354 */       baseTradeDTOList.add(baseTradeDTO);
/* 1355 */       projectListing = null;
/* 1356 */       baseTradeDTO = null;
/*      */     }
/* 1358 */     return baseTradeDTOList;
/*      */   }
/*      */ 
/*      */   public List<ProjectListing> getAllProjectListingList()
/*      */   {
/* 1366 */     List prolList = this.projectListingDAO.selectProjectListingByObj(new ProjectListing());
/*      */ 
/* 1368 */     return prolList;
/*      */   }
/*      */ 
/*      */   private List<ProjectListingDTO> convertObjList2DTOList(List<ProjectListing> objList, List<ProjectListingDTO> dtoList)
/*      */     throws Exception
/*      */   {
/* 1382 */     for (ProjectListing projectListing : objList) {
/* 1383 */       ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 1384 */       projectListingDTO = ConvertUtils.convertProjectListing2ProjectListDTO(projectListing);
/* 1385 */       dtoList.add(projectListingDTO);
/* 1386 */       projectListingDTO = null;
/* 1387 */       projectListing = null;
/*      */     }
/* 1389 */     return dtoList;
/*      */   }
/*      */ 
/*      */   public ProjectListingServiceResult getProjectInfoByCode(String projectCode)
/*      */   {
/* 1399 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 1400 */     ProjectListing projectListing = this.projectListingDAO.selectByProjectCode(projectCode);
/* 1401 */     if (projectListing == null) {
/* 1402 */       result.setErrorNOInfo(Integer.valueOf(EnumProjectErrors.CODE_NOT_FIND_ERROR.getValue()), EnumProjectErrors.CODE_NOT_FIND_ERROR.getInfo());
/*      */ 
/* 1404 */       return result;
/* 1405 */     }if (!EnumProjectStatus.TRADE.getValue().equals(projectListing.getStatus())) {
/* 1406 */       result.setErrorNOInfo(Integer.valueOf(EnumProjectErrors.PROJECT_NOT_TRADE_ERROR.getValue()), EnumProjectErrors.PROJECT_NOT_TRADE_ERROR.getInfo());
/*      */ 
/* 1408 */       return result;
/*      */     }
/* 1410 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 1411 */     projectListingDTO = ConvertUtils.convertProjectListing2ProjectListDTO(projectListing);
/* 1412 */     result.setProjectListingDTO(projectListingDTO);
/* 1413 */     return result;
/*      */   }
/*      */ 
/*      */   public List<ProjectListingDTO> selectLatestProjectListing(int counts, String projectTypeCode) {
/* 1417 */     List plist = new ArrayList();
/* 1418 */     ProjectListingQuery<ProjectListing> query = new ProjectListingQuery();
/* 1419 */     query.setProjectTypeCode(projectTypeCode);
/* 1420 */     query.setPageSize(counts);
/* 1421 */     query.setStatus(EnumProjectStatus.TRADE.getValue());
/* 1422 */     query.setSysTimeFlag("Y");
/* 1423 */     this.projectListingDAO.paginate(query);
/* 1424 */     for (ProjectListing projectListing : query.getData()) {
/* 1425 */       ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 1426 */       projectListingDTO = ConvertUtils.convertProjectListing2ProjectListDTO(projectListing);
/* 1427 */       plist.add(projectListingDTO);
/* 1428 */       projectListing = null;
/*      */     }
/* 1430 */     return plist;
/*      */   }
/*      */ 
/*      */   protected String getMessage(String code, String[] args)
/*      */   {
/* 1440 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*      */   }
/*      */ 
/*      */   public List<AuctionMulitBidProject> queryAuctionMulitBidProjectUncheckedByProjectCode(AuctionMulitBidProjectQuery query)
/*      */   {
/* 1446 */     List projectStatus = new ArrayList();
/* 1447 */     projectStatus.add(EnumProjectStatus.TRADE);
/* 1448 */     query.setProjectStatus(projectStatus);
/* 1449 */     query.setReviewed(EnumActiveStatus.No);
/* 1450 */     query.setReviewerKey(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT);
/* 1451 */     query.setBidStartTimeKey(EnumMulitBidOrderProperty.BID_START_TIME);
/* 1452 */     query.setTradingType(EnumTradingType.MULIT_BID_ORDER);
/* 1453 */     return this.projectListingDAO.queryAuctionMulitBidProject(query);
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.project.ProjectListingServiceImpl
 * JD-Core Version:    0.6.0
 */