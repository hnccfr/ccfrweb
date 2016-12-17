/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;
/*    */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeSubstationService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.util.Assert;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class TradeSubstationAddValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeSubstationService tradeSubstationService;
/*    */ 
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 19 */     Assert.notNull(obj);
/* 20 */     Assert.isInstanceOf(TradeSubstation.class, obj);
/* 21 */     super.validate(obj, err);
/*    */ 
/* 23 */     TradeSubstation tradeSubstation = (TradeSubstation)obj;
/*    */ 
/* 25 */     Long id = tradeSubstation.getId();
/* 26 */     if ((null == id) || (id.longValue() <= 0L)) {
/* 27 */       err.rejectValue("id", null, null, "分中心编号不能为空");
/*    */     }
/*    */ 
/* 36 */     String name = tradeSubstation.getName();
/* 37 */     if (StringUtil.isBlank(name))
/* 38 */       err.rejectValue("name", null, null, "分中心名称不能为空");
/* 39 */     else if (name.length() > 16)
/* 40 */       err.rejectValue("name", null, null, "分中心名称不能");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.TradeSubstationAddValidator
 * JD-Core Version:    0.6.0
 */