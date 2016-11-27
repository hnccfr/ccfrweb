/*     */ package com.hundsun.eclp.biz.service.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.OrgDAO;
/*     */ import com.hundsun.eclp.biz.dao.UserInfoDAO;
/*     */ import com.hundsun.eclp.biz.domain.dept.Department;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*     */ import com.hundsun.eclp.biz.service.OrgService;
/*     */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*     */ import com.hundsun.eclp.enums.EnumDeptStatus;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("orgService")
/*     */ public class OrgServiceImpl
/*     */   implements OrgService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   OrgDAO orgDAO;
/*     */ 
/*     */   @Autowired
/*     */   UserInfoDAO userInfoDao;
/*     */ 
/*     */   @Autowired
/*     */   TransactionTemplate transactionTemplate;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogService workLogService;
/*  35 */   protected Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   public Map<Long, Integer> getCountByParentGroupByParent(List<Long> parentIdList, Short status)
/*     */   {
/*     */     try
/*     */     {
/*  41 */       return this.orgDAO.getCountByParentGroupByParent(parentIdList, status);
/*     */     } catch (Exception e) {
/*  43 */       this.logger.error(e);
/*  44 */     }return null;
/*     */   }
/*     */ 
/*     */   public List<Department> getOrgList(Short status)
/*     */   {
/*     */     try
/*     */     {
/*  51 */       if (status != null) {
/*  52 */         return this.orgDAO.getOrgList(Long.valueOf(status.shortValue()));
/*     */       }
/*  54 */       return this.orgDAO.getOrgList(null);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       this.logger.error(e);
/*  58 */     }return null;
/*     */   }
/*     */ 
/*     */   public List<Department> getListAll(Short status)
/*     */   {
/*     */     try
/*     */     {
/*  65 */       if (status != null) {
/*  66 */         return this.orgDAO.getListAll(Long.valueOf(status.shortValue()));
/*     */       }
/*  68 */       return this.orgDAO.getListAll(null);
/*     */     }
/*     */     catch (Exception e) {
/*  71 */       this.logger.error(e);
/*  72 */     }return null;
/*     */   }
/*     */ 
/*     */   public String getFullNameById(Long id)
/*     */   {
/*     */     try
/*     */     {
/*  79 */       List<Department> deptList = this.orgDAO.getFullListById(id);
/*  80 */       StringBuffer sbf = new StringBuffer();
/*     */ 
/*  82 */       for (Department dept : deptList) {
/*  83 */         sbf.insert(0, "/" + dept.getName());
/*     */       }
/*     */ 
/*  86 */       return sbf.toString();
/*     */     } catch (Exception e) {
/*  88 */       this.logger.error(e);
/*  89 */     }return null;
/*     */   }
/*     */ 
/*     */   public int batchInsert(List<Department> list)
/*     */   {
/*  95 */     if ((list == null) || (list.isEmpty()))
/*  96 */       return 0;
/*     */     try
/*     */     {
/*  99 */       return this.orgDAO.batchInsert(list);
/*     */     } catch (Exception e) {
/* 101 */       this.logger.error(e);
/* 102 */     }return 0;
/*     */   }
/*     */ 
/*     */   public String insert(Department dept, UserAgent userAgent)
/*     */   {
/* 108 */     String message = null;
/*     */     try {
/* 110 */       if (dept != null) {
/* 111 */         if ((dept.getParentId() != null) && (dept.getParentId().longValue() != -1L)) {
/* 112 */           Department parentDept = this.orgDAO.getDepartmentById(dept.getParentId());
/*     */ 
/* 114 */           if (EnumDeptStatus.DISUSE.getCode() == parentDept.getStatus().shortValue())
/* 115 */             return "禁用的父组织结构[" + parentDept.getName() + "]下不可以添加子组织机构";
/*     */         }
/*     */         else {
/* 118 */           dept.setParentId(Long.valueOf(-1L));
/*     */         }
/* 120 */         Integer sort = this.orgDAO.getMaxSort(dept.getParentId());
/* 121 */         if (sort == null)
/* 122 */           dept.setSort(Short.valueOf((short) 1));
/*     */         else {
/* 124 */           dept.setSort(Short.valueOf(sort.shortValue()));
/*     */         }
/* 126 */         dept.setStatus(Short.valueOf(EnumDeptStatus.USE.getCode()));
/* 127 */         Long id = this.orgDAO.insert(dept);
/* 128 */         if (id == null) {
/* 129 */           return "新增组织机构失败";
/*     */         }
/* 131 */         this.workLogService.addWorkLog("新增组织机构", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "新增组织机构[" + dept.getName() + "]成功", userAgent);
/*     */       }
/*     */     } catch (Exception e) {
/* 134 */       this.logger.error(e);
/* 135 */       return message;
/*     */     }
/* 137 */     return message;
/*     */   }
/*     */ 
/*     */   public String edit(Department dept, UserAgent userAgent)
/*     */   {
/* 142 */     String message = null;
/* 143 */     if (dept != null) {
/*     */       try {
/* 145 */         if (dept.getParentId().longValue() == dept.getId().longValue()) {
/* 146 */           return "父组织机构不能为自己";
/*     */         }
/* 148 */         if ((dept.getParentId() != null) && (dept.getParentId().longValue() != -1L))
/*     */         {
/* 155 */           Department oldDept = this.orgDAO.getDepartmentById(dept.getId());
/* 156 */           if (oldDept.getParentId().shortValue() != dept.getParentId().shortValue())
/*     */           {
/* 158 */             List<Department> subList = this.orgDAO.getSubOrgList(dept.getId());
/* 159 */             List upSubList = new ArrayList();
/*     */ 
/* 161 */             if ((subList != null) && (subList.size() == 1))
/*     */             {
/* 163 */               for (Department department : subList) {
/* 164 */                 department.setParentId(oldDept.getParentId());
/* 165 */                 upSubList.add(department);
/*     */               }
/* 167 */               if (this.orgDAO.batchUpdate(upSubList) == 0)
/* 168 */                 return "组织机构更新失败";
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 174 */           dept.setParentId(Long.valueOf(-1L));
/*     */         }
/* 176 */         if (dept.getStatus() != null)
/*     */         {
/* 178 */           if (dept.getStatus().shortValue() == EnumDeptStatus.USE.getCode())
/*     */           {
/* 180 */             List<Department> deptList = this.orgDAO.getUpOrgList(dept.getId());
/* 181 */             if ((deptList != null) && (deptList.size() > 0))
/* 182 */               for (Department department : deptList) {
/* 183 */                 if (department.getId().longValue() == dept.getId().longValue()) {
/*     */                   continue;
/*     */                 }
/* 186 */                 if (department.getStatus().shortValue() == EnumDeptStatus.DISUSE.getCode())
/*     */                 {
/* 188 */                   return "该组织机构下存在禁用状态的父节点，不能启用";
/*     */                 }
/*     */               }
/*     */           }
/* 192 */           else if (dept.getStatus().shortValue() == EnumDeptStatus.DISUSE.getCode())
/*     */           {
/* 194 */             List<Department> deptList = this.orgDAO.getDownOrgList(dept.getId());
/* 195 */             if ((deptList != null) && (deptList.size() > 0)) {
/* 196 */               for (Department department : deptList) {
/* 197 */                 if (department.getId().longValue() == dept.getId().longValue()) {
/*     */                   continue;
/*     */                 }
/* 200 */                 if (department.getStatus().shortValue() == EnumDeptStatus.USE.getCode())
/*     */                 {
/* 202 */                   return "该组织机构下存在启用状态的子节点，不能禁用";
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 210 */         int row = this.orgDAO.edit(dept);
/* 211 */         if (row == 0) {
/* 212 */           return "组织机构更新失败";
/*     */         }
/* 214 */         this.workLogService.addWorkLog("更新组织机构", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "更新组织机构[" + dept.getName() + "]成功", userAgent);
/*     */       } catch (Exception e) {
/* 216 */         this.logger.error(e);
/* 217 */         return message;
/*     */       }
/*     */     }
/* 220 */     return message;
/*     */   }
/*     */ 
/*     */   public Department getDepartmentById(Long id)
/*     */   {
/* 225 */     if (id != null) {
/*     */       try {
/* 227 */         return this.orgDAO.getDepartmentById(id);
/*     */       } catch (Exception e) {
/* 229 */         this.logger.error(e);
/* 230 */         return null;
/*     */       }
/*     */     }
/* 233 */     return null;
/*     */   }
/*     */ 
/*     */   public String deleteOrgByIdList(List<Long> idList, UserAgent userAgent)
/*     */   {
/*     */     try
/*     */     {
/* 240 */       List<Department> deptList = this.orgDAO.getDeptListByIds(idList);
/* 241 */       if ((deptList != null) && (deptList.size() > 0)) {
				  boolean exist;
/* 242 */         for (Department dept : deptList) {
/* 243 */           this.logger.error("dept.getParentId().longValue() = " + dept.getParentId().longValue());
/*     */ 
/* 245 */           List<Department> subList = this.orgDAO.getSubOrgList(dept.getId());
/* 246 */           exist = false;
/* 247 */           if ((subList != null) && (subList.size() > 0))
/* 248 */             for (Department subDept : subList) {
/* 249 */               exist = false;
/* 250 */               for (Long id : idList) {
/* 251 */                 if (id.longValue() == subDept.getId().longValue()) {
/* 252 */                   exist = true;
/*     */                 }
/*     */               }
/* 255 */               if (!exist)
/* 256 */                 return "您欲删除的组织机构下存在子组织机构信息";
/*     */             }
/*     */         }
/*     */         
/* 262 */         UserInfo userinfo = new UserInfo();
/* 263 */         userinfo.setDeptList(idList);
/* 264 */         List userInfoList = this.userInfoDao.selectAll(userinfo);
/* 265 */         if ((userInfoList != null) && (userInfoList.size() > 0)) {
/* 266 */           return "exist";
/*     */         }
/*     */ 
/* 269 */         this.orgDAO.batchDelete(idList);
/* 270 */         this.workLogService.addWorkLog("删除组织机构", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "删除组织机构成功", userAgent);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 274 */       this.logger.error(e);
/* 275 */       return null;
/*     */     }
/* 277 */     return null;
/*     */   }
/*     */ 
/*     */   public String deleteOrgByIdList(final List<Long> idList,final Long deptId,final UserAgent userAgent)
/*     */   {
/* 284 */     return (String)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public String doInTransaction(TransactionStatus status)
/*     */       {
/* 288 */         UserInfo userinfo = new UserInfo();
/* 289 */         userinfo.setDeptList(idList);
/* 290 */         List<UserInfo> userInfoList = OrgServiceImpl.this.userInfoDao.selectAll(userinfo);
/* 291 */         List uinfoList = new ArrayList();
/* 292 */         if (deptId != null)
/*     */         {
/* 294 */           for (UserInfo uinfo : userInfoList) {
/* 295 */             uinfo.setDeptId(deptId);
/* 296 */             uinfoList.add(uinfo);
/*     */           }
/*     */         }
/*     */         else {
/* 300 */           for (UserInfo uinfo : userInfoList) {
/* 301 */             uinfo.setDeptId(null);
/* 302 */             uinfoList.add(uinfo);
/*     */           }
/*     */         }
/*     */ 
/* 306 */         int rows = OrgServiceImpl.this.userInfoDao.batchUpdateDept(userInfoList);
/* 307 */         OrgServiceImpl.this.logger.info("batch update rows===" + rows);
/*     */         try
/*     */         {
/* 310 */           rows = OrgServiceImpl.this.orgDAO.batchDelete(idList);
/* 311 */           OrgServiceImpl.this.workLogService.addWorkLog("删除组织机构", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "删除组织机构成功", userAgent);
/*     */         } catch (Exception e) {
/* 313 */           OrgServiceImpl.this.logger.error(e);
/* 314 */           return null;
/*     */         }
/* 316 */         OrgServiceImpl.this.logger.info("batch Delete rows===" + rows);
/*     */ 
/* 318 */         return null;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public List<Department> getDownOrgList(Long id) {
/* 325 */     if (id == null)
/* 326 */       return null;
/*     */     try
/*     */     {
/* 329 */       return this.orgDAO.getDownOrgList(id);
/*     */     } catch (Exception e) {
/* 331 */       this.logger.error(e);
/* 332 */     }return null;
/*     */   }
/*     */ 
/*     */   public List<Department> getUpOrgList(Long id)
/*     */   {
/* 338 */     if (id == null)
/* 339 */       return null;
/*     */     try
/*     */     {
/* 342 */       return this.orgDAO.getUpOrgList(id);
/*     */     } catch (Exception e) {
/* 344 */       this.logger.error(e);
/* 345 */     }return null;
/*     */   }
/*     */ 
/*     */   public List<Department> getRepeatDeptList(Department dept)
/*     */   {
/* 351 */     if (dept == null)
/* 352 */       return null;
/*     */     try
/*     */     {
/* 355 */       return this.orgDAO.getDeptList(dept);
/*     */     } catch (Exception e) {
/* 357 */       this.logger.error(e);
/* 358 */     }return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.OrgServiceImpl
 * JD-Core Version:    0.6.0
 */