/*     */ package com.hundsun.eclp.web.action;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.AuthorityDAO;
/*     */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*     */ import com.hundsun.eclp.biz.domain.role.Role;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.query.UsersQuery;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.RoleService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.biz.service.common.impl.NotifyServerImpl;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.common.Tree;
/*     */ import com.hundsun.eclp.common.TreeMaker;
/*     */ import com.hundsun.eclp.enums.EnumAuthStatus;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityOpenType;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityType;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityUrlPrefix;
/*     */ import com.hundsun.eclp.enums.EnumIsCore;
/*     */ import com.hundsun.eclp.enums.EnumRoleIsCore;
/*     */ import com.hundsun.eclp.enums.EnumRoleStatus;
/*     */ import com.hundsun.eclp.enums.EnumUserStatus;
/*     */ import com.hundsun.eclp.enums.EnumUsersType;
/*     */ import com.hundsun.eclp.enums.PermissionEnum;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.eclp.util.DateUtil;
/*     */ import com.hundsun.eclp.util.FileHelper;
/*     */ import com.hundsun.eclp.web.validator.AuthValidator;
/*     */ import com.hundsun.network.common.query.QueryPage;
/*     */ import java.io.IOException;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
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
/*     */ @RequestMapping({"/auth"})
/*     */ public class AuthAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuthorityService authorityService;
/*     */ 
/*     */   @Autowired
/*     */   private AuthValidator authValidator;
/*     */ 
/*     */   @Autowired
/*     */   AuthorityDAO authorityDAO;
/*     */ 
/*     */   @Autowired
/*     */   NotifyServerImpl notifyServer;
/*     */ 
/*     */   @Autowired
/*     */   UsersService usersService;
/*     */ 
/*     */   @Autowired
/*     */   RoleService roleService;
/*     */   private static final String datePattern = "yyyy-MM-dd  HH:mm:ss";
/*     */ 
/*     */   @AdminAccess({PermissionEnum.AUTH_INFO})
/*     */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String index()
/*     */   {
/*  87 */     return "auth/index";
/*     */   }
/*     */ 
/*     */   @AdminAccess({PermissionEnum.AUTH_INFO})
/*     */   @RequestMapping({"/tree"})
/*     */   public String tree(@RequestParam(value="showType", required=false) String showType, @RequestParam(value="showUsing", required=false) String showUsing, UserAgent userAgent, ModelMap model) {
/*  95 */     List list = new ArrayList();
/*  96 */     if ((null == showType) || (showType.equals(""))) {
/*  97 */       showType = "all";
/*     */     }
/*  99 */     if ((null == showUsing) || (showType.equals(""))) {
/* 100 */       showUsing = "USE";
/*     */     }
/*     */ 
/* 103 */     List parentIdList = new ArrayList();
/*     */     List<Authority> listAuthority;
/*     */     //List listAuthority;
/* 105 */     if (showType.equals("async"))
/*     */     {
/*     */       //List listAuthority;
/* 106 */       if (!showUsing.equals("ALL"))
/* 107 */         listAuthority = this.authorityService.getListSubSys(Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else
/* 109 */         listAuthority = this.authorityService.getListSubSys(null);
/*     */     }
/*     */     else
/*     */     {
/*     */       //List listAuthority;
/* 112 */       if (!showUsing.equals("ALL"))
/* 113 */         listAuthority = this.authorityService.getListAll(Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else {
/* 115 */         listAuthority = this.authorityService.getListAll(null);
/*     */       }
/*     */     }
/*     */ 
/* 119 */     for (Authority authority : listAuthority)
/* 120 */       parentIdList.add(authority.getId());
/*     */     Map<Long, Integer>  listParentSubNum;
/*     */     //Map listParentSubNum;
/* 124 */     if (showType.equals("async"))
/*     */     {
/*     */       //Map listParentSubNum;
/* 125 */       if (!showUsing.equals("ALL"))
/* 126 */         listParentSubNum = this.authorityService.getCountByParentGroupByParent(parentIdList, Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else
/* 128 */         listParentSubNum = this.authorityService.getCountByParentGroupByParent(parentIdList, null);
/*     */     }
/*     */     else
/*     */     {
/*     */       //Map listParentSubNum;
/* 131 */       if (!showUsing.equals("ALL"))
/* 132 */         listParentSubNum = this.authorityService.getCountByParentGroupByParent(parentIdList, Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */       else {
/* 134 */         listParentSubNum = this.authorityService.getCountByParentGroupByParent(parentIdList, null);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 139 */     for (Authority authority : listAuthority) {
/* 140 */       boolean isParent = false;
/* 141 */       for (Long parentId : listParentSubNum.keySet()) {
/* 142 */         if (authority.getId().longValue() == parentId.longValue()) {
/* 143 */           Integer subNum = (Integer)listParentSubNum.get(parentId);
/* 144 */           if (subNum.intValue() <= 0) break;
/* 145 */           isParent = true; break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 150 */       Tree tree = new Tree(authority.getId().toString(), authority.getParentId().toString(), authority.getName(), authority.getType().toString(), authority.getSort().intValue(), authority.getParentId().longValue() == -1L, isParent);
/*     */ 
/* 157 */       if (authority.getParentId().longValue() != -1L) {
/* 158 */         setDefine(userAgent, tree, authority.getIsCore().shortValue());
/*     */       }
/* 160 */       list.add(tree);
/*     */     }
/*     */ 
/* 163 */     TreeMaker treeMaker = new TreeMaker(list, "-1");
/* 164 */     model.addAttribute("subSysList", treeMaker.toStringScript());
/* 165 */     model.addAttribute("showType", showType);
/* 166 */     model.addAttribute("showUsing", showUsing);
/* 167 */     return "auth/tree";
/*     */   }
/*     */ 
/*     */   private void setDefine(UserAgent userAgent, Tree tree, short authorityIsCore)
/*     */   {
/* 177 */     if (userAgent.getUserType().shortValue() == EnumIsCore.APPLICATION.getCode())
/*     */     {
/* 179 */       if (userAgent.havePermission(PermissionEnum.AUTH_EDIT)) {
/* 180 */         if (authorityIsCore == EnumIsCore.APPLICATION.getCode())
/* 181 */           tree.setDefine("2");
/*     */         else
/* 183 */           tree.setDefine("1");
/*     */       }
/*     */       else {
/* 186 */         tree.setDefine("1");
/*     */       }
/* 188 */       if (userAgent.havePermission(PermissionEnum.AUTH_DEL)) {
/* 189 */         if (authorityIsCore != EnumIsCore.APPLICATION.getCode())
/*     */         {
/* 191 */           tree.setNocheck(true);
/*     */         }
/*     */       }
/* 194 */       else tree.setNocheck(true);
/*     */     }
/*     */     else
/*     */     {
/* 198 */       if (userAgent.havePermission(PermissionEnum.AUTH_EDIT)) {
/* 199 */         if (authorityIsCore != EnumIsCore.BASE.getCode())
/* 200 */           tree.setDefine("2");
/*     */         else
/* 202 */           tree.setDefine("1");
/*     */       }
/*     */       else {
/* 205 */         tree.setDefine("1");
/*     */       }
/* 207 */       if (userAgent.havePermission(PermissionEnum.AUTH_DEL)) {
/* 208 */         if (authorityIsCore == EnumIsCore.BASE.getCode())
/*     */         {
/* 210 */           tree.setNocheck(true);
/*     */         }
/*     */       }
/* 213 */       else tree.setNocheck(true); 
/*     */     }
/*     */   }
/*     */   @AdminAccess({PermissionEnum.AUTH_INFO})
/*     */   @RequestMapping({"/treeContent"})
/*     */   @ResponseBody
/*     */   public List<Tree> treeContent(String pId, String id, String showUsing, UserAgent userAgent) {
/* 221 */     List list = new ArrayList();
/*     */ 
/* 223 */     if (null == showUsing) {
/* 224 */       showUsing = "USE";
/*     */     }
/*     */ 
/* 227 */     List parentIdList = new ArrayList();
/*     */     List<Authority> listAuthority;
/*     */     //List listAuthority;
/* 228 */     if (!showUsing.equals("ALL"))
/* 229 */       listAuthority = this.authorityService.getListBySubSystemParent(Long.valueOf(Long.parseLong(pId)), Long.valueOf(Long.parseLong(id)), Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */     else {
/* 231 */       listAuthority = this.authorityService.getListBySubSystemParent(Long.valueOf(Long.parseLong(pId)), Long.valueOf(Long.parseLong(id)), null);
/*     */     }
/*     */ 
/* 234 */     for (Authority authority : listAuthority)
/* 235 */       parentIdList.add(authority.getId());
/*     */     Map<Long, Integer>  listParentSubNum;
/*     */     //Map listParentSubNum;
/* 239 */     if (!showUsing.equals("ALL"))
/* 240 */       listParentSubNum = this.authorityService.getCountByParentGroupByParent(parentIdList, Short.valueOf(EnumAuthStatus.USE.getCode()));
/*     */     else {
/* 242 */       listParentSubNum = this.authorityService.getCountByParentGroupByParent(parentIdList, null);
/*     */     }
/*     */ 
/* 246 */     for (Authority authority : listAuthority) {
/* 247 */       boolean isParent = false;
/* 248 */       for (Long parentId : listParentSubNum.keySet()) {
/* 249 */         if (authority.getId().longValue() == parentId.longValue()) {
/* 250 */           Integer subNum = (Integer)listParentSubNum.get(parentId);
/* 251 */           if (subNum.intValue() <= 0) break;
/* 252 */           isParent = true; break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 257 */       Tree tree = new Tree(authority.getId().toString(), authority.getParentId().longValue() != -1L ? authority.getParentId().toString() : authority.getSubSystemId(), authority.getName(), authority.getType().toString(), authority.getSort().intValue(), false, isParent);
/*     */ 
/* 263 */       setDefine(userAgent, tree, authority.getIsCore().shortValue());
/* 264 */       list.add(tree);
/*     */     }
/* 266 */     return list; } 
/* 272 */   @AdminAccess({PermissionEnum.AUTH_INFO})
/*     */   @RequestMapping({"/isParent"})
/*     */   @ResponseBody
/*     */   public boolean isParent(String subSystemId, String id, String showUsing) { this._log.error("in authAction.isParent!!!  subSystemId = " + subSystemId + "    id = " + id);
/* 273 */     if ((null == id) || (id.equals(""))) {
/* 274 */       return false;
/*     */     }
/* 276 */     if (null == showUsing) {
/* 277 */       showUsing = "USE";
/*     */     }
/* 279 */     if (!showUsing.equals("ALL")) {
/* 280 */       if (this.authorityService.getCountBySubSystemParent(Long.valueOf(Long.parseLong(subSystemId)), Long.valueOf(Long.parseLong(id)), Short.valueOf(EnumAuthStatus.USE.getCode())) > 0)
/*     */       {
/* 282 */         return true;
/*     */       }
/*     */     }
/* 285 */     else if (this.authorityService.getCountBySubSystemParent(Long.valueOf(Long.parseLong(subSystemId)), Long.valueOf(Long.parseLong(id)), null) > 0)
/*     */     {
/* 287 */       return true;
/*     */     }
/*     */ 
/* 291 */     return false; } 
/*     */   @AdminAccess({PermissionEnum.AUTH_INFO})
/*     */   @RequestMapping({"/list"})
/*     */   public String list(ModelMap model) {
/* 297 */     return "auth/list";
/*     */   }
/* 303 */   @AdminAccess({PermissionEnum.AUTH_ADD})
/*     */   @RequestMapping({"/add"})
/*     */   public String add(ModelMap model, UserAgent userAgent) { initEdit(model);
/* 304 */     Authority authority = new Authority();
/* 305 */     if (userAgent.getUserType().shortValue() != EnumUsersType.BASE_DATA.getCode().shortValue())
/* 306 */       authority.setIsCore(Short.valueOf(userAgent.getUserType().shortValue()));
/*     */     else {
/* 308 */       authority.setIsCore(Short.valueOf(EnumUsersType.DEVELOPMENT_LEVEL.getCode().shortValue()));
/*     */     }
/* 310 */     authority.setStatus(Short.valueOf(EnumAuthStatus.USE.getCode()));
/* 311 */     model.addAttribute("authority", authority);
/* 312 */     return "auth/edit"; } 
/*     */   @AdminAccess({PermissionEnum.AUTH_INFO})
/*     */   @RequestMapping({"/view"})
/*     */   public String view(@RequestParam("id") Long id, ModelMap model) {
/* 318 */     initEdit(model);
/* 319 */     Authority authority = this.authorityService.getInfoAllById(id);
/* 320 */     if (authority.getType().shortValue() == EnumAuthorityType.MENU.getCode()) {
/* 321 */       for (EnumAuthorityUrlPrefix enumAuthorityUrlPrefix : EnumAuthorityUrlPrefix.values()) {
/* 322 */         if (authority.getUrl().startsWith(enumAuthorityUrlPrefix.getCode())) {
/* 323 */           authority.setUrlPrefix(enumAuthorityUrlPrefix.getCode());
/* 324 */           authority.setUrl(authority.getUrl().substring(authority.getUrlPrefix().length()));
/* 325 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 329 */     model.addAttribute("authority", authority);
/* 330 */     return "auth/view";
/*     */   }
/*     */ 
/*     */   @AdminAccess({PermissionEnum.AUTH_USER})
/*     */   @RequestMapping({"view_user"})
/*     */   public String assigntoUser(@RequestParam("id") Long id, @RequestParam(value="page", required=false, defaultValue="1") int currPage, @ModelAttribute("query") UsersQuery query, Model model)
/*     */   {
/* 340 */     query.setCurrentPage(Integer.valueOf(currPage));
/* 341 */     Authority authority = this.authorityService.getInfoAllById(id);
/* 342 */     query = this.usersService.selectUsersByAuth(id, Long.valueOf(authority.getSubSystemId()), query);
/* 343 */     model.addAttribute("enumUsersType", EnumUsersType.values());
/* 344 */     model.addAttribute("userStatusMap", EnumUserStatus.toMap());
/* 345 */     model.addAttribute("authority", authority);
/* 346 */     return "auth/view_user";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"user/excel"})
/*     */   public void excel(@RequestParam("id") Long id, @ModelAttribute("query") UsersQuery query, HttpServletResponse response)
/*     */     throws IOException
/*     */   {
/* 356 */     Authority authority = this.authorityService.getInfoAllById(id);
/* 357 */     HSSFWorkbook wb = new HSSFWorkbook();
/* 358 */     String sheetTitle = authority.getName() + "权限已分配的用户列表";
/* 359 */     HSSFSheet sheet = wb.createSheet(sheetTitle);
/*     */ 
/* 361 */     initExportSheet(sheet, wb, authority.getName());
/* 362 */     List userList = this.usersService.selectListByRoleList(id, Long.valueOf(authority.getSubSystemId()), query);
/* 363 */     if (null != userList)
/*     */     {
/* 365 */       for (int i = 0; i < userList.size(); i++)
/*     */       {
/* 367 */         Users user = (Users)userList.get(i);
/* 368 */         HSSFRow row = sheet.createRow((short)i + 2);
/* 369 */         row.createCell(0).setCellValue(user.getAccount());
/* 370 */         row.createCell(1).setCellValue(user.getName());
/* 371 */         row.createCell(2).setCellValue((String)EnumUsersType.toMap().get(String.valueOf(user.getUserType())));
/* 372 */         row.createCell(3).setCellValue((String)EnumUserStatus.toMap().get(user.getStatus().toString()));
/* 373 */         row.createCell(4).setCellValue(DateUtil.getDateTime("yyyy-MM-dd  HH:mm:ss", user.getGmtCreate()));
/*     */       }
/*     */     }
/* 376 */     FileHelper.ExportExcelReport(response, wb, sheetTitle);
/*     */   }
/*     */ 
/*     */   @AdminAccess({PermissionEnum.AUTH_ROLE})
/*     */   @RequestMapping({"view_role"})
/*     */   public String viewRole(@RequestParam("authId") Long authId, @RequestParam(value="page", required=false, defaultValue="1") int currPage, @ModelAttribute("query") UsersQuery query, Model model)
/*     */   {
/* 385 */     query.setCurrentPage(Integer.valueOf(currPage));
/* 386 */     QueryPage page = this.roleService.getRoleByAuthId(query);
/* 387 */     if (page != null) {
/* 388 */       model.addAttribute("page", page);
/* 389 */       model.addAttribute("enumRoleStatus", EnumRoleStatus.values());
/* 390 */       model.addAttribute("enumRoleIsCore", EnumRoleIsCore.values());
/*     */     }
/* 392 */     model.addAttribute("id", authId);
/* 393 */     model.addAttribute("auth", this.authorityDAO.selectAuthorityById(authId));
/*     */ 
/* 395 */     return "auth/view_role";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"authRole/excel"})
/*     */   public void exportRole(@RequestParam("authId") Long authId, HttpServletResponse response) throws IOException {
/* 401 */     Authority authority = this.authorityService.getInfoAllById(authId);
/* 402 */     HSSFWorkbook wb = new HSSFWorkbook();
/* 403 */     String sheetTitle = authority.getName() + "权限已分配的角色列表";
/* 404 */     HSSFSheet sheet = wb.createSheet(sheetTitle);
/*     */ 
/* 406 */     sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
/* 407 */     HSSFRow row = sheet.createRow(0);
/* 408 */     sheet.setColumnWidth(1, 4500);
/* 409 */     HSSFCell cell = row.createCell(0);
/* 410 */     cell.setCellValue(authority.getName() + "对应的角色列表");
/* 411 */     HSSFCellStyle cellStyle = wb.createCellStyle();
/* 412 */     cellStyle.setAlignment((short) 6);
/* 413 */     cell.setCellStyle(cellStyle);
/* 414 */     String[] cellNames = { "角色代码", "角色名称", "角色类型", "状态", "排序", "备注" };
/* 415 */     row = sheet.createRow(1);
/* 416 */     int j = 0;
/* 417 */     for (String cellName : cellNames) {
/* 418 */       cell = row.createCell(j++);
/* 419 */       cell.setCellValue(cellName);
/*     */     }
/*     */ 
/* 422 */     List<Role> roleList = this.roleService.getRoleByAuthId(authId);
/*     */     Map isCoreMap;
/*     */     Map roleStatusMap;
/*     */     int i;
/* 424 */     if ((roleList != null) && (roleList.size() > 0)) {
/* 425 */       isCoreMap = EnumRoleIsCore.toMap();
/* 426 */       roleStatusMap = EnumRoleStatus.toMap();
/* 427 */       i = 2;
/* 428 */       for (Role role : roleList) {
/* 429 */         row = sheet.createRow((short)(i++));
/* 430 */         row.createCell(0).setCellValue(role.getCode());
/* 431 */         row.createCell(1).setCellValue(role.getDisplayName());
/* 432 */         row.createCell(2).setCellValue((String)isCoreMap.get(Short.valueOf(role.getIsCore().shortValue())));
/* 433 */         row.createCell(3).setCellValue((String)roleStatusMap.get(Integer.valueOf(role.getStatus().intValue())));
/* 434 */         row.createCell(4).setCellValue(role.getSort().longValue());
/* 435 */         row.createCell(5).setCellValue(role.getRemark());
/*     */       }
/*     */     }
/* 438 */     FileHelper.ExportExcelReport(response, wb, sheetTitle);
/*     */   }
/*     */   @AdminAccess({PermissionEnum.AUTH_EDIT})
/*     */   @RequestMapping({"/edit"})
/*     */   public String edit(@RequestParam("id") Long id, ModelMap model) {
/* 445 */     initEdit(model);
/* 446 */     Authority authority = this.authorityService.getInfoAllById(id);
/* 447 */     if (authority.getType().shortValue() == EnumAuthorityType.MENU.getCode()) {
/* 448 */       for (EnumAuthorityUrlPrefix enumAuthorityUrlPrefix : EnumAuthorityUrlPrefix.values()) {
/* 449 */         if (authority.getUrl().startsWith(enumAuthorityUrlPrefix.getCode())) {
/* 450 */           authority.setUrlPrefix(enumAuthorityUrlPrefix.getCode());
/* 451 */           authority.setUrl(authority.getUrl().substring(authority.getUrlPrefix().length()));
/* 452 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 456 */     model.addAttribute("authority", authority);
/* 457 */     return "auth/edit";
/*     */   }
/*     */ 
/*     */   private void initEdit(ModelMap model) {
/* 461 */     List authorityList = new ArrayList();
/* 462 */     for (EnumAuthorityType enumAuthorityType : EnumAuthorityType.values()) {
/* 463 */       if (enumAuthorityType.getCode() != EnumAuthorityType.SYSTEM.getCode()) {
/* 464 */         authorityList.add(enumAuthorityType);
/*     */       }
/*     */     }
/* 467 */     model.addAttribute("authorityTypeList", authorityList);
/* 468 */     model.addAttribute("authorityOpenTypeList", EnumAuthorityOpenType.values());
/* 469 */     model.addAttribute("authorityUrlPrefixList", EnumAuthorityUrlPrefix.values()); } 
/* 474 */   @RequestMapping({"/getParentAll"})
/*     */   @ResponseBody
/*     */   public Authority getParentAll(String id) { Authority authority = null;
/* 475 */     if ((null != id) && (!id.equals(""))) {
/* 476 */       authority = this.authorityService.getInfoAllById(Long.valueOf(Long.parseLong(id)));
/* 477 */       authority.setParentAllName(authority.getParentNameByLevel(""));
/*     */     }
/*     */ 
/* 482 */     return authority;
/*     */   }
/*     */ 
/*     */   @InitBinder
/*     */   private void initBinder(WebDataBinder binder)
/*     */   {
/* 492 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 493 */     dateFormat.setLenient(false);
/* 494 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*     */   }
/* 500 */   @AdminAccess({PermissionEnum.AUTH_ADD, PermissionEnum.AUTH_EDIT})
/*     */   @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String save(@ModelAttribute("authority") Authority authority, BindingResult result, UserAgent userAgent, ModelMap model) { initEdit(model);
/* 501 */     this.authValidator.validate(authority, result);
/* 502 */     String resultMsg = "";
/* 503 */     if (result.hasErrors()) {
/* 504 */       return "auth/edit";
/*     */     }
/*     */ 
/* 507 */     if (userAgent.getUserType().shortValue() == EnumIsCore.APPLICATION.getCode()) {
/* 508 */       authority.setIsCore(userAgent.getUserType());
/*     */     }
/* 510 */     boolean insert = false;
/*     */ 
/* 512 */     Long sysId = null;
/* 513 */     if ((null == authority.getId()) || (authority.getId().equals(""))) {
/* 514 */       Authority parent = this.authorityDAO.selectAuthorityById(Long.valueOf(authority.getParentId().longValue()));
/* 515 */       if (parent != null) {
/* 516 */         sysId = Long.valueOf(parent.getSubSystemId());
/*     */       }
/*     */ 
/* 519 */       resultMsg = this.authorityService.add(authority);
/* 520 */       insert = true;
/*     */     }
/*     */     else {
/* 523 */       Authority authorityOld = this.authorityService.getInfoById(authority.getId());
/* 524 */       if (userAgent.getUserType().shortValue() == EnumIsCore.APPLICATION.getCode())
/* 525 */         resultMsg = this.authorityService.edit(EnumIsCore.APPLICATION, authority);
/*     */       else {
/* 527 */         resultMsg = this.authorityService.edit(EnumIsCore.CORE, authority);
/*     */       }
/* 529 */       if ((resultMsg.equals("")) && 
/* 530 */         (authorityOld.getParentId().longValue() != authority.getParentId().longValue())) {
/* 531 */         model.addAttribute("oldParentId", authorityOld.getParentId());
/*     */       }
/*     */ 
/* 534 */       sysId = Long.valueOf(authorityOld.getSubSystemId());
/*     */     }
/* 536 */     if (resultMsg.equals("")) {
/* 537 */       model.addAttribute("isSuccess", Boolean.valueOf(true));
/* 538 */       if (insert) {
/* 539 */         model.addAttribute("url", "/auth/add.htm");
/* 540 */         resultMsg = "新增成功！";
/*     */ 
/* 542 */         this.notifyServer.notifyClient(sysId, false);
/*     */       } else {
/* 544 */         resultMsg = "修改成功！";
/*     */ 
/* 546 */         this.notifyServer.notifyClient(sysId, true);
/*     */       }
/*     */ 
/* 549 */       return successSelfDefine(model, resultMsg);
/*     */     }
/* 551 */     model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 552 */     model.addAttribute("errorMsg", resultMsg);
/* 553 */     return error(model, resultMsg); }
/*     */ 
/*     */   @AdminAccess({PermissionEnum.AUTH_DEL})
/*     */   @RequestMapping({"/del"})
/*     */   public String del(@RequestParam("id") String id, UserAgent userAgent, ModelMap model)
/*     */   {
/* 561 */     String[] idArray = id.split(",");
/* 562 */     List<Long> idList = new ArrayList();
/* 563 */     for (String idTemp : idArray) {
/* 564 */       idList.add(Long.valueOf(Long.parseLong(idTemp)));
/*     */     }
/* 566 */     if (idList.size() == 0) {
/* 567 */       model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 568 */       model.addAttribute("errorMsg", "请选择需要删除的权限！");
/*     */     }
/* 570 */     String result = "";
/* 571 */     List<Authority> list = this.authorityService.getListByParentIdList(idList);
/* 572 */     if (userAgent.getUserType().shortValue() == EnumIsCore.APPLICATION.getCode())
/* 573 */       result = this.authorityService.deleteAuthorityByIdList(EnumIsCore.APPLICATION, idList);
/*     */     else {
/* 575 */       result = this.authorityService.deleteAuthorityByIdList(EnumIsCore.CORE, idList);
/*     */     }
/* 577 */     if (result.equals("")) {
/* 578 */       List parentIdList = new ArrayList();
/*     */ 
/* 580 */       for (Authority authority : list) {
/* 581 */         boolean deleted = false;
/* 582 */         for (Long idTmep : idList) {
/* 583 */           if (authority.getParentId().longValue() == idTmep.longValue()) {
/* 584 */             deleted = true;
/* 585 */             break;
/*     */           }
/*     */         }
/* 588 */         if (!deleted) {
/* 589 */           parentIdList.add(authority.getParentId());
/*     */         }
/*     */       }
/* 592 */       model.addAttribute("parentIdList", parentIdList);
/* 593 */       model.addAttribute("isSuccess", Boolean.valueOf(true));
/*     */ 
/* 596 */       this.notifyServer.notifyClient(null, true);
/*     */ 
/* 598 */       return successSelfDefine(model, "删除成功！");
/*     */     }
/* 600 */     model.addAttribute("isSuccess", Boolean.valueOf(false));
/* 601 */     model.addAttribute("errorMsg", result);
/* 602 */     model.addAttribute("noBack", Boolean.valueOf(true));
/* 603 */     return error(model, result);
/*     */   }
/*     */ 
/*     */   private String successSelfDefine(ModelMap model, String message)
/*     */   {
/* 612 */     model.addAttribute("message", message);
/* 613 */     return "auth/success";
/*     */   }
/*     */ 
/*     */   private void initExportSheet(HSSFSheet sheet, HSSFWorkbook wb, String authName)
/*     */   {
/* 624 */     sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
/* 625 */     sheet.setColumnWidth(0, 4000);
/* 626 */     sheet.setColumnWidth(1, 4000);
/* 627 */     sheet.setColumnWidth(2, 3000);
/* 628 */     sheet.setColumnWidth(3, 3000);
/* 629 */     sheet.setColumnWidth(4, 5500);
/* 630 */     HSSFRow row1 = sheet.createRow(0);
/* 631 */     HSSFCell cell1 = row1.createCell(0);
/* 632 */     cell1.setCellValue(authName + "权限已分配的用户");
/* 633 */     HSSFCellStyle cellStyle = wb.createCellStyle();
/* 634 */     cellStyle.setAlignment((short) 6);
/* 635 */     cell1.setCellStyle(cellStyle);
/* 636 */     HSSFRow row2 = sheet.createRow(1);
/* 637 */     row2.createCell(0).setCellValue("用户账号");
/* 638 */     row2.createCell(1).setCellValue("姓名");
/* 639 */     row2.createCell(2).setCellValue("用户类型");
/* 640 */     row2.createCell(3).setCellValue("状态");
/* 641 */     row2.createCell(4).setCellValue("创建时间");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.AuthAction
 * JD-Core Version:    0.6.0
 */