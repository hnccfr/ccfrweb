 package com.hundsun.network.hseccms.web.action;
 
 import com.hundsun.network.hseccms.common.URLHelper;
 import com.hundsun.network.hseccms.common.URLHelper.PageInfo;
 import com.hundsun.network.hseccms.enums.EnumContStatus;
 import com.hundsun.network.hseccms.enums.EnumModelHasContent;
 import com.hundsun.network.hseccms.enums.EnumTplDirType;
 import com.hundsun.network.hseccms.model.Cms2Channel;
 import com.hundsun.network.hseccms.model.Cms2ChannelExt;
 import com.hundsun.network.hseccms.model.Cms2ContAll;
 import com.hundsun.network.hseccms.model.Cms2Model;
 import com.hundsun.network.hseccms.model.Cms2Site;
 import com.hundsun.network.hseccms.model.Cms2Template;
 import com.hundsun.network.hseccms.security.SettlerAgent;
 import com.hundsun.network.hseccms.service.Cms2ChannelExtService;
 import com.hundsun.network.hseccms.service.Cms2ChannelService;
 import com.hundsun.network.hseccms.service.Cms2ContService;
 import com.hundsun.network.hseccms.service.Cms2SiteService;
 import com.hundsun.network.hseccms.service.Cms2TemplateService;
 import com.hundsun.network.hseccms.staticpage.StaticPageSvc;
 import com.hundsun.network.hseccms.util.Cms2Utils;
 import com.hundsun.network.hseccms.util.FrontUtils;
 import com.hundsun.network.hseccms.web.common.WebUtils;
 import com.hundsun.network.hseccms.web.render.StringTemplateRender;
 import com.hundsun.network.melody.common.util.StringUtil;
 import java.util.ArrayList;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.ModelMap;
 import org.springframework.web.bind.annotation.RequestMapping;
 
 @Controller
 public class RequestDispatcherAction
 {
   private static Log _log = LogFactory.getLog(WelcomeAction.class);
 
   public static String INDEX = "index";
 
   @Autowired
   private Cms2TemplateService cms2TemplateService;
 
   @Autowired
   private Cms2ContService cms2ContService;
 
   @Autowired
   private Cms2ChannelService cms2ChannelService;
 
   @Autowired
   private Cms2ChannelExtService cms2ChannelExtService;
 
   @Autowired
   private Cms2SiteService cms2SiteService;
 
   @Autowired
   private StringTemplateRender stringTemplateRender;
 
   @Autowired
   private StaticPageSvc staticPageSvc;
 
   @RequestMapping(value={"/toDynamic*"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
   public void urlStaicToDynamic(HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user) { Cms2Site site = Cms2Utils.getSite(request);
     String url = request.getParameter("url");
     try {
       if (url.indexOf(this.staticPageSvc.getSiteStaticPre(site)) < 0) {
         _log.debug("toDynamic illegel url");
         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
         return;
       }
       url = url.replace(this.staticPageSvc.getSiteStaticPre(site), "");
       url = url.replace(site.getStaticSuffix(), site.getDynamicSuffix());
       response.sendRedirect(url);
       return;
     } catch (Exception e) {
       _log.debug("toDynamic error" + e);
       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
     }
   }
 
  @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void indexForWeblogic(HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
  {
    index(request, response, model, user);
  }

	@RequestMapping(value = { "/" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public void index(HttpServletRequest request, HttpServletResponse response,
			ModelMap model, SettlerAgent user) {
		try {
			Cms2Site site = Cms2Utils.getSite(request);

			String url = this.staticPageSvc.getHomepageFile(site);
			if ((url != null) && (url != "") && (site.getStaticIndex())) {
				response.sendRedirect(url);
				return;
			}

			String tpl = "首页";
			String tempContent = null;
			Cms2Template template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "",
							EnumTplDirType.INDEX.getCode(), tpl);
			if (template != null){
				tempContent = template.getCont();
			}
			FrontUtils.frontData(request, model, site, user);
			tempContent = this.stringTemplateRender.render(model, tempContent);
			WebUtils.toHtmlPage(response, tempContent);
		} catch (Exception e) {
			_log.error("", e);
		}
	}

  @RequestMapping(value={"/**/*.*"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void dynamic(String visit, HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
  {
    int pageNo = URLHelper.getPageNo(request);
    String[] params = URLHelper.getParams(request);
    URLHelper.PageInfo info = URLHelper.getPageInfo(request);
    String[] paths = URLHelper.getPaths(request);
    int len = paths.length;
    try {
      if (len == 1) {
        channel(paths[0], pageNo, params, info, request, response, model, user);
        return;
      }if (len == 2) {
        if (paths[1].equals(INDEX)) {
          channel(paths[0], pageNo, params, info, request, response, model, user);
          return;
        }
        Long id = Long.valueOf(Long.parseLong(paths[1]));
        content(id, visit, pageNo, params, info, request, response, model, user);
        return;
      }

      _log.debug("Illegal path length: {" + len + "}, paths: {" + paths + "}");
      this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
      return;
    }
    catch (Exception e) {
      _log.debug("request faild", e);
      this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
    }
  }

  public void channel(String path, int pageNo, String[] params, URLHelper.PageInfo info, HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
    throws Exception
  {
    Cms2Site site = Cms2Utils.getSite(request);
    Cms2Channel channel = this.cms2ChannelService.channelDirectiveForObject(null, site.getSitePath(), path);
    if (channel == null) {
      _log.debug("Channel path not found: {" + path + "}");
      FrontUtils.frontData(request, model, site, user);
      Cms2Template template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.COMMON.getCode(), "无页面");
      String str = template.getCont();
      this.stringTemplateRender.render(model, str);
      WebUtils.toHtmlPage(response, str);
      return;
    }
    Cms2Model cms2Model = channel.getModel();
    if (EnumModelHasContent.SINGLE.getCode().equals(cms2Model.getHasContent()));
    List channelList = this.cms2ChannelService.getWholeTreeBySite(channel.getSiteId());
    ArrayList channelListParent = new ArrayList();
    if (null != channel.getParentId()) {
      channelListParent = getParentList(channel.getParentId().longValue(), channelList);
    }
    channel.setParentList(channelListParent);

    model.addAttribute("channel", channel);
    FrontUtils.frontData(request, model, site, user);
    FrontUtils.frontPageData(request, site, Boolean.valueOf(true), model);
    Cms2ChannelExt channelExt = channel.getChannelExt();
    Cms2Template template = null;
    if ((channelExt.getTplChnlId() == null) || (channelExt.getTplChnlId().compareTo(Long.valueOf(0L)) <= 0)) {
      String tpl = cms2Model.getTplChannelPrefix();
      if (StringUtil.isNotBlank(tpl))
        template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.CHANNEL.getCode(), tpl);
    } else {
      template = this.cms2TemplateService.getByTplId(channelExt.getTplChnlId().toString());
    }
    channel.setSite(site);
    String str = null;
    if (template != null)
      str = template.getCont();
    str = this.stringTemplateRender.render(model, str);
    WebUtils.toHtmlPage(response, str);
  }

  public void content(Long id, String visit, int pageNo, String[] params, URLHelper.PageInfo info, HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
    throws Exception
  {
    Cms2ContAll content = this.cms2ContService.selectAllById(id);
    if (content == null) {
      _log.debug("Content id not found: " + id);
      model.addAttribute("message", "操作失败");
      this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "公用错误页面", request, response, model, user);
      return;
    }
    if ((StringUtil.isBlank(visit)) && (!EnumContStatus.FINISH.getCode().equals(content.getStatus()))) {
      model.addAttribute("message", "操作失败");
      this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "公用错误页面", request, response, model, user);
      return;
    }
    Cms2Channel channel = this.cms2ChannelService.channelDirectiveForObject(content.getChannelId(), null, null);

    List channelList = this.cms2ChannelService.getWholeTreeBySite(channel.getSiteId());
    ArrayList channelListParent = new ArrayList();
    if (null != channel.getParentId()) {
      channelListParent = getParentList(channel.getParentId().longValue(), channelList);
    }
    channel.setParentList(channelListParent);

    Cms2Model cms2Model = channel.getModel();
    Cms2Site site = this.cms2SiteService.queryById(content.getSiteId());
    FrontUtils.frontPageData(request, site, Boolean.valueOf(true), model);
    model.addAttribute("content", content);
    model.addAttribute("channel", channel);
    FrontUtils.frontData(request, model, site, user);
    Cms2ChannelExt channelExt = channel.getChannelExt();
    Cms2Template template = null;
    if ((channelExt.getTplContId() == null) || (channelExt.getTplContId().compareTo(Long.valueOf(0L)) <= 0)) {
      String tpl = cms2Model.getTplContentPrefix();
      if (StringUtil.isNotBlank(tpl))
        template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.CONTENT.getCode(), tpl);
    } else {
      template = this.cms2TemplateService.getByTplId(channelExt.getTplContId().toString());
    }

    String str = null;
    if (template != null)
      str = template.getCont();
    str = this.stringTemplateRender.render(model, str);
    WebUtils.toHtmlPage(response, str);
  }

  private ArrayList<Cms2Channel> getParentList(long parentId, List<Cms2Channel> channelListAll)
  {
    ArrayList channelList = new ArrayList();
    Cms2Channel channelParent = new Cms2Channel();
    for (Cms2Channel channelTemp : channelListAll) {
      if ((null != channelTemp) && (null != channelTemp.getId()) && (channelTemp.getId().longValue() == parentId)) {
        channelParent = channelTemp;
        if (null != channelTemp.getParentId()) {
          channelList = getParentList(channelTemp.getParentId().longValue(), channelListAll);
          break;
        }
      }
    }
    channelList.add(channelParent);
    return channelList;
  }
}
