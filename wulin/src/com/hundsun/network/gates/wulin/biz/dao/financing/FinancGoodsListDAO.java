package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsList;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsListCriteria;
import java.util.List;

public abstract interface FinancGoodsListDAO
{
  public abstract int countByExample(FinancGoodsListCriteria paramFinancGoodsListCriteria);

  public abstract int deleteByExample(FinancGoodsListCriteria paramFinancGoodsListCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancGoodsList paramFinancGoodsList);

  public abstract Long insertSelective(FinancGoodsList paramFinancGoodsList);

  public abstract List<FinancGoodsList> selectByExample(FinancGoodsListCriteria paramFinancGoodsListCriteria);

  public abstract FinancGoodsList selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancGoodsList paramFinancGoodsList, FinancGoodsListCriteria paramFinancGoodsListCriteria);

  public abstract int updateByExample(FinancGoodsList paramFinancGoodsList, FinancGoodsListCriteria paramFinancGoodsListCriteria);

  public abstract int updateByPrimaryKeySelective(FinancGoodsList paramFinancGoodsList);

  public abstract int updateByPrimaryKey(FinancGoodsList paramFinancGoodsList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancGoodsListDAO
 * JD-Core Version:    0.6.0
 */