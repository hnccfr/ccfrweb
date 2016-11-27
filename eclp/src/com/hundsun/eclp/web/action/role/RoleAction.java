/*     */ package com.hundsun.eclp.web.action.role;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.role.Role;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.query.UsersQuery;
/*     */ import com.hundsun.eclp.biz.service.RoleService;
/*     */ import com.hundsun.eclp.biz.service.UserRoleService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.enums.EnumRoleIsCore;
/*     */ import com.hundsun.eclp.enums.EnumRoleStatus;
/*     */ import com.hundsun.eclp.enums.EnumUserStatus;
/*     */ import com.hundsun.eclp.enums.EnumUsersType;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.eclp.util.DateUtil;
/*     */ import com.hundsun.eclp.util.FileHelper;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRichTextString;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/role"})
/*     */ public class RoleAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RoleService roleService;
/*     */ 
/*     */   @Autowired
/*     */   private UserRoleService userRoleService;
/*     */ 
/*     */   @Autowired
/*     */   private UsersService userService;
/*     */   private static final String datePattern = "yyyy-MM-dd  HH:mm:ss";
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_MANAGE, com.hundsun.eclp.enums.PermissionEnum.ROLE_QUERY})
/*     */   @RequestMapping(value={"/role_list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void roleList(Model model, UserAgent user)
/*     */   {
/*  68 */     List roleList = this.roleService.getRoleList(user);
/*  69 */     List userRoleList = this.userRoleService.selectByUserId(Long.valueOf(user.getId()));
/*  70 */     model.addAttribute("roleList", roleList);
/*  71 */     model.addAttribute("userRoleList", userRoleList);
/*  72 */     model.addAttribute("enumRoleStatus", EnumRoleStatus.values());
/*  73 */     model.addAttribute("enumRoleIsCore", EnumRoleIsCore.values());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_ENABLE, com.hundsun.eclp.enums.PermissionEnum.ROLE_ENABLE})
/*     */   @RequestMapping({"/role_status_modify"})
/*     */   public String subSystemStatusModify(@RequestParam(value="roleId", required=false) Long roleId, @RequestParam(value="status", required=false) Short status, Model model, UserAgent user)
/*     */   {
/*  90 */     this.roleService.modifyStatus(roleId, status, user);
/*  91 */     return "redirect:/role/role_list.htm";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_DEL})
/*     */   @RequestMapping({"/delete_role_check"})
/*     */   @ResponseBody
/*     */   public int deleteRoleCheck(@RequestParam(value="roleId", required=false) Long roleId, Model model)
/*     */   {
/* 106 */     int count = this.userRoleService.getUserRoleCount(roleId);
/* 107 */     return count;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_DEL})
/*     */   @RequestMapping(value={"/delete_role"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String deleteRole(@RequestParam(value="roleId", required=false) Long roleId, Model model, UserAgent user)
/*     */   {
/* 122 */     this.roleService.deleteRole(roleId, user);
/*     */ 
/* 124 */     return "redirect:/role/role_list.htm";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_ADD, com.hundsun.eclp.enums.PermissionEnum.ROLE_EDIT})
/*     */   @RequestMapping({"/role_code_check"})
/*     */   @ResponseBody
/*     */   public Object[] subSystemNameCheck(@RequestParam(value="code", required=false) String code, @RequestParam(value="roleId", required=false) Long roleId, Model model)
/*     */   {
/* 140 */     Object[] temp = this.roleService.roleCodeCheck(code, roleId);
/* 141 */     return temp;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_ADD, com.hundsun.eclp.enums.PermissionEnum.ROLE_EDIT})
/*     */   @RequestMapping({"/role_displayname_check"})
/*     */   @ResponseBody
/*     */   public Object[] subSystemFullNameCheck(@RequestParam(value="displayName", required=false) String displayName, @RequestParam(value="roleId", required=false) Long roleId, Model model)
/*     */   {
/* 157 */     Object[] temp = this.roleService.roleDisplayNameCheck(displayName, roleId);
/* 158 */     return temp;
/*     */   }
/* 164 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_VIEW_USER})
/*     */   @RequestMapping({"/role_user"})
/*     */   public String roleUser(@ModelAttribute("query") UsersQuery query, Model model, @RequestParam(value="page", required=false, defaultValue="1") int currPage) { if (query.getRoleId() == null) {
/* 165 */       model.addAttribute("message", "角色id为空");
/* 166 */       return "error";
/*     */     }
/* 168 */     query.setCurrentPage(Integer.valueOf(currPage));
/* 169 */     UsersQuery page = this.userService.selectUsersByRoleId(query);
/* 170 */     if (page != null) {
/* 171 */       model.addAttribute("page", page);
/* 172 */       model.addAttribute("enumUsersStatus", EnumUserStatus.values());
/* 173 */       model.addAttribute("enumUsersType", EnumUsersType.values());
/*     */     }
/* 175 */     model.addAttribute("roleId", query.getRoleId());
/* 176 */     model.addAttribute("role", this.roleService.getRoleById(Long.valueOf(query.getRoleId())));
/*     */ 
/* 178 */     return "role/role_user"; } 
/* 183 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_VIEW_USER})
/*     */   @RequestMapping({"/exportUser"})
/*     */   public void exportUser(@RequestParam("roleId") Long roleId, HttpServletResponse response) throws IOException { if (roleId != null) {
/* 184 */       Role role = this.roleService.getRoleById(roleId);
/* 185 */       String[] cellNames = { "用户帐号", "姓名", "用户类型", "状态", "创建时间" };
/* 186 */       if (role != null) {
/* 187 */         HSSFWorkbook wb = new HSSFWorkbook();
/* 188 */         String sheetTitle = role.getDisplayName() + "角色已分配的用户列表";
/* 189 */         HSSFSheet sheet = wb.createSheet(sheetTitle);
/*     */ 
/* 191 */         sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
/*     */ 
/* 193 */         HSSFRow row = sheet.createRow(0);
/* 194 */         HSSFCell cell = row.createCell(0);
/* 195 */         sheet.setColumnWidth(0, 4500);
/* 196 */         sheet.setColumnWidth(1, 4500);
/* 197 */         sheet.setColumnWidth(4, 5500);
/* 198 */         HSSFCellStyle cellStyle = wb.createCellStyle();
/* 199 */         cellStyle.setAlignment((short) 6);
/* 200 */         cell.setCellStyle(cellStyle);
/* 201 */         cell.setCellValue(new HSSFRichTextString(sheetTitle));
/*     */ 
/* 203 */         row = sheet.createRow(1);
/* 204 */         int j = 0;
/* 205 */         for (String cellName : cellNames) {
/* 206 */           cell = row.createCell(j++);
/* 207 */           cell.setCellValue(cellName);
/*     */         }
/*     */ 
/* 210 */         List<Users> userList = this.userService.selectUsersListByRoleId(roleId);
/*     */         Map userStatusMap;
/*     */         Map userTypeMap;
/*     */         int i;
/* 212 */         if ((userList != null) && (userList.size() > 0)) {
/* 213 */           userStatusMap = EnumUserStatus.toMap();
/* 214 */           userTypeMap = EnumUsersType.toMap();
/* 215 */           i = 2;
/* 216 */           for (Users user : userList) {
/* 217 */             row = sheet.createRow((short)(i++));
/* 218 */             row.createCell(0).setCellValue(user.getAccount());
/* 219 */             row.createCell(1).setCellValue(user.getName());
/* 220 */             row.createCell(2).setCellValue((String)userTypeMap.get(String.valueOf(user.getUserType())));
/* 221 */             row.createCell(3).setCellValue((String)userStatusMap.get(String.valueOf(user.getStatus())));
/* 222 */             row.createCell(4).setCellValue(DateUtil.getDateTime("yyyy-MM-dd  HH:mm:ss", user.getGmtCreate()));
/*     */           }
/*     */         }
/* 225 */         FileHelper.ExportExcelReport(response, wb, sheetTitle);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_ADD})
/*     */   @RequestMapping(value={"/role_add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void roleAdd(@ModelAttribute("role") Role role, Model model)
/*     */   {
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_ADD})
/*     */   @RequestMapping(value={"/role_add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String roleAddSubmit(@ModelAttribute("role") Role role, Model model, UserAgent user)
/*     */   {
/* 256 */     boolean check = this.roleService.checkRole(role.getCode(), role.getDisplayName(), null, model);
/* 257 */     if (!check) {
/* 258 */       return null;
/*     */     }
/* 260 */     this.roleService.insert(role, user);
/*     */ 
/* 262 */     return "redirect:/role/role_list.htm";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_EDIT})
/*     */   @RequestMapping(value={"/role_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void roleEdit(@RequestParam(value="roleId", required=false) Long roleId, @ModelAttribute("role") Role role, Model model)
/*     */   {
/* 275 */     role = this.roleService.getRoleById(roleId);
/* 276 */     model.addAttribute("role", role);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.ROLE_EDIT})
/*     */   @RequestMapping(value={"/role_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String roleEditSubmit(@ModelAttribute("role") Role role, Model model, UserAgent user)
/*     */   {
/* 292 */     boolean check = this.roleService.checkRole(role.getCode(), role.getDisplayName(), role.getId(), model);
/*     */ 
/* 294 */     if (!check) {
/* 295 */       return null;
/*     */     }
/* 297 */     this.roleService.update(role, user);
/*     */ 
/* 299 */     return "redirect:/role/role_list.htm";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.role.RoleAction
 * JD-Core Version:    0.6.0
 */