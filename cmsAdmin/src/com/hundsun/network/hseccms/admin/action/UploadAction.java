/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.admin.util.FileRepository;
/*     */ import com.hundsun.network.hseccms.admin.util.FileUtils;
/*     */ import com.hundsun.network.hseccms.admin.util.ResponseUtils;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.hseccms.util.editor.Command;
/*     */ import com.hundsun.network.hseccms.util.editor.ResourceType;
/*     */ import com.hundsun.network.hseccms.util.editor.UploadUtils;
/*     */ import com.hundsun.network.hseccms.util.fck.UploadResponse;
/*     */ import com.hundsun.network.hseccms.util.image.ImageUtils;
/*     */ import com.hundsun.network.hseccms.util.ueditor.UEditorUploader;
/*     */ import com.hundsun.network.melody.common.web.url.URLBroker;
/*     */ import com.hundsun.network.melody.common.web.url.URLConfig;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
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
/*  51 */   private static final Logger log = LoggerFactory.getLogger(UploadAction.class);
/*     */ 
/*     */   @Autowired
/*     */   private FileRepository fileRepository;
/*     */   MultipartResolver multipartResolver;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private URLBroker uploadServerBroker;
/*     */   private static final String RESULT_PAGE = "/include/iframe_upload";
/*     */   public static final String ERROR = "error";
/*     */ 
/*     */   @Value("${site.resource}")
/*     */   private String resourcePath;
/*     */ 
/*     */   @Value("${resSys}")
/*     */   private String resSys;
/*     */ 
/*  84 */   public void responseInit(HttpServletResponse response) { response.setCharacterEncoding("UTF-8");
/*  85 */     response.setContentType("text/html;charset=UTF-8");
/*  86 */     response.setHeader("Charset", "utf-8");
/*  87 */     response.setHeader("Cache-Control", "no-cache");
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/json"})
/*     */   @ResponseStatus(HttpStatus.OK)
/*     */   @ResponseBody
/*     */   public void fileUpload(@RequestParam(value="uploadFile", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response)
/*     */     throws JSONException
/*     */   {
/* 101 */     responseInit(response);
/*     */ 
/* 103 */     String ext = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
/*     */ 
/* 105 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 106 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 107 */     JSONObject json = new JSONObject();
/*     */     try
/*     */     {
/* 110 */       String fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, file);
/*     */ 
/* 113 */       json.put("success", true);
/* 114 */       json.put("fileUrl", fileUrl);
/* 115 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } catch (IllegalStateException e) {
/* 117 */       log.error("upload file error!", e);
/* 118 */       json.put("success", false).put("msg", e.getMessage());
/* 119 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } catch (IOException e) {
/* 121 */       log.error("upload file error!", e);
/* 122 */       json.put("success", false).put("msg", e.getMessage());
/* 123 */       ResponseUtils.renderJson(response, json.toString());
/*     */     } catch (Exception e) {
/* 125 */       log.error("upload file error!", e);
/* 126 */       json.put("success", false).put("msg", e.getMessage());
/* 127 */       ResponseUtils.renderJson(response, json.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/common"})
/*     */   public String execute(String filename, Integer uploadNum, Boolean mark, String hiddenName, @RequestParam("fileType") String fileType, @RequestParam(value="uploadFile", required=false) MultipartFile file, HttpServletRequest request, ModelMap model)
/*     */   {
/* 140 */     if (file == null) {
/* 141 */       model.addAttribute("error", "请先上传图片");
/* 142 */       return "/include/iframe_upload";
/*     */     }
/* 144 */     if (StringUtils.isBlank(filename)) {
/* 145 */       filename = file.getOriginalFilename();
/*     */     }
/*     */ 
/* 148 */     String ext = FilenameUtils.getExtension(filename).toLowerCase();
/* 149 */     if ((fileType.equals("image")) && 
/* 150 */       (!ImageUtils.isValidImageExt(ext))) {
/* 151 */       model.addAttribute("error", "不支持的文件后缀");
/* 152 */       return "/include/iframe_upload";
/*     */     }
/*     */ 
/* 155 */     if ((fileType.equals("media")) && 
/* 156 */       (!ImageUtils.isValidMediaExt(ext))) {
/* 157 */       model.addAttribute("error", "不支持的文件后缀");
/* 158 */       return "/include/iframe_upload";
/*     */     }
/*     */ 
/* 162 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 163 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 165 */     ResourceType type = ResourceType.getDefaultResourceTypeByExtName(ext);
/*     */     try
/*     */     {
/* 168 */       String fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, file);
/* 169 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + this.resSys + fileUrl;
/* 170 */       model.addAttribute("resource", type.getPath());
/* 171 */       model.addAttribute("uploadPath", fileUrl);
/* 172 */       model.addAttribute("uploadNum", uploadNum);
/* 173 */       model.addAttribute("hiddenName", hiddenName);
/* 174 */       model.addAttribute("fileName", file.getName());
/*     */     } catch (IllegalStateException e) {
/* 176 */       model.addAttribute("error", "文件读写错误");
/* 177 */       log.error("upload file error!", e);
/*     */     } catch (IOException e) {
/* 179 */       model.addAttribute("error", "文件读写错误");
/* 180 */       log.error("upload file error!", e);
/*     */     } catch (Exception e) {
/* 182 */       model.addAttribute("error", "文件读写错误");
/* 183 */       log.error("upload file error!", e);
/*     */     }
/* 185 */     return "/include/iframe_upload";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/attachment"})
/*     */   public String uploadAttachment(@RequestParam(value="attachmentFile", required=false) MultipartFile file, String attachmentNum, HttpServletRequest request, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 194 */     String origName = file.getOriginalFilename();
/* 195 */     String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
/* 196 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 197 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */     try
/*     */     {
/* 200 */       String fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, file);
/* 201 */       String fileGenerateName = fileUrl;
/* 202 */       fileGenerateName = fileGenerateName.substring(fileGenerateName.lastIndexOf("/") + 1, fileGenerateName.length());
/* 203 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + this.resSys + fileUrl;
/* 204 */       model.addAttribute("attachmentPath", fileUrl);
/* 205 */       model.addAttribute("attachmentName", fileGenerateName);
/* 206 */       model.addAttribute("attachmentNum", attachmentNum);
/*     */     } catch (Exception e) {
/* 208 */       model.addAttribute("error", e.getMessage());
/* 209 */       log.error("upload file error!", e);
/*     */     }
/* 211 */     return "/include/attachment_iframe";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fUp/swf"})
/*     */   @ResponseStatus(HttpStatus.OK)
/*     */   @ResponseBody
/*     */   public void fileUpload_swf(MultipartHttpServletRequest request, HttpServletResponse response, @RequestParam(value="path", required=false) String path, ModelMap model) throws Exception
/*     */   {
/* 222 */     JSONObject json = new JSONObject();
/*     */     try {
/* 224 */       int contentLength = request.getContentLength();
/* 225 */       log.info("request contentLength:" + contentLength);
/* 226 */       responseInit(response);
/*     */ 
/* 228 */       List files = request.getFiles("Filedata");
/* 229 */       json.put("error", false);
/* 230 */       if (path != null)
/*     */       {
/* 235 */         path = path + this.resourcePath + "/" + path + "/";
/*     */       }
/*     */       else {
/* 238 */         path = this.resourcePath + "/";
/*     */       }
/*     */ 
/* 241 */       if ((null != files) && (files.size() > 0)) {
/* 242 */         MultipartFile file = (MultipartFile)files.get(0);
/* 243 */         if (FileUtils.uploadAffix(path, file.getOriginalFilename(), file) != null) {
/* 244 */           json.put("filename", file.getOriginalFilename());
/*     */         }
/*     */       }
/*     */ 
/* 248 */       response.getWriter().write(json.toString());
/*     */     } catch (Exception e) {
/* 250 */       json.put("error", true).put("errorInfo", "未预知错误");
/* 251 */       response.getWriter().write(json.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/fck/fUp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void upload(@RequestParam(value="Command", required=false) String commandStr, @RequestParam(value="Type", required=false) String typeStr, @RequestParam(value="CurrentFolder", required=false) String currentFolderStr, @RequestParam(value="mark", required=false) Boolean mark, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 262 */     responseInit(response);
/* 263 */     if ((StringUtils.isEmpty(commandStr)) && (StringUtils.isEmpty(currentFolderStr))) {
/* 264 */       commandStr = "QuickUpload";
/* 265 */       currentFolderStr = "/";
/* 266 */       if (StringUtils.isEmpty(typeStr)) {
/* 267 */         typeStr = "File";
/*     */       }
/*     */     }
/* 270 */     if ((currentFolderStr != null) && (!currentFolderStr.startsWith("/"))) {
/* 271 */       currentFolderStr = "/".concat(currentFolderStr);
/*     */     }
/* 273 */     log.debug("Parameter Command: {}", commandStr);
/* 274 */     log.debug("Parameter Type: {}", typeStr);
/* 275 */     log.debug("Parameter CurrentFolder: {}", currentFolderStr);
/* 276 */     UploadResponse ur = validateUpload(request, commandStr, typeStr, currentFolderStr);
/* 277 */     if (ur == null) {
/* 278 */       ur = doUpload(request, typeStr, currentFolderStr, mark);
/*     */     }
/* 280 */     PrintWriter out = response.getWriter();
/* 281 */     out.print(ur);
/* 282 */     out.flush();
/* 283 */     out.close();
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/Ueditor/fUp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void ueditorUpload(@RequestParam(value="Type", required=false) String typeStr, HttpServletRequest request, HttpServletResponse response) throws Exception
/*     */   {
/* 290 */     UEditorUploader ur = new UEditorUploader();
/* 291 */     ur.ResultSuccess();
/* 292 */     responseInit(response);
/* 293 */     if (StringUtils.isEmpty(typeStr)) {
/* 294 */       typeStr = "File";
/*     */     }
/*     */ 
/* 297 */     log.debug("Parameter Type: {}", typeStr);
/*     */ 
/* 299 */     ur = validateUpload(ur, typeStr);
/* 300 */     if (ur.IsSuccess().booleanValue()) {
/* 301 */       ur = doUpload(ur, request, typeStr);
/*     */     }
/* 303 */     PrintWriter out = response.getWriter();
/* 304 */     out.print(ur.toString());
/* 305 */     out.flush();
/* 306 */     out.close();
/*     */   }
/*     */ 
/*     */   private UploadResponse doUpload(HttpServletRequest request, String typeStr, String currentFolderStr, Boolean mark) throws Exception
/*     */   {
/* 311 */     ResourceType type = ResourceType.getDefaultResourceType(typeStr);
/*     */     try {
/* 313 */       Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 314 */       Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 315 */       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
/*     */ 
/* 317 */       MultipartFile uplFile = (MultipartFile)((Map.Entry)multipartRequest.getFileMap().entrySet().iterator().next()).getValue();
/*     */ 
/* 320 */       String filename = FilenameUtils.getName(uplFile.getOriginalFilename());
/* 321 */       log.debug("Parameter NewFile: {}", filename);
/* 322 */       String ext = FilenameUtils.getExtension(filename);
/* 323 */       if (type.isDeniedExtension(ext)) {
/* 324 */         return UploadResponse.getInvalidFileTypeError(request);
/*     */       }
/* 326 */       if ((type.equals(ResourceType.IMAGE)) && (!ImageUtils.isImage(uplFile.getInputStream()))) {
/* 327 */         return UploadResponse.getInvalidFileTypeError(request);
/*     */       }
/* 329 */       String fileUrl = null;
/* 330 */       if (null != uplFile) {
/* 331 */         fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, uplFile);
/*     */       }
/* 333 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + "/" + this.resSys + fileUrl;
/* 334 */       return UploadResponse.getOK(request, fileUrl); } catch (IOException e) {
/*     */     }
/* 336 */     return UploadResponse.getFileUploadWriteError(request);
/*     */   }
/*     */ 
/*     */   private UEditorUploader doUpload(UEditorUploader ur, HttpServletRequest request, String typeStr)
/*     */     throws Exception
/*     */   {
/* 343 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 344 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 345 */     ResourceType type = ResourceType.getDefaultResourceType(typeStr);
/* 346 */     boolean isMultipart = ServletFileUpload.isMultipartContent(request);
/* 347 */     if (!isMultipart) {
/* 348 */       ur.ResultErrorNofile();
/* 349 */       return ur;
/*     */     }
/*     */     try {
/* 352 */       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
/*     */ 
/* 354 */       MultipartFile uplFile = (MultipartFile)((Map.Entry)multipartRequest.getFileMap().entrySet().iterator().next()).getValue();
/*     */ 
/* 357 */       ur.setOriginalName(uplFile.getOriginalFilename());
/*     */ 
/* 359 */       String filename = FilenameUtils.getName(uplFile.getOriginalFilename());
/* 360 */       log.debug("Parameter NewFile: {}", filename);
/* 361 */       String ext = FilenameUtils.getExtension(filename);
/* 362 */       if (type.isDeniedExtension(ext)) {
/* 363 */         ur.ResultErrorType();
/*     */       }
/* 365 */       if ((type.equals(ResourceType.IMAGE)) && (!ImageUtils.isImage(uplFile.getInputStream()))) {
/* 366 */         ur.ResultErrorType();
/*     */       }
/* 368 */       String fileUrl = null;
/* 369 */       if (null != uplFile) {
/* 370 */         fileUrl = this.fileRepository.storeByExt(site.getResPath(), ext, uplFile);
/*     */       }
/* 372 */       fileUrl = this.uploadServerBroker.getConfig().getURL() + "/" + this.resSys + fileUrl;
/* 373 */       ur.setUrl(fileUrl);
/* 374 */       ur.ResultSuccess();
/*     */     }
/*     */     catch (Exception e) {
/* 377 */       ur.ResultErrorUnknown();
/* 378 */       return ur;
/*     */     }
/* 380 */     return ur;
/*     */   }
/*     */ 
/*     */   private UploadResponse validateUpload(HttpServletRequest request, String commandStr, String typeStr, String currentFolderStr)
/*     */   {
/* 387 */     if (!Command.isValidForPost(commandStr)) {
/* 388 */       return UploadResponse.getInvalidCommandError(request);
/*     */     }
/* 390 */     if (!ResourceType.isValidType(typeStr)) {
/* 391 */       return UploadResponse.getInvalidResourceTypeError(request);
/*     */     }
/* 393 */     if (!UploadUtils.isValidPath(currentFolderStr)) {
/* 394 */       return UploadResponse.getInvalidCurrentFolderError(request);
/*     */     }
/* 396 */     return null;
/*     */   }
/*     */ 
/*     */   private UEditorUploader validateUpload(UEditorUploader ur, String typeStr) throws IOException {
/* 400 */     if (!ResourceType.isValidType(typeStr)) {
/* 401 */       ur.ResultErrorType();
/*     */     }
/* 403 */     return ur;
/*     */   }
/*     */ 
/*     */   private File mark(MultipartFile file) throws Exception
/*     */   {
/* 408 */     String path = System.getProperty("java.io.tmpdir");
/* 409 */     File tempFile = new File(path, String.valueOf(System.currentTimeMillis()));
/* 410 */     file.transferTo(tempFile);
/* 411 */     return tempFile;
/*     */   }
/*     */ 
/*     */   public void setMultipartResolver(MultipartResolver multipartResolver) {
/* 415 */     this.multipartResolver = multipartResolver;
/*     */   }
/*     */ 
/*     */   public void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.UploadAction
 * JD-Core Version:    0.6.0
 */