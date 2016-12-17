package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoods;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsCriteria;
import java.util.List;

public abstract interface FinancGoodsDAO
{
  public abstract int countByExample(FinancGoodsCriteria paramFinancGoodsCriteria);

  public abstract int deleteByExample(FinancGoodsCriteria paramFinancGoodsCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancGoods paramFinancGoods);

  public abstract Long insertSelective(FinancGoods paramFinancGoods);

  public abstract List<FinancGoods> selectByExampleWithBLOBs(FinancGoodsCriteria paramFinancGoodsCriteria);

  public abstract List<FinancGoods> selectByExampleWithoutBLOBs(FinancGoodsCriteria paramFinancGoodsCriteria);

  public abstract FinancGoods selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancGoods paramFinancGoods, FinancGoodsCriteria paramFinancGoodsCriteria);

  public abstract int updateByExampleWithBLOBs(FinancGoods paramFinancGoods, FinancGoodsCriteria paramFinancGoodsCriteria);

  public abstract int updateByExampleWithoutBLOBs(FinancGoods paramFinancGoods, FinancGoodsCriteria paramFinancGoodsCriteria);

  public abstract int updateByPrimaryKeySelective(FinancGoods paramFinancGoods);

  public abstract int updateByPrimaryKeyWithBLOBs(FinancGoods paramFinancGoods);

  public abstract int updateByPrimaryKeyWithoutBLOBs(FinancGoods paramFinancGoods);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancGoodsDAO
 * JD-Core Version:    0.6.0
 */