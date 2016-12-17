/*     */ package com.hundsun.network.gates.genshan.common;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public enum PermissionEnum
/*     */ {
/*  31 */   USER_R_LIST(12002, "前台会员管理"), 
/*  32 */   USER_R_ACCOUNT_QUERY(12003, "查看会员资料"), 
/*  33 */   USER_R_ADDRESS_QUERY(12004, "查看会员地址"), 
/*  34 */   USER_U_PASSWORD(12005, "重置用户密码"), 
/*  35 */   USER_U_STATUS(12006, "启用禁用用户"), 
/*  36 */   USER_R_CREDIT(12007, "查看会员信用信息"), 
/*  37 */   USER_R_AUDIT_LIST(12011, "会员审核管理"), 
/*  38 */   USER_R_AUDIT(12012, "会员审核"), 
/*  39 */   USER_C_SYSTEM_MESSAGE(12021, "发送站内信"), 
/*  40 */   USER_R_SYSTEM_MESSAGE_LIST(12022, "站内信管理"), 
/*  41 */   USER_D_SYSTEM_MESSAGE_DELETE(12023, "删除站内信"), 
/*  42 */   USER_R_SYSTEM_MESSAGE_VIEW(12024, "查看站内信"), 
/*  43 */   USER_R_SYSTEM_MESSAGE_MORE(12025, "显示更多的站内信收件人"), 
/*  44 */   USER_D_SYSTEM_MESSAGE_ALLDELETE(12026, "删除某封站内信使所有用户不再看到"), 
/*  45 */   USER_R_FIND_RECEIVE(12027, "查找收件人"), 
/*     */ 
/*  51 */   PRO_R_PROJECT_LISTING_LIST(13001, "查询挂牌项目"), 
/*  52 */   PRO_R_PROJECT_LISTING_INFO(13002, "查看挂牌详细"), 
/*  53 */   PRO_U_PROJECT_LISTING_AUDIT(13003, "挂牌审核操作"), 
/*  54 */   PRO_U_PROJECT_LISTING_EDIT(13004, "修改挂牌资料"), 
/*  55 */   PRO_U_PROJECT_LISTING_SUSPENSION(13005, "停牌"), 
/*  56 */   PRO_U_PROJECT_LISTING_WITHDRAWAL(13006, "撤牌"), 
/*  57 */   PRO_U_PROJECT_LISTING_RESUMPTION(13007, "复牌"), 
/*  58 */   PRO_U_PROJECT_AUCTION(13008, "拍卖挂牌项目激活"), 
/*     */ 
/*  60 */   PRO_U_PROJECT_AUCTION_BIDHIS(13100, "拍卖历史报价记录"), 
/*     */ 
/*  62 */   ORDER_C_TRANSFER_INPUT(13101, "录入协议转让结果"), 
/*  63 */   ORDER_C_TENDER_INPUT(13102, "录入招标转让结果"), 
/*     */ 
/*  65 */   SCREEN_R_LIST(13200, "大屏展示列表"), 
/*  66 */   SCREEN_C_ADD(13201, "新增大屏展示"), 
/*  67 */   SCREEN_U_EDIT(13202, "编辑大屏展示"), 
/*  68 */   SCREEN_D_DEL(13203, "删除大屏展示"), 
/*     */ 
/*  73 */   S_BASESET(14000, "系统基础设置"), 
/*  74 */   S_B_TYPELIST(14100, "项目类型列表"), 
/*  75 */   S_B_TYPEADD(14101, "项目类型添加"), 
/*  76 */   S_B_TYPEEDIT(14102, "项目类型修改"), 
/*  77 */   S_B_TYPEOPEN(14103, "项目类型启用"), 
/*  78 */   S_B_TYPECLOSE(14104, "项目类型禁用"), 
/*  79 */   S_B_ATTRILIST(14105, "项目属性列表"), 
/*  80 */   S_B_ATTRIADD(14106, "项目属性添加"), 
/*  81 */   S_B_ATTRIEDIT(14107, "项目属性修改"), 
/*  82 */   S_B_ATTRIOPEN(14108, "项目属性启用"), 
/*  83 */   S_B_ATTRICLOSE(14109, "项目属性禁用"), 
/*     */ 
/*  86 */   S_B_MEMLEVSET(14150, "会员级别设置"), 
/*  87 */   S_B_MEMLEVSET_LIST(14151, "列表"), 
/*  88 */   S_B_MEMLEVSET_VIEW(14152, "查看"), 
/*  89 */   S_B_MEMLEVSET_ADD(14153, "添加"), 
/*  90 */   S_B_MEMLEVSET_UPDATE(14154, "更新"), 
/*     */ 
/*  92 */   S_B_MEMCREDITLEVEL(14160, "信用等级设置"), 
/*  93 */   S_B_MEMCREDITLEVEL_LIST(14161, "列表"), 
/*  94 */   S_B_MEMCREDITLEVEL_VIEW(14162, "查看"), 
/*  95 */   S_B_MEMCREDITLEVEL_ADD(14163, "添加"), 
/*  96 */   S_B_MEMCREDITLEVEL_UPDATE(14164, "更新"), 
/*     */ 
/*  98 */   S_B_SYSDICT(14170, "字典设置"), 
/*  99 */   S_B_SYSDICT_LIST(14171, "列表"), 
/* 100 */   S_B_SYSDICT_VIEW(14172, "查看"), 
/* 101 */   S_B_SYSDICT_ADD(14173, "添加"), 
/* 102 */   S_B_SYSDICT_UPDATE(14174, "更新"), 
/*     */ 
/* 104 */   S_B_SSCSSPECIAL(14180, "特殊服务费设置"), 
/* 105 */   S_B_SSCSSPECIAL_LIST(14181, "列表"), 
/* 106 */   S_B_SSCSSPECIAL_VIEW(14182, "查看"), 
/* 107 */   S_B_SSCSSPECIAL_ADD(14183, "添加"), 
/* 108 */   S_B_SSCSSPECIAL_UPDATE(14184, "更新"), 
/*     */ 
/* 110 */   S_B_COMSSPECIAL(14190, "通用服务费设置"), 
/* 111 */   S_B_COMSPECIAL_UPDATE(14191, "修改"), 
/*     */ 
/* 113 */   S_B_USERLEVEL(14200, "会员级别管理"), 
/* 114 */   S_B_USERLEVEL_LIST(14201, "列表"), 
/* 115 */   S_B_USERLEVEL_VIEW(14202, "查看"), 
/* 116 */   S_B_USERLEVEL_ADD(14203, "添加"), 
/* 117 */   S_B_USERLEVEL_UPDATE(14204, "更新"), 
/*     */ 
/* 119 */   S_B_USERCREDIT(14210, "会员信用管理"), 
/* 120 */   S_B_USERCREDIT_LIST(14211, "列表"), 
/* 121 */   S_B_USERCREDIT_VIEW(14212, "查看"), 
/* 122 */   S_B_USERCREDIT_ADD(14213, "添加"), 
/* 123 */   S_B_USERCREDIT_UPDATE(14214, "更新"), 
/*     */ 
/* 126 */   S_B_STANDARD(14300, "标准规格管理"), 
/* 127 */   S_B_STANDARD_LIST(14301, "列表"), 
/* 128 */   S_B_STANDARD_VIEW(14302, "查看"), 
/* 129 */   S_B_STANDARD_ADD(14303, "添加"), 
/* 130 */   S_B_STANDARD_UPDATE(14304, "更新"), 
/*     */ 
/* 132 */   S_B_BSET(14400, "设置审核流程-保证金"), 
/* 133 */   S_B_BSET_LIST(14401, "列表"), 
/* 134 */   S_B_BSET_VIEW(14402, "查看"), 
/* 135 */   S_B_BSET_ADD(14403, "添加"), 
/* 136 */   S_B_BSET_UPDATE(14404, "更新"), 
/*     */ 
/* 138 */   SYS_R_BASEDAY_LIST(14501, "交易日列表"), 
/* 139 */   SYS_U_BASEDAY_UPDATE(14502, "交易日设置"), 
/* 140 */   SYS_C_BASEDAY_INIT(14503, "交易日初始化"), 
/*     */ 
/* 142 */   SYS_C_BASEPHASE_ADD(14601, "新增交易节"), 
/* 143 */   SYS_C_BASEPHASE_MODIFY(14602, "修改交易节"), 
/* 144 */   SYS_U_BASEPHASE_DEL(14603, "删除交易节"), 
/* 145 */   SYS_C_BASEPHASE_ENABLE(14604, "启用交易节"), 
/* 146 */   SYS_C_BASEPHASE_DISABLE(14605, "禁用交易节"), 
/* 147 */   SYS_R_BASEPHASE_LIST(14606, "当前交易日有效交易节列表"), 
/* 148 */   SYS_R_BASEPHASE_NEXT(14607, "下个交易日有效交易节列表"), 
/*     */ 
/* 152 */   ORDER_R_LIST(15001, "订单列表"), 
/* 153 */   ORDER_R_DETAIL(15002, "订单详情"), 
/* 154 */   ORDER_U_CHECK_GOODS(15003, "确认收货"), 
/* 155 */   ORDER_U_CHECK_TICKET(15004, "确认收票"), 
/*     */ 
/* 160 */   OPR_R_ANNOUNCEMENT_LIST(17001, "公告管理"), 
/* 161 */   OPR_R_ANNOUNCEMENT_INFO(17002, "查看公告详情"), 
/* 162 */   OPR_C_ANNOUNCEMENT_ADD(17003, "新增系统公告"), 
/* 163 */   OPR_D_ANNOUNCEMENT_DEL(17004, "删除系统公告"), 
/* 164 */   OPR_U_ANNOUNCEMENT_JOIN_PRO(17005, "公告关联项目"), 
/* 165 */   OPR_U_ANNOUNCEMENT_LEAVE_PRO(17006, "公告取消关联项目"), 
/* 166 */   OPR_U_ANNOUNCEMENT_NORMAL(17007, "发布公告"), 
/* 167 */   OPR_U_ANNOUNCEMENT_EDIT(17008, "修改公告"), 
/*     */ 
/* 170 */   COM_R_LIST(17009, "投诉单列表"), 
/* 171 */   COM_U_REPLAY(17010, "投诉单回复"), 
/* 172 */   COM_R_DETAIL(17011, "投诉单详情"), 
/* 173 */   COM_U_DEAL(17012, "投诉单处理"), 
/*     */ 
/* 176 */   COM_U_TIMERTASK_LIST(17030, "定时器列表"), 
/* 177 */   COM_U_TIMERTASK_DO(17031, "定时器任务执行"), 
/*     */ 
/* 179 */   SUBSTATION_R_LIST(17032, "交易分中心管理"), 
/* 180 */   SUBSTATION_D_DEL(17033, "删除交易分中心"), 
/* 181 */   SUBSTATION_C_ADD(17034, "新增交易分中心"), 
/* 182 */   SUBSTATION_U_EDIT(17035, "修改交易分中心"), 
/*     */ 
/* 184 */   FINANCING_R_LIST(17036, "融资管理"), 
/* 185 */   FINANCING_C_ADD(17037, "新增融资项目"), 
/* 186 */   FINANCING_D_DEL(17038, "删除融资项目"), 
/* 187 */   FINANCING_U_EDIT(17039, "修改融资项目"), 
/* 188 */   FINANCING_U_AUDIT1(17040, "融资项目初审"), 
/* 189 */   FINANCING_U_AUDIT2(17041, "融资项目复审"), 
/* 190 */   FINANCING_U_LOAN(17042, "融资项目放款操作"), 
/* 191 */   FINANCING_U_REPAY(17043, "融资项目还款操作"), 
/*     */ 
/* 195 */   WIH_R_SELL_LIST(18001, "销售意向单列表"), 
/* 196 */   WIH_R_BUY_LIST(18002, "采购意向单列表"), 
/* 197 */   WIH_R_DETAIL(18003, "意向单详情"), 
/* 198 */   WIH_U_AUDIT(18004, "意向单审核"), 
/*     */ 
/* 202 */   FUND_QUERY_R_SETTLENT_LIST(19001, "用户资金信息"), 
/* 203 */   FUND_QUERY_R_ACCOUNTMSG_LIST(19002, "用户资金操作明细"), 
/* 204 */   FUND_QUERY_R_REPORT_LIST(19003, "用户资金情况查询"), 
/* 205 */   FUND_QUERY_R_LOG_LIST(19004, "结算查询"), 
/* 206 */   FUND_QUERY_R_PLATSETTLENT_LIST(19005, "平台结算查询"), 
/* 207 */   FUND_IN_U_FOR_USER(19006, "后台给交易账号入金"), 
/* 208 */   FUND_OUT_U_FOR_USER(19007, "后台给交易账号出金"), 
/*     */ 
/* 213 */   AUCTIONEER_QUERY_R_LIST(20001, "拍卖师管理列表"), 
/* 214 */   AUCTIONEER_C_ADD(20002, "增加拍卖师"), 
/* 215 */   AUCTIONEER_R_INFO(20003, "查看拍卖师信息"), 
/* 216 */   AUCTIONEER_U_PASSWORD_CHANGE(20004, "重置拍卖师密码"), 
/* 217 */   AUCTIONEER_U_STATUS_CHANGE(20005, "启用禁用拍卖师"), 
/*     */ 
/* 221 */   REVIEWER_QUERY_R_LIST(21001, "评审员管理列表"), 
/* 222 */   REVIEWER_C_ADD(21002, "增加评审员"), 
/* 223 */   REVIEWER_R_INFO(21003, "查看评审员信息"), 
/* 224 */   REVIEWER_U_PASSWORD_CHANGE(21004, "重置评审员密码"), 
/* 225 */   REVIEWER_U_STATUS_CHANGE(21005, "启用禁用评审员"), 
/*     */ 
/* 229 */   SUP_R_INFO_LIST(22001, "供求信息列表"), 
/* 230 */   SUP_U_INFO_AUDIT(22003, "审核供求信息"), 
/* 231 */   SUP_R_INFO_DETAIL(22004, "供求信息详情"), 
/* 232 */   SUP_U_INFO_DISABLE(22005, "禁用供求信息"), 
/* 233 */   ACCUSE_R_LIST(22002, "举报信息列表"), 
/* 234 */   ACCUSE_R_DETAIL(22006, "举报信息详情"), 
/* 235 */   ACCUSE_U_AUDIT(22007, "审核举报信息");
/*     */ 
/*     */   private static Map<Object, PermissionEnum> pool;
/*     */   private int code;
/*     */   private String desc;
/*     */ 
/*     */   private PermissionEnum(int code, String desc)
/*     */   {
/* 256 */     this.code = code;
/* 257 */     this.desc = desc;
/*     */   }
/*     */ 
/*     */   public int getCode()
/*     */   {
/* 266 */     return this.code;
/*     */   }
/*     */ 
/*     */   public String getDesc() {
/* 270 */     return this.desc;
/*     */   }
/*     */ 
/*     */   public static PermissionEnum indexOf(int code)
/*     */   {
/* 275 */     return (PermissionEnum)pool.get(Integer.valueOf(code));
/*     */   }
/*     */ 
/*     */   public static PermissionEnum indexOf(String name) {
/* 279 */     return (PermissionEnum)pool.get(name);
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 240 */     pool = new HashMap();
/*     */ 
/* 243 */     for (PermissionEnum each : values()) {
/* 244 */       PermissionEnum defined = (PermissionEnum)pool.get(Integer.valueOf(each.code));
/* 245 */       if (null != defined) {
/* 246 */         throw new IllegalArgumentException(defined.toString() + " defined as same code with " + each.toString());
/*     */       }
/*     */ 
/* 250 */       pool.put(Integer.valueOf(each.code), each);
/* 251 */       pool.put(each.name(), each);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.common.PermissionEnum
 * JD-Core Version:    0.6.0
 */