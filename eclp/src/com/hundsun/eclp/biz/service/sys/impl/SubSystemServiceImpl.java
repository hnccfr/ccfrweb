/*     */ package com.hundsun.eclp.biz.service.sys.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.AuthorityDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*     */ import com.hundsun.eclp.biz.dao.SubSystemDAO;
/*     */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*     */ import com.hundsun.eclp.biz.domain.role.Role;
/*     */ import com.hundsun.eclp.biz.domain.role.RoleSytem;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.common.impl.NotifyServerImpl;
/*     */ import com.hundsun.eclp.biz.service.sys.SubSystemService;
/*     */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityType;
/*     */ import com.hundsun.eclp.enums.EnumSubSystemError;
/*     */ import com.hundsun.eclp.enums.EnumSubSystemOpenType;
/*     */ import com.hundsun.eclp.enums.EnumSubSystemStatus;
/*     */ import com.hundsun.eclp.enums.EnumUsersType;
/*     */ import com.hundsun.eclp.util.FileUploadUtil;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ import org.springframework.ui.Model;
/*     */ 
/*     */ @Service("subSystemService2")
/*     */ public class SubSystemServiceImpl
/*     */   implements SubSystemService
/*     */ {
/*  42 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SubSystemDAO subSystemDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuthorityService authorityService;
/*     */ 
/*     */   @Autowired
/*     */   private AuthorityDAO authorityDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RoleDAO roleDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RoleSystemDAO roleSystemDAO;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogService workLogService;
/*     */ 
/*     */   @Autowired
/*     */   private FileUploadUtil fileUploadUtil;
/*     */ 
/*     */   @Autowired
/*     */   NotifyServerImpl notifyServer;
/*     */ 
/*     */   @Autowired
/*     */   TransactionTemplate transactionTemplate;
/*     */ 
/*  71 */   public List<SubSystem> getAllSubSystemList(UserAgent user) { SubSystem subSystem = new SubSystem();
/*  72 */     if (EnumUsersType.APPLICATION_LEVEL.getCode() == user.getUserType())
/*     */     {
/*  74 */       subSystem.setIsCore(Short.valueOf((short) 0));
/*  75 */       return this.subSystemDAO.getAllSubSystemList(subSystem);
/*     */     }
/*     */ 
/*  78 */     return getAllSubSystemList();
/*     */   }
/*     */ 
/*     */   public List<SubSystem> getAllSubSystemList()
/*     */   {
/*  83 */     return this.subSystemDAO.getAllSubSystemList();
/*     */   }
/*     */   @Transactional
/*     */   public boolean deleteSubSystem(Long id, UserAgent user) {
/*  88 */     this.log.info("SubSystemServiceImpl.deleteSubSystem method");
/*  89 */     boolean temp = false;
/*     */     try
/*     */     {
/*  92 */       SubSystem subSystem = this.subSystemDAO.selectById(id);
/*  93 */       subSystem.setIsDeleted("Y");
/*  94 */       this.subSystemDAO.update(subSystem);
/*     */ 
/*  97 */       Authority authority = this.authorityDAO.selectAuthorityBySubSystemId(subSystem.getId());
/*  98 */       if (authority != null) {
/*  99 */         authority.setIsDeleted("Y");
/* 100 */         this.authorityDAO.updateAuthority(authority);
/*     */       }
/*     */ 
/* 103 */       this.workLogService.addWorkLog("删除", "子系统ID:" + subSystem.getId() + ",name:'" + subSystem.getFullName() + "'删除成功", user);
/*     */ 
/* 105 */       temp = true;
/*     */     } catch (Exception e) {
/* 107 */       this.log.error(e.getMessage());
/*     */     }
/* 109 */     return temp;
/*     */   }
/*     */   @Transactional
/*     */   public Long insert(SubSystem subSystem, UserAgent user) {
/* 114 */     this.log.info("SubSystemServiceImpl.insert method");
/*     */     try
/*     */     {
/* 117 */       if (subSystem.getFile() != null) {
/* 118 */         String filePath = this.fileUploadUtil.uploadFile(subSystem.getFile(), "000000", "subsys_logo");
/* 119 */         subSystem.setLogo(filePath);
/*     */       }
/*     */ 
/* 122 */       if (subSystem.getSort() == null) {
/* 123 */         subSystem.setSort(Short.valueOf(this.subSystemDAO.getMaxSort().shortValue()));
/*     */       }
/* 125 */       Long subSystemId = this.subSystemDAO.insert(subSystem);
/*     */ 
/* 127 */       Authority authority = new Authority();
/* 128 */       authority.setName(subSystem.getFullName());
/* 129 */       authority.setType(Short.valueOf(EnumAuthorityType.SYSTEM.getCode()));
/* 130 */       authority.setIsCore(subSystem.getIsCore());
/* 131 */       authority.setSubSystemId(subSystemId.toString());
/* 132 */       authority.setSort(Short.valueOf(this.authorityService.getMaxSort()));
/* 133 */       authority.setStatus(subSystem.getStatus());
/* 134 */       authority.setParentId(Long.valueOf(-1L));
/* 135 */       authority.setIsLeaf(Short.valueOf((short) 2));
/* 136 */       authority.setOpenType(subSystem.getOpenType());
/* 137 */       authority.setIsDeleted("N");
/* 138 */       authority.setIsAssign((short) 1);
/* 139 */       this.authorityService.insertAuthority(authority);
/*     */ 
/* 142 */       Role role = new Role();
/* 143 */       role.setCode(subSystem.getName() + "_" + "role");
/* 144 */       role.setDisplayName(subSystem.getFullName() + "超级角色");
/* 145 */       role.setIsCore(Short.valueOf((short) 2));
/* 146 */       role.setSort(Long.valueOf(this.roleDAO.getMaxSort() + 1L));
/* 147 */       role.setRoleType(Short.valueOf((short) 0));
/* 148 */       Long roleId = this.roleDAO.insertRole(role);
/*     */ 
/* 151 */       RoleSytem roleSytem = new RoleSytem();
/* 152 */       roleSytem.setRoleId(roleId);
/* 153 */       roleSytem.setSysId(subSystemId);
/* 154 */       this.roleSystemDAO.insertRoleSystem(roleSytem);
/*     */ 
/* 157 */       this.workLogService.addWorkLog("添加", "子系统ID:" + subSystemId + ",name:'" + subSystem.getFullName() + "'添加成功", user);
/*     */ 
/* 159 */       return subSystemId;
/*     */     } catch (Exception e) {
/* 161 */       this.log.error(e.getMessage());
/*     */     }
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */   public int update(SubSystem subSystem, UserAgent user) {
/* 167 */     this.log.info("SubSystemServiceImpl.update method");
/*     */     try
/*     */     {
/* 170 */       if (subSystem.getFile() != null) {
/* 171 */         String filePath = this.fileUploadUtil.uploadFile(subSystem.getFile(), "000000", "subsys_logo");
/* 172 */         subSystem.setLogo(filePath);
/*     */       }
/*     */ 
/* 175 */       SubSystem oldSubSys = this.subSystemDAO.selectById(subSystem.getId());
/*     */ 
/* 177 */       int count = this.subSystemDAO.update(subSystem);
/*     */ 
/* 180 */       Role role = new Role();
/* 181 */       role.setCode(subSystem.getName() + "_" + "role");
/* 182 */       role.setDisplayName(subSystem.getFullName() + "超级角色");
/* 183 */       role.setSort(Long.valueOf(this.roleDAO.getMaxSort() + 1L));
/* 184 */       role.setRoleType(Short.valueOf((short) 0));
/* 185 */       List roleList = this.roleDAO.getSuperRoleList(subSystem.getId());
/* 186 */       if ((roleList == null) || (roleList.size() == 0))
/*     */       {
/* 188 */         role.setIsCore(Short.valueOf((short) 2));
/* 189 */         Long roleId = this.roleDAO.insertRole(role);
/*     */ 
/* 192 */         RoleSytem roleSytem = new RoleSytem();
/* 193 */         roleSytem.setRoleId(roleId);
/* 194 */         roleSytem.setSysId(subSystem.getId());
/* 195 */         this.roleSystemDAO.insertRoleSystem(roleSytem);
/*     */ 
/* 198 */         Authority authority = this.authorityService.selectAuthorityBySubSystemId(subSystem.getId());
/* 199 */         authority.setName(subSystem.getFullName());
/* 200 */         authority.setOpenType(subSystem.getOpenType());
/* 201 */         this.authorityService.updateAuthority(authority);
/*     */       }
/*     */ 
/* 205 */       if (oldSubSys.getSuperCode() != null) {
/* 206 */         if (subSystem.getSuperCode() != null)
/*     */         {
/* 208 */           if (oldSubSys.getSuperCode().longValue() == subSystem.getSuperCode().longValue()) {
/* 209 */             this.notifyServer.notifyClient(oldSubSys.getId(), false);
/*     */           }
/*     */         }
/*     */         else
/* 213 */           this.notifyServer.notifyClient(oldSubSys.getId(), false);
/*     */       }
/* 215 */       else if (subSystem.getSuperCode() != null)
/*     */       {
/* 217 */         this.notifyServer.notifyClient(oldSubSys.getId(), false);
/*     */       }
/*     */ 
/* 220 */       if (!oldSubSys.getName().equals(subSystem.getName())) {
/* 221 */         this.notifyServer.updateSysCode(subSystem.getName(), oldSubSys.getName());
/*     */       }
/*     */ 
/* 225 */       this.workLogService.addWorkLog("更新", "子系统ID:" + subSystem.getId() + ",name:'" + subSystem.getFullName() + "'更新成功", user);
/*     */ 
/* 227 */       return count;
/*     */     } catch (Exception e) {
/* 229 */       this.log.error(e.getMessage());
/*     */     }
/* 231 */     return 0;
/*     */   }
/*     */ 
/*     */   public SubSystem selectById(Long id) {
/* 235 */     return this.subSystemDAO.selectById(id);
/*     */   }
/*     */ 
/*     */   public Object[] subSystemNameCheck(String subSystemName, Long subSystemId) {
/* 239 */     Object[] obj = new Object[2];
/* 240 */     if (StringUtil.isBlank(subSystemName)) {
/* 241 */       obj[0] = Boolean.valueOf(false);
/* 242 */       obj[1] = EnumSubSystemError.SUB_SYSTEM_NAME_EMPTY.getErrorMessage();
/* 243 */       return obj;
/*     */     }
/* 245 */     if (!subSystemName.matches("[0-9a-zA-Z]+")) {
/* 246 */       obj[0] = Boolean.valueOf(false);
/* 247 */       obj[1] = EnumSubSystemError.SUB_SYSTEM_NAME_INVALID.getErrorMessage();
/* 248 */       return obj;
/*     */     }
/* 250 */     int count = this.subSystemDAO.getSubSystemCountByName(subSystemName, subSystemId);
/* 251 */     if (count > 0) {
/* 252 */       obj[0] = Boolean.valueOf(false);
/* 253 */       obj[1] = EnumSubSystemError.SUB_SYSTEM_NAME_EXIST.getErrorMessage();
/* 254 */       return obj;
/*     */     }
/* 256 */     obj[0] = Boolean.valueOf(true);
/* 257 */     obj[1] = "";
/* 258 */     return obj;
/*     */   }
/*     */ 
/*     */   public Object[] subSystemFullNameCheck(String subSystemFullName, Long subSystemId) {
/* 262 */     Object[] obj = new Object[2];
/* 263 */     if (StringUtil.isBlank(subSystemFullName)) {
/* 264 */       obj[0] = Boolean.valueOf(false);
/* 265 */       obj[1] = EnumSubSystemError.SUB_SYSTEM_FULL_NAME_EMPTY.getErrorMessage();
/* 266 */       return obj;
/*     */     }
/* 268 */     int count = this.subSystemDAO.getSubSystemCountByFullName(subSystemFullName, subSystemId);
/* 269 */     if (count > 0) {
/* 270 */       obj[0] = Boolean.valueOf(false);
/* 271 */       obj[1] = EnumSubSystemError.SUB_SYSTEM_FULL_NAME_EXIST.getErrorMessage();
/* 272 */       return obj;
/*     */     }
/* 274 */     obj[0] = Boolean.valueOf(true);
/* 275 */     obj[1] = "";
/* 276 */     return obj;
/*     */   }
/*     */ 
/*     */   public boolean checkSubSystemNames(String subSystemName, String subSystemFullName, Long subSystemId, Model model) {
/* 280 */     boolean temp = true;
/*     */ 
/* 282 */     Object[] checkName = subSystemNameCheck(subSystemName, subSystemId);
/* 283 */     Object[] checkFullName = subSystemFullNameCheck(subSystemFullName, subSystemId);
/*     */ 
/* 286 */     if (!((Boolean)checkName[0]).booleanValue()) {
/* 287 */       model.addAttribute("subSystemNameError", checkName[1]);
/* 288 */       temp = false;
/*     */     }
/* 290 */     if (!((Boolean)checkFullName[0]).booleanValue()) {
/* 291 */       model.addAttribute("subSystemFullNameError", checkFullName[1]);
/* 292 */       temp = false;
/*     */     }
/* 294 */     return temp;
/*     */   }
/*     */ 
/*     */   public boolean checkChildAuth(SubSystem subSystem, Model model) {
/* 298 */     boolean temp = true;
/* 299 */     SubSystem oldSubSystem = this.subSystemDAO.selectById(subSystem.getId());
/*     */ 
/* 301 */     if ((EnumSubSystemOpenType.PAGE_EMBEDDED.getCode() == oldSubSystem.getOpenType().shortValue()) && (EnumSubSystemOpenType.PAGE_EMBEDDED.getCode() != subSystem.getOpenType().shortValue())) {
/* 302 */       int count = this.authorityService.getChildrenCountOfSubSystem(subSystem.getId());
/* 303 */       if (count > 0) {
/* 304 */         temp = false;
/* 305 */         model.addAttribute("subSystemOpenTypeError", EnumSubSystemError.SUB_SYSTEM_HAS_CHILD_AUTH.getErrorMessage());
/*     */       }
/*     */     }
/* 308 */     return temp;
/*     */   }
/*     */   @Transactional
/*     */   public void modifyStatus(Long subSystemId, Short status, UserAgent user) {
/* 313 */     this.log.info("SubSystemServiceImpl.modifyStatus method");
/*     */     try {
/* 315 */       SubSystem subSystem = this.subSystemDAO.selectById(subSystemId);
/* 316 */       subSystem.setStatus(status);
/* 317 */       this.subSystemDAO.update(subSystem);
/*     */ 
/* 319 */       Authority authority = this.authorityService.selectAuthorityBySubSystemId(subSystemId);
/* 320 */       authority.setStatus(status);
/* 321 */       this.authorityService.updateAuthority(authority);
/*     */ 
/* 324 */       if (status.shortValue() == EnumSubSystemStatus.ENABLE.getCode()) {
/* 325 */         this.workLogService.addWorkLog("启用子系统", "子系统ID:" + subSystem.getId() + ",name:'" + subSystem.getFullName() + "'启用子系统成功", user);
/* 326 */         this.workLogService.addWorkLog("启用子系统", "子系统权限ID:" + authority.getId() + ",name:'" + authority.getName() + "'启用子系统成功", user);
/* 327 */       } else if (status.shortValue() == EnumSubSystemStatus.DISABLE.getCode()) {
/* 328 */         this.workLogService.addWorkLog("禁用子系统", "子系统ID:" + subSystem.getId() + ",name:'" + subSystem.getFullName() + "'禁用子系统成功", user);
/* 329 */         this.workLogService.addWorkLog("禁用子系统", "子系统权限ID:" + authority.getId() + ",name:'" + authority.getName() + "'禁用子系统成功", user);
/*     */       }
/*     */     } catch (Exception e) {
/* 332 */       this.log.error(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public SubSystem getSubsystemByCode(String systemCode)
/*     */   {
/* 338 */     return this.subSystemDAO.selectByCode(systemCode);
/*     */   }
/*     */ 
/*     */   public void modifyPosition(final Long subSystemId, final String flag, final UserAgent user)
/*     */   {
/* 344 */     this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public String doInTransaction(TransactionStatus status) {
/* 347 */         if (subSystemId != null) {
/* 348 */           SubSystem subSys = SubSystemServiceImpl.this.subSystemDAO.selectById(subSystemId);
/* 349 */           SubSystem subsystem = null;
/* 350 */           String str = "上移";
/* 351 */           if ("up".equalsIgnoreCase(flag))
/*     */           {
/* 354 */             Long upId = SubSystemServiceImpl.this.subSystemDAO.getUpSubSystemId(subSystemId);
/* 355 */             if (upId != null) {
/* 356 */               subsystem = SubSystemServiceImpl.this.subSystemDAO.selectById(upId);
/*     */             }
/* 358 */             str = "上移";
/* 359 */           } else if ("dw".equalsIgnoreCase(flag))
/*     */           {
/* 362 */             Long downId = SubSystemServiceImpl.this.subSystemDAO.getDownSubSystemId(subSystemId);
/* 363 */             if (downId != null) {
/* 364 */               subsystem = SubSystemServiceImpl.this.subSystemDAO.selectById(downId);
/*     */             }
/* 366 */             str = "下移";
/*     */           }
/* 368 */           if ((subSys != null) && (subsystem != null)) {
/* 369 */             Short sort = subSys.getSort();
/*     */ 
/* 371 */             if (sort.intValue() != subsystem.getSort().intValue())
/*     */             {
/* 373 */               subSys.setSort(subsystem.getSort());
/* 374 */               subsystem.setSort(sort);
/*     */ 
/* 376 */               if ((SubSystemServiceImpl.this.subSystemDAO.update(subsystem) > 0) && (SubSystemServiceImpl.this.subSystemDAO.update(subSys) > 0))
/*     */               {
/* 378 */                 SubSystemServiceImpl.this.workLogService.addWorkLog("子系统" + str, "子系统ID:" + user.getId() + ",name:'" + user.getName() + "子系统" + str + "成功", user);
/*     */               }
/*     */               else {
/* 381 */                 SubSystemServiceImpl.this.workLogService.addWorkLog("子系统" + str, "子系统ID:" + user.getId() + ",name:'" + user.getName() + "子系统" + str + "失败", user);
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 388 */         return null;
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.sys.impl.SubSystemServiceImpl
 * JD-Core Version:    0.6.0
 */