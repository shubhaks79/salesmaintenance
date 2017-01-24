package com.sales.dao.util;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CallbackException;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sales.entity.BaseEntity;

public final class HibernateHdlr {
	private static Logger logger = Logger.getLogger(HibernateHdlr.class);

	public List<?> search(String hql) {
		List<?> lst = null;
		Session session = HibernateUtil.getSession();

		try {
			lst = session.createQuery(hql).list();
		} catch (Exception he) {
			he.printStackTrace();
			logger.error("HibernateHdlr:search:Could not Search", he);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return lst;
	}
	
	public List<?> searchSql(String sqlQuery) {
		List<?> lst = null;
		Session session = HibernateUtil.getSession();

		try {
			lst = session.createSQLQuery(sqlQuery).setCacheable(true).list();
		} catch (Exception he) {
			logger.error("HibernateHdlr:search:Could not Search", he);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return lst;
	}

	public List<?> paginationSearch(String hql, int startindx, int totCnt) {
		List<?> lst = null;
		Session session = HibernateUtil.getSession();

		try {
			Query qry = session.createQuery(hql).setCacheable(true);
			qry.setFirstResult(startindx);
			qry.setMaxResults(totCnt);
			lst = qry.list();
		} catch (Exception he) {
			logger.error(
					"HibernateHdlr:paginationSearch:Could not search the list objects",
					he);
		} finally {
			HibernateUtil.closeSession(session);
		}
		return lst;
	}
	
	public Transaction getTransaction(Session session){
		Transaction tx = session.beginTransaction();
		tx.begin();
		return tx;
	}

	public void commitTransaction(Transaction tx){
		tx.commit();
	}
	
	public Session getSessionFrmHdlr(){
		return HibernateUtil.getSession();
	}
	

	public void closeSessionFrmHdlr(Session session){
		HibernateUtil.closeSession(session);
	}
	
	public void save(BaseEntity bo,Session session) throws Exception{
		try {

			session.saveOrUpdate(bo);

		} catch (HibernateException he) {
			he.printStackTrace();
				logger.error(
						"HibernateHdlr:save(BaseEntity bo):Could not save object",
						he);
				throw new Exception(he);
		} 

	}

	public List<?> save(List<?> list, Session session) throws Exception {
		try {
			// System.out.println("HibernateDAO:save(List list):In Data Handler calling Hibernate");

			Iterator<?> objIt = list.iterator();
			while (objIt.hasNext()) {
				BaseEntity obj = (BaseEntity) objIt.next();

				session.saveOrUpdate(obj);

			}
			logger.debug("HibernateDAO:save(List list):Saved and returning");
			return list;
		} catch (CallbackException cbe) {
			logger.debug("HibernateDAO:save(List list):Callback Exception  ");
			cbe.printStackTrace();
		} catch (HibernateException he) {
			logger.debug("HibernateDAO:save(List list):Hibernate Exception");
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return null;
	}

	public BaseEntity retrieve(BaseEntity object,int id) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			// System.out.println("HibernateDAO:retrieve(BusinessBase object):Id for rerieval is "
			// + object.getId());
			BaseEntity busBase = (BaseEntity) session.load(object.getClass(),
					id);

			return busBase;
		} catch (HibernateException he) {
			logger.debug("HibernateDAO:retrieve(BusinessBase object):retrieve() Exception"
					+ he);
			throw new Exception(
					"HibernateDAO:retrieve(BusinessBase object):Could not Retrieve object of class "
							+ object.getClass().getName()
							+ " for ID "
							+ id, he);
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public void delete(BaseEntity object, Session session) throws Exception {
		try {
			session.lock(object, LockMode.NONE);
			session.delete(object);

		} catch (HibernateException he) {
			throw new Exception(
					"HibernateDAO:delete(BusinessBase object):Could not Retrieve object of class "
							+ object.getClass().getName() 
							, he);
		} 

	}

	public void delete(List<?> list, Session session) throws Exception {

		try {
			Iterator<?> objIt = list.iterator();
			while (objIt.hasNext()) {
				BaseEntity obj = (BaseEntity) objIt.next();

				// first delete row in relatedlaw_toc for given toc

				session.lock(obj, LockMode.NONE);
				session.delete(obj);
			}

		} catch (HibernateException he) {
			throw new Exception(
					"HibernateDAO:delete(List list):Could not Delete objects of List",
					he);
		} 

	}

}
