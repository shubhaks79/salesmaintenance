package com.sales.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sales.entity.BaseEntity;

public class ObjectDao extends BaseDao {
	public void saveBo(BaseEntity baseBo) throws Exception{
		Session session= hdlr.getSessionFrmHdlr();
		try{
			Transaction transaction=hdlr.getTransaction(session);
			hdlr.save(baseBo,session);
			hdlr.commitTransaction(transaction);
		}catch(Exception e){
			throw e;
		}finally{
			hdlr.closeSessionFrmHdlr(session);
		}
	}
	
	public void delBo(BaseEntity baseBo) throws Exception{
		Session session= hdlr.getSessionFrmHdlr();
		try{
			
			Transaction transaction=hdlr.getTransaction(session);
			hdlr.delete(baseBo,session);
			hdlr.commitTransaction(transaction);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			hdlr.closeSessionFrmHdlr(session);
		}
	}
}
