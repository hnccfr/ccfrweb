/*    */ package com.hundsun.network.gates.genshan.web.action.common;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.common.KindEditorAjaxRequest;
/*    */ import com.hundsun.network.gates.genshan.biz.service.common.UploadService;
/*    */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*    */ import org.json.simple.JSONObject;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class KindEditorUploadImgAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UploadService uploadService;
/*    */ 
/*    */   @RequestMapping({"ajax/kindeditor/upload/image"})
/*    */   @ResponseBody
/*    */   public String uploadImg(@ModelAttribute("req") KindEditorAjaxRequest request)
/*    */   {
/* 27 */     JSONObject result = new JSONObject();
/* 28 */     String url = this.uploadService.uploadFile(request.getImgFile());
/* 29 */     if (null == url) {
/* 30 */       result.put("error", Integer.valueOf(1));
/* 31 */       result.put("message", "无法实现图片上传");
/*    */     } else {
/* 33 */       result.put("error", Integer.valueOf(0));
/* 34 */       result.put("url", getUploadServerBroker() + url);
/*    */     }
/* 36 */     return result.toJSONString();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.common.KindEditorUploadImgAction
 * JD-Core Version:    0.6.0
 */