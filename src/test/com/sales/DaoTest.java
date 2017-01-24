package test.com.sales;

import java.util.List;

import com.sales.dao.ObjectDao;
import com.sales.dao.QueryDao;

public class DaoTest {
	QueryDao queryDao=new QueryDao();
	ObjectDao objectDao=new ObjectDao(); 
	
	public void testGetConstants(){
		List<?> list= queryDao.getConstants("sales_type");
		
		System.out.println(list);
	}
	

	/*public void testSaveConstants(){
		ConstantsEntity constantsEntity=new ConstantsEntity();
		constantsEntity.setConstantId("test");
		constantsEntity.setConstantType("sales_type");
		constantsEntity.setConstantDesc("testing");
		try {
			objectDao.saveBo(constantsEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args){
		DaoTest daoTest=new DaoTest();
		
		daoTest.testGetConstants();
	}
}
