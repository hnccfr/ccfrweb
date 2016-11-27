/*     */ package com.hundsun.eclp.biz.service.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.RoleAuthorityDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*     */ import com.hundsun.eclp.biz.dao.SysConfigDAO;
/*     */ import com.hundsun.eclp.biz.dao.UserInfoDAO;
/*     */ import com.hundsun.eclp.biz.dao.UsersDAO;
/*     */ import com.hundsun.eclp.biz.domain.role.RoleAuthority;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermission;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.sys.SysConfig;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*     */ import com.hundsun.eclp.biz.domain.user.UserRole;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.query.UsersQuery;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.SubSystemService;
/*     */ import com.hundsun.eclp.biz.service.ToolService;
/*     */ import com.hundsun.eclp.biz.service.UserRoleService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*     */ import com.hundsun.eclp.enums.EnumUserInfoStatus;
/*     */ import com.hundsun.eclp.enums.EnumUserStatus;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.util.digest.MessageDigest;
/*     */ import com.hundsun.network.melody.common.util.digest.impl.MD5MessageDigestImpl;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("usersService")
/*     */ public class UsersServiceImpl
/*     */   implements UsersService
/*     */ {
/*  43 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SysConfigDAO sysConfigDAO;
/*     */ 
/*     */   @Autowired
/*     */   UsersDAO userDao;
/*     */ 
/*     */   @Autowired
/*     */   AuthorityService authorityService;
/*     */ 
/*     */   @Autowired
/*     */   private UserInfoDAO userInfoDAO;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogService workLogService;
/*     */ 
/*     */   @Autowired
/*     */   private ToolService toolService;
/*     */ 
/*     */   @Autowired
/*     */   private RoleSystemDAO roleSystemDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserRoleService userRoleService;
/*     */ 
/*     */   @Autowired
/*     */   private SubSystemService subSystemService;
/*     */ 
/*     */   @Autowired
/*     */   RoleAuthorityDAO roleAuthorityDAO;
/*     */ 
/*  67 */   private boolean checkPassword(Users user, Users dbuser) { MessageDigest digest = new MD5MessageDigestImpl();
/*  68 */     if (digest.digest(user.getPassword()).equals(dbuser.getPassword())) {
/*  69 */       return Boolean.TRUE.booleanValue();
/*     */     }
/*  71 */     return Boolean.FALSE.booleanValue();
/*     */   }
/*     */ 
/*     */   public Users getUserByAccount(String account)
/*     */   {
/*  76 */     Users user = new Users();
/*  77 */     user.setAccount(account);
/*  78 */     user.setStatus(Short.valueOf(EnumUserStatus.USE_STATUS.getCode()));
/*  79 */     List userList = this.userDao.select(user);
/*  80 */     if ((userList != null) && (userList.size() > 0)) {
/*  81 */       user = (Users)userList.get(0);
/*  82 */       Long[] roleIds = getRolesByUserID(user.getId());
/*  83 */       user.setRoleId(roleIds);
/*  84 */       return user;
/*     */     }
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   public Users queryUserByAccount(String account) {
/*  90 */     Users user = new Users();
/*  91 */     user.setAccount(account);
/*     */ 
/*  93 */     List userList = this.userDao.select(user);
/*  94 */     if ((userList != null) && (userList.size() > 0)) {
/*  95 */       user = (Users)userList.get(0);
/*  96 */       Long[] roleIds = getRolesByUserID(user.getId());
/*  97 */       user.setRoleId(roleIds);
/*  98 */       return user;
/*     */     }
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */   private Long[] getRolesByUserID(Long userId) {
/* 104 */     List<UserRole> userRoleList = this.userRoleService.selectByUserId(userId);
/* 105 */     if (userRoleList != null) {
/* 106 */       Long[] roles = new Long[userRoleList.size()];
/* 107 */       int i = 0;
/* 108 */       for (UserRole userRole : userRoleList) {
/* 109 */         roles[i] = userRole.getRoleId();
/* 110 */         i++;
/*     */       }
/* 112 */       return roles;
/*     */     }
/* 114 */     return new Long[0];
/*     */   }
/*     */ 
/*     */   public boolean login(Users user, String loginIp, String currentSystemCode, Cookyjar cookyjar)
/*     */   {
/* 120 */     if ((StringUtil.isEmpty(user.getAccount())) || (StringUtil.isEmpty(user.getPassword()))) {
/* 121 */       return Boolean.FALSE.booleanValue();
/*     */     }
/*     */ 
/* 124 */     Users dbuser = getUserByAccount(user.getAccount());
/* 125 */     if (dbuser == null) {
/* 126 */       return Boolean.FALSE.booleanValue();
/*     */     }
/* 128 */     user.setId(dbuser.getId());
/* 129 */     if (checkPassword(user, dbuser)) {
/* 130 */       UserAgent userAgent = new UserAgent();
/*     */ 
/* 132 */       userAgent.setName(dbuser.getName());
/* 133 */       if (dbuser.getLastLoginTime() != null)
/* 134 */         userAgent.setEclpLastLoginTime(Long.valueOf(dbuser.getLastLoginTime().getTime()));
/*     */       else {
/* 136 */         userAgent.setEclpLastLoginTime(Long.valueOf(new Date().getTime()));
/*     */       }
/*     */ 
/* 139 */       if (StringUtil.isNotEmpty(currentSystemCode))
/* 140 */         userAgent.setCurrentSystemCode(currentSystemCode);
/*     */       SubSystem subSystem;
/* 144 */       if (StringUtil.isNotEmpty(userAgent.getCurrentSystemCode()))
/* 145 */         subSystem = this.subSystemService.selectByCode(userAgent.getCurrentSystemCode());
/*     */       else {
/* 147 */         subSystem = this.authorityService.getDefaultSubSystemByUser(dbuser);
/*     */       }
/* 149 */       if (subSystem != null) {
/* 150 */         String subSystemCode = subSystem.getName();
/* 151 */         userAgent.setCurrentSystemCode(subSystemCode);
/*     */ 
/* 154 */         userAgent.setPermissionsByList(this.authorityService.getSubsystemPermissionListByUser(dbuser, subSystemCode), subSystemCode);
/* 155 */         addSuperUserPermission(dbuser, userAgent, subSystem);
/*     */       }
/* 157 */       userAgent.setId(dbuser.getId().longValue());
/* 158 */       userAgent.setUserType(dbuser.getUserType());
/* 159 */       userAgent.setUserAccount(dbuser.getAccount());
/* 160 */       if (StringUtil.isBlank(dbuser.getLastLoginIp()))
/* 161 */         userAgent.setLastLoginIp(loginIp);
/*     */       else {
/* 163 */         userAgent.setLastLoginIp(dbuser.getLastLoginIp());
/*     */       }
/*     */ 
/* 166 */       Users newUser = new Users();
/* 167 */       newUser.setId(dbuser.getId());
/* 168 */       newUser.setLastLoginTime(new Date());
/* 169 */       newUser.setLastLoginIp(loginIp);
/* 170 */       newUser.setLoginNum(Long.valueOf(dbuser.getLoginNum() == null ? 1L : dbuser.getLoginNum().longValue() + 1L));
/* 171 */       newUser.setName(dbuser.getName());
/* 172 */       newUser.setSource(user.getSource());
/*     */ 
/* 175 */       updateUserWithInfo(newUser, userAgent);
/* 176 */       cookyjar.set(userAgent);
/* 177 */       return Boolean.TRUE.booleanValue();
/*     */     }
/* 179 */     return Boolean.FALSE.booleanValue();
/*     */   }
/*     */ 
/*     */   public void addSuperUserPermission(Users dbuser, UserAgent userAgent, SubSystem subSystem)
/*     */   {
/* 186 */     String roleid = getSuperUserRoleID(subSystem.getId());
/*     */     Map<Integer, Integer> permissionMap;
/* 187 */     if (StringUtil.isNotEmpty(roleid))
/*     */     {
/* 189 */       boolean isSuperUser = isSuperUser(dbuser, roleid);
/* 190 */       if (isSuperUser) {
/* 191 */         userAgent.setIsSuperUser(isSuperUser);
/* 192 */         if (subSystem.getSuperCode() != null) {
/* 193 */           userAgent.setPermission(getSubsystemSuperUserCode(subSystem));
/*     */         } else {
/* 195 */           permissionMap = MemoPermission.get(subSystem.getName());
/* 196 */           if (permissionMap == null) {
/* 197 */             throw new RuntimeException("MemoPermission's data maybe have some errors, please check the permission data ...");
/*     */           }
/* 199 */           for (Integer item : permissionMap.keySet())
/* 200 */             userAgent.setPermission(((Integer)permissionMap.get(item)).intValue());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getSuperUserRoleID(Long id)
/*     */   {
/* 209 */     return this.roleSystemDAO.getRoleIDBySystemID(id.longValue());
/*     */   }
/*     */ 
/*     */   private int getSubsystemSuperUserCode(SubSystem subSystem) {
/* 213 */     Map map = MemoPermission.get(subSystem.getName());
/* 214 */     if (map != null) {
/* 215 */       Integer permissionIndex = (Integer)map.get(Integer.valueOf(subSystem.getSuperCode().intValue()));
/* 216 */       if (permissionIndex != null) {
/* 217 */         return permissionIndex.intValue();
/*     */       }
/*     */     }
/* 220 */     throw new RuntimeException("MemoPermission's data maybe have some errors, please check the permission data ...");
/*     */   }
/*     */ 
/*     */   private boolean isSuperUser(Users dbuser, String roleid) {
/* 224 */     Long[] arr$ = dbuser.getRoleId(); int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { long item = arr$[i$].longValue();
/* 225 */       if (item == Long.valueOf(roleid).longValue()) {
/* 226 */         return true;
/*     */       }
/*     */     }
/* 229 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean updateUserStatus(Users user, UserAgent userAgent)
/*     */   {
/* 234 */     this.log.info("UsersServiceImpl.updateUser method");
/*     */     try {
/* 236 */       String str = "";
/*     */ 
/* 238 */       if (EnumUserStatus.USE_STATUS.getCode() == user.getStatus().shortValue()) {
/* 239 */         user.setStatus(Short.valueOf(EnumUserStatus.DISUSE_STATUS.getCode()));
/*     */ 
/* 241 */         UserInfo userInfo = this.userInfoDAO.selectByUserId(user.getId());
/* 242 */         if (userInfo != null) {
/* 243 */           userInfo.setStatus(Short.valueOf(EnumUserInfoStatus.DISABLE.getCode()));
/* 244 */           this.userInfoDAO.update(userInfo);
/*     */         }
/* 246 */         str = "禁用";
/* 247 */       } else if (EnumUserStatus.DISUSE_STATUS.getCode() == user.getStatus().shortValue()) {
/* 248 */         user.setStatus(Short.valueOf(EnumUserStatus.USE_STATUS.getCode()));
/*     */ 
/* 250 */         UserInfo userInfo = this.userInfoDAO.selectByUserId(user.getId());
/* 251 */         if (userInfo != null) {
/* 252 */           userInfo.setStatus(Short.valueOf(EnumUserInfoStatus.ENABLE.getCode()));
/* 253 */           this.userInfoDAO.update(userInfo);
/*     */         }
/* 255 */         str = "启用";
/*     */       }
/* 257 */       if (this.userDao.update(user) > 0) {
/* 258 */         this.workLogService.addWorkLog("用户" + str, "用户ID:" + user.getId() + ",name:'" + user.getName() + "'用户[" + user.getName() + "]" + str + "成功", userAgent);
/*     */ 
/* 260 */         this.toolService.synchronizeUpdateTime(null);
/*     */       }
/*     */     } catch (Exception e) {
/* 263 */       this.log.error(e.getMessage());
/* 264 */       return false;
/*     */     }
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */   public UsersQuery selectUsersByPage(UsersQuery query)
/*     */   {
/* 271 */     this.log.info("UsersServiceImpl.selectByPage method");
/*     */     try {
/* 273 */       return this.userDao.serarchByPage(query);
/*     */     } catch (Exception e) {
/* 275 */       this.log.error(e.getMessage());
/*     */     }
/* 277 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean addUser(Users user, UserAgent userAgent)
/*     */   {
/* 282 */     this.log.info("UsersServiceImpl.addUser method");
/*     */     try {
/* 284 */       String psw = "";
/*     */ 
/* 286 */       SysConfig sys = this.sysConfigDAO.selectSysConfigByCode("default_password");
/* 287 */       if (sys != null) {
/* 288 */         psw = sys.getValue();
/*     */       }
/* 290 */       if (StringUtil.isBlank(psw)) {
/* 291 */         psw = "123456";
/*     */       }
/*     */ 
/* 294 */       MessageDigest digest = new MD5MessageDigestImpl();
/* 295 */       user.setPassword(digest.digest(psw));
/* 296 */       user.setStatus(Short.valueOf(EnumUserStatus.USE_STATUS.getCode()));
/*     */ 
/* 298 */       Long userId = this.userDao.insert(user);
/*     */ 
/* 300 */       UserInfo userInfo = user.getUserInfo();
/* 301 */       user = this.userDao.selectById(userId);
/* 302 */       userInfo.setUserId(userId);
/* 303 */       userInfo.setRealName(user.getName());
/* 304 */       userInfo.setStatus(user.getStatus());
/* 305 */       Long sort = Long.valueOf(this.userInfoDAO.getMaxSort().longValue() + 1L);
/* 306 */       userInfo.setSort(Short.valueOf(sort.shortValue()));
/* 307 */       boolean flag = this.userInfoDAO.insert(userInfo).longValue() > 0L;
/* 308 */       this.workLogService.addWorkLog("新增用户", "用户ID:" + userId + ",name:'" + user.getName() + "'新增用户[" + user.getName() + "]成功", userAgent);
/* 309 */       return flag;
/*     */     } catch (Exception e) {
/* 311 */       this.log.error(e.getMessage());
/*     */     }
/* 313 */     return false;
/*     */   }
/*     */ 
/*     */   public Users selectUserById(Long id)
/*     */   {
/* 318 */     this.log.info("UsersServiceImpl.selectUserById method");
/*     */     try {
/* 320 */       return this.userDao.selectById(id);
/*     */     } catch (Exception e) {
/* 322 */       this.log.error(e.getMessage());
/*     */     }
/* 324 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean deleteUserById(Long userId, UserAgent userAgent)
/*     */   {
/* 329 */     this.log.info("UsersServiceImpl.deleteUserById method");
/*     */     try {
/* 331 */       String name = this.userDao.selectById(userId).getName();
/* 332 */       UserInfo userinfo = this.userInfoDAO.selectByUserId(userId);
/* 333 */       if (userinfo != null) {
/* 334 */         this.userInfoDAO.deleteById(userId);
/*     */       }
/* 336 */       if (this.userDao.delete(userId) > 0) {
/* 337 */         this.workLogService.addWorkLog("删除用户", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "'删除用户[" + name + "]成功", userAgent);
/*     */ 
/* 339 */         return this.toolService.synchronizeUpdateTime(null);
/*     */       }
/*     */     } catch (Exception e) {
/* 342 */       this.log.error(e.getMessage());
/*     */     }
/* 344 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean resetPassword(Users user, UserAgent userAgent)
/*     */   {
/* 349 */     String psw = "";
/*     */ 
/* 351 */     SysConfig sys = this.sysConfigDAO.selectSysConfigByCode("default_password");
/* 352 */     if (sys != null) {
/* 353 */       psw = sys.getValue();
/*     */     }
/* 355 */     if (StringUtil.isBlank(psw)) {
/* 356 */       psw = "123456";
/*     */     }
/*     */ 
/* 359 */     MessageDigest digest = new MD5MessageDigestImpl();
/* 360 */     user.setPassword(digest.digest(psw));
/* 361 */     boolean flag = this.userDao.update(user) > 0;
/* 362 */     if (flag)
/* 363 */       this.workLogService.addWorkLog("用户重置密码", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "'用户重置密码", userAgent);
/* 364 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean updateUserPassword(Users user, UserAgent userAgent)
/*     */   {
/* 370 */     MessageDigest digest = new MD5MessageDigestImpl();
/* 371 */     user.setPassword(digest.digest(user.getPassword()));
/* 372 */     boolean flag = this.userDao.update(user) > 0;
/* 373 */     if (flag)
/* 374 */       this.workLogService.addWorkLog("修改用户密码", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "'修改用户密码成功", userAgent);
/* 375 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean updateUserWithInfo(Users user, UserAgent userAgent)
/*     */   {
/* 380 */     boolean flag = false;
/* 381 */     if (this.userDao.update(user) > 0) {
/* 382 */       flag = true;
/* 383 */       UserInfo uInfo = user.getUserInfo();
/* 384 */       if (uInfo != null) {
/* 385 */         uInfo.setRealName(user.getName());
/* 386 */         if (uInfo.getId() == null) {
/* 387 */           uInfo.setStatus(Short.valueOf(EnumUserStatus.USE_STATUS.getCode()));
/* 388 */           flag = this.userInfoDAO.insert(uInfo).longValue() > 0L;
/*     */         } else {
/* 390 */           flag = this.userInfoDAO.update(uInfo) > 0;
/*     */         }
/*     */       }
/*     */ 
/* 394 */       if ((flag) && (!"login".equals(user.getSource())))
/* 395 */         this.workLogService.addWorkLog("修改用户信息", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "'修改用户信息", userAgent);
/* 396 */       return flag;
/*     */     }
/* 398 */     return flag;
/*     */   }
/*     */ 
/*     */   public Users getUserByID(long id)
/*     */   {
/* 403 */     Users user = new Users();
/* 404 */     user.setId(Long.valueOf(id));
/* 405 */     user.setStatus(Short.valueOf(EnumUserStatus.USE_STATUS.getCode()));
/* 406 */     List userList = this.userDao.select(user);
/* 407 */     if ((userList != null) && (userList.size() > 0)) {
/* 408 */       user = (Users)userList.get(0);
/* 409 */       Long[] roleIds = getRolesByUserID(user.getId());
/* 410 */       user.setRoleId(roleIds);
/* 411 */       return user;
/*     */     }
/* 413 */     return null;
/*     */   }
/*     */ 
/*     */   public List<Users> getUserList()
/*     */   {
/* 418 */     return this.userDao.select(new Users());
/*     */   }
/*     */ 
/*     */   public List<Users> selectNotReleUsers()
/*     */   {
/* 423 */     return this.userDao.selectNotReleUsers();
/*     */   }
/*     */ 
/*     */   public boolean checkAccountAndPassword(Users user)
/*     */   {
/* 428 */     Users userDB = getUserByAccount(user.getAccount());
/* 429 */     if (userDB == null) {
/* 430 */       return false;
/*     */     }
/* 432 */     MessageDigest digest = new MD5MessageDigestImpl();
/* 433 */     return userDB.getPassword().equals(digest.digest(user.getPassword()));
/*     */   }
/*     */ 
/*     */   public UsersQuery selectUsersByAuth(Long authId, Long sysId, UsersQuery query)
/*     */   {
/* 439 */     this.log.info("UsersServiceImpl.selectUsersByAuth method");
/*     */     try
/*     */     {
/* 442 */       String roleId = this.roleSystemDAO.getRoleIDBySystemID(sysId.longValue());
/*     */ 
/* 444 */       List<RoleAuthority> roleAuthsList = this.roleAuthorityDAO.findAllRoleByAuthId(authId);
/* 445 */       List roleIdList = new ArrayList();
/* 446 */       for (RoleAuthority role : roleAuthsList)
/*     */       {
/* 448 */         roleIdList.add(role.getRoleId());
/*     */       }
/* 450 */       roleIdList.add(Long.valueOf(Long.parseLong(roleId)));
/* 451 */       query.setRoleList(roleIdList);
/* 452 */       return this.userDao.selectByAuthId(query);
/*     */     } catch (Exception e) {
/* 454 */       this.log.error(e.getMessage());
/*     */     }
/* 456 */     return null;
/*     */   }
/*     */ 
/*     */   public List<Users> selectListByRoleList(Long authId, Long sysId, UsersQuery query) {
/* 460 */     this.log.info("UsersServiceImpl.selectListByRoleList method");
/*     */     try
/*     */     {
/* 463 */       String roleId = this.roleSystemDAO.getRoleIDBySystemID(sysId.longValue());
/*     */ 
/* 465 */       List<RoleAuthority> roleAuthsList = this.roleAuthorityDAO.findAllRoleByAuthId(authId);
/* 466 */       List roleIdList = new ArrayList();
/* 467 */       for (RoleAuthority role : roleAuthsList)
/*     */       {
/* 469 */         roleIdList.add(role.getRoleId());
/*     */       }
/* 471 */       roleIdList.add(Long.valueOf(Long.parseLong(roleId)));
/* 472 */       query.setRoleList(roleIdList);
/* 473 */       return this.userDao.selectListByRoleList(query);
/*     */     } catch (Exception e) {
/* 475 */       this.log.error(e.getMessage());
/*     */     }
/* 477 */     return null;
/*     */   }
/*     */ 
/*     */   public UsersQuery selectUsersByRoleId(UsersQuery query)
/*     */   {
/* 482 */     this.log.info("UsersServiceImpl.selectUsersByRoleId method");
/*     */     try {
/* 484 */       return this.userDao.selectUsersByRoleId(query);
/*     */     } catch (Exception e) {
/* 486 */       this.log.error(e.getMessage());
/*     */     }
/* 488 */     return null;
/*     */   }
/*     */ 
/*     */   public List<Users> selectUsersListByRoleId(Long roleId)
/*     */   {
/* 493 */     this.log.info("UsersServiceImpl.selectUsersByRoleId method");
/*     */     try {
/* 495 */       return this.userDao.selectUsersListByRoleId(roleId);
/*     */     } catch (Exception e) {
/* 497 */       this.log.error(e.getMessage());
/*     */     }
/* 499 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.UsersServiceImpl
 * JD-Core Version:    0.6.0
 */