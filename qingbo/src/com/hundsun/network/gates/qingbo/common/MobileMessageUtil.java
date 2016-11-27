/*     */ package com.hundsun.network.gates.qingbo.common;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.List;
/*     */ import org.apache.commons.httpclient.HttpClient;
/*     */ import org.apache.commons.httpclient.HttpException;
/*     */ import org.apache.commons.httpclient.NameValuePair;
/*     */ import org.apache.commons.httpclient.methods.PostMethod;
/*     */ import org.apache.commons.httpclient.params.HttpClientParams;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ 
/*     */ public class MobileMessageUtil extends BaseService
/*     */ {
/*     */ 
/*     */   @Value("${mobile.msg.url}")
/*     */   private String url;
/*     */ 
/*     */   @Value("${mobile.msg.account}")
/*     */   private String account;
/*     */ 
/*     */   @Value("${mobile.msg.pswd}")
/*     */   private String pswd;
/*     */ 
/*     */   @Value("${mobile.msg.product}")
/*     */   private String product;
/*  39 */   private String msgCharset = "GBK";
/*     */ 
/*     */   public ServiceResult sendMsg(List<String> nums, String msg)
/*     */   {
/*  47 */     ServiceResult result = new ServiceResult();
/*  48 */     this.log.debug("MobileMessageUtil.sendMsg()");
/*  49 */     if ((nums == null) || (nums.size() < 1) || 
/*  50 */       (msg == null) || (msg.length() < 1)) {
/*  51 */       result.setErrorNOInfo(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()), 
/*  52 */         EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  53 */       return result;
/*     */     }
/*     */ 
/*  56 */     StringBuffer mNums = new StringBuffer("");
/*  57 */     for (String aNum : nums) {
/*  58 */       if (mNums.length() > 0) {
/*  59 */         mNums.append(",");
/*     */       }
/*  61 */       mNums.append(aNum);
/*     */     }
/*     */ 
/*  64 */     String defaultCharset = Charset.defaultCharset().name();
/*  65 */     this.log.info("Default charsetName=" + defaultCharset);
/*     */     try
/*     */     {
/*  69 */       msg = new String(msg.getBytes(this.msgCharset), this.msgCharset);
/*  70 */       this.account = new String(this.account.getBytes(this.msgCharset), this.msgCharset);
/*     */     } catch (UnsupportedEncodingException e) {
/*  72 */       e.printStackTrace();
/*     */     }
/*     */ 
/*  76 */     HttpClient httpClient = new HttpClient();
/*     */ 
/*  78 */     httpClient.getParams().setParameter("http.protocol.content-charset", this.msgCharset);
/*     */ 
/*  80 */     PostMethod postMethod = new PostMethod(this.url);
/*     */ 
/*  82 */     NameValuePair[] data = { 
/*  84 */       new NameValuePair("username", this.account), 
/*  86 */       new NameValuePair("password", this.pswd), 
/*  88 */       new NameValuePair("mobile", mNums.toString()), 
/*  93 */       new NameValuePair("content", msg) };
/*     */ 
/* 103 */     postMethod.setRequestBody(data);
/*     */     try
/*     */     {
/* 106 */       int statusCode = httpClient.executeMethod(postMethod);
/* 107 */       if (statusCode != 200) {
/* 108 */         this.log.error("MobileMessageUtil.sendMsg() failed: " + postMethod.getStatusLine());
/*     */       }
/*     */ 
/* 111 */       byte[] responseBody = postMethod.getResponseBody();
/*     */ 
/* 113 */       this.log.info("MobileMessageUtil.sendMsg() result: " + new String(responseBody));
/*     */     }
/*     */     catch (HttpException e)
/*     */     {
/* 117 */       this.log.error("MobileMessageUtil.sendMsg() HttpException", e);
/*     */     }
/*     */     catch (IOException e) {
/* 120 */       this.log.error("MobileMessageUtil.sendMsg() IOException", e);
/*     */     }
/*     */     finally {
/* 123 */       postMethod.releaseConnection();
/*     */     }
/* 125 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.common.MobileMessageUtil
 * JD-Core Version:    0.6.0
 */