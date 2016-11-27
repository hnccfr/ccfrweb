package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancTransferForm;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancTransferFormCriteria;
import java.util.List;

public abstract interface FinancTransferFormDAO
{
  public abstract int countByExample(FinancTransferFormCriteria paramFinancTransferFormCriteria);

  public abstract int deleteByExample(FinancTransferFormCriteria paramFinancTransferFormCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancTransferForm paramFinancTransferForm);

  public abstract Long insertSelective(FinancTransferForm paramFinancTransferForm);

  public abstract List<FinancTransferForm> selectByExample(FinancTransferFormCriteria paramFinancTransferFormCriteria);

  public abstract FinancTransferForm selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancTransferForm paramFinancTransferForm, FinancTransferFormCriteria paramFinancTransferFormCriteria);

  public abstract int updateByExample(FinancTransferForm paramFinancTransferForm, FinancTransferFormCriteria paramFinancTransferFormCriteria);

  public abstract int updateByPrimaryKeySelective(FinancTransferForm paramFinancTransferForm);

  public abstract int updateByPrimaryKey(FinancTransferForm paramFinancTransferForm);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancTransferFormDAO
 * JD-Core Version:    0.6.0
 */