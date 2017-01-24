package test.com.sales;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sales.service.SalesTrackService;
import com.sales.vo.SalesTypeAmountVo;
import com.sales.vo.SalesTypeBillVo;

public class ServiceTest {
	SalesTrackService salesTrackService=new SalesTrackService();
	public void saveSalesTypeAmtEntityTest(){
		SalesTypeAmountVo amountVo=new SalesTypeAmountVo();
		amountVo.setSalesTypeId(2);
		amountVo.setTotalAmount(new BigDecimal(500+""));
		amountVo.setSaleDate(new Timestamp(new Date().getTime()));
		amountVo.setCreateUser("Test");
		amountVo.setCreateDate(new Timestamp(new Date().getTime()));
		amountVo.setModifiedUser("Test");
		amountVo.setModifiedDate(new Timestamp(new Date().getTime()));
		
		List<SalesTypeBillVo> billVos = getBillVoList();
		
		salesTrackService.createSales(amountVo, billVos, null);
	}
	private List<SalesTypeBillVo>  getBillVoList() {
		List<SalesTypeBillVo> billVos=new ArrayList<>(); 
		SalesTypeBillVo billVo=new SalesTypeBillVo();
		billVo.setBillNo("BLNO200");
		billVo.setAllotedAmount(new BigDecimal("200"));
		billVos.add(billVo);
		
		return billVos;
	}
	public static void main(String[] args) {
		ServiceTest serviceTest=new ServiceTest();
		serviceTest.saveSalesTypeAmtEntityTest();
	}

}
