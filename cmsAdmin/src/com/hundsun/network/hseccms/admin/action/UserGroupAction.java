/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.enums.EnumGroupNeedCaptcha;
/*     */ import com.hundsun.network.hseccms.enums.EnumGroupNeedCheck;
/*     */ import com.hundsun.network.hseccms.model.Cms2Group;
/*     */ import com.hundsun.network.hseccms.query.Cms2GroupQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelGroupService;
/*     */ import com.hundsun.network.hseccms.service.Cms2GroupService;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/group"})
/*     */ public class UserGroupAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2GroupService cms2GroupService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelGroupService cms2ChannelGroupService;
/*     */ 
/*     */   @RequestMapping({"/list"})
/*     */   public String logList(@ModelAttribute("query") Cms2GroupQuery query, Model model)
/*     */   {
/*  45 */     model.addAttribute("query", this.cms2GroupService.query(query));
/*  46 */     return "group/list";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addInit(@ModelAttribute("cms2Group") Cms2Group cms2Group, Model model)
/*     */   {
/*  57 */     model.addAttribute("groupNeedCheckList", EnumGroupNeedCheck.toListCanBeSee());
/*  58 */     model.addAttribute("groupNeedCaptchaList", EnumGroupNeedCaptcha.toListCanBeSee());
/*     */ 
/*  60 */     cms2Group.setNeedCheck(new Long(EnumGroupNeedCheck.NEED.getCode()));
/*  61 */     cms2Group.setNeedCaptcha(new Long(EnumGroupNeedCaptcha.NEED.getCode()));
/*  62 */     return "group/add";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String add(@ModelAttribute("cms2Group") Cms2Group cms2Group, Model model, HttpServletRequest request)
/*     */   {
/*  75 */     cms2Group.setAllowSuffix("jpg,jpeg,gif,png,bmp");
/*  76 */     cms2Group.setIsRegDef(Long.valueOf(0L));
/*  77 */     this.cms2GroupService.add(cms2Group);
/*  78 */     model.addAttribute("url", "/group/list.htm");
/*  79 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String editInit(@RequestParam(value="id", required=true) Long id, Model model)
/*     */   {
/*  90 */     model.addAttribute("cms2Group", this.cms2GroupService.getById(id));
/*  91 */     model.addAttribute("groupNeedCheckList", EnumGroupNeedCheck.toListCanBeSee());
/*  92 */     model.addAttribute("groupNeedCaptchaList", EnumGroupNeedCaptcha.toListCanBeSee());
/*  93 */     return "group/edit";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String edit(@ModelAttribute("cms2Group") Cms2Group cms2Group, Model model, HttpServletRequest request)
/*     */   {
/* 106 */     this.cms2GroupService.update(cms2Group);
/* 107 */     model.addAttribute("url", "/group/list.htm");
/* 108 */     model.addAttribute("message", "修改成功");
/* 109 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/delete"})
/*     */   public String delete(@RequestParam(value="id", required=true) Long id, Model model)
/*     */   {
/* 120 */     this.cms2GroupService.deleteById(id);
/* 121 */     this.cms2ChannelGroupService.deleteByGroupId(id);
/* 122 */     model.addAttribute("url", "/group/list.htm");
/* 123 */     model.addAttribute("message", "删除成功");
/* 124 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ajax/checkGroupNameUnique.htm"})
/*     */   public String checkGroupNameUnique(@RequestParam(value="id", required=false) Long id, @RequestParam("groupName") String groupName, ModelMap model, HttpServletRequest request)
/*     */   {
/* 143 */     model.put("content", String.valueOf(this.cms2GroupService.checkNameUnique(id, groupName)));
/*     */ 
/* 145 */     return "common/ajax/content";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ajax/checkGroupCodeUnique.htm"})
/*     */   public String checkGroupCodeUnique(@RequestParam(value="id", required=false) Long id, @RequestParam("code") String code, ModelMap model, HttpServletRequest request)
/*     */   {
/* 164 */     model.put("content", String.valueOf(this.cms2GroupService.checkCodeUnique(id, code)));
/*     */ 
/* 166 */     return "common/ajax/content";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.UserGroupAction
 * JD-Core Version:    0.6.0
 */