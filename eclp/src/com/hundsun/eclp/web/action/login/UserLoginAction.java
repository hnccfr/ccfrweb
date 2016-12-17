package com.hundsun.eclp.web.action.login;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.eclp.biz.domain.sys.SysConfig;
import com.hundsun.eclp.biz.domain.user.Users;
import com.hundsun.eclp.biz.service.LogService;
import com.hundsun.eclp.biz.service.SysConfigService;
import com.hundsun.eclp.biz.service.UsersService;
import com.hundsun.eclp.common.BaseAction;
import com.hundsun.eclp.common.CheckCode;
import com.hundsun.eclp.enums.EnumUserStatus;
import com.hundsun.eclp.enums.ErrorEnum;
import com.hundsun.network.melody.common.util.StringUtil;
import com.hundsun.network.melody.common.util.crypto.Crypto;
import com.hundsun.network.melody.common.util.crypto.impl.AESCryptoImpl;
import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;

@Controller
@RequestMapping({ "/system" })
public class UserLoginAction extends BaseAction {

	@Value("${system.devMode}")
	private boolean devMode;
	private String rememberCookieName = "reme";
	private String curSubSystemCode = "curCode";
	private String loginFaildTimes = "fTimes";
	private int cookieMaxAge = 604800;

	@Autowired
	UsersService userService;

	@Autowired
	LogService logService;

	@Autowired
	SysConfigService sysConfigService;

	@RequestMapping(value = { "/login" }, method={RequestMethod.GET })
	public String login(HttpServletRequest request,	HttpServletResponse response,
			@ModelAttribute("user") Users user,Cookyjar cookyjar,
			@RequestParam(value = "systemCode", required = false) String currentSystemCode,
			Model model) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(this.rememberCookieName)) {
					Crypto crypto = new AESCryptoImpl();
					user.setAccount(crypto.dectypt(cookie.getValue()));
				}
			}
		}

		if (StringUtil.isNotEmpty(currentSystemCode)) {
			Cookie cookie = new Cookie(this.curSubSystemCode, currentSystemCode);

			cookie.setMaxAge(-1);
			response.addCookie(cookie);
		}

		getSystemTitle(model);

		return "system/login";
	}

	private void getSystemTitle(Model model) {
		SysConfig con = this.sysConfigService.selectSysConfigByCode("system_title");
		if (con != null)
			model.addAttribute("systemTitle", con.getValue());
	}

	@RequestMapping(value = { "/login" }, method = {RequestMethod.POST })
	public String checkLogin(@ModelAttribute("user") Users user,
			Cookyjar cookyjar, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String loginIp = getIpAddr(request);

		SysConfig con = this.sysConfigService.selectSysConfigByCode("system_title");
		if (con != null) {
			model.addAttribute("systemTitle", con.getValue());
		}
		
		//检测用户状态，如果用户不存在、被删除、禁用不能登陆
		if (!checkUserStatus(user, loginIp, model, request)) {
			getSystemTitle(model);
			return "system/login";
		}

		//登陆次数超过3次
		int loginFailedTimes = getLoginFailedTimesFromCookie(request);

		if (loginFailedTimes >= 3) {
			String checkCode = request.getParameter("checkcode");
			this._log.debug("get checkcode from request : " + checkCode);
			CheckCode code = (CheckCode) cookyjar.getObject("code");

			if ((StringUtil.isEmpty(checkCode)) || (!checkCode.equals(code.getLoginCheckCode()))) {
				model.addAttribute("tips", ErrorEnum.INCORRECT_CHECK_CODE_ERROR.getDesc());
				model.addAttribute("failedTimes", Integer.valueOf(loginFailedTimes));
				user.setPassword(null);
				model.addAttribute("user", user);

				Users dbuser = getUserByAccount(user.getAccount());
				this.logService.createLoginLog(dbuser, loginIp, false, 
						ErrorEnum.INCORRECT_CHECK_CODE_ERROR.getDesc(),request.getRemoteAddr());
				getSystemTitle(model);
				return "system/login";
			}
		}

		String currentSystemCode = getCurrentSystemCodeFromCookie(request);
		user.setSource("login");

		//登陆成功
		if (this.userService.login(user, loginIp, currentSystemCode, cookyjar)) {
			setCookie(response, user, request.getParameter("remember") != null);

			removeCookie(request, response, this.curSubSystemCode);

			this.logService.createLoginLog(user, loginIp, true, "登陆成功",
					request.getRemoteAddr());

			model.addAttribute("failedTimes", Integer.valueOf(0));
			removeCookie(request, response, this.loginFaildTimes);

			return "redirect:/index.htm";
		}
		//登陆失败
		setUnEncryptCookie(response, this.loginFaildTimes,String.valueOf(loginFailedTimes + 1));
		model.addAttribute("failedTimes", Integer.valueOf(loginFailedTimes + 1));
		model.addAttribute("tips",ErrorEnum.INCORRECT_USERNAME_OR_PASSWORD_ERROR.getDesc());

		this.logService.createLoginLog(user, loginIp, false,
				ErrorEnum.INCORRECT_USERNAME_OR_PASSWORD_ERROR.getDesc(),request.getRemoteAddr());

		user.setPassword(null);
		model.addAttribute("user", user);

		getSystemTitle(model);

		return "system/login";
	}

	private String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;

		ipAddress = request.getHeader("x-forwarded-for");
		if ((ipAddress == null) || (ipAddress.length() == 0)
				|| ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0)
				|| ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0)
				|| ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}

		if ((ipAddress != null) && (ipAddress.length() > 15)) {
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	private boolean checkUserStatus(Users user, String loginIp, Model model,
			HttpServletRequest request) {
		Users dbuser = getUserByAccount(user.getAccount());
		if (dbuser == null) {
			model.addAttribute("tips", ErrorEnum.INCORRECT_USERNAME_ERROR.getDesc());

			user.setLastLoginIp(request.getRemoteAddr());
			this.logService.createLoginLog(user, loginIp, false,
					ErrorEnum.INCORRECT_USERNAME_ERROR.getDesc(), request.getRemoteAddr());
			return false;
		}
		if (EnumUserStatus.DELETE_STATUS.getCode() == dbuser.getStatus() .shortValue()) {
			model.addAttribute("tips", ErrorEnum.INCORRECT_CHECK_DEL_STATUS_ERROR.getDesc());

			this.logService.createLoginLog(dbuser, loginIp, false,
					ErrorEnum.INCORRECT_CHECK_DEL_STATUS_ERROR.getDesc(), request.getRemoteAddr());
			return false;
		}
		if (EnumUserStatus.DISUSE_STATUS.getCode() == dbuser.getStatus() .shortValue()) {
			model.addAttribute("tips", ErrorEnum.INCORRECT_CHECK_DISUSE_STATUS_ERROR.getDesc());

			this.logService.createLoginLog(dbuser, loginIp, false,
					ErrorEnum.INCORRECT_CHECK_DISUSE_STATUS_ERROR.getDesc(), request.getRemoteAddr());
			return false;
		}
		return true;
	}

	public Users getUserByAccount(String account) {
		return this.userService.queryUserByAccount(account);
	}

	private void removeCookie(HttpServletRequest request,
			HttpServletResponse response, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals(name)) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
	}

	private String getCurrentSystemCodeFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(this.curSubSystemCode)) {
					return cookie.getValue();
				}
			}
		}
		return "";
	}

	private int getLoginFailedTimesFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(this.loginFaildTimes)) {
					return Integer.valueOf(cookie.getValue()).intValue();
				}
			}
		}
		return 0;
	}

	private void setCookie(HttpServletResponse response, Users user,
			boolean isSavePassword) {
		if (isSavePassword) {
			Crypto crypto = new AESCryptoImpl();
			Cookie cookie = new Cookie(this.rememberCookieName,
					crypto.encrypt(user.getAccount()));
			cookie.setMaxAge(this.cookieMaxAge);

			response.addCookie(cookie);
		}
	}

	private void setUnEncryptCookie(HttpServletResponse response, String name,
			String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
	}

	@RequestMapping({ "/logout" })
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		removeCookies(request, response);
		return "redirect:/system/login.htm";
	}
}