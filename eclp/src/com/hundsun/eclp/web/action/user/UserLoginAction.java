/*     */ package com.hundsun.eclp.web.action.user;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.sys.SysConfig;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.service.LogService;
/*     */ import com.hundsun.eclp.biz.service.SysConfigService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.common.CheckCode;
/*     */ import com.hundsun.eclp.enums.EnumUserStatus;
/*     */ import com.hundsun.eclp.enums.ErrorEnum;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.util.crypto.Crypto;
/*     */ import com.hundsun.network.melody.common.util.crypto.impl.AESCryptoImpl;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import javax.servlet.http.Cookie;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/system"})
/*     */ public class UserLoginAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Value("${system.devMode}")
/*     */   private boolean devMode;
/*  42 */   private String rememberCookieName = "reme";
/*  43 */   private String curSubSystemCode = "curCode";
/*  44 */   private String loginFaildTimes = "fTimes";
/*  45 */   private int cookieMaxAge = 604800;
/*     */ 
/*     */   @Autowired
/*     */   UsersService userService;
/*     */ 
/*     */   @Autowired
/*     */   LogService logService;
/*     */ 
/*     */   @Autowired
/*     */   SysConfigService sysConfigService;
/*     */ 
/*  63 */   @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String login(@ModelAttribute("user") Users user, HttpServletRequest request, HttpServletResponse response, 
			Cookyjar cookyjar, @RequestParam(value="systemCode", required=false) String currentSystemCode, Model model) { 
				Cookie[] cookies = request.getCookies();
/*  64 */     if (cookies != null) {
/*  65 */       for (Cookie cookie : cookies) {
/*  66 */         if (cookie.getName().equals(this.rememberCookieName)) {
/*  67 */           Crypto crypto = new AESCryptoImpl();
/*  68 */           user.setAccount(crypto.dectypt(cookie.getValue()));
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  74 */     if (StringUtil.isNotEmpty(currentSystemCode)) {
/*  75 */       Cookie cookie = new Cookie(this.curSubSystemCode, currentSystemCode);
/*     */ 
/*  77 */       cookie.setMaxAge(-1);
/*  78 */       response.addCookie(cookie);
/*     */     }
/*     */ 
/*  81 */     getSystemTitle(model);
/*     */ 
/*  83 */     return "system/login";
/*     */   }
/*     */ 
/*     */   private void getSystemTitle(Model model)
/*     */   {
/*  88 */     SysConfig con = this.sysConfigService.selectSysConfigByCode("system_title");
/*  89 */     if (con != null)
/*  90 */       model.addAttribute("systemTitle", con.getValue());
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String checkLogin(@ModelAttribute("user") Users user, Cookyjar cookyjar, Model model, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  99 */     String loginIp = getIpAddr(request);
/*     */ 
/* 101 */     SysConfig con = this.sysConfigService.selectSysConfigByCode("system_title");
/* 102 */     if (con != null) {
/* 103 */       model.addAttribute("systemTitle", con.getValue());
/*     */     }
/* 105 */     if (!checkUserStatus(user, loginIp, model, request))
/*     */     {
/* 107 */       getSystemTitle(model);
/* 108 */       return "system/login";
/*     */     }
/*     */ 
/* 111 */     int loginFailedTimes = getLoginFailedTimesFromCookie(request);
/*     */ 
/* 113 */     if (loginFailedTimes >= 3) {
/* 114 */       String checkCode = request.getParameter("checkcode");
/* 115 */       this._log.debug("get checkcode from request : " + checkCode);
/* 116 */       CheckCode code = (CheckCode)cookyjar.getObject("code");
/*     */ 
/* 118 */       if ((StringUtil.isEmpty(checkCode)) || (!checkCode.equals(code.getLoginCheckCode()))) {
/* 119 */         model.addAttribute("tips", ErrorEnum.INCORRECT_CHECK_CODE_ERROR.getDesc());
/* 120 */         model.addAttribute("failedTimes", Integer.valueOf(loginFailedTimes));
/* 121 */         user.setPassword(null);
/* 122 */         model.addAttribute("user", user);
/*     */ 
/* 124 */         Users dbuser = getUserByAccount(user.getAccount());
/* 125 */         this.logService.createLoginLog(dbuser, loginIp, false, ErrorEnum.INCORRECT_CHECK_CODE_ERROR.getDesc(), request.getRemoteAddr());
/*     */ 
/* 127 */         getSystemTitle(model);
/* 128 */         return "system/login";
/*     */       }
/*     */     }
/*     */ 
/* 132 */     String currentSystemCode = getCurrentSystemCodeFromCookie(request);
/* 133 */     user.setSource("login");
/*     */ 
/* 135 */     if (this.userService.login(user, loginIp, currentSystemCode, cookyjar)) {
/* 136 */       setCookie(response, user, request.getParameter("remember") != null);
/*     */ 
/* 138 */       removeCookie(request, response, this.curSubSystemCode);
/*     */ 
/* 140 */       this.logService.createLoginLog(user, loginIp, true, "登陆成功", request.getRemoteAddr());
/*     */ 
/* 142 */       model.addAttribute("failedTimes", Integer.valueOf(0));
/* 143 */       removeCookie(request, response, this.loginFaildTimes);
/*     */ 
/* 145 */       return "redirect:/index.htm";
/*     */     }
/* 147 */     setUnEncryptCookie(response, this.loginFaildTimes, String.valueOf(loginFailedTimes + 1));
/* 148 */     model.addAttribute("failedTimes", Integer.valueOf(loginFailedTimes + 1));
/* 149 */     model.addAttribute("tips", ErrorEnum.INCORRECT_USERNAME_OR_PASSWORD_ERROR.getDesc());
/*     */ 
/* 151 */     this.logService.createLoginLog(user, loginIp, false, ErrorEnum.INCORRECT_USERNAME_OR_PASSWORD_ERROR.getDesc(), request.getRemoteAddr());
/*     */ 
/* 153 */     user.setPassword(null);
/* 154 */     model.addAttribute("user", user);
/*     */ 
/* 156 */     getSystemTitle(model);
/*     */ 
/* 158 */     return "system/login";
/*     */   }
/*     */ 
/*     */   private String getIpAddr(HttpServletRequest request) {
/* 162 */     String ipAddress = null;
/*     */ 
/* 164 */     ipAddress = request.getHeader("x-forwarded-for");
/* 165 */     if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress)))
/*     */     {
/* 167 */       ipAddress = request.getHeader("Proxy-Client-IP");
/*     */     }
/* 169 */     if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress)))
/*     */     {
/* 171 */       ipAddress = request.getHeader("WL-Proxy-Client-IP");
/*     */     }
/* 173 */     if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress)))
/*     */     {
/* 175 */       ipAddress = request.getRemoteAddr();
/* 176 */       if (ipAddress.equals("127.0.0.1"))
/*     */       {
/* 178 */         InetAddress inet = null;
/*     */         try {
/* 180 */           inet = InetAddress.getLocalHost();
/*     */         } catch (UnknownHostException e) {
/* 182 */           e.printStackTrace();
/*     */         }
/* 184 */         ipAddress = inet.getHostAddress();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 190 */     if ((ipAddress != null) && (ipAddress.length() > 15))
/*     */     {
/* 192 */       if (ipAddress.indexOf(",") > 0) {
/* 193 */         ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
/*     */       }
/*     */     }
/* 196 */     return ipAddress;
/*     */   }
/*     */ 
/*     */   private boolean checkUserStatus(Users user, String loginIp, Model model, HttpServletRequest request) {
/* 200 */     Users dbuser = getUserByAccount(user.getAccount());
/* 201 */     if (dbuser == null) {
/* 202 */       model.addAttribute("tips", ErrorEnum.INCORRECT_USERNAME_ERROR.getDesc());
/*     */ 
/* 204 */       user.setLastLoginIp(request.getRemoteAddr());
/* 205 */       this.logService.createLoginLog(user, loginIp, false, ErrorEnum.INCORRECT_USERNAME_ERROR.getDesc(), request.getRemoteAddr());
/* 206 */       return false;
/*     */     }
/* 208 */     if (EnumUserStatus.DELETE_STATUS.getCode() == dbuser.getStatus().shortValue()) {
/* 209 */       model.addAttribute("tips", ErrorEnum.INCORRECT_CHECK_DEL_STATUS_ERROR.getDesc());
/*     */ 
/* 211 */       this.logService.createLoginLog(dbuser, loginIp, false, ErrorEnum.INCORRECT_CHECK_DEL_STATUS_ERROR.getDesc(), request.getRemoteAddr());
/* 212 */       return false;
/*     */     }
/* 214 */     if (EnumUserStatus.DISUSE_STATUS.getCode() == dbuser.getStatus().shortValue()) {
/* 215 */       model.addAttribute("tips", ErrorEnum.INCORRECT_CHECK_DISUSE_STATUS_ERROR.getDesc());
/*     */ 
/* 217 */       this.logService.createLoginLog(dbuser, loginIp, false, ErrorEnum.INCORRECT_CHECK_DISUSE_STATUS_ERROR.getDesc(), request.getRemoteAddr());
/* 218 */       return false;
/*     */     }
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */   public Users getUserByAccount(String account)
/*     */   {
/* 225 */     return this.userService.queryUserByAccount(account);
/*     */   }
/*     */ 
/*     */   private void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
/* 229 */     Cookie[] cookies = request.getCookies();
/* 230 */     if (cookies != null)
/* 231 */       for (Cookie cookie : cookies)
/* 232 */         if (cookie.getName().equals(name)) {
/* 233 */           cookie.setMaxAge(0);
/* 234 */           response.addCookie(cookie);
/*     */         }
/*     */   }
/*     */ 
/*     */   private String getCurrentSystemCodeFromCookie(HttpServletRequest request)
/*     */   {
/* 242 */     Cookie[] cookies = request.getCookies();
/* 243 */     if (cookies != null) {
/* 244 */       for (Cookie cookie : cookies) {
/* 245 */         if (cookie.getName().equals(this.curSubSystemCode)) {
/* 246 */           return cookie.getValue();
/*     */         }
/*     */       }
/*     */     }
/* 250 */     return "";
/*     */   }
/*     */ 
/*     */   private int getLoginFailedTimesFromCookie(HttpServletRequest request)
/*     */   {
/* 255 */     Cookie[] cookies = request.getCookies();
/* 256 */     if (cookies != null) {
/* 257 */       for (Cookie cookie : cookies) {
/* 258 */         if (cookie.getName().equals(this.loginFaildTimes)) {
/* 259 */           return Integer.valueOf(cookie.getValue()).intValue();
/*     */         }
/*     */       }
/*     */     }
/* 263 */     return 0;
/*     */   }
/*     */ 
/*     */   private void setCookie(HttpServletResponse response, Users user, boolean isSavePassword)
/*     */   {
/* 269 */     if (isSavePassword) {
/* 270 */       Crypto crypto = new AESCryptoImpl();
/* 271 */       Cookie cookie = new Cookie(this.rememberCookieName, crypto.encrypt(user.getAccount()));
/* 272 */       cookie.setMaxAge(this.cookieMaxAge);
/*     */ 
/* 276 */       response.addCookie(cookie);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void setUnEncryptCookie(HttpServletResponse response, String name, String value)
/*     */   {
/* 282 */     Cookie cookie = new Cookie(name, value);
/* 283 */     cookie.setMaxAge(-1);
/* 284 */     response.addCookie(cookie);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/logout"})
/*     */   public String logout(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 300 */     removeCookies(request, response);
/* 301 */     return "redirect:/system/login.htm";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.user.UserLoginAction
 * JD-Core Version:    0.6.0
 */