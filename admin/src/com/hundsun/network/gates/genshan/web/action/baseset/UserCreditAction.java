/*    */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCredit;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.UserCreditQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemCreditLevelService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.UserCreditService;
/*    */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*    */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ @Controller
/*    */ public class UserCreditAction extends BaseAction
/*    */ {
/* 33 */   protected final Log logger = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private UserCreditService userCreditService;
/*    */ 
/*    */   @Autowired
/*    */   private SystemCreditLevelService systemCreditLevelService;
/*    */ 
/*    */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERCREDIT_LIST})
/*    */   @RequestMapping({"/baseset/usercredit/list"})
/*    */   public void list(@RequestParam(value="userAccount", required=false) String userAccount, @ModelAttribute("query") UserCreditQuery query, ModelMap model) throws Exception {
/* 50 */     if (StringUtil.isNotEmpty(userAccount)) {
/* 51 */       query.setUserAccount(userAccount.trim());
/*    */     }
/* 53 */     List systemCreditLevelList = this.systemCreditLevelService.selectAllList();
/* 54 */     model.addAttribute("systemCreditLevelList", systemCreditLevelList);
/* 55 */     this.userCreditService.selectPageList(query);
/*    */   }
/*    */ 
/*    */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERCREDIT_VIEW})
/*    */   @RequestMapping({"/baseset/usercredit/view"})
/*    */   public void view(@RequestParam("id") Long id, Model model)
/*    */     throws Exception
/*    */   {
/* 65 */     List systemCreditLevelList = this.systemCreditLevelService.selectAllList();
/* 66 */     model.addAttribute("systemCreditLevelList", systemCreditLevelList);
/* 67 */     UserCredit smls = this.userCreditService.selectByPrimaryKey(id);
/* 68 */     model.addAttribute("smls", smls);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.UserCreditAction
 * JD-Core Version:    0.6.0
 */