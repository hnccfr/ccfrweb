/*     */ package com.hundsun.network.hseccms.web.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.enums.EnumTplDirType;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.service.Cms2ResourceService;
/*     */ import com.hundsun.network.hseccms.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.util.editor.Command;
/*     */ import com.hundsun.network.hseccms.util.editor.ResourceType;
/*     */ import com.hundsun.network.hseccms.util.editor.UploadUtils;
/*     */ import com.hundsun.network.hseccms.util.fck.UploadResponse;
/*     */ import com.hundsun.network.hseccms.util.image.ImageUtils;
/*     */ import com.hundsun.network.hseccms.util.ueditor.UEditorUploader;
/*     */ import com.hundsun.network.hseccms.web.common.FileRepository;
/*     */ import com.hundsun.network.hseccms.web.common.FileUtils;
/*     */ import com.hundsun.network.hseccms.web.common.ResponseUtils;
/*     */ import com.hundsun.network.hseccms.web.render.StringTemplateRender;
/*     */ import com.hundsun.network.melody.common.web.url.URLBroker;
/*     */ import com.hundsun.network.melody.common.web.url.URLConfig;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.fileupload.servlet.ServletFileUpload;
/*     */ import org.apache.commons.io.FilenameUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.bind.annotation.ResponseStatus;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.multipart.MultipartHttpServletRequest;
/*     */ import org.springframework.web.multipart.MultipartResolver;
/*     */ 
/*     */ @Controller
/*     */ public class UploadAction
/*     */ {
/*  57 */   private static final Logger log = LoggerFactory.getLogger(UploadAction.class);
/*     */ 
/*     */   @Autowired
/*     */   private FileRepository fileRepository;
/*     */   MultipartResolver multipartResolver;
/*     */ 
/*     */   @Autowired
/*     */   private URLBroker uploadServerBroker;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ResourceService cms2ResourceService;
/*     */ 
/*     */   @Autowired
/*     */   private StringTemplateRender stringTemplateRender;
/*     */   public static final String ERROR = "error";
/*     */ 
/*     */   @Value("${site.resource}")
/*     */   private String uploadRootPath;
/*     */ 
/*     */   @Value("${resSys}")
/*     */   private String resSys;
/*     */ 
/*  87 */   public void responseInit(HttpServletResponse response) { response.setCharacterEncoding("UTF-8");
/*  88 */     response.setContentType("text/html;charset=UTF-8");
/*  89 */     response.setHeader("Charset", "utf-8");
/*  90 */     response.setHeader("Cache-Control", "no-cache");
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/json"})
/*     */   @ResponseStatus(HttpStatus.OK)
/*     */   @ResponseBody
/*     */   public void fileUpload(@RequestParam(value="uploadFile", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response)
/*     */     throws JSONException
/*     */   {
/* 104 */     responseInit(response);
/*     */ 
/* 106 */     String ext = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
/*     */ 
/* 108 */     Cms2Site site = Cms2Utils.getSite(request);
/* 109 */     JSONObject json = new JSONObject();
/*     */     try
/*     */     {
/* 112 */       String fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, file);
/* 113 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + this.resSys + fileUrl;
/* 114 */       json.put("success", true);
/* 115 */       json.put("fileUrl", fileUrl);
/* 116 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } catch (IllegalStateException e) {
/* 118 */       log.error("upload file error!", e);
/* 119 */       json.put("success", false).put("msg", e.getMessage());
/* 120 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } catch (IOException e) {
/* 122 */       log.error("upload file error!", e);
/* 123 */       json.put("success", false).put("msg", e.getMessage());
/* 124 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } catch (Exception e) {
/* 126 */       log.error("upload file error!", e);
/* 127 */       json.put("success", false).put("msg", e.getMessage());
/* 128 */       ResponseUtils.renderJson(response, json.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ueditor/image_manager"})
/*     */   public void image_manager(Integer pageNo, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
/* 135 */     Cms2Site site = Cms2Utils.getSite(request);
/* 136 */     String root = site.getResPath() + "/" + "upload";
/*     */ 
/* 138 */     responseInit(response);
/* 139 */     root = deCoderStr(root);
/* 140 */     List<String> pathList = this.cms2ResourceService.listImageFile(root);
/* 141 */     String imgPathRel = "";
/* 142 */     for (String path : pathList) {
/* 143 */       imgPathRel = imgPathRel + this.uploadServerBroker.getConfig().getURL() + "/" + this.resSys + path.substring(path.indexOf(site.getResPath().replace("/", File.separator))) + "ue_separate_ue";
/*     */     }
/*     */ 
/* 146 */     imgPathRel = imgPathRel.substring(0, imgPathRel.lastIndexOf("ue_separate_ue")).replace(File.separator, "/").trim();
/*     */     try
/*     */     {
/* 150 */       PrintWriter out = response.getWriter();
/* 151 */       out.print(imgPathRel);
/* 152 */       out.flush();
/* 153 */       out.close();
/*     */     } catch (IOException e) {
/* 155 */       log.error("Ueditor Manage picture ERROR", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/common"})
/*     */   public void execute(String filename, Integer uploadNum, Boolean mark, String hiddenName, SettlerAgent user, @RequestParam("fileType") String fileType, @RequestParam(value="uploadFile", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*     */   {
/* 168 */     if (file == null) {
/* 169 */       model.addAttribute("error", "请先上传图片");
/* 170 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "上传结果页", request, response, model, user);
/* 171 */       return;
/*     */     }
/* 173 */     if (StringUtils.isBlank(filename)) {
/* 174 */       filename = file.getOriginalFilename();
/*     */     }
/*     */ 
/* 177 */     String ext = FilenameUtils.getExtension(filename).toLowerCase();
/* 178 */     if ((fileType.equals("image")) && 
/* 179 */       (!ImageUtils.isValidImageExt(ext))) {
/* 180 */       model.addAttribute("error", "不支持的文件后缀");
/* 181 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "上传结果页", request, response, model, user);
/* 182 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 186 */       if ((fileType.equals("image")) && 
/* 187 */         (!ImageUtils.isImage(file.getInputStream()))) {
/* 188 */         model.addAttribute("error", "图片格式不支持");
/* 189 */         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "上传结果页", request, response, model, user);
/* 190 */         return;
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 194 */       log.error("image upload error", e);
/* 195 */       model.addAttribute("error", "IO错误");
/* 196 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "上传结果页", request, response, model, user);
/* 197 */       return;
/*     */     }
/*     */ 
/* 200 */     Cms2Site site = Cms2Utils.getSite(request);
/*     */ 
/* 202 */     ResourceType type = ResourceType.getDefaultResourceTypeByExtName(ext);
/*     */     try
/*     */     {
/* 205 */       String fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, file);
/* 206 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + this.resSys + fileUrl;
/* 207 */       model.addAttribute("resource", type.getPath());
/* 208 */       model.addAttribute("uploadPath", fileUrl);
/* 209 */       model.addAttribute("uploadNum", uploadNum);
/* 210 */       model.addAttribute("hiddenName", hiddenName);
/*     */     } catch (IllegalStateException e) {
/* 212 */       model.addAttribute("error", "文件读写错误");
/* 213 */       log.error("upload file error!", e);
/*     */     } catch (IOException e) {
/* 215 */       model.addAttribute("error", "文件读写错误");
/* 216 */       log.error("upload file error!", e);
/*     */     } catch (Exception e) {
/* 218 */       model.addAttribute("error", "文件读写错误");
/* 219 */       log.error("upload file error!", e);
/*     */     }
/*     */ 
/* 222 */     this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "上传结果页", request, response, model, user);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/attachment"})
/*     */   public void uploadAttachment(@RequestParam(value="attachmentFile", required=false) MultipartFile file, SettlerAgent user, String attachmentNum, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 232 */     String origName = file.getOriginalFilename();
/* 233 */     String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
/* 234 */     Cms2Site site = Cms2Utils.getSite(request);
/*     */     try
/*     */     {
/* 237 */       String fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, file);
/* 238 */       String fileGenerateName = fileUrl;
/* 239 */       fileGenerateName = fileGenerateName.substring(fileGenerateName.lastIndexOf("/") + 1, fileGenerateName.length());
/* 240 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + this.resSys + fileUrl;
/* 241 */       model.addAttribute("attachmentPath", fileUrl);
/* 242 */       model.addAttribute("attachmentName", fileGenerateName);
/* 243 */       model.addAttribute("attachmentNum", attachmentNum);
/*     */     } catch (Exception e) {
/* 245 */       model.addAttribute("error", e.getMessage());
/* 246 */       log.error("upload file error!", e);
/*     */     }
/* 248 */     this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "附件上传结果页", request, response, model, user);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/swf"})
/*     */   @ResponseStatus(HttpStatus.OK)
/*     */   @ResponseBody
/*     */   public void fileUpload_swf(MultipartHttpServletRequest request, HttpServletResponse response, @RequestParam(value="path", required=false) String path, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 260 */     JSONObject json = new JSONObject();
/*     */     try {
/* 262 */       int contentLength = request.getContentLength();
/* 263 */       log.info("request contentLength:" + contentLength);
/* 264 */       responseInit(response);
/*     */ 
/* 266 */       List files = request.getFiles("Filedata");
/* 267 */       json.put("error", false);
/* 268 */       if (path != null)
/* 269 */         path = path + this.uploadRootPath + "/" + path + "/";
/*     */       else {
/* 271 */         path = this.uploadRootPath + "/";
/*     */       }
/* 273 */       if ((null != files) && (files.size() > 0)) {
/* 274 */         MultipartFile file = (MultipartFile)files.get(0);
/* 275 */         if (FileUtils.uploadAffix(path, file.getOriginalFilename(), file) != null) {
/* 276 */           json.put("filename", file.getOriginalFilename());
/*     */         }
/*     */       }
/*     */ 
/* 280 */       response.getWriter().write(json.toString());
/*     */     } catch (Exception e) {
/* 282 */       json.put("error", true).put("errorInfo", "未预知错误");
/* 283 */       response.getWriter().write(json.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/fck/fUp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void upload(@RequestParam(value="Command", required=false) String commandStr, @RequestParam(value="Type", required=false) String typeStr, @RequestParam(value="CurrentFolder", required=false) String currentFolderStr, @RequestParam(value="mark", required=false) Boolean mark, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 294 */     responseInit(response);
/* 295 */     if ((StringUtils.isEmpty(commandStr)) && (StringUtils.isEmpty(currentFolderStr))) {
/* 296 */       commandStr = "QuickUpload";
/* 297 */       currentFolderStr = "/";
/* 298 */       if (StringUtils.isEmpty(typeStr)) {
/* 299 */         typeStr = "File";
/*     */       }
/*     */     }
/* 302 */     if ((currentFolderStr != null) && (!currentFolderStr.startsWith("/"))) {
/* 303 */       currentFolderStr = "/".concat(currentFolderStr);
/*     */     }
/* 305 */     log.debug("Parameter Command: {}", commandStr);
/* 306 */     log.debug("Parameter Type: {}", typeStr);
/* 307 */     log.debug("Parameter CurrentFolder: {}", currentFolderStr);
/* 308 */     UploadResponse ur = validateUpload(request, commandStr, typeStr, currentFolderStr);
/* 309 */     if (ur == null) {
/* 310 */       ur = doUpload(request, typeStr, currentFolderStr, mark);
/*     */     }
/* 312 */     PrintWriter out = response.getWriter();
/* 313 */     out.print(ur);
/* 314 */     out.flush();
/* 315 */     out.close();
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/Ueditor/fUp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void ueditorUpload(@RequestParam(value="Type", required=false) String typeStr, HttpServletRequest request, HttpServletResponse response) throws Exception
/*     */   {
/* 322 */     UEditorUploader ur = new UEditorUploader();
/* 323 */     ur.ResultSuccess();
/* 324 */     responseInit(response);
/* 325 */     if (StringUtils.isEmpty(typeStr)) {
/* 326 */       typeStr = "File";
/*     */     }
/*     */ 
/* 329 */     log.debug("Parameter Type: {}", typeStr);
/*     */ 
/* 331 */     ur = validateUpload(ur, typeStr);
/* 332 */     if (ur.IsSuccess().booleanValue()) {
/* 333 */       ur = doUpload(ur, request, typeStr);
/*     */     }
/* 335 */     PrintWriter out = response.getWriter();
/* 336 */     out.print(ur.toString());
/* 337 */     out.flush();
/* 338 */     out.close();
/*     */   }
/*     */ 
/*     */   private UploadResponse doUpload(HttpServletRequest request, String typeStr, String currentFolderStr, Boolean mark) throws Exception
/*     */   {
/* 343 */     ResourceType type = ResourceType.getDefaultResourceType(typeStr);
/*     */     try {
/* 345 */       Cms2Site site = Cms2Utils.getSite(request);
/* 346 */       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
/*     */ 
/* 348 */       MultipartFile uplFile = (MultipartFile)((Map.Entry)multipartRequest.getFileMap().entrySet().iterator().next()).getValue();
/*     */ 
/* 351 */       String filename = FilenameUtils.getName(uplFile.getOriginalFilename());
/* 352 */       log.debug("Parameter NewFile: {}", filename);
/* 353 */       String ext = FilenameUtils.getExtension(filename);
/* 354 */       if (type.isDeniedExtension(ext)) {
/* 355 */         return UploadResponse.getInvalidFileTypeError(request);
/*     */       }
/* 357 */       if ((type.equals(ResourceType.IMAGE)) && (!ImageUtils.isImage(uplFile.getInputStream()))) {
/* 358 */         return UploadResponse.getInvalidFileTypeError(request);
/*     */       }
/* 360 */       String fileUrl = null;
/* 361 */       if (null != uplFile) {
/* 362 */         fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, uplFile);
/*     */       }
/* 364 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + "/" + this.resSys + fileUrl;
/* 365 */       return UploadResponse.getOK(request, fileUrl); } catch (IOException e) {
/*     */     }
/* 367 */     return UploadResponse.getFileUploadWriteError(request);
/*     */   }
/*     */ 
/*     */   private UEditorUploader doUpload(UEditorUploader ur, HttpServletRequest request, String typeStr)
/*     */     throws Exception
/*     */   {
/* 374 */     Cms2Site site = Cms2Utils.getSite(request);
/* 375 */     ResourceType type = ResourceType.getDefaultResourceType(typeStr);
/* 376 */     boolean isMultipart = ServletFileUpload.isMultipartContent(request);
/* 377 */     if (!isMultipart) {
/* 378 */       ur.ResultErrorNofile();
/* 379 */       return ur;
/*     */     }
/*     */     try {
/* 382 */       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
/*     */ 
/* 384 */       MultipartFile uplFile = (MultipartFile)((Map.Entry)multipartRequest.getFileMap().entrySet().iterator().next()).getValue();
/*     */ 
/* 387 */       ur.setOriginalName(uplFile.getOriginalFilename());
/*     */ 
/* 389 */       String filename = FilenameUtils.getName(uplFile.getOriginalFilename());
/* 390 */       log.debug("Parameter NewFile: {}", filename);
/* 391 */       String ext = FilenameUtils.getExtension(filename);
/* 392 */       if (type.isDeniedExtension(ext)) {
/* 393 */         ur.ResultErrorType();
/*     */       }
/* 395 */       if ((type.equals(ResourceType.IMAGE)) && (!ImageUtils.isImage(uplFile.getInputStream()))) {
/* 396 */         ur.ResultErrorType();
/*     */       }
/* 398 */       String fileUrl = null;
/* 399 */       if (null != uplFile) {
/* 400 */         fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, uplFile);
/*     */       }
/* 402 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + "/" + this.resSys + fileUrl;
/* 403 */       ur.setUrl(fileUrl);
/* 404 */       ur.ResultSuccess();
/*     */     }
/*     */     catch (Exception e) {
/* 407 */       ur.ResultErrorUnknown();
/* 408 */       return ur;
/*     */     }
/* 410 */     return ur;
/*     */   }
/*     */ 
/*     */   private UploadResponse validateUpload(HttpServletRequest request, String commandStr, String typeStr, String currentFolderStr)
/*     */   {
/* 417 */     if (!Command.isValidForPost(commandStr)) {
/* 418 */       return UploadResponse.getInvalidCommandError(request);
/*     */     }
/* 420 */     if (!ResourceType.isValidType(typeStr)) {
/* 421 */       return UploadResponse.getInvalidResourceTypeError(request);
/*     */     }
/* 423 */     if (!UploadUtils.isValidPath(currentFolderStr)) {
/* 424 */       return UploadResponse.getInvalidCurrentFolderError(request);
/*     */     }
/* 426 */     return null;
/*     */   }
/*     */ 
/*     */   private File mark(MultipartFile file) throws Exception
/*     */   {
/* 431 */     String path = System.getProperty("java.io.tmpdir");
/* 432 */     File tempFile = new File(path, String.valueOf(System.currentTimeMillis()));
/* 433 */     file.transferTo(tempFile);
/* 434 */     return tempFile;
/*     */   }
/*     */ 
/*     */   public void setMultipartResolver(MultipartResolver multipartResolver) {
/* 438 */     this.multipartResolver = multipartResolver;
/*     */   }
/*     */ 
/*     */   public String deCoderStr(String str) {
/*     */     try {
/* 443 */       return URLDecoder.decode(str, "UTF-8");
/*     */     } catch (UnsupportedEncodingException e) {
/*     */     }
/* 446 */     return null;
/*     */   }
/*     */ 
/*     */   private UEditorUploader validateUpload(UEditorUploader ur, String typeStr) throws IOException {
/* 450 */     if (!ResourceType.isValidType(typeStr)) {
/* 451 */       ur.ResultErrorType();
/*     */     }
/* 453 */     return ur;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.UploadAction
 * JD-Core Version:    0.6.0
 */