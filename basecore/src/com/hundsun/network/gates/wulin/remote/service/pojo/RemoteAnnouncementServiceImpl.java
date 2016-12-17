/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumAnnouncementResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AnnouncementRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.AnnouncementServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteAnnouncementService;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.operation.AnnouncementService;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteAnnouncementService")
/*     */ public class RemoteAnnouncementServiceImpl extends BaseService
/*     */   implements RemoteAnnouncementService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AnnouncementService announcementService;
/*     */ 
/*     */   public AnnouncementServiceResult queryAnnouncementList(AnnouncementRequest request)
/*     */   {
/*  32 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/*  34 */     if ((request == null) || (request.getAnnouncementDTO() == null)) {
/*  35 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/*  36 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/*  37 */       return result;
/*  38 */     }if ((EnumAnnouncementType.PROJECT.getValue().equals(request.getAnnouncementDTO().getType())) && (request.getAnnouncementDTO().getProjectId() == null))
/*     */     {
/*  41 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_PRO_NULL.getValue()));
/*  42 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_PRO_NULL.getInfo());
/*  43 */       return result;
/*     */     }
/*     */ 
/*  46 */     AnnouncementQuery query = ConvertUtils.convert2AnnouncementQuery(request.getAnnouncementDTO());
/*     */ 
/*  48 */     List<Announcement> announcementList = this.announcementService.queryAnnouncementList(query);
/*  49 */     List announcementDTOList = new ArrayList();
/*  50 */     for (Announcement announcement : announcementList) {
/*  51 */       announcementDTOList.add(ConvertUtils.convert2AnnouncementDTO(announcement));
/*     */     }
/*  53 */     result.setAnnouncementDTOList(announcementDTOList);
/*  54 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult queryAnnouncementInfo(Long announcementId)
/*     */   {
/*  63 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/*  65 */     if (announcementId == null) {
/*  66 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/*  67 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/*  68 */       return result;
/*     */     }
/*  70 */     Announcement announcement = this.announcementService.queryAnnouncementInfo(announcementId);
/*     */ 
/*  72 */     if ((announcement == null) || (announcement.getStatus().intValue() == 0)) {
/*  73 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getValue()));
/*  74 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getInfo());
/*  75 */       return result;
/*     */     }
/*  77 */     result.setAnnouncementDTO(ConvertUtils.convert2AnnouncementDTO(announcement));
/*  78 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult queryNewestAnnouncement()
/*     */   {
/*  87 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*  88 */     Announcement announcement = this.announcementService.queryNewestAnnouncement();
/*  89 */     result.setAnnouncementDTO(ConvertUtils.convert2AnnouncementDTO(announcement));
/*  90 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult createAnnouncement(AnnouncementRequest request)
/*     */   {
/*  99 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/* 101 */     if ((request == null) || (request.getAnnouncementDTO() == null)) {
/* 102 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/* 103 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/* 104 */       return result;
/*     */     }
/* 106 */     Announcement announcement = ConvertUtils.convert2Announcement(request.getAnnouncementDTO());
/*     */ 
/* 108 */     if ((EnumAnnouncementType.PROJECT.equals(announcement.getType())) && (announcement.getProjectId() == null))
/*     */     {
/* 110 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_PRO_NULL.getValue()));
/* 111 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_PRO_NULL.getInfo());
/* 112 */       return result;
/*     */     }
/*     */ 
/* 115 */     announcement.setStatus(EnumAnnouncementStatus.CREATE.getValue());
/* 116 */     Long newId = null;
/*     */     try
/*     */     {
/* 119 */       newId = request.isInsertNormal() ? this.announcementService.insertNormal(announcement) : this.announcementService.insert(announcement);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 123 */       this.log.debug(e.getMessage());
/* 124 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.INTERNAL_ERROR.getValue()));
/* 125 */       result.setErrorInfo(EnumAnnouncementResultErrors.INTERNAL_ERROR.getInfo());
/* 126 */       return result;
/*     */     }
/* 128 */     if (newId == null) {
/* 129 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_ADD_ERROR.getValue()));
/* 130 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_ADD_ERROR.getInfo());
/* 131 */       return result;
/*     */     }
/* 133 */     if (request.isInsertNormal()) announcement.setId(newId);
/* 134 */     result.setAnnouncementDTO(ConvertUtils.convert2AnnouncementDTO(announcement));
/* 135 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult removeAnnouncement(AnnouncementRequest request)
/*     */   {
/* 144 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/* 146 */     if ((request.getAnnouncementDTO() == null) || (request.getAnnouncementDTO().getId() == null)) {
/* 147 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/* 148 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/* 149 */       return result;
/*     */     }
/* 151 */     Announcement announcement = this.announcementService.queryAnnouncementInfo(request.getAnnouncementDTO().getId());
/*     */ 
/* 154 */     if ((announcement == null) || (announcement.getStatus().intValue() == 0)) {
/* 155 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getValue()));
/* 156 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getInfo());
/* 157 */       return result;
/*     */     }
/* 159 */     request.getAnnouncementDTO().setProjectId(announcement.getProjectId());
/*     */     try {
/* 161 */       this.announcementService.removeAnnouncement(announcement);
/*     */     } catch (Exception e) {
/* 163 */       this.log.debug(e.getMessage());
/* 164 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.INTERNAL_ERROR.getValue()));
/* 165 */       result.setErrorInfo(EnumAnnouncementResultErrors.INTERNAL_ERROR.getInfo());
/* 166 */       return result;
/*     */     }
/* 168 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 169 */     announcementDTO.setId(announcement.getId());
/* 170 */     result.setAnnouncementDTO(announcementDTO);
/* 171 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult joinProject(AnnouncementRequest request)
/*     */   {
/* 181 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/* 183 */     if ((request.getAnnouncementDTO() == null) || (request.getAnnouncementDTO().getId() == null) || (request.getAnnouncementDTO().getProjectId() == null))
/*     */     {
/* 185 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/* 186 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/* 187 */       return result;
/*     */     }
/* 189 */     Announcement announcement = this.announcementService.queryAnnouncementInfo(request.getAnnouncementDTO().getId());
/*     */ 
/* 192 */     if ((announcement == null) || (announcement.getStatus().intValue() == 0)) {
/* 193 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getValue()));
/* 194 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getInfo());
/* 195 */       return result;
/*     */     }
/* 197 */     request.getAnnouncementDTO().setStatus(announcement.getStatus());
/*     */     try {
/* 199 */       this.announcementService.joinProject(ConvertUtils.convert2Announcement(request.getAnnouncementDTO()));
/*     */     }
/*     */     catch (Exception e) {
/* 202 */       e.printStackTrace();
/* 203 */       this.log.debug(e.getMessage());
/* 204 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.INTERNAL_ERROR.getValue()));
/* 205 */       result.setErrorInfo(EnumAnnouncementResultErrors.INTERNAL_ERROR.getInfo());
/* 206 */       return result;
/*     */     }
/* 208 */     result.setAnnouncementDTO(request.getAnnouncementDTO());
/* 209 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult leaveProject(AnnouncementRequest request)
/*     */   {
/* 219 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/* 221 */     if ((request.getAnnouncementDTO() == null) || (request.getAnnouncementDTO().getId() == null)) {
/* 222 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/* 223 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/* 224 */       return result;
/*     */     }
/* 226 */     Announcement announcement = this.announcementService.queryAnnouncementInfo(request.getAnnouncementDTO().getId());
/*     */ 
/* 229 */     if ((announcement == null) || (announcement.getStatus().intValue() == 0)) {
/* 230 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getValue()));
/* 231 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getInfo());
/* 232 */       return result;
/*     */     }
/*     */ 
/* 235 */     if (EnumAnnouncementType.PROJECT.getValue().equals(announcement.getType())) {
/* 236 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_PRO_NULL.getValue()));
/* 237 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_PRO_NULL.getInfo());
/* 238 */       return result;
/*     */     }
/*     */     try {
/* 241 */       this.announcementService.leaveProject(ConvertUtils.convert2Announcement(request.getAnnouncementDTO()));
/*     */     }
/*     */     catch (Exception e) {
/* 244 */       e.printStackTrace();
/* 245 */       this.log.debug(e.getMessage());
/* 246 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.INTERNAL_ERROR.getValue()));
/* 247 */       result.setErrorInfo(EnumAnnouncementResultErrors.INTERNAL_ERROR.getInfo());
/* 248 */       return result;
/*     */     }
/* 250 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 251 */     announcementDTO.setId(announcement.getId());
/* 252 */     result.setAnnouncementDTO(announcementDTO);
/* 253 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult normal(AnnouncementRequest request)
/*     */   {
/* 262 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/* 264 */     if ((request.getAnnouncementDTO() == null) || (request.getAnnouncementDTO().getId() == null)) {
/* 265 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/* 266 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/* 267 */       return result;
/*     */     }
/* 269 */     Announcement announcement = this.announcementService.queryAnnouncementInfo(request.getAnnouncementDTO().getId());
/*     */ 
/* 272 */     if ((announcement == null) || (announcement.getStatus().intValue() != 1)) {
/* 273 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getValue()));
/* 274 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_STATUS_ERROR.getInfo());
/* 275 */       return result;
/*     */     }
/*     */     try {
/* 278 */       this.announcementService.normal(announcement);
/*     */     } catch (Exception e) {
/* 280 */       this.log.debug(e.getMessage());
/* 281 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.INTERNAL_ERROR.getValue()));
/* 282 */       result.setErrorInfo(EnumAnnouncementResultErrors.INTERNAL_ERROR.getInfo());
/* 283 */       return result;
/*     */     }
/* 285 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 286 */     announcementDTO.setId(announcement.getId());
/* 287 */     result.setAnnouncementDTO(announcementDTO);
/* 288 */     return result;
/*     */   }
/*     */ 
/*     */   public AnnouncementServiceResult updateById(AnnouncementRequest request)
/*     */   {
/* 297 */     AnnouncementServiceResult result = new AnnouncementServiceResult();
/*     */ 
/* 299 */     if ((request == null) || (request.getAnnouncementDTO() == null) || (request.getAnnouncementDTO().getId() == null))
/*     */     {
/* 301 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.PARAMETER_ERROR.getValue()));
/* 302 */       result.setErrorInfo(EnumAnnouncementResultErrors.PARAMETER_ERROR.getInfo());
/* 303 */       return result;
/*     */     }
/* 305 */     Announcement announcement = ConvertUtils.convert2Announcement(request.getAnnouncementDTO());
/*     */ 
/* 307 */     if ((EnumAnnouncementType.PROJECT.equals(announcement.getType())) && (announcement.getProjectId() == null))
/*     */     {
/* 309 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.ANN_PRO_NULL.getValue()));
/* 310 */       result.setErrorInfo(EnumAnnouncementResultErrors.ANN_PRO_NULL.getInfo());
/* 311 */       return result;
/*     */     }
/*     */     try {
/* 314 */       this.announcementService.updateById(announcement);
/*     */     } catch (Exception e) {
/* 316 */       this.log.debug(e.getMessage());
/* 317 */       result.setErrorNO(Integer.valueOf(EnumAnnouncementResultErrors.INTERNAL_ERROR.getValue()));
/* 318 */       result.setErrorInfo(EnumAnnouncementResultErrors.INTERNAL_ERROR.getInfo());
/* 319 */       return result;
/*     */     }
/* 321 */     result.setAnnouncementDTO(request.getAnnouncementDTO());
/* 322 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteAnnouncementServiceImpl
 * JD-Core Version:    0.6.0
 */