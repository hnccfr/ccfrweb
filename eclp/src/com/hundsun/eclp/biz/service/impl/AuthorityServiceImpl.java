/*     */ package com.hundsun.eclp.biz.service.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.AuthorityDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleAuthorityDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleDAO;
/*     */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*     */ import com.hundsun.eclp.biz.dao.SubSystemDAO;
/*     */ import com.hundsun.eclp.biz.dao.sys.EclpSubSystemRegisterDAO;
/*     */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermission;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.common.Tree;
/*     */ import com.hundsun.eclp.common.TreeMaker;
/*     */ import com.hundsun.eclp.enums.EnumAuthStatus;
/*     */ import com.hundsun.eclp.enums.EnumAuthStatusDel;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityOpenType;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityType;
/*     */ import com.hundsun.eclp.enums.EnumIsCore;
/*     */ import com.hundsun.eclp.enums.EnumIsLeaf;
/*     */ import com.hundsun.eclp.enums.PermissionEnum;
/*     */ import com.hundsun.network.common.service.BaseService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ public class AuthorityServiceImpl extends BaseService
/*     */   implements AuthorityService
/*     */ {
/*     */   AuthorityDAO authorityDAO;
/*     */   RoleAuthorityDAO roleAuthorityDAO;
/*     */   SubSystemDAO subSystemDAO;
/*     */   TransactionTemplate transactionTemplate;
/*     */   RoleSystemDAO roleSystemDAO;
/*     */   RoleDAO roleDAO;
/*  57 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   EclpSubSystemRegisterDAO eclpSubSystemRegisterDAO;
/*     */ 
/*  61 */   public List<PermissionEnum> getPermissionListByUser(Users user, String subSystemCode) { List<Integer> permissionList = this.authorityDAO.selectAuthorityByUserAndSubsystem(user, subSystemCode);
/*  62 */     List list = new ArrayList();
/*  63 */     for (Integer permissionID : permissionList) {
/*  64 */       if (PermissionEnum.indexOf(permissionID.intValue()) != null) {
/*  65 */         list.add(PermissionEnum.indexOf(permissionID.intValue()));
/*     */       }
/*     */     }
/*  68 */     return list;
/*     */   }
/*     */ 
/*     */   public List<Integer> getSubsystemPermissionListByUser(Users user, String subSystemCode)
/*     */   {
/*  73 */     return this.authorityDAO.selectAuthorityByUserAndSubsystem(user, subSystemCode);
/*     */   }
/*     */ 
/*     */   public SubSystem getDefaultSubSystemByUser(Users user)
/*     */   {
/*  78 */     if ((user.getDefaultSubSys() != null) && (user.getDefaultSubSys().longValue() > 0L)) {
/*  79 */       return this.subSystemDAO.selectById(user.getDefaultSubSys());
/*     */     }
/*  81 */     List subSystemList = this.authorityDAO.selectSubSystemAuthorityByUser(user);
/*  82 */     if ((subSystemList != null) && (subSystemList.size() > 0)) {
/*  83 */       return (SubSystem)subSystemList.get(0);
/*     */     }
/*  85 */     subSystemList = this.roleSystemDAO.selectSystemByUserId(user.getId());
/*  86 */     if ((subSystemList != null) && (subSystemList.size() > 0)) {
/*  87 */       return (SubSystem)subSystemList.get(0);
/*     */     }
/*     */ 
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */   public List<Authority> getListSubSys(Short status) {
/*  95 */     return this.authorityDAO.selectAuthoritySubSys(status);
/*     */   }
/*     */ 
/*     */   public List<Authority> getListAll(Short status) {
/*  99 */     return this.authorityDAO.selectAuthorityAll(status);
/*     */   }
/*     */ 
/*     */   public List<Authority> getListBySubSystemParent(Long subSystemId, Long parentId, Short status) {
/* 103 */     return this.authorityDAO.selectAuthorityByParent(parentId, status);
/*     */   }
/*     */ 
/*     */   public List<Authority> getListByParentIdList(List<Long> idList) {
/* 107 */     return this.authorityDAO.selectAuthorityByIdList(idList);
/*     */   }
/*     */ 
/*     */   public int getCountBySubSystemParent(Long subSystemId, Long parentId, Short status) {
/* 111 */     return this.authorityDAO.selectCountByParent(parentId, status);
/*     */   }
/*     */ 
/*     */   public Map<Long, Integer> getCountByParentGroupByParent(List<Long> parentIdList, Short status) {
/* 115 */     this.logger.error("status = " + status);
/* 116 */     Map<Long,Integer> listParentSubNum = this.authorityDAO.selectCountByParentGroupByParent(parentIdList, status);
/* 117 */     for (Long parentId : listParentSubNum.keySet()) {
/* 118 */       Integer subNum = (Integer)listParentSubNum.get(parentId);
/* 119 */       this.logger.error("parentId = " + parentId.longValue() + "          subNum = " + subNum.intValue());
/*     */     }
/* 121 */     return listParentSubNum;
/*     */   }
/*     */ 
/*     */   public Authority getInfoById(Long id) {
/* 125 */     return this.authorityDAO.selectAuthorityById(id);
/*     */   }
/*     */ 
/*     */   public Authority getInfoAllById(Long id) {
/* 129 */     Authority authority = this.authorityDAO.selectAuthorityById(id);
/* 130 */     if ((null != authority) && (null != authority.getId()) && 
/* 131 */       (null != authority.getSubSystemId())) {
/* 132 */       authority.setSubSystem(this.authorityDAO.selectAuthorityById(Long.valueOf(Long.parseLong(authority.getSubSystemId()))));
/*     */ 
/* 134 */       if (authority.getParentId().longValue() != Authority.getRootFlag().longValue()) {
/* 135 */         authority.setParent(getParentById(authority.getParentId()));
/*     */       }
/*     */     }
/*     */ 
/* 139 */     return authority;
/*     */   }
/*     */ 
/*     */   private Authority getParentById(Long id)
/*     */   {
/* 148 */     Authority authority = null;
/* 149 */     if ((null != id) && (!id.equals(""))) {
/* 150 */       authority = this.authorityDAO.selectAuthorityById(id);
/* 151 */       if (authority.getParentId().longValue() != Authority.getRootFlag().longValue()) {
/* 152 */         authority.setParent(getParentById(authority.getParentId()));
/*     */       }
/*     */     }
/* 155 */     return authority;
/*     */   }
/*     */ 
/*     */   public String add(final Authority authority)
/*     */   {
/* 160 */     return (String)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public String doInTransaction(TransactionStatus status) {
/* 162 */         String result = "";
/*     */         try {
/* 164 */           Authority parent = AuthorityServiceImpl.this.authorityDAO.selectAuthorityById(Long.valueOf(authority.getParentId().longValue()));
/* 165 */           result = AuthorityServiceImpl.this.judgeFromChildAndParent(authority, parent);
/* 166 */           if (!result.equals("")) {
/* 167 */             return result;
/*     */           }
/*     */ 
/* 170 */           authority.setSubSystemId(parent.getSubSystemId());
/* 171 */           authority.setIsLeaf(Short.valueOf(EnumIsLeaf.LEAF.getCode()));
/* 172 */           authority.setIsDeleted(EnumAuthStatusDel.NORMAL.getCode());
/* 173 */           result = AuthorityServiceImpl.this.authorityDAO.selectAuthorityExist(authority);
/* 174 */           if (!result.equals("")) {
/* 175 */             return result;
/*     */           }
/* 177 */           AuthorityServiceImpl.this.authorityDAO.insertAuthority(authority);
/*     */ 
/* 179 */           if (parent.getIsLeaf().shortValue() == EnumIsLeaf.LEAF.getCode()) {
/* 180 */             parent.setIsLeaf(Short.valueOf(EnumIsLeaf.STALK.getCode()));
/* 181 */             AuthorityServiceImpl.this.authorityDAO.updateAuthority(parent);
/*     */           }
/*     */         } catch (Exception e) {
/* 184 */           status.setRollbackOnly();
/* 185 */           AuthorityServiceImpl.this.logger.error("", e);
/* 186 */           result = "未预期，请稍后再试！";
/*     */         }
/* 188 */         return result;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public String edit(final EnumIsCore userIsCore,final Authority authority) {
/* 195 */     return (String)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public String doInTransaction(TransactionStatus status) {
/* 197 */         String result = "";
/*     */         try
/*     */         {
/* 200 */           Authority authorityOld = AuthorityServiceImpl.this.authorityDAO.selectAuthorityById(Long.valueOf(authority.getId().longValue()));
/* 201 */           if ((userIsCore.getCode() == EnumIsCore.APPLICATION.getCode()) && (authorityOld.getIsCore().shortValue() == EnumIsCore.CORE.getCode()))
/*     */           {
/* 203 */             return "您无法修改核心数据！";
/* 204 */           }if ((userIsCore.getCode() == EnumIsCore.CORE.getCode()) && (authorityOld.getIsCore().shortValue() == EnumIsCore.BASE.getCode()))
/*     */           {
/* 206 */             return "您无法修改基础数据！";
/*     */           }
/*     */ 
/* 209 */           Authority parentNew = AuthorityServiceImpl.this.authorityDAO.selectAuthorityById(Long.valueOf(authority.getParentId().longValue()));
/* 210 */           result = AuthorityServiceImpl.this.judgeFromChildAndParent(authority, parentNew);
/* 211 */           if (!result.equals("")) {
/* 212 */             return result;
/*     */           }
/*     */ 
/* 215 */           authority.setSubSystemId(parentNew.getSubSystemId());
/* 216 */           result = AuthorityServiceImpl.this.authorityDAO.selectAuthorityExist(authority);
/* 217 */           if (!result.equals("")) {
/* 218 */             return result;
/*     */           }
/*     */ 
/* 221 */           if ((authorityOld.getType().shortValue() != authority.getType().shortValue()) && (
/* 222 */             (authorityOld.getType().shortValue() == EnumAuthorityType.MENU_BAR.getCode()) || (authorityOld.getType().shortValue() == EnumAuthorityType.MENU.getCode())))
/*     */           {
/* 224 */             if (AuthorityServiceImpl.this.authorityDAO.selectCountByParent(authorityOld.getId(), null) > 0) {
/* 225 */               return "权限存在子权限，不能修改权限类型！";
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 230 */           if (authorityOld.getStatus().shortValue() != authority.getStatus().shortValue()) {
/* 231 */             if (authorityOld.getStatus().shortValue() == EnumAuthStatus.USE.getCode())
/*     */             {
/* 233 */               if ((authority.getType().shortValue() != EnumAuthorityType.OPERATION.getCode()) && 
/* 234 */                 (AuthorityServiceImpl.this.authorityDAO.selectUseCountByParent(authority.getId()) > 0)) {
/* 235 */                 return "该权限存在未禁用的子权限，不能修改为禁用！";
/*     */               }
/*     */ 
/*     */             }
/* 240 */             else if (parentNew.getStatus().shortValue() == EnumAuthStatus.DISUSE.getCode()) {
/* 241 */               return "该权限的父权限权限状态为“禁用”，不能修改为启用！";
/*     */             }
/*     */           }
/*     */ 
/* 245 */           AuthorityServiceImpl.this.logger.error("authorityOld.getParentId().longValue() = " + authorityOld.getParentId().longValue());
/* 246 */           AuthorityServiceImpl.this.logger.error("authority.getParentId().longValue() = " + authority.getParentId().longValue());
/*     */ 
/* 248 */           if (authorityOld.getParentId().longValue() != authority.getParentId().longValue()) {
/* 249 */             AuthorityServiceImpl.this.logger.error("authorityOld.getSubSystemId() = " + authorityOld.getSubSystemId());
/* 250 */             AuthorityServiceImpl.this.logger.error("authority.getSubSystemId() = " + authority.getSubSystemId());
/* 251 */             if (authorityOld.getSubSystemId().equals(authority.getSubSystemId()))
/*     */             {
/* 253 */               List<Authority> list = AuthorityServiceImpl.this.authorityDAO.selectAuthorityAllBySubSys(authorityOld.getSubSystemId());
/*     */ 
/* 256 */               List listTree = new ArrayList();
/* 257 */               for (Authority authority : list) {
/* 258 */                 Tree tree = new Tree(authority.getId().toString(), authority.getParentId().toString(), authority.getName(), authority.getType().toString(), authority.getSort().intValue(), true);
/*     */ 
/* 264 */                 listTree.add(tree);
/*     */               }
/* 266 */               TreeMaker treeMaker = new TreeMaker(listTree, authorityOld.getSubSystemId());
/*     */ 
/* 268 */               List<String> listSubIds = treeMaker.getSubIdList(authorityOld.getId().toString());
/* 269 */               AuthorityServiceImpl.this.logger.error("authorityOld.getParentId() = " + authorityOld.getParentId());
/* 270 */               AuthorityServiceImpl.this.logger.error("authority.getParentId() = " + authority.getParentId());
/* 271 */               if (null != listSubIds) {
/* 272 */                 for (String subId : listSubIds) {
/* 273 */                   AuthorityServiceImpl.this.logger.error("subId = " + subId);
/* 274 */                   if (subId.equals(authority.getParentId().toString())) {
/* 275 */                     return "父权限不能是当前权限的子权限！";
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/* 282 */           if ((authorityOld.getType().shortValue() == authority.getType().shortValue()) && (authority.getType().shortValue() == EnumAuthorityType.MENU.getCode()) && (authority.getOpenType().shortValue() == EnumAuthorityOpenType.OUTER.getCode()) && (authorityOld.getOpenType().shortValue() == EnumAuthorityOpenType.INNER.getCode()))
/*     */           {
/* 286 */             if (AuthorityServiceImpl.this.authorityDAO.selectUseCountByParent(authority.getId()) > 0) {
/* 287 */               return "该权限下存在子权限不能修改打开方式为“弹出”！";
/*     */             }
/*     */           }
/*     */ 
/* 291 */           if ((authorityOld.getType().shortValue() != EnumAuthorityType.OPERATION.getCode()) && 
/* 292 */             (!authorityOld.getSubSystemId().equals(authority.getSubSystemId()))) {
/* 293 */             List idList = new ArrayList();
/*     */ 
/* 295 */             List<Authority> subList = AuthorityServiceImpl.this.authorityDAO.selectAuthorityByParent(authorityOld.getId(), null);
/* 296 */             while ((null != subList) && (subList.size() > 0)) {
/* 297 */               List idListTemp = new ArrayList();
/* 298 */               for (Authority sub : subList) {
/* 299 */                 idList.add(sub.getId());
/* 300 */                 idListTemp.add(sub.getId());
/*     */               }
/* 302 */               subList = AuthorityServiceImpl.this.authorityDAO.selectAuthorityByParentList(idListTemp);
/*     */             }
/* 304 */             AuthorityServiceImpl.this.authorityDAO.updateAuthoritySubSysByIdList(idList, authority.getSubSystemId());
/*     */           }
/*     */ 
/* 307 */           String url = "";
/* 308 */           if ((authority.getType().shortValue() == EnumAuthorityType.MENU.getCode()) && (authority.getOpenType().shortValue() == EnumAuthorityOpenType.OUTER.getCode()))
/*     */           {
/* 310 */             url = authority.getUrl();
/* 311 */             authority.setUrl(authority.getUrlPrefix() + authority.getUrl());
/*     */           }
/* 313 */           AuthorityServiceImpl.this.authorityDAO.updateAuthority(authority);
/* 314 */           if (!url.equals("")) {
/* 315 */             authority.setUrl(url);
/*     */           }
/*     */ 
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 328 */           status.setRollbackOnly();
/* 329 */           AuthorityServiceImpl.this.logger.error("", e);
/* 330 */           result = "未预期，请稍后再试！";
/*     */         }
/* 332 */         return result;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private String judgeFromChildAndParent(Authority authority, Authority parent)
/*     */   {
/* 344 */     if (authority.getType().shortValue() == EnumAuthorityType.MENU_BAR.getCode()) {
/* 345 */       if (parent.getType().shortValue() == EnumAuthorityType.MENU.getCode())
/* 346 */         return "“菜单组”的父权限不能是“菜单”！";
/* 347 */       if (parent.getType().shortValue() == EnumAuthorityType.OPERATION.getCode())
/* 348 */         return "“菜单组”的父权限不能是“操作”！";
/*     */     }
/* 350 */     else if (authority.getType().shortValue() == EnumAuthorityType.MENU.getCode()) {
/* 351 */       if (parent.getType().shortValue() == EnumAuthorityType.MENU.getCode())
/* 352 */         return "“菜单”的父权限不能是“菜单”！";
/* 353 */       if (parent.getType().shortValue() == EnumAuthorityType.OPERATION.getCode())
/* 354 */         return "“菜单”的父权限不能是“操作”！";
/*     */     }
/* 356 */     else if (authority.getType().shortValue() == EnumAuthorityType.OPERATION.getCode()) {
/* 357 */       if (parent.getType().shortValue() == EnumAuthorityType.SYSTEM.getCode())
/* 358 */         return "“操作”的父权限不能是“子系统”！";
/* 359 */       if (parent.getType().shortValue() == EnumAuthorityType.MENU_BAR.getCode())
/* 360 */         return "“操作”的父权限不能是“菜单组”！";
/* 361 */       if (parent.getType().shortValue() == EnumAuthorityType.OPERATION.getCode()) {
/* 362 */         return "“操作”的父权限不能是“操作”！";
/*     */       }
/*     */     }
/* 365 */     if (parent.getOpenType().shortValue() == EnumAuthorityOpenType.OUTER.getCode())
/* 366 */       return "父权限的打开方式为“弹出”，无法在弹出的权限下建子权限！";
/* 367 */     if (parent.getOpenType().shortValue() != EnumAuthorityOpenType.INNER.getCode()) {
/* 368 */       return "父权限的打开方式为“页面跳转”，无法在页面跳转的权限下建子权限！";
/*     */     }
/* 370 */     return "";
/*     */   }
/*     */ 
/*     */   public List<Authority> selectMenuByUserAndSubsystem(Long userid, String subSystemCode)
/*     */   {
/* 376 */     if (StringUtils.isBlank(subSystemCode)) {
/* 377 */       return null;
/*     */     }
/* 379 */     return this.authorityDAO.selectMenuByUserAndSubsystem(userid, subSystemCode);
/*     */   }
/*     */ 
/*     */   public List<Authority> getChildrenOfSubSystem(Long subSystemId)
/*     */   {
/* 384 */     return this.authorityDAO.getChildrenOfSubSystem(subSystemId);
/*     */   }
/*     */ 
/*     */   public int getChildrenCountOfSubSystem(Long subSystemId) {
/* 388 */     return this.authorityDAO.getChildrenCountOfSubSystem(subSystemId);
/*     */   }
/*     */ 
/*     */   public List<Long> getChildrenIdsOfSubSystem(Long subSystemId) {
/* 392 */     return this.authorityDAO.getChildrenIdsOfSubSystem(subSystemId);
/*     */   }
/*     */ 
/*     */   public String deleteAuthorityByIdList(final EnumIsCore userIsCore,final List<Long> idList)
/*     */   {
/* 397 */     return (String)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public String doInTransaction(TransactionStatus status) {
/* 399 */         String result = "";
/*     */         try {
/* 401 */           List<Authority> listOld = AuthorityServiceImpl.this.authorityDAO.selectAuthorityByIdList(idList);
/* 402 */           if (userIsCore.getCode() == EnumIsCore.APPLICATION.getCode()) {
/* 403 */             for (Authority authority : listOld) {
/* 404 */               if (authority.getIsCore().shortValue() == EnumIsCore.CORE.getCode())
/* 405 */                 return "您无法删除核心数据！";
/*     */             }
/*     */           }
/*     */           else {
/* 409 */             for (Authority authority : listOld) {
/* 410 */               if (authority.getIsCore().shortValue() == EnumIsCore.BASE.getCode()) {
/* 411 */                 return "您无法删除基础数据！";
/*     */               }
/*     */             }
/*     */           }
/* 415 */           List<Authority> list = AuthorityServiceImpl.this.authorityDAO.selectAuthorityByParentList(idList);
/* 416 */           if (null != list) {
/* 417 */             for (Authority authority : list) {
/* 418 */               if ((null != authority) && (null != authority.getId()) && (null != authority.getParentId())) {
/* 419 */                 AuthorityServiceImpl.this.logger.error("authority.getParentId().longValue() = " + authority.getParentId().longValue());
/* 420 */                 boolean exist = false;
/* 421 */                 for (Long id : idList) {
/* 422 */                   if (id.longValue() == authority.getId().longValue()) {
/* 423 */                     AuthorityServiceImpl.this.logger.error("id.longValue() = " + id.longValue() + "   authority.getId().longValue() = " + authority.getId().longValue());
/*     */ 
/* 425 */                     exist = true;
/* 426 */                     break;
/*     */                   }
/*     */                 }
/* 429 */                 if (!exist) {
/* 430 */                   authority = AuthorityServiceImpl.this.getInfoAllById(authority.getId());
/* 431 */                   return "您欲删除的权限下存在未删除的子权限“" + authority.getParentNameByLevel("") + Authority.getSplit() + authority.getName() + "”，不能删除！";
/*     */                 }
/*     */               }
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 438 */           AuthorityServiceImpl.this.authorityDAO.deleteAuthorityByIdList(idList);
/* 439 */           AuthorityServiceImpl.this.roleAuthorityDAO.deleteRoleAuthorityByAuthIdList(idList);
/*     */         } catch (Exception e) {
/* 441 */           status.setRollbackOnly();
/* 442 */           AuthorityServiceImpl.this.logger.error("", e);
/* 443 */           result = "未预期，请稍后再试！";
/*     */         }
/* 445 */         return result;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/* 455 */     List<SubSystem> sysList = this.subSystemDAO.getAllSubSystemList();
/* 456 */     if ((sysList != null) && (sysList.size() > 0)) {
/* 457 */       for (SubSystem sys : sysList)
/*     */       {
/* 459 */         queryPermissionBySys(sys);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 480 */     this.eclpSubSystemRegisterDAO.deleteAll();
/*     */   }
/*     */   private void queryPermissionBySys(SubSystem sys) {
/* 483 */     if (sys != null)
/*     */     {
/* 485 */       Map permissionMap = new HashMap();
/*     */ 
/* 487 */       if (sys.getSuperCode() != null) {
/* 488 */         permissionMap.put(Integer.valueOf(sys.getSuperCode().intValue()), Integer.valueOf(0));
/*     */       }
/*     */ 
/* 492 */       List<Authority> authList = this.authorityDAO.selectAuthListBySubSys(sys.getId());
/*     */       int row;
/* 493 */       if ((authList != null) && (authList.size() > 0)) {
/* 494 */         row = 1;
/* 495 */         for (Authority auth : authList) {
/* 496 */           permissionMap.put(Integer.valueOf(auth.getCode().intValue()), Integer.valueOf(row++));
/*     */         }
/*     */       }
/*     */ 
/* 500 */       MemoPermission.put(sys.getName(), permissionMap);
/*     */     }
/*     */   }
/*     */ 
/*     */   public short getMaxSort()
/*     */   {
/* 507 */     return this.authorityDAO.getMaxSort();
/*     */   }
/*     */ 
/*     */   public void insertAuthority(Authority record) {
/* 511 */     this.authorityDAO.insertAuthority(record);
/*     */   }
/*     */ 
/*     */   public int updateAuthority(Authority record) {
/* 515 */     return this.authorityDAO.updateAuthority(record);
/*     */   }
/*     */ 
/*     */   public Authority selectAuthorityById(Long id) {
/* 519 */     return this.authorityDAO.selectAuthorityById(id);
/*     */   }
/*     */ 
/*     */   public Authority selectAuthorityBySubSystemId(Long subSystemId) {
/* 523 */     return this.authorityDAO.selectAuthorityBySubSystemId(subSystemId);
/*     */   }
/*     */ 
/*     */   public List<Authority> selectAuthority(Authority auth)
/*     */   {
/* 528 */     if (auth != null) {
/* 529 */       return this.authorityDAO.selectAuthority(auth);
/*     */     }
/* 531 */     return null;
/*     */   }
/*     */ 
/*     */   public List<Authority> getCanAssginAuthList()
/*     */   {
/* 536 */     return this.authorityDAO.selectCanAssginAuthList();
/*     */   }
/*     */ 
/*     */   public AuthorityDAO getAuthorityDAO() {
/* 540 */     return this.authorityDAO;
/*     */   }
/*     */ 
/*     */   public void setAuthorityDAO(AuthorityDAO authorityDAO) {
/* 544 */     this.authorityDAO = authorityDAO;
/*     */   }
/*     */ 
/*     */   public RoleAuthorityDAO getRoleAuthorityDAO() {
/* 548 */     return this.roleAuthorityDAO;
/*     */   }
/*     */ 
/*     */   public void setRoleAuthorityDAO(RoleAuthorityDAO roleAuthorityDAO) {
/* 552 */     this.roleAuthorityDAO = roleAuthorityDAO;
/*     */   }
/*     */ 
/*     */   public SubSystemDAO getSubSystemDAO() {
/* 556 */     return this.subSystemDAO;
/*     */   }
/*     */ 
/*     */   public void setSubSystemDAO(SubSystemDAO subSystemDAO) {
/* 560 */     this.subSystemDAO = subSystemDAO;
/*     */   }
/*     */ 
/*     */   public TransactionTemplate getTransactionTemplate() {
/* 564 */     return this.transactionTemplate;
/*     */   }
/*     */ 
/*     */   public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
/* 568 */     this.transactionTemplate = transactionTemplate;
/*     */   }
/*     */ 
/*     */   public List<Authority> selectMenuBySubsystem(Long sysId)
/*     */   {
/* 573 */     if (sysId == null) {
/* 574 */       return null;
/*     */     }
/* 576 */     return this.authorityDAO.selectMenuBySubsystem(sysId);
/*     */   }
/*     */ 
/*     */   public RoleSystemDAO getRoleSystemDAO() {
/* 580 */     return this.roleSystemDAO;
/*     */   }
/*     */ 
/*     */   public void setRoleSystemDAO(RoleSystemDAO roleSystemDAO) {
/* 584 */     this.roleSystemDAO = roleSystemDAO;
/*     */   }
/*     */ 
/*     */   public List<Integer> getSubsystemAllPermissionListByUser(Users user, String subSystemCode)
/*     */   {
/* 590 */     return this.authorityDAO.selectAllAuthorityByUserAndSubsystem(user, subSystemCode);
/*     */   }
/*     */ 
/*     */   public RoleDAO getRoleDAO() {
/* 594 */     return this.roleDAO;
/*     */   }
/*     */ 
/*     */   public void setRoleDAO(RoleDAO roleDAO) {
/* 598 */     this.roleDAO = roleDAO;
/*     */   }
/*     */ 
/*     */   public List<Authority> getAllAuthListByUserId(Long userId)
/*     */   {
/* 603 */     if (userId != null)
/*     */     {
/* 605 */       List authList = this.authorityDAO.selectAllAuthByUserId(userId);
/* 606 */       return getSubSystemList(authList);
/*     */     }
/* 608 */     return null;
/*     */   }
/*     */ 
/*     */   private List<Authority> getSubSystemList(List<Authority> authList)
/*     */   {
/* 618 */     if ((authList != null) && (authList.size() > 0)) {
/* 619 */       List sysList = new ArrayList();
/* 620 */       for (Authority auth : authList) {
/* 621 */         if ((auth.getParentId() != null) && (auth.getParentId().equals(Long.valueOf(-1L))))
/*     */         {
/* 623 */           auth = recurseChildList(auth, authList);
/* 624 */           sysList.add(auth);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 629 */       return sysList;
/*     */     }
/* 631 */     return null;
/*     */   }
/*     */ 
/*     */   private Authority recurseChildList(Authority auth, List<Authority> authList)
/*     */   {
/* 643 */     if ((auth.getParentId().longValue() == -1L) || (auth.getIsLeaf().shortValue() == 2))
/*     */     {
/* 645 */       List<Authority> childList = getChildListByParentId(auth.getId(), authList);
/* 646 */       if ((childList != null) && (childList.size() > 0)) {
/* 647 */         for (Authority childAuth : childList) {
/* 648 */           childAuth = recurseChildList(childAuth, authList);
/*     */         }
/* 650 */         auth.setChildList(childList);
/*     */       }
/*     */     }
/* 653 */     return auth;
/*     */   }
/*     */ 
/*     */   private List<Authority> getChildListByParentId(Long parentId, List<Authority> authList)
/*     */   {
/* 663 */     if ((authList != null) && (authList.size() > 0)) {
/* 664 */       List childList = new ArrayList();
/* 665 */       for (Authority auth : authList) {
/* 666 */         if ((auth.getParentId() != null) && (auth.getParentId().equals(parentId))) {
/* 667 */           childList.add(auth);
/*     */         }
/*     */       }
/* 670 */       return childList;
/*     */     }
/* 672 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.AuthorityServiceImpl
 * JD-Core Version:    0.6.0
 */