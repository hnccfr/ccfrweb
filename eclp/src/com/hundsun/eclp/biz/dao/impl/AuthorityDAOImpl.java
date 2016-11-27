/*     */ package com.hundsun.eclp.biz.dao.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.AuthorityDAO;
/*     */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.network.common.dao.BaseDAO;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("authorityDAO")
/*     */ public class AuthorityDAOImpl extends BaseDAO
/*     */   implements AuthorityDAO
/*     */ {
/*     */   private static final String SQLMAP_SPACE = "Authority.";
/*  24 */   private final Log _log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public List<Authority> selectAuthorityByParent(Long parentId, Short status)
/*     */   {
/*  29 */     Map map = new HashMap();
/*  30 */     map.put("parentId", parentId.toString());
/*  31 */     if (null != status) {
/*  32 */       map.put("status", status.toString());
/*     */     }
/*  34 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthorityByParent", map);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthorityByParentList(List<Long> parentIdList)
/*     */   {
/*  40 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthorityByParentList", parentIdList);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthorityByIdList(List<Long> idList)
/*     */   {
/*  46 */     if ((null == idList) || (idList.size() == 0)) {
/*  47 */       return null;
/*     */     }
/*  49 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthorityByIdList", idList);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthoritySubSys(Short status)
/*     */   {
/*  54 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthoritySubSys", status);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthorityAll(Short status)
/*     */   {
/*  60 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthorityAll", status);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthorityAllBySubSys(String subSystemId)
/*     */   {
/*  66 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthorityAllBySubSys", subSystemId);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthListBySubSys(Long subSystemId)
/*     */   {
/*  71 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthListBySubSys", subSystemId.toString());
/*     */   }
/*     */ 
/*     */   public int selectCountByParent(Long parentId, Short status)
/*     */   {
/*  78 */     Map map = new HashMap();
/*  79 */     map.put("parentId", parentId.toString());
/*  80 */     if (null != status) {
/*  81 */       map.put("status", status.toString());
/*     */     }
/*  83 */     return ((Integer)getSqlMapClientTemplate().queryForObject("Authority.selectCountByParent", map)).intValue();
/*     */   }
/*     */ 
/*     */   public Map<Long, Integer> selectCountByParentGroupByParent(List<Long> parentIdList, Short status)
/*     */   {
/*  88 */     Map map = new HashMap();
/*  89 */     map.put("parentIdList", parentIdList);
/*  90 */     if (null != status) {
/*  91 */       map.put("status", status.toString());
/*     */     }
/*  93 */     List<Map> list = getSqlMapClientTemplate().queryForList("Authority.selectCountByParentGroupByParent", map);
/*  94 */     Map result = new HashMap();
/*  95 */     for (Map mapTemp : list) {
/*  96 */       result.put(Long.valueOf(((BigDecimal)mapTemp.get("PARENT_ID")).longValue()), Integer.valueOf(((BigDecimal)mapTemp.get("ID_COUNT")).intValue()));
/*     */     }
/*  98 */     return result;
/*     */   }
/*     */ 
/*     */   public int selectUseCountByParent(Long parentId)
/*     */   {
/* 103 */     return ((Integer)getSqlMapClientTemplate().queryForObject("Authority.selectUseCountByParent", parentId)).intValue();
/*     */   }
/*     */ 
/*     */   public int selectCountBySubSys(Long subSystemId)
/*     */   {
/* 108 */     return ((Integer)getSqlMapClientTemplate().queryForObject("Authority.selectCountBySubSys", subSystemId)).intValue();
/*     */   }
/*     */ 
/*     */   public String selectAuthorityExist(Authority record)
/*     */   {
/* 113 */     String result = "";
/* 114 */     boolean existCode = false;
/* 115 */     boolean existName = false;
/* 116 */     List<Authority> list = getSqlMapClientTemplate().queryForList("Authority.selectAuthorityExist", record);
/* 117 */     if ((null != list) && (list.size() > 0)) {
/* 118 */       for (Authority authority : list) {
/* 119 */         if ((existCode) && (existName)) {
/*     */           break;
/*     */         }
/* 122 */         if (authority.getCode().intValue() == record.getCode().intValue()) {
/* 123 */           existCode = true;
/*     */         }
/* 125 */         if (authority.getName().equals(record.getName())) {
/* 126 */           existName = true;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 131 */     if ((!existCode) || (!existName))
/*     */     {
/* 133 */       if (!existCode)
/*     */       {
/* 135 */         if (existName)
/* 136 */           result = "同一父权限下“名称”重复！";
/*     */       }
/*     */     }
/* 139 */     return result;
/*     */   }
/*     */ 
/*     */   public void insertAuthority(Authority record)
/*     */   {
/* 144 */     if (record != null)
/* 145 */       getSqlMapClientTemplate().insert("Authority.insertAuthority", record);
/*     */   }
/*     */ 
/*     */   public int updateAuthority(Authority record)
/*     */   {
/* 151 */     if (record != null) {
/* 152 */       return getSqlMapClientTemplate().update("Authority.updateAuthority", record);
/*     */     }
/* 154 */     return 0;
/*     */   }
/*     */ 
/*     */   public int updateAuthoritySubSysByIdList(List<Long> idList, String subSystemId)
/*     */   {
/* 159 */     if ((null == idList) || (idList.size() < 1) || (null == subSystemId) || (subSystemId.equals(""))) {
/* 160 */       return 0;
/*     */     }
/* 162 */     Map map = new HashMap();
/* 163 */     map.put("subSystemId", subSystemId);
/* 164 */     map.put("idList", idList);
/* 165 */     return getSqlMapClientTemplate().update("Authority.updateAuthoritySubSysByIdList", map);
/*     */   }
/*     */ 
/*     */   public Authority selectAuthorityById(Long id)
/*     */   {
/* 170 */     if (id != null) {
/* 171 */       return (Authority)getSqlMapClientTemplate().queryForObject("Authority.selectAuthorityById", id);
/*     */     }
/* 173 */     return null;
/*     */   }
/*     */ 
/*     */   public int deleteAuthorityById(Long id)
/*     */   {
/* 178 */     if (id != null) {
/* 179 */       Authority auth = selectAuthorityById(id);
/* 180 */       if (auth != null) {
/* 181 */         return getSqlMapClientTemplate().update("Authority.updateAuthority", auth);
/*     */       }
/*     */     }
/* 184 */     return 0;
/*     */   }
/*     */ 
/*     */   public List<Authority> getChildrenOfSubSystem(Long subSystemId)
/*     */   {
/* 189 */     return getSqlMapClientTemplate().queryForList("Authority.getChildrenOfSubSystem", subSystemId);
/*     */   }
/*     */ 
/*     */   public int getChildrenCountOfSubSystem(Long subSystemId) {
/* 193 */     return ((Integer)getSqlMapClientTemplate().queryForObject("Authority.getChildrenCountOfSubSystem", subSystemId)).intValue();
/*     */   }
/*     */ 
/*     */   public List<Long> getChildrenIdsOfSubSystem(Long subSystemId)
/*     */   {
/* 198 */     return getSqlMapClientTemplate().queryForList("Authority.getChildrenIdsOfSubSystem", subSystemId);
/*     */   }
/*     */ 
/*     */   public int deleteAuthorityByIdList(List<Long> idList) {
/* 202 */     return getSqlMapClientTemplate().delete("Authority.deleteAuthorityByIdList", idList);
/*     */   }
/*     */ 
/*     */   public List<Integer> selectAuthorityByUserAndSubsystem(Users user, String subSystem)
/*     */   {
/* 208 */     Map map = new HashMap();
/* 209 */     map.put("userId", user.getId() + "");
/* 210 */     map.put("subSystem", subSystem);
/* 211 */     return getSqlMapClientTemplate().queryForList("Authority.selectAuthorityByUserAndSubsystem", map);
/*     */   }
/*     */ 
/*     */   public List<Integer> selectAllAuthorityByUserAndSubsystem(Users user, String subSystem)
/*     */   {
/* 217 */     Map map = new HashMap();
/* 218 */     map.put("userId", user.getId() + "");
/* 219 */     map.put("subSystem", subSystem);
/* 220 */     return getSqlMapClientTemplate().queryForList("Authority.selectAllAuthorityByUserAndSubsystem", map);
/*     */   }
/*     */ 
/*     */   public List<SubSystem> selectSubSystemAuthorityByUser(Users user)
/*     */   {
/* 226 */     return getSqlMapClientTemplate().queryForList("Authority.selectSubSystemAuthorityByUser", user);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectMenuByUserAndSubsystem(Long userid, String subSystemCode)
/*     */   {
/* 234 */     if ((userid == null) || (StringUtils.isBlank(subSystemCode))) {
/* 235 */       return null;
/*     */     }
/* 237 */     HashMap queryMap = new HashMap();
/* 238 */     queryMap.put("userId", userid);
/* 239 */     queryMap.put("subSystem", subSystemCode);
/* 240 */     return getSqlMapClientTemplate().queryForList("Authority.selectMenuByUserIdAndSubsystem", queryMap);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectMenuBySubsystem(Long sysId)
/*     */   {
/* 245 */     if (sysId == null) {
/* 246 */       return null;
/*     */     }
/* 248 */     return getSqlMapClientTemplate().queryForList("Authority.selectMenuBySubsystem", sysId);
/*     */   }
/*     */ 
/*     */   public short getMaxSort()
/*     */   {
/* 253 */     return ((Short)getSqlMapClientTemplate().queryForObject("Authority.getMaxSort")).shortValue();
/*     */   }
/*     */ 
/*     */   public Authority selectAuthorityBySubSystemId(Long subSystemId) {
/* 257 */     return (Authority)getSqlMapClientTemplate().queryForObject("Authority.selectAuthorityBySubSystemId", subSystemId);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthority(Authority auth)
/*     */   {
/* 263 */     if (auth != null) {
/* 264 */       return getSqlMapClientTemplate().queryForList("Authority.selectAuthority", auth);
/*     */     }
/* 266 */     return null;
/*     */   }
/*     */ 
/*     */   public List<Authority> selectCanAssginAuthList()
/*     */   {
/* 271 */     return getSqlMapClientTemplate().queryForList("Authority.selectCanAssignAuthorityAll");
/*     */   }
/*     */ 
/*     */   public List<Long> selectAuthByUserId(Long userId)
/*     */   {
/* 277 */     return getSqlMapClientTemplate().queryForList("Authority.selectByUserId", userId);
/*     */   }
/*     */ 
/*     */   public List<Long> selectAuthIdBySubsystemId(List<Long> idList)
/*     */   {
/* 288 */     if ((null == idList) || (idList.size() == 0)) {
/* 289 */       return null;
/*     */     }
/* 291 */     Map map = new HashMap();
/* 292 */     map.put("idList", idList);
/* 293 */     return getSqlMapClientTemplate().queryForList("Authority.selectBySubSystemId", map);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthListByRoleId(List<Long> roleIdList)
/*     */   {
/* 301 */     List list = new ArrayList();
/* 302 */     if ((roleIdList != null) && (roleIdList.size() > 0)) {
/* 303 */       list = getSqlMapClientTemplate().queryForList("Authority.selectAuthListByRoleIds", roleIdList);
/*     */     }
/* 305 */     return list;
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthListBySuperRoleId(List<Long> roleIdList)
/*     */   {
/* 311 */     List list = new ArrayList();
/* 312 */     if ((roleIdList != null) && (roleIdList.size() > 0)) {
/* 313 */       list = getSqlMapClientTemplate().queryForList("Authority.selectAuthListBySuperRoleIds", roleIdList);
/*     */     }
/* 315 */     return list;
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAllAuthByUserId(Long userId)
/*     */   {
/* 321 */     Map map = new HashMap();
/* 322 */     if (userId != null) {
/* 323 */       map.put("userId", userId);
/* 324 */       return getSqlMapClientTemplate().queryForList("Authority.selectAllAuthByUserId", map);
/*     */     }
/* 326 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.AuthorityDAOImpl
 * JD-Core Version:    0.6.0
 */