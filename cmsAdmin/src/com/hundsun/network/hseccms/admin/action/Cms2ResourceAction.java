/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.common.query.QueryPage;
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.common.TreeMaker;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.service.Cms2ResourceService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.melody.common.web.url.URLBroker;
/*     */ import com.hundsun.network.melody.common.web.url.URLConfig;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/res"})
/*     */ public class Cms2ResourceAction extends BaseAction
/*     */ {
/*  44 */   private static Log _log = LogFactory.getLog(Cms2ResourceAction.class);
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ResourceService cms2ResourceService;
/*     */ 
/*     */   @Autowired
/*     */   private URLBroker uploadServerBroker;
/*     */ 
/*     */   @Value("${file.server.url}")
/*     */   private String fileServerUrl;
/*     */ 
/*     */   @Value("${file.sysCode}")
/*     */   private String sysCode;
/*     */ 
/*     */   @Value("${file.bizRule}")
/*     */   private String bizRule;
/*     */ 
/*     */   @Value("${upload.file.max.res}")
/*     */   private Long maxRes;
/*     */ 
/*     */   @Value("${resSys}")
/*     */   private String resSys;
/*     */ 
/*  73 */   @RequestMapping({"/index"})
/*     */   public String index() { return "res/index"; }
/*     */ 
/*     */   @RequestMapping({"/left"})
/*     */   public String left(String path, HttpServletRequest request, ModelMap model) {
/*  78 */     return "res/left";
/*     */   }
/*     */ 
/*     */   public String checkValidator(Integer pageNo, HttpServletRequest request, String root, ModelMap model) {
/*  82 */     if (null == root) {
/*  83 */       model.addAttribute("message", "error.folderExistFile");
/*  84 */       model.addAttribute("root", root);
/*     */     }
/*  86 */     return list(pageNo, request, model, root);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/tree"})
/*     */   public String tree(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
/*  92 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/*  93 */     Cms2Site currentSite = this.cms2SiteService.queryById(currentSiteId);
/*  94 */     String rootPath = "/";
/*  95 */     if (null != currentSite) {
/*  96 */       rootPath = currentSite.getResPath();
/*     */     }
/*  98 */     List treeList = this.cms2ResourceService.getTreeLists(rootPath);
/*  99 */     if (null != treeList) {
/* 100 */       TreeMaker treeMaker = new TreeMaker(treeList, "-1");
/* 101 */       model.addAttribute("resList", treeMaker.toStringScript());
/*     */     } else {
/* 103 */       model.addAttribute("message", "树数据获取失败");
/*     */     }
/* 105 */     return "res/tree";
/*     */   }
/* 111 */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_MANAGE})
/*     */   @RequestMapping({"/list"})
/*     */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model, @RequestParam String root) { Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 112 */     Cms2Site currentSite = this.cms2SiteService.queryById(currentSiteId);
/* 113 */     if (StringUtils.isBlank(root)) {
/* 114 */       root = currentSite.getResPath();
/*     */     }
/* 116 */     String rel = "";
/* 117 */     if (StringUtils.isBlank(root)) {
/* 118 */       rel = "/";
/* 119 */       root = "/";
/*     */     } else {
/* 121 */       rel = root.substring(currentSite.getResPath().length());
/*     */     }
/* 123 */     if (rel.length() == 0) {
/* 124 */       rel = "/";
/*     */     }
/* 126 */     root = deCoderStr(root);
/* 127 */     List fileList = this.cms2ResourceService.listFile(root, false);
/* 128 */     QueryPage query = new QueryPage();
/* 129 */     model.addAttribute("fileServerUrl", this.fileServerUrl);
/* 130 */     model.addAttribute("root", root);
/* 131 */     model.addAttribute("rel", rel);
/* 132 */     model.addAttribute("sysCode", this.sysCode);
/* 133 */     model.addAttribute("bizRule", this.bizRule);
/* 134 */     query.setItems(fileList);
/* 135 */     model.addAttribute("query", query);
/* 136 */     model.addAttribute("batchId", "221");
/* 137 */     model.addAttribute("maxRes", Long.valueOf(this.maxRes.longValue() / 1048576L));
/* 138 */     return "res/list"; }
/*     */ 
/*     */   @RequestMapping({"/ueditor/image_manager"})
/*     */   public void image_manager(Integer pageNo, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*     */   {
/* 144 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 145 */     Cms2Site currentSite = this.cms2SiteService.queryById(currentSiteId);
/* 146 */     String root = currentSite.getResPath() + "/" + "upload";
/* 147 */     responseInit(response);
/* 148 */     root = deCoderStr(root);
/* 149 */     List<String> pathList = this.cms2ResourceService.listImageFile(root);
/* 150 */     String imgPathRel = "";
/* 151 */     for (String path : pathList) {
/* 152 */       imgPathRel = imgPathRel + this.uploadServerBroker.getConfig().getURL() + "/" + this.resSys + path.substring(path.indexOf(currentSite.getResPath().replace("/", File.separator))) + "ue_separate_ue";
/*     */     }
/*     */ 
/* 155 */     imgPathRel = imgPathRel.substring(0, imgPathRel.lastIndexOf("ue_separate_ue")).replace(File.separator, "/").trim();
/*     */     try
/*     */     {
/* 159 */       PrintWriter out = response.getWriter();
/* 160 */       out.print(imgPathRel);
/* 161 */       out.flush();
/* 162 */       out.close();
/*     */     } catch (IOException e) {
/* 164 */       _log.error("Ueditor Manage picture ERROR", e);
/*     */     }
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_EDIT})
/*     */   @RequestMapping({"/v_rename"})
/*     */   public String renameInput(HttpServletRequest request, @RequestParam String root, @RequestParam String name, ModelMap model) {
/* 171 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 172 */     Cms2Site currentSite = this.cms2SiteService.queryById(currentSiteId);
/* 173 */     String origName = name.substring(currentSite.getResPath().length());
/* 174 */     String resourceName = origName.substring(origName.lastIndexOf("/") + 1, origName.length());
/* 175 */     model.addAttribute("resourceName", resourceName);
/* 176 */     if (resourceName.contains(".")) {
/* 177 */       model.addAttribute("origName", resourceName.substring(0, resourceName.lastIndexOf(".")));
/* 178 */       model.addAttribute("extensionName", resourceName.substring(resourceName.lastIndexOf(".") + 1, resourceName.length()));
/*     */     } else {
/* 180 */       model.addAttribute("origName", resourceName);
/*     */     }
/* 182 */     model.addAttribute("root", root);
/* 183 */     return "res/rename";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_EDIT})
/*     */   @RequestMapping(value={"/o_rename"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String renameSubmit(Integer pageNo, String root, String origName, String fileName, String extensionName, SettlerAgent cmsAgent, HttpServletRequest request, ModelMap model) {
/* 191 */     String result = this.cms2ResourceService.rename(origName, fileName, root, extensionName);
/* 192 */     if (!result.equals("")) {
/* 193 */       model.addAttribute("message", result);
/* 194 */       return list(pageNo, request, model, root);
/*     */     }
/* 196 */     model.addAttribute("root", root);
/* 197 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "资源文件重命名", "", "资源文件重命名成功" + root + "/" + origName);
/* 198 */     return list(pageNo, request, model, root);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_DEL})
/*     */   @RequestMapping({"/del_single"})
/*     */   public String deleteSingle(Integer pageNo, HttpServletRequest request, @RequestParam String root, @RequestParam String name, SettlerAgent cmsAgent, ModelMap model)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 208 */     if ((null == root) || (null == name)) {
/* 209 */       model.addAttribute("message", "error.folderExistFile");
/* 210 */       model.addAttribute("root", root);
/* 211 */       return list(pageNo, request, model, root);
/*     */     }
/* 213 */     String result = this.cms2ResourceService.delete(root, new String[] { name });
/* 214 */     if (!result.equals("")) {
/* 215 */       model.addAttribute("message", result);
/* 216 */       return list(pageNo, request, model, root);
/*     */     }
/* 218 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "资源文件删除", "", "资源文件删除成功" + root + "/" + name);
/* 219 */     model.addAttribute("root", root);
/* 220 */     return list(pageNo, request, model, root);
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_EDIT})
/*     */   @RequestMapping({"/v_edit"})
/*     */   public String edit(HttpServletRequest request, @RequestParam String root, @RequestParam String name, ModelMap model) throws IOException {
/* 227 */     if ((null == root) || (null == name)) {
/* 228 */       model.addAttribute("message", "error.folderExistFile");
/*     */     }
/* 230 */     String source = this.cms2ResourceService.readFile(root, name);
/* 231 */     model.addAttribute("source", source);
/* 232 */     model.addAttribute("root", root);
/* 233 */     model.addAttribute("name", name);
/* 234 */     model.addAttribute("filename", name.substring(name.lastIndexOf(47) + 1));
/* 235 */     return "res/edit";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_EDIT})
/*     */   @RequestMapping({"/o_update"})
/*     */   public String update(Integer pageNo, @RequestParam String root, @RequestParam String name, @RequestParam String source, HttpServletRequest request, HttpServletResponse response, SettlerAgent cmsAgent, ModelMap model) throws IOException {
/* 243 */     String result = this.cms2ResourceService.updateFile(root, name, source);
/* 244 */     if (!result.equals("")) {
/* 245 */       model.addAttribute("message", result);
/*     */     } else {
/* 247 */       model.addAttribute("message", "修改成功");
/* 248 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "资源文件修改", "", "资源文件修改成功" + root + "/" + name);
/*     */     }
/* 250 */     return list(pageNo, request, model, root);
/*     */   }
/*     */ 
/*     */   public void responseSetting(HttpServletResponse response, String contentType) {
/* 254 */     response.setContentType(contentType);
/* 255 */     response.setHeader("Pragma", "No-cache");
/* 256 */     response.setHeader("Cache-Control", "no-cache");
/* 257 */     response.setDateHeader("Expires", 0L);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_ADD})
/*     */   @RequestMapping({"/create_dir"})
/*     */   public String createDir(Integer pageNo, String root, String dirName, SettlerAgent cmsAgent, HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException
/*     */   {
/* 266 */     if ((StringUtils.isBlank(root.trim())) || (StringUtils.isBlank(dirName.trim()))) {
/* 267 */       model.addAttribute("message", "目录不能为空");
/* 268 */       return list(pageNo, request, model, root);
/*     */     }
/* 270 */     String result = this.cms2ResourceService.createDir(root, dirName);
/* 271 */     if (!result.equals("")) {
/* 272 */       model.addAttribute("message", result);
/*     */     } else {
/* 274 */       model.addAttribute("message", "创建成功");
/* 275 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "资源文件创建目录", "", "资源文件创建目录成功" + root + "/" + dirName);
/*     */     }
/* 277 */     return list(pageNo, request, model, root);
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_ADD})
/*     */   @RequestMapping({"/v_add"})
/*     */   public String add(HttpServletRequest request, @RequestParam String root, ModelMap model) {
/* 284 */     model.addAttribute("root", root);
/* 285 */     return "res/add";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_ADD})
/*     */   @RequestMapping({"/o_save"})
/*     */   public String save(String root, String filename, String source, HttpServletRequest request, SettlerAgent cmsAgent, ModelMap model) throws IOException {
/* 293 */     model.addAttribute("root", root);
/* 294 */     if ((null == root) || (null == filename)) {
/* 295 */       model.addAttribute("message", "参数错误");
/*     */     }
/* 297 */     String result = this.cms2ResourceService.createFile(root, filename, source);
/* 298 */     if (!result.equals("")) {
/* 299 */       model.addAttribute("message", result);
/*     */     } else {
/* 301 */       model.addAttribute("message", "创建成功");
/* 302 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "资源文件添加", "", "资源文件添加成功" + root + "/" + filename);
/*     */     }
/* 304 */     _log.info(filename + "文件创建成功");
/* 305 */     return "redirect:list.htm";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_ADD})
/*     */   @RequestMapping(value={"/o_swfupload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void swfUpload(String root, @RequestParam(value="Filedata", required=false) MultipartFile file, SettlerAgent cmsAgent, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IllegalStateException, IOException
/*     */   {
/* 314 */     _log.error(" in Cms2ResourceAction.swfUpload()!!! ");
/* 315 */     responseSetting(response, "text/plain;charset=UTF-8");
/* 316 */     String result = this.cms2ResourceService.saveFile(root, file);
/* 317 */     if (!result.equals("")) {
/* 318 */       model.addAttribute("message", result);
/*     */     } else {
/* 320 */       model.addAttribute("message", "上传成功");
/* 321 */       response.getWriter().write("{error:\"false\"}");
/* 322 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "资源文件上传", "", "资源文件上传成功" + root + "/" + file.getName());
/*     */     }
/* 324 */     model.addAttribute("root", root);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.RES_DEL})
/*     */   @RequestMapping({"/delete"})
/*     */   public String delete(Integer pageNo, String root, String[] names, SettlerAgent cmsAgent, HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException
/*     */   {
/* 333 */     if (null == root) {
/* 334 */       model.addAttribute("message", "error.folderExistFile");
/* 335 */       model.addAttribute("root", root);
/* 336 */       return list(pageNo, request, model, root);
/*     */     }
/* 338 */     String result = this.cms2ResourceService.delete(root, names);
/* 339 */     if (!result.equals("")) {
/* 340 */       model.addAttribute("message", result);
/*     */     } else {
/* 342 */       model.addAttribute("message", "删除成功");
/* 343 */       for (String name : names) {
/* 344 */         super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "资源文件删除", "", "资源文件删除成功" + root + "/" + name);
/*     */       }
/*     */     }
/* 347 */     model.addAttribute("root", root);
/* 348 */     return list(pageNo, request, model, root);
/*     */   }
/*     */ 
/*     */   public String deCoderStr(String str) {
/*     */     try {
/* 353 */       return URLDecoder.decode(str, "UTF-8");
/*     */     } catch (UnsupportedEncodingException e) {
/*     */     }
/* 356 */     return null;
/*     */   }
/*     */ 
/*     */   public void responseInit(HttpServletResponse response)
/*     */   {
/* 361 */     response.setCharacterEncoding("UTF-8");
/* 362 */     response.setContentType("text/html;charset=UTF-8");
/* 363 */     response.setHeader("Charset", "utf-8");
/* 364 */     response.setHeader("Cache-Control", "no-cache");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.Cms2ResourceAction
 * JD-Core Version:    0.6.0
 */