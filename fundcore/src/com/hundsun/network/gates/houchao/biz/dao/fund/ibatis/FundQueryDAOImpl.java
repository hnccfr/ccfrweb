/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundQueryDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.query.FundInOutDetailQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.dto.FundInOutDetailDTO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("fundQueryDAO")
/*    */ public class FundQueryDAOImpl extends BaseDAO
/*    */   implements FundQueryDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "FundQuery.";
/*    */ 
/*    */   public void queryFundInOut(FundInOutDetailQuery<FundInOutDetailDTO> query)
/*    */   {
/* 33 */     paginate(query, "FundQuery.queryFundInOutDetailCount", "FundQuery.queryFundInOutDetailList");
/*    */   }
/*    */ 
/*    */   public int queryFundInOutTotal(FundInOutDetailQuery<FundInOutDetailDTO> query)
/*    */   {
/* 43 */     return ((Integer)getSqlMapClientTemplate().queryForObject("FundQuery.queryFundInOutDetailCount", query)).intValue();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundQueryDAOImpl
 * JD-Core Version:    0.6.0
 */