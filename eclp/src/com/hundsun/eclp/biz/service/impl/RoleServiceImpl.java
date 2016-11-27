/*     */ package com.hundsun.eclp.biz.service.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.RoleDAO;
/*     */ import com.hundsun.eclp.biz.domain.role.Role;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.query.UsersQuery;
/*     */ import com.hundsun.eclp.biz.service.RoleService;
/*     */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*     */ import com.hundsun.eclp.enums.EnumRoleError;
/*     */ import com.hundsun.eclp.enums.EnumRoleStatus;
/*     */ import com.hundsun.eclp.enums.EnumUsersType;
/*     */ import com.hundsun.network.common.query.QueryPage;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.ui.Model;
/*     */ 
/*     */ @Service("roleService")
/*     */ public class RoleServiceImpl
/*     */   implements RoleService
/*     */ {
/*  28 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private RoleDAO roleDAO;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogService workLogService;
/*     */ 
/*  38 */   public Role getRoleByUser(Users user) { return null; }
/*     */ 
/*     */   public List<Role> getRoleList(UserAgent user)
/*     */   {
/*  42 */     Role role = new Role();
/*  43 */     if (EnumUsersType.APPLICATION_LEVEL.getCode() == user.getUserType())
/*     */     {
/*  45 */       role.setIsCore(Short.valueOf((short) 0));
/*  46 */       return this.roleDAO.getRoleList(role);
/*     */     }
/*     */ 
/*  49 */     return getRoleList();
/*     */   }
/*     */ 
/*     */   public List<Role> getRoleList() {
/*  53 */     return this.roleDAO.getRoleList();
/*     */   }
/*     */   @Transactional
/*     */   public void modifyStatus(Long roleId, Short status, UserAgent user) {
/*  58 */     this.log.info("RoleServiceImpl.modifyStatus method");
/*     */     try {
/*  60 */       Role role = this.roleDAO.selectRoleById(roleId);
/*  61 */       role.setStatus(status);
/*  62 */       this.roleDAO.updateRole(role);
/*     */ 
/*  65 */       if (status.shortValue() == EnumRoleStatus.ENABLE.getCode())
/*  66 */         this.workLogService.addWorkLog("启用", "角色ID:" + role.getId() + ",name:'" + role.getDisplayName() + "'启用成功", user);
/*  67 */       else if (status.shortValue() == EnumRoleStatus.DISABLE.getCode())
/*  68 */         this.workLogService.addWorkLog("禁用", "角色ID:" + role.getId() + ",name:'" + role.getDisplayName() + "'禁用成功", user);
/*     */     }
/*     */     catch (Exception e) {
/*  71 */       this.log.error(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void deleteRole(Long roleId, UserAgent user) {
/*  76 */     this.log.info("RoleServiceImpl.deleteRole method");
/*     */     try {
/*  78 */       Role role = this.roleDAO.selectRoleById(roleId);
/*  79 */       role.setIsDeleted("Y");
/*  80 */       this.roleDAO.updateRole(role);
/*     */ 
/*  83 */       this.workLogService.addWorkLog("删除", "角色ID:" + role.getId() + ",name:'" + role.getDisplayName() + "'删除成功", user);
/*     */     } catch (Exception e) {
/*  85 */       this.log.error(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public Object[] roleCodeCheck(String code, Long roleId) {
/*  90 */     Object[] obj = new Object[2];
/*  91 */     if (StringUtil.isBlank(code)) {
/*  92 */       obj[0] = Boolean.valueOf(false);
/*  93 */       obj[1] = EnumRoleError.ROLE_CODE_EMPTY.getErrorMessage();
/*  94 */       return obj;
/*     */     }
/*  96 */     if (!code.matches("[0-9a-zA-Z_]+")) {
/*  97 */       obj[0] = Boolean.valueOf(false);
/*  98 */       obj[1] = EnumRoleError.ROLE_CODE_INVALID.getErrorMessage();
/*  99 */       return obj;
/*     */     }
/* 101 */     int count = this.roleDAO.getRoleCountByCode(code, roleId);
/* 102 */     if (count > 0) {
/* 103 */       obj[0] = Boolean.valueOf(false);
/* 104 */       obj[1] = EnumRoleError.ROLE_CODE_EXIST.getErrorMessage();
/* 105 */       return obj;
/*     */     }
/* 107 */     obj[0] = Boolean.valueOf(true);
/* 108 */     obj[1] = "";
/* 109 */     return obj;
/*     */   }
/*     */ 
/*     */   public Object[] roleDisplayNameCheck(String displayName, Long roleId) {
/* 113 */     Object[] obj = new Object[2];
/* 114 */     if (StringUtil.isBlank(displayName)) {
/* 115 */       obj[0] = Boolean.valueOf(false);
/* 116 */       obj[1] = EnumRoleError.ROLE_DISPLAY_NAME_EMPTY.getErrorMessage();
/* 117 */       return obj;
/*     */     }
/* 119 */     int count = this.roleDAO.getRoleCountByDisplayName(displayName, roleId);
/* 120 */     if (count > 0) {
/* 121 */       obj[0] = Boolean.valueOf(false);
/* 122 */       obj[1] = EnumRoleError.ROLE_DISPLAY_NAME_EXIST.getErrorMessage();
/* 123 */       return obj;
/*     */     }
/* 125 */     obj[0] = Boolean.valueOf(true);
/* 126 */     obj[1] = "";
/* 127 */     return obj;
/*     */   }
/*     */ 
/*     */   public boolean checkRole(String code, String displayName, Long roleId, Model model) {
/* 131 */     boolean temp = true;
/*     */ 
/* 133 */     Object[] checkCode = roleCodeCheck(code, roleId);
/* 134 */     Object[] checkDisplayName = roleDisplayNameCheck(displayName, roleId);
/*     */ 
/* 137 */     if (!((Boolean)checkCode[0]).booleanValue()) {
/* 138 */       model.addAttribute("roleCodeError", checkCode[1]);
/* 139 */       temp = false;
/*     */     }
/* 141 */     if (!((Boolean)checkDisplayName[0]).booleanValue()) {
/* 142 */       model.addAttribute("roleDisplayNameError", checkDisplayName[1]);
/* 143 */       temp = false;
/*     */     }
/* 145 */     return temp;
/*     */   }
/*     */ 
/*     */   public void insert(Role role, UserAgent user) {
/* 149 */     this.log.info("RoleServiceImpl.insert method");
/*     */     try {
/* 151 */       Long roleId = this.roleDAO.insertRole(role);
/*     */ 
/* 154 */       this.workLogService.addWorkLog("添加", "角色ID:" + roleId + ",name:'" + role.getDisplayName() + "'添加成功", user);
/*     */     }
/*     */     catch (Exception e) {
/* 157 */       this.log.error(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public Role getRoleById(Long roleId) {
/* 162 */     return this.roleDAO.selectRoleById(roleId);
/*     */   }
/*     */ 
/*     */   public void update(Role role, UserAgent user) {
/* 166 */     this.log.info("RoleServiceImpl.update method");
/*     */     try {
/* 168 */       this.roleDAO.updateRole(role);
/*     */ 
/* 171 */       this.workLogService.addWorkLog("更新", "角色ID:" + role.getId() + ",name:'" + role.getDisplayName() + "'更新成功", user);
/*     */     }
/*     */     catch (Exception e) {
/* 174 */       this.log.error(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public QueryPage getRoleByAuthId(UsersQuery query)
/*     */   {
/* 180 */     this.log.info("RoleServiceImpl.getRoleByAuthId method");
/*     */     try {
/* 182 */       return this.roleDAO.getRoleByAuthId(query);
/*     */     } catch (Exception e) {
/* 184 */       this.log.error(e.getMessage());
/* 185 */     }return null;
/*     */   }
/*     */ 
/*     */   public List<Role> getRoleByAuthId(Long authId)
/*     */   {
/* 191 */     this.log.info("RoleServiceImpl.getRoleByAuthId method");
/*     */     try {
/* 193 */       return this.roleDAO.getRoleByAuthId(authId);
/*     */     } catch (Exception e) {
/* 195 */       this.log.error(e.getMessage());
/* 196 */     }return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.RoleServiceImpl
 * JD-Core Version:    0.6.0
 */