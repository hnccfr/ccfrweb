/*     */ package com.hundsun.network.hseccms.admin.security;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public enum PermissionEnum
/*     */ {
/*  12 */   CRM_MEMBER(1001, "会员管理"), 
/*  13 */   LIST_MEMBER(10011, "会员查询、查看"), 
/*  14 */   EDIT_MEMBER(10012, "会员信息修改"), 
/*  15 */   FREEZE_MEMBER(10013, "会员冻结、解冻"), 
/*  16 */   RESET_PWD_MEMBER(10014, "会员密码初始化"), 
/*  17 */   AUDIT_MEMBER(10015, "会员审核"), 
/*     */ 
/*  22 */   CRM_TRADE(1205, "订单管理"), 
/*  23 */   LIST_TRADE(12051, "查询订单"), 
/*  24 */   EDIT_TRADE(12052, "订单编辑"), 
/*  25 */   AUDIT_TRADE(12053, "订单受理"), 
/*     */ 
/*  31 */   CRM_USER(1501, "系统用户管理"), 
/*  32 */   LIST_CRM_USER(15011, "系统用户查询"), 
/*  33 */   EDIT_CRM_USER(15012, "系统用户新增、修改"), 
/*  34 */   FREEZE_CRM_USER(15013, "系统用户冻结、解冻"), 
/*  35 */   RESET_PWD_CRM_USER(15014, "系统用户密码初始化"), 
/*  36 */   SET_ROLE_CRM_USER(15015, "角色设置"), 
/*     */ 
/*  41 */   CRM_ROLE(1502, "系统角色管理"), 
/*  42 */   LIST_ROLE(15021, "系统角色查看"), 
/*  43 */   SET_PERMISSION(15022, "权限设置"), 
/*  44 */   ADD_ROLE(15023, "系统角色新增"), 
/*  45 */   EDIT_ROLE(15024, "系统角色修改"), 
/*  46 */   REMOVE_ROLE(15025, "系统角色删除"), 
/*     */ 
/*  51 */   WORKLOG(1503, "操作日志管理"), 
/*  52 */   LIST_WORKLOG(15031, "操作日志查询"), 
/*     */ 
/*  57 */   SYS_CONFIG(1504, "系统配置管理"), 
/*  58 */   LIST_CONFIG(15041, "系统配置查看"), 
/*  59 */   EDIT_CONFIG(15042, "系统配置修改"), 
/*     */ 
/*  64 */   YUNJIA(1600, "运价管理"), 
/*  65 */   DETAIL_YUNJIA(16001, "运价查看"), 
/*  66 */   AUDIT_YUNJIA(16002, "运价审核"), 
/*  67 */   LIST_YUNJIA(16003, "运价列表"), 
/*     */ 
/*  72 */   BILL_MANAGER(1900, "账单管理"), 
/*  73 */   BILL_AUDIT(19001, "账单审核"), 
/*  74 */   BILL_LIST(19002, "账单查看"), 
/*  75 */   RECEIPT_EDIT(19003, "账单发票修改"), 
/*     */ 
/*  80 */   NOTIFY_MANAGER(2000, "提醒管理"), 
/*  81 */   NOTIFY_LIST(2001, "账单查看"), 
/*     */ 
/*  83 */   CONT_MANAGE(10100, "文章管理"), 
/*  84 */   CONT_ADD(10101, "新增文章"), 
/*  85 */   CONT_EDIT(10102, "修改文章"), 
/*  86 */   CONT_DEL(10103, "删除文章"), 
/*  87 */   CONT_AUDIT(10104, "文章审核"), 
/*  88 */   CONT_MOVE(10105, "文章迁移"), 
/*  89 */   CONT_MANAGE_NOAUDIT(10900, "文章管理"), 
/*     */ 
/*  92 */   CHANNEL_MANAGE(20100, "栏目管理"), 
/*  93 */   CHANNEL_ADD(20101, "新增栏目"), 
/*  94 */   CHANNEL_EDIT(20102, "修改栏目"), 
/*  95 */   CHANNEL_SORT(20103, "栏目排序"), 
/*  96 */   CHANNEL_DEL(20104, "删除栏目"), 
/*     */ 
/*  98 */   SITE_MODIFY(30101, "站点设置"), 
/*     */ 
/* 100 */   ADV_MANAGE(40100, "广告管理"), 
/* 101 */   ADV_ADD(40101, "新增广告"), 
/* 102 */   ADV_EDIT(40102, "修改广告"), 
/* 103 */   ADV_DEL(40103, "删除广告"), 
/* 104 */   ADV_SWITCH(40104, "启用/禁用广告"), 
/*     */ 
/* 106 */   ADV_SPACE_MANAGE(40200, "广告版位管理"), 
/* 107 */   ADV_SPACE_ADD(40201, "新增广告版位"), 
/* 108 */   ADV_SPACE_EDIT(40202, "修改广告版位"), 
/* 109 */   ADV_SPACE_DEL(40203, "删除广告版位"), 
/*     */ 
/* 111 */   LINK_MANAGE(40300, "友情链接管理"), 
/* 112 */   LINK_ADD(40301, "新增友情链接"), 
/* 113 */   LINK_EDIT(40302, "修改友情链接"), 
/* 114 */   LINK_DEL(40303, "删除友情链接"), 
/* 115 */   LINK_SWITCH(40304, "启用/禁用友情链接"), 
/*     */ 
/* 117 */   LINK_CTG_MANAGE(40400, "友情链接类别管理"), 
/* 118 */   LINK_CTG_ADD(40401, "新增友情链接类别"), 
/* 119 */   LINK_CTG_EDIT(40402, "修改友情链接类别"), 
/* 120 */   LINK_CTG_DEL(40403, "删除友情链接类别"), 
/*     */ 
/* 127 */   TPL_MANAGE(60200, "模版管理"), 
/* 128 */   TPL_ADD(60201, "新增模版"), 
/* 129 */   TPL_EDIT(60202, "修改模版"), 
/* 130 */   TPL_DEL(60203, "删除模版"), 
/*     */ 
/* 132 */   RES_MANAGE(70200, "资源管理"), 
/* 133 */   RES_ADD(70201, "新增资源文件"), 
/* 134 */   RES_EDIT(70202, "修改资源文件"), 
/* 135 */   RES_DEL(70203, "删除资源文件"), 
/*     */ 
/* 138 */   LOG_LIST(71001, "操作日志"), 
/*     */ 
/* 140 */   MEMBER_CONTRIBUTE(71003, "会员组投稿权限"), 
/*     */ 
/* 143 */   SET_USER_SETP(72001, "用户权限管理"), 
/*     */ 
/* 147 */   JOB(73000, "实时任务"), 
/* 148 */   JOBTIMING(73001, "定时任务"), 
/* 149 */   HOMESTATIC(73002, "首页静态化"), 
/* 150 */   CHANNELSTATIC(73003, "栏目静态化"), 
/* 151 */   CONTENTSTATIC(73004, "内容静态化");
/*     */ 
/*     */   private static Map<Object, PermissionEnum> pool;
/*     */   private int code;
/*     */   private String desc;
/*     */ 
/*     */   private PermissionEnum(int code, String desc)
/*     */   {
/* 171 */     this.code = code;
/* 172 */     this.desc = desc;
/*     */   }
/*     */ 
/*     */   public int getCode()
/*     */   {
/* 181 */     return this.code;
/*     */   }
/*     */ 
/*     */   public String getDesc() {
/* 185 */     return this.desc;
/*     */   }
/*     */ 
/*     */   public static PermissionEnum indexOf(int code)
/*     */   {
/* 190 */     return (PermissionEnum)pool.get(Integer.valueOf(code));
/*     */   }
/*     */ 
/*     */   public static PermissionEnum indexOf(String name) {
/* 194 */     return (PermissionEnum)pool.get(name);
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 155 */     pool = new HashMap();
/*     */ 
/* 158 */     for (PermissionEnum each : values()) {
/* 159 */       PermissionEnum defined = (PermissionEnum)pool.get(Integer.valueOf(each.code));
/* 160 */       if (null != defined) {
/* 161 */         throw new IllegalArgumentException(defined.toString() + " defined as same code with " + each.toString());
/*     */       }
/*     */ 
/* 165 */       pool.put(Integer.valueOf(each.code), each);
/* 166 */       pool.put(each.name(), each);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.security.PermissionEnum
 * JD-Core Version:    0.6.0
 */