/*     */ package com.hundsun.eclp.web.action.userinfo;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.dept.Department;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.query.UserInfoQuery;
/*     */ import com.hundsun.eclp.biz.service.OrgService;
/*     */ import com.hundsun.eclp.biz.service.UserInfoService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.common.Tree;
/*     */ import com.hundsun.eclp.common.TreeMaker;
/*     */ import com.hundsun.eclp.enums.EnumAuthStatus;
/*     */ import com.hundsun.eclp.enums.EnumEducation;
/*     */ import com.hundsun.eclp.enums.EnumUserInfoIDType;
/*     */ import com.hundsun.eclp.enums.EnumUserInfoStatus;
/*     */ import com.hundsun.eclp.enums.EnumUsersDegree;
/*     */ import com.hundsun.eclp.enums.EnumUsersType;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.eclp.util.StringUtil;
/*     */ import com.hundsun.eclp.web.validator.UserInfoValidator;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.WebDataBinder;
/*     */ import org.springframework.web.bind.annotation.InitBinder;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/userinfo"})
/*     */ public class UserInfoAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   UserInfoValidator userInfoValidator;
/*     */ 
/*     */   @Autowired
/*     */   OrgService orgService;
/*     */ 
/*     */   @Autowired
/*     */   UserInfoService userInfoService;
/*     */ 
/*     */   @Autowired
/*     */   UsersService usersService;
/*     */ 
/*     */   @InitBinder
/*     */   private void initBinder(WebDataBinder binder)
/*     */   {
/*  66 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*  67 */     dateFormat.setLenient(false);
/*  68 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_MANAGE})
/*     */   @RequestMapping({"/index"})
/*     */   public void init(UserAgent userAgent)
/*     */   {
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/tree"})
/*     */   public String tree(@RequestParam(value="showType", required=false) String showType, @RequestParam(value="showUsing", required=false) String showUsing, UserAgent userAgent, ModelMap model) {
/*  82 */     initAddEditParam(showType, showUsing, null, true, model);
/*  83 */     return "/userinfo/tree";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_MANAGE})
/*     */   @RequestMapping({"/main"})
/*     */   public String list(@RequestParam(value="showType", required=false) String showType, @ModelAttribute("query") UserInfoQuery query, @RequestParam(value="page", required=false, defaultValue="1") int page, ModelMap model, Cookyjar cookyjar)
/*     */   {
/*  93 */     return initList(showType, query, page, model, cookyjar);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_ADD})
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addUserInit(@ModelAttribute("userInfo") UserInfo userInfo, ModelMap model)
/*     */   {
/* 107 */     initAddEditParam(null, null, null, true, model);
/* 108 */     initAddr(model, userInfo);
/* 109 */     List userList = this.usersService.getUserList();
/* 110 */     model.addAttribute("userList", userList);
/* 111 */     model.addAttribute("enumUserInfoStatus", EnumUserInfoStatus.values());
/* 112 */     return "/userinfo/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_ADD})
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String addUser(@ModelAttribute("userInfo") UserInfo userInfo, BindingResult infoResult, ModelMap model, UserAgent userAgent)
/*     */   {
/* 129 */     StringUtil.trim(userInfo);
/*     */ 
/* 131 */     this.userInfoValidator.validate(userInfo, infoResult);
/* 132 */     if (infoResult.hasErrors()) {
/* 133 */       initAddEditParam(null, null, null, true, model);
/* 134 */       model.addAttribute("enumUserInfoStatus", EnumUserInfoStatus.values());
/* 135 */       return "/userinfo/add";
/*     */     }
/*     */ 
/* 138 */     boolean flag = this.userInfoService.addUInfo(userInfo, userAgent);
/* 139 */     model.addAttribute("url", "/userinfo/main.htm");
/* 140 */     return flag == true ? "success" : "error";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_MANAGE})
/*     */   @RequestMapping(value={"detail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void detailInit(@ModelAttribute("userInfo") UserInfo userInfo, @RequestParam(value="page", required=false, defaultValue="1") int page, @RequestParam(value="uId", required=true) Long uId, ModelMap model)
/*     */   {
/* 154 */     UserInfo uinfo = this.userInfoService.selectUserInfoById(uId);
/* 155 */     model.addAttribute("uinfo", uinfo);
/* 156 */     initAddEditParam(null, null, null, true, model);
/* 157 */     List userList = this.usersService.getUserList();
/* 158 */     model.addAttribute("userList", userList);
/* 159 */     model.addAttribute("page", Integer.valueOf(page));
/* 160 */     model.addAttribute("enumUserInfoStatus", EnumUserInfoStatus.values());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_EDIT})
/*     */   @RequestMapping(value={"edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void edituInfoInit(@ModelAttribute("userInfo") UserInfo userInfo, @RequestParam(value="page", required=false, defaultValue="1") int page, @RequestParam(value="uId", required=true) Long uId, ModelMap model)
/*     */   {
/* 174 */     UserInfo uinfo = this.userInfoService.selectUserInfoById(uId);
/* 175 */     model.addAttribute("userInfo", uinfo);
/* 176 */     model.addAttribute("page", Integer.valueOf(page));
/* 177 */     initAddEditParam(null, null, null, true, model);
/* 178 */     initAddr(model, uinfo);
/* 179 */     List userList = this.usersService.getUserList();
/* 180 */     model.addAttribute("userList", userList);
/* 181 */     model.addAttribute("enumUserInfoStatus", EnumUserInfoStatus.values());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_EDIT})
/*     */   @RequestMapping(value={"edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String editUserInfo(@ModelAttribute("userInfo") UserInfo userInfo, BindingResult infoResult, @RequestParam(value="page", required=false, defaultValue="1") int page, ModelMap model, UserAgent userAgent)
/*     */   {
/* 197 */     StringUtil.trim(userInfo);
/* 198 */     this.userInfoValidator.validate(userInfo, infoResult);
/* 199 */     if (infoResult.hasErrors()) {
/* 200 */       initAddEditParam(null, null, null, true, model);
/* 201 */       model.addAttribute("enumUserInfoStatus", EnumUserInfoStatus.values());
/* 202 */       model.addAttribute("page", Integer.valueOf(page));
/* 203 */       return "/userinfo/edit";
/*     */     }
/* 205 */     boolean flag = this.userInfoService.updateUserWithInfo(userInfo, userAgent);
/* 206 */     model.addAttribute("editResult", Boolean.valueOf(flag));
/* 207 */     if (flag) {
/* 208 */       return "redirect:/userinfo/main.htm?page=" + page;
/*     */     }
/* 210 */     return "error";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_ASSIGN_USER})
/*     */   @RequestMapping(value={"assign_users"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String initAssignUsers(@ModelAttribute("userinfo") UserInfo userinfo, @RequestParam("uinfoId") Long uinfoId, ModelMap model, @RequestParam(value="page", required=false, defaultValue="1") int page)
/*     */   {
/* 227 */     UserInfo uinfo = this.userInfoService.selectUserInfoById(uinfoId);
/*     */ 
/* 230 */     List<Users> usersList = this.usersService.selectNotReleUsers();
/* 231 */     if (usersList == null) {
/* 232 */       usersList = new ArrayList();
/*     */     }
/* 234 */     if (uinfo.getUserId() != null) {
/* 235 */       Users user = this.usersService.selectUserById(uinfo.getUserId());
/* 236 */       if (user != null)
/* 237 */         usersList.add(user);
/*     */     }
/* 239 */     for (Users user : usersList) {
/* 240 */       if (EnumUsersType.BASE_DATA.getCode().shortValue() == user.getUserType().shortValue()) {
/* 241 */         usersList.remove(user);
/* 242 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 246 */     model.addAttribute("usersList", usersList);
/* 247 */     model.addAttribute("uinfo", uinfo);
/* 248 */     model.addAttribute("page", Integer.valueOf(page));
/* 249 */     return "/userinfo/assign_users";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_ASSIGN_USER})
/*     */   @RequestMapping(value={"assign_users"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String assignUsers(@ModelAttribute("userinfo") UserInfo userinfo, @RequestParam(value="page", required=false, defaultValue="1") int page, ModelMap model, UserAgent userAgent)
/*     */   {
/* 265 */     UserInfo uinfo = this.userInfoService.selectUserInfoById(userinfo.getId());
/* 266 */     uinfo.setUserId(userinfo.getUserId());
/* 267 */     boolean flag = this.userInfoService.updateUserWithInfo(uinfo, userAgent);
/* 268 */     model.addAttribute("url", "/userinfo/main.htm?page=" + page);
/* 269 */     return flag ? "success" : "error";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"assign_dept_tree"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String assignDtree(@RequestParam(value="showType", required=false) String showType, @RequestParam(value="showUsing", required=false) String showUsing, @RequestParam(value="deptId", required=false) Long deptId, UserAgent userAgent, ModelMap model)
/*     */   {
/* 278 */     initAddEditParam(showType, showUsing, deptId, false, model);
/* 279 */     return "/userinfo/assign_dept_tree";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_ASSIGN_ORG})
/*     */   @RequestMapping(value={"assign_dept"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String initAssignDept(@RequestParam("uid") Long uid, @RequestParam(value="deptId", required=false) Long deptId, ModelMap model)
/*     */   {
/* 292 */     model.addAttribute("uid", uid);
/* 293 */     model.addAttribute("deptId", deptId);
/* 294 */     return "/userinfo/assign_dept";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_ASSIGN_ORG})
/*     */   @RequestMapping(value={"assign_dept"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void assignDept(@RequestParam("uid") Long uid, @RequestParam("deptId") Long deptId, ModelMap model, Cookyjar cookyjar, UserAgent userAgent)
/*     */   {
/* 307 */     boolean flag = this.userInfoService.setDept(uid, deptId, userAgent);
/* 308 */     model.addAttribute("result", Boolean.valueOf(flag));
/* 309 */     model.addAttribute("deptId", deptId);
/* 310 */     model.addAttribute("uid", uid);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_ASSIGN_ORG})
/*     */   @RequestMapping(value={"remove_dept"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void removeDept(@RequestParam("uid") Long uid, ModelMap model, Cookyjar cookyjar)
/*     */   {
/* 322 */     boolean flag = this.userInfoService.removeDept(uid);
/* 323 */     model.addAttribute("result", Boolean.valueOf(flag));
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"modify_position"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String setPosition(@ModelAttribute("query") UserInfoQuery query, @RequestParam("uid") String uid, @RequestParam("flag") String flag, @RequestParam(value="page", required=false, defaultValue="1") int page, UserAgent userAgent, ModelMap model, Cookyjar cookyjar)
/*     */   {
/* 337 */     this.userInfoService.modifyPosition(Long.valueOf(Long.parseLong(uid)), flag, userAgent, query.getDeptId());
/* 338 */     return initList(null, query, page, model, cookyjar);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_DISABLE, com.hundsun.eclp.enums.PermissionEnum.STAFF_ENABLE})
/*     */   @RequestMapping({"setStatus"})
/*     */   @ResponseBody
/*     */   public Object setStatus(@RequestParam("uid") Long uid, ModelMap model, UserAgent userAgent)
/*     */   {
/* 353 */     boolean flag = this.userInfoService.updateUinfoStatus(uid, userAgent);
/* 354 */     return Boolean.valueOf(flag);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.STAFF_DEL})
/*     */   @RequestMapping({"del"})
/*     */   @ResponseBody
/*     */   public Object delete(@RequestParam("uid") Long uid, ModelMap model, UserAgent userAgent)
/*     */   {
/* 370 */     boolean flag = this.userInfoService.deleteUInfoById(uid, userAgent);
/* 371 */     return Boolean.valueOf(flag);
/*     */   }
/*     */ 
/*     */   public String initList(String showType, UserInfoQuery query, int page, ModelMap model, Cookyjar cookyjar)
/*     */   {
/* 386 */     if ((showType != null) && (showType.equals("-1")))
/*     */     {
/* 388 */       showType = null;
/*     */     }
/*     */ 
/* 391 */     if (query != null)
/*     */     {
/* 393 */       query.setCurrentPage(Integer.valueOf(page));
/* 394 */       StringUtil.trim(query);
/* 395 */       if ((query.getDeptId() == null) || (query.getDeptId() == ""))
/*     */       {
/* 397 */         query.setDeptId(showType);
/*     */       }
/* 399 */       query = this.userInfoService.selectUserInfoByPage(query);
/*     */     }
/* 401 */     model.addAttribute("enumUserInfoStatus", EnumUserInfoStatus.values());
/* 402 */     model.addAttribute("showType", showType);
/* 403 */     initAddEditParam(null, null, null, true, model);
/* 404 */     return "/userinfo/main";
/*     */   }
/*     */ 
/*     */   public void initAddEditParam(String showType, String showUsing, Long deptId, boolean nocheck, ModelMap model)
/*     */   {
/* 414 */     List list = new ArrayList();
/* 415 */     if ((null == showType) || (showType.equals(""))) {
/* 416 */       showType = "all";
/*     */     }
/* 418 */     if ((null == showUsing) || (showType.equals(""))) {
/* 419 */       showUsing = "USE";
/*     */     }
/*     */ 
/* 422 */     List parentIdList = new ArrayList();
/*     */     List<Department> orgList;
/*     */     //List orgList;
/* 424 */     if ("async".equals(showType))
/*     */     {
/*     */       ///List orgList;
/* 425 */       if (!"ALL".equalsIgnoreCase(showUsing))
/* 426 */         orgList = this.orgService.getOrgList(Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else
/* 428 */         orgList = this.orgService.getOrgList(null);
/*     */     }
/*     */     else
/*     */     {
/*     */      // List orgList;
/* 431 */       if (!"ALL".equalsIgnoreCase(showUsing))
/* 432 */         orgList = this.orgService.getListAll(Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else {
/* 434 */         orgList = this.orgService.getListAll(null);
/*     */       }
/*     */     }
/*     */ 
/* 438 */     for (Department org : orgList)
/* 439 */       parentIdList.add(org.getId());
/*     */     Map<Long, Integer>  listParentSubNum;
/*     */     //Map listParentSubNum;
/* 443 */     if (showType.equals("async"))
/*     */     {
/*     */       //Map listParentSubNum;
/* 444 */       if (!showUsing.equals("ALL")) {
/* 445 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       }
/*     */       else
/* 448 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, null);
/*     */     }
/*     */     else
/*     */     {
/*     */       //Map listParentSubNum;
/* 452 */       if (!showUsing.equals("ALL")) {
/* 453 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       }
/*     */       else {
/* 456 */         listParentSubNum = this.orgService.getCountByParentGroupByParent(parentIdList, null);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 463 */     Tree tree = new Tree("-1", "0", "组织机构", null, 1, true, true);
/* 464 */     list.add(tree);
/* 465 */     for (Department org : orgList)
/*     */     {
/* 467 */       boolean isParent = false;
/* 468 */       for (Long parentId : listParentSubNum.keySet()) {
/* 469 */         if (org.getId().longValue() == parentId.longValue()) {
/* 470 */           Integer subNum = (Integer)listParentSubNum.get(parentId);
/* 471 */           if (subNum.intValue() <= 0) break;
/* 472 */           isParent = true; break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 477 */       tree = new Tree(org.getId().toString(), org.getParentId().toString(), org.getName(), null, org.getSort().intValue(), nocheck, isParent);
/*     */ 
/* 480 */       tree.setDefine("2");
/* 481 */       if (org.getId().equals(deptId))
/*     */       {
/* 483 */         tree.setChecked(true);
/*     */       }
/* 485 */       list.add(tree);
/*     */     }
/*     */ 
/* 489 */     TreeMaker treeMaker = new TreeMaker(list, "0");
/* 490 */     model.addAttribute("orgList", treeMaker.toStringScript());
/* 491 */     model.addAttribute("showType", showType);
/* 492 */     model.addAttribute("showUsing", showUsing);
/* 493 */     model.addAttribute("tree", list);
/*     */ 
/* 495 */     model.addAttribute("enumUsersType", EnumUsersType.values());
/*     */ 
/* 497 */     model.addAttribute("enumUserInfoIDType", EnumUserInfoIDType.values());
/*     */ 
/* 499 */     model.addAttribute("enumEducation", EnumEducation.values());
/*     */ 
/* 501 */     model.addAttribute("enumUsersDegree", EnumUsersDegree.values());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.userinfo.UserInfoAction
 * JD-Core Version:    0.6.0
 */