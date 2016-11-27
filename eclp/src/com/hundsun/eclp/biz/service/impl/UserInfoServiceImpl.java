/*     */ package com.hundsun.eclp.biz.service.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.UserInfoDAO;
/*     */ import com.hundsun.eclp.biz.dao.UsersDAO;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.query.UserInfoQuery;
/*     */ import com.hundsun.eclp.biz.service.UserInfoService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*     */ import com.hundsun.eclp.enums.EnumUserInfoStatus;
/*     */ import com.hundsun.eclp.enums.EnumUserStatus;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("userInfoService")
/*     */ public class UserInfoServiceImpl
/*     */   implements UserInfoService
/*     */ {
/*  26 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private UserInfoDAO userInfoDAO;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogService workLogService;
/*     */ 
/*     */   @Autowired
/*     */   private UsersService usersService;
/*     */ 
/*     */   @Autowired
/*     */   private UsersDAO userDao;
/*     */ 
/*     */   @Autowired
/*     */   TransactionTemplate transactionTemplate;
/*     */ 
/*  41 */   public UserInfo selectUserInfoByUserId(Long userId) { this.log.info("UsersInfoServiceImpl.updateUser method");
/*     */     try {
/*  43 */       return this.userInfoDAO.selectByUserId(userId);
/*     */     } catch (Exception e) {
/*  45 */       this.log.error(e.getMessage());
/*     */     }
/*  47 */     return null; }
/*     */ 
/*     */   public UserInfoQuery selectUserInfoByPage(UserInfoQuery query)
/*     */   {
/*  51 */     this.log.info("UsersInfoServiceImpl.selectUserInfoByPage method");
/*     */     try {
/*  53 */       return this.userInfoDAO.serarchByPage(query);
/*     */     } catch (Exception e) {
/*  55 */       this.log.error(e.getMessage());
/*     */     }
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean addUInfo(UserInfo uinfo, UserAgent userAgent) {
/*  61 */     this.log.info("UsersInfoServiceImpl.addUInfo method");
/*  62 */     Long sort = Long.valueOf(this.userInfoDAO.getMaxSort().longValue() + 1L);
/*  63 */     uinfo.setSort(Short.valueOf(sort.shortValue()));
/*  64 */     boolean flag = this.userInfoDAO.insert(uinfo).longValue() > 0L;
/*     */ 
/*  67 */     this.workLogService.addWorkLog("新增人员信息", new StringBuilder().append("用户ID:").append(userAgent.getId()).append(",name:'").append(userAgent.getName()).append("新增人员[").append(uinfo.getRealName()).append("]成功").toString(), userAgent);
/*     */ 
/*  69 */     return flag;
/*     */   }
/*     */ 
/*     */   public UserInfo selectUserInfoById(Long id) {
/*  73 */     this.log.info("UsersInfoServiceImpl.selectUserInfoById method");
/*     */     try {
/*  75 */       return this.userInfoDAO.selectById(id);
/*     */     } catch (Exception e) {
/*  77 */       this.log.error(e.getMessage());
/*     */     }
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean uppUInfo(UserInfo uinfo, UserAgent userAgent) {
/*  83 */     this.log.info("UsersInfoServiceImpl.uppUInfo method");
/*     */     try {
/*  85 */       if (this.userInfoDAO.updateUserInfoById(uinfo) > 0)
/*     */       {
/*  88 */         this.workLogService.addWorkLog("更新人员信息", new StringBuilder().append("用户ID:").append(userAgent.getId()).append(",name:'").append(userAgent.getName()).append("人员[").append(uinfo.getRealName()).append("]删除成功").toString(), userAgent);
/*     */ 
/*  90 */         return true;
/*     */       }
/*     */ 
/*  93 */       this.workLogService.addWorkLog("更新人员信息", new StringBuilder().append("用户ID:").append(userAgent.getId()).append(",name:'").append(userAgent.getName()).append("人员[").append(uinfo.getRealName()).append("]删除失败").toString(), userAgent);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  97 */       this.log.error(e.getMessage());
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean updateUserWithInfo(UserInfo uinfo, UserAgent userAgent) {
/* 103 */     this.log.info("UsersInfoServiceImpl.updateUserWithInfo method");
/* 104 */     boolean flag = false;
/*     */     try {
/* 106 */       if (uinfo.getUserId() != null)
/*     */       {
/* 108 */         Users users = this.usersService.getUserByID(uinfo.getUserId().longValue());
/* 109 */         if (users != null)
/*     */         {
/* 114 */           users.setName(uinfo.getRealName());
/* 115 */           flag = (this.userInfoDAO.updateUserInfoById(uinfo) > 0) && (this.userDao.update(users) > 0);
/*     */         } else {
/* 117 */           flag = this.userInfoDAO.updateUserInfoById(uinfo) > 0;
/*     */         }
/*     */ 
/* 120 */         this.workLogService.addWorkLog("更新人员信息", new StringBuilder().append("用户ID:").append(userAgent.getId()).append(",name:'").append(userAgent.getName()).append("人员[").append(uinfo.getRealName()).append("]更新").append(flag == true ? "成功" : "失败").toString(), userAgent);
/*     */       }
/*     */       else {
/* 123 */         return uppUInfo(uinfo, userAgent);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 128 */       this.log.error(e.getMessage());
/*     */     }
/* 130 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean deleteUInfoById(Long uid, UserAgent userAgent) {
/* 134 */     this.log.info("UsersInfoServiceImpl.deleteUInfoById method");
/*     */     try {
/* 136 */       UserInfo userInfo = this.userInfoDAO.selectById(uid);
/* 137 */       if (this.userInfoDAO.deleteById(uid) > 0)
/*     */       {
/* 140 */         this.workLogService.addWorkLog("删除人员", new StringBuilder().append("用户ID:").append(userAgent.getId()).append(",name:'").append(userAgent.getName()).append("人员[").append(userInfo.getRealName()).append("]删除成功").toString(), userAgent);
/* 141 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 145 */       this.log.error(e.getMessage());
/*     */     }
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean setDept(Long uid, Long deptId, UserAgent userAgent) {
/* 151 */     this.log.info("UsersInfoServiceImpl.setDept method");
/*     */     try {
/* 153 */       UserInfo uinfo = this.userInfoDAO.selectById(uid);
/* 154 */       uinfo.setDeptId(deptId);
/*     */ 
/* 156 */       boolean flag = this.userInfoDAO.updateById(uinfo) > 0;
/*     */ 
/* 158 */       this.workLogService.addWorkLog("分配机构", new StringBuilder().append("用户ID:").append(userAgent.getId()).append(",name:'").append(userAgent.getName()).append("分配机构成功").toString(), userAgent);
/*     */ 
/* 160 */       return flag;
/*     */     }
/*     */     catch (Exception e) {
/* 163 */       this.log.error(e.getMessage());
/*     */     }
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */   public void modifyPosition(final Long uid,final String flag,final UserAgent userAgent,final String deptId)
/*     */   {
/* 171 */     this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public String doInTransaction(TransactionStatus status) {
/* 173 */         if (uid != null) {
/* 174 */           UserInfo uinfo = UserInfoServiceImpl.this.userInfoDAO.selectById(uid);
/* 175 */           UserInfo sortUinfo = null;
/* 176 */           Map map = new HashMap();
/* 177 */           map.put("id", uid);
/* 178 */           if (StringUtil.isNotBlank(deptId)) {
/* 179 */             map.put("deptId", Long.valueOf(deptId));
/*     */           }
/* 181 */           if ("up".equalsIgnoreCase(flag))
/*     */           {
/* 184 */             Long upId = UserInfoServiceImpl.this.userInfoDAO.getUpUinfoId(map);
/* 185 */             if (upId != null)
/* 186 */               sortUinfo = UserInfoServiceImpl.this.userInfoDAO.selectById(upId);
/*     */           }
/* 188 */           else if ("dw".equalsIgnoreCase(flag))
/*     */           {
/* 191 */             Long downId = UserInfoServiceImpl.this.userInfoDAO.getDowmUinfoId(map);
/* 192 */             if (downId != null) {
/* 193 */               sortUinfo = UserInfoServiceImpl.this.userInfoDAO.selectById(downId);
/*     */             }
/*     */           }
/*     */ 
/* 197 */           if (sortUinfo != null) {
/* 198 */             Short tempsort = uinfo.getSort();
/* 199 */             uinfo.setSort(sortUinfo.getSort());
/* 200 */             sortUinfo.setSort(tempsort);
/* 201 */             UserInfoServiceImpl.this.userInfoDAO.updateById(uinfo);
/* 202 */             UserInfoServiceImpl.this.userInfoDAO.updateById(sortUinfo);
/* 203 */             if ("up".equalsIgnoreCase(flag))
/*     */             {
/* 206 */               UserInfoServiceImpl.this.workLogService.addWorkLog("人员上移", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "人员[" + uinfo.getRealName() + "]上移", userAgent);
/* 207 */             } else if ("dw".equalsIgnoreCase(flag))
/*     */             {
/* 209 */               UserInfoServiceImpl.this.workLogService.addWorkLog("人员下移", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "人员[" + uinfo.getRealName() + "]下移", userAgent);
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 248 */         return null;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public boolean removeDept(Long uid) {
/* 255 */     this.log.info("UsersInfoServiceImpl.removeDept method");
/* 256 */     return this.userInfoDAO.removeDeptId(uid) > 0;
/*     */   }
/*     */ 
/*     */   public boolean updateUinfoStatus(Long uid, UserAgent userAgent) {
/* 260 */     this.log.info("UsersInfoServiceImpl.updateUinfoStatus method");
/* 261 */     String str = "启用";
/* 262 */     if (uid != null)
/*     */     {
/* 264 */       UserInfo uinfo = this.userInfoDAO.selectById(uid);
/*     */ 
/* 266 */       if (EnumUserInfoStatus.ENABLE.getCode() == uinfo.getStatus().shortValue())
/*     */       {
/* 268 */         uinfo.setStatus(Short.valueOf(EnumUserInfoStatus.DISABLE.getCode()));
/* 269 */         if (uinfo.getUserId() != null) {
/* 270 */           Users user = this.userDao.selectById(uinfo.getUserId());
/* 271 */           if (user != null) {
/* 272 */             user.setStatus(Short.valueOf(EnumUserStatus.DISUSE_STATUS.getCode()));
/* 273 */             this.userDao.update(user);
/*     */           }
/*     */         }
/* 276 */         str = "禁用";
/*     */       }
/* 278 */       else if (EnumUserInfoStatus.DISABLE.getCode() == uinfo.getStatus().shortValue())
/*     */       {
/* 280 */         uinfo.setStatus(Short.valueOf(EnumUserInfoStatus.ENABLE.getCode()));
/* 281 */         if (uinfo.getUserId() != null) {
/* 282 */           Users user = this.userDao.selectById(uinfo.getUserId());
/* 283 */           if (user != null) {
/* 284 */             user.setStatus(Short.valueOf(EnumUserStatus.USE_STATUS.getCode()));
/* 285 */             this.userDao.update(user);
/*     */           }
/*     */         }
/* 288 */         str = "启用";
/*     */       }
/*     */ 
/* 291 */       boolean flag = this.userInfoDAO.updateById(uinfo) > 0;
/*     */ 
/* 293 */       this.workLogService.addWorkLog(new StringBuilder().append("人员").append(str).toString(), new StringBuilder().append("用户ID:").append(userAgent.getId()).append(",name:'").append(userAgent.getName()).append("人员[").append(uinfo.getRealName()).append("]").append(str).append(flag == true ? "成功" : "失败").toString(), userAgent);
/*     */ 
/* 295 */       return flag;
/*     */     }
/*     */ 
/* 298 */     return false;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.UserInfoServiceImpl
 * JD-Core Version:    0.6.0
 */