/*    */ package com.hundsun.network.gates.fengshan.web.action.checkcode;
/*    */ 
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
/*    */ import nl.captcha.backgrounds.GradiatedBackgroundProducer;
/*    */ import nl.captcha.gimpy.BlockGimpyRenderer;
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
/* 34 */   private static final List<Font> englishFonts = Arrays.asList(new Font[] { new Font("Lucida Sans", 2, 60), new Font("SansSerif", 2, 75) });
/*    */ 
/*    */   @RequestMapping
/*    */   public void simple(HttpServletResponse response, Cookyjar cookyjar)
/*    */     throws IOException
/*    */   {
/* 41 */     Captcha captcha = new Captcha.Builder(220, 80).addText(new EasyCharTextProducer(), new FixedWordRenderer(Color.black, englishFonts)).gimp(new BlockGimpyRenderer()).gimp(new DropShadowGimpyRenderer()).addBackground(new GradiatedBackgroundProducer()).addNoise(new CurvedLineNoiseProducer(Color.black, 1.8F)).addNoise(new CurvedLineNoiseProducer(Color.black, 1.3F)).build();
/*    */ 
/* 52 */     cookyjar.set("checkCode", captcha.getAnswer());
/* 53 */     response.setContentType("image/jpeg");
/* 54 */     OutputStream os = response.getOutputStream();
/* 55 */     ImageIO.write(captcha.getImage(), "JPEG", os);
/*    */   }
/*    */ 
/*    */   @RequestMapping
/*    */   public void arithmetic(HttpServletResponse response, Cookyjar cookyjar) throws IOException {
/* 61 */     Random random = new Random();
/* 62 */     int one = 1 + random.nextInt(49);
/* 63 */     int two = random.nextInt(49);
/* 64 */     String text = "";
/* 65 */     int value = 0;
/* 66 */     if (random.nextBoolean()) {
/* 67 */       text = one + '+' + two + "";
/*    */ 
/* 69 */       value = one + two;
/*    */     }
/* 71 */     else if (one > two) {
/* 72 */       text = one + '-' + two+ "";
/*    */ 
/* 74 */       value = one - two;
/*    */     } else {
/* 76 */       text = two + '-' + one+ "";
/*    */ 
/* 78 */       value = two - one;
/*    */     }
/*    */ 
/* 81 */     cookyjar.set("checkCode", Long.valueOf(value));
/* 82 */     final String _text = text;
/* 83 */     Captcha captcha = new Captcha.Builder(220, 80).addText(new TextProducer()
/*    */     {
/*    */       public String getText() {
/* 86 */         return _text;
/*    */       }
/*    */     }
/*    */     , new FixedWordRenderer(Color.black, englishFonts)).gimp(new RippleGimpyRenderer()).gimp(new DropShadowGimpyRenderer()).addNoise(new CurvedLineNoiseProducer(Color.black, 2.8F)).addNoise(new CurvedLineNoiseProducer(Color.black, 1.3F)).addBackground(new GradiatedBackgroundProducer()).build();
/*    */ 
/* 94 */     response.setContentType("image/jpeg");
/* 95 */     OutputStream os = response.getOutputStream();
/* 96 */     ImageIO.write(captcha.getImage(), "JPEG", os);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.checkcode.CheckCodeAction
 * JD-Core Version:    0.6.0
 */