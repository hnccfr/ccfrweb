/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.user;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.baseset.UserCreditDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.baseset.UserLevelDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.operation.AnnouncementDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderCcDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAccuseDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.user.UserUpgradeAuditDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.AnnouncementQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectListingQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoAccuseQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderCcQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeWishOrderQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.UserAccountQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserCreditInfo;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserRole;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.common.MailService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.genshan.common.MobileMessageUtil;
/*     */ import com.hundsun.network.gates.genshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.luosi.biz.enums.EnumPasswordType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserRegisterRequset;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserResetPWDResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.ui.Model;
/*     */ 
/*     */ @Service("userAccountService")
/*     */ public class UserAccountServiceImpl extends BaseService
/*     */   implements UserAccountService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO userAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private UserLevelDAO userLevelDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditDAO userCreditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private MailService mailService;
/*     */ 
/*     */   @Autowired
/*     */   private UserUpgradeAuditDAO userUpgradeAuditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AnnouncementDAO announcementDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderCcDAO tradeOrderCcDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoDAO supplyDemandInfoDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoAccuseDAO supplyDemandInfoAccuseDAO;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   public void getUserAccountList(UserAccountQuery query)
/*     */   {
/* 107 */     this.userAccountDAO.selectUserAccountList(query);
/*     */   }
/*     */ 
/*     */   public UserAccount getUserByAccount(String account)
/*     */   {
/* 112 */     return this.userAccountDAO.selectUserByAccount(account);
/*     */   }
/*     */ 
/*     */   public UserResetPWDResult resetUserPwd(String account, String operator, String passwordType)
/*     */   {
/* 117 */     UserResetPWDResult result = new UserResetPWDResult();
/* 118 */     if (StringUtil.isEmpty(account)) {
/* 119 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 120 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 121 */       return result;
/*     */     }
/* 123 */     UserResetPasswordRequest request = new UserResetPasswordRequest();
/* 124 */     request.setAccount(account);
/* 125 */     request.setOperator(operator);
/* 126 */     request.setPasswordType(passwordType);
/* 127 */     result = this.remoteUserService.updatePassword(request);
/*     */ 
/* 129 */     if (result.correct()) {
/* 130 */       boolean active = false;
/* 131 */       SystemDictRequest dictRequest = new SystemDictRequest();
/* 132 */       dictRequest.setParaCode(EnumSystemDictKey.REGISTER_EMAIL_ACTIVE.getValue());
/* 133 */       SystemDictServiceResult systemDict = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/* 134 */       if (systemDict != null) {
/* 135 */         active = EnumActiveStatus.Yes.getValue().equals(systemDict.getSystemDictDTO().getParaValue());
/*     */       }
/* 137 */       if (active)
/*     */       {
/*     */         try {
/* 140 */           UserAccount userAccount = this.userAccountDAO.selectUserByAccount(account);
/* 141 */           List nums = new ArrayList();
/* 142 */           nums.add(userAccount.getMobile());
/* 143 */           String msg = "";
/* 144 */           if (EnumPasswordType.SYSTEM.getValue().equals(passwordType))
/* 145 */             msg = "尊敬的" + userAccount.getName() + "您好，您的登录密码被重置为：";
/*     */           else {
/* 147 */             msg = "尊敬的" + userAccount.getName() + "您好，您的资金账户密码被重置为：";
/*     */           }
/* 149 */           msg = msg + result.getNewPassword() + "。为确保您的账户安全，请及时进行修改（若系统密码被重置，请用重置后的密码登陆）【中部林业产权交易服务中心】";
/* 150 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*     */         } catch (Exception e) {
/* 152 */           this.log.error("send mobileMessage for reset password error cause by:" + e);
/*     */         }
/*     */         try {
/* 155 */           this.mailService.sendPassWordRestMail(account, passwordType, result.getNewPassword());
/*     */         } catch (Exception e) {
/* 157 */           this.log.error("send reset password error cause by:" + e);
/*     */         }
/*     */       }
/*     */     }
/* 161 */     return result;
/*     */   }
/*     */ 
/*     */   public UserLevel getUserLevelByUserAccount(String userAccount)
/*     */   {
/* 166 */     return this.userLevelDAO.selectUserLevelByUserAccount(userAccount);
/*     */   }
/*     */ 
/*     */   public int changeUserStatus(UserAccount userAccount)
/*     */   {
/* 171 */     return this.userAccountDAO.updateUserStatus(userAccount);
/*     */   }
/*     */ 
/*     */   public UserCreditInfo getUserCreditByUserAccount(String userAccount)
/*     */   {
/* 176 */     return this.userCreditDAO.selectByUserAccount(userAccount);
/*     */   }
/*     */ 
/*     */   public List<UserRole> getRoleList()
/*     */   {
/* 181 */     return this.userAccountDAO.selectRoleList();
/*     */   }
/*     */ 
/*     */   public UserServiceResult userAdd(UserAccount userAccount)
/*     */   {
/* 191 */     UserServiceResult result = new UserServiceResult();
/* 192 */     UserRegisterRequset request = ConvertUtils.convertUAccount2RegRequest(userAccount);
/*     */     try
/*     */     {
/* 195 */       result = this.remoteUserService.register(request);
/*     */     } catch (Exception e) {
/* 197 */       e.printStackTrace();
/* 198 */       this.log.error(e);
/* 199 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 200 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 202 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult userAuctioneer(UserAccount userAccount)
/*     */   {
/* 212 */     UserServiceResult result = new UserServiceResult();
/* 213 */     UserRegisterRequset request = ConvertUtils.convertUAccount2RegRequest2(userAccount);
/*     */     try
/*     */     {
/* 216 */       result = this.remoteUserService.specialRegister(request);
/*     */     } catch (Exception e) {
/* 218 */       e.printStackTrace();
/* 219 */       this.log.error(e);
/* 220 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 221 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 223 */     return result;
/*     */   }
/*     */ 
/*     */   public Long selectByParaMap(Map<String, Object> map)
/*     */   {
/* 229 */     return this.userAccountDAO.selectByParaMap(map);
/*     */   }
/*     */ 
/*     */   public UserServiceResult addReviewer(UserAccount userAccount)
/*     */   {
/* 234 */     UserServiceResult result = new UserServiceResult();
/* 235 */     UserRegisterRequset request = ConvertUtils.convertUAccount2RegRequest2(userAccount);
/*     */     try
/*     */     {
/* 238 */       result = this.remoteUserService.specialRegister(request);
/*     */     } catch (Exception e) {
/* 240 */       e.printStackTrace();
/* 241 */       this.log.error(e);
/* 242 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 243 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 245 */     return result;
/*     */   }
/*     */ 
/*     */   public void initIssueTodo(Model model)
/*     */   {
/* 255 */     model.addAttribute("buyType", EnumListingType.BUY.getValue());
/* 256 */     model.addAttribute("sellType", EnumListingType.SELL.getValue());
/*     */ 
/* 259 */     Integer auditNumber = this.userUpgradeAuditDAO.selectNumOfAudit();
/* 260 */     model.addAttribute("auditNumber", auditNumber);
/*     */ 
/* 263 */     ProjectListingQuery page = new ProjectListingQuery();
/* 264 */     page.setStatus(EnumProjectStatus.AUDIT.getValue());
/* 265 */     page.setListingType(EnumListingType.BUY.getValue());
/* 266 */     Integer buyProjectNumber = this.projectListingDAO.selectNumOfAuditProject(page);
/* 267 */     page.setListingType(EnumListingType.SELL.getValue());
/* 268 */     Integer sellProjectNumber = this.projectListingDAO.selectNumOfAuditProject(page);
/* 269 */     model.addAttribute("buyProjectNumber", buyProjectNumber);
/* 270 */     model.addAttribute("sellProjectNumber", sellProjectNumber);
/* 271 */     model.addAttribute("auditNode", EnumProjectStatus.AUDIT.getValue());
/*     */ 
/* 274 */     TradeWishOrderQuery twoQuery = new TradeWishOrderQuery();
/* 275 */     twoQuery.setStatus(EnumTradeWishOrderStatus.AUDIT.getValue());
/* 276 */     twoQuery.setTradeDictor(EnumListingType.BUY.getValue());
/* 277 */     Integer buyTwoNumber = this.tradeWishOrderDAO.getNumByQuery(twoQuery);
/* 278 */     model.addAttribute("buyTwoNumber", buyTwoNumber);
/* 279 */     twoQuery.setTradeDictor(EnumListingType.SELL.getValue());
/* 280 */     Integer sellTwoNumber = this.tradeWishOrderDAO.getNumByQuery(twoQuery);
/* 281 */     model.addAttribute("sellTwoNumber", sellTwoNumber);
/* 282 */     model.addAttribute("twoStatus", EnumTradeWishOrderStatus.AUDIT.getValue());
/*     */ 
/* 299 */     AnnouncementQuery annQuery = new AnnouncementQuery();
/* 300 */     annQuery.setStatus(EnumAnnouncementStatus.CREATE.getValue());
/* 301 */     Integer annNumber = this.announcementDAO.getNumByQuery(annQuery);
/* 302 */     model.addAttribute("annNumber", annNumber);
/* 303 */     model.addAttribute("annStatus", EnumAnnouncementStatus.CREATE.getValue());
/*     */ 
/* 306 */     TradeOrderCcQuery tocQuery = new TradeOrderCcQuery();
/* 307 */     tocQuery.setStatus(EnumTradeOrderCcStatus.SUBMIT.getValue());
/* 308 */     Integer tocNumber = this.tradeOrderCcDAO.getNumByQuery(tocQuery);
/* 309 */     model.addAttribute("tocNumber", tocNumber);
/* 310 */     model.addAttribute("tocStatus", EnumTradeOrderCcStatus.SUBMIT.getValue());
/*     */ 
/* 313 */     SupplyDemandInfoQuery supQuery = new SupplyDemandInfoQuery();
/* 314 */     supQuery.setStatus(EnumInfoStatus.AUDIT.getValue());
/* 315 */     Integer supNumber = this.supplyDemandInfoDAO.getNumByQuery(supQuery);
/* 316 */     model.addAttribute("supNumber", supNumber);
/* 317 */     model.addAttribute("supStatus", EnumInfoStatus.AUDIT.getValue());
/*     */ 
/* 320 */     SupplyDemandInfoAccuseQuery supAccQuery = new SupplyDemandInfoAccuseQuery();
/* 321 */     supAccQuery.setStatus("A");
/* 322 */     Integer supAccNumber = this.supplyDemandInfoAccuseDAO.getNumByQuery(supAccQuery);
/* 323 */     model.addAttribute("supAccNumber", supAccNumber);
/* 324 */     model.addAttribute("supAccStatus", "A");
/*     */   }
/*     */ 
/*     */   public UserAccount getUserByFundAccount(String fundAccount)
/*     */   {
/* 329 */     return this.userAccountDAO.getUserByFundAccount(fundAccount);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.user.UserAccountServiceImpl
 * JD-Core Version:    0.6.0
 */