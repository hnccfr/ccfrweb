package com.hundsun.eclp.web.action.index;

import com.hundsun.eclp.biz.dao.RoleSystemDAO;
import com.hundsun.eclp.biz.domain.auth.Authority;
import com.hundsun.eclp.biz.domain.sys.SubSystem;
import com.hundsun.eclp.biz.domain.sys.SysConfig;
import com.hundsun.eclp.biz.domain.user.UserAgent;
import com.hundsun.eclp.biz.service.AuthorityService;
import com.hundsun.eclp.biz.service.SubSystemService;
import com.hundsun.eclp.biz.service.SysConfigService;
import com.hundsun.eclp.biz.service.UsersService;
import com.hundsun.eclp.biz.service.common.CookieWriter;
import com.hundsun.eclp.common.BaseAction;
import com.hundsun.eclp.enums.EnumAuthorityType;
import com.hundsun.eclp.security.AdminAccess;
import com.hundsun.eclp.util.DateUtil;
import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexAction extends BaseAction
{

	@Autowired
	SubSystemService subSystemService;

	@Autowired
	AuthorityService authorityService;

	@Autowired
	SysConfigService sysConfigService;

	@Autowired
	CookieWriter cookieWriter;

	@Autowired
	UsersService userService;

	@Autowired
	RoleSystemDAO roleSystemDAO;

	@RequestMapping({ "/index" })
	@AdminAccess(value = {})
	public String index(Model model, UserAgent user) {
		if (user == null) {
			return "redirect:system/login.htm";
		}

		SysConfig con = this.sysConfigService.selectSysConfigByCode("system_title");
		if (con != null){
			model.addAttribute("systemTitle", con.getValue());
		}
		return "main/index";
//		return "system/index";
	}

	@RequestMapping({"/contain/crmheader"})
	@AdminAccess(value = {  })
	public String header(UserAgent user, Model model)
	{
		if (user == null) {
			return "system/login";
		}

		List<SubSystem> sysList = this.subSystemService.getSubSystemByUserId(Long.valueOf(user.getId()));
		if (sysList == null) {
			sysList = new ArrayList();
		}

		List _sysList = this.roleSystemDAO.selectSystemByUserId(Long.valueOf(user.getId()));

		sysList.addAll(_sysList);

		Map map = new HashMap();
		List subSysList = new ArrayList();

		for (SubSystem subsys : sysList) {
			if (!map.containsKey(subsys.getId())) {
				map.put(subsys.getId(), null);
				subSysList.add(subsys);
			}
		}

	  model.addAttribute("sysList", subSysList);
	  initSysConfig(model);
//	  return "contain/crmheader";
	  return "main/header";
	}
	
	@RequestMapping({"/contain/crmmenu"})
	@AdminAccess(value = {  })
	public String menu(UserAgent user, Model model, @RequestParam(value="subSysId", required=false) Long subSysId, Cookyjar cookyjar) { if (user == null) {
	    return "system/login";
	  }
	  String currSysCode = null;
	  SubSystem subSys = null;
	  if (subSysId != null) {
	    subSys = this.subSystemService.selectById(subSysId);
	    if (subSys != null) {
	      currSysCode = subSys.getName();
	      model.addAttribute("subSys", subSys);
	    }
	  }
	  if (StringUtils.isBlank(currSysCode)) {
	    currSysCode = user.getCurrentSystemCode();
	    subSys = this.subSystemService.selectByCode(currSysCode);
	    model.addAttribute("subSys", subSys);
	  }
	  this._log.debug("user.getCurrentSystemCode()====" + user.getCurrentSystemCode());
	  if (currSysCode != null)
	  {
	    this.cookieWriter.updateUserAgentPermissionBySubsystem(user, cookyjar, currSysCode);
	  }
	
	  this._log.debug("currSysCode====" + currSysCode);
	  if (StringUtils.isNotBlank(currSysCode)) {
	    List<Authority> authList = new ArrayList<Authority>();
	    this._log.debug("user.isSuperUser()====" + user.isSuperUser());
	
	    if (user.isSuperUser())
	    {
	      authList = this.authorityService.selectMenuBySubsystem(subSys.getId());
	    }
	    else {
	      authList = this.authorityService.selectMenuByUserAndSubsystem(Long.valueOf(user.getId()), currSysCode);
	    }
	
	    if (authList != null) {
	      List menuList = new ArrayList();
	      for (Authority auth : authList) {
	        if (auth.getType().shortValue() == EnumAuthorityType.MENU_BAR.getCode()) {
	          List childList = new ArrayList();
	          for (Authority child : authList) {
	            if ((child.getType().shortValue() == EnumAuthorityType.MENU.getCode()) && (auth.getId().longValue() == child.getParentId().longValue()))
	            {
	              childList.add(child);
	            }
	          }
	          auth.setChildList(childList);
	          menuList.add(auth);
	        }
	      }
	      model.addAttribute("menuList", menuList);
	    }
	  }
	
	  initSysConfig(model);
//	  return "contain/crmmenu";
	  return "main/menu";
	}

private void initSysConfig(Model model)
{
  List<SysConfig> list = this.sysConfigService.selectAllSysConfig();
  if ((list != null) && (list.size() > 0))
    for (SysConfig sys : list)
      if ("system_logo".equalsIgnoreCase(sys.getCode()))
      {
        model.addAttribute("systemLogo", sys.getValue());
      } else if ("system_style".equalsIgnoreCase(sys.getCode()))
      {
        model.addAttribute("systemStyle", sys.getValue());
      } else if ("system_name".equalsIgnoreCase(sys.getCode()))
      {
        model.addAttribute("systemName", sys.getValue());
      } else if ("system_title".equalsIgnoreCase(sys.getCode()))
      {
        model.addAttribute("title", sys.getValue());
      }
}

@RequestMapping({"/contain/crmbody"})
@AdminAccess(value = {  })
public String body(Model model, UserAgent user)
{
   SysConfig con = this.sysConfigService.selectSysConfigByCode("system_name");
   if (con != null) {
     model.addAttribute("systemName", con.getValue());
   }
   if (StringUtils.isNotBlank(user.getCurrentSystemCode())) {
     model.addAttribute("subSys", this.subSystemService.selectByCode(user.getCurrentSystemCode()));
   }
   if ((user.getEclpLastLoginTime() != null) && (user.getEclpLastLoginTime().longValue() != -1L)) {
     model.addAttribute("lastLoginTime", DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date(user.getEclpLastLoginTime().longValue())));
   }
   return "contain/crmbody";
 }

	@RequestMapping({"/contain/crmfooter"})
	@AdminAccess(value = {  })
   public String crmfooter(Model model) {
     initSysConfig(model);
     return "contain/crmfooter";
   }
   
 }