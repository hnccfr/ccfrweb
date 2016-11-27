/*    */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.dto.FundInOutDetailDTO;
/*    */ 
/*    */ public class FundDetailQuery extends Pagination<FundInOutDetailDTO>
/*    */ {
/*    */   private static final long serialVersionUID = -8085895614564642710L;
/*    */   private String startDate;
/*    */   private String endDate;
/*    */ 
/*    */   public String getStartDate()
/*    */   {
/* 17 */     return this.startDate;
/*    */   }
/*    */   public void setStartDate(String startDate) {
/* 20 */     this.startDate = startDate;
/*    */   }
/*    */   public String getEndDate() {
/* 23 */     return this.endDate;
/*    */   }
/*    */   public void setEndDate(String endDate) {
/* 26 */     this.endDate = endDate;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.FundDetailQuery
 * JD-Core Version:    0.6.0
 */