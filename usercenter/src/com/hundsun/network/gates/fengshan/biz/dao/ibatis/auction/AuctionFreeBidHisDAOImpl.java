/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidHisDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBidHis;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionFreeBidQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionFreeBidHisDAO")
/*    */ public class AuctionFreeBidHisDAOImpl extends BaseDAO
/*    */   implements AuctionFreeBidHisDAO
/*    */ {
/*    */   public void queryFreeBidHisList(AuctionFreeBidQuery query)
/*    */   {
/* 17 */     paginate(query, "AUCTION_FREE_BID_HIS.queryFreeBidHisListCount", "AUCTION_FREE_BID_HIS.queryFreeBidHisList");
/*    */   }
/*    */ 
/*    */   public void insert(AuctionFreeBidHis record)
/*    */   {
/* 22 */     getSqlMapClientTemplate().insert("AUCTION_FREE_BID_HIS.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionFreeBidHis selectByPrimaryKey(Long id)
/*    */   {
/* 27 */     return (AuctionFreeBidHis)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID_HIS.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int selectFreeBidHisCount(String bidderAccount, String projectCode)
/*    */   {
/* 38 */     AuctionFreeBidQuery query = new AuctionFreeBidQuery();
/* 39 */     query.setBidderAccount(bidderAccount);
/* 40 */     query.setProjectCode(projectCode);
/* 41 */     return ((Integer)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID_HIS.selectFreeBidHisCount", query)).intValue();
/*    */   }
/*    */ 
/*    */   public int selectBidCountByProjectCode(String projectCode)
/*    */   {
/* 50 */     AuctionFreeBidQuery query = new AuctionFreeBidQuery();
/* 51 */     query.setProjectCode(projectCode);
/* 52 */     return ((Integer)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID_HIS.selectBidCountByProjectCode", query)).intValue();
/*    */   }
/*    */ 
/*    */   public AuctionFreeBidHis selectLastBidRecord(String bidderAccount, String projectCode)
/*    */   {
/* 64 */     AuctionFreeBidQuery query = new AuctionFreeBidQuery();
/* 65 */     query.setBidderAccount(bidderAccount);
/* 66 */     query.setProjectCode(projectCode);
/* 67 */     List list = getSqlMapClientTemplate().queryForList("AUCTION_FREE_BID_HIS.selectLastBidRecord", query);
/* 68 */     if ((list != null) && (list.size() > 0)) {
/* 69 */       return (AuctionFreeBidHis)list.get(0);
/*    */     }
/* 71 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction.AuctionFreeBidHisDAOImpl
 * JD-Core Version:    0.6.0
 */