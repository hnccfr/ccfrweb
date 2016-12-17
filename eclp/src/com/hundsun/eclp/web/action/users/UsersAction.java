package com.hundsun.eclp.web.action.users;

import com.hundsun.eclp.biz.dao.RoleSystemDAO;
import com.hundsun.eclp.biz.domain.auth.Authority;
import com.hundsun.eclp.biz.domain.role.Role;
import com.hundsun.eclp.biz.domain.sys.SubSystem;
import com.hundsun.eclp.biz.domain.user.UserAgent;
import com.hundsun.eclp.biz.domain.user.UserInfo;
import com.hundsun.eclp.biz.domain.user.UserRole;
import com.hundsun.eclp.biz.domain.user.Users;
import com.hundsun.eclp.biz.query.UsersQuery;
import com.hundsun.eclp.biz.service.AuthorityService;
import com.hundsun.eclp.biz.service.RoleService;
import com.hundsun.eclp.biz.service.SubSystemService;
import com.hundsun.eclp.biz.service.UserInfoService;
import com.hundsun.eclp.biz.service.UserRoleService;
import com.hundsun.eclp.biz.service.UsersService;
import com.hundsun.eclp.common.BaseAction;
import com.hundsun.eclp.enums.EnumEducation;
import com.hundsun.eclp.enums.EnumRoleIsCore;
import com.hundsun.eclp.enums.EnumRoleStatus;
import com.hundsun.eclp.enums.EnumUserInfoIDType;
import com.hundsun.eclp.enums.EnumUserStatus;
import com.hundsun.eclp.enums.EnumUsersDegree;
import com.hundsun.eclp.enums.EnumUsersType;
import com.hundsun.eclp.enums.PermissionEnum;
import com.hundsun.eclp.security.AdminAccess;
import com.hundsun.eclp.util.FileHelper;
import com.hundsun.eclp.util.StringUtil;
import com.hundsun.eclp.web.validator.PasswordValidator;
import com.hundsun.eclp.web.validator.UserInfoValidator;
import com.hundsun.eclp.web.validator.UserValidator;
import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/users/"})
public class UsersAction extends BaseAction
{
  private final String PATH = ".htm";

  private final String USERS_LIST_PATH = "/users/users_list";

  private final String USERS_EDIT_PATH = "/users/users_edit";

  private final String USERS_ADD_PATH = "/users/users_add";

  private final String PASSWORD_EDIT_PATH = "/users/password_edit";

  private final String USER_INFO_PATH = "/users/user_info_edit";

  @Autowired
  private UsersService usersService;

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private UserValidator userValidator;

  @Autowired
  private UserInfoValidator userInfoValidator;

  @Autowired
  private PasswordValidator passwordValidator;

  @Autowired
  SubSystemService subSystemService;

  @Autowired
  private UserRoleService userRoleService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private AuthorityService authorityService;

  @Autowired
  RoleSystemDAO roleSystemDAO;
  private int startRow = 1;

  @InitBinder
  private void initBinder(WebDataBinder binder)
  {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    this.startRow = 1;
  }

  @RequestMapping({"users_list"})
  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_INFO, com.hundsun.eclp.enums.PermissionEnum.USER_QUERY})
  public String listInit(@ModelAttribute("query") UsersQuery query, @RequestParam(value="page", required=false, defaultValue="1") int page, ModelMap model, Cookyjar cookyjar, UserAgent userAgent)
  {
    query.setAgentUserType(userAgent.getUserType().toString());
    query.setCurrentPage(Integer.valueOf(page));

    StringUtil.trim(query);

    query = this.usersService.selectUsersByPage(query);
    model.addAttribute("enumUsersStatus", EnumUserStatus.values());
    model.addAttribute("enumUsersType", EnumUsersType.values());
    return "/users/users_list";
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_ADD})
  @RequestMapping(value={"users_add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void addUserInit(@ModelAttribute("user") Users user, @ModelAttribute("userInfo") UserInfo userInfo, ModelMap model)
  {
    initAddEditParam(model);
    initAddr(model, userInfo);
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_ADD})
  @RequestMapping(value={"users_add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String addUser(@ModelAttribute("user") Users user, BindingResult userResult, @ModelAttribute("userInfo") UserInfo userInfo, BindingResult infoResult, ModelMap model, UserAgent userAgent)
  {
    StringUtil.trim(user);

    StringUtil.trim(userInfo);

    this.userValidator.validate(user, userResult);
    userInfo.setRealName(user.getName());
    this.userInfoValidator.validate(userInfo, infoResult);
    if ((userResult.hasErrors()) || (infoResult.hasErrors()))
    {
      initAddEditParam(model);
      return "/users/users_add";
    }

    user.setUserInfo(userInfo);
    boolean flag = this.usersService.addUser(user, userAgent);
    model.addAttribute("url", "/users/users_list.htm");
    return flag == true ? "success" : "error";
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_EDIT})
  @RequestMapping(value={"users_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void editUserInit(@ModelAttribute("user") Users user, @RequestParam(value="page", required=false, defaultValue="1") int page, @ModelAttribute("userInfo") UserInfo userInfo, @RequestParam("userId") Long userId, ModelMap model)
  {
    user = this.usersService.selectUserById(userId);
    userInfo = this.userInfoService.selectUserInfoByUserId(userId);
    model.addAttribute("user", user);
    if (userInfo == null)
      userInfo = new UserInfo();
    else {
      userInfo.setUinfoId(userInfo.getId());
    }
    model.addAttribute("userInfo", userInfo);
    model.addAttribute("page", Integer.valueOf(page));

    initAddEditParam(model);
    initAddr(model, userInfo);
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_EDIT})
  @RequestMapping(value={"users_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String editUser(@RequestParam("userInfoDelete") String userInfoDelete, @RequestParam(value="page", required=false, defaultValue="1") int page, @ModelAttribute("user") Users user, BindingResult userResult, @ModelAttribute("userInfo") UserInfo userInfo, BindingResult infoResult, ModelMap model, UserAgent userAgent)
  {
    userInfo.setUserId(user.getId());

    StringUtil.trim(user);

    StringUtil.trim(userInfo);

    userInfo.setRealName(user.getName());
    userInfo.setId(null);
    userInfo.setId(userInfo.getUinfoId());

    this.userValidator.validate(user, userResult);
    this.userInfoValidator.validate(userInfo, infoResult);
    if ((userResult.hasErrors()) || (infoResult.hasErrors()))
    {
      initAddEditParam(model);
      return "/users/users_edit";
    }

    user.setUserInfo(userInfo);
    if ("Y".equals(userInfoDelete)) {
      user.setStatus(Short.valueOf((short) 2));
      userInfo.setStatus(Short.valueOf((short) 2));
    }
    boolean flag = this.usersService.updateUserWithInfo(user, userAgent);
    model.addAttribute("url", "/users/users_list.htm?page=" + page);
    model.addAttribute("editResult", Boolean.valueOf(flag));

    return null;
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_DEL})
  @RequestMapping({"users_delete"})
  @ResponseBody
  public Object deleteUser(@RequestParam("userId") Long userId, ModelMap model, UserAgent userAgent)
  {
    boolean flag = this.usersService.deleteUserById(userId, userAgent);
    return Boolean.valueOf(flag);
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_ENABLE, com.hundsun.eclp.enums.PermissionEnum.USER_DISABLE})
  @RequestMapping({"users_status_change"})
  @ResponseBody
  public Object changeStatus(@RequestParam("userId") Long id, ModelMap model, UserAgent userAgent)
  {
    Users user = this.usersService.selectUserById(id);

    boolean flag = this.usersService.updateUserStatus(user, userAgent);
    return Boolean.valueOf(flag);
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_PASS_RESET})
  @RequestMapping({"password_reset"})
  @ResponseBody
  public Object resetPassword(@RequestParam("userId") Long id, ModelMap model, UserAgent userAgent)
  {
    boolean flag = false;
    Users user = this.usersService.selectUserById(id);

    if ((user == null) || (user.getStatus().shortValue() == EnumUserStatus.DELETE_STATUS.getCode())) {
      model.addAttribute("message", "用户不存在或者已删除");
      return Boolean.valueOf(flag);
    }

    flag = this.usersService.resetPassword(user, userAgent);
    return Boolean.valueOf(flag);
  }

  @RequestMapping(value={"password_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void editPasswordInit(@ModelAttribute("user") Users user, ModelMap model)
  {
  }

  @RequestMapping(value={"password_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  
  @AdminAccess(value = { PermissionEnum.USER_PASS_RESET })
  public String editPassword(@ModelAttribute("user") Users user, Cookyjar cookyjar, ModelMap model, UserAgent userAgent)
  {
    user.setId(Long.valueOf(userAgent.getId()));

    user.setPassword(user.getNewPassword());
    boolean flag = this.usersService.updateUserPassword(user, userAgent);
    if (flag) {
      cookyjar.remove("eclpUserAgent");
      cookyjar.remove("userAgent");
      model.addAttribute("url", "/system/logout.htm");
      model.addAttribute("modifyPass", "Y");
      return null;
    }
    return "error";
  }

  @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_ROLE_ASSIGN})
  @RequestMapping(value={"assign_role"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String initAssignRole(@ModelAttribute("user") Users user, @RequestParam("userId") Long userId, @RequestParam(value="page", required=false, defaultValue="1") int page, ModelMap model)
  {
    Users u = null;
    if (userId != null) {
      u = this.usersService.selectUserById(userId);
      if (u != null) {
        model.addAttribute("user", u);

        List<UserRole> userRoleList = this.userRoleService.selectByUserId(userId);

        List<Role> allRoleList = this.roleService.getRoleList();

        List roleList = new ArrayList();

        if ((userRoleList != null) && (allRoleList != null)) {
          for (Role role : allRoleList)
          {
            if ((u.getUserType().intValue() == EnumUsersType.APPLICATION_LEVEL.getCode().intValue()) && 
              (role.getIsCore().intValue() == EnumRoleIsCore.BASIC.getCode().intValue()))
            {
              continue;
            }

            if (role.getStatus().intValue() == EnumRoleStatus.ENABLE.getCode()) {
              for (UserRole userRole : userRoleList) {
                if (role.getId().longValue() == userRole.getRoleId().longValue()) {
                  role.setIsSelected("Y");
                  break;
                }
              }
              roleList.add(role);
            }
          }
         }
         model.addAttribute("allRoleList", roleList);
       }
     }
 
     model.addAttribute("page", Integer.valueOf(page));
     return "/users/assign_role";
   }
 
   @RequestMapping(value={"view_auth"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_VIEW_AUTH})
   public String initAssignAuth(@ModelAttribute("user") Users user, @RequestParam("userId") Long userId, @RequestParam(value="page", required=false, defaultValue="1") int page, ModelMap model)
   {
     Users u = null;
     if (userId != null) {
       u = this.usersService.selectUserById(userId);
       if (u != null) {
         model.addAttribute("user", u);
 
         List authList = this.authorityService.getAllAuthListByUserId(userId);
         model.addAttribute("authList", authList);
       }
     }
     model.addAttribute("page", Integer.valueOf(page));
     return "/users/view_auth";
   }
 
   @RequestMapping(value={"auth_down"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
   public void authDownload(@RequestParam("userId") Long userId, HttpServletResponse response) throws IOException
   {
     Users u = null;
     if (userId != null) {
       u = this.usersService.selectUserById(userId);
       HSSFWorkbook wb = new HSSFWorkbook();
       String sheetTitle = u.getAccount() + "已分配的权限列表";
       HSSFSheet sheet = wb.createSheet(sheetTitle);
 
       initExportSheet(sheet, wb, u.getAccount());
       if (userId != null)
       {
         List authList = this.authorityService.getAllAuthListByUserId(userId);
         if ((authList != null) && (authList.size() > 0))
           getBook(sheet, authList);
       }
       FileHelper.ExportExcelReport(response, wb, sheetTitle);
     }
   }
 
   public void getBook(HSSFSheet sheet, List<Authority> authList)
   {
     for (int i = 0; i < authList.size(); i++)
     {
       this.startRow += 1;
       Authority auth = (Authority)authList.get(i);
       HSSFRow row = sheet.createRow((short)this.startRow);
 
       SubSystem subSystem = this.subSystemService.selectById(Long.valueOf(auth.getSubSystemId()));
       if (auth.getParentId().longValue() == -1L)
       {
         row.createCell(0).setCellValue(subSystem.getFullName());
       }
       row.createCell(1).setCellValue(auth.getName());
       if (auth.getCode() != null)
       {
         row.createCell(2).setCellValue(auth.getCode().longValue());
       }
       if ((auth.getChildList() == null) || (auth.getChildList().size() <= 0))
         continue;
       getBook(sheet, auth.getChildList());
     }
   }
 
   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.USER_ROLE_ASSIGN})
   @RequestMapping(value={"assign_role"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
   public String assignRole(@ModelAttribute("user") Users user, ModelMap model, @RequestParam(value="page", required=false, defaultValue="1") int page, UserAgent userAgent) {
     Long[] roleIdList = user.getRoleId();
     List userRoleList = new ArrayList();
     if (roleIdList != null) {
       UserRole userRole = new UserRole();
       for (Long roleId : roleIdList) {
         userRole = new UserRole();
         userRole.setRoleId(roleId);
         userRole.setUserId(user.getId());
         userRoleList.add(userRole);
       }
     }
     this.userRoleService.insert(user.getId(), userRoleList, userAgent);
     return "redirect:/users/users_list.htm?page=" + page;
   }
 
   @RequestMapping(value={"user_info_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
   public void userInfoEditInit(@ModelAttribute("user") Users user, @ModelAttribute("userInfo") UserInfo userInfo, @RequestParam("userId") Long userId, ModelMap model, UserAgent userAgent)
   {
     user = this.usersService.selectUserById(userId);
     userInfo = this.userInfoService.selectUserInfoByUserId(userId);
     if (userInfo == null) {
       userInfo = new UserInfo();
       userInfo.setUserId(user.getId());
       userInfo.setRealName(user.getName());
       userInfo.setStatus(user.getStatus());
     }
     model.addAttribute("user", user);
     model.addAttribute("userInfo", userInfo);
 
     initParam(model, userAgent);
     initAddr(model, userInfo);
   }
 
   @RequestMapping(value={"user_info_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
   public String userInfoEdit(@ModelAttribute("user") Users user, BindingResult userResult, @ModelAttribute("userInfo") UserInfo userInfo, BindingResult infoResult, ModelMap model, UserAgent userAgent)
   {
     user.setId(userInfo.getUserId());
     user.setName(userInfo.getRealName());
     userInfo.setStatus(user.getStatus());
 
     StringUtil.trim(user);
 
     StringUtil.trim(userInfo);
 
     this.userValidator.validate(user, userResult);
     this.userInfoValidator.validate(userInfo, infoResult);
 
     initParam(model, userAgent);
     initAddr(model, userInfo);
     if ((userResult.hasErrors()) || (infoResult.hasErrors())) {
       return "/users/user_info_edit";
     }
     user.setUserInfo(userInfo);
     boolean flag = this.usersService.updateUserWithInfo(user, userAgent);
     if (flag)
       model.addAttribute("success", "success");
     else
       model.addAttribute("fail", "fail");
     return "/users/user_info_edit";
   }
 
   public void initParam(ModelMap model, UserAgent userAgent)
   {
     List<SubSystem> sysList = this.subSystemService.getSubSystemByUserId(Long.valueOf(userAgent.getId()));
     if (sysList == null) {
       sysList = new ArrayList();
     }
 
     if (userAgent.isSuperUser())
     {
       List<SubSystem> _sysList = this.roleSystemDAO.selectSystemByUserId(Long.valueOf(userAgent.getId()));

      if ((_sysList != null) && (_sysList.size() > 0)) {
        for (SubSystem sys : _sysList) {
          Long id = sys.getId();
          for (SubSystem subsys : sysList) {
            if (id.longValue() == subsys.getId().longValue()) {
              id = null;
              break;
            }
          }
          if (id != null) {
            sysList.add(sys);
          }
        }
      }
    }

    model.addAttribute("sysList", sysList);

    model.addAttribute("enumUsersType", EnumUsersType.values());

    model.addAttribute("enumUserInfoIDType", EnumUserInfoIDType.values());

    model.addAttribute("enumEducation", EnumEducation.values());

    model.addAttribute("enumUsersDegree", EnumUsersDegree.values());
  }

  public void initAddEditParam(ModelMap model)
  {
    model.addAttribute("enumUsersType", EnumUsersType.values());

    model.addAttribute("enumUserInfoIDType", EnumUserInfoIDType.values());

    model.addAttribute("enumEducation", EnumEducation.values());

    model.addAttribute("enumUsersDegree", EnumUsersDegree.values());
  }

  private void initExportSheet(HSSFSheet sheet, HSSFWorkbook wb, String userAccount)
  {
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
    sheet.setColumnWidth(0, 4000);
    sheet.setColumnWidth(1, 4500);
    sheet.setColumnWidth(2, 2500);
    HSSFRow row1 = sheet.createRow(0);
    HSSFCell cell1 = row1.createCell(0);
    HSSFCellStyle cellStyle = wb.createCellStyle();
    cellStyle.setAlignment((short) 6);
    cell1.setCellStyle(cellStyle);
    cell1.setCellValue(userAccount + "已分配的权限");
    HSSFRow row2 = sheet.createRow(1);
    row2.createCell(0).setCellValue("子系统");
    row2.createCell(1).setCellValue("权限");
    row2.createCell(2).setCellValue("权限code");
  }
}
