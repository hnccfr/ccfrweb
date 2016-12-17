/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionFreeBidHisDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionFreeBidHis;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.AuctionFreeBidQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionFreeBidHisDAO")
/*    */ public class AuctionFreeBidHisDAOImpl extends BaseDAO
/*    */   implements AuctionFreeBidHisDAO
/*    */ {
/*    */   public void queryFreeBidHisList(AuctionFreeBidQuery query)
/*    */   {
/* 15 */     paginate(query, "AUCTION_FREE_BID_HIS.queryFreeBidHisListCount", "AUCTION_FREE_BID_HIS.queryFreeBidHisList");
/*    */   }
/*    */ 
/*    */   public void insert(AuctionFreeBidHis record)
/*    */   {
/* 20 */     getSqlMapClientTemplate().insert("AUCTION_FREE_BID_HIS.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionFreeBidHis selectByPrimaryKey(Long id)
/*    */   {
/* 25 */     return (AuctionFreeBidHis)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID_HIS.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int selectFreeBidHisCount(String bidderAccount, String projectCode)
/*    */   {
/* 37 */     AuctionFreeBidQuery query = new AuctionFreeBidQuery();
/* 38 */     query.setBidderAccount(bidderAccount);
/* 39 */     query.setProjectCode(projectCode);
/* 40 */     return ((Integer)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID_HIS.selectFreeBidHisCount", query)).intValue();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionFreeBidHisDAOImpl
 * JD-Core Version:    0.6.0
 */