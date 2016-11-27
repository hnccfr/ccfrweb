/*     */ package com.hundsun.eclp.interfaces.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.LoginLogDAO;
/*     */ import com.hundsun.eclp.biz.dao.OrgDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*     */ import com.hundsun.eclp.biz.dao.SubSystemDAO;
/*     */ import com.hundsun.eclp.biz.dao.UserInfoDAO;
/*     */ import com.hundsun.eclp.biz.dao.UsersDAO;
/*     */ import com.hundsun.eclp.biz.domain.dept.Department;
/*     */ import com.hundsun.eclp.biz.domain.sys.LoginLog;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermission;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*     */ import com.hundsun.eclp.biz.domain.user.UserRole;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.query.UserInfoQuery;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.UserRoleService;
/*     */ import com.hundsun.eclp.client.remote.client.RemoteUserService;
/*     */ import com.hundsun.eclp.client.remote.dto.OrgDTO;
/*     */ import com.hundsun.eclp.client.remote.dto.UserDTO;
/*     */ import com.hundsun.eclp.client.remote.dto.UserResult;
/*     */ import com.hundsun.eclp.util.BeanUtilEx;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteUserService")
/*     */ public class RemoteUserServiceImpl
/*     */   implements RemoteUserService
/*     */ {
/*  40 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   AuthorityService authorityService;
/*     */ 
/*     */   @Autowired
/*     */   UserRoleService userRoleService;
/*     */ 
/*     */   @Autowired
/*     */   UserInfoDAO userInfoDAO;
/*     */ 
/*     */   @Autowired
/*     */   UsersDAO usersDAO;
/*     */ 
/*     */   @Autowired
/*     */   LoginLogDAO loginLogDAO;
/*     */ 
/*     */   @Autowired
/*     */   RoleDAO roleDAO;
/*     */ 
/*     */   @Autowired
/*     */   SubSystemDAO subSystemDAO;
/*     */ 
/*     */   @Autowired
/*     */   RoleSystemDAO roleSystemDAO;
/*     */ 
/*     */   @Autowired
/*     */   OrgDAO orgDAO;
/*     */ 
/*  71 */   public UserDTO getUserInfoByID(Long id) { this.log.debug("userid====" + id);
/*  72 */     Users user = this.usersDAO.selectById(id);
/*  73 */     this.log.debug("user ====" + user);
/*  74 */     if (user == null) {
/*  75 */       return null;
/*     */     }
/*  77 */     UserDTO userDto = new UserDTO();
/*  78 */     userDto.setAccount(user.getAccount());
/*  79 */     userDto.setAccountStatus(user.getStatus().shortValue());
/*  80 */     userDto.setLoginNum(user.getLoginNum());
/*  81 */     LoginLog log = this.loginLogDAO.getLastLoginLog(user.getAccount());
/*  82 */     if (log != null) {
/*  83 */       userDto.setLastLoginIP(log.getLoginIp());
/*  84 */       userDto.setLastLoginTime(log.getLoginTime());
/*     */     }
/*  86 */     UserInfo userInfo = this.userInfoDAO.selectByUserId(id);
/*  87 */     if (userInfo == null)
/*  88 */       return null;
/*     */     try
/*     */     {
/*  91 */       BeanUtilEx.copyProperties(userDto, userInfo);
/*     */     } catch (IllegalAccessException e) {
/*  93 */       e.printStackTrace();
/*     */     } catch (InvocationTargetException e) {
/*  95 */       e.printStackTrace();
/*     */     }
/*  97 */     return userDto;
/*     */   }
/*     */ 
/*     */   public BigInteger getUserPermissions(Long id, String subSystemCode)
/*     */   {
/* 102 */     Users user = getUserWithRoleInfo(id);
/*     */ 
/* 104 */     List<Integer> list = this.authorityService.getSubsystemPermissionListByUser(user, subSystemCode);
/*     */ 
/* 106 */     BigInteger result = new BigInteger("0");
/* 107 */     Map permissionSet = MemoPermission.get(subSystemCode);
/* 108 */     this.log.debug("子系统[" + subSystemCode + "]:" + permissionSet);
/*     */     Map<Integer, Integer> permissionMap;
/* 109 */     if (permissionSet != null) {
/* 110 */       if ((list != null) && (list.size() > 0)) {
/* 111 */         for (Integer item : list) {
/* 112 */           this.log.debug("permission code :" + item + " index:" + permissionSet.get(item));
/* 113 */           result = result.setBit(((Integer)permissionSet.get(item)).intValue());
/*     */         }
/*     */       }
/* 116 */       SubSystem subSystem = this.subSystemDAO.selectByCode(subSystemCode);
/* 117 */       if (isSuperUser(user, subSystem)) {
/* 118 */         if (subSystem.getSuperCode() != null) {
/* 119 */           result = result.setBit(subSystem.getSuperCode().intValue());
/*     */         } else {
/* 121 */           permissionMap = MemoPermission.get(subSystem.getName());
/* 122 */           if (permissionMap == null) {
/* 123 */             throw new RuntimeException("MemoPermission's data maybe have some errors, please check the permission data ...");
/*     */           }
/* 125 */           for (Integer item : permissionMap.keySet()) {
/* 126 */             result = result.setBit(((Integer)permissionMap.get(item)).intValue());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 132 */     this.log.debug("用户权限值：" + result);
/* 133 */     return result;
/*     */   }
/*     */ 
/*     */   private Users getUserWithRoleInfo(Long id) {
/* 137 */     Users user = this.usersDAO.selectById(id);
/* 138 */     user.setRoleId(getRolesByUserID(id));
/* 139 */     return user;
/*     */   }
/*     */ 
/*     */   private Long[] getRolesByUserID(Long userId) {
/* 143 */     List<UserRole> userRoleList = this.userRoleService.selectByUserId(userId);
/* 144 */     if (userRoleList != null) {
/* 145 */       Long[] roles = new Long[userRoleList.size()];
/* 146 */       int i = 0;
/* 147 */       for (UserRole userRole : userRoleList) {
/* 148 */         roles[i] = userRole.getRoleId();
/* 149 */         i++;
/*     */       }
/* 151 */       return roles;
/*     */     }
/* 153 */     return new Long[0];
/*     */   }
/*     */ 
/*     */   private boolean isSuperUser(Users user, SubSystem subSystem) {
/* 157 */     String roldId = this.roleSystemDAO.getRoleIDBySystemCode(subSystem.getName());
/* 158 */     Long[] arr$ = user.getRoleId(); int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { long item = arr$[i$].longValue();
/* 159 */       if (item == Long.valueOf(roldId).longValue()) {
/* 160 */         return true;
/*     */       }
/*     */     }
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */   public List<Integer> getSubSystemPermissionListByUserId(Long id, String subSystemCode)
/*     */   {
/* 170 */     this.log.debug("method[ getUserPermissionsWithList ]: userId=" + id + "        systemCode=" + subSystemCode);
/* 171 */     Users user = new Users();
/* 172 */     user.setId(id);
/* 173 */     return this.authorityService.getSubsystemAllPermissionListByUser(user, subSystemCode);
/*     */   }
/*     */ 
/*     */   public UserDTO getUserInfoByAccount(String account)
/*     */   {
/* 178 */     this.log.info("RemoteUserServiceImpl.getUserInfoByAccount method:[account=" + account + "]");
/*     */     try {
/* 180 */       if (StringUtil.isNotBlank(account)) {
/* 181 */         UserInfo userinfo = this.userInfoDAO.selectByAccount(account);
/* 182 */         if (userinfo != null)
/* 183 */           return userinfo.toDTO();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 187 */       this.log.error(e.getMessage());
/*     */     }
/* 189 */     return null;
/*     */   }
/*     */ 
/*     */   public UserResult getUserListBySubSystemCode(UserDTO user)
/*     */   {
/* 195 */     this.log.info("RemoteUserServiceImpl.getUserListBySubSystemCode method[subSystemCode=" + user.getSubSystemCode() + "]");
/* 196 */     UserResult rs = new UserResult();
/*     */     try {
/* 198 */       rs.setSuccess(true);
/* 199 */       if (StringUtil.isBlank(user.getSubSystemCode())) {
/* 200 */         rs.setSuccess(false);
/* 201 */         rs.setErrorMsg("子系统code不能为空");
/* 202 */         return rs;
/*     */       }
/*     */ 
/* 205 */       List roleList = this.roleDAO.getRoleIdBySubSystemCode(user.getSubSystemCode());
/* 206 */       if (roleList != null) {
/* 207 */         UserInfoQuery query = getUserInfoQuery(user);
/* 208 */         query.setRoleList(roleList);
/*     */ 
/* 210 */         query = this.userInfoDAO.selectUserInfo(query);
/* 211 */         if (query != null) {
/* 212 */           rs.setCurrPage(query.getCurrentPage().intValue());
/* 213 */           rs.setTotalItems(query.getTotalItem().intValue());
/* 214 */           rs.setTotalPage(query.getTotalPage());
/* 215 */           List rsList = query.getItems();
/* 216 */           if (rsList != null)
/* 217 */             rs.setResult(toDTO(rsList));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 222 */       rs.setSuccess(false);
/* 223 */       this.log.error(e.getMessage());
/* 224 */       rs.setErrorMsg(e.getMessage());
/*     */     }
/* 226 */     return rs;
/*     */   }
/*     */ 
/*     */   private UserInfoQuery getUserInfoQuery(UserDTO user) {
/* 230 */     UserInfoQuery query = new UserInfoQuery();
/* 231 */     if (user.getPageSize() != null)
/* 232 */       query.setPageSize(user.getPageSize());
/*     */     else
/* 234 */       query.setPageSize(Integer.valueOf(20));
/* 235 */     if (user.getCurrPage() != null)
/* 236 */       query.setCurrentPage(user.getCurrPage());
/*     */     else {
/* 238 */       query.setCurrentPage(Integer.valueOf(1));
/*     */     }
/* 240 */     if (user.getStatus() != null)
/* 241 */       query.setStatus(String.valueOf(user.getStatus()));
/* 242 */     return query;
/*     */   }
/*     */ 
/*     */   private Object toDTO(List<UserInfo> rsList) {
/* 246 */     List list = new ArrayList();
/* 247 */     for (UserInfo userinfo : rsList) {
/* 248 */       list.add(userinfo.toDTO());
/*     */     }
/* 250 */     return list;
/*     */   }
/*     */ 
/*     */   public OrgDTO getDeptInfoByUserId(Long userId)
/*     */   {
/* 255 */     if (userId == null)
/* 256 */       return null;
/*     */     try
/*     */     {
/* 259 */       List<Department> list = this.orgDAO.getUpOrgListByUserId(userId);
/* 260 */       if ((list == null) || (list.size() == 0)) {
/* 261 */         return null;
/*     */       }
/* 263 */       OrgDTO orgDTO = new OrgDTO();
/* 264 */       int size = list.size();
/* 265 */       int i = 0;
/*     */ 
/* 267 */       String deptIds = ""; String deptNames = "";
/* 268 */       String topDeptId = ""; String topDeptName = "";
/* 269 */       String leafDeptId = ""; String leafDeptName = "";
/* 270 */       for (Department dept : list) {
/* 271 */         if (StringUtil.isNotBlank(deptIds)) {
/* 272 */           deptIds = "-" + deptIds;
/*     */         }
/* 274 */         deptIds = dept.getId().toString() + deptIds;
/* 275 */         if (StringUtil.isNotBlank(deptNames)) {
/* 276 */           deptNames = "-" + deptNames;
/*     */         }
/* 278 */         deptNames = dept.getName() + deptNames;
/* 279 */         i++; if (i == size) {
/* 280 */           topDeptId = dept.getId().toString();
/* 281 */           topDeptName = dept.getName();
/* 282 */         } else if (i == 1) {
/* 283 */           leafDeptId = dept.getId().toString();
/* 284 */           leafDeptName = dept.getName();
/*     */         }
/*     */       }
/* 287 */       orgDTO.setDeptIds(deptIds);
/* 288 */       orgDTO.setDeptNames(deptNames);
/* 289 */       orgDTO.setTopDeptId(topDeptId);
/* 290 */       orgDTO.setTopDeptName(topDeptName);
/* 291 */       orgDTO.setLeafDeptId(leafDeptId);
/* 292 */       orgDTO.setLeafDeptName(leafDeptName);
/* 293 */       return orgDTO;
/*     */     } catch (Exception e) {
/* 295 */       this.log.error("getDeptInfoById", e);
/* 296 */     }throw new RuntimeException("根据部门id查询部门信息失败");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.interfaces.impl.RemoteUserServiceImpl
 * JD-Core Version:    0.6.0
 */