/*     */ package com.hundsun.eclp.enums;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public enum PermissionEnum
/*     */ {
/*   8 */   SUPER_ADMIN(0, "超级管理员"), 
/*     */ 
/*  10 */   LOGIN_PLATFORM(10000, "登录平台"), 
/*     */ 
/*  12 */   USER_MANAGE(11000, "用户管理"), 
/*     */ 
/*  14 */   USER_INFO(11100, "用户信息"), 
/*  15 */   USER_ADD(11101, "新增用户"), 
/*  16 */   USER_EDIT(11102, "修改用户"), 
/*  17 */   USER_DEL(11103, "删除用户"), 
/*  18 */   USER_DISABLE(11104, "禁用用户"), 
/*  19 */   USER_ENABLE(11105, "启用用户"), 
/*  20 */   USER_ROLE_ASSIGN(11106, "分配角色"), 
/*  21 */   USER_PASS_RESET(11107, "重置密码"), 
/*  22 */   USER_VIEW_AUTH(11108, "查看/导出权限"), 
/*  23 */   USER_QUERY(11109, "用户查询"), 
/*     */ 
/*  25 */   STAFF_MANAGE(11200, "人员管理"), 
/*  26 */   STAFF_ADD(11201, "新增人员"), 
/*  27 */   STAFF_EDIT(11202, "修改人员"), 
/*  28 */   STAFF_DEL(11203, "删除人员"), 
/*  29 */   STAFF_DISABLE(11204, "禁止人员"), 
/*  30 */   STAFF_ENABLE(11205, "启用人员"), 
/*  31 */   STAFF_ASSIGN_USER(11206, "分配用户"), 
/*  32 */   STAFF_ASSIGN_ORG(11207, "分配机构"), 
/*     */ 
/*  34 */   ORGANIZATION_INFO(11300, "组织机构信息"), 
/*  35 */   ORG_ADD(11301, "新增组织机构"), 
/*  36 */   ORG_EDIT(11302, "修改组织机构"), 
/*  37 */   ORG_DEL(11303, "删除组织机构"), 
/*  38 */   ORG_ENABLE(11304, "启用组织机构"), 
/*  39 */   ORG_DISABLE(11305, "禁止组织机构"), 
/*     */ 
/*  41 */   RESOURCE_MANAGE(12000, "资源管理"), 
/*     */ 
/*  43 */   SUBSYSTEM_MANAGE(12100, "子系统管理"), 
/*  44 */   SUBSYSTEM_ADD(12101, "新增子系统"), 
/*  45 */   SUBSYSTEM_EDIT(12102, "修改子系统"), 
/*  46 */   SUBSYSTEM_DEL(12103, "删除子系统"), 
/*  47 */   SUBSYSTEM_ENABLE(12104, "启用子系统"), 
/*  48 */   SUBSYSTEM_DISABLE(12105, "禁止子系统"), 
/*     */ 
/*  50 */   ROLE_MANAGE(12200, "角色管理"), 
/*  51 */   ROLE_ADD(12201, "新增角色"), 
/*  52 */   ROLE_EDIT(12202, "修改角色"), 
/*  53 */   ROLE_DEL(12203, "删除角色"), 
/*  54 */   ROLE_ENABLE(12204, "启用角色"), 
/*  55 */   ROLE_DISABLE(12205, "禁止角色"), 
/*  56 */   ROLE_AUTHORIZATION(12206, "角色授权"), 
/*  57 */   ROLE_VIEW_USER(12207, "查询/导出用户"), 
/*  58 */   ROLE_QUERY(12208, "角色查询"), 
/*     */ 
/*  60 */   AUTH_INFO(12300, "权限信息"), 
/*  61 */   AUTH_ADD(12301, "新增权限"), 
/*  62 */   AUTH_EDIT(12302, "修改权限"), 
/*  63 */   AUTH_DEL(12303, "删除权限"), 
/*  64 */   AUTH_USER(12304, "查看/导出用户"), 
/*  65 */   AUTH_ROLE(12305, "查看/导出角色"), 
/*     */ 
/*  67 */   SYS_MANAGE(14000, "系统管理"), 
/*     */ 
/*  69 */   SYS_CONFIG(14100, "系统设置"), 
/*  70 */   SYS_MANAGE_EDIT(14101, "修改系统管理"), 
/*     */ 
/*  72 */   LOGIN_LOG(14200, "登陆日志"), 
/*  73 */   OPERATE_LOG(14300, "操作日志"), 
/*     */ 
/*  75 */   FUNC_CHECK(14500, "功能复核"), 
/*  76 */   FUNC_CHECK_ADD(14501, "新增功能复核"), 
/*  77 */   FUNC_CHECK_EDIT(14503, "编辑功能复核"), 
/*  78 */   FUNC_CHECK_DEL(14505, "功能复核删除"), 
/*  79 */   FUNC_CHECK_ENABLE(14507, "启用功能复核"), 
/*  80 */   FUNC_CHECK_DISABLE(14509, "禁止功能复核"), 
/*     */ 
/*  82 */   MENU_GROUP_PERFORM_MONITOR(15000, "运行监控"), 
/*     */ 
/*  84 */   MENU_PERFORM_MONITOR(15100, "运行监控"), 
/*     */ 
/*  87 */   CACHE_MA(16000, "缓存管理"), 
/*  88 */   SUB_SYS_CACHE_MA(16100, "子系统缓存");
/*     */ 
/*     */   private static Map<Object, PermissionEnum> pool;
/*     */   private int code;
/*     */   private String desc;
/*     */ 
/*     */   private PermissionEnum(int code, String desc)
/*     */   {
/* 109 */     this.code = code;
/* 110 */     this.desc = desc;
/*     */   }
/*     */ 
/*     */   public int getCode()
/*     */   {
/* 119 */     return this.code;
/*     */   }
/*     */ 
/*     */   public String getDesc() {
/* 123 */     return this.desc;
/*     */   }
/*     */ 
/*     */   public static PermissionEnum indexOf(int code)
/*     */   {
/* 128 */     return (PermissionEnum)pool.get(Integer.valueOf(code));
/*     */   }
/*     */ 
/*     */   public static PermissionEnum indexOf(String name) {
/* 132 */     return (PermissionEnum)pool.get(name);
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  93 */     pool = new HashMap();
/*     */ 
/*  96 */     for (PermissionEnum each : values()) {
/*  97 */       PermissionEnum defined = (PermissionEnum)pool.get(Integer.valueOf(each.code));
/*  98 */       if (null != defined) {
/*  99 */         throw new IllegalArgumentException(defined.toString() + " defined as same code with " + each.toString());
/*     */       }
/*     */ 
/* 103 */       pool.put(Integer.valueOf(each.code), each);
/* 104 */       pool.put(each.name(), each);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.PermissionEnum
 * JD-Core Version:    0.6.0
 */