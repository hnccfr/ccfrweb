/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.admin.util.ResponseUtils;
/*     */ import com.hundsun.network.hseccms.common.Tree;
/*     */ import com.hundsun.network.hseccms.common.TreeMaker;
/*     */ import com.hundsun.network.hseccms.enums.EnumTplDirType;
/*     */ import com.hundsun.network.hseccms.enums.EnumTplIsDir;
/*     */ import com.hundsun.network.hseccms.enums.EnumTplIsParent;
/*     */ import com.hundsun.network.hseccms.model.Cms2Template;
/*     */ import com.hundsun.network.hseccms.query.Cms2TemplateBakQuery;
/*     */ import com.hundsun.network.hseccms.query.Cms2TemplateQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2TemplateBakService;
/*     */ import com.hundsun.network.hseccms.service.Cms2TemplateService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.bind.annotation.ResponseStatus;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/tpl"})
/*     */ public class Cms2TplAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2TemplateService cms2TemplateService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2TemplateBakService cms2TemplateBakService;
/*     */ 
/*     */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String index()
/*     */   {
/*  60 */     return "tpl/index";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/tree"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String tree(HttpServletRequest request, ModelMap model) {
/*  66 */     List treeList = getTreeLists(request);
/*  67 */     if (null != treeList) {
/*  68 */       TreeMaker treeMaker = new TreeMaker(treeList, "-1");
/*  69 */       model.addAttribute("tplTreeList", treeMaker.toStringScript());
/*     */     } else {
/*  71 */       model.addAttribute("message", "树数据获取失败");
/*     */     }
/*  73 */     return "tpl/tree";
/*     */   }
/*     */ 
/*     */   public List<Tree> getTreeLists(HttpServletRequest request) {
/*  77 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  78 */     List tplList = this.cms2TemplateService.getTplBySiteId(siteId.toString());
/*  79 */     List list = new ArrayList();
/*  80 */     Tree rootTree = new Tree("0", "-1", "根目录", "list.htm?dirType=", true, "rightFrame", false, true);
/*     */ 
/*  89 */     list.add(rootTree);
/*  90 */     int index = 1;
/*  91 */     for (EnumTplDirType e : EnumTplDirType.values()) {
/*  92 */       Tree dicTypeTree = new Tree("" + e.getValue().toString() + "", "0", "" + e.getMessage() + "", "list.htm?dirType=" + e.getValue().toString(), false, "rightFrame", false, true);
/*     */ 
/* 101 */       list.add(dicTypeTree);
/* 102 */       index++;
/*     */     }
/* 104 */     for (int i = 0; i < tplList.size(); i++) {
/* 105 */       Cms2Template tpl = (Cms2Template)tplList.get(i);
/* 106 */       index = index + i + 100;
/*     */ 
/* 108 */       String pid = "9";
/* 109 */       String dirType = "";
/* 110 */       String name = "";
/* 111 */       if (tpl.getDirType() != null) {
/* 112 */         pid = tpl.getDirType().toString();
/* 113 */         dirType = tpl.getDirType().toString();
/*     */       }
/* 115 */       boolean isParent = false;
/* 116 */       String url = "";
/* 117 */       if (tpl.getIsDirectory().equals(EnumTplIsDir.IS_DIR.getValue())) {
/* 118 */         isParent = true;
/* 119 */         url = "list.htm?dirType=" + dirType;
/* 120 */         name = tpl.getTplName();
/*     */       } else {
/* 122 */         url = "v_edit.htm?dirType=" + dirType + "&id=" + tpl.getId();
/* 123 */         name = tpl.getTplName() + "";
/*     */       }
/* 125 */       Tree tplTree = new Tree("" + index + "", "" + pid + "", "" + name + "", url, false, "rightFrame", false, isParent);
/*     */ 
/* 134 */       list.add(tplTree);
/*     */     }
/* 136 */     return list;
/*     */   }
/*     */ 
/*     */   public String getCurrentPath(String pId, String currentPath)
/*     */   {
/* 141 */     if (pId != "") {
/* 142 */       Cms2Template tpl = this.cms2TemplateService.getByTplId(pId);
/* 143 */       if (null != tpl) {
/* 144 */         currentPath = "/" + tpl.getTplName() + currentPath;
/* 145 */         if (tpl.getParentId() != null) {
/* 146 */           currentPath = getCurrentPath(tpl.getParentId().toString(), currentPath);
/*     */         }
/*     */       }
/*     */     }
/* 150 */     return currentPath;
/*     */   }
/*     */ 
/*     */   public String getCurrentPath(String dirType) {
/* 154 */     if ((dirType == null) || (dirType.length() == 0)) {
/* 155 */       return "/";
/*     */     }
/* 157 */     return (String)EnumTplDirType.toMap().get(dirType);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_MANAGE})
/*     */   @RequestMapping({"/list"})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Cms2TemplateQuery query, @RequestParam(value="dirType", required=false) String dirType, HttpServletRequest request, Model model)
/*     */   {
/* 172 */     if (StringUtil.isNotEmpty(queryStr)) {
/* 173 */       query = (Cms2TemplateQuery)query.riseUp(queryStr);
/*     */     }
/* 175 */     if ((dirType == null) || (dirType.length() == 0)) {
/* 176 */       dirType = "";
/*     */     }
/* 178 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 179 */     query.setDirType(dirType);
/* 180 */     query.setSiteId(siteId.toString());
/* 181 */     query.setDirType(dirType);
/* 182 */     query.setOrderBy("TPL_NAME");
/* 183 */     query = this.cms2TemplateService.getChildPage(query);
/* 184 */     model.addAttribute("query", query);
/* 185 */     model.addAttribute("currentPath", getCurrentPath(dirType));
/* 186 */     model.addAttribute("dirType", dirType);
/* 187 */     return "tpl/list";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_ADD})
/*     */   @RequestMapping({"/v_add"})
/*     */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, HttpServletRequest request, @RequestParam String dirType, Model model)
/*     */   {
/* 196 */     if (null == dirType) {
/* 197 */       model.addAttribute("message", "请选择子栏目添加");
/* 198 */       return list(queryStr, new Cms2TemplateQuery(), dirType, request, model);
/*     */     }
/* 200 */     model.addAttribute("q", queryStr);
/* 201 */     model.addAttribute("dirType", dirType);
/* 202 */     model.addAttribute("dirTypeMap", EnumTplDirType.toMap());
/* 203 */     return "tpl/add";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_ADD})
/*     */   @RequestMapping({"/o_save"})
/*     */   public String save(@RequestParam(value="q", required=false, defaultValue="") String queryStr, String parentId, String filename, String source, String dirType, HttpServletRequest request, SettlerAgent cmsAgent, Model model) throws IOException {
/* 211 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 212 */     Cms2Template tpl = new Cms2Template();
/* 213 */     tpl.setSiteId(siteId);
/* 214 */     tpl.setIsDirectory(EnumTplIsDir.IS_FILE.getValue());
/* 215 */     tpl.setIsParent(EnumTplIsParent.IS_NOT_PARENT.getValue());
/* 216 */     tpl.setCurrPath("/" + filename);
/* 217 */     tpl.setDirType(Long.valueOf(Long.parseLong(dirType)));
/* 218 */     tpl.setParentId(Long.valueOf(0L));
/* 219 */     tpl.setTplName(filename);
/* 220 */     Long tplId = this.cms2TemplateService.save(tpl, source);
/* 221 */     if (tplId == null) {
/* 222 */       model.addAttribute("message", "添加模版失败");
/* 223 */       return list(queryStr, new Cms2TemplateQuery(), dirType, request, model);
/*     */     }
/* 225 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "模版增加", tpl.getId().toString(), filename);
/* 226 */     return editView(queryStr, dirType, tplId.toString(), model);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_DEL})
/*     */   @RequestMapping({"/del_single"})
/*     */   public String deleteSingle(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam String dirType, @RequestParam String id, SettlerAgent cmsAgent, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
/* 234 */     String result = this.cms2TemplateService.delTpl(new String[] { id });
/* 235 */     if (result != "") {
/* 236 */       model.addAttribute("message", result);
/*     */     } else {
/* 238 */       model.addAttribute("message", "删除成功");
/* 239 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "模版删除", id, "模版删除成功");
/*     */     }
/* 241 */     return list(queryStr, new Cms2TemplateQuery(), dirType, request, model);
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_DEL})
/*     */   @RequestMapping({"/delete"})
/*     */   public String deleteMulti(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam String dirType, String[] ids, HttpServletRequest request, SettlerAgent cmsAgent, Model model) throws UnsupportedEncodingException {
/* 248 */     String result = this.cms2TemplateService.delTpl(ids);
/* 249 */     if (result != "") {
/* 250 */       model.addAttribute("message", result);
/*     */     } else {
/* 252 */       model.addAttribute("message", "删除成功");
/* 253 */       for (String id : ids) {
/* 254 */         super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "模版删除", id, "模版删除成功");
/*     */       }
/*     */     }
/* 257 */     return list(queryStr, new Cms2TemplateQuery(), dirType, request, model);
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_EDIT})
/*     */   @RequestMapping({"/v_edit"})
/*     */   public String editView(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam String dirType, @RequestParam String id, Model model) {
/* 264 */     Cms2Template tpl = this.cms2TemplateService.getByTplId(id);
/* 265 */     model.addAttribute("q", queryStr);
/* 266 */     model.addAttribute("tpl", tpl);
/* 267 */     model.addAttribute("dirType", dirType);
/* 268 */     model.addAttribute("tplId", id);
/* 269 */     return "tpl/edit";
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_EDIT})
/*     */   @RequestMapping({"/o_edit"})
/*     */   public String editControl(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam String dirType, @RequestParam String id, String source, String remark, SettlerAgent cmsAgent, HttpServletRequest request, Model model) {
/* 276 */     Cms2Template tpl = new Cms2Template();
/* 277 */     tpl.setId(Long.valueOf(Long.parseLong(id)));
/* 278 */     tpl.setCont(source);
/* 279 */     tpl.setSiteId(Cms2Utils.getCurrentSiteId(request));
/* 280 */     tpl.setUserId(Long.valueOf(cmsAgent.getId()));
/* 281 */     tpl.setUserName(cmsAgent.getUserAccount());
/* 282 */     String result = this.cms2TemplateService.update(tpl, remark, true);
/* 283 */     if (result != "") {
/* 284 */       model.addAttribute("message", result);
/*     */     } else {
/* 286 */       model.addAttribute("message", "修改成功");
/* 287 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "模版修改", id, "模版修改成功");
/*     */     }
/* 289 */     return list(queryStr, new Cms2TemplateQuery(), dirType, request, model);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/v_rename"})
/*     */   public String renameView(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam String dirType, @RequestParam String id, Model model) {
/* 295 */     Cms2Template tpl = this.cms2TemplateService.getByTplId(id);
/* 296 */     model.addAttribute("q", queryStr);
/* 297 */     model.addAttribute("tpl", tpl);
/* 298 */     model.addAttribute("dirType", dirType);
/* 299 */     model.addAttribute("currentPath", getCurrentPath(dirType));
/* 300 */     return "tpl/rename";
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.TPL_EDIT})
/*     */   @RequestMapping({"/o_rename"})
/*     */   public String renameControl(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam String dirType, @RequestParam String id, String fileName, SettlerAgent cmsAgent, HttpServletRequest request, Model model) {
/* 307 */     Cms2Template tpl = new Cms2Template();
/* 308 */     tpl.setId(Long.valueOf(Long.parseLong(id)));
/* 309 */     tpl.setTplName(fileName);
/* 310 */     tpl.setSiteId(Cms2Utils.getCurrentSiteId(request));
/* 311 */     String result = this.cms2TemplateService.update(tpl, null, false);
/* 312 */     if (result != "") {
/* 313 */       model.addAttribute("message", result);
/*     */     } else {
/* 315 */       model.addAttribute("message", "修改成功");
/* 316 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "模版重命名", id, "");
/*     */     }
/* 318 */     return list(queryStr, new Cms2TemplateQuery(), dirType, request, model);
/*     */   }
/*     */   @RequestMapping({"/o_create_dir"})
/*     */   public String createDir(Cms2TemplateQuery query, @RequestParam String parentId, String dirName, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
/* 323 */     Cms2Template tpl = new Cms2Template();
/* 324 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 325 */     tpl.setSiteId(siteId);
/* 326 */     if ((parentId != null) && (parentId != ""))
/* 327 */       tpl.setParentId(Long.valueOf(Long.parseLong(parentId)));
/*     */     else {
/* 329 */       tpl.setParentId(null);
/*     */     }
/* 331 */     tpl.setIsDirectory(EnumTplIsDir.IS_DIR.getValue());
/* 332 */     tpl.setIsParent(EnumTplIsParent.IS_NOT_PARENT.getValue());
/* 333 */     tpl.setTplName(dirName);
/* 334 */     Long result = this.cms2TemplateService.save(tpl, null);
/* 335 */     model.addAttribute("query", query);
/* 336 */     if (result == null)
/* 337 */       model.addAttribute("message", "新建目录失败");
/*     */     else {
/* 339 */       model.addAttribute("message", "目录新建成功");
/*     */     }
/* 341 */     return list(null, query, parentId, request, model);
/*     */   }
/*     */   @RequestMapping({"/bak/list"})
/*     */   public String tplBakList(@RequestParam String dirType, Cms2TemplateBakQuery query, HttpServletRequest request, Model model) {
/* 346 */     query = this.cms2TemplateBakService.getQuery(query);
/* 347 */     model.addAttribute("query", query);
/* 348 */     model.addAttribute("tplId", query.getTplId());
/* 349 */     model.addAttribute("dirType", dirType);
/* 350 */     return "tpl/bak_list"; } 
/* 357 */   @RequestMapping({"/bak/del"})
/*     */   @ResponseStatus(HttpStatus.OK)
/*     */   @ResponseBody
/*     */   public void tplBakDel(@RequestParam String tplBakId, HttpServletRequest request, HttpServletResponse response, Model model) throws JSONException { JSONObject json = new JSONObject();
/*     */     try {
/* 359 */       this.cms2TemplateBakService.delById(tplBakId);
/* 360 */       json.put("success", true);
/* 361 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } catch (Exception e) {
/* 363 */       json.put("success", false).put("msg", e.getMessage());
/* 364 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } }
/*     */ 
/*     */   @RequestMapping({"/bak/restore"})
/*     */   public String tplBakRestore(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam String dirType, @RequestParam String tplBakId, @RequestParam String tplId, HttpServletRequest request, Model model) {
/* 370 */     String result = this.cms2TemplateBakService.tplRestore(Long.valueOf(Long.parseLong(tplBakId)));
/* 371 */     if (result != "")
/* 372 */       model.addAttribute("message", "还原失败:" + result);
/*     */     else {
/* 374 */       model.addAttribute("message", "还原成功");
/*     */     }
/* 376 */     return editView(queryStr, dirType, tplId, model);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ajax/checkNameUnique.htm"})
/*     */   public String checkCtgNameUnique(@RequestParam(value="id", required=false) Long id, @RequestParam("dirType") String dirType, String filename, ModelMap model, HttpServletRequest request)
/*     */   {
/* 392 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*     */ 
/* 401 */     Cms2Template tpl = this.cms2TemplateService.getTplByTypeAndName(siteId.toString(), dirType, filename);
/* 402 */     if (null != id) {
/* 403 */       if (null != tpl) {
/* 404 */         if (id.equals(tpl.getId()))
/* 405 */           model.put("content", "true");
/*     */         else
/* 407 */           model.put("content", "false");
/*     */       }
/*     */       else {
/* 410 */         model.put("content", "true");
/*     */       }
/*     */     }
/* 413 */     else if (null != tpl)
/* 414 */       model.put("content", "false");
/*     */     else {
/* 416 */       model.put("content", "true");
/*     */     }
/*     */ 
/* 419 */     return "common/ajax/content";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.Cms2TplAction
 * JD-Core Version:    0.6.0
 */