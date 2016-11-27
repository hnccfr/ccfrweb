/*     */ package com.hundsun.eclp.web.action.org;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.dept.Department;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.service.OrgService;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.common.Tree;
/*     */ import com.hundsun.eclp.common.TreeMaker;
/*     */ import com.hundsun.eclp.enums.EnumAuthStatus;
/*     */ import com.hundsun.eclp.enums.EnumDeptStatus;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.eclp.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/org"})
/*     */ public class OrgMaActon extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   OrgService orgService;
/*     */ 
/*     */   @RequestMapping({"/index"})
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ORGANIZATION_INFO})
/*     */   public void init(UserAgent userAgent)
/*     */   {
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/tree"})
/*     */   public String tree(@RequestParam(value="showType", required=false) String showType, @RequestParam(value="showUsing", required=false) String showUsing, UserAgent userAgent, ModelMap model)
/*     */   {
/*  45 */     List list = new ArrayList();
/*  46 */     if ((null == showType) || (showType.equals(""))) {
/*  47 */       showType = "all";
/*     */     }
/*  49 */     if ((null == showUsing) || (showType.equals(""))) {
/*  50 */       showUsing = "ALL";
/*     */     }
/*     */ 
/*  53 */     List parentIdList = new ArrayList();
/*     */     List<Department> orgList;
/*     */     //List orgList;
/*  55 */     if ("async".equals(showType))
/*     */     {
/*     */       //List orgList;
/*  56 */       if (!"ALL".equalsIgnoreCase(showUsing))
/*  57 */         orgList = this.orgService.getOrgList(Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else
/*  59 */         orgList = this.orgService.getOrgList(null);
/*     */     }
/*     */     else
/*     */     {
/*     */       //List orgList;
/*  62 */       if (!"ALL".equalsIgnoreCase(showUsing))
/*  63 */         orgList = this.orgService.getListAll(Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else {
/*  65 */         orgList = this.orgService.getListAll(null);
/*     */       }
/*     */     }
/*     */ 
/*  69 */     for (Department org : orgList)
/*  70 */       parentIdList.add(org.getId());
/*     */     Map<Long, Integer> listParentSubNum;
/*     */     //Map listParentSubNum;
/*  74 */     if (showType.equals("async"))
/*     */     {
/*     */       //Map listParentSubNum;
/*  75 */       if (!showUsing.equals("ALL"))
/*  76 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else
/*  78 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, null);
/*     */     }
/*     */     else
/*     */     {
/*     */      //Map listParentSubNum;
/*  81 */       if (!showUsing.equals("ALL"))
/*  82 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else {
/*  84 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, null);
/*     */       }
/*     */     }
/*     */ 
/*  88 */     Tree tree = new Tree("-1", "0", "系统组织机构", null, 1, true, orgList.size() > 0);
/*  89 */     list.add(tree);
/*     */ 
/*  91 */     for (Department org : orgList) {
/*  92 */       boolean isParent = false;
/*  93 */       for (Long parentId : listParentSubNum.keySet()) {
/*  94 */         if (org.getId().longValue() == parentId.longValue()) {
/*  95 */           Integer subNum = (Integer)listParentSubNum.get(parentId);
/*  96 */           if (subNum.intValue() <= 0) break;
/*  97 */           isParent = true; break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 102 */       tree = new Tree(org.getId().toString(), org.getParentId().toString(), org.getName(), null, org.getSort().intValue(), false, isParent);
/*     */ 
/* 109 */       tree.setDefine("2");
/* 110 */       list.add(tree);
/*     */     }
/*     */ 
/* 113 */     TreeMaker treeMaker = new TreeMaker(list, "0");
/* 114 */     model.addAttribute("orgList", treeMaker.toStringScript());
/* 115 */     model.addAttribute("showType", showType);
/* 116 */     model.addAttribute("showUsing", showUsing);
/* 117 */     return "org/tree"; } 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ORG_ADD})
/*     */   @RequestMapping({"/add"})
/*     */   public void add(ModelMap model, UserAgent userAgent, @ModelAttribute("org") Department org) {  } 
/* 126 */   @RequestMapping({"/getParentAll"})
/*     */   @ResponseBody
/*     */   public Department getParentAll(String id) { Department dept = new Department();
/* 127 */     if (StringUtil.isNotBlank(id))
/*     */     {
/* 129 */       String fullName = this.orgService.getFullNameById(Long.valueOf(Long.parseLong(id)));
/* 130 */       if (StringUtil.isNotBlank(fullName))
/* 131 */         dept.setFullName(fullName);
/*     */       else {
/* 133 */         dept.setFullName("");
/*     */       }
/*     */     }
/* 136 */     return dept; }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ORG_ADD, com.hundsun.eclp.enums.PermissionEnum.ORG_EDIT})
/*     */   @RequestMapping({"/save"})
/*     */   public String save(ModelMap model, UserAgent userAgent, @ModelAttribute("org") Department org) {
/* 143 */     model.addAttribute("refreshAll", "1");
/* 144 */     StringUtil.trim(org);
/* 145 */     if (org != null) {
/* 146 */       if (org.getParentId() == null) {
/* 147 */         org.setParentId(Long.valueOf(-1L));
/*     */       }
/*     */ 
/* 150 */       List<Department> list = this.orgService.getRepeatDeptList(org);
/* 151 */       if (org.getId() != null) {
/* 152 */         if (list != null) {
/* 153 */           for (Department dept : list) {
/* 154 */             if (dept.getId().longValue() != org.getId().longValue()) {
/* 155 */               model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 156 */               return error(model, "同一级节点组织机构名称不能重复");
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 161 */         String retMsg = this.orgService.edit(org, userAgent);
/* 162 */         if (StringUtil.isNotBlank(retMsg)) {
/* 163 */           model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 164 */           return error(model, retMsg);
/*     */         }
/* 166 */         model.addAttribute("url", "/org/index.htm");
/* 167 */         return successSelfDefine(model, "组织机构修改成功");
/*     */       }
/*     */ 
/* 170 */       if ((list != null) && (list.size() > 0)) {
/* 171 */         model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 172 */         return error(model, "同一级节点组织机构名称不能重复");
/*     */       }
/* 174 */       String retMsg = this.orgService.insert(org, userAgent);
/* 175 */       if (StringUtil.isNotBlank(retMsg)) {
/* 176 */         model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 177 */         return error(model, retMsg);
/*     */       }
/* 179 */       model.addAttribute("url", "/org/index.htm");
/* 180 */       return successSelfDefine(model, "组织机构新增成功");
/*     */     }
/*     */ 
/* 184 */     return null;
/*     */   }
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ORG_EDIT})
/*     */   @RequestMapping({"/edit"})
/*     */   public void edit(ModelMap model, UserAgent userAgent, @RequestParam("id") Long id) {
/* 191 */     Department dept = this.orgService.getDepartmentById(id);
/*     */ 
/* 193 */     String fullName = this.orgService.getFullNameById(dept.getParentId());
/* 194 */     if (StringUtil.isNotBlank(fullName))
/* 195 */       dept.setFullName(fullName);
/*     */     else {
/* 197 */       dept.setFullName("/系统组织机构");
/*     */     }
/* 199 */     model.addAttribute("org", dept); } 
/* 204 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ORG_DEL})
/*     */   @RequestMapping({"/del"})
/*     */   public String initDel(@RequestParam("id") String id, UserAgent userAgent, ModelMap model) { String[] idArray = id.split(",");
/* 205 */     List idList = new ArrayList();
/* 206 */     for (String idTemp : idArray) {
/* 207 */       idList.add(Long.valueOf(Long.parseLong(idTemp)));
/*     */     }
/* 209 */     if (idList.size() == 0) {
/* 210 */       model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 211 */       model.addAttribute("errorMsg", "请选择需要删除的组织机构！");
/*     */     }
/*     */ 
/* 214 */     String result = this.orgService.deleteOrgByIdList(idList, userAgent);
/* 215 */     if (StringUtil.isNotBlank(result)) {
/* 216 */       if ("exist".equalsIgnoreCase(result)) {
/* 217 */         return "redirect:/org/move.htm?id=" + id;
/*     */       }
/* 219 */       model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 220 */       model.addAttribute("errorMsg", result);
/* 221 */       model.addAttribute("noBack", Boolean.valueOf(true));
/* 222 */       return error(model, result);
/*     */     }
/*     */ 
/* 225 */     model.addAttribute("url", "/org/index.htm");
/* 226 */     return successSelfDefine(model, "删除成功！"); }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ORG_DEL})
/*     */   @RequestMapping({"/doDel"})
/*     */   public String doDel(@RequestParam("id") String id, @RequestParam("deptId") Long deptId, UserAgent userAgent, ModelMap model) {
/* 233 */     model.addAttribute("refreshAll", "1");
/* 234 */     String[] idArray = id.split(",");
/* 235 */     List idList = new ArrayList();
/* 236 */     for (String idTemp : idArray) {
/* 237 */       idList.add(Long.valueOf(Long.parseLong(idTemp)));
/*     */     }
/* 239 */     if (idList.size() == 0) {
/* 240 */       model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 241 */       model.addAttribute("errorMsg", "请选择需要删除的组织机构！");
/*     */     }
/*     */ 
/* 244 */     String result = this.orgService.deleteOrgByIdList(idList, deptId, userAgent);
/* 245 */     if (StringUtil.isNotBlank(result)) {
/* 246 */       model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 247 */       model.addAttribute("errorMsg", result);
/* 248 */       model.addAttribute("noBack", Boolean.valueOf(true));
/* 249 */       return error(model, result);
/*     */     }
/* 251 */     model.addAttribute("url", "/org/index.htm");
/* 252 */     return successSelfDefine(model, "删除成功！");
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/move"})
/*     */   public void move(ModelMap model, @RequestParam("id") String ids)
/*     */   {
/* 259 */     List<Department> deptList = this.orgService.getListAll(null);
/* 260 */     String[] idArray = ids.split(",");
/* 261 */     List<Long> idList = new ArrayList();
/* 262 */     for (String idTemp : idArray) {
/* 263 */       idList.add(Long.valueOf(Long.parseLong(idTemp)));
/*     */     }
/* 265 */     List orgList = new ArrayList();
/* 266 */     List removeOrgList = new ArrayList();
/* 267 */     boolean flag = false;
/* 268 */     for (Department dept : deptList) {
/* 269 */       flag = false;
/* 270 */       for (Long id : idList) {
/* 271 */         if (dept.getId().longValue() == id.longValue()) {
/* 272 */           flag = true;
/*     */         }
/*     */       }
/* 275 */       if (flag) {
/* 276 */         removeOrgList.add(dept);
/*     */       }
/* 278 */       else if (dept.getStatus().shortValue() == EnumDeptStatus.USE.getCode()) {
/* 279 */         orgList.add(dept);
/*     */       }
/*     */     }
/*     */ 
/* 283 */     model.addAttribute("ids", ids);
/* 284 */     model.addAttribute("orgList", orgList);
/* 285 */     model.addAttribute("removeOrgList", removeOrgList);
/*     */   }
/*     */ 
/*     */   private String successSelfDefine(ModelMap model, String message)
/*     */   {
/* 290 */     model.addAttribute("message", message);
/* 291 */     return "org/success";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.org.OrgMaActon
 * JD-Core Version:    0.6.0
 */