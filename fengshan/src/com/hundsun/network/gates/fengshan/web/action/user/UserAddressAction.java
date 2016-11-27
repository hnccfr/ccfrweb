/*     */ package com.hundsun.network.gates.fengshan.web.action.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAddress;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserAddressService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.fengshan.web.validator.user.UserAddressValidator;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class UserAddressAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserAddressService userAddressService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAddressValidator userAddressValidator;
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_ADDRESS})
/*     */   @RequestMapping(value={"/user/address/operate"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initUserAddressAdd(UserAgent userAgent, @ModelAttribute("userAddress") UserAddress userAddress, Model model)
/*     */   {
/*  54 */     if (null != userAddress.getId()) {
/*  55 */       userAddress = this.userAddressService.getUserAddressById(userAddress.getId());
/*  56 */       model.addAttribute("userAddress", userAddress);
/*     */     }
/*  58 */     UserAddress queryUserAddress = new UserAddress();
/*  59 */     queryUserAddress.setUserAccount(userAgent.getAccount());
/*  60 */     queryUserAddress.setType(userAddress.getType());
/*  61 */     List allUserAddresses = new ArrayList();
/*  62 */     allUserAddresses = this.userAddressService.getAllUserAddresses(queryUserAddress);
/*  63 */     model.addAttribute("allUserAddresses", allUserAddresses);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_ADDRESS})
/*     */   @RequestMapping(value={"/user/address/operate"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void userAddressAdd(UserAgent userAgent, @ModelAttribute("userAddress") UserAddress userAddress, BindingResult result, Model model)
/*     */   {
/*  79 */     String errMessage = "";
/*  80 */     String successMessage = "";
/*  81 */     userAddress.setUserAccount(userAgent.getAccount());
/*  82 */     userAddress.setOperator(userAgent.getAccount());
/*  83 */     List allUserAddresses = new ArrayList();
/*  84 */     this.userAddressValidator.validate(userAddress, result);
/*  85 */     if (result.hasErrors()) {
/*  86 */       allUserAddresses = this.userAddressService.getAllUserAddresses(userAddress);
/*  87 */       model.addAttribute("allUserAddresses", allUserAddresses);
/*  88 */       return;
/*     */     }
/*  90 */     if (userAddress.getIsDefault() == null)
/*  91 */       userAddress.setIsDefault("N");
/*  92 */     if (null != userAddress.getId()) {
/*  93 */       int number = this.userAddressService.changeUserAddress(userAddress);
/*  94 */       if (number > 0)
/*  95 */         successMessage = "修改成功";
/*     */       else
/*  97 */         errMessage = "修改失败，请重试";
/*     */     }
/*     */     else {
/* 100 */       boolean isSuccess = this.userAddressService.addUserAddress(userAddress);
/* 101 */       if (isSuccess)
/* 102 */         successMessage = "增加成功";
/*     */       else
/* 104 */         errMessage = "增加失败:最多只能有十条地址信息";
/*     */     }
/* 106 */     allUserAddresses = this.userAddressService.getAllUserAddresses(userAddress);
/* 107 */     model.addAttribute("allUserAddresses", allUserAddresses);
/* 108 */     model.addAttribute("errMessage", errMessage);
/* 109 */     model.addAttribute("successMessage", successMessage);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_ADDRESS})
/*     */   @RequestMapping(value={"/user/address/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public String userAddressDelete(@RequestParam("id") Long id)
/*     */   {
/* 124 */     int line = this.userAddressService.deleteUserAddress(id);
/* 125 */     if (line > 0) {
/* 126 */       return "OK";
/*     */     }
/* 128 */     return "error";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/user/address/addressDiv"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void getTestList(UserAgent userAgent, @RequestParam("type") String type, @RequestParam("linkmanAccount") String linkmanAccount, Model model)
/*     */   {
/* 145 */     UserAddress userAddress = new UserAddress();
/* 146 */     if (StringUtil.isEmpty(linkmanAccount))
/* 147 */       userAddress.setUserAccount(userAgent.getAccount());
/*     */     else {
/* 149 */       userAddress.setUserAccount(linkmanAccount);
/*     */     }
/* 151 */     userAddress.setType(type);
/* 152 */     List addressList = this.userAddressService.getAllUserAddresses(userAddress);
/* 153 */     model.addAttribute("addressList", addressList);
/* 154 */     model.addAttribute("type", type);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/user/address/select"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public UserAddress getSelectAddress(@RequestParam("id") Long id, Model model)
/*     */   {
/* 169 */     UserAddress userAddress = new UserAddress();
/* 170 */     userAddress = this.userAddressService.getUserAddressById(id);
/* 171 */     return userAddress;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.user.UserAddressAction
 * JD-Core Version:    0.6.0
 */