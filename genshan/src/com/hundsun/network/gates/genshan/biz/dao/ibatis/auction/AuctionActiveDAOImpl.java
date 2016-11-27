/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionActiveDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionActiveDAO")
/*    */ public class AuctionActiveDAOImpl extends BaseDAO
/*    */   implements AuctionActiveDAO
/*    */ {
/*    */   public List<ProjectListing> getAuctionProjectList()
/*    */   {
/* 31 */     Map map = new HashMap();
/* 32 */     map.put("bidStartTime", "bidStartTime");
/*    */ 
/* 34 */     map.put("projectStatus", EnumProjectStatus.TRADE.getValue());
/* 35 */     List codeList = new ArrayList();
/* 36 */     codeList.add(EnumTradingType.BID_ORDER.getValue());
/* 37 */     codeList.add(EnumTradingType.MULIT_BID_ORDER.getValue());
/* 38 */     map.put("codeList", codeList);
/* 39 */     return getSqlMapClientTemplate().queryForList("ProjectListing.selectAuctionToActive", map);
/*    */   }
/*    */ 
/*    */   public List<TradeWishOrder> getAuctionBidderList(Map<String, Object> map)
/*    */   {
/* 54 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.queryAuctionBidder", map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionActiveDAOImpl
 * JD-Core Version:    0.6.0
 */