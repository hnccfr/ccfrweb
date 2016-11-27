/*     */ package com.hundsun.eclp.biz.dao.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.UserInfoDAO;
/*     */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*     */ import com.hundsun.eclp.biz.query.UserInfoQuery;
/*     */ import com.hundsun.eclp.enums.EnumUserStatus;
/*     */ import com.hundsun.network.common.dao.BaseDAO;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("userInfoDao")
/*     */ public class UserInfoDAOImpl extends BaseDAO
/*     */   implements UserInfoDAO
/*     */ {
/*     */   public Long insert(UserInfo record)
/*     */   {
/*  19 */     if (record != null) {
/*  20 */       return (Long)getSqlMapClientTemplate().insert("ECLP_USER_INFO.INSERT", record);
/*     */     }
/*  22 */     return null;
/*     */   }
/*     */ 
/*     */   public List<UserInfo> selectAll(UserInfo record)
/*     */   {
/*  28 */     if (record != null) {
/*  29 */       return getSqlMapClientTemplate().queryForList("ECLP_USER_INFO.SELECT", record);
/*     */     }
/*  31 */     return null;
/*     */   }
/*     */ 
/*     */   public UserInfo selectByUserId(Long userid)
/*     */   {
/*  36 */     if (userid != null) {
/*  37 */       return (UserInfo)getSqlMapClientTemplate().queryForObject("ECLP_USER_INFO.SELECT_BY_USERID", userid);
/*     */     }
/*  39 */     return null;
/*     */   }
/*     */ 
/*     */   public int update(UserInfo record)
/*     */   {
/*  44 */     if (record != null) {
/*  45 */       return getSqlMapClientTemplate().update("ECLP_USER_INFO.UPDATE", record);
/*     */     }
/*  47 */     return 0;
/*     */   }
/*     */ 
/*     */   public int delete(Long userid)
/*     */   {
/*  52 */     if (userid != null) {
/*  53 */       UserInfo userinfo = selectById(userid);
/*  54 */       if (userinfo != null) {
/*  55 */         userinfo.setStatus(Short.valueOf(EnumUserStatus.DELETE_STATUS.getCode()));
/*  56 */         return getSqlMapClientTemplate().update("ECLP_USER_INFO.UPDATE", userinfo);
/*     */       }
/*     */     }
/*  59 */     return 0;
/*     */   }
/*     */ 
/*     */   public UserInfoQuery serarchByPage(UserInfoQuery query)
/*     */   {
/*  64 */     return query = (UserInfoQuery)getPagination(query, "ECLP_USER_INFO.selectCountAll", "ECLP_USER_INFO.selectAll");
/*     */   }
/*     */ 
/*     */   public UserInfo selectById(Long id)
/*     */   {
/*  69 */     if (id != null) {
/*  70 */       return (UserInfo)getSqlMapClientTemplate().queryForObject("ECLP_USER_INFO.SELECT_BY_ID", id);
/*     */     }
/*  72 */     return null;
/*     */   }
/*     */ 
/*     */   public int updateById(UserInfo record)
/*     */   {
/*  77 */     if (record != null) {
/*  78 */       return getSqlMapClientTemplate().update("ECLP_USER_INFO.UPDATEBYID", record);
/*     */     }
/*  80 */     return 0;
/*     */   }
/*     */   public int updateUserInfoById(UserInfo record) {
/*  83 */     if (record != null) {
/*  84 */       return getSqlMapClientTemplate().update("ECLP_USER_INFO.UPDATEBYID", record);
/*     */     }
/*  86 */     return 0;
/*     */   }
/*     */ 
/*     */   public int batchUpdateDept(List<UserInfo> userInfoList)
/*     */   {
/*  91 */     return executeBatchUpdate("ECLP_USER_INFO.UPDATE_DEPT", userInfoList);
/*     */   }
/*     */ 
/*     */   public Long getDowmUinfoId(Long uid)
/*     */   {
/*  96 */     return (Long)getSqlMapClientTemplate().queryForObject("ECLP_USER_INFO.getDowmUinfoId", uid);
/*     */   }
/*     */ 
/*     */   public Long getDowmUinfoId(Map<String, Object> map) {
/* 100 */     return (Long)getSqlMapClientTemplate().queryForObject("ECLP_USER_INFO.getDowmUinfoId", map);
/*     */   }
/*     */ 
/*     */   public Long getUpUinfoId(Long uid) {
/* 104 */     return (Long)getSqlMapClientTemplate().queryForObject("ECLP_USER_INFO.getUpUinfoId", uid);
/*     */   }
/*     */ 
/*     */   public Long getUpUinfoId(Map<String, Object> map) {
/* 108 */     return (Long)getSqlMapClientTemplate().queryForObject("ECLP_USER_INFO.getUpUinfoId", map);
/*     */   }
/*     */ 
/*     */   public int removeDeptId(Long uid) {
/* 112 */     if (uid != null) {
/* 113 */       return getSqlMapClientTemplate().update("ECLP_USER_INFO.UPDATEDEPT", uid);
/*     */     }
/* 115 */     return 0;
/*     */   }
/*     */ 
/*     */   public Long getMaxSort()
/*     */   {
/* 120 */     Long maxSort = (Long)getSqlMapClientTemplate().queryForObject("ECLP_USER_INFO.GETMAXSORT");
/* 121 */     if (maxSort != null) {
/* 122 */       return maxSort;
/*     */     }
/* 124 */     return Long.valueOf(0L);
/*     */   }
/*     */ 
/*     */   public int deleteById(Long userid)
/*     */   {
/* 129 */     if (userid != null) {
/* 130 */       return getSqlMapClientTemplate().update("ECLP_USER_INFO.DELETE", userid);
/*     */     }
/* 132 */     return 0;
/*     */   }
/*     */ 
/*     */   public UserInfoQuery selectUserInfo(UserInfoQuery query)
/*     */   {
/* 137 */     if (query != null) {
/* 138 */       return (UserInfoQuery)getPagination(query, "ECLP_USER_INFO.SELECT_USER_INFO_COUNT", "ECLP_USER_INFO.SELECT_USER_INFO");
/*     */     }
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   public UserInfo selectByAccount(String account)
/*     */   {
/* 146 */     if (StringUtil.isNotBlank(account)) {
/* 147 */       List usreList = getSqlMapClientTemplate().queryForList("ECLP_USER_INFO.SELECT_BY_ACCOUNT", account);
/* 148 */       if ((usreList != null) && (usreList.size() > 0)) {
/* 149 */         return (UserInfo)usreList.get(0);
/*     */       }
/*     */     }
/* 152 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.UserInfoDAOImpl
 * JD-Core Version:    0.6.0
 */