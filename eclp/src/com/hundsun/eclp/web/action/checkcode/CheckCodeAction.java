/*    */ package com.hundsun.eclp.web.action.checkcode;
/*    */ 
/*    */ import com.hundsun.eclp.common.CheckCode;
/*    */ import com.hundsun.network.melody.common.util.captcha.EasyCharTextProducer;
/*    */ import com.hundsun.network.melody.common.util.captcha.FixedWordRenderer;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import nl.captcha.Captcha;
/*    */ import nl.captcha.Captcha.Builder;
/*    */ import nl.captcha.backgrounds.FlatColorBackgroundProducer;
/*    */ import nl.captcha.backgrounds.GradiatedBackgroundProducer;
/*    */ import nl.captcha.gimpy.DropShadowGimpyRenderer;
/*    */ import nl.captcha.gimpy.RippleGimpyRenderer;
/*    */ import nl.captcha.noise.CurvedLineNoiseProducer;
/*    */ import nl.captcha.text.producer.TextProducer;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/checkcode/*"})
/*    */ public class CheckCodeAction
/*    */ {
/* 39 */   private static final List<Font> englishFonts = Arrays.asList(new Font[] { new Font("Lucida Sans", 2, 55), new Font("SansSerif", 2, 60) });
/*    */ 
/*    */   @RequestMapping
/*    */   public void simple(HttpServletResponse response, Cookyjar cookyjar) throws IOException
/*    */   {
/* 45 */     Captcha captcha = new Captcha.Builder(190, 60).addText(new EasyCharTextProducer(), new FixedWordRenderer(Color.black, englishFonts)).gimp().addBackground(new FlatColorBackgroundProducer(Color.white)).addNoise(new CurvedLineNoiseProducer(Color.black, 1.8F)).addNoise(new CurvedLineNoiseProducer(Color.black, 1.3F)).build();
/*    */ 
/* 51 */     response.setContentType("image/jpeg");
/*    */ 
/* 53 */     CheckCode checkCode = new CheckCode();
/* 54 */     checkCode.setLoginCheckCode(captcha.getAnswer());
/* 55 */     cookyjar.set(checkCode);
/*    */ 
/* 57 */     OutputStream os = response.getOutputStream();
/* 58 */     ImageIO.write(captcha.getImage(), "JPEG", os);
/*    */   }
/*    */   @RequestMapping
/*    */   public void arithmetic(HttpServletResponse response) throws IOException {
/* 63 */     final Random random = new Random();
/* 64 */     final int one = 1 + random.nextInt(49);
/* 65 */     final int two = random.nextInt(49);
/*    */ 
/* 67 */     Captcha captcha = new Captcha.Builder(220, 80).addText(new TextProducer()
/*    */     {
/*    */       public String getText() {
/* 70 */         if (random.nextBoolean()) {
/* 71 */           return one + '+' + two + "";
/*    */         }
/*    */ 
/* 74 */         if (one > two) {
/* 75 */           return one + '-' + two+ "";
/*    */         }
/*    */ 
/* 78 */         return two + '-' + one+ "";
/*    */       }
/*    */     }
/*    */     , new FixedWordRenderer(Color.black, englishFonts)).gimp(new RippleGimpyRenderer()).gimp(new DropShadowGimpyRenderer()).addNoise(new CurvedLineNoiseProducer(Color.black, 2.8F)).addNoise(new CurvedLineNoiseProducer(Color.black, 1.3F)).addBackground(new GradiatedBackgroundProducer()).build();
/*    */ 
/* 88 */     response.setContentType("image/jpeg");
/* 89 */     OutputStream os = response.getOutputStream();
/* 90 */     ImageIO.write(captcha.getImage(), "JPEG", os);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.checkcode.CheckCodeAction
 * JD-Core Version:    0.6.0
 */