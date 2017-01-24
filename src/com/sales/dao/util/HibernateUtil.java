package com.sales.dao.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public final class HibernateUtil {
	private HibernateUtil() {

	}

	public static Session getSession() {
		DataSourceHibernate getds = DataSourceHibernate.getInstance();
		SessionFactory getFactory = getds.getHibernateSession();
		Session session = getFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		try {
			session.close();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}
}
