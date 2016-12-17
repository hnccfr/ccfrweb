package com.hundsun.eclp.common;

import com.hundsun.eclp.biz.domain.user.UserInfo;
import com.hundsun.eclp.biz.service.sys.RegionService;
import com.hundsun.eclp.enums.EnumRegionType;
import com.hundsun.network.melody.common.util.StringUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

public class BaseAction {
	protected final Log _log = LogFactory.getLog(getClass());

	@Value("${app.domain}")
	private String domain;

	@Autowired
	private RegionService regionService;

	protected String success(Model model, String message) {
		model.addAttribute("message", message);
		return "success";
	}

	protected String success(ModelMap model, String message) {
		model.addAttribute("message", message);
		return "success";
	}

	protected String error(Model model, String message) {
		model.addAttribute("message", message);
		return "error";
	}

	protected String error(ModelMap model, String message) {
		model.addAttribute("message", message);
		return "error";
	}

	protected void removeCookies(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if ((null != cookies) && (cookies.length > 0))
			for (Cookie cookie : cookies)
				response.addCookie(delCookie(cookie.getName()));
	}

	private Cookie delCookie(String cookieName) {
		Cookie newCookie = new Cookie(cookieName, null);
		newCookie.setMaxAge(0);
		newCookie.setPath("/");
		newCookie.setDomain(this.domain);
		return newCookie;
	}

	protected void initAddr(ModelMap model, UserInfo userInfo) {
		model.addAttribute("provinceList",
				this.regionService.getRegionByType(EnumRegionType.PROVINCE));

		if (StringUtil.isNotBlank(userInfo.getRegCityCode())) {
			model.addAttribute("cityList", this.regionService
					.getChildRegionList(EnumRegionType.CITY,
							userInfo.getRegProvinceCode()));
		}

		if (StringUtil.isNotBlank(userInfo.getRegDistrictCode()))
			model.addAttribute("districtList", this.regionService
					.getChildRegionList(EnumRegionType.DISTRICT,
							userInfo.getRegCityCode()));
	}
}