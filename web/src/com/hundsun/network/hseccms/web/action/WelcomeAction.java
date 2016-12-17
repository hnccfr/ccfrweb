/*    */ package com.hundsun.network.hseccms.web.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*    */ import com.hundsun.network.hseccms.web.security.SettlerAccessDeniedException;
/*    */ import java.net.InetAddress;
/*    */ import java.net.NetworkInterface;
/*    */ import java.util.Enumeration;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class WelcomeAction
/*    */ {
/* 24 */   private static Log _log = LogFactory.getLog(WelcomeAction.class);
/*    */ 
/* 28 */   @RequestMapping({"/welcome"})
/*    */   public void showWelcome(Model model, SettlerAgent settlerAgent) { if (settlerAgent == null) {
/* 29 */       throw new SettlerAccessDeniedException();
/*    */     }
/* 31 */     Cms2Site site = new Cms2Site();
/* 32 */     model.addAttribute("site", site);
/* 33 */     model.addAttribute("user", "未来的乔布斯-from web");
/* 34 */     String ip = "";
/*    */     try {
/* 36 */       ip = getAllLocalIP();
/*    */     } catch (Exception e) {
/* 38 */       _log.error("can not to get localHost");
/*    */     }
/* 40 */     model.addAttribute("ip", ip); }
/*    */ 
/*    */   public static String getAllLocalIP()
/*    */     throws Exception
/*    */   {
/* 45 */     String ar = "";
/* 46 */     Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
/* 47 */     InetAddress ip = null;
/* 48 */     while (netInterfaces.hasMoreElements()) {
/* 49 */       NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
/* 50 */       String netip = null;
/* 51 */       String localip = null;
/* 52 */       Enumeration address = ni.getInetAddresses();
/* 53 */       while (address.hasMoreElements()) {
/* 54 */         ip = (InetAddress)address.nextElement();
/* 55 */         if ((!ip.isSiteLocalAddress()) && (!ip.isLoopbackAddress()) && (ip.getHostAddress().indexOf(":") == -1))
/*    */         {
/* 57 */           netip = netip + ip.getHostAddress() + ";"; continue;
/* 58 */         }if ((!ip.isSiteLocalAddress()) || (ip.isLoopbackAddress()) || (ip.getHostAddress().indexOf(":") != -1))
/*    */           continue;
/* 60 */         localip = ip.getHostAddress() + ";";
/*    */       }
/*    */ 
/* 63 */       ar = ar + "[" + netip + "|" + localip + "]";
/*    */     }
/* 65 */     return ar;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.WelcomeAction
 * JD-Core Version:    0.6.0
 */