package com.sales.service;

import java.util.List;

import com.sales.dao.ObjectDao;
import com.sales.entity.SalestypeAmtEntity;
import com.sales.vo.SalesTypeAmountVo;
import com.sales.vo.SalesTypeBillDetailVo;
import com.sales.vo.SalesTypeBillVo;

public class SalesTrackService {
	ObjectDao objectDao=new ObjectDao();
	
	public String createSales(SalesTypeAmountVo amountVo, List<SalesTypeBillVo> billVoList, List<SalesTypeBillDetailVo> billDetailVo){
		
		SalestypeAmtEntity amtEntity=new SalestypeAmtEntity();
		amtEntity.setSalesTypeId(amountVo.getSalesTypeId());
		amtEntity.setTotalAmount(amountVo.getTotalAmount());
		amtEntity.setSaleDate(amountVo.getCreateDate());
		
		try {
			objectDao.saveBo(amtEntity);
			
			if(billVoList!=null){
				for(SalesTypeBillVo billVo:billVoList){
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}
