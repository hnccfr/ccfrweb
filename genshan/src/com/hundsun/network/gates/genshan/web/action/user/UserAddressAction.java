/*    */ package com.hundsun.network.gates.genshan.web.action.user;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAddress;
/*    */ import com.hundsun.network.gates.genshan.biz.service.user.UserAddressService;
/*    */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*    */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class UserAddressAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserAddressService userAddressService;
/*    */ 
/*    */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_ADDRESS_QUERY})
/*    */   @RequestMapping({"/user/address"})
/*    */   public void userAddressView(@ModelAttribute("userAddress") UserAddress userAddress, Model model)
/*    */   {
/* 37 */     List userAddressList = this.userAddressService.getAllUserAddresses(userAddress);
/* 38 */     model.addAttribute("userAddressList", userAddressList);
/* 39 */     model.addAttribute("userAccount", userAddress.getUserAccount());
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/user/addressDiv"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void getAddressDivList(@RequestParam("type") String type, @RequestParam("account") String account, Model model)
/*    */   {
/* 55 */     UserAddress userAddress = new UserAddress();
/* 56 */     userAddress.setUserAccount(account);
/* 57 */     userAddress.setType(type);
/* 58 */     List addressList = this.userAddressService.getAllUserAddresses(userAddress);
/* 59 */     model.addAttribute("addressList", addressList);
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/user/select"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public UserAddress getSelectAddress(@RequestParam("id") Long id, Model model)
/*    */   {
/* 74 */     UserAddress userAddress = new UserAddress();
/* 75 */     userAddress = this.userAddressService.getUserAddressById(id);
/* 76 */     return userAddress;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.user.UserAddressAction
 * JD-Core Version:    0.6.0
 */