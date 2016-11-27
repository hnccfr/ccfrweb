/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemDict;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemDictQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemDictService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class SystemDictAddValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemDictService systemDictService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 22 */     super.validate(obj, errors);
/* 23 */     SystemDict systemDict = (SystemDict)obj;
/*    */ 
/* 25 */     if (StringUtil.isNotBlank(systemDict.getParaCode())) {
/* 26 */       SystemDictQuery query = new SystemDictQuery();
/* 27 */       query.setParaCode(systemDict.getParaCode());
/* 28 */       List list = this.systemDictService.checkRepeat(query);
/* 29 */       if ((list != null) && (list.size() > 0))
/* 30 */         errors.rejectValue("paraCode", "", "已经存在的参数编码！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.SystemDictAddValidator
 * JD-Core Version:    0.6.0
 */