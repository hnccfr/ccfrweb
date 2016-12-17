package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancWarehouse;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancWarehouseCriteria;
import java.util.List;

public abstract interface FinancWarehouseDAO
{
  public abstract int countByExample(FinancWarehouseCriteria paramFinancWarehouseCriteria);

  public abstract int deleteByExample(FinancWarehouseCriteria paramFinancWarehouseCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancWarehouse paramFinancWarehouse);

  public abstract Long insertSelective(FinancWarehouse paramFinancWarehouse);

  public abstract List<FinancWarehouse> selectByExample(FinancWarehouseCriteria paramFinancWarehouseCriteria);

  public abstract FinancWarehouse selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancWarehouse paramFinancWarehouse, FinancWarehouseCriteria paramFinancWarehouseCriteria);

  public abstract int updateByExample(FinancWarehouse paramFinancWarehouse, FinancWarehouseCriteria paramFinancWarehouseCriteria);

  public abstract int updateByPrimaryKeySelective(FinancWarehouse paramFinancWarehouse);

  public abstract int updateByPrimaryKey(FinancWarehouse paramFinancWarehouse);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancWarehouseDAO
 * JD-Core Version:    0.6.0
 */