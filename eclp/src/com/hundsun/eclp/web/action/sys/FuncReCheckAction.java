/*     */ package com.hundsun.eclp.web.action.sys;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.auth.FuncRecheck;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.service.FuncRecheckService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.enums.EnumFuncReCheckStatus;
/*     */ import com.hundsun.eclp.enums.EnumFuncReCheckType;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.util.digest.MessageDigest;
/*     */ import com.hundsun.network.melody.common.util.digest.impl.MD5MessageDigestImpl;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/sys"})
/*     */ public class FuncReCheckAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   FuncRecheckService funcCheckerService;
/*     */ 
/*     */   @Autowired
/*     */   UsersService userService;
/*     */ 
/*     */   @RequestMapping({"/func_recheck_list"})
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK})
/*     */   public String list(Model model, UserAgent user)
/*     */   {
/*  36 */     model.addAttribute("funcRecheckList", this.funcCheckerService.selectAll());
/*  37 */     return "/system/func_recheck_list";
/*     */   }
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK_ADD})
/*     */   @RequestMapping({"/add_func_recheck"})
/*     */   public String doAdd(Model model, UserAgent user, @ModelAttribute("funcCheck") FuncRecheck checker) {
/*  44 */     model.addAttribute("funcRecheckList", EnumFuncReCheckType.toList());
/*  45 */     return "/system/func_recheck_add";
/*     */   }
/*  51 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK_ADD, com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK_EDIT})
/*     */   @RequestMapping({"/save_func_recheck"})
/*     */   public String add(Model model, UserAgent user, @ModelAttribute("funcCheck") FuncRecheck checker) { checker.setFuncName(EnumFuncReCheckType.getDesc(checker.getFuncCode()));
/*  52 */     checker.setStatus(Short.valueOf(EnumFuncReCheckStatus.ENABLE.getCode()));
/*  53 */     String isAdd = "Y";
/*  54 */     if (checker.getId() != null) {
/*  55 */       isAdd = "N";
/*     */     }
/*  57 */     if (StringUtil.isNotBlank(checker.getFuncChecker())) {
/*  58 */       checker.setFuncChecker(checker.getFuncChecker().trim());
/*     */     }
/*  60 */     Long id = this.funcCheckerService.insertOrUpdate(checker);
/*  61 */     if (id == null) {
/*  62 */       if ("Y".equalsIgnoreCase(isAdd))
/*  63 */         model.addAttribute("message", "复核功能添加失败");
/*     */       else {
/*  65 */         model.addAttribute("message", "复核功能编辑失败");
/*     */       }
/*  67 */       return "error";
/*     */     }
/*  69 */     if ("Y".equalsIgnoreCase(isAdd))
/*  70 */       model.addAttribute("message", "复核功能添加成功");
/*     */     else {
/*  72 */       model.addAttribute("message", "复核功能编辑成功");
/*     */     }
/*     */ 
/*  75 */     model.addAttribute("url", "/sys/func_recheck_list.htm");
/*  76 */     return "success"; } 
/*  81 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK_EDIT})
/*     */   @RequestMapping({"/edit_func_recheck"})
/*     */   public String doEdit(Model model, UserAgent user, @RequestParam("id") Long id) { if (id == null) {
/*  82 */       model.addAttribute("message", "参数为空");
/*  83 */       return "error";
/*     */     }
/*  85 */     FuncRecheck check = this.funcCheckerService.selectById(id);
/*  86 */     if (check == null) {
/*  87 */       model.addAttribute("message", "复核功能记录不存在");
/*  88 */       return "error";
/*     */     }
/*  90 */     model.addAttribute("funcRecheckList", EnumFuncReCheckType.toList());
/*  91 */     model.addAttribute("funcCheck", check);
/*  92 */     return "/system/func_recheck_edit"; } 
/*  97 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK_DEL})
/*     */   @RequestMapping({"/do_del"})
/*     */   @ResponseBody
/*     */   public String doDel(Model model, @RequestParam("id") Long id) { FuncRecheck check = this.funcCheckerService.selectById(id);
/*  98 */     if (check == null) {
/*  99 */       return "null";
/*     */     }
/* 101 */     int rows = this.funcCheckerService.deleteById(id);
/* 102 */     if (rows == 0) {
/* 103 */       return "error";
/*     */     }
/* 105 */     return "success"; } 
/* 110 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK_ENABLE, com.hundsun.eclp.enums.PermissionEnum.FUNC_CHECK_DISABLE})
/*     */   @RequestMapping({"/do_up_status"})
/*     */   @ResponseBody
/*     */   public String doUpStatus(Model model, @RequestParam("id") Long id, @RequestParam("flag") String flag) { FuncRecheck check = this.funcCheckerService.selectById(id);
/* 111 */     if (check == null) {
/* 112 */       return "null";
/*     */     }
/* 114 */     if ("Y".equals(flag))
/* 115 */       check.setStatus(Short.valueOf(EnumFuncReCheckStatus.ENABLE.getCode()));
/* 116 */     else if ("N".equals(flag)) {
/* 117 */       check.setStatus(Short.valueOf(EnumFuncReCheckStatus.DISABLE.getCode()));
/*     */     }
/* 119 */     int rows = this.funcCheckerService.update(check);
/* 120 */     if (rows == 0) {
/* 121 */       return "error";
/*     */     }
/* 123 */     return "success"; } 
/* 128 */   @RequestMapping({"/do_check"})
/*     */   @ResponseBody
/*     */   public String doCheck(Model model, @RequestParam("funcCode") String funcCode) { FuncRecheck check = this.funcCheckerService.selectByFuncCode(funcCode);
/* 129 */     if (check != null) {
/* 130 */       return "exist";
/*     */     }
/* 132 */     return "success"; } 
/* 136 */   @RequestMapping({"/do_check_user"})
/*     */   @ResponseBody
/*     */   public String doCheckUser(Model model, @RequestParam("account") String account) { if (StringUtil.isBlank(account)) {
/* 137 */       return "null";
/*     */     }
/* 139 */     account = account.trim();
/* 140 */     String[] accounts = account.split(",");
/* 141 */     if (accounts.length > 5) {
/* 142 */       return "checkError";
/*     */     }
/* 144 */     String tempStr = "";
/* 145 */     for (String acc : accounts) {
/* 146 */       if (StringUtil.isBlank(acc)) {
/* 147 */         return "patternError";
/*     */       }
/* 149 */       Users user = this.userService.getUserByAccount(acc.trim());
/* 150 */       if (user == null) {
/* 151 */         tempStr = tempStr + acc.trim() + "、";
/*     */       }
/*     */     }
/* 154 */     if (StringUtil.isNotBlank(tempStr)) {
/* 155 */       if (tempStr.endsWith("、")) {
/* 156 */         tempStr = tempStr.substring(0, tempStr.lastIndexOf("、"));
/*     */       }
/* 158 */       return "error," + tempStr;
/*     */     }
/* 160 */     return "success"; } 
/* 165 */   @RequestMapping({"/get_func_checker"})
/*     */   @ResponseBody
/*     */   public List<Users> getFuncChecker(UserAgent user, @RequestParam("funcCode") String funcCode) { FuncRecheck check = this.funcCheckerService.selectByFuncCode(funcCode);
/* 166 */     if (check == null) {
/* 167 */       return null;
/*     */     }
/* 169 */     if ((EnumFuncReCheckStatus.ENABLE.getCode() == check.getStatus().shortValue()) && 
/* 170 */       (check != null) && (StringUtil.isNotBlank(check.getFuncChecker()))) {
/* 171 */       List usersList = new ArrayList();
/* 172 */       String account = check.getFuncChecker().trim();
/* 173 */       String[] accounts = account.split(",");
/* 174 */       for (String acc : accounts) {
/* 175 */         if (!StringUtil.isNotBlank(acc))
/*     */           continue;
/* 177 */         Users dbuser = this.userService.getUserByAccount(acc.trim());
/* 178 */         if (dbuser == null)
/*     */           continue;
/* 180 */         if (dbuser.getId().longValue() == user.getId()) {
/* 181 */           return null;
/*     */         }
/* 183 */         usersList.add(dbuser);
/*     */       }
/*     */ 
/* 187 */       if (usersList.size() > 0) {
/* 188 */         return usersList;
/*     */       }
/*     */     }
/* 191 */     return null; } 
/* 196 */   @RequestMapping({"/check_password"})
/*     */   @ResponseBody
/*     */   public String getFuncChecker(@RequestParam("funcCode") String funcCode, @RequestParam("checker") String checker, @RequestParam("password") String password) { FuncRecheck check = this.funcCheckerService.selectByFuncCode(funcCode);
/* 197 */     if ((check != null) && (StringUtil.isNotBlank(check.getFuncChecker()))) {
/* 198 */       String[] accounts = check.getFuncChecker().split(",");
/* 199 */       String account = "";
/* 200 */       for (String acc : accounts) {
/* 201 */         if (acc.trim().equals(checker)) {
/* 202 */           account = acc.trim();
/* 203 */           break;
/*     */         }
/*     */       }
/* 206 */       if (StringUtil.isBlank(account)) {
/* 207 */         return "userError";
/*     */       }
/* 209 */       Users dbuser = this.userService.getUserByAccount(account);
/* 210 */       if (dbuser == null) {
/* 211 */         return "nullUser";
/*     */       }
/* 213 */       if (!checkPassword(password, dbuser)) {
/* 214 */         return "passwordFail";
/*     */       }
/*     */     }
/* 217 */     return "success"; }
/*     */ 
/*     */   private boolean checkPassword(String password, Users account)
/*     */   {
/* 221 */     MessageDigest digest = new MD5MessageDigestImpl();
/* 222 */     if (digest.digest(password).equals(account.getPassword())) {
/* 223 */       return Boolean.TRUE.booleanValue();
/*     */     }
/* 225 */     return Boolean.FALSE.booleanValue();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.sys.FuncReCheckAction
 * JD-Core Version:    0.6.0
 */